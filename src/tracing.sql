/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : tracing

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-09-30 21:14:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '全国');
INSERT INTO `city` VALUES ('11', '北京');
INSERT INTO `city` VALUES ('12', '上海');
INSERT INTO `city` VALUES ('13', '天津');
INSERT INTO `city` VALUES ('14', '山东');
INSERT INTO `city` VALUES ('15', '河北');
INSERT INTO `city` VALUES ('16', '河南');
INSERT INTO `city` VALUES ('17', '黑龙江');
INSERT INTO `city` VALUES ('18', '江苏');
INSERT INTO `city` VALUES ('19', '浙江');
INSERT INTO `city` VALUES ('20', '内蒙古');
INSERT INTO `city` VALUES ('21', '新疆');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `lost_info_id` int(50) NOT NULL,
  `collect_time` varchar(255) NOT NULL,
  `collect_by_phone` varchar(255) NOT NULL,
  `collect_user_id` int(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collect
-- ----------------------------

-- ----------------------------
-- Table structure for commit
-- ----------------------------
DROP TABLE IF EXISTS `commit`;
CREATE TABLE `commit` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT,
  `commit_content` varchar(255) DEFAULT NULL,
  `commit_user_id` bigint(255) NOT NULL,
  `commit_lost_id` int(50) NOT NULL,
  `create_time` varchar(50) NOT NULL,
  `commit_by_phone` varchar(255) NOT NULL,
  `useful` bigint(255) NOT NULL,
  `unuserful` bigint(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commit
-- ----------------------------

-- ----------------------------
-- Table structure for essay
-- ----------------------------
DROP TABLE IF EXISTS `essay`;
CREATE TABLE `essay` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_time` varchar(50) DEFAULT NULL,
  `essay_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of essay
-- ----------------------------
INSERT INTO `essay` VALUES ('1', '关爱被拐卖儿童的美文', '儿童被拐卖或走失的悲剧，每天都在上演。据中国最大的寻子网站“宝贝回家”统计，从2007年成立至2013年5月，该网站共收到全国寻子登记5000多条，其中90%是因为监管缺失导致孩子被拐走，一半被拐家庭属于农民工家庭。\r\n面临残酷的现实，丢失骨肉的父母们是多么痛心疾首，如果你也有孩子，如果你的孩子也成为失踪儿童，那你该怎么办呢？这并不是诅咒，所有家长都应该接着往下看。', '2018-09-29 星期六 下午 14:52:53', 'http://www.bdfqy.com/aiqingyulu/1687009.html');
INSERT INTO `essay` VALUES ('2', '失踪儿童矿泉水引争议 企业能走多久', '近日，山东省青岛市不少细心市民发现，青岛市区部分便利店出现一款印有失踪儿童头像的矿泉水，瓶体上印着失踪儿童头像及其基本信息，厂家承诺对帮助孩子还家者重奖10万元。', '2018-09-29 星期六 下午 14:52:53', 'http://news.qinbei.com/20161116/1826286.shtml');

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `record_id` bigint(255) NOT NULL AUTO_INCREMENT,
  `create_time` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `feedback_by_phone` varchar(255) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('1', '2018-09-30 星期日 下午 20:24:44', 'app不错，继续加油哦。。000000000000000000000000000000', null, 'android', '1');
INSERT INTO `feedback` VALUES ('2', '2018-09-30 星期日 下午 20:25:16', 'app不错，继续加油哦。。000000000000000000000000000000', '18766552107', 'android', '1');
INSERT INTO `feedback` VALUES ('3', '2018-09-30 星期日 下午 20:25:17', 'app不错，继续加油哦。。000000000000000000000000000000', '18766552107', 'android', '1');
INSERT INTO `feedback` VALUES ('4', '2018-09-30 星期日 下午 20:25:18', 'app不错，继续加油哦。。000000000000000000000000000000', '18766552107', 'android', '1');
INSERT INTO `feedback` VALUES ('5', '2018-09-30 星期日 下午 20:25:18', 'app不错，继续加油哦。。000000000000000000000000000000', '18766552107', 'android', '1');
INSERT INTO `feedback` VALUES ('6', '2018-09-30 星期日 下午 20:25:18', 'app不错，继续加油哦。。000000000000000000000000000000', '18766552107', 'android', '1');
INSERT INTO `feedback` VALUES ('7', '2018-09-30 星期日 下午 20:25:19', 'app不错，继续加油哦。。000000000000000000000000000000', '18766552107', 'android', '1');
INSERT INTO `feedback` VALUES ('8', '2018-09-30 星期日 下午 20:25:19', 'app不错，继续加油哦。。000000000000000000000000000000', '18766552107', 'android', '1');
INSERT INTO `feedback` VALUES ('9', '2018-09-30 星期日 下午 20:25:19', 'app不错，继续加油哦。。000000000000000000000000000000', '18766552107', 'android', '1');

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `file_type` varchar(255) NOT NULL COMMENT '0 头像、1lost 图像',
  `user_id` int(50) DEFAULT NULL,
  `lost_info_id` int(50) DEFAULT NULL,
  `file_url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file
-- ----------------------------

-- ----------------------------
-- Table structure for lost_info
-- ----------------------------
DROP TABLE IF EXISTS `lost_info`;
CREATE TABLE `lost_info` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `lost_name` varchar(255) NOT NULL,
  `lost_age` varchar(255) DEFAULT NULL,
  `lost_sex` varchar(255) NOT NULL,
  `lost_high` varchar(255) DEFAULT NULL,
  `last_see_time` varchar(255) DEFAULT NULL,
  `lost_area` varchar(20) NOT NULL,
  `create_time` varchar(255) NOT NULL,
  `contact_name` varchar(255) NOT NULL,
  `contact_phone` varchar(255) NOT NULL,
  `contact_wx` varchar(255) DEFAULT NULL,
  `contact_address` varchar(255) DEFAULT NULL,
  `send_by_phone` varchar(255) NOT NULL,
  `look_time` bigint(255) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lost_info
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) NOT NULL,
  `user_name` varchar(255) DEFAULT '',
  `password` varchar(255) NOT NULL,
  `photo` varchar(255) DEFAULT '',
  `address` varchar(255) DEFAULT NULL,
  `weixin` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) NOT NULL,
  `rigister_by_phone` varchar(255) NOT NULL,
  `last_login_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', '18766552101', '18766552101', '1123456', '', null, null, '2018-09-29 星期六 下午 14:52:53', 'android', '2018-09-30 星期日 下午 20:13:25');
