/*
Navicat MySQL Data Transfer

Source Server         : zhangqinnew
Source Server Version : 50716
Source Host           : 39.105.111.201:3306
Source Database       : wn-websit

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-07-16 16:37:15
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
  PRIMARY KEY (`app_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='接入应用';

-- ----------------------------
-- Records of app_info
-- ----------------------------
INSERT INTO `app_info` VALUES ('1', '1', '1', '1', '1', '1', '2017-03-11 17:46:22', '1', '1');

-- ----------------------------
-- Table structure for bo_banner
-- ----------------------------
DROP TABLE IF EXISTS `bo_banner`;
CREATE TABLE `bo_banner` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `title` varchar(512) NOT NULL COMMENT 'Banner题目',
  `des` varchar(512) DEFAULT NULL COMMENT '描述_textarea',
  `banner_img` varchar(1024) NOT NULL COMMENT 'banner图片_img',
  `target` varchar(1024) DEFAULT NULL COMMENT '目标地址',
  `target_type` int(1) DEFAULT NULL COMMENT '跳转类型_select_1:网页',
  `type` varchar(32) DEFAULT NULL COMMENT 'Banner类型_select_1:官网首页轮播',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `status` int(1) DEFAULT '1' COMMENT '状态_radio_1:可用|0:不可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='Banner轮播';

-- ----------------------------
-- Records of bo_banner
-- ----------------------------
INSERT INTO `bo_banner` VALUES ('f18abc41d93846759ceec3ff5654d995', '1', '1', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/41590419807140.jpg', '1', '1', '1', null, '1', '1');

-- ----------------------------
-- Table structure for bo_contact_us
-- ----------------------------
DROP TABLE IF EXISTS `bo_contact_us`;
CREATE TABLE `bo_contact_us` (
  `id` varchar(32) COLLATE utf8mb4_bin NOT NULL,
  `link_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系人',
  `link_phone` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '电话',
  `link_sub` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '主题',
  `link_content` varchar(2000) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '内容',
  `link_time` datetime DEFAULT NULL COMMENT '时间',
  `link_mail` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系邮箱',
  `link_state` int(1) DEFAULT '0' COMMENT '处理状态_radio_0:未联系|1:已联系',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='客户意向';

-- ----------------------------
-- Records of bo_contact_us
-- ----------------------------
INSERT INTO `bo_contact_us` VALUES ('25fa905e366f49c3b5fa3d87b778b059', '1', '1', '1', '1', '2018-05-09 13:37:57', '1', '0');
INSERT INTO `bo_contact_us` VALUES ('298ebb54d9184c32a475dc60a418b7ea', '12', '212', '121', '121', '2018-05-09 13:39:59', '212', '0');
INSERT INTO `bo_contact_us` VALUES ('c344b7a390f74f9388bdd33049c4a911', '1', '1', '1', '1', '2018-06-18 22:28:41', '1', '0');

-- ----------------------------
-- Table structure for bo_test
-- ----------------------------
DROP TABLE IF EXISTS `bo_test`;
CREATE TABLE `bo_test` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `birthday` date DEFAULT NULL COMMENT '出生日期_date',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `img_url` varchar(1000) DEFAULT NULL COMMENT '头像_img',
  `des` varchar(255) DEFAULT NULL COMMENT '描述_textarea',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别_dic_sex',
  `file_my` varchar(255) DEFAULT NULL COMMENT '个人档案_file',
  `html` text COMMENT '描述_html',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='测试表格_child_a1';

-- ----------------------------
-- Records of bo_test
-- ----------------------------
INSERT INTO `bo_test` VALUES ('4405fcae7d774395b3868fc84f099521', '1111111111', '2018-05-26', '1', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/png/59433444663671.png', '1', '男', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/png/59438801047244.png', '');

-- ----------------------------
-- Table structure for bo_test2
-- ----------------------------
DROP TABLE IF EXISTS `bo_test2`;
CREATE TABLE `bo_test2` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `pid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='测试表格_child_a2_pid';

-- ----------------------------
-- Records of bo_test2
-- ----------------------------
INSERT INTO `bo_test2` VALUES ('4405fcae7d774395b3868fc84f099521', '1111111111', null);

-- ----------------------------
-- Table structure for bo_web_image
-- ----------------------------
DROP TABLE IF EXISTS `bo_web_image`;
CREATE TABLE `bo_web_image` (
  `id` varchar(32) COLLATE utf8mb4_bin NOT NULL,
  `image_url` varchar(1024) COLLATE utf8mb4_bin NOT NULL COMMENT '图片地址_img',
  `image_title` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图片标题',
  `image_des` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图片描述',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='画廊';

-- ----------------------------
-- Records of bo_web_image
-- ----------------------------
INSERT INTO `bo_web_image` VALUES ('91d9cf41d1624688a02fdf91f1ebabd6', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/41590419807140.jpg', '1', '1', null);

-- ----------------------------
-- Table structure for bo_web_news
-- ----------------------------
DROP TABLE IF EXISTS `bo_web_news`;
CREATE TABLE `bo_web_news` (
  `id` varchar(36) COLLATE utf8mb4_slovenian_ci NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `publish` int(1) DEFAULT NULL COMMENT '是否发布_radio_0:未发布|1:已发布',
  `author` varchar(22) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '作者',
  `source` varchar(255) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '来源',
  `update_time` datetime DEFAULT NULL,
  `content` text COLLATE utf8mb4_slovenian_ci COMMENT '内容_html',
  `cover` varchar(255) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '封面_img',
  `title` varchar(200) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '标题',
  `news_type` int(1) DEFAULT NULL COMMENT '新闻类型_select_1:普通新闻|2:项目简介|3:成果展示|4:建设进展',
  `intro` varchar(1024) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '简介_textarea',
  `keyword` varchar(255) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '关键字',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_slovenian_ci ROW_FORMAT=DYNAMIC COMMENT='新闻';

-- ----------------------------
-- Records of bo_web_news
-- ----------------------------
INSERT INTO `bo_web_news` VALUES ('11', '2018-05-09 20:48:36', '1', '小乔帮主', '农业农村部', null, '<p>本网讯&nbsp; 2018年&ldquo;三夏&rdquo;小麦跨区机收大会战，自5月28日启动以来，由南向北快速有序推进，鄂、豫、皖、苏、鲁、冀、陕等冬小麦主产区相继告捷。截至6月19日，全国已收获冬小麦3.1亿亩，全国大规模小麦跨区机收基本结束，机收比例达95.5%，创历史新高。各地夏种迅速压茬展开，全国已机播夏玉米1.45亿亩，机播比例超过82%。</p>\n\n<p>　　作业更高效。今年全国63万台联合收割机、5.5万个农机服务组织、180万名农机手奋战在夏收夏种一线，其中参加跨区作业的大喂入量高性能联合收割机占比超过70%，机收效率大幅提高。农机部门充分运用信息化手段特别是手机APP促进服务供需高效对接，方便机手找活干、方便农民找机用。全国连续5天小麦日机收面积过2000万亩、玉米日机播面积过1000万亩，单日机收面积最高达2751万亩，均创历史新纪录。麦收进度过半、过八成、基本结束用时比去年同期缩短1至2天。</p>\n\n<p>　　装备更智能。各地大力推广应用&ldquo;智慧&rdquo;农机，让调度更精准、作业效率更高效，作业质量更可控、维修服务更及时，为 &ldquo;三夏&rdquo;机械化生产注入新活力。越来越多的新型收割机出厂预装北斗定位和工况监测系统，可第一时间精准确定机器位置、诊断故障原因和就近获取维修服务。</p>\n\n<p>　　生产更绿色。今年联合收割机普遍配备了秸秆切碎抛洒装置，各地推行小麦联合收获&mdash;麦秸抛洒覆盖还田&mdash;夏玉米免耕播种等绿色作业模式，河南、安徽、山东等地秸秆离田还田率超过90%。河北省投入5200万元支持农机合作社向&ldquo;精准作业&rdquo;转型升级，试验示范精准高速播种、变量施肥施药灌溉等高效绿色全程机械化装备技术。山东整合各类涉农资金2亿元，在48个县集成推广深耕深松、宽幅精播等绿色生产模式，示范区耕种管收综合机械化率达到100%，化肥、农药使用量平均减少10%。</p>\n\n<p>　　服务更暖心。各地大力推广托管式、订单式、租赁式及&ldquo;全程机械化+综合农事&rdquo;一站式服务模式，小麦主产区机收机播&ldquo;一条龙&rdquo;服务面积超过1.7亿亩，带动更多农户便捷应用机械化高效生产方式，农民省事又省钱、机手增效又增收。一批骨干农机企业、明星农机合作社主动践行社会责任，积极为贫困农户免费割麦。各省共设立跨区作业服务站3400个，为过往的机收队提供市场信息、机具维修、交通指引等周到服务。</p>', 'http://fenghenongchang.image.alimmdn.com/image/console/1531212046026.jpg', '全国大规模小麦跨区机收基本结束 机收率达95.5% 创历史新高', '1', '新华社北京7月10日电（记者王卓伦、赵修知）中阿合作论坛第八届部长级会议10日在人民大会堂开幕。国家主席习近平出席开幕式并发表题为《携手推进新时代中阿战略伙伴关系》的重要讲话，宣布中阿双方一致同意，建立全面合作、共同发展、面向未来的中阿战略伙伴关系。', '跨区机收大会战');
INSERT INTO `bo_web_news` VALUES ('12', '2018-05-09 20:48:36', '1', 'xiaoqiao', '农业农村部', null, '<p>近日，由石家庄市种子站主办、河北宏瑞种业有限公司承办的2018年河北省优质强筋小麦观摩研讨会在石家庄召开，来自石家庄、邯郸、邢台等地的种子管理部门、种粮大户200多人参加了会议。</p>\n\n<p>　　与会代表参观了我省优质强筋小麦当家品种藁优2018、藁优52178等新品种长势，专家介绍了我国优质强筋小麦的市场需求、面粉加工企业对优质强筋小麦的需求，以及我省发展强筋优质麦产业的区位优势，对如何加快推进优质强筋小麦育繁推一体化、发展企业+合作社+农民产业联合体提出了建议。</p>\n\n<p>　　据了解，河北宏瑞种业有限公司拥有8万多亩繁种基地，科研农场用地500多亩，拥有一个强筋麦研发中心，三个试验站/园区（赵县、辛集、冀州），四个玉米科研基地，有一套完整的生产控制体系保证生产质量，配备国际先进的成套种子加工流水线、质量检验室和各种检验仪器，能对各类种子的各项质量指标进行检测。目前，该公司正在与科研单位、农民合作社联合，探索优质强筋小麦育繁推一体化之路。</p>', 'http://fenghenongchang.image.alimmdn.com/image/console/1531212053983.jpg', '探讨推进优质强筋 小麦育繁推一体化方案', '3', '新华社北京7月10日电（记者王卓伦、赵修知）中阿合作论坛第八届部长级会议10日在人民大会堂开幕。国家主席习近平出席开幕式并发表题为《携手推进新时代中阿战略伙伴关系》的重要讲话，宣布中阿双方一致同意，建立全面合作、共同发展、面向未来的中阿战略伙伴关系。', '1');
INSERT INTO `bo_web_news` VALUES ('13', '2018-05-09 20:48:36', '1', '1', '1', null, '<p>1</p>', 'http://fenghenongchang.image.alimmdn.com/image/console/1531212063407.jpg', '星巴克要全面禁用塑料吸管 这是怎么回事?', '3', '新华社北京7月10日电（记者王卓伦、赵修知）中阿合作论坛第八届部长级会议10日在人民大会堂开幕。国家主席习近平出席开幕式并发表题为《携手推进新时代中阿战略伙伴关系》的重要讲话，宣布中阿双方一致同意，建立全面合作、共同发展、面向未来的中阿战略伙伴关系。', '1');
INSERT INTO `bo_web_news` VALUES ('14', '2018-05-09 20:48:36', '1', '1', '1', null, '<p>1</p>', 'http://fenghenongchang.image.alimmdn.com/image/console/1531212073411.jpg', '一本划时代的国学书在英国出版', '4', '新华社北京7月10日电（记者王卓伦、赵修知）中阿合作论坛第八届部长级会议10日在人民大会堂开幕。国家主席习近平出席开幕式并发表题为《携手推进新时代中阿战略伙伴关系》的重要讲话，宣布中阿双方一致同意，建立全面合作、共同发展、面向未来的中阿战略伙伴关系。', '1');
INSERT INTO `bo_web_news` VALUES ('15', '2018-05-09 20:48:36', '1', '1', '1', null, '<p>1</p>', 'http://fenghenongchang.image.alimmdn.com/image/console/1531212187300.jpg', '习主席发表重要讲话', '4', '新华社北京7月10日电（记者王卓伦、赵修知）中阿合作论坛第八届部长级会议10日在人民大会堂开幕。国家主席习近平出席开幕式并发表题为《携手推进新时代中阿战略伙伴关系》的重要讲话，宣布中阿双方一致同意，建立全面合作、共同发展、面向未来的中阿战略伙伴关系。', '1');
INSERT INTO `bo_web_news` VALUES ('16', '2018-05-09 20:48:36', '1', '1', '1', null, '<p>1</p>', 'http://fenghenongchang.image.alimmdn.com/image/console/1531212257157.jpg', '1一本划时代的国学书在英国出版', '4', '新华社北京7月10日电（记者王卓伦、赵修知）中阿合作论坛第八届部长级会议10日在人民大会堂开幕。国家主席习近平出席开幕式并发表题为《携手推进新时代中阿战略伙伴关系》的重要讲话，宣布中阿双方一致同意，建立全面合作、共同发展、面向未来的中阿战略伙伴关系。', '1');
INSERT INTO `bo_web_news` VALUES ('2', '2018-05-09 20:48:36', '1', '大海全是水', '大海全是水', null, '<p>1<img alt=\"\" src=\"http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/13010821327858.jpg\" style=\"height:267px; width:400px\" /></p>\n\n<p><img alt=\"\" src=\"http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/13041456494464.jpg\" style=\"height:267px; width:400px\" /></p>', 'http://fenghenongchang.image.alimmdn.com/image/console/1531212272574.jpg', '大海全是水', '3', '新华社北京7月10日电（记者王卓伦、赵修知）中阿合作论坛第八届部长级会议10日在人民大会堂开幕。国家主席习近平出席开幕式并发表题为《携手推进新时代中阿战略伙伴关系》的重要讲话，宣布中阿双方一致同意，建立全面合作、共同发展、面向未来的中阿战略伙伴关系。', '1');
INSERT INTO `bo_web_news` VALUES ('3', '2018-05-09 20:48:36', '1', '1', '1', null, '<p>1</p>', 'http://fenghenongchang.image.alimmdn.com/image/console/1531212138002.jpg', '北京赛车怎么看规律', '2', '新华社北京7月10日电（记者王卓伦、赵修知）中阿合作论坛第八届部长级会议10日在人民大会堂开幕。国家主席习近平出席开幕式并发表题为《携手推进新时代中阿战略伙伴关系》的重要讲话，宣布中阿双方一致同意，建立全面合作、共同发展、面向未来的中阿战略伙伴关系。', '1');
INSERT INTO `bo_web_news` VALUES ('4', '2018-05-09 20:48:36', '1', '1', '1', null, '<p>1</p>', 'http://fenghenongchang.image.alimmdn.com/image/console/1531212175841.jpg', '绝地求生PCPI官方赛事什么时候开始 吃鸡PCPI赛事详情一览', '2', '新华社北京7月10日电（记者王卓伦、赵修知）中阿合作论坛第八届部长级会议10日在人民大会堂开幕。国家主席习近平出席开幕式并发表题为《携手推进新时代中阿战略伙伴关系》的重要讲话，宣布中阿双方一致同意，建立全面合作、共同发展、面向未来的中阿战略伙伴关系。', '1');
INSERT INTO `bo_web_news` VALUES ('5', '2018-05-09 20:48:36', '1', '1', '1', null, '<p>1</p>', 'http://fenghenongchang.image.alimmdn.com/image/console/1531212164816.jpg', '习主席发表重要讲话', '3', '新华社北京7月10日电（记者王卓伦、赵修知）中阿合作论坛第八届部长级会议10日在人民大会堂开幕。国家主席习近平出席开幕式并发表题为《携手推进新时代中阿战略伙伴关系》的重要讲话，宣布中阿双方一致同意，建立全面合作、共同发展、面向未来的中阿战略伙伴关系。', '1');
INSERT INTO `bo_web_news` VALUES ('6', '2018-05-09 20:48:36', '1', '1', '1', null, '<p>1</p>', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/41590419807140.jpg', '习主席发表重要讲话', '4', '新华社北京7月10日电（记者王卓伦、赵修知）中阿合作论坛第八届部长级会议10日在人民大会堂开幕。国家主席习近平出席开幕式并发表题为《携手推进新时代中阿战略伙伴关系》的重要讲话，宣布中阿双方一致同意，建立全面合作、共同发展、面向未来的中阿战略伙伴关系。', '1');
INSERT INTO `bo_web_news` VALUES ('7', '2018-05-09 20:48:36', '1', '1', '1', null, '<p>1</p>', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/41590419807140.jpg', '财政部：建立健全国有资本管理的“四梁八柱”', '3', '新华社北京7月10日电（记者王卓伦、赵修知）中阿合作论坛第八届部长级会议10日在人民大会堂开幕。国家主席习近平出席开幕式并发表题为《携手推进新时代中阿战略伙伴关系》的重要讲话，宣布中阿双方一致同意，建立全面合作、共同发展、面向未来的中阿战略伙伴关系。', '1');
INSERT INTO `bo_web_news` VALUES ('8', '2018-05-09 20:48:36', '1', '1', '1', null, '<p>1</p>', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/41590419807140.jpg', '习主席发表重要讲话', '3', '新华社北京7月10日电（记者王卓伦、赵修知）中阿合作论坛第八届部长级会议10日在人民大会堂开幕。国家主席习近平出席开幕式并发表题为《携手推进新时代中阿战略伙伴关系》的重要讲话，宣布中阿双方一致同意，建立全面合作、共同发展、面向未来的中阿战略伙伴关系。', '1');
INSERT INTO `bo_web_news` VALUES ('9', '2018-05-09 20:48:36', '1', '1', '1', null, '<p>1</p>', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/41590419807140.jpg', '习主席发表重要讲话', '3', '新华社北京7月10日电（记者王卓伦、赵修知）中阿合作论坛第八届部长级会议10日在人民大会堂开幕。国家主席习近平出席开幕式并发表题为《携手推进新时代中阿战略伙伴关系》的重要讲话，宣布中阿双方一致同意，建立全面合作、共同发展、面向未来的中阿战略伙伴关系。', '1');
INSERT INTO `bo_web_news` VALUES ('c77c738cb8ed4f2888d3b3e18ac908cb', '2018-05-09 20:48:36', '1', '1', '1', null, '<p>1</p>', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/41590419807140.jpg', '习主席发表重要讲话', '2', '新华社北京7月10日电（记者王卓伦、赵修知）中阿合作论坛第八届部长级会议10日在人民大会堂开幕。国家主席习近平出席开幕式并发表题为《携手推进新时代中阿战略伙伴关系》的重要讲话，宣布中阿双方一致同意，建立全面合作、共同发展、面向未来的中阿战略伙伴关系。', '1');

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_slovenian_ci ROW_FORMAT=DYNAMIC COMMENT='数据字段';

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------
INSERT INTO `sys_dictionary` VALUES ('9201f6d742924a9c975e1a15d1308831', 'ceshi', '111', '1', '1', '0');
INSERT INTO `sys_dictionary` VALUES ('e69e79b778204cad84fd9e0c20336f80', 'sex', '男', '男', '男', '0');

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
  PRIMARY KEY (`file_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_slovenian_ci ROW_FORMAT=DYNAMIC COMMENT='系统文件';

-- ----------------------------
-- Records of sys_file
-- ----------------------------
INSERT INTO `sys_file` VALUES ('159567968ac04091b864b04757288649', '微信图片_20170913170326.jpg', '.jpg', '640', '480', '28389', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/946024690191547.jpg', '2017-10-24 10:46:26', '0', 'd50ec5449f93976ae60a5531b21bcb25');
INSERT INTO `sys_file` VALUES ('1e2aef01e0494996854fa7965c269c47', '41870053970826.png', '.png', '617', '610', '1322', '/upload/20180522/41870053970826.png', '2018-05-22 09:21:51', '1', '8e8aed2a6bb118db4ae971e068ce258a');
INSERT INTO `sys_file` VALUES ('25933e547cab4da4817a083ce57ed4c3', 'VCG41497197687.jpg', '.jpg', '267', '400', '24860', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/13041456494464.jpg', '2018-06-20 13:08:09', '0', '6e2c1cf1b1dc597a0314b7d94ff62c38');
INSERT INTO `sys_file` VALUES ('459fbf9509dc4664a3b5020ad78d1946', '13706934489197.jpg', '.jpg', '640', '640', '28629', '/upload/20180403/13706934489197.jpg', '2018-04-03 14:58:51', '1', '73e8adbecb01c09b40f4f3fdcc06c507');
INSERT INTO `sys_file` VALUES ('8a8694742448448e953406d5aca4503e', 'logo_副本.jpg', '.jpg', '64', '64', '2027', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/964543670863864.jpg', '2017-10-24 15:55:05', '0', '967a48090138e717e8ca026827fac7f4');
INSERT INTO `sys_file` VALUES ('8ccc81b06c55482eaace447025338338', '595626873085912.zip', '.zip', null, null, '37304', '/upload/20180503/595626873085912.zip', '2018-05-03 09:15:40', '1', 'a10500f26970f562e2f549dbde5ee5a6');
INSERT INTO `sys_file` VALUES ('931823b7c742478a814f4e8a9808a5d4', '1510799899.png', '.png', '500', '500', '29581', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/png/414332199038991.png', '2017-11-20 09:58:54', '0', 'd99219d82244ff92c46121f2b7f7f6f');
INSERT INTO `sys_file` VALUES ('9c5b017b18c34f1aa36633956f42311d', 'VCG2187e169bf3.jpg', '.jpg', '267', '400', '38881', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/13010821327858.jpg', '2018-06-20 13:07:39', '0', '91b833ab3e51948f4c9871b3cc073934');
INSERT INTO `sys_file` VALUES ('ad1cc1b678e64946880b64f7585dc47a', '13699999990425.jpg', '.jpg', '322', '404', '93816', '/upload/20180403/13699999990425.jpg', '2018-04-03 14:58:44', '1', 'c6e308158a8fd50149cb6275c70496d9');
INSERT INTO `sys_file` VALUES ('b5c0df624acc43f79345c6b2c317f802', '1024(1).png', '.png', '1024', '1024', '687260', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/png/59433444663671.png', '2018-05-22 14:14:35', '0', 'ab6de7dc3703bff0e58f58165e0db3ef');
INSERT INTO `sys_file` VALUES ('b95c6cc7ab674056a484829c8ed0af6c', '微信图片_20170913170326.jpg', '.jpg', '640', '480', '28389', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/jpg/946041991157746.jpg', '2017-10-24 10:46:43', '0', 'd50ec5449f93976ae60a5531b21bcb25');
INSERT INTO `sys_file` VALUES ('cdaff65fcc24430bb766cbdd12c1ae0e', '6.png', '.png', '1280', '1260', '443495', 'http://fenghenongchang.image.alimmdn.com/fenghenongchang/img/png/59438801047244.png', '2018-05-22 14:14:40', '0', 'ab70ad77884e9f2984b8b1a8d3db1936');
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
  PRIMARY KEY (`nav_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统菜单';

-- ----------------------------
-- Records of sys_nav
-- ----------------------------
INSERT INTO `sys_nav` VALUES ('09b4f5fe129b486ab9ecd298eee184aa', '新闻', '/console/bo_web_news/list', '_self', 'glyphicon glyphicon-film', '2', '0ec0a63e71ca43709a044e1442cb493a', '1', '4944c8ec84c44128abdde07f2bd45db4', '2', null);
INSERT INTO `sys_nav` VALUES ('0ec0a63e71ca43709a044e1442cb493a', '数据管理', '数据管理', '_self', 'glyphicon glyphicon-cloud', '1', '0', '1', '34cf7a843d0c4c77a86e09f357674095', '1', null);
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
  PRIMARY KEY (`snr_id`) USING BTREE,
  KEY `FK_Reference_18` (`nav_id`) USING BTREE,
  KEY `FK_Reference_19` (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色菜单权限';

-- ----------------------------
-- Records of sys_nav_role
-- ----------------------------
INSERT INTO `sys_nav_role` VALUES ('1a2dd29ebc424bff9f0536b38ea867b7', '09b4f5fe129b486ab9ecd298eee184aa', '1');
INSERT INTO `sys_nav_role` VALUES ('8c72b5912f2547478ea0c66f8c381a7a', '143c374692dd4d11a0168ce8c28484a2', '1');
INSERT INTO `sys_nav_role` VALUES ('a3b29b0f5a9d4beaa6836c6ae8f2771e', '24', '1');
INSERT INTO `sys_nav_role` VALUES ('ae14dd112beb414aaf46621f3e416070', 'd1e2fa7a87e74f82b4e935db1a780788', '1');
INSERT INTO `sys_nav_role` VALUES ('c04b9da2560c4121949bb3e3c69db7c9', '0ec0a63e71ca43709a044e1442cb493a', '1');
INSERT INTO `sys_nav_role` VALUES ('ca064e1ad8f34e6aac06c3bb2891fc99', '23', '1');
INSERT INTO `sys_nav_role` VALUES ('dcd7069b18f04fc78566ba22dd08e193', '18', '1');
INSERT INTO `sys_nav_role` VALUES ('e4efa451e08c47c49a2ec263299721b1', '16', '1');

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_slovenian_ci ROW_FORMAT=DYNAMIC COMMENT='请求_except(s,c)';

-- ----------------------------
-- Records of sys_req_url
-- ----------------------------
INSERT INTO `sys_req_url` VALUES ('006b447c0aad43f284350e790ba2d763', '/console/bo_web_image/edit', 'edit', '', 'de76cedeb545481ebbac4dcd6234316f');
INSERT INTO `sys_req_url` VALUES ('0222ea6e0fea4f98afb03232f79f4551', '/file/upload', 'upload', '', 'c80da3d1515d47c7bf815f463438039d');
INSERT INTO `sys_req_url` VALUES ('0273716180ba4734bfbc4db95c623349', '/console/sys_role/clear/role/req', 'clearReq', '', '5961ed25fd2a41fa9c83bff34390a35f');
INSERT INTO `sys_req_url` VALUES ('02896c3da3864ae8b313ea18fd549014', '/console/file/ali/token', 'getAliToken', '', 'c80da3d1515d47c7bf815f463438039d');
INSERT INTO `sys_req_url` VALUES ('06f5900c68e54ea68df4c69624ef4993', '/news/detail/{id}', 'newsList', '', '9fb81f12fd02449aa8f35b053212a02c');
INSERT INTO `sys_req_url` VALUES ('1241be8477ce4475b64614ef5d48c999', '/console/sys_req_url/edit', 'edit', '', 'd156cfadf4884282b50140105f162392');
INSERT INTO `sys_req_url` VALUES ('1332159059a447deb4411f85b96924f4', '/news/list/{type}', 'newsListPage', '', '9fb81f12fd02449aa8f35b053212a02c');
INSERT INTO `sys_req_url` VALUES ('17e4b8b67de3414a8690a6c96f25ea76', '/console/bo_web_news/save', 'save', '', '6c18e14e264f4224a541ff4216e93022');
INSERT INTO `sys_req_url` VALUES ('1d7ac48e8ad146dd9df75aac56899824', '/console/sys_user/dochangepass', 'dochangepass', '', '22553952098547c09877b2cef8ad8313');
INSERT INTO `sys_req_url` VALUES ('1edf86f36b434654b05c48b81563d578', '/console/bo_banner/add', 'add', '', '0bf8d00287b14f8dba9132404d171a55');
INSERT INTO `sys_req_url` VALUES ('1f0fd30f6bac494db47a0b3826d76fc6', '/console/sys_role/save', 'save', '', '5961ed25fd2a41fa9c83bff34390a35f');
INSERT INTO `sys_req_url` VALUES ('1fcb914769544fff9a90633ec8c63960', '/console/sys_user/list/select', 'select', '', '22553952098547c09877b2cef8ad8313');
INSERT INTO `sys_req_url` VALUES ('20564dae17414675bd3588dd1a36abd0', '/console/bo_contact_us/save', 'save', '', 'ce4da1d3b36848c0bac65c88c2f966f9');
INSERT INTO `sys_req_url` VALUES ('21e2800a5ed746b88e88e25548e0568b', '/console/sys_req_url/list', 'list', '', 'd156cfadf4884282b50140105f162392');
INSERT INTO `sys_req_url` VALUES ('24bb929929ff441c9eefb2b2e4e40ba1', '/console/bo_contact_us/edit', 'edit', '', 'ce4da1d3b36848c0bac65c88c2f966f9');
INSERT INTO `sys_req_url` VALUES ('28243547dd144b2ab78f0f561c2045eb', '/console/sys_role/user_accredit/{user_id}', 'user_accredit', '', '5961ed25fd2a41fa9c83bff34390a35f');
INSERT INTO `sys_req_url` VALUES ('2e3aa852e82c440e95968fac13068be1', '/console/bo_banner/save', 'save', '', '0bf8d00287b14f8dba9132404d171a55');
INSERT INTO `sys_req_url` VALUES ('2ee7d3b2de254ad59e3d4d9019f9e627', '/console/sys_role/do_req_accredit/{role_id}', 'do_req_accredit', '', '5961ed25fd2a41fa9c83bff34390a35f');
INSERT INTO `sys_req_url` VALUES ('3050d52069514e57969c2d24387dd9f9', '/console/bo_web_image/list', 'list', '', 'de76cedeb545481ebbac4dcd6234316f');
INSERT INTO `sys_req_url` VALUES ('305111790e6a43b38ebd6a3839f12f18', '/console/logout', 'logout', '', '4654839ffd514ff4a390d8d3448c611d');
INSERT INTO `sys_req_url` VALUES ('31433229e8a64105928873303925f3f0', '/console/bo_web_image/json', 'json', '', 'de76cedeb545481ebbac4dcd6234316f');
INSERT INTO `sys_req_url` VALUES ('34a5b85374a6453cb068ad6ffd3d2e13', '/console/sys_user/edit', 'edit', '', '22553952098547c09877b2cef8ad8313');
INSERT INTO `sys_req_url` VALUES ('368509a0f53a4e2d9b997f091b6b9a44', '/console/sys_user/add', 'add', '', '22553952098547c09877b2cef8ad8313');
INSERT INTO `sys_req_url` VALUES ('3ae74d7041014d45b5c1152459285831', '/console/sys_role/json', 'json', '', '5961ed25fd2a41fa9c83bff34390a35f');
INSERT INTO `sys_req_url` VALUES ('3b513226b2534a5a807caeb3db1fa0de', '/', 'index', '', '9fb81f12fd02449aa8f35b053212a02c');
INSERT INTO `sys_req_url` VALUES ('3e27cf9fdac44f478f7042c3c746f4f3', '/console/bo_test/json', 'json', '', 'c5163d00c529443ab0720dea8c0eacc2');
INSERT INTO `sys_req_url` VALUES ('41d04ee02b4a48dbbb814acfed69ccca', '/console/bo_contact_us/delete', 'delete', '', 'ce4da1d3b36848c0bac65c88c2f966f9');
INSERT INTO `sys_req_url` VALUES ('457be54fc5a64942857c7d1d9fe9d7ad', '/console/bo_test/add', 'add', '', 'c5163d00c529443ab0720dea8c0eacc2');
INSERT INTO `sys_req_url` VALUES ('46aa65b1c59a43f49573bd1d2d828c87', '/console/sys_user/save', 'save', '', '22553952098547c09877b2cef8ad8313');
INSERT INTO `sys_req_url` VALUES ('48bbcead95db4c2da18209c3e206ea18', '/console/bo_test/list', 'list', '', 'c5163d00c529443ab0720dea8c0eacc2');
INSERT INTO `sys_req_url` VALUES ('4cdf7f362d1f40f2bb1bc36940d09885', '/console', 'index', '', '4654839ffd514ff4a390d8d3448c611d');
INSERT INTO `sys_req_url` VALUES ('4eed0991b0ef467d82e46e72446d4ac8', '/console/sys_dictionary/add/{code}', 'add', '', '76bcb5891f3847188f22ee67eeab727d');
INSERT INTO `sys_req_url` VALUES ('53733977744e4305b195806a59c76b3f', '/contact/send', 'contactSend', '', '9fb81f12fd02449aa8f35b053212a02c');
INSERT INTO `sys_req_url` VALUES ('58e679d5378440f4a268ebcd62ddbca2', '/console/sys_nav/edit', 'edit', '', 'ae09fb76077d4bc3adf6fcc5cbcf5116');
INSERT INTO `sys_req_url` VALUES ('5931fa3e1f4b4c32a49ed1442f194a0a', '/console/sys_dictionary/json', 'json', '', '76bcb5891f3847188f22ee67eeab727d');
INSERT INTO `sys_req_url` VALUES ('59d2ed112cdc4aa4b552538944eeb7ba', '/console/bo_web_image/add', 'add', '', 'de76cedeb545481ebbac4dcd6234316f');
INSERT INTO `sys_req_url` VALUES ('5c62cbe1bd3741fe9a5971aeeb713b6c', '/console/sys_role/do_user_accredit/{user_id}', 'do_user_accredit', '', '5961ed25fd2a41fa9c83bff34390a35f');
INSERT INTO `sys_req_url` VALUES ('5ea9aa182e7f43799258665e70115e07', '/console/sys_user/changepass', 'changepass', '', '22553952098547c09877b2cef8ad8313');
INSERT INTO `sys_req_url` VALUES ('5eeba028f23d4629aca123b3fa7beb08', '/console/bo_banner/list', 'list', '', '0bf8d00287b14f8dba9132404d171a55');
INSERT INTO `sys_req_url` VALUES ('5f49d0471a764e03a0d54367f7b6983b', '/file/upload/ckeditor', 'uploadCkeditor', '', 'c80da3d1515d47c7bf815f463438039d');
INSERT INTO `sys_req_url` VALUES ('5f781941bdde4a96a23ecf2b9ca9bf7b', '/console/sys_dictionary/delete', 'delete', '', '76bcb5891f3847188f22ee67eeab727d');
INSERT INTO `sys_req_url` VALUES ('6028d90b82db469ca42f720f9780b059', '/console/sys_nav/add', 'add', '', 'ae09fb76077d4bc3adf6fcc5cbcf5116');
INSERT INTO `sys_req_url` VALUES ('66690edc031c4281af1e9baf62209708', '/console/sys_user/base', 'base', '', '22553952098547c09877b2cef8ad8313');
INSERT INTO `sys_req_url` VALUES ('6aacfefc86954c08bf2da9d538752b5e', '/console/bo_contact_us/add', 'add', '', 'ce4da1d3b36848c0bac65c88c2f966f9');
INSERT INTO `sys_req_url` VALUES ('6cdcb14ed0464815aef17a322c4e94dc', '/console/sys_user/list', 'list', '', '22553952098547c09877b2cef8ad8313');
INSERT INTO `sys_req_url` VALUES ('6d8bd095e0604e09893931640d1981c6', '/console/first/nav', 'firstNav', '', 'c1dd738acd5b442db49dc911c5f7e266');
INSERT INTO `sys_req_url` VALUES ('6faf3aa7523644cda98738ae41640bf7', '/console/sys_role/clear/role/nav', 'clearNav', '', '5961ed25fd2a41fa9c83bff34390a35f');
INSERT INTO `sys_req_url` VALUES ('72c334da85864b7bad87a17e764e6015', '/console/sys_role/req_accredit/{role_id}', 'req_accredit', '', '5961ed25fd2a41fa9c83bff34390a35f');
INSERT INTO `sys_req_url` VALUES ('73bb550ec5364e4a8ba91b183de610ae', '/console/sys_dictionary/save', 'save', '', '76bcb5891f3847188f22ee67eeab727d');
INSERT INTO `sys_req_url` VALUES ('763bef1c4aa54ece89c3758acbe835b2', '/console/bo_test/edit', 'edit', '', 'c5163d00c529443ab0720dea8c0eacc2');
INSERT INTO `sys_req_url` VALUES ('76ddd2d0f08142d695042984043a0f36', '/console/sys_role/edit', 'edit', '', '5961ed25fd2a41fa9c83bff34390a35f');
INSERT INTO `sys_req_url` VALUES ('76eda725bfb74b6cb7c267a3a61f84e8', '/console/sys_req_url/delete', 'delete', '', 'd156cfadf4884282b50140105f162392');
INSERT INTO `sys_req_url` VALUES ('7b56da95361242e9967b086992581e29', '/console/sys_nav/list', 'list', '', 'ae09fb76077d4bc3adf6fcc5cbcf5116');
INSERT INTO `sys_req_url` VALUES ('7bb46ffdbc9d4280bf773e82f87e424a', '/console/sys_req_url/save', 'save', '', 'd156cfadf4884282b50140105f162392');
INSERT INTO `sys_req_url` VALUES ('85689d019c0b47c98cb576af6446526b', '/console/sys_role/do_nav_accredit/{role_id}', 'do_nav_accredit', '', '5961ed25fd2a41fa9c83bff34390a35f');
INSERT INTO `sys_req_url` VALUES ('87c5b48c37984a07a9dadd8c1e0df5ee', '/console/second/nav', 'secondNav', '', 'c1dd738acd5b442db49dc911c5f7e266');
INSERT INTO `sys_req_url` VALUES ('8933a83684a442b8b82ddf5d132acc34', '/console/login', 'login', '', '4654839ffd514ff4a390d8d3448c611d');
INSERT INTO `sys_req_url` VALUES ('8e46cc87ecc647c4a13f527b194db555', '/console/bo_web_news/list', 'list', '', '6c18e14e264f4224a541ff4216e93022');
INSERT INTO `sys_req_url` VALUES ('8f7b483963da4dcda2023e5beaff80b6', '/console/bo_banner/delete', 'delete', '', '0bf8d00287b14f8dba9132404d171a55');
INSERT INTO `sys_req_url` VALUES ('900297fa24a848a18f65ee56a9819af4', '/common/captcha/get/{id}', 'getCaptchaImage', '', 'a53cd99cdad1453c871ef1a978d8c6d9');
INSERT INTO `sys_req_url` VALUES ('90203448e83c49b58976960616b191d6', '/console/sys_role/delete', 'delete', '', '5961ed25fd2a41fa9c83bff34390a35f');
INSERT INTO `sys_req_url` VALUES ('9c205e0ba8714bfe996556bfd5fe9751', '/console/sys_role/add', 'add', '', '5961ed25fd2a41fa9c83bff34390a35f');
INSERT INTO `sys_req_url` VALUES ('9c92fd140ea44e72bc6c659bf507607a', '/console/bo_test/delete', 'delete', '', 'c5163d00c529443ab0720dea8c0eacc2');
INSERT INTO `sys_req_url` VALUES ('a15216e3d8e84ce2b62943b2c262dfb9', '/console/bo_web_news/add', 'add', '', '6c18e14e264f4224a541ff4216e93022');
INSERT INTO `sys_req_url` VALUES ('a1e7b6e8aab34ec2b7dd785b00acbb3a', '/console/sys_role/nav_accredit/json/{role_id}/{sys_id}', 'nav_accreditJson', '', '5961ed25fd2a41fa9c83bff34390a35f');
INSERT INTO `sys_req_url` VALUES ('a270652c5e554b818795f720f658d38a', '/console/sys_user/reset/password', 'resetPassword', '', '22553952098547c09877b2cef8ad8313');
INSERT INTO `sys_req_url` VALUES ('a37fe437ba0d400c814d1704715d1bec', '/console/bo_web_image/save', 'save', '', 'de76cedeb545481ebbac4dcd6234316f');
INSERT INTO `sys_req_url` VALUES ('a41a29db14c940a695ea04082ba8dbda', '/file/upload/ali', 'uploadAli', '', 'c80da3d1515d47c7bf815f463438039d');
INSERT INTO `sys_req_url` VALUES ('a65a1aacea7c433b831b8e679548fe60', '/console/bo_test/save', 'save', '', 'c5163d00c529443ab0720dea8c0eacc2');
INSERT INTO `sys_req_url` VALUES ('a732f2a40eea4c4ab5e25cb36c90f83f', '/console/bo_web_news/json', 'json', '', '6c18e14e264f4224a541ff4216e93022');
INSERT INTO `sys_req_url` VALUES ('a79b458c20ae44ef972f08864384fce2', '/news/list/json/{type}', 'newsList', '', '9fb81f12fd02449aa8f35b053212a02c');
INSERT INTO `sys_req_url` VALUES ('a7a98bf1930b4be980c9b9c3a7c26479', '/console/bo_web_news/edit', 'edit', '', '6c18e14e264f4224a541ff4216e93022');
INSERT INTO `sys_req_url` VALUES ('adeb103048174404a0b2cf5a581012f2', '/console/select/json', 'json', '', '5d23fb89ff8042d28aba786f5004d825');
INSERT INTO `sys_req_url` VALUES ('b2fbe2757e8d4c13ac183aa1a934dddd', '/console/bo_contact_us/list', 'list', '', 'ce4da1d3b36848c0bac65c88c2f966f9');
INSERT INTO `sys_req_url` VALUES ('b5e729977c994c0f817f3a757e52e5ca', '/console/sys_user/json', 'json', '', '22553952098547c09877b2cef8ad8313');
INSERT INTO `sys_req_url` VALUES ('b738e314301642baa41162381a69f402', '/console/sys_nav/json', 'json', '', 'ae09fb76077d4bc3adf6fcc5cbcf5116');
INSERT INTO `sys_req_url` VALUES ('b9127992cf33418dba0dbdb39b45dac5', '/console/sys_role/req/group/json', 'reqGroupJson', '', '5961ed25fd2a41fa9c83bff34390a35f');
INSERT INTO `sys_req_url` VALUES ('c19daf325816445d8162e9b5a71bcfa0', '/{page}', 'index', '', '9fb81f12fd02449aa8f35b053212a02c');
INSERT INTO `sys_req_url` VALUES ('c569e6fd362b45308e5c0b5809108105', '/console/sys_nav/save', 'save', '', 'ae09fb76077d4bc3adf6fcc5cbcf5116');
INSERT INTO `sys_req_url` VALUES ('c78e51bd47be4a66aaa842ad275dfff7', '/console/nav/trun/first', 'getNavFirstReturn', '', 'c1dd738acd5b442db49dc911c5f7e266');
INSERT INTO `sys_req_url` VALUES ('c96094ce77c748e995141b795848cef7', '/console/sys_req_url/add', 'add', '', 'd156cfadf4884282b50140105f162392');
INSERT INTO `sys_req_url` VALUES ('ccbca2aeb5ae401086152f955fc704a2', '/console/bo_banner/edit', 'edit', '', '0bf8d00287b14f8dba9132404d171a55');
INSERT INTO `sys_req_url` VALUES ('cd99ae910d204cfa8a16be39d166ca5a', '/console/file/exist/{md5}', 'hasFile', '', 'c80da3d1515d47c7bf815f463438039d');
INSERT INTO `sys_req_url` VALUES ('d0d350647e3d4a1d8bc8456cdd419a96', '/console/sys_req_url/json', 'json', '', 'd156cfadf4884282b50140105f162392');
INSERT INTO `sys_req_url` VALUES ('d453057be54449358026a6ef5d45e245', '/console/sys_role/req_accredit/json', 'req_accreditJson', '', '5961ed25fd2a41fa9c83bff34390a35f');
INSERT INTO `sys_req_url` VALUES ('d7875492040a4c5a8dfd42b7818ac01f', '/console/sys_role/nav_accredit/{role_id}', 'nav_accredit', '', '5961ed25fd2a41fa9c83bff34390a35f');
INSERT INTO `sys_req_url` VALUES ('da5a6b2a040848b1849eb8fa39afb537', '/console/export/excel', 'exportExcel', '', '759623c12f324e7c8813935770dc167b');
INSERT INTO `sys_req_url` VALUES ('da81498f05044389a5372824488ab3e4', '/console/bo_banner/json', 'json', '', '0bf8d00287b14f8dba9132404d171a55');
INSERT INTO `sys_req_url` VALUES ('e6405dcd35fe4401a0c5098fc8cba9b7', '/console/sys_role/nav/json', 'navJson', '', '5961ed25fd2a41fa9c83bff34390a35f');
INSERT INTO `sys_req_url` VALUES ('e6749bbe28764a8e8a6b67660e52025d', '/console/sys_nav/delete', 'delete', '', 'ae09fb76077d4bc3adf6fcc5cbcf5116');
INSERT INTO `sys_req_url` VALUES ('e9074bc0e9464df3a451be2b87aafdde', '/console/bo_web_news/delete', 'delete', '', '6c18e14e264f4224a541ff4216e93022');
INSERT INTO `sys_req_url` VALUES ('e9bfa1e90c1f45ebb96773e59d621fc0', '/console/bo_contact_us/json', 'json', '', 'ce4da1d3b36848c0bac65c88c2f966f9');
INSERT INTO `sys_req_url` VALUES ('eda7d889a1a34cf991ce1c326e8c8e4a', '/console/sys_dictionary/list/{code}', 'list', '', '76bcb5891f3847188f22ee67eeab727d');
INSERT INTO `sys_req_url` VALUES ('efea82c1eabe42009a95ff8f4e54a458', '/console/sys_role/list', 'list', '', '5961ed25fd2a41fa9c83bff34390a35f');
INSERT INTO `sys_req_url` VALUES ('f43f6da38eff40d6a661b16a84b14640', '/console/bo_web_image/delete', 'delete', '', 'de76cedeb545481ebbac4dcd6234316f');
INSERT INTO `sys_req_url` VALUES ('fb73654a1bc34af9a9e7ffa8b04bbb6a', '/console/sys_user/delete', 'delete', '', '22553952098547c09877b2cef8ad8313');
INSERT INTO `sys_req_url` VALUES ('fd8c1889a1934aef95e5d094344ce863', '/console/sys_dictionary/edit', 'edit', '', '76bcb5891f3847188f22ee67eeab727d');

-- ----------------------------
-- Table structure for sys_req_url_group
-- ----------------------------
DROP TABLE IF EXISTS `sys_req_url_group`;
CREATE TABLE `sys_req_url_group` (
  `id` varchar(32) COLLATE utf8mb4_slovenian_ci NOT NULL,
  `name` varchar(512) COLLATE utf8mb4_slovenian_ci DEFAULT NULL,
  `description` varchar(512) COLLATE utf8mb4_slovenian_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_slovenian_ci ROW_FORMAT=DYNAMIC COMMENT='请求分组_except(s,c)';

-- ----------------------------
-- Records of sys_req_url_group
-- ----------------------------
INSERT INTO `sys_req_url_group` VALUES ('0bf8d00287b14f8dba9132404d171a55', 'zhang.lao.console.controller.zhang.lao.console.controller.BoBannerController', 'zhang.lao.console.controller.zhang.lao.console.controller.BoBannerController');
INSERT INTO `sys_req_url_group` VALUES ('22553952098547c09877b2cef8ad8313', 'zhang.lao.console.controller.zhang.lao.console.controller.SysUserController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysUserController');
INSERT INTO `sys_req_url_group` VALUES ('4654839ffd514ff4a390d8d3448c611d', 'zhang.lao.console.controller.login.zhang.lao.console.controller.login.LoginController', 'zhang.lao.console.controller.login.zhang.lao.console.controller.login.LoginController');
INSERT INTO `sys_req_url_group` VALUES ('5961ed25fd2a41fa9c83bff34390a35f', 'zhang.lao.console.controller.zhang.lao.console.controller.SysRoleController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysRoleController');
INSERT INTO `sys_req_url_group` VALUES ('5d23fb89ff8042d28aba786f5004d825', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.SelectCommontController', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.SelectCommontController');
INSERT INTO `sys_req_url_group` VALUES ('6c18e14e264f4224a541ff4216e93022', 'zhang.lao.console.controller.zhang.lao.console.controller.BoWebNewsController', 'zhang.lao.console.controller.zhang.lao.console.controller.BoWebNewsController');
INSERT INTO `sys_req_url_group` VALUES ('759623c12f324e7c8813935770dc167b', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.HtmlTableToExcel', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.HtmlTableToExcel');
INSERT INTO `sys_req_url_group` VALUES ('76bcb5891f3847188f22ee67eeab727d', 'zhang.lao.console.controller.zhang.lao.console.controller.SysDictionaryController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysDictionaryController');
INSERT INTO `sys_req_url_group` VALUES ('9fb81f12fd02449aa8f35b053212a02c', 'zhang.lao.console.controller.front.zhang.lao.console.controller.front.IndexController', 'zhang.lao.console.controller.front.zhang.lao.console.controller.front.IndexController');
INSERT INTO `sys_req_url_group` VALUES ('a53cd99cdad1453c871ef1a978d8c6d9', 'zhang.lao.console.controller.common.captcha.zhang.lao.console.controller.common.captcha.CaptchaController', 'zhang.lao.console.controller.common.captcha.zhang.lao.console.controller.common.captcha.CaptchaController');
INSERT INTO `sys_req_url_group` VALUES ('ae09fb76077d4bc3adf6fcc5cbcf5116', 'zhang.lao.console.controller.zhang.lao.console.controller.SysNavController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysNavController');
INSERT INTO `sys_req_url_group` VALUES ('c1dd738acd5b442db49dc911c5f7e266', 'zhang.lao.console.controller.nav.zhang.lao.console.controller.nav.PageTurnController', 'zhang.lao.console.controller.nav.zhang.lao.console.controller.nav.PageTurnController');
INSERT INTO `sys_req_url_group` VALUES ('c5163d00c529443ab0720dea8c0eacc2', 'zhang.lao.console.controller.zhang.lao.console.controller.BoTestController', 'zhang.lao.console.controller.zhang.lao.console.controller.BoTestController');
INSERT INTO `sys_req_url_group` VALUES ('c80da3d1515d47c7bf815f463438039d', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.FileUpAndDown', 'zhang.lao.console.controller.common.zhang.lao.console.controller.common.FileUpAndDown');
INSERT INTO `sys_req_url_group` VALUES ('ce4da1d3b36848c0bac65c88c2f966f9', 'zhang.lao.console.controller.zhang.lao.console.controller.BoContactUsController', 'zhang.lao.console.controller.zhang.lao.console.controller.BoContactUsController');
INSERT INTO `sys_req_url_group` VALUES ('d156cfadf4884282b50140105f162392', 'zhang.lao.console.controller.zhang.lao.console.controller.SysReqUrlController', 'zhang.lao.console.controller.zhang.lao.console.controller.SysReqUrlController');
INSERT INTO `sys_req_url_group` VALUES ('de76cedeb545481ebbac4dcd6234316f', 'zhang.lao.console.controller.zhang.lao.console.controller.BoWebImageController', 'zhang.lao.console.controller.zhang.lao.console.controller.BoWebImageController');

-- ----------------------------
-- Table structure for sys_req_url_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_req_url_role`;
CREATE TABLE `sys_req_url_role` (
  `id` varchar(32) COLLATE utf8mb4_slovenian_ci NOT NULL,
  `role_id` varchar(32) COLLATE utf8mb4_slovenian_ci DEFAULT NULL,
  `req_url` varchar(1024) COLLATE utf8mb4_slovenian_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_slovenian_ci ROW_FORMAT=DYNAMIC COMMENT='请求角色_except(s,c)';

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_slovenian_ci ROW_FORMAT=DYNAMIC COMMENT='请求白名单_except(s,c)';

-- ----------------------------
-- Records of sys_req_url_white_list
-- ----------------------------
INSERT INTO `sys_req_url_white_list` VALUES ('1', '/console/first/nav', '/console/first/nav', '/console/first/nav');
INSERT INTO `sys_req_url_white_list` VALUES ('11', '/file/upload/ckeditor', '1', '1');
INSERT INTO `sys_req_url_white_list` VALUES ('2', '/', '1', '1');
INSERT INTO `sys_req_url_white_list` VALUES ('3', '/common/captcha/get/{id}', '1', '1');
INSERT INTO `sys_req_url_white_list` VALUES ('4', '/console', '1', '1');
INSERT INTO `sys_req_url_white_list` VALUES ('5', '/console/login\r\n/console/logout', '1', '1');
INSERT INTO `sys_req_url_white_list` VALUES ('6', '/console/nav/trun/first', '1', '1');
INSERT INTO `sys_req_url_white_list` VALUES ('7', '/console/select/json', '1', '1');
INSERT INTO `sys_req_url_white_list` VALUES ('8', '/file/upload', '1', '1');
INSERT INTO `sys_req_url_white_list` VALUES ('9', '/file/upload/ali', '1', '1');

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
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统角色，开发者平台、后台管理统一维护';

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
  PRIMARY KEY (`su_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统管理用户';

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
  PRIMARY KEY (`snr_id`) USING BTREE,
  KEY `FK_Reference_16` (`su_id`) USING BTREE,
  KEY `FK_Reference_17` (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户角色_except(s,c)';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('29', '1', '1');
