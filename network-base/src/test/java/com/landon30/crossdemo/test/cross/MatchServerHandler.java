package com.landon30.crossdemo.test.cross;

import com.alipay.remoting.BizContext;
import com.alipay.remoting.rpc.protocol.SyncUserProcessor;
import com.landon30.crossdemo.test.net.CrossNetMessage;
import com.landon30.crossdemo.test.proto.Cross;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * match server handler
 *
 * @author landon30
 */
public class MatchServerHandler extends SyncUserProcessor<CrossNetMessage> {
    private static final Logger log = LogManager.getLogger(MatchServerHandler.class);

    public Object handleRequest(BizContext bizCtx, CrossNetMessage request) throws Exception {
        int msgType = request.getMsgType();
        byte[] bytes = request.getBody();

        log.debug("MatchServerHandler.handleRequest.msgType:{}", Cross.CrossMsgType.forNumber(msgType));

        // 根据type确定反序列化数据
        switch (msgType) {
            case Cross.CrossMsgType
                    .G_CROSS_PLAYA_SIGN_UP_VALUE:
                Cross.APlayerMsg playAPlayerMsg = Cross.APlayerMsg.parseFrom(bytes);
                // 处理跨服报名
                MatchService.INSTANCE.gameplayASignUp(bizCtx.getRemoteAddress(), new GamePlayerAMatchPlayer(playAPlayerMsg.getServerId(),
                        playAPlayerMsg.getRoleId(), playAPlayerMsg.getFight()));
                return new CrossNetMessage(Cross.CrossMsgType.G_CROSS_PLAYA_SIGN_UP_VALUE);

            case Cross.CrossMsgType.G_CROSS_PLAYA_MATCH_VALUE:
                Cross.APlayerMatchMsg matchMsg = Cross.APlayerMatchMsg.parseFrom(bytes);
                return MatchService.INSTANCE.startMatch(matchMsg.getServerId(), matchMsg.getRoleId());
        }

        return null;
    }

    @Override
    public String interest() {
        return CrossNetMessage.class.getName();
    }
}
