package com.landon30.crossdemo.test.cross;

import java.util.HashSet;

/**
 * 跨服玩法A的匹配分组
 */
public class GameplayAMatchGroup {
    /**
     * 当前组匹配的server集合
     */
    private HashSet<Integer> serverSet = new HashSet<>();

    public GameplayAMatchGroup() {
    }

    public void addMatchServer(int serverId) {
        serverSet.add(serverId);
    }

    public boolean isMatch(int serverId) {
        return serverSet.contains(serverId);
    }
}
