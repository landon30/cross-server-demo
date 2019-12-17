package com.landon30.crossdemo.test.cross;

import com.alipay.remoting.rpc.RpcClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * 游戏服务器
 */
public class GameServer {
    private static final Logger log = LogManager.getLogger(GameServer.class);

    public static final String MATCH_ADDR = "127.0.0.1:8888";

    // 和match通讯的client
    private static RpcClient matchRpcClient;

    public static void main(String[] args) throws Exception {
        matchRpcClient = new RpcClient();
        matchRpcClient.registerUserProcessor(new GameServerCrossHandler());
        matchRpcClient.startup();

        // 模拟跨服玩法A报名
        GamePlayerService.INSTANCE.init();
        GamePlayerService.INSTANCE.mockGamePlayASignup();

        // 模拟玩法A跨服匹配
        GamePlayerService.INSTANCE.mock2Match();


        // FIXME 发完数据进程就结束了
        TimeUnit.HOURS.sleep(1);
    }

    public static RpcClient getMatchRpcClient() {
        return matchRpcClient;
    }
}
