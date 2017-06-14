/*
Navicat MySQL Data Transfer

Source Server         : benji
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : laozhang

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-06-14 18:37:12
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
INSERT INTO `bo_cms_news` VALUES ('1d9c58f269264fb28c965b7aa4ea5846', '2017-06-14 16:37:59', '1', '1', '11', null, '1', '\\upload\\20170614\\196944845585578.jpg', '2017-06-14 16:37:49', '1', '1', '1');

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
INSERT INTO `sys_nav` VALUES ('16', '用户信息', '/console/sys_user/list', '1', 'glyphicon glyphicon-asterisk', '1', '0', '1', 'a621322fe88b49afaa91835f421a193b', '1', null);
INSERT INTO `sys_nav` VALUES ('18', '系统账户', '/console/sys_user/list', '1', 'glyphicon glyphicon-user', '1', '16', '1', '1ac0c79d7c3d4ab185fb23178e99970f', '2', null);
INSERT INTO `sys_nav` VALUES ('23', '用户角色', '/console/sys_role/list', '1', 'glyphicon glyphicon-user', '1', '16', '1', 'e77c92c7a5824e08a17b47cec09f3e5a', '2', null);
INSERT INTO `sys_nav` VALUES ('24', '导航', '/console/sys_nav/list', '1', 'glyphicon glyphicon-list', '1', '16', '1', '1ac0c79d7c3d4ab185fb23178e999ddd', '2', null);
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
INSERT INTO `sys_nav_role` VALUES ('171ee167df504e9a890efbf86720d1a2', '18', '1');
INSERT INTO `sys_nav_role` VALUES ('254b7ed800eb4e3bb0e39243efbc42f5', 'b1d0e2d0e7e5439595ee25aed5ab5baa', '1');
INSERT INTO `sys_nav_role` VALUES ('51e4ef4b803146dab8e5bbfc5ed42539', 'e62bf1dd57a44ffa9f4e763d1c89911e', '1');
INSERT INTO `sys_nav_role` VALUES ('53', '16', '2');
INSERT INTO `sys_nav_role` VALUES ('54', '24', '2');
INSERT INTO `sys_nav_role` VALUES ('56dbbb199be74e3e87de70425ef1d634', 'e0fed8124cae460ab481b45ede61e2b0', '1');
INSERT INTO `sys_nav_role` VALUES ('62ade01f1f4d44da830e2c5644c0b453', '24', '1');
INSERT INTO `sys_nav_role` VALUES ('9004c261414547d88c9eb1a9bd0efac9', '16', '1');
INSERT INTO `sys_nav_role` VALUES ('bc17b0cccc5a4aca89e3df2aaa3de06b', '23', '1');

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
INSERT INTO `sys_req_url_role` VALUES ('2fcf931f52bf4cd1934f86ee23d2fe12', '2', '/console/sys_nav/delete');
INSERT INTO `sys_req_url_role` VALUES ('3b2c7d5faa9745eb9d5ae66f88ab420e', '1', '/console/sys_user/delete');
INSERT INTO `sys_req_url_role` VALUES ('3dd7a9351c854f93928b59e8bea091a8', '1', '/console/sys_role/nav_accredit/{role_id}');
INSERT INTO `sys_req_url_role` VALUES ('42f517fbc3ac4b03a65bcfc2dbdb9617', '1', '/console/sys_nav/delete');
INSERT INTO `sys_req_url_role` VALUES ('492b8959c8f34748bd39788bacc4ceb6', '1', '/console/sys_nav/edit');
INSERT INTO `sys_req_url_role` VALUES ('4c116472eebb4cb7bbd23cad20f76cf2', '1', '/console/sys_req_url/');
INSERT INTO `sys_req_url_role` VALUES ('4e70b9a1c0dd4165b5655fb9f7e446ce', '1', '/console/sys_req_url/save');
INSERT INTO `sys_req_url_role` VALUES ('551d174d0be448be8b6b8255bf8ce650', '2', '/console/sys_nav/add');
INSERT INTO `sys_req_url_role` VALUES ('5727022bb6934180bd0ed5b7f74e00fd', '1', '/console/sys_role/user_accredit/{user_id}');
INSERT INTO `sys_req_url_role` VALUES ('5896c65698eb42ea9c7285cb71913ef1', '1', '/console/sys_user/');
INSERT INTO `sys_req_url_role` VALUES ('62a4c2ecb30043a5b307a380722c8ad1', '2', '/console/sys_nav/');
INSERT INTO `sys_req_url_role` VALUES ('6733b247b59d454093dd88c956ebabca', '1', '/console/sys_nav/json');
INSERT INTO `sys_req_url_role` VALUES ('6e166a3fb1494fe2827aaaadaee97a6f', '1', '/console/sys_nav/add');
INSERT INTO `sys_req_url_role` VALUES ('7a28d31d00a64c1081e642e25ac92cd3', '1', '/console/sys_role/save');
INSERT INTO `sys_req_url_role` VALUES ('7db8673289a44462b620004959572d3b', '2', '/console/sys_nav/edit');
INSERT INTO `sys_req_url_role` VALUES ('7dd5197cfcf84da2b0610034f87da753', '2', '/console/select/');
INSERT INTO `sys_req_url_role` VALUES ('84eb82991e654324a28aa8af57312720', '1', '/console/sys_nav/save');
INSERT INTO `sys_req_url_role` VALUES ('85b20370fad04fb69a095d8b7f1f31aa', '2', '/console/select/json');
INSERT INTO `sys_req_url_role` VALUES ('8931c4369d3f4ecc8e4351bfb1af98fa', '1', '/console/sys_role/delete');
INSERT INTO `sys_req_url_role` VALUES ('89a294f0dbc346f9ad88d0f4195fd674', '1', '/console/sys_role/req_accredit/{role_id}');
INSERT INTO `sys_req_url_role` VALUES ('8ae4e426ee184ccda8128e1f195b13e8', '1', '/console/sys_role/do_req_accredit/{role_id}');
INSERT INTO `sys_req_url_role` VALUES ('8fba4eaf4e384a2ab95706b77d10d2ad', '2', '/console/sys_nav/list');
INSERT INTO `sys_req_url_role` VALUES ('9e7815b028f64575b784c590191d44e5', '1', '/console/select/');
INSERT INTO `sys_req_url_role` VALUES ('a3bcb3ad310e4119b15bd44cb316f876', '1', '/console/sys_role/list');
INSERT INTO `sys_req_url_role` VALUES ('a4cf6f567b1c4be49b9b1d2f35133373', '1', '/console/sys_role/do_user_accredit/{user_id}');
INSERT INTO `sys_req_url_role` VALUES ('a6bff7453cca471aa77778eb789b521e', '1', '/console/sys_user/base');
INSERT INTO `sys_req_url_role` VALUES ('add6ad32c3b0495aab625d052f72c8de', '1', '/console/sys_nav/');
INSERT INTO `sys_req_url_role` VALUES ('af527f48d4624207ae361525b354e465', '1', '/console/sys_role/req/group/json');
INSERT INTO `sys_req_url_role` VALUES ('afb5e36aa83742af83d98b8363ca16af', '2', '/console/sys_nav/json');
INSERT INTO `sys_req_url_role` VALUES ('b38618e6f5394466a6cffe76d6190f73', '1', '/console/select/json');
INSERT INTO `sys_req_url_role` VALUES ('b4d6f4a1307846aca75da77c60c9a67e', '1', '/console/sys_user/json');
INSERT INTO `sys_req_url_role` VALUES ('bbbdd37ac92e46e88fef5104f9600d25', '1', '/console/sys_nav/list');
INSERT INTO `sys_req_url_role` VALUES ('bc2fadd38c864250a4056196ef8df226', '1', '/console/sys_req_url/json');
INSERT INTO `sys_req_url_role` VALUES ('cf9492c96a1546218b7e57da323d411a', '1', '/console/sys_role/req_accredit/json');
INSERT INTO `sys_req_url_role` VALUES ('d8a28f26263443f68ed061b93e269c7c', '1', '/console/sys_user/dochangepass');
INSERT INTO `sys_req_url_role` VALUES ('df5aa5d6561a49588d04c388c159310c', '1', '/console/sys_user/changepass');
INSERT INTO `sys_req_url_role` VALUES ('ee3ae417c1b5450ca403515a74f680b9', '2', '/console/sys_nav/save');
INSERT INTO `sys_req_url_role` VALUES ('ee8fe5277b85420cb988a2863faae846', '1', '/console/sys_user/add');
INSERT INTO `sys_req_url_role` VALUES ('ef0c2859c4aa439c810ae235e4d73983', '1', '/console/sys_role/add');
INSERT INTO `sys_req_url_role` VALUES ('f22e7fd2fed54c6398f1d9c5e26082f3', '1', '/console/sys_req_url/add');
INSERT INTO `sys_req_url_role` VALUES ('f3df8512a2dc4e62b139265ada574fef', '1', '/console/sys_role/json');
INSERT INTO `sys_req_url_role` VALUES ('f98a13a46bfb4ac2aaf931d6c569ffaf', '1', '/console/sys_user/list/select');
INSERT INTO `sys_req_url_role` VALUES ('fc239df89f774cd0803afa5de967cf34', '1', '/console/sys_user/edit');
INSERT INTO `sys_req_url_role` VALUES ('feb1531f073f4f6ab5d6d7da6cbb234c', '1', '/console/sys_req_url/list');

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
INSERT INTO `sys_role` VALUES ('2', '菜单管理员', '1', '0', '2016-12-23 17:53:18');

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
INSERT INTO `sys_user` VALUES ('1', '张钦', 'e10adc3949ba59abbe56e057f20f883e', '\\upload\\20170524\\86806213013314.png', '18210178959', '492297036@qq.com', null, null, '1', '1', null, '1', '1', 'admin');
INSERT INTO `sys_user` VALUES ('2', '菜单', 'e10adc3949ba59abbe56e057f20f883e', '\\upload\\20161223\\636839587638071.png', '18210172259', '1', null, null, null, null, null, '1', '1', 'caidan');

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
INSERT INTO `sys_user_role` VALUES ('30', '2', '2');
