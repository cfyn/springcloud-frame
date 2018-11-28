DROP database IF EXISTS siwei_base;
CREATE database siwei_base DEFAULT CHARACTER SET 'utf8';
use siwei_base;

DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `permission_type` int(1) NOT NULL COMMENT '权限类型(1.菜单权限; 2.功能权限)',
  `url` varchar(200) DEFAULT NULL COMMENT '资源路径',
  `permission` varchar(200) DEFAULT NULL COMMENT '权限(如：astack:car:create)',
  `parent_menu_id` int(11) DEFAULT NULL COMMENT '父菜单权限id',
  `describition` varchar(500) DEFAULT NULL COMMENT '描述',
  `belong_system` int(1) NOT NULL COMMENT '所属系统码',
  
  `enabled` boolean DEFAULT TRUE COMMENT '是否启用(默认启用)',
  `deleted` boolean DEFAULT FALSE COMMENT '是否已删除(默认不删除)',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `last_modified_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role` varchar(500) DEFAULT NULL COMMENT '角色标识(如:admin、manager)',
  `belong_system` int(1) NOT NULL COMMENT '所属系统码',
  
  `enabled` boolean DEFAULT TRUE COMMENT '是否启用(默认启用)',
  `deleted` boolean DEFAULT FALSE COMMENT '是否已删除(默认不删除)',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `last_modified_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系表';

DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `permission_id` int(11) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与权限对应关系';

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `mobile` varchar(20) NOT NULL unique COMMENT '手机号',
  `sex` int(1) DEFAULT '1' COMMENT '用户性别(1:男  2:女)',
  `head_img` varchar(100) DEFAULT NULL COMMENT '用户头像地址',
  `province` varchar(10) DEFAULT NULL COMMENT '用户所在省',
  `city` varchar(10) DEFAULT NULL COMMENT '用户所在市',
  `county` varchar(10) DEFAULT NULL COMMENT '用户所在区',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `astack_admin_system` boolean DEFAULT FALSE COMMENT 'A栈后台',
  `astack_agent_system` boolean DEFAULT FALSE COMMENT 'A栈APP',
  `astack_webapp_system` boolean DEFAULT FALSE COMMENT 'A栈WebApp',
  `astack_statistical_system` boolean DEFAULT FALSE COMMENT 'A栈统计系统',
  `life_insurance_system` boolean DEFAULT FALSE COMMENT '寿险',
  `dafeng_statistical_system` boolean DEFAULT FALSE COMMENT '大蜂统计系统',
  `astack_agent_small_program_system` boolean DEFAULT FALSE COMMENT 'A栈代理人小程序',
  `astack_toc_small_program_system` boolean DEFAULT FALSE COMMENT 'A栈c端小程序',
  `spare_system_code1` boolean DEFAULT FALSE COMMENT '备用系统码',
  `spare_system_code2` boolean DEFAULT FALSE COMMENT '备用系统码',
  
  `enabled` boolean DEFAULT TRUE COMMENT '是否启用(默认启用)',
  `deleted` boolean DEFAULT FALSE COMMENT '是否已删除(默认不删除)',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `last_modified_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identity_type` int(5) NOT NULL COMMENT '登录类型',
  `identifier` varchar(100) NOT NULL COMMENT '第三方应用唯一标识',
  `credential` varchar(255) NOT NULL COMMENT '密码凭证',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  
  `enabled` boolean DEFAULT TRUE COMMENT '是否启用(默认启用)',
  `deleted` boolean DEFAULT FALSE COMMENT '是否已删除(默认不删除)',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `last_modified_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登录信息表';

DROP TABLE IF EXISTS `user_log`;
CREATE TABLE `user_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(50) DEFAULT null COMMENT '用户ip',
  `operation` varchar(10) DEFAULT null COMMENT '操作',
  `entity_id` int(11) DEFAULT null COMMENT '操作实体id',
  `log` varchar(1000) DEFAULT null COMMENT '日志信息',
  `change_json` varchar(2000) DEFAULT null COMMENT '此次变化的json字符串',
  `operator_id` int(11) DEFAULT null COMMENT '操作人id',
  `table_name` varchar(50) DEFAULT null COMMENT '日志表对应的数据库表名',
  
  `enabled` boolean DEFAULT TRUE COMMENT '是否启用(默认启用)',
  `deleted` boolean DEFAULT FALSE COMMENT '是否已删除(默认不删除)',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `last_modified_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户日志表';

DROP TABLE IF EXISTS `user_login_log`;
CREATE TABLE `user_login_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(50) DEFAULT null COMMENT '用户ip',
  `operation` varchar(10) DEFAULT null COMMENT '操作',
  `entity_id` int(11) DEFAULT null COMMENT '操作实体id',
  `log` varchar(1000) DEFAULT null COMMENT '日志信息',
  `change_json` varchar(2000) DEFAULT null COMMENT '此次变化的json字符串',
  `operator_id` int(11) DEFAULT null COMMENT '操作人id',
  `table_name` varchar(50) DEFAULT null COMMENT '日志表对应的数据库表名',
  
  `enabled` boolean DEFAULT TRUE COMMENT '是否启用(默认启用)',
  `deleted` boolean DEFAULT FALSE COMMENT '是否已删除(默认不删除)',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `last_modified_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登录信息日志表';

DROP TABLE IF EXISTS `role_log`;
CREATE TABLE `role_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(50) DEFAULT null COMMENT '用户ip',
  `operation` varchar(10) DEFAULT null COMMENT '操作',
  `entity_id` int(11) DEFAULT null COMMENT '操作实体id',
  `log` varchar(1000) DEFAULT null COMMENT '日志信息',
  `change_json` varchar(2000) DEFAULT null COMMENT '此次变化的json字符串',
  `operator_id` int(11) DEFAULT null COMMENT '操作人id',
  `table_name` varchar(50) DEFAULT null COMMENT '日志表对应的数据库表名',
  
  `enabled` boolean DEFAULT TRUE COMMENT '是否启用(默认启用)',
  `deleted` boolean DEFAULT FALSE COMMENT '是否已删除(默认不删除)',
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `last_modified_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色日志表';