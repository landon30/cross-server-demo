package com.landon30.crossdemo.test.net;

import com.alipay.remoting.rpc.RpcServer;

/**
 * 基于sofa-bolt实现的一个测试server
 *
 * @author landon30
 */
public class SimpleServer {
    public static void main(String[] args) throws Exception {
        RpcServer server = new RpcServer(8888);

        SimpleServerHandler serverHandler = new SimpleServerHandler();
        server.registerUserProcessor(serverHandler);

        server.startup();

        System.out.println("simple server startup");
    }
}
