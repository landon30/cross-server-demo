package com.landon30.crossdemo.test.cross;

import com.alipay.remoting.BizContext;
import com.alipay.remoting.rpc.protocol.SyncUserProcessor;
import com.landon30.crossdemo.test.net.CrossNetMessage;
import com.landon30.crossdemo.test.proto.Cross;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * gameserver用于和内部服务器通讯的handler
 *
 * @author landon30
 */
public class GameServerCrossHandler extends SyncUserProcessor<CrossNetMessage> {
    private static final Logger log = LogManager.getLogger(GameServerCrossHandler.class);

    public Object handleRequest(BizContext bizCtx, CrossNetMessage request) throws Exception {
        int msgType = request.getMsgType();
        byte[] bytes = request.getBody();

        log.debug("GameServerCrossHandler.handleRequest.msgType:{}", Cross.CrossMsgType.forNumber(msgType));

        // 根据type确定反序列化数据
        switch (msgType) {
            // 目前初步设计是获取匹配玩家详细信息的时候是通过match向gs同步拉取
            // 此时是双工
            case Cross.CrossMsgType
                    .CROSS_PLAYA_PLAYER_DETAIL_VALUE:
                Cross.APlayerMatchMsg matchMsg = Cross.APlayerMatchMsg.parseFrom(bytes);
                long matchRoleId = matchMsg.getRoleId();
                return GamePlayerService.INSTANCE.getPlayerDetail(matchRoleId);
        }

        return null;
    }

    @Override
    public String interest() {
        return CrossNetMessage.class.getName();
    }
}
