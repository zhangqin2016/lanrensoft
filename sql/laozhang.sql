/*
Navicat MySQL Data Transfer

Source Server         : benji
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : laozhang

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-08-25 19:10:46
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
INSERT INTO `sys_req_url` VALUES ('00714ba813b14a68b8f4381d5aa36bd9', '/console/sys_role/nav_accredit/json/{role_id}/{sys_id}', 'nav_accreditJson', '', 'd2aa83013cb24246b622b50f2dc0d03d');
INSERT INTO `sys_req_url` VALUES ('03c9ab3eea5440af979f4dba70363b97', '/console/sys_nav/json', 'json', '', '277450947e914448a830e53066c95e9c');
INSERT INTO `sys_req_url` VALUES ('0642fb9563bb49ebac53399f1b122b78', '/console/bo_cms_news/json', 'json', '', '9eec0587294b4d25b0b06b9ea3513b5b');
INSERT INTO `sys_req_url` VALUES ('072988fadc74427199052e4eb7b8f907', '/console/sys_user/list', 'list', '', '6daa649c9d7c40079ebe7fcba5f3fcda');
INSERT INTO `sys_req_url` VALUES ('0b1176417d8b4375af8103f3d97b2a17', '/console/sys_role/delete', 'delete', '', 'd2aa83013cb24246b622b50f2dc0d03d');
INSERT INTO `sys_req_url` VALUES ('0cea95c883d64047b84a92f80ed9c373', '/console/sys_req_url/list', 'list', '', '19b84fbd9cc5438a822be3d590e22bea');
INSERT INTO `sys_req_url` VALUES ('1394311474784aaf9be9352676493ce8', '/console/sys_req_url/save', 'save', '', '19b84fbd9cc5438a822be3d590e22bea');
INSERT INTO `sys_req_url` VALUES ('218c2903478a4ebfb3815551891eb728', '/console/sys_nav/delete', 'delete', '', '277450947e914448a830e53066c95e9c');
INSERT INTO `sys_req_url` VALUES ('21a4531eb33249c497c6a607e80d3ceb', '/console/sys_role/edit', 'edit', '', 'd2aa83013cb24246b622b50f2dc0d03d');
INSERT INTO `sys_req_url` VALUES ('236d4211b53e49b08d9018980730926f', '/console/sys_nav/save', 'save', '', '277450947e914448a830e53066c95e9c');
INSERT INTO `sys_req_url` VALUES ('2401679ee3224910b96dac823470bb78', '/console/sys_role/req/group/json', 'reqGroupJson', '', 'd2aa83013cb24246b622b50f2dc0d03d');
INSERT INTO `sys_req_url` VALUES ('25cc1e95bcc8406c83bd897797d42dd9', '/console/sys_user/edit', 'edit', '', '6daa649c9d7c40079ebe7fcba5f3fcda');
INSERT INTO `sys_req_url` VALUES ('27679d0c83aa4e7cad13713d7055be51', '/console/sys_req_url/json', 'json', '', '19b84fbd9cc5438a822be3d590e22bea');
INSERT INTO `sys_req_url` VALUES ('2df73b0edee8471da280d65cd8cf2457', '/console/login', 'login', '', 'be2708664bd84b70aba386dc232be4bd');
INSERT INTO `sys_req_url` VALUES ('2e8b5d973b8c40fdb4b8439d59ee826a', '/console/sys_role/do_nav_accredit/{role_id}', 'do_nav_accredit', '', 'd2aa83013cb24246b622b50f2dc0d03d');
INSERT INTO `sys_req_url` VALUES ('2fd95d65c4f140728dbcebc56b1a8536', '/console/bo_cms_news/edit', 'edit', '', '9eec0587294b4d25b0b06b9ea3513b5b');
INSERT INTO `sys_req_url` VALUES ('3447e62379e241659f34c209277d6aab', '/common/captcha/get/{id}', 'getCaptchaImage', '', 'fb7c17cc2ce84ffea9a748e72377d635');
INSERT INTO `sys_req_url` VALUES ('34e7552e9c8841c7bff7711fb3478427', '/console/sys_user/dochangepass', 'dochangepass', '', '6daa649c9d7c40079ebe7fcba5f3fcda');
INSERT INTO `sys_req_url` VALUES ('3827c2bd26634752a23e41f7f997853a', '/console/sys_role/save', 'save', '', 'd2aa83013cb24246b622b50f2dc0d03d');
INSERT INTO `sys_req_url` VALUES ('45e710c564b149b592083fbeb31aa67c', '/console/sys_nav/list', 'list', '', '277450947e914448a830e53066c95e9c');
INSERT INTO `sys_req_url` VALUES ('49b33b7f3d904086861b9fef8c2db6bc', '/file/upload', 'upload', '', 'c25661d6f7c2448982ccd50e31b64e82');
INSERT INTO `sys_req_url` VALUES ('4b539f0972b24f3ea14a373ed0b43458', '/console/sys_user/add', 'add', '', '6daa649c9d7c40079ebe7fcba5f3fcda');
INSERT INTO `sys_req_url` VALUES ('4e6e5bd6ca9b4dff9dd5155a6a06bfce', '/console/bo_user/list', 'list', '', '9538f24743c64407953afd8532706088');
INSERT INTO `sys_req_url` VALUES ('4e7330cf878b4e35a2b1326db9b99c9a', '/console/sys_req_url/add', 'add', '', '19b84fbd9cc5438a822be3d590e22bea');
INSERT INTO `sys_req_url` VALUES ('500ef572fe0b48bf9b742b52a7986571', '/console/nav/trun/first', 'getNavFirstReturn', '', 'd891335303514f078f12baa05967961d');
INSERT INTO `sys_req_url` VALUES ('51a70f08f24b4090be2af4c99d502228', '/console/sys_role/req_accredit/json', 'req_accreditJson', '', 'd2aa83013cb24246b622b50f2dc0d03d');
INSERT INTO `sys_req_url` VALUES ('58ef41b5d07a4f3aa3d4c85c93354f6b', '/console/sys_role/json', 'json', '', 'd2aa83013cb24246b622b50f2dc0d03d');
INSERT INTO `sys_req_url` VALUES ('655002064d5d411897b1dfc1c760830a', '/console/bo_cms_news/list', 'list', '', '9eec0587294b4d25b0b06b9ea3513b5b');
INSERT INTO `sys_req_url` VALUES ('68be6b61d6524fb4832b1d9e5f9f655f', '/console/bo_cms_news/add', 'add', '', '9eec0587294b4d25b0b06b9ea3513b5b');
INSERT INTO `sys_req_url` VALUES ('6c58a5896b0446e49739b3ae687702a9', '/file/upload/ali', 'uploadAli', '', 'c25661d6f7c2448982ccd50e31b64e82');
INSERT INTO `sys_req_url` VALUES ('6ddc004547d14238b95f59d2371951ac', '/console/sys_role/nav/json', 'navJson', '', 'd2aa83013cb24246b622b50f2dc0d03d');
INSERT INTO `sys_req_url` VALUES ('744833e53a7f4ec4baf57507633e6355', '/console/sys_user/save', 'save', '', '6daa649c9d7c40079ebe7fcba5f3fcda');
INSERT INTO `sys_req_url` VALUES ('79bd59921d0c425e980b86d53d9c09d2', '/console/{test}/fload/user/a', 'testJson', '', '679db28033d748dd87512c64398e9d02');
INSERT INTO `sys_req_url` VALUES ('7b3357257103463d9144000089413d55', '/console/bo_user/edit', 'edit', '', '9538f24743c64407953afd8532706088');
INSERT INTO `sys_req_url` VALUES ('7c0b650fe55647828fc564fb11ad3f0f', '/console/bo_user/save', 'save', '', '9538f24743c64407953afd8532706088');
INSERT INTO `sys_req_url` VALUES ('7d67dac0cc084c83b27e03accf775a33', '/console/sys_role/do_req_accredit/{role_id}', 'do_req_accredit', '', 'd2aa83013cb24246b622b50f2dc0d03d');
INSERT INTO `sys_req_url` VALUES ('7e9ec6f2b8914e1ebed76d28dda29ab4', '/console/select/json', 'json', '', '8845193114774bce91808bce273ee85f');
INSERT INTO `sys_req_url` VALUES ('836519ca404c46a2bb5b1de743ea71be', '/console/sys_user/list/select', 'select', '', '6daa649c9d7c40079ebe7fcba5f3fcda');
INSERT INTO `sys_req_url` VALUES ('8d7af795bbd944be987c516152b6a638', '/console/sys_role/list', 'list', '', 'd2aa83013cb24246b622b50f2dc0d03d');
INSERT INTO `sys_req_url` VALUES ('964f0e9fa3ef48309b0547b083c6a319', '/console/sys_role/clear/role/req', 'clearReq', '', 'd2aa83013cb24246b622b50f2dc0d03d');
INSERT INTO `sys_req_url` VALUES ('979fc4cb2a5b4e5f91c367d0734863e2', '/console/sys_user/json', 'json', '', '6daa649c9d7c40079ebe7fcba5f3fcda');
INSERT INTO `sys_req_url` VALUES ('a274947ab26e4f7ba114c56680cdaffe', '/console/sys_role/user_accredit/{user_id}', 'user_accredit', '', 'd2aa83013cb24246b622b50f2dc0d03d');
INSERT INTO `sys_req_url` VALUES ('a35456972c3540789276a89ca80e1820', '/console/sys_user/delete', 'delete', '', '6daa649c9d7c40079ebe7fcba5f3fcda');
INSERT INTO `sys_req_url` VALUES ('a7f3835afbfa41829d0707aa1879fbcf', '/console/sys_role/clear/role/nav', 'clearNav', '', 'd2aa83013cb24246b622b50f2dc0d03d');
INSERT INTO `sys_req_url` VALUES ('ab59f0f9192c46f7807f48c85383f741', '/console/test/{fload}/user/a', 'testJson2', '', '679db28033d748dd87512c64398e9d02');
INSERT INTO `sys_req_url` VALUES ('ac1d8d6171184b108afc4acaa920fdf0', '/console/sys_user/base', 'base', '', '6daa649c9d7c40079ebe7fcba5f3fcda');
INSERT INTO `sys_req_url` VALUES ('b18e5118dad94774a39ee5439cea1633', '/console/sys_req_url/edit', 'edit', '', '19b84fbd9cc5438a822be3d590e22bea');
INSERT INTO `sys_req_url` VALUES ('b8c961f3d2d847ebb831811b7ba109de', '/console/bo_cms_news/delete', 'delete', '', '9eec0587294b4d25b0b06b9ea3513b5b');
INSERT INTO `sys_req_url` VALUES ('b95c46ef98b04b07a554efce7ddd5aba', '/console/sys_role/do_user_accredit/{user_id}', 'do_user_accredit', '', 'd2aa83013cb24246b622b50f2dc0d03d');
INSERT INTO `sys_req_url` VALUES ('c1ba143836cc4c3ea88e919ef3bba4a0', '/file/upload/ali/ue', 'uploadAliUe', '', 'c25661d6f7c2448982ccd50e31b64e82');
INSERT INTO `sys_req_url` VALUES ('c225fe9d9ad6467aab2f5445a51bcce4', '/', 'main', '', 'be2708664bd84b70aba386dc232be4bd');
INSERT INTO `sys_req_url` VALUES ('c3d501ed17994b55bbd979328ba804bb', '/console/bo_user/add', 'add', '', '9538f24743c64407953afd8532706088');
INSERT INTO `sys_req_url` VALUES ('c6526ca1b5bb487d9a3fbeb3c691377e', '/console', 'index', '', 'be2708664bd84b70aba386dc232be4bd');
INSERT INTO `sys_req_url` VALUES ('c8d58de95897483da1ccabf7b389422b', '/console/sys_role/req_accredit/{role_id}', 'req_accredit', '', 'd2aa83013cb24246b622b50f2dc0d03d');
INSERT INTO `sys_req_url` VALUES ('c9507b88e9ea40ca8dc97f3b499b0681', '/console/sys_nav/edit', 'edit', '', '277450947e914448a830e53066c95e9c');
INSERT INTO `sys_req_url` VALUES ('cc4bcc33782048a581b68d3ffa1b46bd', '/console/logout', 'logout', '', 'be2708664bd84b70aba386dc232be4bd');
INSERT INTO `sys_req_url` VALUES ('d92fb4bb809a4ba1af39e3e7918fb38d', '/console/bo_cms_news/save', 'save', '', '9eec0587294b4d25b0b06b9ea3513b5b');
INSERT INTO `sys_req_url` VALUES ('d9d69a60ffac48069effa92a9e3c8f60', '/console/sys_user/changepass', 'changepass', '', '6daa649c9d7c40079ebe7fcba5f3fcda');
INSERT INTO `sys_req_url` VALUES ('da21cd9e944d4fa1b981021d06445e37', '/console/bo_user/delete', 'delete', '', '9538f24743c64407953afd8532706088');
INSERT INTO `sys_req_url` VALUES ('daec25ce8b8143659125da9f472ccdc5', '/console/sys_role/nav_accredit/{role_id}', 'nav_accredit', '', 'd2aa83013cb24246b622b50f2dc0d03d');
INSERT INTO `sys_req_url` VALUES ('dc3335b210184d7aa0f186f8f7d67597', '/console/sys_nav/add', 'add', '', '277450947e914448a830e53066c95e9c');
INSERT INTO `sys_req_url` VALUES ('e13d50002d8e4ce682dbb15f94784eca', '/console/sys_req_url/delete', 'delete', '', '19b84fbd9cc5438a822be3d590e22bea');
INSERT INTO `sys_req_url` VALUES ('edb2b8ec27b44fb1a5ca43f90a51815b', '/console/export/excel', 'exportExcel', '', '29f730845f2b468ca2cdb5814772296f');
INSERT INTO `sys_req_url` VALUES ('f71a2b151f324cde953ce36aa5437460', '/console/bo_user/json', 'json', '', '9538f24743c64407953afd8532706088');
INSERT INTO `sys_req_url` VALUES ('fce47f011b6b42f58f432dc2a7ce5b93', '/console/sys_role/add', 'add', '', 'd2aa83013cb24246b622b50f2dc0d03d');

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
INSERT INTO `sys_req_url_group` VALUES ('19b84fbd9cc5438a822be3d590e22bea', 'zhang.lao.console.controller.zhang.lao.console.controller.SysReqUrlController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysReqUrlController');
INSERT INTO `sys_req_url_group` VALUES ('277450947e914448a830e53066c95e9c', 'zhang.lao.console.controller.zhang.lao.console.controller.SysNavController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysNavController');
INSERT INTO `sys_req_url_group` VALUES ('29f730845f2b468ca2cdb5814772296f', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.HtmlTableToExcel', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.HtmlTableToExcel');
INSERT INTO `sys_req_url_group` VALUES ('679db28033d748dd87512c64398e9d02', 'zhang.lao.console.controller.zhang.lao.console.controller.TestController', 'zhang.lao.console.controller.zhang.lao.console.controller.TestController');
INSERT INTO `sys_req_url_group` VALUES ('6daa649c9d7c40079ebe7fcba5f3fcda', 'zhang.lao.console.controller.zhang.lao.console.controller.SysUserController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysUserController');
INSERT INTO `sys_req_url_group` VALUES ('8845193114774bce91808bce273ee85f', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.SelectCommontController', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.SelectCommontController');
INSERT INTO `sys_req_url_group` VALUES ('9538f24743c64407953afd8532706088', 'zhang.lao.console.controller.zhang.lao.console.controller.BoUserController', 'zhang.lao.console.controller.zhang.lao.console.controller.BoUserController');
INSERT INTO `sys_req_url_group` VALUES ('9eec0587294b4d25b0b06b9ea3513b5b', 'zhang.lao.console.controller.zhang.lao.console.controller.BoCmsNewsController', 'zhang.lao.console.controller.zhang.lao.console.controller.BoCmsNewsController');
INSERT INTO `sys_req_url_group` VALUES ('be2708664bd84b70aba386dc232be4bd', 'zhang.lao.console.controller.login.zhang.lao.console.controller.login.LoginController', 'zhang.lao.console.controller.login.zhang.lao.console.controller.login.LoginController');
INSERT INTO `sys_req_url_group` VALUES ('c25661d6f7c2448982ccd50e31b64e82', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.FileUpAndDown', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.FileUpAndDown');
INSERT INTO `sys_req_url_group` VALUES ('d2aa83013cb24246b622b50f2dc0d03d', 'zhang.lao.console.controller.zhang.lao.console.controller.SysRoleController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysRoleController');
INSERT INTO `sys_req_url_group` VALUES ('d891335303514f078f12baa05967961d', 'zhang.lao.console.controller.nav.zhang.lao.console.controller.nav.PageTurnController', 'zhang.lao.console.controller.nav.zhang.lao.console.controller.nav.PageTurnController');
INSERT INTO `sys_req_url_group` VALUES ('fb7c17cc2ce84ffea9a748e72377d635', 'zhang.lao.console.controller.common.captcha.zhang.lao.console.controller.common.captcha.CaptchaController', 'zhang.lao.console.controller.common.captcha.zhang.lao.console.controller.common.captcha.CaptchaController');

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
