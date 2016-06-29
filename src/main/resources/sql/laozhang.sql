/*
Navicat MySQL Data Transfer

Source Server         : kspt
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : laozhang

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2016-06-29 19:49:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_nav
-- ----------------------------
DROP TABLE IF EXISTS `sys_nav`;
CREATE TABLE `sys_nav` (
  `nav_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(128) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(1024) DEFAULT NULL COMMENT '菜单地址',
  `url_target` varchar(32) DEFAULT NULL COMMENT '链接打开位置',
  `icon_url` varchar(1024) DEFAULT NULL COMMENT '菜单图标',
  `sort` smallint(3) DEFAULT NULL COMMENT '排序',
  `p_id` int(10) DEFAULT NULL COMMENT '上级ID',
  `status` smallint(2) DEFAULT NULL COMMENT '状态',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'UUID',
  `level` smallint(2) DEFAULT NULL COMMENT '菜单级别',
  `is_show` smallint(2) DEFAULT NULL COMMENT '是否显示',
  PRIMARY KEY (`nav_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='系统菜单';

-- ----------------------------
-- Records of sys_nav
-- ----------------------------
INSERT INTO `sys_nav` VALUES ('16', '用户信息', '/sunarvr/console/sys_user/list', '1', null, '1', '0', '1', 'a621322fe88b49afaa91835f421a193b', '1', '1');
INSERT INTO `sys_nav` VALUES ('18', '系统账户', '/sunarvr/console/sys_user/list', '1', null, '1', '16', '1', '1ac0c79d7c3d4ab185fb23178e99970f', '2', '1');
INSERT INTO `sys_nav` VALUES ('20', '试衣统计', '/sunarvr/console/log_fitting/list', '1', null, '1', '8', '1', '0c33659f76704e609a1ee455d4fe3283', '2', '1');
INSERT INTO `sys_nav` VALUES ('23', '用户角色', '/sunarvr/console/sys_role/list', '1', null, '1', '16', '1', 'e77c92c7a5824e08a17b47cec09f3e5a', '2', '1');

-- ----------------------------
-- Table structure for sys_nav_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_nav_role`;
CREATE TABLE `sys_nav_role` (
  `snr_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `nav_id` int(10) DEFAULT NULL COMMENT '菜单ID',
  `role_id` int(10) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`snr_id`),
  KEY `FK_Reference_18` (`nav_id`),
  KEY `FK_Reference_19` (`role_id`),
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`nav_id`) REFERENCES `sys_nav` (`nav_id`),
  CONSTRAINT `FK_Reference_19` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COMMENT='角色菜单权限';

-- ----------------------------
-- Records of sys_nav_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `role_name` varchar(128) DEFAULT NULL COMMENT '角色名',
  `status` smallint(2) DEFAULT NULL COMMENT '状态',
  `pid` int(10) DEFAULT NULL COMMENT '上级角色ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统角色，开发者平台、后台管理统一维护';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系统管理员', '1', '0', '2016-03-10 16:27:48');
INSERT INTO `sys_role` VALUES ('2', '数据管理员', '1', '0', '2016-03-11 09:50:28');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `su_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '管理ID',
  `user_name` varchar(128) DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(128) DEFAULT NULL COMMENT '昵称',
  `user_password` varchar(128) DEFAULT NULL COMMENT '密码',
  `user_pic` varchar(1024) DEFAULT NULL COMMENT '头像',
  `verify_email` smallint(2) DEFAULT NULL COMMENT '邮箱是否验证',
  `phone` varchar(16) DEFAULT NULL COMMENT '手机号',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `create_user_id` int(10) DEFAULT NULL COMMENT '创建人ID',
  `update_user_id` int(10) DEFAULT NULL COMMENT '最后更新人ID',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'UUID',
  `company_uuid` varchar(64) DEFAULT NULL COMMENT '企业UUID',
  `user_type` smallint(1) DEFAULT NULL COMMENT '账户类型1企业,2个人',
  `is_auth` smallint(2) DEFAULT NULL COMMENT '是否已认证',
  `status` smallint(2) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`su_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='系统管理用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '管理员', '张钦', 'e10adc3949ba59abbe56e057f20f883e', 'http://arvrdata.image.alimmdn.com/img/1464258652550uyahsy.jpg', null, 'admin', '492297036@qq.com', null, null, null, null, null, null, '1', null, '1');
INSERT INTO `sys_user` VALUES ('2', '张钦', null, 'e10adc3949ba59abbe56e057f20f883e', 'http://arvrdata.image.alimmdn.com/yilove/img/1464946051186wcn14m.jpg', null, '1', '1', '2016-05-19 14:56:57', '2016-05-19 14:56:57', null, null, 'e5ce607a759947149ea5234eb311a9a5', null, null, null, '1');
INSERT INTO `sys_user` VALUES ('3', '李四', null, 'e10adc3949ba59abbe56e057f20f883e', 'http://arvrdata.image.alimmdn.com/img/1464258641317slo564.jpg', null, 'lisi', '1', '2016-05-26 18:26:14', '2016-05-26 18:26:14', null, null, 'd84484604055407ebdf2d3215d1989f3', null, null, null, '1');
INSERT INTO `sys_user` VALUES ('4', '王五', null, 'e10adc3949ba59abbe56e057f20f883e', 'http://arvrdata.image.alimmdn.com/yilove/img/1464946038109gnxa3n.jpg', null, 'wangwu', '1', '2016-05-26 18:34:15', '2016-05-26 18:34:15', null, null, '97148f67fd534cbfaf2272e35b0ce1f2', null, null, null, '1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `snr_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `su_id` int(10) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(10) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`snr_id`),
  KEY `FK_Reference_16` (`su_id`),
  KEY `FK_Reference_17` (`role_id`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`su_id`) REFERENCES `sys_user` (`su_id`),
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='用户角色管理';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('15', '4', '2');
INSERT INTO `sys_user_role` VALUES ('16', '3', '2');
INSERT INTO `sys_user_role` VALUES ('17', '2', '2');
INSERT INTO `sys_user_role` VALUES ('18', '1', '1');
INSERT INTO `sys_user_role` VALUES ('19', '1', '2');
