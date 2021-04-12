/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 8.0.23 : Database - db_yeb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_yeb` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `db_yeb`;

/*Table structure for table `t_admin` */

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `telephone` varchar(50) DEFAULT NULL COMMENT '住宅电话',
  `address` varchar(100) DEFAULT NULL COMMENT '用户地址',
  `enabled` tinyint(1) DEFAULT NULL COMMENT '是否启用',
  `password` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `user_face` varchar(300) DEFAULT NULL COMMENT '用户头像',
  `gender` int DEFAULT NULL COMMENT '性别',
  `age` int DEFAULT NULL COMMENT '年龄',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(300) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `t_admin` */

insert  into `t_admin`(`id`,`name`,`username`,`telephone`,`address`,`enabled`,`password`,`user_face`,`gender`,`age`,`gmt_create`,`gmt_modified`,`remark`) values (1,'admin','admin','18739012475','北京市',1,'$2a$10$ngTKak9Qth98evd.EIm0c.phJu9qVTfxk6MEtz51PLZfMwDC38bUS','https://portrait.gitee.com/uploads/avatars/user/2617/7853024_mornd_1608529482.png!avatar200',1,20,'2021-02-01 18:51:52',NULL,NULL),(2,'mornd','mornd','14578964561','北京市',1,'$2a$10$ngTKak9Qth98evd.EIm0c.phJu9qVTfxk6MEtz51PLZfMwDC38bUS','https://portrait.gitee.com/uploads/avatars/user/2617/7853024_mornd_1608529482.png!avatar200',1,21,'2021-02-01 00:00:00',NULL,NULL),(3,'安娜','Anna','14524597698','上海市',1,'$2a$10$ngTKak9Qth98evd.EIm0c.phJu9qVTfxk6MEtz51PLZfMwDC38bUS','https://portrait.gitee.com/uploads/avatars/user/2617/7853024_mornd_1608529482.png!avatar200',0,16,'2021-02-01 19:06:55',NULL,NULL),(4,'爱丽丝','Alice','16538703759','上海市',1,'$2a$10$ngTKak9Qth98evd.EIm0c.phJu9qVTfxk6MEtz51PLZfMwDC38bUS','https://portrait.gitee.com/uploads/avatars/user/2617/7853024_mornd_1608529482.png!avatar200',0,18,'2021-02-01 00:00:00',NULL,NULL),(5,'贝西','Betsy','12456789679','南昌市',1,'$2a$10$ngTKak9Qth98evd.EIm0c.phJu9qVTfxk6MEtz51PLZfMwDC38bUS','https://portrait.gitee.com/uploads/avatars/user/2617/7853024_mornd_1608529482.png!avatar200',1,20,'2021-02-10 14:01:07',NULL,NULL),(6,'鲍勃','bob','13424567967','成都市',1,'$2a$10$ngTKak9Qth98evd.EIm0c.phJu9qVTfxk6MEtz51PLZfMwDC38bUS','https://portrait.gitee.com/uploads/avatars/user/2617/7853024_mornd_1608529482.png!avatar200',1,24,'2021-02-10 14:01:17',NULL,NULL),(7,'凯瑟琳','Catherine','14567897535','北京市',0,'$2a$10$ngTKak9Qth98evd.EIm0c.phJu9qVTfxk6MEtz51PLZfMwDC38bUS','https://portrait.gitee.com/uploads/avatars/user/2617/7853024_mornd_1608529482.png!avatar200',0,17,'2021-02-10 00:00:00',NULL,NULL),(8,'黛娜','Dina','18647687987','北京市',1,'$2a$10$ngTKak9Qth98evd.EIm0c.phJu9qVTfxk6MEtz51PLZfMwDC38bUS','https://portrait.gitee.com/uploads/avatars/user/2617/7853024_mornd_1608529482.png!avatar200',0,17,'2021-02-10 00:00:00',NULL,NULL),(9,'埃米莉','Emilie','15262354953','上海市',1,'$2a$10$ngTKak9Qth98evd.EIm0c.phJu9qVTfxk6MEtz51PLZfMwDC38bUS','https://portrait.gitee.com/uploads/avatars/user/2617/7853024_mornd_1608529482.png!avatar200',0,16,'2021-02-10 16:24:46',NULL,NULL),(10,'简','Jane','13552614144',NULL,1,'$2a$10$ngTKak9Qth98evd.EIm0c.phJu9qVTfxk6MEtz51PLZfMwDC38bUS','https://portrait.gitee.com/uploads/avatars/user/2617/7853024_mornd_1608529482.png!avatar200',1,23,'2021-02-10 16:55:24',NULL,NULL),(11,'路西','Lucy','15263021546',NULL,1,'$2a$10$ngTKak9Qth98evd.EIm0c.phJu9qVTfxk6MEtz51PLZfMwDC38bUS','https://portrait.gitee.com/uploads/avatars/user/2617/7853024_mornd_1608529482.png!avatar200',0,21,'2021-02-10 16:55:51',NULL,NULL);

/*Table structure for table `t_admin_role` */

DROP TABLE IF EXISTS `t_admin_role`;

CREATE TABLE `t_admin_role` (
  `aid` int DEFAULT NULL COMMENT 'adminid',
  `rid` int DEFAULT NULL COMMENT '角色id',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `remark` varchar(100) DEFAULT NULL,
  KEY `admin_role` (`aid`),
  KEY `rid` (`rid`),
  CONSTRAINT `admin_role` FOREIGN KEY (`aid`) REFERENCES `t_admin` (`id`),
  CONSTRAINT `t_admin_role_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_admin_role` */

insert  into `t_admin_role`(`aid`,`rid`,`gmt_create`,`remark`) values (5,5,'2021-02-10 23:55:03',NULL),(6,7,'2021-02-10 23:55:13',NULL),(4,5,'2021-02-12 21:34:48',NULL),(3,2,'2021-02-12 21:36:40',NULL),(2,1,'2021-03-04 06:55:47',NULL),(1,2,'2021-03-04 06:56:05',NULL);

/*Table structure for table `t_department` */

DROP TABLE IF EXISTS `t_department`;

CREATE TABLE `t_department` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '部门名称',
  `parent_id` int DEFAULT NULL COMMENT '父id',
  `dep_path` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '路径',
  `enabled` tinyint(1) DEFAULT '1' COMMENT '是否启用',
  `is_Parent` tinyint(1) DEFAULT NULL COMMENT '是否上级',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `remark` varchar(300) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

/*Data for the table `t_department` */

insert  into `t_department`(`id`,`name`,`parent_id`,`dep_path`,`enabled`,`is_Parent`,`create_date`,`remark`) values (1,'股东会',-1,'.1',1,1,'2021-02-08 00:00:00',NULL),(2,'董事会',1,'.1.2',1,1,'2021-02-08 13:38:02',NULL),(3,'总办',2,'.1.2.3',1,1,'2021-02-08 00:00:00',NULL),(4,'财务部',3,'.1.2.3.4',1,1,'2021-02-08 00:00:00',NULL),(5,'市场部',3,'.1.2.3.5',1,1,'2021-02-08 13:38:54',NULL),(6,'华东市场部',5,'.1.2.3.5.6',1,1,'2021-02-08 13:39:23',NULL),(7,'华南市场部',5,'.1.2.3.5.7',1,1,'2021-02-08 00:00:00',NULL),(8,'华北市场部',5,'.1.2.3.5.8',1,0,'2021-02-08 13:40:07',NULL),(9,'西北市场部',5,'.1.2.3.5.9',1,0,'2021-02-08 13:40:37',NULL),(13,'技术部',3,'.1.2.3.13',1,0,'2021-02-08 13:43:01',NULL),(14,'运维部',3,'.1.2.3.14',1,0,'2021-02-08 13:43:19',NULL),(16,'北京市场部',8,NULL,1,NULL,'2021-02-08 16:31:57',NULL),(17,'成都市场部',9,NULL,1,NULL,'2021-02-08 16:38:04',NULL),(18,'广州市场部',7,NULL,1,NULL,'2021-02-08 16:40:22',NULL),(59,'上海市场部',6,'',1,NULL,'2021-02-09 00:00:00',''),(66,'浦东市场部',59,'',0,NULL,'2021-02-10 13:20:10','');

/*Table structure for table `t_employee` */

DROP TABLE IF EXISTS `t_employee`;

CREATE TABLE `t_employee` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `gender` char(4) DEFAULT NULL COMMENT '性别',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `id_card` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `wedlock` enum('未婚','已婚','离异') CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '婚姻状况',
  `nation_id` int DEFAULT NULL COMMENT '民族',
  `nation_place` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '籍贯',
  `politic_id` int DEFAULT NULL COMMENT '政治面貌',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `department_id` int DEFAULT NULL COMMENT '部门编号',
  `job_level_id` int DEFAULT NULL COMMENT '职称id',
  `pos_id` int DEFAULT NULL COMMENT '职位id',
  `engage_form` varchar(50) DEFAULT NULL COMMENT '聘用形式',
  `tiptop_degree` enum('博士','硕士','本科','大专','高中','初中','小学','其他') CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最高学历',
  `specialty` varchar(100) DEFAULT NULL COMMENT '所属专业',
  `school` varchar(50) DEFAULT NULL COMMENT '毕业院校',
  `begin_date` datetime DEFAULT NULL COMMENT '入职日期',
  `work_state` enum('在职','离职') CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '在职状态',
  `work_id` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '工号',
  `contract_term` double DEFAULT NULL COMMENT '合同期限',
  `conversion_time` datetime DEFAULT NULL COMMENT '转正日期',
  `not_work_tract` datetime DEFAULT NULL COMMENT '离职日期',
  `begin_contract` datetime DEFAULT NULL COMMENT '合同起始日期',
  `end_contract` datetime DEFAULT NULL COMMENT '合同终止日期',
  `work_age` int DEFAULT NULL COMMENT '工龄',
  `salary_id` int DEFAULT NULL COMMENT '工资账套id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=249 DEFAULT CHARSET=utf8;

/*Data for the table `t_employee` */

insert  into `t_employee`(`id`,`name`,`gender`,`birthday`,`id_card`,`wedlock`,`nation_id`,`nation_place`,`politic_id`,`email`,`phone`,`address`,`department_id`,`job_level_id`,`pos_id`,`engage_form`,`tiptop_degree`,`specialty`,`school`,`begin_date`,`work_state`,`work_id`,`contract_term`,`conversion_time`,`not_work_tract`,`begin_contract`,`end_contract`,`work_age`,`salary_id`) values (11,'anne','女','2021-02-16 00:00:00','360430200005141212','未婚',2,'重庆',1,'987@qq.com','13310256300','重庆市万州区',7,1,1,'劳动合同','初中','电子工程','上海交通大学','2021-02-19 00:00:00','在职','06D0E81F87034A7',713,'2021-02-10 00:00:00',NULL,'2021-02-26 00:00:00','2023-02-09 00:00:00',2,2),(12,'jack','男','2021-02-06 00:00:00','360430199909142359','已婚',4,'广州',3,'555@qq.com','15236521107','广州市天河区',1,2,2,'劳动合同','博士','室内装修设计','上海交通大学','2021-02-12 00:00:00','在职','0CA2806D764D436',4,'2021-02-17 00:00:00',NULL,'2021-02-21 00:00:00','2021-02-25 00:00:00',1,4),(14,'hello','女','2021-01-31 00:00:00','360430199905112532','已婚',1,'江西',2,'111@qq.com','1111111','dsfs',4,2,1,'劳务合同','初中','123','123','2021-02-20 00:00:00','在职','E1EF0D92A905479',1480,'2021-01-31 00:00:00',NULL,'2021-01-31 00:00:00','2025-02-19 00:00:00',NULL,1),(16,'王二狗','男','1999-01-31 00:00:00','340251199905111245','未婚',1,'广东',3,'ergou@163.com','12563225201','广东省广州市番禺区',18,5,4,'劳动合同','高中','无','无','2021-02-20 00:00:00','在职','5684B4323B8E475',2171,'2023-02-01 00:00:00',NULL,'2021-02-20 00:00:00','2027-01-31 00:00:00',NULL,2),(20,'李狗蛋','男','2021-02-01 00:00:00','325124199905220012','未婚',1,'上海',3,'goudan@163.com','12562355895','上海市浦东新区',59,5,3,'劳动合同','高中','无','无','2021-02-01 00:00:00','在职','9FE6222B796E43E',745,'2021-02-19 00:00:00',NULL,'2021-02-01 00:00:00','2023-02-16 00:00:00',NULL,3),(21,'李四','男','1999-05-12 00:00:00','360430199905126554','未婚',1,'江西',2,'haha@163.com','15243655598','江西省九江市浔阳区',3,2,3,'劳动合同','博士','信息管理于信息系统','南京大学','2021-02-02 15:04:39','在职','B97D0AD56055472',8,'2021-02-25 00:00:00',NULL,'2021-02-20 00:00:00','2021-02-28 00:00:00',NULL,1),(22,'王五','男','2021-02-11 00:00:00','365265199901141512','未婚',3,'江西',3,'1112@qq.com','15326544441','江西省九江市柴桑区',4,4,2,'劳动合同','初中','护理系','北京大学','2021-02-04 15:05:01','在职','21179C69368B495',738,'2021-02-12 00:00:00',NULL,'2021-01-31 00:00:00','2023-02-08 00:00:00',NULL,4),(23,'赵六','男','2021-02-19 00:00:00','360430199906152532','已婚',1,'江西',1,'000@163.com','15236598652','江西省九江市柴桑区',5,2,4,'劳动合同','博士','室内装修设计','上海交通大学','2021-02-13 15:05:03','在职','FD6FFD0170C04CC',27,'2021-02-05 00:00:00',NULL,'2021-02-05 00:00:00','2021-03-04 00:00:00',NULL,2),(24,'何七','男','2014-01-01 00:00:00','360430199905123212','未婚',1,'江西',3,'010@163.com','13356253112','江西省九江市柴桑区',4,1,2,'劳务合同','硕士','无','中国人民学院','2021-02-13 15:05:06','在职','C068C7EFB83A461',2201,'2021-02-17 00:00:00',NULL,'2021-02-08 00:00:00','2027-02-18 00:00:00',NULL,4),(25,'孙八','男','2021-02-07 00:00:00','360430199906113625','已婚',1,'江西',4,'123456@qq.com','15236598652','江西省九江市柴桑区',2,1,3,'劳动合同','高中','无','中国科学院大学','2021-02-05 15:05:09','在职','E1DD2F8E3D3A403',0,'2021-01-14 00:00:00',NULL,'2021-02-05 00:00:00','2021-02-05 00:00:00',NULL,1),(26,'钱九','男','2021-02-16 00:00:00','360430200011121345','未婚',2,'江西',3,'9999@qq.com','15201452301','江西省九江市柴桑区',3,3,1,'劳动合同','本科','市场营销','南昌大学','2021-02-02 15:05:12','在职','328598D4C91D40C',15,'2021-02-10 00:00:00',NULL,'2021-02-09 00:00:00','2021-02-24 00:00:00',NULL,2),(27,'李十','男','2021-02-13 00:00:00','360430200012145655','已婚',1,'江西',2,'8888@qq.com','15632541025','江西省九江市柴桑区',2,2,3,'劳动合同','本科','电子工程','清华大学','2021-02-18 15:05:15','在职','E84CCBBA11ED488',15,'2021-02-10 00:00:00',NULL,'2021-02-05 00:00:00','2021-02-20 00:00:00',NULL,3),(29,'bob12','男','2021-02-03 00:00:00','360444199905152356','离异',3,'上海',2,'135@qq.com','12325612511','上海市普陀区',6,4,1,'劳动合同','大专','市场营销','中国科学院大学','2021-02-16 00:00:00','在职','177ECA8A98A549C',350,'2021-02-12 00:00:00',NULL,'2021-02-25 00:00:00','2022-02-10 00:00:00',NULL,4),(237,'小林','男','2021-03-02 00:00:00','152451256532561524','未婚',2,'江西',3,'1152229579@qq.com','15245124144','广州市番禺区',66,1,1,'劳动合同','高中','无','无','2021-03-10 00:00:00','在职','7338D91B6B944DB',6,'2021-03-18 00:00:00',NULL,'2021-03-24 00:00:00','2021-03-30 00:00:00',NULL,NULL),(238,'小小','男','2021-03-02 00:00:00','154215255632514525','未婚',1,'江西',2,'1152229579@qq.com','15236523451','广州市番禺区',18,1,1,'劳动合同','小学','无','无','2021-03-12 00:00:00','在职','9AD79B3FA0BD442',1,'2021-03-23 00:00:00',NULL,'2021-03-21 00:00:00','2021-03-22 00:00:00',NULL,NULL),(240,'小小','男','2021-03-02 00:00:00','154215255632514525','未婚',1,'江西',2,'1152229579@qq.com','15236523451','广州市番禺区',18,1,1,'劳动合同','小学','无','无','2021-03-12 00:00:00','在职','9A119B3FA0BD442',1,'2021-03-23 00:00:00',NULL,'2021-03-21 00:00:00','2021-03-22 00:00:00',NULL,NULL),(241,'小小','男','2021-03-02 00:00:00','154215255632514525','未婚',1,'江西',2,'1152229579@qq.com','15236523451','广州市番禺区',18,1,1,'劳动合同','小学','无','无','2021-03-12 00:00:00','在职','9A119B32A0BD442',1,'2021-03-23 00:00:00',NULL,'2021-03-21 00:00:00','2021-03-22 00:00:00',NULL,NULL),(242,'小小','男','2021-03-02 00:00:00','154215255632514525','未婚',1,'江西',2,'1152229579@qq.com','15236523451','广州市番禺区',18,1,1,'劳动合同','小学','无','无','2021-03-12 00:00:00','在职','9A119B12A0BD442',1,'2021-03-23 00:00:00',NULL,'2021-03-21 00:00:00','2021-03-22 00:00:00',NULL,NULL),(243,'小小','男','2021-03-02 00:00:00','154215255632514525','未婚',1,'江西',2,'1152229579@qq.com','15236523451','广州市番禺区',18,1,1,'劳动合同','小学','无','无','2021-03-12 00:00:00','在职','9A112212A0BD442',1,'2021-03-23 00:00:00',NULL,'2021-03-21 00:00:00','2021-03-22 00:00:00',NULL,NULL),(244,'小小','男','2021-03-02 00:00:00','154215255632514525','未婚',1,'江西',2,'1152229579@qq.com','15236523451','广州市番禺区',18,1,1,'劳动合同','小学','无','无','2021-03-12 00:00:00','在职','9A112211A0BD442',1,'2021-03-23 00:00:00',NULL,'2021-03-21 00:00:00','2021-03-22 00:00:00',NULL,NULL),(245,'小小','男','2021-03-02 00:00:00','154215255632514525','未婚',1,'江西',2,'1152229579@qq.com','15236523451','广州市番禺区',18,1,1,'劳动合同','小学','无','无','2021-03-12 00:00:00','在职','9A132211A0BD442',1,'2021-03-23 00:00:00',NULL,'2021-03-21 00:00:00','2021-03-22 00:00:00',NULL,NULL),(246,'小小','男','2021-03-02 00:00:00','154215255632514525','未婚',1,'江西',2,'1152229579@qq.com','15236523451','广州市番禺区',18,1,1,'劳动合同','小学','无','无','2021-03-12 00:00:00','在职','9A13221120BD442',1,'2021-03-23 00:00:00',NULL,'2021-03-21 00:00:00','2021-03-22 00:00:00',NULL,NULL),(248,'小小','男','2021-03-02 00:00:00','154215255632514525','未婚',1,'江西',2,'1152229579@qq.com','15236523451','广州市番禺区',18,1,1,'劳动合同','小学','无','无','2021-03-12 00:00:00','在职','9A13221220BD442',1,'2021-03-23 00:00:00',NULL,'2021-03-21 00:00:00','2021-03-22 00:00:00',NULL,NULL);

/*Table structure for table `t_joblevel` */

DROP TABLE IF EXISTS `t_joblevel`;

CREATE TABLE `t_joblevel` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '职称管理id',
  `name` varchar(50) NOT NULL COMMENT '职称名称',
  `title_level` enum('正高级','副高级','中级','初级','员级') CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职称等级',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `enabled` tinyint(1) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

/*Data for the table `t_joblevel` */

insert  into `t_joblevel`(`id`,`name`,`title_level`,`create_date`,`enabled`) values (1,'教授','正高级','2021-02-03 20:21:20',1),(2,'副教授','副高级','2021-02-03 20:21:47',1),(3,'助教','初级','2021-02-03 20:22:02',1),(4,'讲师','中级','2021-02-03 20:22:09',0),(5,'初级工程师','初级','2021-02-03 20:22:20',1),(6,'中级工程师','中级','2021-02-03 20:22:30',1),(7,'高级工程师','副高级','2021-02-03 20:22:42',1),(8,'骨灰级工程师','正高级','2021-02-03 20:22:53',1);

/*Table structure for table `t_mail_log` */

DROP TABLE IF EXISTS `t_mail_log`;

CREATE TABLE `t_mail_log` (
  `msg_id` varchar(100) NOT NULL COMMENT '消息id',
  `e_id` int DEFAULT NULL COMMENT '接收员工id',
  `status` int DEFAULT NULL COMMENT '状态(0:消息投递中1:投递成功2:投递失败)',
  `route_key` varchar(50) DEFAULT NULL COMMENT '路由键',
  `exchange` varchar(20) DEFAULT NULL COMMENT '交换机',
  `count` int DEFAULT NULL COMMENT '重试次数',
  `try_time` datetime DEFAULT NULL COMMENT '重试时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`msg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_mail_log` */

insert  into `t_mail_log`(`msg_id`,`e_id`,`status`,`route_key`,`exchange`,`count`,`try_time`,`create_time`,`update_time`) values ('0fa951907ff1420a8521988e32d0ee2c',245,1,'mail.routing.key','mail.exchange',0,'2021-03-03 14:05:01','2021-03-03 14:04:01','2021-03-03 14:04:01'),('13456b2148f143e59cbe3c94ab8bf101',243,1,'mail.routing.key','mail.exchange',0,'2021-03-03 14:01:53','2021-03-03 14:00:53','2021-03-03 14:00:53'),('521286b50f55431093e5dfa41f1faa98',242,1,'mail.routing.key','mail.exchange',2,'2021-03-03 13:12:30','2021-03-03 12:50:25','2021-03-03 13:11:30'),('b73175bae6e04a72972eee8294e003a6',244,1,'mail.routing.key','mail.exchange',0,'2021-03-03 14:04:04','2021-03-03 14:03:04','2021-03-03 14:03:04');

/*Table structure for table `t_menu` */

DROP TABLE IF EXISTS `t_menu`;

CREATE TABLE `t_menu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'url',
  `path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '路径',
  `component` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '组件名称',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单名称',
  `icon_cls` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图标',
  `keep_alive` tinyint(1) DEFAULT NULL COMMENT '是否保持激活',
  `require_auth` tinyint(1) DEFAULT NULL COMMENT '是否要求权限',
  `parent_id` int DEFAULT NULL COMMENT '父id',
  `enabled` tinyint(1) DEFAULT NULL COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `t_menu` */

insert  into `t_menu`(`id`,`url`,`path`,`component`,`name`,`icon_cls`,`keep_alive`,`require_auth`,`parent_id`,`enabled`) values (1,'/','/home','Home','所有','fa fa-circle',NULL,0,0,1),(2,'/','/home','Home','员工资料','fa fa-address-card-o',NULL,1,1,1),(3,'/','/home','Home','人事管理','fa fa-group',NULL,1,1,1),(4,'/','/home','Home','薪资管理','fa fa-truck',NULL,1,1,1),(5,'/','/home','Home','统计管理','fa fa-bar-chart-o',NULL,1,1,1),(6,'/','/home','Home','系统管理','fa fa-gear',NULL,1,1,1),(7,'/employee/basic/**','/emp/basic','EmpBasic','基本资料','fa fa-file-text-o',NULL,1,2,1),(8,'/employee/advanced/**','/emp/adv','EmpAdv','高级资料','fa fa-newspaper-o',NULL,1,2,1),(9,'/personnel/emp/**','/per/emp','PerEmp','员工资料','',NULL,1,3,1),(10,'/personnel/ec/**','/per/ec','PerEc','员工奖惩',NULL,NULL,1,3,1),(11,'/personnel/train/**','/per/train','PerTrain','员工培训',NULL,NULL,1,3,1),(12,'/personnel/salary/**','/per/salary','PerSalary','员工调薪',NULL,NULL,1,3,1),(13,'/personnel/remove/**','/per/mv','PerMv','员工调动',NULL,NULL,1,3,1),(14,'/salary/sob/**','/sal/sob','SalSob','工资账套管理',NULL,NULL,1,4,1),(15,'/salary/sobcfg/**','/sal/sobcfg','SalSobCfg','员工账套管理',NULL,NULL,1,4,1),(16,'/salary/table/**','/sal/table','SalTable','工资表管理',NULL,NULL,1,4,1),(17,'/salary/month/**','/sal/month','SalMonth','月末处理',NULL,NULL,1,4,1),(18,'/salary/search/**','/sal/search','SalarySearch','工资表查询',NULL,NULL,1,4,1),(19,'/statistics/all/**','/sta/all','StaAll','综合信息统计',NULL,NULL,1,5,1),(20,'/statistics/score/**','/sta/score','StaScore','员工积分统计',NULL,NULL,1,5,1),(21,'/statistics/personnel/**','/sta/pers','StaPers','人事信息统计',NULL,NULL,1,5,1),(22,'/statistics/recored/**','/sta/record','StaRecord','人事记录统计',NULL,NULL,1,5,1),(23,'/system/basic/**','/sys/basic','SysBasic','基础信息设置',NULL,NULL,1,6,1),(24,'/system/config/**','/sys/config','SysConfig','系统管理',NULL,NULL,1,6,1),(25,'/system/log/**','/sys/log','SysLog','操作日志管理',NULL,NULL,1,6,1),(26,'/system/admin/**','/sys/admin','SysAdmin','操作员管理',NULL,NULL,1,6,1),(27,'/system/data/**','/sys/data','SysData','备份恢复数据库',NULL,NULL,1,6,1),(28,'/system/init/**','/sys/init','SysInit','初始化数据库',NULL,NULL,1,6,1),(30,'/test/test/**','/sys/test',NULL,'测试菜单',NULL,NULL,1,4,1);

/*Table structure for table `t_menu_role` */

DROP TABLE IF EXISTS `t_menu_role`;

CREATE TABLE `t_menu_role` (
  `mid` int DEFAULT NULL COMMENT '菜单id',
  `rid` int DEFAULT NULL COMMENT '角色id',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  KEY `mid` (`mid`),
  KEY `rid` (`rid`),
  CONSTRAINT `t_menu_role_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `t_menu` (`id`),
  CONSTRAINT `t_menu_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_menu_role` */

