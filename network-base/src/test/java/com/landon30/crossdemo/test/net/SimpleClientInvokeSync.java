package com.landon30.crossdemo.test.net;

import com.alipay.remoting.rpc.RpcClient;
import com.landon30.crossdemo.test.proto.Protocol;

/**
 * simple client invokeSync，最常用的一种方式
 *
 * @author landon30
 */
public class SimpleClientInvokeSync {
    public static void main(String[] args) throws Exception {
        RpcClient client = new RpcClient();
        client.startup();

        String addr = "127.0.0.1:8888";

        // 准备发送数据
        CrossNetMessage requestMsg = new CrossNetMessage(Protocol.ProtocolMsgType.G_CROSS_PLAYER_INFO_VALUE,
                Protocol.PlayerInfoMsg.newBuilder().setName("landon").setAge(30).build().toByteArray());

        // 测试sync同步调用，很实用
        CrossNetMessage responseMsg = (CrossNetMessage) client.invokeSync(addr, requestMsg, 1000);

        // 根据msgType反序列化
        switch (responseMsg.getMsgType()) {
            case Protocol.ProtocolMsgType
                    .G_CROSS_PLAYER_INFO_VALUE:
                System.out.println("SimpleClient.invokeSync.response:" + "G_CROSS_PLAYER_INFO");
                Protocol.PlayerInfoMsg responseDeseMsg = Protocol.PlayerInfoMsg.parseFrom(responseMsg.getBody());
                System.out.println("SimpleClient.invokeSync.response.data:" + responseDeseMsg.getName() + "," + responseDeseMsg.getAge());
                break;
        }
    }
}
