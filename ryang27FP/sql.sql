/*
SQLyog Trial v12.4.1 (64 bit)
MySQL - 8.0.28 : Database - itmd4515
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`itmd4515` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `itmd4515`;

/*Table structure for table `animal` */

DROP TABLE IF EXISTS `animal`;

CREATE TABLE `animal` (
  `aid` int NOT NULL AUTO_INCREMENT,
  `aname` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `anum` int DEFAULT NULL,
  `ename` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `animal` */

insert  into `animal`(`aid`,`aname`,`anum`,`ename`) values 
(1,NULL,NULL,NULL);

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `cname` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `ctype` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `ename` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `city` */

/*Table structure for table `euser` */

DROP TABLE IF EXISTS `euser`;

CREATE TABLE `euser` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `ename` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `uname` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `utel` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `euser` */

/*Table structure for table `event` */

DROP TABLE IF EXISTS `event`;

CREATE TABLE `event` (
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `date` date DEFAULT NULL,
  `type` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '10:00',
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `event` */

insert  into `event`(`name`,`date`,`type`,`remark`,`id`) values 
('asd',NULL,'kkk',NULL,2),
('asd',NULL,'www',NULL,3),
('Zoo1','2023-10-05','openness','10:00',4),
('Zoo1','2023-10-05','openness','10:00',5),
('12',NULL,'12',NULL,7),
('asd',NULL,'12',NULL,8),
('12',NULL,'www',NULL,11),
('qw',NULL,'sss',NULL,12);

/*Table structure for table `usere` */

DROP TABLE IF EXISTS `usere`;

CREATE TABLE `usere` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1769495744 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

/*Data for the table `usere` */

insert  into `usere`(`id`,`username`,`password`) values 
(-1658727038,'123','123'),
(1769495743,'user','1234');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
