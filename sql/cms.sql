/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : cms

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2017-09-08 07:14:26
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
-- Table structure for bo_app_banner
-- ----------------------------
DROP TABLE IF EXISTS `bo_app_banner`;
CREATE TABLE `bo_app_banner` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `title` varchar(512) NOT NULL COMMENT 'Banner题目',
  `banner_img` varchar(1024) NOT NULL COMMENT 'banner图片_img',
  `target` varchar(1024) DEFAULT NULL COMMENT '目标地址',
  `target_type` int(1) DEFAULT NULL COMMENT '跳转类型_select_1:页面',
  `type` varchar(32) DEFAULT NULL COMMENT 'Banner类型_select_1:首页',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `status` int(1) DEFAULT '1' COMMENT '状态_radio_0:禁用|1:可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Banner轮播';

-- ----------------------------
-- Records of bo_app_banner
-- ----------------------------
INSERT INTO `bo_app_banner` VALUES ('98aa988726d4499f8183ace7bd04beb5', '1', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/43716170862084.jpg', '1', '1', 'index', null, '1', '1');
INSERT INTO `bo_app_banner` VALUES ('d0dcb835c5a14c3285c30a8434190c98', '测试', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/43728175394012.jpg', 'http://www.baidu.com', '1', 'index', null, '1', '1');

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
-- Table structure for bo_progect_around
-- ----------------------------
DROP TABLE IF EXISTS `bo_progect_around`;
CREATE TABLE `bo_progect_around` (
  `id` varchar(32) NOT NULL,
  `project_id` varchar(32) DEFAULT NULL COMMENT '项目',
  `name` varchar(32) DEFAULT NULL COMMENT '图片地址_img',
  `info_image` varchar(1024) DEFAULT NULL COMMENT '图片_img',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目图集';

-- ----------------------------
-- Records of bo_progect_around
-- ----------------------------

-- ----------------------------
-- Table structure for bo_progect_goods_images
-- ----------------------------
DROP TABLE IF EXISTS `bo_progect_goods_images`;
CREATE TABLE `bo_progect_goods_images` (
  `id` varchar(32) NOT NULL,
  `goods_id` varchar(32) DEFAULT NULL COMMENT '项目',
  `image_url` varchar(1024) DEFAULT NULL COMMENT '图片地址_img',
  `image_name` varchar(255) DEFAULT NULL COMMENT '图片名称',
  `image_type` varchar(255) DEFAULT NULL COMMENT '图片类型_dic_progect_img_type',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目图集';

-- ----------------------------
-- Records of bo_progect_goods_images
-- ----------------------------

-- ----------------------------
-- Table structure for bo_progect_images
-- ----------------------------
DROP TABLE IF EXISTS `bo_progect_images`;
CREATE TABLE `bo_progect_images` (
  `id` varchar(32) NOT NULL,
  `project_id` varchar(32) DEFAULT NULL COMMENT '项目',
  `image_url` varchar(1024) DEFAULT NULL COMMENT '图片地址_img',
  `image_name` varchar(255) DEFAULT NULL COMMENT '图片名称',
  `image_type` varchar(255) DEFAULT NULL COMMENT '图片类型_dic_progect_img_type',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目图集';

-- ----------------------------
-- Records of bo_progect_images
-- ----------------------------

-- ----------------------------
-- Table structure for bo_project
-- ----------------------------
DROP TABLE IF EXISTS `bo_project`;
CREATE TABLE `bo_project` (
  `id` varchar(32) NOT NULL,
  `type` varchar(22) DEFAULT NULL COMMENT '项目类型_select_1:产权|2:股权|3:租售',
  `self_build` varchar(11) DEFAULT NULL COMMENT '是否是自营_radio_1:是|2:否',
  `title` varchar(32) DEFAULT NULL COMMENT '名称',
  `project_developers` varchar(56) DEFAULT NULL COMMENT '开发商',
  `project_into` date DEFAULT NULL COMMENT '入住时间',
  `projrct_manager` varchar(255) DEFAULT NULL COMMENT '物业',
  `project_estate` int(11) DEFAULT NULL COMMENT '产权',
  `province` varchar(255) DEFAULT NULL COMMENT '省份',
  `city` varchar(255) DEFAULT NULL COMMENT '城市',
  `country` varchar(255) DEFAULT NULL COMMENT '县',
  `address` varchar(1024) DEFAULT NULL COMMENT '地址',
  `decoration_leave` varchar(255) DEFAULT NULL COMMENT '装修_dic_decoration_leave',
  `image_cover` varchar(1024) DEFAULT NULL COMMENT '图片介绍_img',
  `state` int(1) DEFAULT NULL COMMENT '状态_radio_1:可用|0:不可用',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='地产项目';

-- ----------------------------
-- Records of bo_project
-- ----------------------------
INSERT INTO `bo_project` VALUES ('6c620c93dd054e16aad0563ab7625dee', '1', '1', '2', '2', '2017-09-07', '2', '2', '2', '2', '2', '2', '顶级', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/42743338631437.jpg', '1', '1');

-- ----------------------------
-- Table structure for bo_project_goods
-- ----------------------------
DROP TABLE IF EXISTS `bo_project_goods`;
CREATE TABLE `bo_project_goods` (
  `id` varchar(32) NOT NULL,
  `title` varchar(32) DEFAULT NULL COMMENT '名称',
  `build_area` decimal(11,2) DEFAULT NULL COMMENT '建筑面积',
  `equity_price` decimal(11,2) DEFAULT NULL COMMENT '产权价',
  `admin_price` decimal(11,2) DEFAULT NULL COMMENT '会员价',
  `detail` text COMMENT '详情',
  `image_cover` varchar(1024) DEFAULT NULL COMMENT '图片介绍',
  `tag` varchar(255) DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='地产项目商品';

-- ----------------------------
-- Records of bo_project_goods
-- ----------------------------

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
INSERT INTO `sys_dictionary` VALUES ('00177ee3eb404573935ce7de873c9607', 'decoration_leave', '顶级', '顶级', '顶级', '0');

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
INSERT INTO `sys_file` VALUES ('45300b4230de4d0291cdbb610444f62b', '4.jpg', '.jpg', '1080', '1920', '681469', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/43728175394012.jpg', '2017-09-07 23:19:49', '0', null);
INSERT INTO `sys_file` VALUES ('b8e71a8466654a5f8796663303cf15ec', '001.jpg', '.jpg', '1200', '1920', '1541350', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/43716170862084.jpg', '2017-09-07 23:19:37', '0', null);
INSERT INTO `sys_file` VALUES ('c2778ae74522427289dfae9895edc4e0', '4.jpg', '.jpg', '1080', '1920', '681469', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/42743338631437.jpg', '2017-09-07 23:03:24', '0', null);
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
INSERT INTO `sys_nav` VALUES ('2ad9f796ff1a41df9f50aee6c0f87830', '装饰等级', '/console/sys_dictionary/list/decoration_leave', '_self', 'glyphicon glyphicon-th-list', '5', 'dd6150b4f57c42979a0e8fc8d5600a54', '1', 'e496063d08c34562a89670e16648c8b3', '2', null);
INSERT INTO `sys_nav` VALUES ('2eb1bb8803ad4d2996d1d1ea3591f75b', '轮播管理', '/console/bo_app_banner/list/index', '_self', 'glyphicon glyphicon-picture', '3', 'dd6150b4f57c42979a0e8fc8d5600a54', '1', '7709fd6902014372925ed2d5d27c0618', '2', null);
INSERT INTO `sys_nav` VALUES ('7bed0648d96e486a956ac729023c1e13', '用户管理', '/console/bo_user/list', '_self', 'glyphicon glyphicon-user', '2', 'e62bf1dd57a44ffa9f4e763d1c89911e', '1', 'c5f9f03781c54bc781d1f129d30c3bb7', '2', null);
INSERT INTO `sys_nav` VALUES ('b1d0e2d0e7e5439595ee25aed5ab5baa', '新闻列表', '/console/bo_cms_news/list', '_main', 'glyphicon glyphicon-road', '4', 'e0fed8124cae460ab481b45ede61e2b0', '1', 'c91a638248c948568927dba7c9fc079b', '3', null);
INSERT INTO `sys_nav` VALUES ('dd6150b4f57c42979a0e8fc8d5600a54', '项目管理', '/1', '_self', 'glyphicon glyphicon-star', '2', '0', '1', '7583f9f08cc14d69ab495da6783c4e22', '1', null);
INSERT INTO `sys_nav` VALUES ('e0fed8124cae460ab481b45ede61e2b0', '新闻管理', '/', '_main', 'glyphicon glyphicon-picture', '2', 'e62bf1dd57a44ffa9f4e763d1c89911e', '1', 'f6183183046745508fcf5a98eb1f7a7b', '2', null);
INSERT INTO `sys_nav` VALUES ('e62bf1dd57a44ffa9f4e763d1c89911e', 'CMS管理', '/', '_main', 'glyphicon glyphicon-globe', '2', '0', '0', 'a2ba244d349b443985646086f128cddf', '1', null);
INSERT INTO `sys_nav` VALUES ('e8d9a555235549689892a0e474191354', '项目管理', '/console/bo_project/list', '_self', 'glyphicon glyphicon-th', '1', 'dd6150b4f57c42979a0e8fc8d5600a54', '1', '1220210e800a4afe8a158e78114f7466', '2', null);

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
INSERT INTO `sys_nav_role` VALUES ('034f5ae84dc14c348b2c2d68b9c63b1a', '23', '1');
INSERT INTO `sys_nav_role` VALUES ('1c295e96628f48f7ad1e3c101db32bdf', 'b1d0e2d0e7e5439595ee25aed5ab5baa', '1');
INSERT INTO `sys_nav_role` VALUES ('2d0daa77f00f4d339e1610c70e0c50aa', '18', '1');
INSERT INTO `sys_nav_role` VALUES ('49341c2ace9948d29e754026d6e7a72d', 'dd6150b4f57c42979a0e8fc8d5600a54', '1');
INSERT INTO `sys_nav_role` VALUES ('53d71a76e93e4eaaad32577ef1d2fba2', '24', '1');
INSERT INTO `sys_nav_role` VALUES ('5f04bc78d18d41e1b689f59c635cda51', 'e8d9a555235549689892a0e474191354', '1');
INSERT INTO `sys_nav_role` VALUES ('656f7909d5cf4c2da6f4a779e1f408e8', 'e0fed8124cae460ab481b45ede61e2b0', '1');
INSERT INTO `sys_nav_role` VALUES ('9e0692edeea3407cb81f2784e93dabf9', 'e62bf1dd57a44ffa9f4e763d1c89911e', '1');
INSERT INTO `sys_nav_role` VALUES ('9eff743c547040bf92c5ca6e0dbaf248', '16', '1');
INSERT INTO `sys_nav_role` VALUES ('bd0f0b04c5f542228e8a33a57df5e787', '2eb1bb8803ad4d2996d1d1ea3591f75b', '1');
INSERT INTO `sys_nav_role` VALUES ('c03403ae4d0b42309fa5d84b67e27fdc', '2ad9f796ff1a41df9f50aee6c0f87830', '1');
INSERT INTO `sys_nav_role` VALUES ('cab91417504840879631904d4397329b', '7bed0648d96e486a956ac729023c1e13', '1');

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
INSERT INTO `sys_req_url` VALUES ('0057b8a5f62c4575bbcab93848babb21', '/console/sys_role/delete', 'delete', '', '63a0dd85d172415ab41110a8d189d15f');
INSERT INTO `sys_req_url` VALUES ('0099b41803a44c808ceea14b864c2886', '/console/bo_progect_images/add', 'add', '', 'e5b8e9aed114460692dae3b23e63a545');
INSERT INTO `sys_req_url` VALUES ('01471bc2c5004790aa215fb2fd46b6e9', '/console/sys_dictionary/edit', 'edit', '', '54ad54179dae415689a49ed5df578462');
INSERT INTO `sys_req_url` VALUES ('071c0c8fa6434a2e97a5b3d9922bee2e', '/console/sys_role/clear/role/nav', 'clearNav', '', '63a0dd85d172415ab41110a8d189d15f');
INSERT INTO `sys_req_url` VALUES ('0c4abd925b7241f1a4879b116468e848', '/console/sys_user/json', 'json', '', 'baf6963835df42bba5a7c4b984808364');
INSERT INTO `sys_req_url` VALUES ('0dd2ff490e834e6196ec15e8efa8b2eb', '/console/bo_cms_news/list', 'list', '', '78a6e01ac9e84f368800014efd7407be');
INSERT INTO `sys_req_url` VALUES ('0e656d8beff74228b8da906fc51797dd', '/console/sys_dictionary/add/{code}', 'add', '', '54ad54179dae415689a49ed5df578462');
INSERT INTO `sys_req_url` VALUES ('11b8645b34d74bc7be4ef8a99bbd992b', '/console/bo_user/delete', 'delete', '', '9dbd93ce60ae4a38a376c820f42a2faa');
INSERT INTO `sys_req_url` VALUES ('1577612c1ff54475a2e7cee479f2a76b', '/console/bo_project_goods/list', 'list', '', '6427924c9f1e4300b79fb31ebc552351');
INSERT INTO `sys_req_url` VALUES ('178f15e95e6244608888491802de7cc1', '/console/sys_req_url/list', 'list', '', 'cf7d3007e93544e2ba89b245dbcd2c28');
INSERT INTO `sys_req_url` VALUES ('1d97279ff77c433392d520744c541507', '/console/sys_user/list/select', 'select', '', 'baf6963835df42bba5a7c4b984808364');
INSERT INTO `sys_req_url` VALUES ('2245b6036b3e494a9549c7ae6dd6b8bc', '/console/bo_progect_images/json', 'json', '', 'e5b8e9aed114460692dae3b23e63a545');
INSERT INTO `sys_req_url` VALUES ('22b3b88d9f8e4f0a88fe35e0178591ee', '/console/sys_role/nav/json', 'navJson', '', '63a0dd85d172415ab41110a8d189d15f');
INSERT INTO `sys_req_url` VALUES ('234e52f3381d4e9eadbf2f0946d11224', '/console/bo_cms_news/json', 'json', '', '78a6e01ac9e84f368800014efd7407be');
INSERT INTO `sys_req_url` VALUES ('24fac3ccfe6a4e1790c853afee704644', '/console/export/excel', 'exportExcel', '', 'c0222eac6c9942f69ab13a254839e3a3');
INSERT INTO `sys_req_url` VALUES ('2645f5bbe3634e308dfe452fe85590fd', '/console/bo_project/delete', 'delete', '', '48c89733783c48fb88a07613b3a1c57a');
INSERT INTO `sys_req_url` VALUES ('2797163f5d89444290e20d56a7a3cb56', '/console/sys_nav/delete', 'delete', '', 'c81624b5b95840f18eecf678704d94d3');
INSERT INTO `sys_req_url` VALUES ('292b201ca8b34d659c99698e13a5e083', '/console/bo_progect_around/list', 'list', '', '319d34637c9440c3838caef256092f89');
INSERT INTO `sys_req_url` VALUES ('2e2642fe77b143dcaaef4d9a4a232488', '/console/bo_project/list', 'list', '', '48c89733783c48fb88a07613b3a1c57a');
INSERT INTO `sys_req_url` VALUES ('2e977827fbf645d7a63c2920aeffaa3a', '/console/sys_nav/json', 'json', '', 'c81624b5b95840f18eecf678704d94d3');
INSERT INTO `sys_req_url` VALUES ('2efba56e535041b9ba261d56341651bd', '/console/sys_nav/save', 'save', '', 'c81624b5b95840f18eecf678704d94d3');
INSERT INTO `sys_req_url` VALUES ('31b06f93e96e4769a84e0f665ef7dc36', '/console/sys_role/req_accredit/{role_id}', 'req_accredit', '', '63a0dd85d172415ab41110a8d189d15f');
INSERT INTO `sys_req_url` VALUES ('334e2b7f41db43cdba51f6a5058c13ed', '/console/sys_dictionary/list/{code}', 'list', '', '54ad54179dae415689a49ed5df578462');
INSERT INTO `sys_req_url` VALUES ('37fdf1767d8d4484941e48a8c916206d', '/console/sys_nav/list', 'list', '', 'c81624b5b95840f18eecf678704d94d3');
INSERT INTO `sys_req_url` VALUES ('3d09cdc50847444ea695b084ce8bb528', '/console/bo_project_goods/save', 'save', '', '6427924c9f1e4300b79fb31ebc552351');
INSERT INTO `sys_req_url` VALUES ('434be69153a3416392efd29f4e2f71c5', '/console/bo_progect_around/delete', 'delete', '', '319d34637c9440c3838caef256092f89');
INSERT INTO `sys_req_url` VALUES ('46396e0382c64ecf8907106727c9a4c1', '/console/sys_user/save', 'save', '', 'baf6963835df42bba5a7c4b984808364');
INSERT INTO `sys_req_url` VALUES ('48b58b7a5620445794f359c746b63677', '/console/bo_progect_goods_images/list', 'list', '', '6b1b4430bf5740b7b6931d95ae71debc');
INSERT INTO `sys_req_url` VALUES ('4a012fff2f3a49748ed8b44b66ab7cc1', '/console/sys_role/list', 'list', '', '63a0dd85d172415ab41110a8d189d15f');
INSERT INTO `sys_req_url` VALUES ('4e0809dbcbe74d7f91b2fb24b5da295a', '/console/sys_role/nav_accredit/json/{role_id}/{sys_id}', 'nav_accreditJson', '', '63a0dd85d172415ab41110a8d189d15f');
INSERT INTO `sys_req_url` VALUES ('4ea72d8788aa4ba69f658ad6b778fdf4', '/console/sys_req_url/json', 'json', '', 'cf7d3007e93544e2ba89b245dbcd2c28');
INSERT INTO `sys_req_url` VALUES ('57aac1ce8e9e4df69e371c630fa7ed42', '/console/sys_role/clear/role/req', 'clearReq', '', '63a0dd85d172415ab41110a8d189d15f');
INSERT INTO `sys_req_url` VALUES ('589a8897fe834b03ac80d2178c3ad1b0', '/console/bo_project_goods/json', 'json', '', '6427924c9f1e4300b79fb31ebc552351');
INSERT INTO `sys_req_url` VALUES ('59441af5ba8843e78f8d9a9ca009aa42', '/console/bo_app_banner/delete', 'delete', '', 'e3e3cddcebae4948bd954f581b9191b1');
INSERT INTO `sys_req_url` VALUES ('5aa65c21ac8a4ad8bf99357cafa4270e', '/console/bo_app_banner/edit', 'edit', '', 'e3e3cddcebae4948bd954f581b9191b1');
INSERT INTO `sys_req_url` VALUES ('5f99d5c1be6a42459809ad6e08618d3c', '/console/sys_role/add', 'add', '', '63a0dd85d172415ab41110a8d189d15f');
INSERT INTO `sys_req_url` VALUES ('62eed5b82d0b4464a7c55cce5d8b79b5', '/console/bo_project/edit', 'edit', '', '48c89733783c48fb88a07613b3a1c57a');
INSERT INTO `sys_req_url` VALUES ('63024679a7fe4903ad3bf39ba0004438', '/console/sys_role/do_nav_accredit/{role_id}', 'do_nav_accredit', '', '63a0dd85d172415ab41110a8d189d15f');
INSERT INTO `sys_req_url` VALUES ('630900feac684eb99c5108e5eaf4b4c0', '/console/bo_progect_goods_images/json', 'json', '', '6b1b4430bf5740b7b6931d95ae71debc');
INSERT INTO `sys_req_url` VALUES ('6370f515e39e4153b71fcb4def13a32f', '/console/sys_dictionary/delete', 'delete', '', '54ad54179dae415689a49ed5df578462');
INSERT INTO `sys_req_url` VALUES ('6435805950ca4a1aa28963e9d3de9c4c', '/console/bo_progect_images/edit', 'edit', '', 'e5b8e9aed114460692dae3b23e63a545');
INSERT INTO `sys_req_url` VALUES ('64beb1d1381849a1912cc973d2c4a4b2', '/console/sys_role/nav_accredit/{role_id}', 'nav_accredit', '', '63a0dd85d172415ab41110a8d189d15f');
INSERT INTO `sys_req_url` VALUES ('65d97dceefad4f63a8a7d7b6532e3c2c', '/console/bo_user/list', 'list', '', '9dbd93ce60ae4a38a376c820f42a2faa');
INSERT INTO `sys_req_url` VALUES ('668605ee41e74aa3bfea608ddb9a9a0a', '/console/sys_req_url/save', 'save', '', 'cf7d3007e93544e2ba89b245dbcd2c28');
INSERT INTO `sys_req_url` VALUES ('6698a78555c24ce8a118fcf1741ead91', '/console/bo_project_goods/add', 'add', '', '6427924c9f1e4300b79fb31ebc552351');
INSERT INTO `sys_req_url` VALUES ('6782bb6416f84d3d828920d21c81c0e4', '/console/bo_progect_goods_images/add', 'add', '', '6b1b4430bf5740b7b6931d95ae71debc');
INSERT INTO `sys_req_url` VALUES ('6dbfa117487b4b83add1f51ce4303b66', '/console/bo_user/add', 'add', '', '9dbd93ce60ae4a38a376c820f42a2faa');
INSERT INTO `sys_req_url` VALUES ('6f7da881f1d441c29cb88bb06a93689a', '/console/bo_progect_goods_images/delete', 'delete', '', '6b1b4430bf5740b7b6931d95ae71debc');
INSERT INTO `sys_req_url` VALUES ('7028ef7788c94193a59a659e15a35e2f', '/console/sys_user/changepass', 'changepass', '', 'baf6963835df42bba5a7c4b984808364');
INSERT INTO `sys_req_url` VALUES ('71f858001ef647ca878c18d5086761e7', '/console/sys_role/json', 'json', '', '63a0dd85d172415ab41110a8d189d15f');
INSERT INTO `sys_req_url` VALUES ('72df02d8279f41eea1756b21d0767e51', '/console/sys_role/req/group/json', 'reqGroupJson', '', '63a0dd85d172415ab41110a8d189d15f');
INSERT INTO `sys_req_url` VALUES ('7388f832770e40ba831096d814146567', '/console/sys_role/do_req_accredit/{role_id}', 'do_req_accredit', '', '63a0dd85d172415ab41110a8d189d15f');
INSERT INTO `sys_req_url` VALUES ('75500282fa694566b8424ac2825242c5', '/console/sys_role/edit', 'edit', '', '63a0dd85d172415ab41110a8d189d15f');
INSERT INTO `sys_req_url` VALUES ('76c7a7feba5b4a358ffe0a590f9bcd28', '/console/sys_req_url/edit', 'edit', '', 'cf7d3007e93544e2ba89b245dbcd2c28');
INSERT INTO `sys_req_url` VALUES ('76d0160e077248dca710466af3ed056e', '/file/upload/ali/ue', 'uploadAliUe', '', 'b06f41aa9eed4e598428f3b80d6ea922');
INSERT INTO `sys_req_url` VALUES ('7b299c890ad7447babf69ecd431648a5', '/console/nav/trun/first', 'getNavFirstReturn', '', '984b00cc7fec47b38474d38c5ac650bf');
INSERT INTO `sys_req_url` VALUES ('7ca9579afc3c4e1fb77a08f52917a42b', '/console', 'index', '', 'aef085ff64fd425eb359ac84c28da9ec');
INSERT INTO `sys_req_url` VALUES ('7d2e7b5d7e1d4bb0b67cc259b412fdb1', '/console/bo_cms_news/add', 'add', '', '78a6e01ac9e84f368800014efd7407be');
INSERT INTO `sys_req_url` VALUES ('8055a456934641e9af757194b5f04a5b', '/console/sys_role/user_accredit/{user_id}', 'user_accredit', '', '63a0dd85d172415ab41110a8d189d15f');
INSERT INTO `sys_req_url` VALUES ('8200121ae8354cefac802cff40b99dd2', '/console/bo_progect_around/json', 'json', '', '319d34637c9440c3838caef256092f89');
INSERT INTO `sys_req_url` VALUES ('8215c4145b944705ba9554b1017f4be5', '/console/bo_progect_goods_images/save', 'save', '', '6b1b4430bf5740b7b6931d95ae71debc');
INSERT INTO `sys_req_url` VALUES ('837c7ac3f5534283a96d0975a88b4cb7', '/console/sys_role/req_accredit/json', 'req_accreditJson', '', '63a0dd85d172415ab41110a8d189d15f');
INSERT INTO `sys_req_url` VALUES ('8c638d27830c4b88861e543ca04b1e7b', '/console/bo_project/json', 'json', '', '48c89733783c48fb88a07613b3a1c57a');
INSERT INTO `sys_req_url` VALUES ('8d704c72cf8749dab6757ab068b963bd', '/console/bo_user/json', 'json', '', '9dbd93ce60ae4a38a376c820f42a2faa');
INSERT INTO `sys_req_url` VALUES ('8dc5477398e943229af11f0326844cdf', '/console/bo_project/save', 'save', '', '48c89733783c48fb88a07613b3a1c57a');
INSERT INTO `sys_req_url` VALUES ('8ed970ca2b7841748a19d66f75bf6c17', '/console/bo_project/add', 'add', '', '48c89733783c48fb88a07613b3a1c57a');
INSERT INTO `sys_req_url` VALUES ('8fbcce06d35145059b10d71a877d26aa', '/console/bo_progect_images/save', 'save', '', 'e5b8e9aed114460692dae3b23e63a545');
INSERT INTO `sys_req_url` VALUES ('9120a0a8e71c48a08ec9081b284ec110', '/console/login', 'login', '', 'aef085ff64fd425eb359ac84c28da9ec');
INSERT INTO `sys_req_url` VALUES ('94f509384baa491ea27588a171120292', '/console/bo_project_goods/edit', 'edit', '', '6427924c9f1e4300b79fb31ebc552351');
INSERT INTO `sys_req_url` VALUES ('95d759dad18d41e79245a671e253b0a1', '/console/bo_progect_around/edit', 'edit', '', '319d34637c9440c3838caef256092f89');
INSERT INTO `sys_req_url` VALUES ('9ad87bfb6a024d9099be4b4d14829b3b', '/console/bo_progect_images/delete', 'delete', '', 'e5b8e9aed114460692dae3b23e63a545');
INSERT INTO `sys_req_url` VALUES ('9b06102f659a41b580ca32f134f476ac', '/console/sys_user/edit', 'edit', '', 'baf6963835df42bba5a7c4b984808364');
INSERT INTO `sys_req_url` VALUES ('9b46294141814b15981c7db0ca0ca3c5', '/common/captcha/get/{id}', 'getCaptchaImage', '', '92f207d623524ec6a70fa9831c9777f1');
INSERT INTO `sys_req_url` VALUES ('9e4801ca0e5f42f1baa77974ddc67d90', '/console/bo_cms_news/edit', 'edit', '', '78a6e01ac9e84f368800014efd7407be');
INSERT INTO `sys_req_url` VALUES ('a0d38aa4c1384702a29190ec1b108b14', '/file/upload', 'upload', '', 'b06f41aa9eed4e598428f3b80d6ea922');
INSERT INTO `sys_req_url` VALUES ('a57bc82c63924742903732c463961d71', '/body_upload', 'body_upload', '', '2f84ba62f5ea4bfaa3e845bb0f01b156');
INSERT INTO `sys_req_url` VALUES ('a5f936abf8324538ad75c5d93c7e4704', '/console/bo_app_banner/list/{type}', 'list', '', 'e3e3cddcebae4948bd954f581b9191b1');
INSERT INTO `sys_req_url` VALUES ('ab35a062f3f045bab0f326af34ec087a', '/console/bo_user/save', 'save', '', '9dbd93ce60ae4a38a376c820f42a2faa');
INSERT INTO `sys_req_url` VALUES ('ac3d2596bfba4d8abca65e2abbc2e3b3', '/file/upload/ali', 'uploadAli', '', 'b06f41aa9eed4e598428f3b80d6ea922');
INSERT INTO `sys_req_url` VALUES ('ae78fa9db6924c608d9f40ebe1a0596f', '/console/logout', 'logout', '', 'aef085ff64fd425eb359ac84c28da9ec');
INSERT INTO `sys_req_url` VALUES ('b2702326428a4b659bbd8ae84a502bd5', '/console/bo_progect_images/list', 'list', '', 'e5b8e9aed114460692dae3b23e63a545');
INSERT INTO `sys_req_url` VALUES ('b4f534f02ea94f06990b0cc5cf51112f', '/console/sys_role/save', 'save', '', '63a0dd85d172415ab41110a8d189d15f');
INSERT INTO `sys_req_url` VALUES ('b79db43e8e0e468c96970e332a55fdd7', '/console/sys_user/base', 'base', '', 'baf6963835df42bba5a7c4b984808364');
INSERT INTO `sys_req_url` VALUES ('bab630b871674486aedcf0c7e7711f75', '/console/sys_dictionary/save', 'save', '', '54ad54179dae415689a49ed5df578462');
INSERT INTO `sys_req_url` VALUES ('c03b6a270a3740d1abf2d7e53de9f0bd', '/console/sys_req_url/add', 'add', '', 'cf7d3007e93544e2ba89b245dbcd2c28');
INSERT INTO `sys_req_url` VALUES ('c2e9647129994853a923382aea2c8a67', '/console/bo_cms_news/save', 'save', '', '78a6e01ac9e84f368800014efd7407be');
INSERT INTO `sys_req_url` VALUES ('c3d12a10da4b4c5fa9c463b2f364cfe3', '/console/sys_user/delete', 'delete', '', 'baf6963835df42bba5a7c4b984808364');
INSERT INTO `sys_req_url` VALUES ('c40800218519494dad5ca1a85d059898', '/console/sys_nav/add', 'add', '', 'c81624b5b95840f18eecf678704d94d3');
INSERT INTO `sys_req_url` VALUES ('c97f991455ac4b139e9ea14e25055e56', '/console/bo_progect_around/save', 'save', '', '319d34637c9440c3838caef256092f89');
INSERT INTO `sys_req_url` VALUES ('caf0844f39414cee8b7e27163a8187f5', '/console/sys_role/do_user_accredit/{user_id}', 'do_user_accredit', '', '63a0dd85d172415ab41110a8d189d15f');
INSERT INTO `sys_req_url` VALUES ('cece19adc3c44222a7d9f63592450795', '/console/bo_app_banner/add/{type}', 'add', '', 'e3e3cddcebae4948bd954f581b9191b1');
INSERT INTO `sys_req_url` VALUES ('d0fdc886bae04b9db329f1cf7a8a539b', '/console/bo_user/edit', 'edit', '', '9dbd93ce60ae4a38a376c820f42a2faa');
INSERT INTO `sys_req_url` VALUES ('d27806cae77b4784bef47dfbb83758ed', '/console/sys_user/dochangepass', 'dochangepass', '', 'baf6963835df42bba5a7c4b984808364');
INSERT INTO `sys_req_url` VALUES ('d368c969eb7a498ab0cf5d8f6176c076', '/console/sys_req_url/delete', 'delete', '', 'cf7d3007e93544e2ba89b245dbcd2c28');
INSERT INTO `sys_req_url` VALUES ('d4451e556fdb429aa26189778c12986d', '/', 'main', '', 'aef085ff64fd425eb359ac84c28da9ec');
INSERT INTO `sys_req_url` VALUES ('d5b4f6dadfcc4d8f969a1365052b67ab', '/console/sys_user/list', 'list', '', 'baf6963835df42bba5a7c4b984808364');
INSERT INTO `sys_req_url` VALUES ('e29ccfe660a44da199f3406e7e075f13', '/console/sys_dictionary/json', 'json', '', '54ad54179dae415689a49ed5df578462');
INSERT INTO `sys_req_url` VALUES ('e2f711cc6bf54f1dad4d76f27ff23ad6', '/img_upload', 'img_upload', '', '2f84ba62f5ea4bfaa3e845bb0f01b156');
INSERT INTO `sys_req_url` VALUES ('e31009bd29dd4eeeb513295dbe1274b1', '/console/sys_user/add', 'add', '', 'baf6963835df42bba5a7c4b984808364');
INSERT INTO `sys_req_url` VALUES ('e72f6729fe2c424db1e3216218f14b95', '/console/bo_app_banner/save', 'save', '', 'e3e3cddcebae4948bd954f581b9191b1');
INSERT INTO `sys_req_url` VALUES ('e98793d007ec4cc895c665d17f6297a9', '/console/select/json', 'json', '', '0d6e1235b7c04f5eb6ae5bb150d1df29');
INSERT INTO `sys_req_url` VALUES ('ef0919e28f1c457ab99ce08ffdce56c4', '/console/bo_progect_around/add', 'add', '', '319d34637c9440c3838caef256092f89');
INSERT INTO `sys_req_url` VALUES ('f08822e1b77b484a8fc811302d084272', '/console/sys_nav/edit', 'edit', '', 'c81624b5b95840f18eecf678704d94d3');
INSERT INTO `sys_req_url` VALUES ('f1e71f2267074b4386a779d35c59afb9', '/console/bo_progect_goods_images/edit', 'edit', '', '6b1b4430bf5740b7b6931d95ae71debc');
INSERT INTO `sys_req_url` VALUES ('f5899e2dc1d448169c0e373001757e5b', '/console/bo_cms_news/delete', 'delete', '', '78a6e01ac9e84f368800014efd7407be');
INSERT INTO `sys_req_url` VALUES ('fa4c0aa9fbb6428db80ed0b5ce51b8cd', '/console/bo_app_banner/json', 'json', '', 'e3e3cddcebae4948bd954f581b9191b1');
INSERT INTO `sys_req_url` VALUES ('fb160d33364444afb921a6347d211454', '/console/bo_project_goods/delete', 'delete', '', '6427924c9f1e4300b79fb31ebc552351');

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
INSERT INTO `sys_req_url_group` VALUES ('0d6e1235b7c04f5eb6ae5bb150d1df29', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.SelectCommontController', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.SelectCommontController');
INSERT INTO `sys_req_url_group` VALUES ('2f84ba62f5ea4bfaa3e845bb0f01b156', 'zhang.lao.console.controller.zhang.lao.console.controller.TestController', 'zhang.lao.console.controller.zhang.lao.console.controller.TestController');
INSERT INTO `sys_req_url_group` VALUES ('319d34637c9440c3838caef256092f89', 'zhang.lao.console.controller.zhang.lao.console.controller.BoProgectAroundController', 'zhang.lao.console.controller.zhang.lao.console.controller.BoProgectAroundController');
INSERT INTO `sys_req_url_group` VALUES ('48c89733783c48fb88a07613b3a1c57a', 'zhang.lao.console.controller.zhang.lao.console.controller.BoProjectController', 'zhang.lao.console.controller.zhang.lao.console.controller.BoProjectController');
INSERT INTO `sys_req_url_group` VALUES ('54ad54179dae415689a49ed5df578462', 'zhang.lao.console.controller.zhang.lao.console.controller.SysDictionaryController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysDictionaryController');
INSERT INTO `sys_req_url_group` VALUES ('63a0dd85d172415ab41110a8d189d15f', 'zhang.lao.console.controller.zhang.lao.console.controller.SysRoleController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysRoleController');
INSERT INTO `sys_req_url_group` VALUES ('6427924c9f1e4300b79fb31ebc552351', 'zhang.lao.console.controller.zhang.lao.console.controller.BoProjectGoodsController', 'zhang.lao.console.controller.zhang.lao.console.controller.BoProjectGoodsController');
INSERT INTO `sys_req_url_group` VALUES ('6b1b4430bf5740b7b6931d95ae71debc', 'zhang.lao.console.controller.zhang.lao.console.controller.BoProgectGoodsImagesController', 'zhang.lao.console.controller.zhang.lao.console.controller.BoProgectGoodsImagesController');
INSERT INTO `sys_req_url_group` VALUES ('78a6e01ac9e84f368800014efd7407be', 'zhang.lao.console.controller.zhang.lao.console.controller.BoCmsNewsController', 'zhang.lao.console.controller.zhang.lao.console.controller.BoCmsNewsController');
INSERT INTO `sys_req_url_group` VALUES ('92f207d623524ec6a70fa9831c9777f1', 'zhang.lao.console.controller.common.captcha.zhang.lao.console.controller.common.captcha.CaptchaController', 'zhang.lao.console.controller.common.captcha.zhang.lao.console.controller.common.captcha.CaptchaController');
INSERT INTO `sys_req_url_group` VALUES ('984b00cc7fec47b38474d38c5ac650bf', 'zhang.lao.console.controller.nav.zhang.lao.console.controller.nav.PageTurnController', 'zhang.lao.console.controller.nav.zhang.lao.console.controller.nav.PageTurnController');
INSERT INTO `sys_req_url_group` VALUES ('9dbd93ce60ae4a38a376c820f42a2faa', 'zhang.lao.console.controller.zhang.lao.console.controller.BoUserController', 'zhang.lao.console.controller.zhang.lao.console.controller.BoUserController');
INSERT INTO `sys_req_url_group` VALUES ('aef085ff64fd425eb359ac84c28da9ec', 'zhang.lao.console.controller.login.zhang.lao.console.controller.login.LoginController', 'zhang.lao.console.controller.login.zhang.lao.console.controller.login.LoginController');
INSERT INTO `sys_req_url_group` VALUES ('b06f41aa9eed4e598428f3b80d6ea922', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.FileUpAndDown', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.FileUpAndDown');
INSERT INTO `sys_req_url_group` VALUES ('baf6963835df42bba5a7c4b984808364', 'zhang.lao.console.controller.zhang.lao.console.controller.SysUserController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysUserController');
INSERT INTO `sys_req_url_group` VALUES ('c0222eac6c9942f69ab13a254839e3a3', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.HtmlTableToExcel', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.HtmlTableToExcel');
INSERT INTO `sys_req_url_group` VALUES ('c81624b5b95840f18eecf678704d94d3', 'zhang.lao.console.controller.zhang.lao.console.controller.SysNavController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysNavController');
INSERT INTO `sys_req_url_group` VALUES ('cf7d3007e93544e2ba89b245dbcd2c28', 'zhang.lao.console.controller.zhang.lao.console.controller.SysReqUrlController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysReqUrlController');
INSERT INTO `sys_req_url_group` VALUES ('e3e3cddcebae4948bd954f581b9191b1', 'zhang.lao.console.controller.zhang.lao.console.controller.BoAppBannerController', 'zhang.lao.console.controller.zhang.lao.console.controller.BoAppBannerController');
INSERT INTO `sys_req_url_group` VALUES ('e5b8e9aed114460692dae3b23e63a545', 'zhang.lao.console.controller.zhang.lao.console.controller.BoProgectImagesController', 'zhang.lao.console.controller.zhang.lao.console.controller.BoProgectImagesController');

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
