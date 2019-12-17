package com.landon30.crossdemo.test.cross;

import com.alipay.remoting.exception.RemotingException;
import com.landon30.crossdemo.test.net.CrossNetMessage;
import com.landon30.crossdemo.test.proto.Cross;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试的一个匹配服务
 *
 * @author landon30
 */
public enum MatchService {
    INSTANCE;

    private static final Logger log = LogManager.getLogger(MatchService.class);


    /**
     * 跨服玩家A的匹配数据
     */
    private Map<GameplayAMatchGroup, Map<Long, GamePlayerAMatchPlayer>> gamePlayerAMatchPlayerMap = new HashMap<>();

    /**
     * 简单维护的一个远端gs地址，用于双工通讯
     */
    private Map<Integer, String> remoteGSAddrMap = new HashMap<>();

    /**
     * 初始化，执行服务器分组
     */
    public void init() {
        gameplayACrossGroup();
    }

    /**
     * 跨服玩法A的跨服服务器分组
     */
    private void gameplayACrossGroup() {
        // 1，2，3三个服务器为一组
        // 4,5,6三个服务器为一组
        GameplayAMatchGroup groupA = new GameplayAMatchGroup();
        groupA.addMatchServer(1);
        groupA.addMatchServer(2);
        groupA.addMatchServer(3);
        gamePlayerAMatchPlayerMap.put(groupA, new HashMap<>());

        GameplayAMatchGroup groupB = new GameplayAMatchGroup();
        groupB.addMatchServer(4);
        groupB.addMatchServer(5);
        groupB.addMatchServer(6);
        gamePlayerAMatchPlayerMap.put(groupB, new HashMap<>());
    }

    /**
     * 跨服玩家A,根据战力返回匹配的一个玩家
     *
     * @param serverId
     * @param roleId
     * @return
     */
    public GamePlayerAMatchPlayer gameplayAMatch(int serverId, long roleId) {
        for (Map.Entry<GameplayAMatchGroup, Map<Long, GamePlayerAMatchPlayer>> entry : gamePlayerAMatchPlayerMap.entrySet()) {
            if (entry.getKey().isMatch(serverId)) {
                // 在报名的跨服玩家数据中返回一个
                return entry.getValue().values().stream().filter((player) -> player.getRoleId() != roleId).findAny().get();
            }
        }

        return null;
    }

    /**
     * 跨服玩家A玩家报名
     *
     * @param remoteAddr
     * @param player
     */
    public void gameplayASignUp(String remoteAddr, GamePlayerAMatchPlayer player) {
        int serverId = player.getServerId();
        long roleId = player.getRoleId();

        log.debug("MatchService.gameplayASignUp.serverId:{},roleId:{}", serverId, roleId);

        for (Map.Entry<GameplayAMatchGroup, Map<Long, GamePlayerAMatchPlayer>> entry : gamePlayerAMatchPlayerMap.entrySet()) {
            if (entry.getKey().isMatch(serverId)) {
                entry.getValue().put(roleId, player);

                // 临时处理，放到地址列表
                remoteGSAddrMap.put(serverId, remoteAddr);
            }
        }
    }

    /**
     * 执行匹配
     *
     * @param serverId
     * @param sourceRoleId
     * @return
     */
    public CrossNetMessage startMatch(int serverId, long sourceRoleId) {
        log.debug("MatchService.startMatch.serverId:{},roleId:{}", serverId, sourceRoleId);

        // 先得到一个匹配的玩家
        GamePlayerAMatchPlayer matchPlayer = gameplayAMatch(serverId, sourceRoleId);

        // 去匹配玩家对应的server拉取详细信息，双工
        CrossNetMessage matchRequestMsg = new CrossNetMessage(Cross.CrossMsgType.CROSS_PLAYA_PLAYER_DETAIL_VALUE,
                Cross.APlayerMatchMsg.newBuilder().setServerId(matchPlayer.getServerId()).setRoleId(matchPlayer.getRoleId()).build().toByteArray());
        try {
            CrossNetMessage matchPlayerResponseMsg = (CrossNetMessage) MatchServer.getServer().invokeSync(remoteGSAddrMap.get(serverId), matchRequestMsg, 1000);
            return matchPlayerResponseMsg;
        } catch (RemotingException e) {
            log.warn("", e);
        } catch (InterruptedException e) {
            log.warn("", e);
        }

        return null;
    }
}
