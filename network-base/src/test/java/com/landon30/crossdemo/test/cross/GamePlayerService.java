package com.landon30.crossdemo.test.cross;

import com.alipay.remoting.exception.RemotingException;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.landon30.crossdemo.test.net.CrossNetMessage;
import com.landon30.crossdemo.test.proto.Cross;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * 游戏服务器的玩家服务
 */
public enum GamePlayerService {
    INSTANCE;

    private static final Logger log = LogManager.getLogger(GamePlayerService.class);

    private Map<Long, GamePlayer> playerMap = new HashMap<>();

    public int getServerId() {
        return Integer.parseInt(System.getProperty("server.id"));
    }

    // 生成几个player
    public void init() {
        int serverId = getServerId();

        // 简单区分一下不同区服的roleid
        for (int i = 1; i <= 10; i++) {
            long roleId = serverId * 100 + i;
            GamePlayer player = new GamePlayer(roleId, ThreadLocalRandom.current().nextInt(10000));
            playerMap.put(roleId, player);
        }
    }

    /**
     * 用于跨服获取玩家详细信息
     *
     * @param roleId
     * @return
     */
    public CrossNetMessage getPlayerDetail(long roleId) {
        GamePlayer player = playerMap.get(roleId);
        if (player == null) {
            return new CrossNetMessage(Cross.CrossMsgType.CROSS_PLAYA_PLAYER_DETAIL_VALUE);
        }

        Cross.APlayerDetailMsg.Builder builder = Cross.APlayerDetailMsg.newBuilder();
        builder.setFight(player.getFight()).setRoleId(roleId).setServerId(getServerId()).
                setRoleDetail(ByteString.copyFrom(player.getDetail()));
        return new CrossNetMessage(Cross.CrossMsgType.CROSS_PLAYA_PLAYER_DETAIL_VALUE, builder.build().toByteArray());
    }

    /**
     * 构建跨服报名的消息
     *
     * @param player
     * @return
     */
    public CrossNetMessage buildPlayASignup(GamePlayer player) {
        Cross.APlayerMsg msg = Cross.APlayerMsg.newBuilder().setServerId(getServerId()).setRoleId(player.getRoleId())
                .setFight(player.getFight()).build();
        CrossNetMessage netMsg = new CrossNetMessage(Cross.CrossMsgType.G_CROSS_PLAYA_SIGN_UP_VALUE, msg.toByteArray());
        return netMsg;
    }

    /**
     * 模拟报名
     */
    public void mockGamePlayASignup() {
        int serverId = getServerId();
        for (int i = 1; i <= 3; i++) {
            long roleId = serverId * 100 + i;
            GamePlayer player = playerMap.get(roleId);

            CrossNetMessage netMsg = buildPlayASignup(player);

            try {
                // 向match报名
                log.debug("player:{} prepare sign up", roleId);
                CrossNetMessage responseMsg = (CrossNetMessage) GameServer.getMatchRpcClient().invokeSync(GameServer.MATCH_ADDR, netMsg, 1000);
                log.debug("player:{} sign up with response:{}", roleId, Cross.CrossMsgType.forNumber(responseMsg.getMsgType()));
            } catch (RemotingException e) {
                log.warn("", e);
            } catch (InterruptedException e) {
                log.warn("", e);
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                log.warn("", e);
            }
        }
    }

    /**
     * 构建跨服匹配的消息
     *
     * @param roleId
     * @return
     */
    public CrossNetMessage buildPlayAMatch(long roleId) {
        Cross.APlayerMatchMsg msg = Cross.APlayerMatchMsg.newBuilder().setServerId(getServerId()).setRoleId(roleId).build();
        CrossNetMessage netMsg = new CrossNetMessage(Cross.CrossMsgType.G_CROSS_PLAYA_MATCH_VALUE, msg.toByteArray());
        return netMsg;
    }

    // 发起匹配消息
    public void mock2Match() {
        long roleId = getServerId() * 100 + 1;
        CrossNetMessage requestMsg = buildPlayAMatch(roleId);

        try {
            // 向match发起匹配
            log.debug("player:{} prepare match", roleId);
            CrossNetMessage responseMsg = (CrossNetMessage) GameServer.getMatchRpcClient().invokeSync(GameServer.MATCH_ADDR,
                    requestMsg, 1000);
            log.debug("player:{} match with response:{}", roleId, Cross.CrossMsgType.forNumber(responseMsg.getMsgType()));
            onMatchSuccess(roleId, responseMsg);
        } catch (RemotingException e) {
            log.warn("", e);
        } catch (InterruptedException e) {
            log.warn("", e);
        }
    }

    // 匹配成功
    private void onMatchSuccess(long sourceRoleId, CrossNetMessage response) {
        try {
            GamePlayer sourcePlayer = playerMap.get(sourceRoleId);
            Cross.APlayerDetailMsg detailMsg = Cross.APlayerDetailMsg.parseFrom(response.getBody());
            log.debug("match success,sourceServerId:{},sourceRoleId:{},sourceFight:{},sourceDetail:{},targetRoleId:{},targetSourceId:{},targetFight:{},tagetDetail:{}",
                    sourceRoleId, getServerId(), sourcePlayer.getFight(), sourcePlayer.getDetail().length, detailMsg.getRoleId(), detailMsg.getServerId(), detailMsg.getFight(), detailMsg.getRoleDetail().toByteArray().length);

            log.debug("match success,prepare fight,{}_{} vs {}_{}", sourceRoleId, getServerId(), detailMsg.getRoleId(), detailMsg.getServerId());
        } catch (InvalidProtocolBufferException e) {
            log.warn("", e);
        }
    }
}
