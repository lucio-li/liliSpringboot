/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : lili

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-10-24 00:18:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `id` varchar(128) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `size` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `moments_id` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `update_user` varchar(255) DEFAULT NULL,
  `status` int(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attachment
-- ----------------------------
INSERT INTO `attachment` VALUES ('2a73fdb9a6c343e1bb2f708b3cf7c681', 'jpg', '327611', 'sss (1).jpg', 'b2d8fe22b7d94869aba9a601c20fdd91', '2018-10-13 16:54:44', '2018-10-13 16:54:44', null, null, '0');
INSERT INTO `attachment` VALUES ('2efd7042a774470f82ac3df13e3d1b3d', 'jpg', '327611', 'sss (1).jpg', 'b2d8fe22b7d94869aba9a601c20fdd91', '2018-10-13 16:55:11', '2018-10-13 16:55:11', null, null, '0');
INSERT INTO `attachment` VALUES ('40a977bd769e4e129521cd0e1435c511', 'jpg', '327611', 'wx43391e3140e0d290.o6zAJswzNWxs6nL1Zut7hznnpzTs.j32YTxWn8gws6a6646d1b5d6866ff89b71d592fe3897.jpg', 'c7f12938f7274d578c5668b4200ae267', '2018-10-20 20:25:02', '2018-10-20 20:25:02', null, null, '1');
INSERT INTO `attachment` VALUES ('84951ea9fc4a496ea7e50b8bb5be43e6', 'jpg', '192385', 'wx43391e3140e0d290.o6zAJswzNWxs6nL1Zut7hznnpzTs.8PwQYbg3kMJjc4f396442c9c7806b3783428a76a9ac0.jpg', 'c7f12938f7274d578c5668b4200ae267', '2018-10-20 20:25:02', '2018-10-20 20:25:02', null, null, '1');
INSERT INTO `attachment` VALUES ('89bca328082f4d4dbe8453aec58cb00a', 'jpg', '327611', 'sss (1).jpg', '1', '2018-10-13 17:17:19', '2018-10-13 17:17:19', null, null, '1');
INSERT INTO `attachment` VALUES ('c3d3928677fb400397ef33ad0b70f3f6', 'jpg', '327611', 'wx43391e3140e0d290.o6zAJswzNWxs6nL1Zut7hznnpzTs.j32YTxWn8gws6a6646d1b5d6866ff89b71d592fe3897.jpg', '670b3017b04447faa83ae9ea31cb78d4', '2018-10-20 20:28:43', '2018-10-20 20:28:43', null, null, '1');
INSERT INTO `attachment` VALUES ('da36a8cbd5cd472eaa503c6dd7803063', 'jpg', '192385', 'wx43391e3140e0d290.o6zAJswzNWxs6nL1Zut7hznnpzTs.8PwQYbg3kMJjc4f396442c9c7806b3783428a76a9ac0.jpg', '670b3017b04447faa83ae9ea31cb78d4', '2018-10-20 20:28:43', '2018-10-20 20:28:43', null, null, '1');
INSERT INTO `attachment` VALUES ('fbc6c3c615d7410492f2a9558fe473ec', 'jpg', '327611', 'wx43391e3140e0d290.o6zAJswzNWxs6nL1Zut7hznnpzTs.kLF3oWGVxey66a6646d1b5d6866ff89b71d592fe3897.jpg', 'd525ec09222e4bbb809a28b9e7fcaab3', '2018-10-24 00:13:23', '2018-10-24 00:13:23', null, null, '1');

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` varchar(128) CHARACTER SET utf8 NOT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '发布时间',
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `aim_user` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `moments_id` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('35e5c0f7a2a241609fd345abccf61fa3', '2018-10-21 22:52:43', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '[03][03]', null, '2a654f9b3abc408c9ca786f7d0d585bc', '2018-10-21 22:52:43', null, '1');
INSERT INTO `comments` VALUES ('880ee555ed3a483bbd11e01f4f4539ad', '2018-10-21 22:55:07', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '[04][04][04]', null, '35938b5ba11b4f938c95243e5aecfcf7', '2018-10-21 22:55:07', null, '1');
INSERT INTO `comments` VALUES ('9a582d4c94554960b3a29268cbd94bc4', '2018-10-21 22:53:11', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '[12][12]', null, 'c0ef90d79bcc4c56b06f044b6db24a7a', '2018-10-21 22:53:11', null, '1');
INSERT INTO `comments` VALUES ('9aff358ea59b4066b08b4ef3b292534c', '2018-10-21 22:51:16', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '[11][12][12]', null, 'a81ac8f607fa4864acf2c4ea3496893b', '2018-10-21 22:51:16', null, '1');
INSERT INTO `comments` VALUES ('a2b464ad95e5402b802cf921fbc5d291', '2018-10-21 23:03:40', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '[04][04][04]', null, '2a654f9b3abc408c9ca786f7d0d585bc', '2018-10-21 23:03:40', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '1');
INSERT INTO `comments` VALUES ('a63c658d1e49415cacc6960f3390541a', '2018-10-21 22:54:11', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '[05][05]', null, 'c52d11e52ca5471ba59bbbcc8975a7dc', '2018-10-21 22:54:11', null, '1');
INSERT INTO `comments` VALUES ('ab82a5c3ca1243d7878b782741bbbf4a', '2018-10-22 00:07:30', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '[05][05][05][05]', null, '670b3017b04447faa83ae9ea31cb78d4', '2018-10-22 00:07:30', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '1');
INSERT INTO `comments` VALUES ('ac0bc1acb406468d939ea99c4ec7b89d', '2018-10-21 22:51:02', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '[11][12][12]', null, 'a81ac8f607fa4864acf2c4ea3496893b', '2018-10-21 22:51:02', null, '1');
INSERT INTO `comments` VALUES ('b218aad1961f4c818fd09e9115e8ded0', '2018-10-21 23:05:06', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '[05][05][05][05]', null, 'c52d11e52ca5471ba59bbbcc8975a7dc', '2018-10-21 23:05:06', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '1');
INSERT INTO `comments` VALUES ('d3667259cd0a44ab9cc3e355bf5aed11', '2018-10-12 23:44:56', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '评论', 'asa', 'b2d8fe22b7d94869aba9a601c20fdd91', '2018-10-12 23:44:56', '121', '1');
INSERT INTO `comments` VALUES ('d3667259cd0a44ab9cc3e355bf5aed15', '2018-10-12 23:44:56', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '评论', 'asa', 'b2d8fe22b7d94869aba9a601c20fdd91', '2018-10-12 23:44:56', '121', '1');
INSERT INTO `comments` VALUES ('d5c86cf2dc7f4291815946ed3c20ff8c', '2018-10-22 00:07:38', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '[13][12]', null, '670b3017b04447faa83ae9ea31cb78d4', '2018-10-22 00:07:38', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '1');
INSERT INTO `comments` VALUES ('e76b5da7aa974151b52bfb13c8bc2350', '2018-10-22 00:07:03', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '[03][03][03]', null, 'f0fee23788f341b6880978a3dbc9a6fd', '2018-10-22 00:07:03', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '1');
INSERT INTO `comments` VALUES ('ee92f08215be4b2383b0074c18562119', '2018-10-21 22:52:28', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '[03][03]', null, 'f0fee23788f341b6880978a3dbc9a6fd', '2018-10-21 22:52:28', null, '1');

-- ----------------------------
-- Table structure for moments
-- ----------------------------
DROP TABLE IF EXISTS `moments`;
CREATE TABLE `moments` (
  `id` varchar(255) CHARACTER SET utf8 NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(255) DEFAULT '1',
  `update_user` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of moments
-- ----------------------------
INSERT INTO `moments` VALUES ('226c86684bcb439f82727620dff62bad', '2018-10-23 22:13:52', '测试', '', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '2018-10-23 22:13:52', '1', 'o70L30FY-FZdDyrhKI_E7vQqVCg0');
INSERT INTO `moments` VALUES ('2a654f9b3abc408c9ca786f7d0d585bc', '2018-10-23 23:37:05', '热舞? ? ? 你好，很好，起步额你我央视影音? ? ? ? ? ? ? ', '', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '2018-10-23 23:37:05', '1', 'o70L30FY-FZdDyrhKI_E7vQqVCg0');
INSERT INTO `moments` VALUES ('2ea8bf537ea94a178561e3f4ed841b26', '2018-10-23 23:52:33', 'sadfsadfasfd', '', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '2018-10-23 23:52:33', '1', 'o70L30FY-FZdDyrhKI_E7vQqVCg0');
INSERT INTO `moments` VALUES ('596f5ffaf46e42d8a5ab0ad99c0b39d9', '2018-10-23 23:32:48', '? ? ? ? ', '', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '2018-10-23 23:32:48', '1', 'o70L30FY-FZdDyrhKI_E7vQqVCg0');
INSERT INTO `moments` VALUES ('a3c9b5b4527d462d9b197d6a6f85712f', '2018-10-23 23:31:09', '? ? ? ? ? ? ? ', '', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '2018-10-23 23:31:09', '1', 'o70L30FY-FZdDyrhKI_E7vQqVCg0');
INSERT INTO `moments` VALUES ('d525ec09222e4bbb809a28b9e7fcaab3', '2018-10-24 00:13:23', '????????aDSAs?????????????????', '广州市天河区文化局(天府路西)', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '2018-10-24 00:13:23', '1', 'o70L30FY-FZdDyrhKI_E7vQqVCg0');
INSERT INTO `moments` VALUES ('f0fee23788f341b6880978a3dbc9a6fd', '2018-10-20 20:32:01', '', '', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', '2018-10-20 20:32:01', '1', 'o70L30FY-FZdDyrhKI_E7vQqVCg0');

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
INSERT INTO `user` VALUES ('43d5bcf0933d49ff8dc8bbaa7229f538', '枫桥夜泊', 'o70L30FY-FZdDyrhKI_E7vQqVCg0', 'https://wx.qlogo.cn/mmopen/vi_32/lwy6Y5ybTj1iaJw8ic7l6vXriaHyXOPAlGeknINSOgAG8qAGRSKFJCLicxPAicdMrp3XibfWCHIq2odEKuQnPic3fpsAQ/132');
