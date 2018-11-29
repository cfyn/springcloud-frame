# springcloud-frame
springcloud示例代码
Frame  -------------------------------------------------------- 项目总包(基础包版本等)
	frame ---------------------------------------------------- 说明文档,项目文档(普通文件夹)
siwei-common-utils ---------------------------------- 项目公共jar包，公共方法(尽量只添加公用jar包，以免多余功能影响微服务模块)
	siwei-eureka-server ---------------------------------- 注册中心
	siwei-config-server ----------------------------------- 配置文件管理中心
	siwei-user-provider ---------------------------------- 用户服务提供者
	siwei-user-consumer -------------------------------- 用户消费者
	siwei-zuul ----------------------------------------------- 服务网关（负责请求转发和登录权限验证）


启动顺序  siwei-eureka-server (端口:9000)
		  siwei-config-server (端口:8888)
		  siwei-user-provider (端口:9081  服务提供者端口: 9xxx )
		  siwei-user-consumer (端口:8081 服务消费者端口: 8xxx)
		  siwei-zuul (端口:8080)
配置文件 全放在 config-server项目下 本地配置