insert  into `t_menu_role`(`mid`,`rid`,`gmt_create`,`remark`) values (7,6,'2021-02-06 20:44:18',NULL),(8,6,'2021-02-06 20:44:18',NULL),(11,6,'2021-02-06 20:44:18',NULL),(7,4,'2021-02-06 20:46:09',NULL),(7,7,'2021-02-06 20:47:02',NULL),(8,7,'2021-02-06 20:47:02',NULL),(9,7,'2021-02-06 20:47:02',NULL),(10,7,'2021-02-06 20:47:02',NULL),(11,7,'2021-02-06 20:47:02',NULL),(12,7,'2021-02-06 20:47:02',NULL),(13,7,'2021-02-06 20:47:02',NULL),(7,1,'2021-02-07 20:47:58',NULL),(8,1,'2021-02-07 20:47:58',NULL),(9,1,'2021-02-07 20:47:58',NULL),(10,1,'2021-02-07 20:47:58',NULL),(11,1,'2021-02-07 20:47:58',NULL),(12,1,'2021-02-07 20:47:58',NULL),(13,1,'2021-02-07 20:47:58',NULL),(14,1,'2021-02-07 20:47:58',NULL),(15,1,'2021-02-07 20:47:58',NULL),(16,1,'2021-02-07 20:47:58',NULL),(17,1,'2021-02-07 20:47:58',NULL),(18,1,'2021-02-07 20:47:58',NULL),(30,1,'2021-02-07 20:47:58',NULL),(19,1,'2021-02-07 20:47:58',NULL),(20,1,'2021-02-07 20:47:58',NULL),(21,1,'2021-02-07 20:47:58',NULL),(22,1,'2021-02-07 20:47:58',NULL),(23,1,'2021-02-07 20:47:58',NULL),(24,1,'2021-02-07 20:47:58',NULL),(25,1,'2021-02-07 20:47:58',NULL),(26,1,'2021-02-07 20:47:58',NULL),(27,1,'2021-02-07 20:47:58',NULL),(28,1,'2021-02-07 20:47:58',NULL),(7,5,'2021-02-09 11:21:59',NULL),(8,5,'2021-02-09 11:21:59',NULL),(9,5,'2021-02-09 11:21:59',NULL),(10,5,'2021-02-09 11:21:59',NULL),(11,5,'2021-02-09 11:21:59',NULL),(12,5,'2021-02-09 11:21:59',NULL),(13,5,'2021-02-09 11:21:59',NULL),(14,5,'2021-02-09 11:21:59',NULL),(15,5,'2021-02-09 11:21:59',NULL),(16,5,'2021-02-09 11:21:59',NULL),(17,5,'2021-02-09 11:21:59',NULL),(18,5,'2021-02-09 11:21:59',NULL),(19,5,'2021-02-09 11:21:59',NULL),(20,5,'2021-02-09 11:21:59',NULL),(21,5,'2021-02-09 11:21:59',NULL),(22,5,'2021-02-09 11:21:59',NULL),(23,5,'2021-02-09 11:21:59',NULL),(24,5,'2021-02-09 11:21:59',NULL),(25,5,'2021-02-09 11:21:59',NULL),(26,5,'2021-02-09 11:21:59',NULL),(27,5,'2021-02-09 11:21:59',NULL),(28,5,'2021-02-09 11:21:59',NULL),(7,23,'2021-02-09 15:56:11',NULL),(8,23,'2021-02-09 15:56:11',NULL),(9,23,'2021-02-09 15:56:11',NULL),(10,23,'2021-02-09 15:56:11',NULL),(11,23,'2021-02-09 15:56:11',NULL),(12,23,'2021-02-09 15:56:11',NULL),(13,23,'2021-02-09 15:56:11',NULL),(14,23,'2021-02-09 15:56:11',NULL),(15,23,'2021-02-09 15:56:11',NULL),(16,23,'2021-02-09 15:56:11',NULL),(17,23,'2021-02-09 15:56:11',NULL),(18,23,'2021-02-09 15:56:11',NULL),(19,23,'2021-02-09 15:56:11',NULL),(20,23,'2021-02-09 15:56:11',NULL),(21,23,'2021-02-09 15:56:11',NULL),(22,23,'2021-02-09 15:56:11',NULL),(23,23,'2021-02-09 15:56:11',NULL),(24,23,'2021-02-09 15:56:11',NULL),(25,23,'2021-02-09 15:56:11',NULL),(26,23,'2021-02-09 15:56:11',NULL),(27,23,'2021-02-09 15:56:11',NULL),(28,23,'2021-02-09 15:56:11',NULL),(7,3,'2021-02-09 15:56:16',NULL),(8,3,'2021-02-09 15:56:16',NULL),(9,3,'2021-02-09 15:56:16',NULL),(10,3,'2021-02-09 15:56:16',NULL),(11,3,'2021-02-09 15:56:16',NULL),(12,3,'2021-02-09 15:56:16',NULL),(13,3,'2021-02-09 15:56:16',NULL),(14,3,'2021-02-09 15:56:16',NULL),(15,3,'2021-02-09 15:56:16',NULL),(16,3,'2021-02-09 15:56:16',NULL),(17,3,'2021-02-09 15:56:16',NULL),(18,3,'2021-02-09 15:56:16',NULL),(19,3,'2021-02-09 15:56:16',NULL),(20,3,'2021-02-09 15:56:16',NULL),(21,3,'2021-02-09 15:56:16',NULL),(22,3,'2021-02-09 15:56:16',NULL),(23,3,'2021-02-09 15:56:16',NULL),(24,3,'2021-02-09 15:56:16',NULL),(25,3,'2021-02-09 15:56:16',NULL),(26,3,'2021-02-09 15:56:16',NULL),(27,3,'2021-02-09 15:56:16',NULL),(28,3,'2021-02-09 15:56:16',NULL),(7,2,'2021-03-04 06:56:20',NULL),(8,2,'2021-03-04 06:56:20',NULL),(9,2,'2021-03-04 06:56:20',NULL),(10,2,'2021-03-04 06:56:20',NULL),(11,2,'2021-03-04 06:56:20',NULL),(12,2,'2021-03-04 06:56:20',NULL),(13,2,'2021-03-04 06:56:20',NULL),(14,2,'2021-03-04 06:56:20',NULL),(15,2,'2021-03-04 06:56:20',NULL),(16,2,'2021-03-04 06:56:20',NULL),(17,2,'2021-03-04 06:56:20',NULL),(18,2,'2021-03-04 06:56:20',NULL),(30,2,'2021-03-04 06:56:20',NULL);

