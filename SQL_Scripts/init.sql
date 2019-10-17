CREATE DATABASE IF NOT EXISTS  `pot_gold_db`;
use pot_gold_db;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userName` varchar(32) DEFAULT NULL COMMENT '用户名',
  `passWord` varchar(32) DEFAULT NULL COMMENT '密码',
  `user_sex` varchar(32) DEFAULT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8MB4

-- ----------------------------
DROP TABLE
IF EXISTS `t_gold_task`;
CREATE TABLE `t_gold_task` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `step` INT NOT NULL DEFAULT 0 COMMENT '任务进行到的步骤',
  `step_desc` VARCHAR(20) NULL DEFAULT '' COMMENT '步骤描述',
  `file_origin` VARCHAR(200) NULL DEFAULT '' COMMENT '任务原始文件夹',
  `file_output` VARCHAR(200) NULL DEFAULT '' COMMENT '任务输出文件夹',
  `file_record` VARCHAR(200) NULL DEFAULT '' COMMENT '任务执行节点记录',
  `exception` VARCHAR(200) NULL DEFAULT '' COMMENT '异常停止信息',
  `warning` TEXT  COMMENT '警告信息',
  `converted` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '当前转化到的页数',
  `current` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '当前识别到的页数',
  `total` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '总页数',
  `deleted` TINYINT NOT NULL DEFAULT 0 COMMENT '删除状态 0:未删除 1:已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_by` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='乐高页面表';
