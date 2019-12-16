package com.landon30.crossdemo.test.net;

import com.alipay.remoting.InvokeCallback;
import com.alipay.remoting.rpc.RpcClient;
import com.landon30.crossdemo.test.proto.Protocol;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * simple client with callback
 *
 * @author landon30
 */
public class SimpleClientInvokeWithCallback {
    public static void main(String[] args) throws Exception {
        RpcClient client = new RpcClient();
        client.startup();

        String addr = "127.0.0.1:8888";

        // 准备发送数据
        CrossNetMessage requestMsg = new CrossNetMessage(Protocol.ProtocolMsgType.G_CROSS_PLAYER_INFO_VALUE,
                Protocol.PlayerInfoMsg.newBuilder().setName("landon").setAge(30).build().toByteArray());

        // 测试callback
        client.invokeWithCallback(addr, requestMsg, new InvokeCallback() {
            public void onResponse(Object result) {
                try {
                    System.out.println("invokeWithCallback.onResponse.thread:" + Thread.currentThread().getName());

                    CrossNetMessage responseMsg = (CrossNetMessage) result;
                    // 根据msgType反序列化
                    switch (responseMsg.getMsgType()) {
                        case Protocol.ProtocolMsgType
                                .G_CROSS_PLAYER_INFO_VALUE:
                            System.out.println("SimpleClient.invokeWithCallback.response:" + "G_CROSS_PLAYER_INFO");
                            Protocol.PlayerInfoMsg responseDeseMsg = Protocol.PlayerInfoMsg.parseFrom(responseMsg.getBody());
                            System.out.println("SimpleClient.invokeWithCallback.response.data:"
                                    + responseDeseMsg.getName() + "," + responseDeseMsg.getAge());
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            public void onException(Throwable e) {
                e.printStackTrace();
            }

            // 回调的线程池，默认是Bolt-default-executor
            public Executor getExecutor() {
                return null;
            }
        }, 1000);


        TimeUnit.SECONDS.sleep(5);
    }
}
