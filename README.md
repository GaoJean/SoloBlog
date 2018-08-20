# SoloBlog
### 基于SpringBoot的个人博客，采用微服务的形式


### 1. 技术预演：

- 后端：
    - 开发工具：idea
    - 核心框架：SpringBoot
    - MVC 框架：Spring MVC
    - 打包工具：Maven
    - ORM 框架：MyBatis
    - 发版工具：Jenkins
    - 代码仓库：Git
    - 配置文件中心：Matrix
    - RESTful接口文档框架：Swagger
    - 缓存中间件：Redis
    - 编译辅助插件：Lombok
    - 数据库：MySQL
    - JDK：1.8


- 前端：
    - 技术


### 2. 工程架构：
以RESTful风格的接口与客户端通信（Web）
- soloblog
<br>父工程，主要为子工程导入需要的jar包
- soloblog-common
<br>模型常量，为工程提供常量类，工具类
- soloblog-dao
<br>持久化层，实现数据库存取，提供DB数据
- soloblog-service
<br>服务层，实现业务逻辑，事务封装
- soloblog-web
<br>控制器层，处理HTTP请求，与客户端进行通信，数据交换

