/*
Navicat MySQL Data Transfer

Source Server         : benji
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : laozhang

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-08-18 17:11:26
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
  `name` varchar(128) COLLATE utf8mb4_slovenian_ci DEFAULT NULL,
  `description` varchar(60) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_slovenian_ci;

-- ----------------------------
-- Records of sys_req_url
-- ----------------------------

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
INSERT INTO `sys_req_url_role` VALUES ('cf9492c96a1546218b7e57da323d411a', '1', '/console/sys_role/req_accredit/json');
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