/*Table structure for table `t_nation` */

DROP TABLE IF EXISTS `t_nation`;

CREATE TABLE `t_nation` (
  `id` int NOT NULL COMMENT '民族id',
  `name` varchar(10) DEFAULT NULL COMMENT '民族名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_nation` */

insert  into `t_nation`(`id`,`name`) values (1,'汉族'),(2,'蒙古族'),(3,'回族'),(4,'藏族'),(5,'维吾尔族'),(6,'苗族'),(7,'彝族'),(8,'壮族'),(9,'布依族'),(10,'朝鲜族'),(11,'满族'),(12,'侗族'),(13,'瑶族'),(14,'白族'),(15,'土家族'),(16,'哈尼族'),(17,'哈萨克族'),(18,'傣族'),(19,'黎族'),(20,'傈僳族'),(21,'佤族'),(22,'畲族'),(23,'高山族'),(24,'拉祜族'),(25,'水族'),(26,'东乡族'),(27,'纳西族'),(28,'景颇族'),(29,'柯尔克孜族'),(30,'土族'),(31,'达斡尔族'),(32,'仫佬族'),(33,'羌族'),(34,'布朗族'),(35,'撒拉族'),(36,'毛难族'),(37,'仡佬族'),(38,'锡伯族'),(39,'阿昌族'),(40,'普米族'),(41,'塔吉克族'),(42,'怒族'),(43,'乌孜别克族'),(44,'俄罗斯族'),(45,'鄂温克族'),(46,'崩龙族'),(47,'保安族'),(48,'裕固族'),(49,'京族'),(50,'塔塔尔族'),(51,'独龙族'),(52,'鄂伦春族'),(53,'赫哲族'),(54,'门巴族'),(55,'珞巴族'),(56,'基诺族'),(57,'其他');

/*Table structure for table `t_politics_status` */

DROP TABLE IF EXISTS `t_politics_status`;

CREATE TABLE `t_politics_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `t_politics_status` */

insert  into `t_politics_status`(`id`,`name`) values (1,'中共预备党员'),(2,'台盟盟员'),(3,'普通公民'),(4,'民盟盟员'),(5,'九三学社社员'),(6,'民革党员'),(7,'农工党员'),(8,'共青团员'),(9,'其他');

/*Table structure for table `t_position` */

DROP TABLE IF EXISTS `t_position`;

CREATE TABLE `t_position` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '职位',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `enabled` tinyint(1) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

/*Data for the table `t_position` */

insert  into `t_position`(`id`,`name`,`create_date`,`enabled`) values (1,'技术总监','2021-02-03 19:28:45',1),(2,'运营总监','2021-02-03 19:28:47',1),(3,'市场总监','2021-02-03 19:28:23',1),(4,'研发工程师','2021-02-03 19:28:33',1),(5,'运维工程师','2021-02-03 19:28:43',1),(7,'测试职位','2021-02-03 22:52:59',0),(80,'实施工程师','2021-02-21 09:57:05',1),(81,'项目主管','2021-02-21 09:57:20',1),(82,'测试总监','2021-02-21 09:57:35',1);

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色码',
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `enabled` tinyint(1) DEFAULT '1' COMMENT '是否启用',
  `remark` varchar(100) DEFAULT NULL COMMENT '角色备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`code`,`name`,`gmt_create`,`enabled`,`remark`) values (1,'ROLE_superAdmin','超级管理员','2021-02-01 19:05:41',1,NULL),(2,'ROLE_admin','系统管理员','2021-02-01 19:06:06',1,NULL),(3,'ROLE_manager','部门经理','2021-02-03 00:00:00',1,NULL),(4,'ROLE_recruiter','招聘主管','2021-02-03 15:42:29',1,NULL),(5,'ROLE_ personnel','人事专员','2021-02-03 00:00:00',1,NULL),(6,'ROLE_train','培训主管','2021-02-03 00:00:00',0,NULL),(7,'ROLE_performance','薪资绩效主管','2021-02-03 00:00:00',1,NULL),(23,'ROLE_test','测试角色','2021-02-08 00:00:00',1,NULL),(24,'ROLE_111','111111','2021-02-08 00:00:00',1,NULL),(25,'ROLE_222','2222','2021-02-08 00:00:00',1,NULL);

/*Table structure for table `t_salary` */

DROP TABLE IF EXISTS `t_salary`;

CREATE TABLE `t_salary` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名称',
  `basic_salary` double DEFAULT NULL COMMENT '基本工资',
  `bonus` double DEFAULT NULL COMMENT '奖金',
  `lunch_salary` double DEFAULT NULL COMMENT '午餐补助',
  `traffic_salary` double DEFAULT NULL COMMENT '交通补助',
  `all_salary` double DEFAULT NULL COMMENT '应发工资',
  `pension_base` double DEFAULT NULL COMMENT '养老基金数',
  `pension_per` double DEFAULT NULL COMMENT '养老金比率',
  `create_date` datetime DEFAULT NULL COMMENT '启用时间',
  `medical_base` int DEFAULT NULL COMMENT '医疗基数',
  `medical_per` float DEFAULT NULL COMMENT '医疗保险比率',
  `accumulation_fund_base` int DEFAULT NULL COMMENT '公积金基数',
  `accumulation_fund_per` float DEFAULT NULL COMMENT '公积金比率',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `t_salary` */

insert  into `t_salary`(`id`,`name`,`basic_salary`,`bonus`,`lunch_salary`,`traffic_salary`,`all_salary`,`pension_base`,`pension_per`,`create_date`,`medical_base`,`medical_per`,`accumulation_fund_base`,`accumulation_fund_per`) values (1,'市场部工资账套',8000,500,800,400,NULL,1000,0.06,'2021-02-24 00:00:00',1000,0.06,1000,0.06),(2,'人事部工资账套',3000,500,500,500,NULL,1800,0.06,'2021-02-24 00:00:00',2200,0.06,3200,0.06),(3,'运维部工资账套',9000,500,1000,1000,NULL,3000,0.06,'2021-02-24 00:00:00',3000,0.06,3000,0.06),(4,'财务部工资账套',5000,500,500,500,NULL,500,0.06,'2021-02-24 13:09:16',500,0.06,500,0.06),(5,'测试部工资账套',3000,500,500,500,NULL,500,0.06,'2021-02-24 14:22:18',500,0.06,500,0.06),(6,'技术部工资账套',7000,500,1000,700,NULL,700,0.06,'2021-02-24 14:23:07',700,0.06,500,0.06),(8,'123',123,23123,3123,3123,NULL,213,312,'2021-02-24 15:40:57',323,312,3123,312);

/*Table structure for table `t_sys_log` */

DROP TABLE IF EXISTS `t_sys_log`;

CREATE TABLE `t_sys_log` (
  `title` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `user_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作用户',
  `class_name` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类名',
  `method` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '方法名',
  `param` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '方法参数',
  `visit_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '访问时间',
  `execution_time` bigint DEFAULT NULL COMMENT '操作时长',
  `ip` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'ip',
  `url` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'url',
  `os_and_browser` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作系统及浏览器信息',
  `session_id` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'session id',
  `req_method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求方式',
  `is_ajax` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否是Ajax请求',
  `user_id` int DEFAULT '0' COMMENT '操作用户id',
  `result` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '方法返回结果',
  `exception` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '异常信息'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_log` */

/* Procedure structure for procedure `GreetWorld` */

/*!50003 DROP PROCEDURE IF EXISTS  `GreetWorld` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `GreetWorld`()
select concat(@gretting,'world') */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
