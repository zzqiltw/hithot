-- MySQL dump 10.10
--
-- Host: localhost    Database: hithot
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `imagepoint`
--

DROP TABLE IF EXISTS `imagepoint`;
CREATE TABLE `imagepoint` (
  `id` varchar(40) NOT NULL,
  `name` varchar(40) NOT NULL,
  `author` varchar(40) NOT NULL,
  `image` varchar(255) NOT NULL,
  `description` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `imagepoint`
--


/*!40000 ALTER TABLE `imagepoint` DISABLE KEYS */;
LOCK TABLES `imagepoint` WRITE;
INSERT INTO `imagepoint` VALUES ('17a44dea-2ecd-4470-88ef-4a7307ced7dc','辅导员','zzq','d83c2323-d767-49d1-a50d-f5b79d8adf8c20131220133541.jpg','辅导员给学生们开年级会'),('9ce67821-2f4e-42bb-bf6d-0c3a0bfa633b','集体听讲','kkk','c37e3665-790d-45da-ad27-bf562d6f05a920131220133619.jpg','大家都很认真'),('b8e304a7-9e80-4504-9be4-a16a5edda26a','极峰论坛辩论赛','zzq','0d81d4e4-8afd-43ba-8ad4-e0c513c5ac4820131220133441.jpg','这是一场精彩的极峰论坛辩论赛');
UNLOCK TABLES;
/*!40000 ALTER TABLE `imagepoint` ENABLE KEYS */;

--
-- Table structure for table `point`
--

DROP TABLE IF EXISTS `point`;
CREATE TABLE `point` (
  `id` int(11) NOT NULL auto_increment,
  `author` varchar(32) default NULL,
  `postTime` date default NULL,
  `title` varchar(32) default NULL,
  `text` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `point`
--


/*!40000 ALTER TABLE `point` DISABLE KEYS */;
LOCK TABLES `point` WRITE;
INSERT INTO `point` VALUES (240,'zzq','2013-12-20','需要审核的词汇测试','这是一个敏感词汇：防真<font color=\'red\'>手枪</font>，并且会被高亮处理');
UNLOCK TABLES;
/*!40000 ALTER TABLE `point` ENABLE KEYS */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(32) default NULL,
  `password` varchar(64) default NULL,
  `email` varchar(64) default NULL,
  `flag` varchar(4) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--


/*!40000 ALTER TABLE `user` DISABLE KEYS */;
LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'zzq','3P3ekJrLR7nU7WGOhkLj7g==','zzqiltw@gmail.com','0'),(2,'zzz','86u4a9NM9NUmmPFMDaHcYA==','zzz@zz.com','0'),(4,'rrr','ICy5YqxZB1uWSwcVLSNLcA==','sdf@sdf.com','1'),(5,'ppp','8n9vHHxcv04+GS4KR7hTAA==','ppp@ss.com','1'),(6,'huashu','ICy5YqxZB1uWSwcVLSNLcA==','sdf@sdf.com','1'),(7,'kkk','ICy5YqxZB1uWSwcVLSNLcA==','sdf@sdf.com','1');
UNLOCK TABLES;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

