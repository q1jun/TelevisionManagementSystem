/*
 Navicat Premium Data Transfer

 Source Server         : mac
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : tv

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 28/12/2021 23:00:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ad_dispatch
-- ----------------------------
DROP TABLE IF EXISTS `ad_dispatch`;
CREATE TABLE `ad_dispatch` (
  `adid` int unsigned NOT NULL AUTO_INCREMENT COMMENT '广告投放编号',
  `aid` int unsigned NOT NULL COMMENT '广告编号',
  `cid` int unsigned NOT NULL COMMENT '栏目编号',
  PRIMARY KEY (`adid`,`aid`,`cid`),
  KEY `aid1` (`aid`),
  KEY `cid1` (`cid`),
  CONSTRAINT `aid1` FOREIGN KEY (`aid`) REFERENCES `advertisement` (`aid`),
  CONSTRAINT `cid1` FOREIGN KEY (`cid`) REFERENCES `column` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for advertisement
-- ----------------------------
DROP TABLE IF EXISTS `advertisement`;
CREATE TABLE `advertisement` (
  `aid` int unsigned NOT NULL AUTO_INCREMENT COMMENT '广告编号',
  `aprice` decimal(10,2) NOT NULL COMMENT '广告价格',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for column
-- ----------------------------
DROP TABLE IF EXISTS `column`;
CREATE TABLE `column` (
  `cid` int unsigned NOT NULL AUTO_INCREMENT COMMENT '栏目编号',
  `cname` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '栏目名称',
  `ctime` datetime NOT NULL COMMENT '播出时间',
  `cduration` int NOT NULL COMMENT '播出时长(秒)',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for dispatch_audit
-- ----------------------------
DROP TABLE IF EXISTS `dispatch_audit`;
CREATE TABLE `dispatch_audit` (
  `dlaid` int unsigned NOT NULL AUTO_INCREMENT COMMENT '调度单审计编号',
  `dlid` int unsigned NOT NULL COMMENT '调度单编号',
  `dluid` int unsigned NOT NULL COMMENT '审计人员名称',
  `dlstatus` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '未审批' COMMENT '调度单状态',
  PRIMARY KEY (`dlaid`,`dlid`,`dluid`) USING BTREE,
  KEY `dlid` (`dlid`),
  KEY `dluid` (`dluid`),
  CONSTRAINT `dispatch_audit_ibfk_1` FOREIGN KEY (`dlid`) REFERENCES `dispatch_list` (`did`),
  CONSTRAINT `dispatch_audit_ibfk_2` FOREIGN KEY (`dluid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for dispatch_list
-- ----------------------------
DROP TABLE IF EXISTS `dispatch_list`;
CREATE TABLE `dispatch_list` (
  `did` int unsigned NOT NULL AUTO_INCREMENT COMMENT '调度单号',
  `cid` int unsigned NOT NULL COMMENT '被协调栏目编号',
  `tvrid` int unsigned NOT NULL COMMENT '演播厅房间号',
  `uid` int unsigned NOT NULL COMMENT '员工编号',
  PRIMARY KEY (`did`,`cid`,`tvrid`,`uid`),
  KEY `cid` (`cid`),
  KEY `tvrid` (`tvrid`),
  KEY `uid` (`uid`),
  KEY `did` (`did`),
  CONSTRAINT `cid` FOREIGN KEY (`cid`) REFERENCES `column` (`cid`),
  CONSTRAINT `tvrid` FOREIGN KEY (`tvrid`) REFERENCES `tv_room` (`tvrid`),
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for tv_room
-- ----------------------------
DROP TABLE IF EXISTS `tv_room`;
CREATE TABLE `tv_room` (
  `tvrid` int unsigned NOT NULL COMMENT '演播厅房间号',
  `tvrsize` double(10,2) DEFAULT NULL COMMENT '演播厅大小',
  PRIMARY KEY (`tvrid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int unsigned NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `uname` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '员工姓名',
  `uposition` varchar(12) COLLATE utf8_unicode_ci NOT NULL COMMENT '员工职位',
  `ugender` varchar(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工性别',
  `ubirthday` datetime DEFAULT NULL COMMENT '员工生日',
  `utel` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工电话',
  `uaddress` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工住址',
  `upassword` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '员工密码',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

SET FOREIGN_KEY_CHECKS = 1;
