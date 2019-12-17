package com.landon30.crossdemo.test.cross;

import com.alipay.remoting.rpc.RpcServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 测试的一个匹配服务器
 *
 * @author landon30
 */
public class MatchServer {
    private static final Logger log = LogManager.getLogger(MatchServer.class);

    private static RpcServer server;

    public static void main(String[] args) {
        // 注：使用 Address 方式的双工通信，需要在初始化 RpcServer 时，打开 manageConnection 开关
        server = new RpcServer(8888, true);

        MatchServerHandler serverHandler = new MatchServerHandler();
        server.registerUserProcessor(serverHandler);

        server.startup();

        // 初始化match service
        MatchService.INSTANCE.init();

        log.debug("Match server started");
    }

    public static RpcServer getServer() {
        return server;
    }
}
