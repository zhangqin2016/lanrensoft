/*
Navicat MySQL Data Transfer

Source Server         : benji
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : laozhang

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-08-21 18:15:53
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
-- Table structure for bo_cms_news
-- ----------------------------
DROP TABLE IF EXISTS `bo_cms_news`;
CREATE TABLE `bo_cms_news` (
  `id` varchar(36) COLLATE utf8mb4_slovenian_ci NOT NULL COMMENT 'id_uuid',
  `create_time` datetime DEFAULT NULL,
  `publish` int(1) DEFAULT NULL COMMENT '是否发布_radio_0:未发布|1:已发布',
  `author` varchar(22) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '作者',
  `source` varchar(255) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '来源',
  `update_time` datetime DEFAULT NULL,
  `content` text COLLATE utf8mb4_slovenian_ci COMMENT '内容',
  `cover` varchar(255) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '封面_img',
  `title` varchar(200) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '新闻标题_date',
  `news_type` int(1) DEFAULT NULL COMMENT '新闻类型_select_1:1|2:2',
  `intro` varchar(1024) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '简介',
  `tag` varchar(255) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '新闻标签',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_slovenian_ci COMMENT='新闻';

-- ----------------------------
-- Records of bo_cms_news
-- ----------------------------
INSERT INTO `bo_cms_news` VALUES ('1d9c58f269264fb28c965b7aa4ea5846', '2017-06-14 16:37:59', '0', '1', '11', null, '1', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/1740847072834707.jpg', '2017-06-14 16:37:49', '1', '222', '1');

-- ----------------------------
-- Table structure for bo_user
-- ----------------------------
DROP TABLE IF EXISTS `bo_user`;
CREATE TABLE `bo_user` (
  `id` varchar(32) NOT NULL,
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `phone_number` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `password` varchar(48) DEFAULT NULL COMMENT '密码',
  `sex` int(1) DEFAULT NULL COMMENT '性别_radio_0:保密|1:男|2:女',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `state` int(1) DEFAULT NULL COMMENT '是否可用_radio_0:不可用|1:可用',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `head_image` varchar(1024) DEFAULT NULL COMMENT '头像_img',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of bo_user
-- ----------------------------
INSERT INTO `bo_user` VALUES ('82f672112fea4d6db3033ca624d8ddca', '3', '3', '3', '0', '3', '0', null, 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/1914733068261941.jpg');
INSERT INTO `bo_user` VALUES ('a4485fb6b5554d84b0fb008478a9ac2d', '121', '212', '1212', '0', '1212', '0', null, '\\upload\\20170714\\1914509749582876.jpg');
INSERT INTO `bo_user` VALUES ('d9bcb13188f14f5c8987f2b674c43b8f', '2', '2', '2', '0', '2', '0', null, '\\upload\\20170630\\713457902642228.jpg');
INSERT INTO `bo_user` VALUES ('ef93db4f06894f5cb5f6ee77b880db5f', '1', '1', '1', '2', '1', '1', null, '\\upload\\20170621\\781499313283325.jpg');

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
INSERT INTO `sys_nav` VALUES ('16', '系统设置', '/console/sys_user/list', '_self', 'glyphicon glyphicon-eur', '1', '0', '1', 'a621322fe88b49afaa91835f421a193b', '1', null);
INSERT INTO `sys_nav` VALUES ('18', '系统账户', '/console/sys_user/list', '1', 'glyphicon glyphicon-user', '1', '16', '1', '1ac0c79d7c3d4ab185fb23178e99970f', '2', null);
INSERT INTO `sys_nav` VALUES ('23', '用户角色', '/console/sys_role/list', '1', 'glyphicon glyphicon-user', '1', '16', '1', 'e77c92c7a5824e08a17b47cec09f3e5a', '2', null);
INSERT INTO `sys_nav` VALUES ('24', '导航', '/console/sys_nav/list', '1', 'glyphicon glyphicon-list', '1', '16', '1', '1ac0c79d7c3d4ab185fb23178e999ddd', '2', null);
INSERT INTO `sys_nav` VALUES ('7bed0648d96e486a956ac729023c1e13', '用户管理', '/console/bo_user/list', '_self', 'glyphicon glyphicon-user', '2', 'e62bf1dd57a44ffa9f4e763d1c89911e', '1', 'c5f9f03781c54bc781d1f129d30c3bb7', '2', null);
INSERT INTO `sys_nav` VALUES ('b1d0e2d0e7e5439595ee25aed5ab5baa', '新闻列表', '/console/bo_cms_news/list', '_main', 'glyphicon glyphicon-road', '4', 'e0fed8124cae460ab481b45ede61e2b0', '1', 'c91a638248c948568927dba7c9fc079b', '3', null);
INSERT INTO `sys_nav` VALUES ('e0fed8124cae460ab481b45ede61e2b0', '新闻管理', '/', '_main', 'glyphicon glyphicon-picture', '2', 'e62bf1dd57a44ffa9f4e763d1c89911e', '1', 'f6183183046745508fcf5a98eb1f7a7b', '2', null);
INSERT INTO `sys_nav` VALUES ('e62bf1dd57a44ffa9f4e763d1c89911e', 'CMS管理', '/', '_main', 'glyphicon glyphicon-globe', '2', '0', '1', 'a2ba244d349b443985646086f128cddf', '1', null);

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
INSERT INTO `sys_nav_role` VALUES ('078c81f9c1ef4cb1bff1f1ce7e63d260', 'b1d0e2d0e7e5439595ee25aed5ab5baa', '1');
INSERT INTO `sys_nav_role` VALUES ('388d6fbdcbca47269cf7e0d7027ac89d', '24', '1');
INSERT INTO `sys_nav_role` VALUES ('59a7e191c8a14d99b166142116e44e11', '18', '1');
INSERT INTO `sys_nav_role` VALUES ('7cb972692ea44b1d8996c3dae8d5d10c', '23', '1');
INSERT INTO `sys_nav_role` VALUES ('bd619af688194e4aa0d4501a426a22b6', 'e62bf1dd57a44ffa9f4e763d1c89911e', '1');
INSERT INTO `sys_nav_role` VALUES ('cb298b14254643f08f9477669dd4dcf1', '7bed0648d96e486a956ac729023c1e13', '1');
INSERT INTO `sys_nav_role` VALUES ('d6d1238be3ef4964bc01f7d31d64061c', 'e0fed8124cae460ab481b45ede61e2b0', '1');
INSERT INTO `sys_nav_role` VALUES ('de335a8ff1fe4730adbb34926e711433', '16', '1');

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
INSERT INTO `sys_req_url` VALUES ('027ce8c5065446779387dc7a1fa935ee', '/console/sys_role/req/group/json', 'reqGroupJson', '', '01a1ac47f5c347fc874a71d52ea174d2');
INSERT INTO `sys_req_url` VALUES ('03408ad642c6445aafa74045bc06a355', '/console/sys_user/json', 'json', '', '5294709f5971431a863dc3e06265020b');
INSERT INTO `sys_req_url` VALUES ('038d0ca2d8a94362b18bda758130478a', '/common/captcha/get/{id}', 'getCaptchaImage', '', 'e90cfd5f88b84ae0b984b11a89a2a769');
INSERT INTO `sys_req_url` VALUES ('059b84202a7b4bd8abae0aca2bbec3b7', '/console/sys_user/edit', 'edit', '', '5294709f5971431a863dc3e06265020b');
INSERT INTO `sys_req_url` VALUES ('0634c55402604d2e9c8265be120e646a', '/console/sys_role/list', 'list', '', '01a1ac47f5c347fc874a71d52ea174d2');
INSERT INTO `sys_req_url` VALUES ('0ce8a36bfce244da8688028f8198b33a', '/console/export/excel', 'exportExcel', '', 'b41ba388fdf74158926a17c616bdf5c4');
INSERT INTO `sys_req_url` VALUES ('1be8330d2bd04a1d96a34d4565470ee6', '/console/bo_cms_news/edit', 'edit', '', '5d514d2cd9e34c46a88c5fdbe65e14f6');
INSERT INTO `sys_req_url` VALUES ('1cb274973a6f4ebf9c889ef52d0b67cc', '/console/bo_user/add', 'add', '', '3a24fe92db654250a9b4004f81ac057e');
INSERT INTO `sys_req_url` VALUES ('1d3f3f55704d4d7186d3e465370a042c', '/file/upload', 'upload', '', '0a74190723774085851e1ec42857f41a');
INSERT INTO `sys_req_url` VALUES ('2d2ba589437149eba7b3d5df7768691f', '/console/{test}/fload/user/a', 'testJson', '', 'd0a105c8453a47208b3f2a1a22cabe9d');
INSERT INTO `sys_req_url` VALUES ('2da21776bf3e417c8da6ee20b96a23fe', '/console/logout', 'logout', '', 'ce68212e774f4a7199fc28f0748c7595');
INSERT INTO `sys_req_url` VALUES ('3149702a4fac47bf97b388fe426a0c7f', '/console/sys_req_url/json', 'json', '', '4215a5e0b177468fb0a5e1f35bf8d1ca');
INSERT INTO `sys_req_url` VALUES ('3488d6bdf9b245ffb186c2ea8cf86c40', '/console/nav/trun/first', 'getNavFirstReturn', '', '828e9690d5374b2abc74d6285f3e0f02');
INSERT INTO `sys_req_url` VALUES ('34fc4da8f5544f048ebe5c0b7d6de4f3', '/console/bo_cms_news/delete', 'delete', '', '5d514d2cd9e34c46a88c5fdbe65e14f6');
INSERT INTO `sys_req_url` VALUES ('364a099bd50c45e59e319e3295fcee47', '/console/sys_nav/json', 'json', '', '18d9973c3a2a45e5b31aeb0d670a4314');
INSERT INTO `sys_req_url` VALUES ('40189f4b346e47ebbc8635efa6cde071', '/console/sys_req_url/add', 'add', '', '4215a5e0b177468fb0a5e1f35bf8d1ca');
INSERT INTO `sys_req_url` VALUES ('44331208ab8447a88cb51a6e393b1ae4', '/console/select/json', 'json', '', 'a4aac22f7a314c9d90feb8a4b1180c04');
INSERT INTO `sys_req_url` VALUES ('4555c26d1eae40efa490ec9f39b86379', '/console/bo_cms_news/save', 'save', '', '5d514d2cd9e34c46a88c5fdbe65e14f6');
INSERT INTO `sys_req_url` VALUES ('48a23eb15c954892b60af326ed18d647', '/console/bo_user/save', 'save', '', '3a24fe92db654250a9b4004f81ac057e');
INSERT INTO `sys_req_url` VALUES ('4e1f8d18eed54886822c27e022b01248', '/console/sys_nav/add', 'add', '', '18d9973c3a2a45e5b31aeb0d670a4314');
INSERT INTO `sys_req_url` VALUES ('4ee1f905b0104600b6f51d48ddc4033a', '/console/sys_user/delete', 'delete', '', '5294709f5971431a863dc3e06265020b');
INSERT INTO `sys_req_url` VALUES ('52a3662d618d45eeaa00226c588f3905', '/console/bo_user/json', 'json', '', '3a24fe92db654250a9b4004f81ac057e');
INSERT INTO `sys_req_url` VALUES ('56c4769ca3614db9ae4b0fa233c32309', '/console/sys_nav/list', 'list', '', '18d9973c3a2a45e5b31aeb0d670a4314');
INSERT INTO `sys_req_url` VALUES ('607de7ae66ae47cd95a6b2c152332178', '/console/sys_role/nav_accredit/{role_id}', 'nav_accredit', '', '01a1ac47f5c347fc874a71d52ea174d2');
INSERT INTO `sys_req_url` VALUES ('67d223f8adca446697533b20fd8a82e0', '/file/upload/ali/ue', 'uploadAliUe', '', '0a74190723774085851e1ec42857f41a');
INSERT INTO `sys_req_url` VALUES ('6a0388e22ddb48e38b9cb07627f5f945', '/console/sys_nav/delete', 'delete', '', '18d9973c3a2a45e5b31aeb0d670a4314');
INSERT INTO `sys_req_url` VALUES ('70284edc264a461ab15e872a9b87fb08', '/console/sys_user/list', 'list', '', '5294709f5971431a863dc3e06265020b');
INSERT INTO `sys_req_url` VALUES ('74332d5376cd4cf2a21fa70060e5a07e', '/console/sys_user/dochangepass', 'dochangepass', '', '5294709f5971431a863dc3e06265020b');
INSERT INTO `sys_req_url` VALUES ('7af5c601b1d8469f9c70a66e77834054', '/console/sys_role/nav_accredit/json/{role_id}/{sys_id}', 'nav_accreditJson', '', '01a1ac47f5c347fc874a71d52ea174d2');
INSERT INTO `sys_req_url` VALUES ('7b6988c32e1442a89c4dbfa6925f634a', '/console/sys_role/save', 'save', '', '01a1ac47f5c347fc874a71d52ea174d2');
INSERT INTO `sys_req_url` VALUES ('7f07688d6e75414092e2b33403845b36', '/console/sys_user/list/select', 'select', '', '5294709f5971431a863dc3e06265020b');
INSERT INTO `sys_req_url` VALUES ('85ecd98a7c56499694f9148504839fc5', '/console/sys_role/do_user_accredit/{user_id}', 'do_user_accredit', '', '01a1ac47f5c347fc874a71d52ea174d2');
INSERT INTO `sys_req_url` VALUES ('86a08b8ff39e44de812e76eae3bddde0', '/console/sys_nav/save', 'save', '', '18d9973c3a2a45e5b31aeb0d670a4314');
INSERT INTO `sys_req_url` VALUES ('8a1dbbefcb34492aa98a00746376673a', '/console/sys_role/user_accredit/{user_id}', 'user_accredit', '', '01a1ac47f5c347fc874a71d52ea174d2');
INSERT INTO `sys_req_url` VALUES ('8b24109b18cd4cc79fbe616cef7d64b4', '/console/sys_req_url/edit', 'edit', '', '4215a5e0b177468fb0a5e1f35bf8d1ca');
INSERT INTO `sys_req_url` VALUES ('8cff26ced4e4490784546ada92a5b851', '/console', 'index', '', 'ce68212e774f4a7199fc28f0748c7595');
INSERT INTO `sys_req_url` VALUES ('93ade75c771d43c199f838c9a2971463', '/console/sys_role/req_accredit/{role_id}', 'req_accredit', '', '01a1ac47f5c347fc874a71d52ea174d2');
INSERT INTO `sys_req_url` VALUES ('9514e0c7b3e543fb896a19cc29fd1538', '/console/sys_role/do_nav_accredit/{role_id}', 'do_nav_accredit', '', '01a1ac47f5c347fc874a71d52ea174d2');
INSERT INTO `sys_req_url` VALUES ('956cef87509b4cbe83803976bcb5bfdd', '/console/sys_nav/edit', 'edit', '', '18d9973c3a2a45e5b31aeb0d670a4314');
INSERT INTO `sys_req_url` VALUES ('9713950c31864659b172c77a720bab05', '/console/sys_role/add', 'add', '', '01a1ac47f5c347fc874a71d52ea174d2');
INSERT INTO `sys_req_url` VALUES ('a08a76f7bdd3467b9f141c7253dd3a6d', '/console/sys_role/do_req_accredit/{role_id}', 'do_req_accredit', '', '01a1ac47f5c347fc874a71d52ea174d2');
INSERT INTO `sys_req_url` VALUES ('a156c97de1ed45378ead500a78f31786', '/console/bo_cms_news/json', 'json', '', '5d514d2cd9e34c46a88c5fdbe65e14f6');
INSERT INTO `sys_req_url` VALUES ('a504cd421c1f40e3ba39997cc0a35197', '/console/sys_user/changepass', 'changepass', '', '5294709f5971431a863dc3e06265020b');
INSERT INTO `sys_req_url` VALUES ('ad2a12a319ce4d19ab9e53bf249ff62a', '/', 'main', '', 'ce68212e774f4a7199fc28f0748c7595');
INSERT INTO `sys_req_url` VALUES ('b098ec43bf4d40058c7bb359fbc43063', '/console/sys_req_url/save', 'save', '', '4215a5e0b177468fb0a5e1f35bf8d1ca');
INSERT INTO `sys_req_url` VALUES ('b3874d9fda2b4413a902fb9105226767', '/console/sys_user/base', 'base', '', '5294709f5971431a863dc3e06265020b');
INSERT INTO `sys_req_url` VALUES ('b438c0d46b7640778c09c9aa81613b16', '/console/sys_role/nav/json', 'navJson', '', '01a1ac47f5c347fc874a71d52ea174d2');
INSERT INTO `sys_req_url` VALUES ('b7bf1b26777b4b3593d59fa82cea3678', '/console/login', 'login', '', 'ce68212e774f4a7199fc28f0748c7595');
INSERT INTO `sys_req_url` VALUES ('b7d8d37d73d54d578ac86b2c463c0faf', '/console/bo_user/delete', 'delete', '', '3a24fe92db654250a9b4004f81ac057e');
INSERT INTO `sys_req_url` VALUES ('becca3a34b7b4e009efe03f52bda3d75', '/console/test/{fload}/user/a', 'testJson2', '', 'd0a105c8453a47208b3f2a1a22cabe9d');
INSERT INTO `sys_req_url` VALUES ('c1d93540373e4a04a44c97f69f55f59c', '/console/sys_req_url/list', 'list', '', '4215a5e0b177468fb0a5e1f35bf8d1ca');
INSERT INTO `sys_req_url` VALUES ('caa6fdf73c184d2488982b950d1524ed', '/console/bo_user/list', 'list', '', '3a24fe92db654250a9b4004f81ac057e');
INSERT INTO `sys_req_url` VALUES ('d23352c0e07a42d2bdad27d07c13dca3', '/console/bo_user/edit', 'edit', '', '3a24fe92db654250a9b4004f81ac057e');
INSERT INTO `sys_req_url` VALUES ('d5becd465bda411595ff8aab9475c039', '/console/sys_user/add', 'add', '', '5294709f5971431a863dc3e06265020b');
INSERT INTO `sys_req_url` VALUES ('db255c1c08c24f5b9adbd28612711f48', '/console/sys_req_url/delete', 'delete', '', '4215a5e0b177468fb0a5e1f35bf8d1ca');
INSERT INTO `sys_req_url` VALUES ('ece3ccbc3e3c476e934c3ef68503c070', '/console/sys_role/json', 'json', '', '01a1ac47f5c347fc874a71d52ea174d2');
INSERT INTO `sys_req_url` VALUES ('ed52f60b8ebc4aef82f1d548514ad939', '/console/bo_cms_news/add', 'add', '', '5d514d2cd9e34c46a88c5fdbe65e14f6');
INSERT INTO `sys_req_url` VALUES ('eebebf1378294cbca85aa8397cfa77bc', '/file/upload/ali', 'uploadAli', '', '0a74190723774085851e1ec42857f41a');
INSERT INTO `sys_req_url` VALUES ('ef055894ee3c4bf7b044d843904f4014', '/console/bo_cms_news/list', 'list', '', '5d514d2cd9e34c46a88c5fdbe65e14f6');
INSERT INTO `sys_req_url` VALUES ('ef8cb595eef84e4ea78ca39d0b68ca06', '/console/sys_role/req_accredit/json', 'req_accreditJson', '', '01a1ac47f5c347fc874a71d52ea174d2');
INSERT INTO `sys_req_url` VALUES ('f99893c0b4f6468e9368ebd100bec786', '/console/sys_role/edit', 'edit', '', '01a1ac47f5c347fc874a71d52ea174d2');
INSERT INTO `sys_req_url` VALUES ('fba75179c86c462e9cc441025224aecb', '/console/sys_role/delete', 'delete', '', '01a1ac47f5c347fc874a71d52ea174d2');
INSERT INTO `sys_req_url` VALUES ('fc3a904639ab44599fbd11609254317c', '/console/sys_user/save', 'save', '', '5294709f5971431a863dc3e06265020b');

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
INSERT INTO `sys_req_url_group` VALUES ('01a1ac47f5c347fc874a71d52ea174d2', 'zhang.lao.console.controller.zhang.lao.console.controller.SysRoleController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysRoleController');
INSERT INTO `sys_req_url_group` VALUES ('0a74190723774085851e1ec42857f41a', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.FileUpAndDown', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.FileUpAndDown');
INSERT INTO `sys_req_url_group` VALUES ('18d9973c3a2a45e5b31aeb0d670a4314', 'zhang.lao.console.controller.zhang.lao.console.controller.SysNavController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysNavController');
INSERT INTO `sys_req_url_group` VALUES ('3a24fe92db654250a9b4004f81ac057e', 'zhang.lao.console.controller.zhang.lao.console.controller.BoUserController', 'zhang.lao.console.controller.zhang.lao.console.controller.BoUserController');
INSERT INTO `sys_req_url_group` VALUES ('4215a5e0b177468fb0a5e1f35bf8d1ca', 'zhang.lao.console.controller.zhang.lao.console.controller.SysReqUrlController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysReqUrlController');
INSERT INTO `sys_req_url_group` VALUES ('5294709f5971431a863dc3e06265020b', 'zhang.lao.console.controller.zhang.lao.console.controller.SysUserController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysUserController');
INSERT INTO `sys_req_url_group` VALUES ('5d514d2cd9e34c46a88c5fdbe65e14f6', 'zhang.lao.console.controller.zhang.lao.console.controller.BoCmsNewsController', 'zhang.lao.console.controller.zhang.lao.console.controller.BoCmsNewsController');
INSERT INTO `sys_req_url_group` VALUES ('828e9690d5374b2abc74d6285f3e0f02', 'zhang.lao.console.controller.nav.zhang.lao.console.controller.nav.PageTurnController', 'zhang.lao.console.controller.nav.zhang.lao.console.controller.nav.PageTurnController');
INSERT INTO `sys_req_url_group` VALUES ('a4aac22f7a314c9d90feb8a4b1180c04', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.SelectCommontController', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.SelectCommontController');
INSERT INTO `sys_req_url_group` VALUES ('b41ba388fdf74158926a17c616bdf5c4', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.HtmlTableToExcel', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.HtmlTableToExcel');
INSERT INTO `sys_req_url_group` VALUES ('ce68212e774f4a7199fc28f0748c7595', 'zhang.lao.console.controller.login.zhang.lao.console.controller.login.LoginController', 'zhang.lao.console.controller.login.zhang.lao.console.controller.login.LoginController');
INSERT INTO `sys_req_url_group` VALUES ('d0a105c8453a47208b3f2a1a22cabe9d', 'zhang.lao.console.controller.zhang.lao.console.controller.TestController', 'zhang.lao.console.controller.zhang.lao.console.controller.TestController');
INSERT INTO `sys_req_url_group` VALUES ('e90cfd5f88b84ae0b984b11a89a2a769', 'zhang.lao.console.controller.common.captcha.zhang.lao.console.controller.common.captcha.CaptchaController', 'zhang.lao.console.controller.common.captcha.zhang.lao.console.controller.common.captcha.CaptchaController');

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
INSERT INTO `sys_req_url_role` VALUES ('0166ce502d39499aac0f0d9c4b5b2cc4', '1', '/console/sys_req_url/delete');
INSERT INTO `sys_req_url_role` VALUES ('07d4f895a62444e6885c74bf60d178f6', '1', '/console/sys_req_url/edit');
INSERT INTO `sys_req_url_role` VALUES ('0a92421391664c4187e54149d3c40fbb', '1', '/console/sys_role/do_nav_accredit/{role_id}');
INSERT INTO `sys_req_url_role` VALUES ('1a33c701bc9148799122475190e6adc6', '1', '/console/sys_role/nav/json');
INSERT INTO `sys_req_url_role` VALUES ('1c1c2bc25dce492480c48935bfa6b21e', '1', '/console/sys_user/list');
INSERT INTO `sys_req_url_role` VALUES ('217ad62db73648a69881760c57261f71', '1', '/console/sys_user/save');
INSERT INTO `sys_req_url_role` VALUES ('281ae9cd5e844310a3d3adf880823c62', '1', '/console/sys_role/nav_accredit/json/{role_id}/{sys_id}');
INSERT INTO `sys_req_url_role` VALUES ('28cafa239e6c4e2787585a89339553f4', '1', '/console/sys_req_url/init');
INSERT INTO `sys_req_url_role` VALUES ('2efa3165a8e841f797cb4157d0950853', '1', '/console/sys_role/');
INSERT INTO `sys_req_url_role` VALUES ('2f696315b3614ca38928790541d82a5d', '1', '/console/sys_role/edit');
INSERT INTO `sys_req_url_role` VALUES ('3b2c7d5faa9745eb9d5ae66f88ab420e', '1', '/console/sys_user/delete');
INSERT INTO `sys_req_url_role` VALUES ('3dd7a9351c854f93928b59e8bea091a8', '1', '/console/sys_role/nav_accredit/{role_id}');
INSERT INTO `sys_req_url_role` VALUES ('42f517fbc3ac4b03a65bcfc2dbdb9617', '1', '/console/sys_nav/delete');
INSERT INTO `sys_req_url_role` VALUES ('439d2b53efca4341ad9d9403962655f0', 'b944043e1c064c9cbeaef09d0103d4a5', '/console/{test}/fload/user/a');
INSERT INTO `sys_req_url_role` VALUES ('492b8959c8f34748bd39788bacc4ceb6', '1', '/console/sys_nav/edit');
INSERT INTO `sys_req_url_role` VALUES ('4c116472eebb4cb7bbd23cad20f76cf2', '1', '/console/sys_req_url/');
INSERT INTO `sys_req_url_role` VALUES ('4e70b9a1c0dd4165b5655fb9f7e446ce', '1', '/console/sys_req_url/save');
INSERT INTO `sys_req_url_role` VALUES ('5727022bb6934180bd0ed5b7f74e00fd', '1', '/console/sys_role/user_accredit/{user_id}');
INSERT INTO `sys_req_url_role` VALUES ('5896c65698eb42ea9c7285cb71913ef1', '1', '/console/sys_user/');
INSERT INTO `sys_req_url_role` VALUES ('6733b247b59d454093dd88c956ebabca', '1', '/console/sys_nav/json');
INSERT INTO `sys_req_url_role` VALUES ('6e166a3fb1494fe2827aaaadaee97a6f', '1', '/console/sys_nav/add');
INSERT INTO `sys_req_url_role` VALUES ('7a28d31d00a64c1081e642e25ac92cd3', '1', '/console/sys_role/save');
INSERT INTO `sys_req_url_role` VALUES ('84eb82991e654324a28aa8af57312720', '1', '/console/sys_nav/save');
INSERT INTO `sys_req_url_role` VALUES ('8931c4369d3f4ecc8e4351bfb1af98fa', '1', '/console/sys_role/delete');
INSERT INTO `sys_req_url_role` VALUES ('89a294f0dbc346f9ad88d0f4195fd674', '1', '/console/sys_role/req_accredit/{role_id}');
INSERT INTO `sys_req_url_role` VALUES ('8ae4e426ee184ccda8128e1f195b13e8', '1', '/console/sys_role/do_req_accredit/{role_id}');
INSERT INTO `sys_req_url_role` VALUES ('9e7815b028f64575b784c590191d44e5', '1', '/console/select/');
INSERT INTO `sys_req_url_role` VALUES ('a3bcb3ad310e4119b15bd44cb316f876', '1', '/console/sys_role/list');
INSERT INTO `sys_req_url_role` VALUES ('a4cf6f567b1c4be49b9b1d2f35133373', '1', '/console/sys_role/do_user_accredit/{user_id}');
INSERT INTO `sys_req_url_role` VALUES ('a6bff7453cca471aa77778eb789b521e', '1', '/console/sys_user/base');
INSERT INTO `sys_req_url_role` VALUES ('add6ad32c3b0495aab625d052f72c8de', '1', '/console/sys_nav/');
INSERT INTO `sys_req_url_role` VALUES ('af527f48d4624207ae361525b354e465', '1', '/console/sys_role/req/group/json');
INSERT INTO `sys_req_url_role` VALUES ('b38618e6f5394466a6cffe76d6190f73', '1', '/console/select/json');
INSERT INTO `sys_req_url_role` VALUES ('b4d6f4a1307846aca75da77c60c9a67e', '1', '/console/sys_user/json');
INSERT INTO `sys_req_url_role` VALUES ('bbbdd37ac92e46e88fef5104f9600d25', '1', '/console/sys_nav/list');
INSERT INTO `sys_req_url_role` VALUES ('bc2fadd38c864250a4056196ef8df226', '1', '/console/sys_req_url/json');
INSERT INTO `sys_req_url_role` VALUES ('c25e443429a14b6ca698d27ec5669434', 'b944043e1c064c9cbeaef09d0103d4a5', '/console/test/{fload}/user/a');
INSERT INTO `sys_req_url_role` VALUES ('cf9492c96a1546218b7e57da323d411a', '1', '/console/sys_role/req_accredit/json');
INSERT INTO `sys_req_url_role` VALUES ('d03fb35b850e4f98a3dda7972e149f4b', 'b944043e1c064c9cbeaef09d0103d4a5', 'zhang.lao.console.controller.zhang.lao.console.controller.TestController');
INSERT INTO `sys_req_url_role` VALUES ('d8a28f26263443f68ed061b93e269c7c', '1', '/console/sys_user/dochangepass');
INSERT INTO `sys_req_url_role` VALUES ('df5aa5d6561a49588d04c388c159310c', '1', '/console/sys_user/changepass');
INSERT INTO `sys_req_url_role` VALUES ('ee8fe5277b85420cb988a2863faae846', '1', '/console/sys_user/add');
INSERT INTO `sys_req_url_role` VALUES ('ef0c2859c4aa439c810ae235e4d73983', '1', '/console/sys_role/add');
INSERT INTO `sys_req_url_role` VALUES ('f22e7fd2fed54c6398f1d9c5e26082f3', '1', '/console/sys_req_url/add');
INSERT INTO `sys_req_url_role` VALUES ('f3df8512a2dc4e62b139265ada574fef', '1', '/console/sys_role/json');
INSERT INTO `sys_req_url_role` VALUES ('f98a13a46bfb4ac2aaf931d6c569ffaf', '1', '/console/sys_user/list/select');
INSERT INTO `sys_req_url_role` VALUES ('fc239df89f774cd0803afa5de967cf34', '1', '/console/sys_user/edit');
INSERT INTO `sys_req_url_role` VALUES ('feb1531f073f4f6ab5d6d7da6cbb234c', '1', '/console/sys_req_url/list');

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
INSERT INTO `sys_role` VALUES ('b944043e1c064c9cbeaef09d0103d4a5', '普通用户', '1', '0', '2017-08-21 15:12:48');

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
INSERT INTO `sys_user` VALUES ('1', '张钦2', 'e10adc3949ba59abbe56e057f20f883e', '\\upload\\20170524\\86806213013314.png', '18210178959', '492297036@qq.com', null, null, '1', '1', null, '1', '1', 'admin');
INSERT INTO `sys_user` VALUES ('7047f9c8c825498f83d2048c92463cb6', 'test', 'e10adc3949ba59abbe56e057f20f883e', null, 'test', 'test', null, null, null, null, null, '1', '2', null);

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
INSERT INTO `sys_user_role` VALUES ('4e1395fa9832463197646ea0dffad8de', '7047f9c8c825498f83d2048c92463cb6', 'b944043e1c064c9cbeaef09d0103d4a5');
