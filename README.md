# 游戏跨服服务器的实现demo
1. 包括游戏服务器、跨服服务器、匹配服务器
2. 使用的技术栈包括sofa-bolt、sofarpc等

## 2019.12.18
1. demo逻辑说明
   - https://github.com/landon30/cross-server-demo
   - 说明
     1. MatchServer启动，初始化RpcServer
        - 使用 Address 方式的双工通信，需要在初始化 RpcServer 时，打开 manageConnection 开关
        - 注册MatchServerHandler
     2. 初始化MatchService
        - 执行玩法A跨服分组，1，2，3为一组跨服
        - 每个跨服分组对应玩法A的所有玩家报名数据
     3. GameServer启动，初始化RpcClient
        - 注册GameServerCrossHandler
        - 初始化部分游戏玩家数据
     4. GameServer模拟玩法A报名
        - 模拟部分玩家报名，同步调用matchserver
        - 数据主要是玩法匹配相关数据，如战力
     5. MatchServerHandler处理'玩法A跨服报名'
        - 将报名数据根据serverId放到所在跨服分组的报名数据中
        - 同时保存serverId和remoteAddr的映射，用于后面双工通讯
        - 返回一个只带消息号的消息，表示跨服报名成功
     6. GameServer模拟玩法A匹配
        - 某玩家发起匹配请求，同步调用matchserver
     7. MatchServerHandler处理'玩法A跨服匹配'
        - 在所在跨服分组中找到战力匹配的玩家
        - 拿到该玩家所在server的remoteAddr，直接在match同步调用，获取该玩家详细数据
     8. GameServerCrossHandler处理‘跨服获取玩家详细信息’
        - 封装玩家详细信息，同步返回match
     9. MatchServerHandler同步返回匹配数据，GameServer同步拿到，准备发起战斗

3. 总结

   1. 建议网络层直接使用sofabolt
   2. server之间内部通讯建议同步调用或者rpc，逻辑处理更方便
   3. server之间通讯定义了通用的CrossNetMessage，根据msgType反序列化具体的数据
      - 和目前gameserver处理逻辑一致
      - TODO 如果觉得这层麻烦，可以直接考虑rpc，直接调用远端服务器的方法
   4. 支持双共
      - 比如match这边可以可以保存serverid和连接信息的映射，match可以直接向gameserver同步调用，方式一样，gameserver只需要注册对应的handler处理即可
   5. 建议结合文档、源代码将一些sofabolt细节和实践再看一下
   6. 网络层解决后，剩下的就是其他包装了，相对较容易
