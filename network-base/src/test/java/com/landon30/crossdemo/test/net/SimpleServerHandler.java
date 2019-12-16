package com.landon30.crossdemo.test.net;

import com.alipay.remoting.BizContext;
import com.alipay.remoting.rpc.protocol.SyncUserProcessor;
import com.landon30.crossdemo.test.proto.Protocol;

/**
 * simple server handler
 *
 * @author landon30
 */
public class SimpleServerHandler extends SyncUserProcessor<CrossNetMessage> {

    public Object handleRequest(BizContext bizCtx, CrossNetMessage request) throws Exception {
        System.out.println("SimpleServerHandler.handleRequest,thread:" + Thread.currentThread().getName());
        int msgType = request.getMsgType();

        // 这里先做一个简单的判断，根据type确定反序列化数据
        switch (msgType) {
            case Protocol.ProtocolMsgType
                    .G_CROSS_PLAYER_INFO_VALUE:
                // 模拟处理消息
                Protocol.PlayerInfoMsg desePlayerInfoMsg = Protocol.PlayerInfoMsg.parseFrom(request.getBody());
                System.out.println("SimpleServerHandler.handleRequest.PlayerInfoMsg.dese:"
                        + desePlayerInfoMsg.getName() + "," + desePlayerInfoMsg.getAge());
                System.out.println("SimpleServerHandler.handleRequest.handle:G_CROSS_PLAYER_INFO");

                // 模拟返回消息
                Protocol.PlayerInfoMsg.Builder sendMsgBuilder = Protocol.PlayerInfoMsg.newBuilder().setName("mavs").setAge(28);
                return new CrossNetMessage(Protocol.ProtocolMsgType.G_CROSS_PLAYER_INFO_VALUE, sendMsgBuilder.build().toByteArray());
        }

        return null;
    }

    @Override
    public String interest() {
        return CrossNetMessage.class.getName();
    }
}
