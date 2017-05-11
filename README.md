# MyService
基于Java8和SpringBoot自己构建的一个Restful API服务框架，便于以后的项目使用

### 目前已包含的特性

* Controller中返回对象即返回JSON
* 基于Redis共享session
* 基于Redis的查询缓存
* 定时刷新的微信公众平台AccessToken和JSAPITicket
* Mybatis操作MySQL数据库（初步实现）【加入PageHelper插件，tk.mapper工具，阿里druid连接池】
* pom中使用starter简化pom内容

### TODO List
* MongoDB数据库连接
* aspect记录方法名和类名
* (业务相关)七牛云服务
* (业务相关)阿里大鱼
* *作为API服务的OAUTH认证