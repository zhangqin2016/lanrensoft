/*
Navicat MySQL Data Transfer

Source Server         : benji
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : laozhang

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2016-12-23 18:04:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for app_info
-- ----------------------------
DROP TABLE IF EXISTS `app_info`;
CREATE TABLE `app_info` (
  `app_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `app_key` varchar(128) DEFAULT NULL COMMENT 'key',
  `app_secret` varchar(128) DEFAULT NULL COMMENT '密钥',
  `app_remark` varchar(1024) DEFAULT NULL COMMENT '应用描述',
  `app_name` varchar(128) DEFAULT NULL COMMENT '应用名称',
  `app_type` varchar(128) DEFAULT NULL COMMENT '应用类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` smallint(2) DEFAULT NULL COMMENT '状态',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'UUID',
  PRIMARY KEY (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接入应用';

-- ----------------------------
-- Records of app_info
-- ----------------------------

-- ----------------------------
-- Table structure for app_token
-- ----------------------------
DROP TABLE IF EXISTS `app_token`;
CREATE TABLE `app_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `token` varchar(128) DEFAULT NULL COMMENT 'token值',
  `openid` varchar(128) DEFAULT NULL COMMENT 'openid',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `expires_time` datetime DEFAULT NULL COMMENT '失效时间',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'UUID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Token记录';

-- ----------------------------
-- Records of app_token
-- ----------------------------

-- ----------------------------
-- Table structure for sys_nav
-- ----------------------------
DROP TABLE IF EXISTS `sys_nav`;
CREATE TABLE `sys_nav` (
  `nav_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(128) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(1024) DEFAULT NULL COMMENT '菜单地址',
  `url_target` varchar(32) DEFAULT NULL COMMENT '链接打开位置',
  `icon_url` varchar(1024) DEFAULT NULL COMMENT '菜单图标',
  `sort` smallint(3) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '上级ID',
  `status` smallint(2) DEFAULT NULL COMMENT '状态_radio_1:可用|0:不可用',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'UUID',
  `levels` smallint(2) DEFAULT NULL COMMENT '菜单级别',
  `type` smallint(1) DEFAULT NULL COMMENT '类型_radio_0:按钮|1:菜单',
  PRIMARY KEY (`nav_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='系统菜单';

-- ----------------------------
-- Records of sys_nav
-- ----------------------------
INSERT INTO `sys_nav` VALUES ('16', '用户信息', '/console/sys_user/list', '1', 'glyphicon glyphicon-asterisk', '1', '0', '1', 'a621322fe88b49afaa91835f421a193b', '1', null);
INSERT INTO `sys_nav` VALUES ('18', '系统账户', '/console/sys_user/list', '1', 'glyphicon glyphicon-user', '1', '16', '1', '1ac0c79d7c3d4ab185fb23178e99970f', '2', null);
INSERT INTO `sys_nav` VALUES ('23', '用户角色', '/console/sys_role/list', '1', 'glyphicon glyphicon-user', '1', '16', '1', 'e77c92c7a5824e08a17b47cec09f3e5a', '2', null);
INSERT INTO `sys_nav` VALUES ('24', '导航', '/console/sys_nav/list', '1', 'glyphicon glyphicon-list', '1', '16', '1', '1ac0c79d7c3d4ab185fb23178e999ddd', '2', null);

-- ----------------------------
-- Table structure for sys_nav_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_nav_role`;
CREATE TABLE `sys_nav_role` (
  `snr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `nav_id` int(11) DEFAULT NULL COMMENT '菜单ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`snr_id`),
  KEY `FK_Reference_18` (`nav_id`),
  KEY `FK_Reference_19` (`role_id`),
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`nav_id`) REFERENCES `sys_nav` (`nav_id`),
  CONSTRAINT `FK_Reference_19` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='角色菜单权限';

-- ----------------------------
-- Records of sys_nav_role
-- ----------------------------
INSERT INTO `sys_nav_role` VALUES ('49', '16', '1');
INSERT INTO `sys_nav_role` VALUES ('50', '18', '1');
INSERT INTO `sys_nav_role` VALUES ('51', '23', '1');
INSERT INTO `sys_nav_role` VALUES ('52', '24', '1');
INSERT INTO `sys_nav_role` VALUES ('53', '16', '2');
INSERT INTO `sys_nav_role` VALUES ('54', '24', '2');

-- ----------------------------
-- Table structure for sys_req_url
-- ----------------------------
DROP TABLE IF EXISTS `sys_req_url`;
CREATE TABLE `sys_req_url` (
  `id` varchar(36) COLLATE utf8mb4_slovenian_ci NOT NULL,
  `url` varchar(255) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '地址',
  `name` varchar(128) COLLATE utf8mb4_slovenian_ci DEFAULT NULL,
  `description` varchar(500) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_slovenian_ci;

-- ----------------------------
-- Records of sys_req_url
-- ----------------------------
INSERT INTO `sys_req_url` VALUES ('02391e837d5d40d493034a8276921ff6', '/console/sys_nav/list', '-列表页面', '-列表页面');
INSERT INTO `sys_req_url` VALUES ('2b51ed22cab74fd5a7018655133bfcb6', '/console/sys_user/json', '用户管理-列表json数据请求', '用户管理-列表json数据请求');
INSERT INTO `sys_req_url` VALUES ('3ab52cba80414303a8bff49050421828', '/console/sys_user/changepass', '用户管理', '用户管理');
INSERT INTO `sys_req_url` VALUES ('3cfdc51bba734ecbad1fed330c474aab', '/console/sys_role/json', '角色管理-列表json数据请求', '角色管理-列表json数据请求');
INSERT INTO `sys_req_url` VALUES ('3e8dad9fe6d04fb38b6f948af6861d59', '/console/sys_role/nav_accredit/json/{role_id}/{sys_id}', '角色管理', '角色管理');
INSERT INTO `sys_req_url` VALUES ('465feba42ba14ddf8fd418f5e8df229d', '/console/sys_role/nav_accredit/{role_id}', '角色管理', '角色管理');
INSERT INTO `sys_req_url` VALUES ('4717f60b22c342ca93e8d4d125caf963', '/console/sys_user/dochangepass', '用户管理', '用户管理');
INSERT INTO `sys_req_url` VALUES ('4bc414406d4c4fdbbae180bfbe500668', '/console/sys_user/add', '用户管理-添加页面', '用户管理-添加页面');
INSERT INTO `sys_req_url` VALUES ('546bf670e0004f53ab4d5a8c90e06c9b', '/console/sys_req_url/init', '请求url管理', '请求url管理');
INSERT INTO `sys_req_url` VALUES ('5739748995ef44a3afc711577fe05a04', '/console/sys_role/req/group/json', '角色管理-列表json数据请求', '角色管理-列表json数据请求');
INSERT INTO `sys_req_url` VALUES ('5ee287beeb2a4167bf62c6ea7a8ace85', '/console/sys_nav/edit', '-编辑页面', '-编辑页面');
INSERT INTO `sys_req_url` VALUES ('65cf492f683b424e946482233094f754', '/console/sys_role/save', '角色管理-保存操作', '角色管理-保存操作');
INSERT INTO `sys_req_url` VALUES ('6a10e13c94ca4a34a15f8eec138fb85f', '/console/sys_user/delete', '用户管理-删除', '用户管理-删除');
INSERT INTO `sys_req_url` VALUES ('6f0a02f39fad422dae15b9daf649e5ee', '/console/sys_req_url/edit', '请求url管理-编辑页面', '请求url管理-编辑页面');
INSERT INTO `sys_req_url` VALUES ('775b26aa975c427897a53fe9b8e29182', '/console/sys_role/do_user_accredit/{user_id}', '角色管理', '角色管理');
INSERT INTO `sys_req_url` VALUES ('7bb3f5f8b3af42f9a6d0e0eb12ee08f3', '/console/sys_req_url/delete', '请求url管理-删除', '请求url管理-删除');
INSERT INTO `sys_req_url` VALUES ('8a43f2c30e0443c98850ae211a941e24', '/console/sys_user/save', '用户管理-保存操作', '用户管理-保存操作');
INSERT INTO `sys_req_url` VALUES ('8ca197728023490aafb8c40dc74dfc7d', '/console/sys_req_url/json', '请求url管理-列表json数据请求', '请求url管理-列表json数据请求');
INSERT INTO `sys_req_url` VALUES ('91c43fd2a6974b428fe5cbae02a98f01', '/console/sys_req_url/save', '请求url管理-保存操作', '请求url管理-保存操作');
INSERT INTO `sys_req_url` VALUES ('938eda419086474994d857cb2848c1f2', '/console/select/json', '-列表json数据请求', '-列表json数据请求');
INSERT INTO `sys_req_url` VALUES ('951e9aa982fb4cddb0a9cf8b634c5dac', '/console/sys_role/user_accredit/{user_id}', '角色管理', '角色管理');
INSERT INTO `sys_req_url` VALUES ('952d9e90aa8a4caa8456647b3ef85206', '/console/sys_role/list', '角色管理-列表页面', '角色管理-列表页面');
INSERT INTO `sys_req_url` VALUES ('a375ea149610466ca987f04cf686d271', '/console/sys_nav/delete', '-删除', '-删除');
INSERT INTO `sys_req_url` VALUES ('af6ab3446468411aba56f36d6632b1e4', '/console/sys_role/nav/json', '角色管理-列表json数据请求', '角色管理-列表json数据请求');
INSERT INTO `sys_req_url` VALUES ('b03b5472036e45b5b30d2710cbb481cc', '/console/sys_user/list/select', '用户管理', '用户管理');
INSERT INTO `sys_req_url` VALUES ('b185b54cc5384a6bb86f9e0e10f03445', '/console/sys_role/delete', '角色管理-删除', '角色管理-删除');
INSERT INTO `sys_req_url` VALUES ('b36c0b0f89f841dfab259d6f93613c63', '/console/sys_user/base', '用户管理', '用户管理');
INSERT INTO `sys_req_url` VALUES ('bdecc689d9034360a402fd0929792027', '/console/sys_user/list', '用户管理-列表页面', '用户管理-列表页面');
INSERT INTO `sys_req_url` VALUES ('beaf2bc0fb3449f6974cab610d923efa', '/console/sys_role/req_accredit/{role_id}', '角色管理', '角色管理');
INSERT INTO `sys_req_url` VALUES ('bf84fafb50e0435b9e31edb986301472', '/console/sys_user/edit', '用户管理-编辑页面', '用户管理-编辑页面');
INSERT INTO `sys_req_url` VALUES ('bff1d7ff20f14f4fa25bba2ef2d9450b', '/console/sys_role/add', '角色管理-添加页面', '角色管理-添加页面');
INSERT INTO `sys_req_url` VALUES ('c1587893c0184317a9d67f78b64f6302', '/console/sys_role/do_req_accredit/{role_id}', '角色管理', '角色管理');
INSERT INTO `sys_req_url` VALUES ('c28311d178984a6bb2f4810f046716cd', '/console/sys_role/edit', '角色管理-编辑页面', '角色管理-编辑页面');
INSERT INTO `sys_req_url` VALUES ('c60c4ebaf48841d0b35b49ce79f44b60', '/console/sys_role/req_accredit/json', '角色管理-列表json数据请求', '角色管理-列表json数据请求');
INSERT INTO `sys_req_url` VALUES ('cadc8b6ac9074f9f8576f73a5be9d3d7', '/console/sys_nav/save', '-保存操作', '-保存操作');
INSERT INTO `sys_req_url` VALUES ('d030a6b3605e46a58c3209b4273d5554', '/console/sys_req_url/list', '请求url管理-列表页面', '请求url管理-列表页面');
INSERT INTO `sys_req_url` VALUES ('dd5876dc535d4d8083c95097b5c6384c', '/console/sys_role/do_nav_accredit/{role_id}', '角色管理', '角色管理');
INSERT INTO `sys_req_url` VALUES ('dfce58432f384ffea08ca88bc31fb5b1', '/console/sys_nav/add', '-添加页面', '-添加页面');
INSERT INTO `sys_req_url` VALUES ('e1434e77a4de4b10ba5574c38089f2de', '/console/sys_nav/json', '-列表json数据请求', '-列表json数据请求');
INSERT INTO `sys_req_url` VALUES ('fe435f84664f4669b5a5e4df014b1824', '/console/sys_req_url/add', '请求url管理-添加页面', '请求url管理-添加页面');

-- ----------------------------
-- Table structure for sys_req_url_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_req_url_role`;
CREATE TABLE `sys_req_url_role` (
  `id` varchar(36) COLLATE utf8mb4_slovenian_ci NOT NULL,
  `role_id` int(10) DEFAULT NULL,
  `req_url` varchar(1024) COLLATE utf8mb4_slovenian_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_slovenian_ci;

-- ----------------------------
-- Records of sys_req_url_role
-- ----------------------------
INSERT INTO `sys_req_url_role` VALUES ('2fcf931f52bf4cd1934f86ee23d2fe12', '2', '/console/sys_nav/delete');
INSERT INTO `sys_req_url_role` VALUES ('551d174d0be448be8b6b8255bf8ce650', '2', '/console/sys_nav/add');
INSERT INTO `sys_req_url_role` VALUES ('62a4c2ecb30043a5b307a380722c8ad1', '2', '/console/sys_nav/');
INSERT INTO `sys_req_url_role` VALUES ('7db8673289a44462b620004959572d3b', '2', '/console/sys_nav/edit');
INSERT INTO `sys_req_url_role` VALUES ('7dd5197cfcf84da2b0610034f87da753', '2', '/console/select/');
INSERT INTO `sys_req_url_role` VALUES ('85b20370fad04fb69a095d8b7f1f31aa', '2', '/console/select/json');
INSERT INTO `sys_req_url_role` VALUES ('8fba4eaf4e384a2ab95706b77d10d2ad', '2', '/console/sys_nav/list');
INSERT INTO `sys_req_url_role` VALUES ('afb5e36aa83742af83d98b8363ca16af', '2', '/console/sys_nav/json');
INSERT INTO `sys_req_url_role` VALUES ('ee3ae417c1b5450ca403515a74f680b9', '2', '/console/sys_nav/save');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `role_name` varchar(128) DEFAULT NULL COMMENT '角色名',
  `status` smallint(2) DEFAULT NULL COMMENT '状态_radio_0:禁用|1:可用',
  `pid` int(11) DEFAULT NULL COMMENT '上级角色ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统角色，开发者平台、后台管理统一维护';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系统管理员', '1', '0', '2016-03-10 16:27:48');
INSERT INTO `sys_role` VALUES ('2', '菜单管理员', '1', '0', '2016-12-23 17:53:18');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `su_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理ID',
  `user_name` varchar(128) DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(128) DEFAULT NULL COMMENT '昵称',
  `user_password` varchar(128) DEFAULT NULL COMMENT '密码',
  `user_pic` varchar(1024) DEFAULT NULL COMMENT '头像_img',
  `verify_email` smallint(2) DEFAULT NULL COMMENT '邮箱是否验证',
  `phone` varchar(16) DEFAULT NULL COMMENT '手机号',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `create_user_id` int(11) DEFAULT NULL COMMENT '创建人ID',
  `update_user_id` int(11) DEFAULT NULL COMMENT '最后更新人ID',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'UUID',
  `user_type` smallint(1) DEFAULT NULL COMMENT '账户类型1企业,2个人',
  `is_auth` smallint(2) DEFAULT NULL COMMENT '是否已认证',
  `status` smallint(2) DEFAULT NULL COMMENT '状态_radio_1:可用|0:不可用',
  PRIMARY KEY (`su_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统管理用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'laozhang', '张钦', 'e10adc3949ba59abbe56e057f20f883e', '\\upload\\20160803\\33320935281680.jpg', '1', '18210178959', '492297036@qq.com', null, null, '1', '1', null, '1', '1', '1');
INSERT INTO `sys_user` VALUES ('2', 'caidan', '菜单', 'e10adc3949ba59abbe56e057f20f883e', '\\upload\\20161223\\636839587638071.png', null, '18210178959', '1', null, null, null, null, null, null, null, '1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `snr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `su_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`snr_id`),
  KEY `FK_Reference_16` (`su_id`),
  KEY `FK_Reference_17` (`role_id`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`su_id`) REFERENCES `sys_user` (`su_id`),
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='用户角色管理';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('29', '1', '1');
INSERT INTO `sys_user_role` VALUES ('30', '2', '2');
