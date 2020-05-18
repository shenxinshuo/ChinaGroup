-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: findwork
-- ------------------------------------------------------
-- Server version	8.0.15-commercial

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `passowrd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (2,'沈鑫烁','123456'),(3,'mike','4843'),(4,'you',NULL),(5,'john','520'),(6,'salary','1314');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_admin`
--

DROP TABLE IF EXISTS `t_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_admin` (
  `ADid` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `Apassword` varchar(255) NOT NULL COMMENT '登录密码',
  `Aaccount` varchar(50) NOT NULL COMMENT '登录账号',
  `comment` varchar(255) DEFAULT NULL COMMENT '投诉备注',
  `delete_flag` tinyint(1) DEFAULT '0' COMMENT '删除标识',
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `Rid` int(10) DEFAULT NULL,
  PRIMARY KEY (`ADid`),
  UNIQUE KEY `ADid` (`ADid`),
  UNIQUE KEY `Aaccount` (`Aaccount`),
  KEY `FK_ADMIN_ROLE_idx` (`Rid`),
  CONSTRAINT `FK_ADMIN_ROLE` FOREIGN KEY (`Rid`) REFERENCES `t_role` (`Rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin`
--

LOCK TABLES `t_admin` WRITE;
/*!40000 ALTER TABLE `t_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_advertise`
--

DROP TABLE IF EXISTS `t_advertise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_advertise` (
  `Aid` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `Bid` int(10) DEFAULT NULL COMMENT '企业ID，外键',
  `Bname` varchar(50) DEFAULT NULL COMMENT '企业名',
  `Atitle` varchar(200) DEFAULT NULL COMMENT '招聘标题',
  `Apost` varchar(50) NOT NULL COMMENT '招聘岗位',
  `Aeducation_background` varchar(255) DEFAULT NULL COMMENT '学历',
  `Alow_wages` int(10) DEFAULT NULL COMMENT '最低工资',
  `Alarge_wages` int(10) DEFAULT NULL COMMENT '最高工资',
  `Aask` varchar(255) DEFAULT NULL COMMENT '岗位要求',
  `Awant_joy_type` varchar(50) DEFAULT NULL COMMENT '想招的工作类型：实习，全职。。',
  `Adeadline` datetime DEFAULT NULL COMMENT '接受报名截止日期',
  `delete_flag` int(1) NOT NULL DEFAULT '0' COMMENT '删除标识，0：正常，1：已删除',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_at` datetime DEFAULT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `Acheck` tinyint(4) DEFAULT '0' COMMENT '是否已审核',
  `Bcity` varchar(20) DEFAULT NULL COMMENT '企业所在城市',
  `PTid` int(10) DEFAULT NULL,
  PRIMARY KEY (`Aid`),
  UNIQUE KEY `Aid` (`Aid`),
  KEY `FK_ADVERTISE_BUSINESS_BID` (`Bid`),
  KEY `FK_ADVERTISE_POST_idx` (`PTid`),
  CONSTRAINT `FK_ADVERTISE_BUSINESS_BID` FOREIGN KEY (`Bid`) REFERENCES `t_business` (`Bid`),
  CONSTRAINT `FK_ADVERTISE_POST` FOREIGN KEY (`PTid`) REFERENCES `t_post` (`Pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='招聘信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_advertise`
--

LOCK TABLES `t_advertise` WRITE;
/*!40000 ALTER TABLE `t_advertise` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_advertise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_advertisement`
--

DROP TABLE IF EXISTS `t_advertisement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_advertisement` (
  `Aid` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `Atopic` varchar(200) DEFAULT NULL COMMENT '广告主题',
  `Bid` int(10) DEFAULT NULL COMMENT '外键（企业表）',
  `Acost` int(10) NOT NULL COMMENT '广告费用',
  `Apicture` varchar(150) DEFAULT NULL COMMENT '宣传图片地址',
  `Aurl` varchar(100) DEFAULT NULL COMMENT '宣传链接',
  `delete_flag` int(1) NOT NULL DEFAULT '0' COMMENT '删除标识，0：正常，1：已删除',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_at` datetime DEFAULT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`Aid`),
  UNIQUE KEY `Aid` (`Aid`),
  KEY `FK_ADVERTISEMRNT_BUSINESS_BID` (`Bid`),
  CONSTRAINT `FK_ADVERTISEMRNT_BUSINESS_BID` FOREIGN KEY (`Bid`) REFERENCES `t_business` (`Bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='广告表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_advertisement`
--

LOCK TABLES `t_advertisement` WRITE;
/*!40000 ALTER TABLE `t_advertisement` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_advertisement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_blacklist`
--

DROP TABLE IF EXISTS `t_blacklist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_blacklist` (
  `Bid` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `BusinessID` int(10) DEFAULT NULL COMMENT '外键（Business）',
  `AdvertiseID` int(10) DEFAULT NULL COMMENT '外键（Advertise）',
  `comment` varchar(255) DEFAULT NULL COMMENT '投诉备注',
  `delete_flag` tinyint(1) DEFAULT '0' COMMENT '删除标识',
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  PRIMARY KEY (`Bid`),
  UNIQUE KEY `Bid` (`Bid`),
  KEY `FK_BLACKLIST_BUSINESS` (`BusinessID`),
  KEY `FK_BLACKLIST_ADVERTISE` (`AdvertiseID`),
  CONSTRAINT `FK_BLACKLIST_ADVERTISE` FOREIGN KEY (`AdvertiseID`) REFERENCES `t_advertise` (`Aid`),
  CONSTRAINT `FK_BLACKLIST_BUSINESS` FOREIGN KEY (`BusinessID`) REFERENCES `t_business` (`Bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='黑名单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blacklist`
--

LOCK TABLES `t_blacklist` WRITE;
/*!40000 ALTER TABLE `t_blacklist` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_blacklist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_business`
--

DROP TABLE IF EXISTS `t_business`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_business` (
  `Bid` int(10) NOT NULL AUTO_INCREMENT COMMENT '企业ID，主键',
  `Rid` int(10) DEFAULT NULL COMMENT '角色ID，外键',
  `Bname` varchar(50) NOT NULL COMMENT '企业名称',
  `Bcity` varchar(20) NOT NULL COMMENT '企业所在城市',
  `Btelephone` char(11) NOT NULL COMMENT '企业联系电话',
  `Bemail` varchar(50) DEFAULT NULL COMMENT '企业邮箱',
  `Baddress` varchar(255) DEFAULT NULL COMMENT '企业地址',
  `Bdescription` varchar(255) DEFAULT NULL COMMENT '企业简介',
  `Burl` varchar(255) DEFAULT NULL COMMENT '公司详情超链接',
  `delete_flag` int(1) NOT NULL DEFAULT '0' COMMENT '删除标识，0：正常，1：已删除',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_at` datetime DEFAULT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  `Bpassword` varchar(255) DEFAULT NULL COMMENT '企业登录密码',
  `Bcheck_flag` tinyint(2) DEFAULT '0' COMMENT '审核状态（0:待审核 1：通过 -1：未）',
  PRIMARY KEY (`Bid`),
  UNIQUE KEY `Bid` (`Bid`),
  KEY `FK_BUSINESS_ROLE_RID` (`Rid`),
  CONSTRAINT `FK_BUSINESS_ROLE_RID` FOREIGN KEY (`Rid`) REFERENCES `t_role` (`Rid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='企业表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_business`
--

LOCK TABLES `t_business` WRITE;
/*!40000 ALTER TABLE `t_business` DISABLE KEYS */;
INSERT INTO `t_business` VALUES (2,NULL,'阿里巴巴','杭州','0',NULL,NULL,NULL,NULL,1,NULL,'2020-05-15 11:23:18','2020-05-16 23:18:08','mayu',0),(3,2,'腾讯','马化腾','0',NULL,NULL,NULL,NULL,0,NULL,'2020-05-15 11:39:21','2020-05-15 11:39:21',NULL,0),(4,NULL,'百度','北京','0',NULL,NULL,NULL,NULL,1,'百度李彦宏','2020-05-16 23:07:36','2020-05-17 15:49:33','liyanhong',0);
/*!40000 ALTER TABLE `t_business` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_collection_advertise`
--

DROP TABLE IF EXISTS `t_collection_advertise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_collection_advertise` (
  `Cid` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `Uid` int(10) DEFAULT NULL COMMENT '外键（用户表）',
  `Aid` int(10) DEFAULT NULL COMMENT '外键（招聘信息表）',
  `delete_flag` int(1) NOT NULL DEFAULT '0' COMMENT '删除标识，0：正常，1：已删除',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_at` datetime DEFAULT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`Cid`),
  UNIQUE KEY `Cid` (`Cid`),
  KEY `FK_COLLECTION_AD_USER_UID` (`Uid`),
  KEY `FK_COLLECTION_AD_ADVERTISE_AID` (`Aid`),
  CONSTRAINT `FK_COLLECTION_AD_ADVERTISE_AID` FOREIGN KEY (`Aid`) REFERENCES `t_advertise` (`Aid`),
  CONSTRAINT `FK_COLLECTION_AD_USER_UID` FOREIGN KEY (`Uid`) REFERENCES `t_user` (`Uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='收藏中心（简历）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_collection_advertise`
--

LOCK TABLES `t_collection_advertise` WRITE;
/*!40000 ALTER TABLE `t_collection_advertise` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_collection_advertise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_collection_business`
--

DROP TABLE IF EXISTS `t_collection_business`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_collection_business` (
  `Cid` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `Uid` int(10) DEFAULT NULL COMMENT '外键（用户表）',
  `Bid` int(10) DEFAULT NULL COMMENT '外键（企业表）',
  `delete_flag` int(1) NOT NULL DEFAULT '0' COMMENT '删除标识，0：正常，1：已删除',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_at` datetime DEFAULT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`Cid`),
  UNIQUE KEY `Cid` (`Cid`),
  KEY `FK_COLLECTION_BU_USER_UID` (`Uid`),
  KEY `FK_COLLECTION_BU_BUSINESS_BID` (`Bid`),
  CONSTRAINT `FK_COLLECTION_BU_BUSINESS_BID` FOREIGN KEY (`Bid`) REFERENCES `t_business` (`Bid`),
  CONSTRAINT `FK_COLLECTION_BU_USER_UID` FOREIGN KEY (`Uid`) REFERENCES `t_user` (`Uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='收藏中心（企业）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_collection_business`
--

LOCK TABLES `t_collection_business` WRITE;
/*!40000 ALTER TABLE `t_collection_business` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_collection_business` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_comment`
--

DROP TABLE IF EXISTS `t_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_comment` (
  `Cid` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `Aid` int(10) DEFAULT NULL COMMENT '外键（招聘信息表）',
  `Uid` int(10) DEFAULT NULL COMMENT '外键（用户表）',
  `Ccontent` varchar(255) NOT NULL COMMENT '评论内容',
  `Ctime` datetime NOT NULL COMMENT '何时评论',
  `Canswer` varchar(255) DEFAULT NULL COMMENT '企业回复内容',
  `Canswer_time` datetime DEFAULT NULL COMMENT '企业回复时间',
  `delete_flag` int(1) NOT NULL DEFAULT '0' COMMENT '删除标识，0：正常，1：已删除',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`Cid`),
  UNIQUE KEY `Cid` (`Cid`),
  KEY `FK_COMMENT_ADVERTISE_AID` (`Aid`),
  KEY `FK_COMMENT_USER_UID` (`Uid`),
  CONSTRAINT `FK_COMMENT_ADVERTISE_AID` FOREIGN KEY (`Aid`) REFERENCES `t_advertise` (`Aid`),
  CONSTRAINT `FK_COMMENT_USER_UID` FOREIGN KEY (`Uid`) REFERENCES `t_user` (`Uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='评论信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_comment`
--

LOCK TABLES `t_comment` WRITE;
/*!40000 ALTER TABLE `t_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_cv`
--

DROP TABLE IF EXISTS `t_cv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_cv` (
  `Cid` int(10) NOT NULL AUTO_INCREMENT COMMENT '简历ID，主键',
  `Uid` int(10) DEFAULT NULL COMMENT '用户ID，外键',
  `Uname` varchar(20) DEFAULT NULL COMMENT '简历所属用户姓名',
  `Utelephone` char(11) DEFAULT NULL COMMENT '联系电话',
  `Ctitle` varchar(100) DEFAULT NULL COMMENT '简历标题',
  `Ccontent` text COMMENT '简历内容',
  `Cself-appraisal` varchar(255) DEFAULT NULL COMMENT '自我评价',
  `Ceducation_background` varchar(255) DEFAULT NULL COMMENT '学历',
  `Upolitics_status` varchar(20) DEFAULT NULL COMMENT '政治面貌',
  `Cskill` varchar(255) DEFAULT NULL COMMENT '特长，技能',
  `Cexperience` varchar(255) DEFAULT NULL COMMENT '工作经历',
  `Clive_province` varchar(20) DEFAULT NULL COMMENT '居住省份',
  `Clive_city` varchar(20) DEFAULT NULL COMMENT '居住城市',
  `Cwant_joy_type` varchar(50) DEFAULT NULL COMMENT '想要的工作类型：实习、全职。。。',
  `Cwant_province` varchar(20) DEFAULT NULL COMMENT '想去的省份',
  `Cwant_city` varchar(20) DEFAULT NULL COMMENT '想去的城市',
  `Cwant_low_wages` int(10) DEFAULT NULL COMMENT '期望最低工资',
  `Cwant_large_wages` int(10) DEFAULT NULL COMMENT '期望最高工资',
  `Cwant_post` varchar(50) DEFAULT NULL COMMENT '意向行业职位',
  `delete_flag` int(1) NOT NULL DEFAULT '0' COMMENT '删除标识，0：正常，1：已删除',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_at` datetime DEFAULT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`Cid`),
  UNIQUE KEY `Cid` (`Cid`),
  KEY `FK_CV_USER_UID` (`Uid`),
  CONSTRAINT `FK_CV_USER_UID` FOREIGN KEY (`Uid`) REFERENCES `t_user` (`Uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='简历表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_cv`
--

LOCK TABLES `t_cv` WRITE;
/*!40000 ALTER TABLE `t_cv` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_cv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_cv_advertise`
--

DROP TABLE IF EXISTS `t_cv_advertise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_cv_advertise` (
  `Cid` int(10) NOT NULL COMMENT '外键（简历）',
  `Aid` int(10) NOT NULL COMMENT '外键（招聘信息）',
  PRIMARY KEY (`Cid`,`Aid`),
  KEY `FK_CA_ADVERTISE` (`Aid`),
  CONSTRAINT `FK_CA_ADVERTISE` FOREIGN KEY (`Aid`) REFERENCES `t_advertise` (`Aid`),
  CONSTRAINT `FK_CA_CV` FOREIGN KEY (`Cid`) REFERENCES `t_cv` (`Cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='招聘信息和简历多对多中间表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_cv_advertise`
--

LOCK TABLES `t_cv_advertise` WRITE;
/*!40000 ALTER TABLE `t_cv_advertise` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_cv_advertise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_post`
--

DROP TABLE IF EXISTS `t_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_post` (
  `Pid` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `PTid` int(10) DEFAULT NULL COMMENT '外键（岗位类型）',
  `Pname` varchar(50) NOT NULL COMMENT '岗位名称',
  `comment` varchar(255) DEFAULT NULL COMMENT '岗位备注',
  `delete_flag` tinyint(1) DEFAULT '0' COMMENT '删除标识',
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  PRIMARY KEY (`Pid`),
  UNIQUE KEY `Pid` (`Pid`),
  KEY `FK_POST_POSTTYPE` (`PTid`),
  CONSTRAINT `FK_POST_POSTTYPE` FOREIGN KEY (`PTid`) REFERENCES `t_post_type` (`PTid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='岗位表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_post`
--

LOCK TABLES `t_post` WRITE;
/*!40000 ALTER TABLE `t_post` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_post_type`
--

DROP TABLE IF EXISTS `t_post_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_post_type` (
  `PTid` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `Pname` varchar(50) NOT NULL COMMENT '岗位类型名称',
  `comment` varchar(255) DEFAULT NULL COMMENT '岗位类型备注',
  `delete_flag` tinyint(1) DEFAULT '0' COMMENT '删除标识',
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  PRIMARY KEY (`PTid`),
  UNIQUE KEY `PTid` (`PTid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='岗位类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_post_type`
--

LOCK TABLES `t_post_type` WRITE;
/*!40000 ALTER TABLE `t_post_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_post_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_role` (
  `Rid` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色ID，主键',
  `Rname` varchar(20) NOT NULL COMMENT '角色名',
  `delete_flag` int(1) NOT NULL DEFAULT '0' COMMENT '删除标识，0：正常，1：已删除',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_at` datetime DEFAULT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`Rid`),
  UNIQUE KEY `Rid` (`Rid`),
  UNIQUE KEY `Rname` (`Rname`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (1,'求职者',0,NULL,'2020-05-14 11:09:16','2020-05-14 11:09:16'),(2,'企业',0,NULL,'2020-05-14 11:12:06','2020-05-14 11:12:06'),(5,'管理员',1,'管理员角色','2020-05-17 17:12:43','2020-05-17 17:20:47');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `t_user` (
  `Uid` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户ID，主键',
  `Rid` int(10) DEFAULT NULL COMMENT '角色ID，外键',
  `Uname` varchar(20) NOT NULL COMMENT '用户姓名',
  `Upassword` varchar(20) NOT NULL COMMENT '密码',
  `Uaddress` varchar(255) DEFAULT NULL COMMENT '地址',
  `Uimagepath` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `Utelephone` char(11) DEFAULT NULL COMMENT '用户联系电话',
  `Uemail` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `Ubirthday` date DEFAULT NULL COMMENT '用户生日',
  `delete_flag` int(1) NOT NULL DEFAULT '0' COMMENT '删除标识，0：正常，1：已删除',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_at` datetime DEFAULT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`Uid`),
  UNIQUE KEY `Uid` (`Uid`),
  KEY `FK_USER_ROLE_RID` (`Rid`),
  CONSTRAINT `FK_USER_ROLE_RID` FOREIGN KEY (`Rid`) REFERENCES `t_role` (`Rid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,1,'王德略','123456','广东XXXXXX',NULL,'0',NULL,NULL,0,NULL,'2020-05-17 12:52:46','2020-05-17 12:52:46');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'findwork'
--

--
-- Dumping routines for database 'findwork'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-18 12:25:30
