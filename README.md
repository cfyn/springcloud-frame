# springcloud-frame
#springcloud示例代码
##Frame  -------------------------------------------------------- 项目总包(基础包版本等)
	frame ---------------------------------------------------- 说明文档,项目文档(普通文件夹)
        siwei-common-utils ---------------------------------- 项目公共jar包，公共方法(尽量只添加公用jar包，以免多余功能影响微服务模块)
	siwei-eureka-server ---------------------------------- 注册中心
	siwei-config-server ----------------------------------- 配置文件管理中心
	siwei-user-provider ---------------------------------- 用户服务提供者
	siwei-user-consumer -------------------------------- 用户消费者
	siwei-zuul ----------------------------------------------- 服务网关（负责请求转发和登录权限验证）


##启动顺序  siwei-eureka-server (端口:9000)
		  siwei-config-server (端口:8888)
		  siwei-user-provider (端口:9081  服务提供者端口: 9xxx )
		  siwei-user-consumer (端口:8081 服务消费者端口: 8xxx)
		  siwei-zuul (端口:8080)
##配置文件 全放在 config-server项目下 本地配置
# 框架使用文档

## 简单介绍
    eureka-server为注册中心，只需启动时先启动即可
    siwei-common-utils为工具类项目，在parent项目下的lib目录下有其jar包，可替换到自己的maven仓库中，如果需要改变工具包，需重新打包并替换掉parent项目lib目录下的jar包
    siwei-config-server为其中一个配置中心项目，在注册中心启动之后启动即可
    siwei-server-provider为服务提供方项目，配置依赖于siwei-config-server项目，需在其后启动
    siwei-zuul为网关项目，负责路径分发和登录退出功能，登录成功之后会返回token，前端需带入token
    在生成数据库表时，需在本项目下生成对应的sql文件，更新时需更改sql文件和数据库

## 权限
    权限存储在一张表中，分为菜单权限和功能权限，具体字段可以查看siwei-zuul项目的resources/SQL目录下的sql文件，对应的父id和系统码需存储正确，permission字段为权限控制字段，自定义，可参考已有字段
    权限控制基本和shiro一致，需要在controller层使用注解控制（@RequirePermission和@RequireRole注解），注解中有两个字段，value和logical，value为数组类型，可传入多个，logical为权限判断方式，分为AND和OR，默认为AND，具体可看PermissionAspect文件
    TokenIntecepter为拦截器，用户判断token，不需要token验证的路径，可在此文件的static块中加入即可
	
## 日志
    日志的创建是aop实现，具体可以看LogAspect文件，会对于service层进行切面，参数中只有继承了BaseEntity的参数才会被记录，对于需要特殊操作的接口，需在控制层转换
    对于继承BaseEntity的实体类，在其字段上需要使用@ApiModel和@ApiModelProperty注解，标明实体类和各字段的意义

## 文档
    文档使用swagger框架，新的项目复制此文件并修改扫描包路径即可，需要注意在此配置文件中，上线时需要将PathSelectors.any()改为PathSelectors.none()
    文档生成的访问路径，由于token验证的问题，需要在拦截器中将路径配置到static块中，可参考已有拦截器文件
    对于swagger框架的使用，可自行上网搜索
