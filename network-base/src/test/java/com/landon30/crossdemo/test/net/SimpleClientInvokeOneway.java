package com.landon30.crossdemo.test.net;

import com.alipay.remoting.rpc.RpcClient;
import com.landon30.crossdemo.test.proto.Protocol;

import java.util.concurrent.TimeUnit;

/**
 * simple client invoke oneway
 *
 * @author landon30
 */
public class SimpleClientInvokeOneway {
    public static void main(String[] args) throws Exception {
        RpcClient client = new RpcClient();
        client.registerUserProcessor(new SimpleClientHandler());
        client.startup();

        String addr = "127.0.0.1:8888";

        // 准备发送数据
        CrossNetMessage requestMsg = new CrossNetMessage(Protocol.ProtocolMsgType.G_CROSS_PLAYER_INFO_VALUE,
                Protocol.PlayerInfoMsg.newBuilder().setName("landon").setAge(30).build().toByteArray());

        // 测试oneway方式，只发送，注册了一个simple client handler
        // FIXME:经测试，oneway不会有response，即使serverhandler返回了response，注册的client handler也没什么用
        client.oneway(addr, requestMsg);

        TimeUnit.SECONDS.sleep(5);
    }
}
