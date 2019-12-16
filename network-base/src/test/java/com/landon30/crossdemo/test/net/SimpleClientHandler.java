package com.landon30.crossdemo.test.net;

import com.alipay.remoting.BizContext;
import com.alipay.remoting.rpc.protocol.SyncUserProcessor;
import com.landon30.crossdemo.test.proto.Protocol;

/**
 * simple client handler
 *
 * @author landon30
 */
public class SimpleClientHandler extends SyncUserProcessor<CrossNetMessage> {

    public Object handleRequest(BizContext bizCtx, CrossNetMessage request) throws Exception {
        System.out.println("SimpleClientHandler.handleRequest,thread:" + Thread.currentThread().getName());
        int msgType = request.getMsgType();

        // 测试oneway方式调用后的调用
        switch (msgType) {
            case Protocol.ProtocolMsgType
                    .G_CROSS_PLAYER_INFO_VALUE:
                // 模拟处理消息
                Protocol.PlayerInfoMsg desePlayerInfoMsg = Protocol.PlayerInfoMsg.parseFrom(request.getBody());
                System.out.println("SimpleClientHandler.handleRequest.PlayerInfoMsg.dese:"
                        + desePlayerInfoMsg.getName() + "," + desePlayerInfoMsg.getAge());
                System.out.println("SimpleClientHandler.handleRequest.handle:G_CROSS_PLAYER_INFO");
        }

        // TODO 是否会有问题
        return null;
    }

    @Override
    public String interest() {
        return CrossNetMessage.class.getName();
    }
}
