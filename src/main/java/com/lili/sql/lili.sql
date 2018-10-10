/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : lili

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-10-09 23:45:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `id` varchar(128) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `size` double DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `moments_id` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attachment
-- ----------------------------

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` varchar(128) NOT NULL,
  `moments_time` datetime DEFAULT NULL COMMENT '发布时间',
  `name` varchar(255) DEFAULT NULL,
  `content_detail` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk` (`moments_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------

-- ----------------------------
-- Table structure for moments
-- ----------------------------
DROP TABLE IF EXISTS `moments`;
CREATE TABLE `moments` (
  `time` varchar(255) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `directory` varchar(255) DEFAULT NULL,
  `avatarUrl` varchar(255) DEFAULT NULL COMMENT '头像url地址',
  `aimUser` varchar(255) DEFAULT NULL COMMENT '回复谁',
  PRIMARY KEY (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of moments
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `headImg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
