/*
Navicat MySQL Data Transfer

Source Server         : 寻亲记
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : tracing

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-09-27 17:22:06
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
