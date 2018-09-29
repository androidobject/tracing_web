/*
Navicat MySQL Data Transfer

Source Server         : tracing
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : tracing

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2018-09-29 14:55:47
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of essay
-- ----------------------------

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
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------

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
INSERT INTO `user` VALUES ('3', '18766552101', '18766552101', '1123456', '', null, null, '2018-09-29 星期六 下午 14:52:53', 'android', null);
