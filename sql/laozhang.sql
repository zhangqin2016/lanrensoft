/*
Navicat MySQL Data Transfer

Source Server         : benji
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : laozhang

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-11-17 19:18:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for app_info
-- ----------------------------
DROP TABLE IF EXISTS `app_info`;
CREATE TABLE `app_info` (
  `app_id` varchar(32) NOT NULL COMMENT 'ID',
  `app_key` varchar(128) DEFAULT NULL COMMENT 'key',
  `app_secret` varchar(128) DEFAULT NULL COMMENT '密钥',
  `app_remark` varchar(1024) DEFAULT NULL COMMENT '应用描述',
  `app_name` varchar(128) DEFAULT NULL COMMENT '应用名称',
  `app_type` varchar(128) DEFAULT NULL COMMENT '应用类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` smallint(2) DEFAULT NULL COMMENT '状态',
  `uuid` varchar(32) DEFAULT NULL COMMENT 'UUID',
  PRIMARY KEY (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接入应用';

-- ----------------------------
-- Records of app_info
-- ----------------------------
INSERT INTO `app_info` VALUES ('1', '1', '1', '1', '1', '1', '2017-03-11 17:46:22', '1', '1');

-- ----------------------------
-- Table structure for app_token
-- ----------------------------
DROP TABLE IF EXISTS `app_token`;
CREATE TABLE `app_token` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `token` varchar(128) DEFAULT NULL COMMENT 'token值',
  `openid` varchar(128) DEFAULT NULL COMMENT 'openid',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `expires_time` datetime DEFAULT NULL COMMENT '失效时间',
  `uuid` varchar(32) DEFAULT NULL COMMENT 'UUID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Token记录';

-- ----------------------------
-- Records of app_token
-- ----------------------------

-- ----------------------------
-- Table structure for bo_test
-- ----------------------------
DROP TABLE IF EXISTS `bo_test`;
CREATE TABLE `bo_test` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `birthday` date DEFAULT NULL COMMENT '出生日期_date',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `img_url` varchar(255) DEFAULT NULL COMMENT '头像_img',
  `des` varchar(255) DEFAULT NULL COMMENT '描述_textarea',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别_radio_男|女|保密',
  `file_my` varchar(255) DEFAULT NULL COMMENT '个人档案_file',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of bo_test
-- ----------------------------
INSERT INTO `bo_test` VALUES ('bac9f6da09644840a6fd40907a7f7601', '1', '1970-01-01', '1', '\\upload\\20171116\\96504632776570.png', '1sdfsdf', '男', '\\upload\\20171116\\96510360396856.png');

-- ----------------------------
-- Table structure for sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary` (
  `id` varchar(32) COLLATE utf8mb4_slovenian_ci NOT NULL,
  `code` varchar(32) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '名称',
  `value` varchar(32) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '值',
  `des` varchar(255) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '描述标题',
  `name` varchar(255) COLLATE utf8mb4_slovenian_ci DEFAULT NULL,
  `default_value` int(1) DEFAULT NULL COMMENT '是否是默认值_radio_0:否|1:是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_slovenian_ci COMMENT='数据字段';

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------
INSERT INTO `sys_dictionary` VALUES ('9201f6d742924a9c975e1a15d1308831', 'ceshi', '111', '1', '1', '0');

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `file_id` varchar(32) COLLATE utf8mb4_slovenian_ci NOT NULL,
  `file_name` varchar(256) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '文件名称',
  `file_type` varchar(255) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '文件类型',
  `file_height` int(11) DEFAULT NULL COMMENT '文件高度',
  `file_width` int(11) DEFAULT NULL COMMENT '文件宽度',
  `file_size` int(20) DEFAULT NULL COMMENT '文件大小',
  `file_url` varchar(255) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '文件地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `local` int(1) DEFAULT NULL COMMENT '是否上传到本地_radio_1:本地|2:图片服务器',
  `file_md5` varchar(255) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '文件md5',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_slovenian_ci COMMENT='系统文件';

-- ----------------------------
-- Records of sys_file
-- ----------------------------
INSERT INTO `sys_file` VALUES ('159567968ac04091b864b04757288649', '微信图片_20170913170326.jpg', '.jpg', '640', '480', '28389', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/946024690191547.jpg', '2017-10-24 10:46:26', '0', 'd50ec5449f93976ae60a5531b21bcb25');
INSERT INTO `sys_file` VALUES ('8a8694742448448e953406d5aca4503e', 'logo_副本.jpg', '.jpg', '64', '64', '2027', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/964543670863864.jpg', '2017-10-24 15:55:05', '0', '967a48090138e717e8ca026827fac7f4');
INSERT INTO `sys_file` VALUES ('b95c6cc7ab674056a484829c8ed0af6c', '微信图片_20170913170326.jpg', '.jpg', '640', '480', '28389', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/946041991157746.jpg', '2017-10-24 10:46:43', '0', 'd50ec5449f93976ae60a5531b21bcb25');
INSERT INTO `sys_file` VALUES ('d8ecc23c9ac645a0a0c8a547cdbc42da', 'QQ截图20170704100445.jpg', '.jpg', '178', '249', '8921', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/1740847072834707.jpg', '2017-07-12 15:13:36', '0', null);
INSERT INTO `sys_file` VALUES ('e9bc0a1f76c4476ab607060ba7947e20', 'QQ截图20170704100445.jpg', '.jpg', '178', '249', '8921', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/1914733068261941.jpg', '2017-07-14 15:31:33', '0', null);
INSERT INTO `sys_file` VALUES ('f0217164b4294c82b7eba8a762a85703', 'QQ截图20170704100445.jpg', '.jpg', '178', '249', '8921', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/1740835053160537.jpg', '2017-07-12 15:13:24', '0', null);

-- ----------------------------
-- Table structure for sys_nav
-- ----------------------------
DROP TABLE IF EXISTS `sys_nav`;
CREATE TABLE `sys_nav` (
  `nav_id` varchar(32) NOT NULL COMMENT 'ID',
  `name` varchar(128) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(1024) DEFAULT NULL COMMENT '菜单地址',
  `url_target` varchar(32) DEFAULT NULL COMMENT '链接打开位置',
  `icon_url` varchar(1024) DEFAULT NULL COMMENT '菜单图标',
  `sort` smallint(3) DEFAULT NULL COMMENT '排序',
  `pid` varchar(32) DEFAULT NULL COMMENT '上级ID',
  `status` smallint(1) DEFAULT NULL COMMENT '状态_radio_1:可用|0:不可用',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'UUID',
  `levels` smallint(2) DEFAULT NULL COMMENT '菜单级别',
  `type` smallint(1) DEFAULT NULL COMMENT '类型_radio_0:按钮|1:菜单',
  PRIMARY KEY (`nav_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单';

-- ----------------------------
-- Records of sys_nav
-- ----------------------------
INSERT INTO `sys_nav` VALUES ('143c374692dd4d11a0168ce8c28484a2', '字典管理', '1', '_self', 'glyphicon glyphicon-edit', '3', '16', '1', '1d54f2a8510041bf89b763e9cfc9b2ae', '2', null);
INSERT INTO `sys_nav` VALUES ('16', '系统设置', '/console/sys_user/list', '_self', 'glyphicon glyphicon-eur', '1', '0', '1', 'a621322fe88b49afaa91835f421a193b', '1', null);
INSERT INTO `sys_nav` VALUES ('18', '系统账户', '/console/sys_user/list', '1', 'glyphicon glyphicon-user', '1', '16', '1', '1ac0c79d7c3d4ab185fb23178e99970f', '2', null);
INSERT INTO `sys_nav` VALUES ('23', '用户角色', '/console/sys_role/list', '1', 'glyphicon glyphicon-user', '1', '16', '1', 'e77c92c7a5824e08a17b47cec09f3e5a', '2', null);
INSERT INTO `sys_nav` VALUES ('24', '导航', '/console/sys_nav/list', '1', 'glyphicon glyphicon-list', '1', '16', '1', '1ac0c79d7c3d4ab185fb23178e999ddd', '2', null);
INSERT INTO `sys_nav` VALUES ('d1e2fa7a87e74f82b4e935db1a780788', '测试字典', '/console/sys_dictionary/list/ceshi', '_self', 'glyphicon glyphicon-calendar', '1', '143c374692dd4d11a0168ce8c28484a2', '1', 'cd6fe0f060e14a9880af92015454f76d', '3', null);

-- ----------------------------
-- Table structure for sys_nav_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_nav_role`;
CREATE TABLE `sys_nav_role` (
  `snr_id` varchar(32) NOT NULL COMMENT 'ID',
  `nav_id` varchar(32) DEFAULT NULL COMMENT '菜单ID',
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`snr_id`),
  KEY `FK_Reference_18` (`nav_id`),
  KEY `FK_Reference_19` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单权限';

-- ----------------------------
-- Records of sys_nav_role
-- ----------------------------
INSERT INTO `sys_nav_role` VALUES ('1223c09e820041e69b2e7c125751db73', '16', '1');
INSERT INTO `sys_nav_role` VALUES ('183e052de6c84aea8cb7100e8c5a7bd0', '143c374692dd4d11a0168ce8c28484a2', '1');
INSERT INTO `sys_nav_role` VALUES ('55221c99620541e08bb94f7d1b8361a7', '23', '1');
INSERT INTO `sys_nav_role` VALUES ('cb78e5091c444d2ab777833402b926fa', '24', '1');
INSERT INTO `sys_nav_role` VALUES ('d7c3e871aea346f6b18799bab549653b', '18', '1');
INSERT INTO `sys_nav_role` VALUES ('ef0b60a339ac441c947ca4d170a0c5bd', 'd1e2fa7a87e74f82b4e935db1a780788', '1');

-- ----------------------------
-- Table structure for sys_req_url
-- ----------------------------
DROP TABLE IF EXISTS `sys_req_url`;
CREATE TABLE `sys_req_url` (
  `id` varchar(32) COLLATE utf8mb4_slovenian_ci NOT NULL,
  `url` varchar(512) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '地址',
  `name` varchar(512) COLLATE utf8mb4_slovenian_ci DEFAULT NULL,
  `description` varchar(512) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '描述',
  `group_id` varchar(32) COLLATE utf8mb4_slovenian_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_slovenian_ci;

-- ----------------------------
-- Records of sys_req_url
-- ----------------------------
INSERT INTO `sys_req_url` VALUES ('00b2195a20874daeb3804fa6466dc7d5', '/console/sys_role/clear/role/req', 'clearReq', '', 'e2c6b7f9652a49d6ab9ce1a5f8ae7312');
INSERT INTO `sys_req_url` VALUES ('02d41bda8fb54701938b073314963840', '/console/sys_role/nav/json', 'navJson', '', 'e2c6b7f9652a49d6ab9ce1a5f8ae7312');
INSERT INTO `sys_req_url` VALUES ('05cdbdf9b392449792e7e4092c062e4a', '/console/sys_role/save', 'save', '', 'e2c6b7f9652a49d6ab9ce1a5f8ae7312');
INSERT INTO `sys_req_url` VALUES ('071c2aec73474935a9908a957dba1c20', '/console/sys_nav/delete', 'delete', '', '91a5de68825441f1847ceebb09f735d1');
INSERT INTO `sys_req_url` VALUES ('0c915e286c104e55bfb8252b1d84e311', '/console/sys_user/base', 'base', '', 'e5d1302c9ef040fdbd8a8616c8ced669');
INSERT INTO `sys_req_url` VALUES ('0ce4503a947d4132a16065c1a4bb85a9', '/console/sys_role/clear/role/nav', 'clearNav', '', 'e2c6b7f9652a49d6ab9ce1a5f8ae7312');
INSERT INTO `sys_req_url` VALUES ('0f8283077c484059a3fdbbb50d65c5af', '/file/upload', 'upload', '', '0527e6f64ceb4f88a852af218fa62582');
INSERT INTO `sys_req_url` VALUES ('0fb892825976458d8b77c7b89ddf4c80', '/console/sys_user/changepass', 'changepass', '', 'e5d1302c9ef040fdbd8a8616c8ced669');
INSERT INTO `sys_req_url` VALUES ('148cbd50787848ebb77fad112327bc7e', '/console/sys_role/user_accredit/{user_id}', 'user_accredit', '', 'e2c6b7f9652a49d6ab9ce1a5f8ae7312');
INSERT INTO `sys_req_url` VALUES ('14cbb4b86d3142529357620827a9d811', '/console/bo_test/list', 'list', '', '38d3eca5374c416ab5f4202f7a01e090');
INSERT INTO `sys_req_url` VALUES ('1c07b6d6f5bd453c9e0235116cf9645a', '/console', 'index', '', '32f664842cfc425aae1a0587180b92f9');
INSERT INTO `sys_req_url` VALUES ('1fce1765e1ff4a52a6465ad0624861bc', '/console/bo_test/save', 'save', '', '38d3eca5374c416ab5f4202f7a01e090');
INSERT INTO `sys_req_url` VALUES ('2649e99de5724daebe2192c2010d38fc', '/console/sys_role/json', 'json', '', 'e2c6b7f9652a49d6ab9ce1a5f8ae7312');
INSERT INTO `sys_req_url` VALUES ('3240e5103106481aa1998fc8afddbd61', '/console/export/excel', 'exportExcel', '', '57d363c2908a4820bf3a282231d3dd3e');
INSERT INTO `sys_req_url` VALUES ('328cc3b57cef41e39da38411e786e1d0', '/common/captcha/get/{id}', 'getCaptchaImage', '', '5e0aecd8b297410f8356fb8cda57a2ab');
INSERT INTO `sys_req_url` VALUES ('36c6aa2bc1804a3d8e9c04ec12c84ec5', '/console/sys_dictionary/list/{code}', 'list', '', '6f8b28443a3c4e4495c4c5fcffb3e5b8');
INSERT INTO `sys_req_url` VALUES ('3bab98b73026401089eae824190586b5', '/console/sys_role/req_accredit/json', 'req_accreditJson', '', 'e2c6b7f9652a49d6ab9ce1a5f8ae7312');
INSERT INTO `sys_req_url` VALUES ('45d9f4cd468645f0a1406db8adec41cb', '/console/sys_req_url/edit', 'edit', '', 'a88dd30911e745509eed8618a0fddd40');
INSERT INTO `sys_req_url` VALUES ('46bb0cc1394244bbb1c014b57cc80aeb', '/console/sys_role/do_nav_accredit/{role_id}', 'do_nav_accredit', '', 'e2c6b7f9652a49d6ab9ce1a5f8ae7312');
INSERT INTO `sys_req_url` VALUES ('4aaba8d20ed94ed193924a18763497e2', '/console/sys_role/req/group/json', 'reqGroupJson', '', 'e2c6b7f9652a49d6ab9ce1a5f8ae7312');
INSERT INTO `sys_req_url` VALUES ('4e30f23b3a3640919db6057ec9f0b272', '/console/sys_user/list', 'list', '', 'e5d1302c9ef040fdbd8a8616c8ced669');
INSERT INTO `sys_req_url` VALUES ('4fbe1ecc1e5d4ee7a7374c6e3c963bea', '/console/sys_dictionary/json', 'json', '', '6f8b28443a3c4e4495c4c5fcffb3e5b8');
INSERT INTO `sys_req_url` VALUES ('5989d0fe5a434542aaa2ab9f0aaef8bd', '/console/sys_role/nav_accredit/{role_id}', 'nav_accredit', '', 'e2c6b7f9652a49d6ab9ce1a5f8ae7312');
INSERT INTO `sys_req_url` VALUES ('5bbce083f58e431d915b4a194ebde235', '/', 'main', '', '32f664842cfc425aae1a0587180b92f9');
INSERT INTO `sys_req_url` VALUES ('5cbce37cbde0482cbcc2728c0d81f922', '/console/sys_role/do_user_accredit/{user_id}', 'do_user_accredit', '', 'e2c6b7f9652a49d6ab9ce1a5f8ae7312');
INSERT INTO `sys_req_url` VALUES ('5d4f3dcf9fff4c5a8a913ef0373588a6', '/console/sys_dictionary/save', 'save', '', '6f8b28443a3c4e4495c4c5fcffb3e5b8');
INSERT INTO `sys_req_url` VALUES ('694ae8a1974249e684dcd55cba1c78f9', '/console/bo_test/json', 'json', '', '38d3eca5374c416ab5f4202f7a01e090');
INSERT INTO `sys_req_url` VALUES ('6c5eb6465a7844b0a587ccf33b97be77', '/console/sys_user/delete', 'delete', '', 'e5d1302c9ef040fdbd8a8616c8ced669');
INSERT INTO `sys_req_url` VALUES ('6c71a07d700c44528cf9e71f9a1daf1f', '/console/sys_dictionary/delete', 'delete', '', '6f8b28443a3c4e4495c4c5fcffb3e5b8');
INSERT INTO `sys_req_url` VALUES ('6d15626df15f4403bdf4561d77c0e9c8', '/console/sys_dictionary/edit', 'edit', '', '6f8b28443a3c4e4495c4c5fcffb3e5b8');
INSERT INTO `sys_req_url` VALUES ('793668bbf65a4a9d9c7e4b023e4c4719', '/file/upload/ali', 'uploadAli', '', '0527e6f64ceb4f88a852af218fa62582');
INSERT INTO `sys_req_url` VALUES ('80f4be56c84e4ae2897fd833fac0b43a', '/console/sys_nav/add', 'add', '', '91a5de68825441f1847ceebb09f735d1');
INSERT INTO `sys_req_url` VALUES ('81f14ff927c8442eb5b0e1767777ffd3', '/console/sys_role/list', 'list', '', 'e2c6b7f9652a49d6ab9ce1a5f8ae7312');
INSERT INTO `sys_req_url` VALUES ('8c6e887ccfa9499aa4e75d2f6b310317', '/console/nav/trun/first', 'getNavFirstReturn', '', 'ba2391b78b044b5c9e81829ef4ff68dd');
INSERT INTO `sys_req_url` VALUES ('91824eb417b84d419f081a84d65f3f2d', '/console/sys_req_url/add', 'add', '', 'a88dd30911e745509eed8618a0fddd40');
INSERT INTO `sys_req_url` VALUES ('94de29d0b4a34df3b4cb38f2c8bd7f7f', '/console/sys_req_url/delete', 'delete', '', 'a88dd30911e745509eed8618a0fddd40');
INSERT INTO `sys_req_url` VALUES ('9854d8f585c444938aa8d47b678a3501', '/console/bo_test/add', 'add', '', '38d3eca5374c416ab5f4202f7a01e090');
INSERT INTO `sys_req_url` VALUES ('a38796029d124c68ac0b625e1028cdb9', '/console/select/json', 'json', '', 'c0c751fd69db40aca3783b67a4239798');
INSERT INTO `sys_req_url` VALUES ('a7f8339ff52a4e46842df831e9f49671', '/console/sys_role/do_req_accredit/{role_id}', 'do_req_accredit', '', 'e2c6b7f9652a49d6ab9ce1a5f8ae7312');
INSERT INTO `sys_req_url` VALUES ('a81d0a9869024af5a4be9aa91432ce85', '/console/sys_user/edit', 'edit', '', 'e5d1302c9ef040fdbd8a8616c8ced669');
INSERT INTO `sys_req_url` VALUES ('b10564218fa149199cee6954030a6c06', '/console/login', 'login', '', '32f664842cfc425aae1a0587180b92f9');
INSERT INTO `sys_req_url` VALUES ('b8706a27dd984a3eb841f07da83427b2', '/console/sys_nav/save', 'save', '', '91a5de68825441f1847ceebb09f735d1');
INSERT INTO `sys_req_url` VALUES ('b90679c0d946451d8726f0bb9617bf80', '/console/sys_user/json', 'json', '', 'e5d1302c9ef040fdbd8a8616c8ced669');
INSERT INTO `sys_req_url` VALUES ('b9fe2d8a49e74d1186075bc74077a92f', '/console/sys_req_url/save', 'save', '', 'a88dd30911e745509eed8618a0fddd40');
INSERT INTO `sys_req_url` VALUES ('ba797003ad094a7ba6d480dc89e04a3d', '/console/sys_user/list/select', 'select', '', 'e5d1302c9ef040fdbd8a8616c8ced669');
INSERT INTO `sys_req_url` VALUES ('c0831e7a561b4b5d8d44e0601e2c3ae7', '/console/sys_nav/list', 'list', '', '91a5de68825441f1847ceebb09f735d1');
INSERT INTO `sys_req_url` VALUES ('c6a55c83ca0e4d9a906ef04808d03092', '/console/bo_test/edit', 'edit', '', '38d3eca5374c416ab5f4202f7a01e090');
INSERT INTO `sys_req_url` VALUES ('ca6ed890d6ab43ab984b561f9f32477b', '/console/sys_req_url/json', 'json', '', 'a88dd30911e745509eed8618a0fddd40');
INSERT INTO `sys_req_url` VALUES ('cf611260d54844e9b7eaa89b17ae9a4a', '/console/bo_test/delete', 'delete', '', '38d3eca5374c416ab5f4202f7a01e090');
INSERT INTO `sys_req_url` VALUES ('d059b1fe049143699efbdc64c3484b33', '/console/sys_role/edit', 'edit', '', 'e2c6b7f9652a49d6ab9ce1a5f8ae7312');
INSERT INTO `sys_req_url` VALUES ('d60b231cda1b48aba2d46fa2e6a2ae4c', '/console/sys_req_url/list', 'list', '', 'a88dd30911e745509eed8618a0fddd40');
INSERT INTO `sys_req_url` VALUES ('da7fa1bbae56426793dcb7801047727f', '/console/sys_user/save', 'save', '', 'e5d1302c9ef040fdbd8a8616c8ced669');
INSERT INTO `sys_req_url` VALUES ('e23be9d1c798494f9a44e539c5e1b814', '/console/sys_role/nav_accredit/json/{role_id}/{sys_id}', 'nav_accreditJson', '', 'e2c6b7f9652a49d6ab9ce1a5f8ae7312');
INSERT INTO `sys_req_url` VALUES ('e878c7f41f194cddada85e15aacc2bc1', '/console/sys_user/reset/password', 'resetPassword', '', 'e5d1302c9ef040fdbd8a8616c8ced669');
INSERT INTO `sys_req_url` VALUES ('e98ee3fd479944a8bd1c62196aea0635', '/console/sys_dictionary/add/{code}', 'add', '', '6f8b28443a3c4e4495c4c5fcffb3e5b8');
INSERT INTO `sys_req_url` VALUES ('eab65be4802a43ff84736705bf0b148c', '/console/sys_nav/json', 'json', '', '91a5de68825441f1847ceebb09f735d1');
INSERT INTO `sys_req_url` VALUES ('efdc282b6aed4a14b0dbc8207076adab', '/console/sys_user/dochangepass', 'dochangepass', '', 'e5d1302c9ef040fdbd8a8616c8ced669');
INSERT INTO `sys_req_url` VALUES ('f04761255a784a609aa129f96bd87e17', '/console/sys_role/add', 'add', '', 'e2c6b7f9652a49d6ab9ce1a5f8ae7312');
INSERT INTO `sys_req_url` VALUES ('f1bb517270ed48beb35a247022140563', '/console/logout', 'logout', '', '32f664842cfc425aae1a0587180b92f9');
INSERT INTO `sys_req_url` VALUES ('f9e62253a4be42ba81c605af31cf6ec3', '/console/sys_role/req_accredit/{role_id}', 'req_accredit', '', 'e2c6b7f9652a49d6ab9ce1a5f8ae7312');
INSERT INTO `sys_req_url` VALUES ('fadb0eedc54c42f78920131adf5ccea8', '/console/sys_user/add', 'add', '', 'e5d1302c9ef040fdbd8a8616c8ced669');
INSERT INTO `sys_req_url` VALUES ('fbd4c52b5b814888b20e3494ae816063', '/console/sys_role/delete', 'delete', '', 'e2c6b7f9652a49d6ab9ce1a5f8ae7312');
INSERT INTO `sys_req_url` VALUES ('fc7ede032749440e892063c660bb2e35', '/console/sys_nav/edit', 'edit', '', '91a5de68825441f1847ceebb09f735d1');

-- ----------------------------
-- Table structure for sys_req_url_group
-- ----------------------------
DROP TABLE IF EXISTS `sys_req_url_group`;
CREATE TABLE `sys_req_url_group` (
  `id` varchar(32) COLLATE utf8mb4_slovenian_ci NOT NULL,
  `name` varchar(512) COLLATE utf8mb4_slovenian_ci DEFAULT NULL,
  `description` varchar(512) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_slovenian_ci;

-- ----------------------------
-- Records of sys_req_url_group
-- ----------------------------
INSERT INTO `sys_req_url_group` VALUES ('0527e6f64ceb4f88a852af218fa62582', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.FileUpAndDown', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.FileUpAndDown');
INSERT INTO `sys_req_url_group` VALUES ('32f664842cfc425aae1a0587180b92f9', 'zhang.lao.console.controller.login.zhang.lao.console.controller.login.LoginController', 'zhang.lao.console.controller.login.zhang.lao.console.controller.login.LoginController');
INSERT INTO `sys_req_url_group` VALUES ('38d3eca5374c416ab5f4202f7a01e090', 'zhang.lao.console.controller.zhang.lao.console.controller.BoTestController', 'zhang.lao.console.controller.zhang.lao.console.controller.BoTestController');
INSERT INTO `sys_req_url_group` VALUES ('57d363c2908a4820bf3a282231d3dd3e', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.HtmlTableToExcel', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.HtmlTableToExcel');
INSERT INTO `sys_req_url_group` VALUES ('5e0aecd8b297410f8356fb8cda57a2ab', 'zhang.lao.console.controller.common.captcha.zhang.lao.console.controller.common.captcha.CaptchaController', 'zhang.lao.console.controller.common.captcha.zhang.lao.console.controller.common.captcha.CaptchaController');
INSERT INTO `sys_req_url_group` VALUES ('6f8b28443a3c4e4495c4c5fcffb3e5b8', 'zhang.lao.console.controller.zhang.lao.console.controller.SysDictionaryController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysDictionaryController');
INSERT INTO `sys_req_url_group` VALUES ('91a5de68825441f1847ceebb09f735d1', 'zhang.lao.console.controller.zhang.lao.console.controller.SysNavController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysNavController');
INSERT INTO `sys_req_url_group` VALUES ('a88dd30911e745509eed8618a0fddd40', 'zhang.lao.console.controller.zhang.lao.console.controller.SysReqUrlController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysReqUrlController');
INSERT INTO `sys_req_url_group` VALUES ('ba2391b78b044b5c9e81829ef4ff68dd', 'zhang.lao.console.controller.nav.zhang.lao.console.controller.nav.PageTurnController', 'zhang.lao.console.controller.nav.zhang.lao.console.controller.nav.PageTurnController');
INSERT INTO `sys_req_url_group` VALUES ('c0c751fd69db40aca3783b67a4239798', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.SelectCommontController', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.SelectCommontController');
INSERT INTO `sys_req_url_group` VALUES ('e2c6b7f9652a49d6ab9ce1a5f8ae7312', 'zhang.lao.console.controller.zhang.lao.console.controller.SysRoleController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysRoleController');
INSERT INTO `sys_req_url_group` VALUES ('e5d1302c9ef040fdbd8a8616c8ced669', 'zhang.lao.console.controller.zhang.lao.console.controller.SysUserController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysUserController');

-- ----------------------------
-- Table structure for sys_req_url_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_req_url_role`;
CREATE TABLE `sys_req_url_role` (
  `id` varchar(32) COLLATE utf8mb4_slovenian_ci NOT NULL,
  `role_id` varchar(32) COLLATE utf8mb4_slovenian_ci DEFAULT NULL,
  `req_url` varchar(1024) COLLATE utf8mb4_slovenian_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_slovenian_ci;

-- ----------------------------
-- Records of sys_req_url_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_req_url_white_list
-- ----------------------------
DROP TABLE IF EXISTS `sys_req_url_white_list`;
CREATE TABLE `sys_req_url_white_list` (
  `id` varchar(32) COLLATE utf8mb4_slovenian_ci NOT NULL,
  `url` varchar(512) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '地址',
  `name` varchar(128) COLLATE utf8mb4_slovenian_ci DEFAULT NULL,
  `description` varchar(60) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_slovenian_ci;

-- ----------------------------
-- Records of sys_req_url_white_list
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` varchar(32) NOT NULL COMMENT 'ID',
  `role_name` varchar(128) DEFAULT NULL COMMENT '角色名',
  `status` smallint(2) DEFAULT NULL COMMENT '状态_radio_0:禁用|1:可用',
  `pid` varchar(32) DEFAULT NULL COMMENT '上级角色ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色，开发者平台、后台管理统一维护';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系统管理员', '1', '0', '2016-03-10 16:27:48');
INSERT INTO `sys_role` VALUES ('59add951f06c4a11ab9c22135b4bb12f', '测试', '1', '0', '2017-08-22 10:17:35');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `su_id` varchar(32) NOT NULL COMMENT '管理ID',
  `nick_name` varchar(128) DEFAULT NULL COMMENT '昵称',
  `user_password` varchar(128) DEFAULT NULL COMMENT '密码',
  `user_pic` varchar(1024) DEFAULT NULL COMMENT '头像_img',
  `phone` varchar(16) DEFAULT NULL COMMENT '手机号',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `create_user_id` varchar(32) DEFAULT NULL COMMENT '创建人ID',
  `update_user_id` varchar(32) DEFAULT NULL COMMENT '最后更新人ID',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'UUID',
  `status` smallint(1) DEFAULT NULL COMMENT '状态_radio_1:可用|0:不可用',
  `user_type` smallint(1) DEFAULT NULL COMMENT '用户类型_radio_1:系统管理员|2:普通管理员',
  `user_account` varchar(36) DEFAULT NULL COMMENT '用户账户',
  PRIMARY KEY (`su_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统管理用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '张钦2', '14e1b600b1fd579f47433b88e8d85291', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/946024690191547.jpg', '18210178959', '492297036@qq.com', null, null, '1', '1', null, '1', '1', 'admin');
INSERT INTO `sys_user` VALUES ('7047f9c8c825498f83d2048c92463cb6', 'test', '14e1b600b1fd579f47433b88e8d85291', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/946041991157746.jpg', 'test', 'test', null, null, null, null, null, '1', '2', 'test');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `snr_id` varchar(32) NOT NULL COMMENT 'ID',
  `su_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`snr_id`),
  KEY `FK_Reference_16` (`su_id`),
  KEY `FK_Reference_17` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色管理';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('29', '1', '1');
