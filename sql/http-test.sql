/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.23-log : Database - http_test
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE = '' */;

/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS */`http_test` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `http_test`;

/*Table structure for table `files` */

DROP TABLE IF EXISTS `files`;

CREATE TABLE `files` (
  `id`           bigint(20)   NOT NULL AUTO_INCREMENT,
  `user_id`      bigint(20)   NOT NULL,
  `name`         varchar(300) NOT NULL,
  `save_path`    varchar(300) NOT NULL,
  `deleted`      tinyint(4)   NOT NULL DEFAULT '0',
  `gmt_create`   timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 39
  DEFAULT CHARSET = utf8;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id`           bigint(20)  NOT NULL AUTO_INCREMENT,
  `name`         varchar(30) NOT NULL,
  `deleted`      tinyint(4)  NOT NULL DEFAULT '0',
  `gmt_create`   timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 29
  DEFAULT CHARSET = utf8;

/*Table structure for table `user_copy` */

DROP TABLE IF EXISTS `user_copy`;

CREATE TABLE `user_copy` (
  `id`           bigint(20)  NOT NULL AUTO_INCREMENT,
  `name`         varchar(30) NOT NULL,
  `deleted`      tinyint(4)  NOT NULL DEFAULT '0',
  `gmt_create`   timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 17
  DEFAULT CHARSET = utf8;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;
