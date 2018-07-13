/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.6.24 : Database - king-admin
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`king-admin` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `king-admin`;

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` varchar(32) NOT NULL,
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父菜单ID',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `type` varchar(10) DEFAULT NULL,
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `title` varchar(50) DEFAULT NULL COMMENT '菜单标题',
  `level` int(11) DEFAULT NULL COMMENT '菜单层级',
  `order` int(11) DEFAULT NULL COMMENT '排序',
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单管理';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`parent_id`,`name`,`type`,`icon`,`title`,`level`,`order`,`create_user_id`,`create_time`,`update_user_id`,`update_time`) values ('00a6357c7ab14d9d9720124632dc948d','ab5dd0bc078443d9b7163567474526c9','sys.role.view','2','ion-search','查看',3,4,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-18 11:01:21',NULL,NULL),('07ba4e5b9888403780856184e6e30c6d','#','KT Admin','0',NULL,'平台菜单',0,0,NULL,NULL,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-24 00:54:11'),('0d3e4a35ad03449ba409223d99963aae','745d991060c54cd8a9c490409c4aa903','sys.menu.add','2','ion-plus-round','新增',3,1,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-18 19:09:20',NULL,NULL),('1efd3ab941164ac9a8f87aa5148d1820','d1ec24bffa654aa888fdfb331ede091a','dict.dictclass.edit','2','ion-edit','编辑',3,2,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 11:06:08','96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 11:06:08'),('36e07c711c034e8da6040153e6493aa7','f0dbb3052721482d90df80128dfcff18','sys.user.delete','2','ion-trash-a','删除',2,3,NULL,NULL,NULL,NULL),('375d52d5fa4a44d690e613ad740aa60d','745d991060c54cd8a9c490409c4aa903','sys.menu.delete','2','ion-trash-a','删除',3,3,'16ca5e0d3d4a4f988f748a5879c9ca98','2017-06-20 16:27:20','16ca5e0d3d4a4f988f748a5879c9ca98','2017-06-20 16:27:20'),('3aa370c18b8841b784a4ea616576a849','ab5dd0bc078443d9b7163567474526c9','sys.role.edit','2','ion-edit','编辑',3,2,NULL,NULL,NULL,NULL),('48ec7769aff1400186bdeb5da1dfe745','ab5dd0bc078443d9b7163567474526c9','sys.role.add','2','ion-plus-round','新增',3,1,NULL,NULL,NULL,NULL),('4a4b2b5bf36945b89bbafd7ecef9b9b2','f0dbb3052721482d90df80128dfcff18','sys.user.view','2','ion-search','查看',2,4,NULL,NULL,NULL,NULL),('4c7f081cf62a420ea7980901a29d0ec4','f0dbb3052721482d90df80128dfcff18','sys.user.edit','2','ion-edit','编辑',2,2,NULL,NULL,NULL,NULL),('5a3ae113d7564a01855ab006a36905df','745d991060c54cd8a9c490409c4aa903','sys.menu.view','2','ion-search','查看',3,4,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 10:57:04','96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 10:57:04'),('62afbed699844c90a3d7677d672508d1','ab5dd0bc078443d9b7163567474526c9','sys.role.delete','2','ion-trash-a','删除',3,3,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-18 11:00:07',NULL,NULL),('68c4c8f6bdee4dbe9d3d2a546e9ae0a9','c45d42e50495435ab416db0ec92e481d','dict.dict','1','ion-document-text','字典管理',2,2,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-21 17:23:15','96169ca8adb04ca6b63e0d492a9b2807','2017-06-21 17:25:01'),('6cafc502862b4c538611ecc3988a5306','68c4c8f6bdee4dbe9d3d2a546e9ae0a9','dict.dict.view','2','ion-search','查看',3,4,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 11:13:02','96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 11:13:02'),('73923860f3f2437b870f257028459172','07ba4e5b9888403780856184e6e30c6d','sys','0','ion-grid','系统管理',0,2,NULL,NULL,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-24 00:54:15'),('745d991060c54cd8a9c490409c4aa903','73923860f3f2437b870f257028459172','sys.menu','1','socicon socicon-twitter','菜单管理',1,3,NULL,NULL,NULL,NULL),('878f1a934bf044a5bee37608aa237f56','68c4c8f6bdee4dbe9d3d2a546e9ae0a9','dict.dict.delete','2','ion-trash-a','删除',3,3,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 11:12:25','96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 11:12:25'),('a215acffb61e43c4803c8c0cbd99ae28','745d991060c54cd8a9c490409c4aa903','sys.menu.edit','2','ion-edit','编辑',3,2,'16ca5e0d3d4a4f988f748a5879c9ca98','2017-06-20 16:25:15','16ca5e0d3d4a4f988f748a5879c9ca98','2017-06-20 16:25:15'),('ab5dd0bc078443d9b7163567474526c9','73923860f3f2437b870f257028459172','sys.role','1','socicon socicon-facebook','角色管理',1,1,NULL,NULL,NULL,NULL),('aeafd2a9381e48268948358c4b35276f','d1ec24bffa654aa888fdfb331ede091a','dict.dictclass.add','2','ion-plus-round','新增',3,1,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 10:58:06','96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 10:58:06'),('b72da734c7074ef1829103775baf1cb8','d1ec24bffa654aa888fdfb331ede091a','dict.dictclass.delete','2','ion-trash-a','删除',3,3,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 11:07:20','96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 11:07:20'),('c20c19ec0c9a4954abeca8948da17d13','d1ec24bffa654aa888fdfb331ede091a','dict.dictclass.view','2','ion-search','查看',3,4,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 11:08:15','96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 11:08:15'),('c45d42e50495435ab416db0ec92e481d','07ba4e5b9888403780856184e6e30c6d','dict','0','ion-navicon-round','字典管理',1,3,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-21 17:20:11','96169ca8adb04ca6b63e0d492a9b2807','2017-06-21 17:21:44'),('cdcb8499fee84a7aa2967b8269feea59','68c4c8f6bdee4dbe9d3d2a546e9ae0a9','dict.dict.add','2','ion-plus-round','新增',3,1,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 11:09:17','96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 11:09:17'),('d1ec24bffa654aa888fdfb331ede091a','c45d42e50495435ab416db0ec92e481d','dict.dictclass','1','ion-clipboard','字典分类',2,1,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-21 17:24:49','96169ca8adb04ca6b63e0d492a9b2807','2017-06-24 00:54:04'),('d54e5e8cf6d14ba194c14a938e6915bd','68c4c8f6bdee4dbe9d3d2a546e9ae0a9','dict.dict.edit','2','ion-edit','编辑',3,2,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 11:11:13','96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 11:11:13'),('ef9e6d3e2d984667945228a0c7157831','f0dbb3052721482d90df80128dfcff18','sys.user.add','2','ion-plus-round','新增',2,1,NULL,NULL,NULL,NULL),('f0dbb3052721482d90df80128dfcff18','73923860f3f2437b870f257028459172','sys.user','1','socicon socicon-github','用户管理',1,0,NULL,NULL,NULL,NULL),('f5efec389be0435d9e365e7b8c498071','07ba4e5b9888403780856184e6e30c6d','home','1','ion-android-home','首页',0,0,NULL,NULL,'16ca5e0d3d4a4f988f748a5879c9ca98','2017-06-20 18:37:04');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` varchar(32) NOT NULL,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`role_name`,`remark`,`create_user_id`,`create_time`,`update_user_id`,`update_time`) values ('0074d75da58445249417c76111a4b018','admin','系统管理员',NULL,NULL,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 11:18:48'),('1eb2ee3af13c4effb70c6c1c7456ac3b','user1','普通用户1',NULL,NULL,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 11:45:55'),('7b3ddb7091004a40ad6391f414d50a65','user2','系统用户2',NULL,NULL,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 12:39:45');

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `id` varchar(32) NOT NULL,
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色ID',
  `menu_id` varchar(32) DEFAULT NULL COMMENT '菜单ID',
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单关系表';

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`create_user_id`,`create_time`,`update_user_id`,`update_time`) values ('00db262988344baaa790b1b4e0550f04','f27aeac8a4e742a6942200b7eaebdb0f','68c4c8f6bdee4dbe9d3d2a546e9ae0a9',NULL,NULL,NULL,NULL),('010f21550ccc43689b3e93e005907b23','6f67751171c9490f91c647e3088a3939','878f1a934bf044a5bee37608aa237f56',NULL,NULL,NULL,NULL),('0833ea43b8e84e7284888b7d6672f80f','0074d75da58445249417c76111a4b018','1efd3ab941164ac9a8f87aa5148d1820',NULL,NULL,NULL,NULL),('0bf91e9a0bb14113824d3d5f511f82c3','0074d75da58445249417c76111a4b018','3aa370c18b8841b784a4ea616576a849',NULL,NULL,NULL,NULL),('0d495ee552fe401ea5a0353a04228844','0074d75da58445249417c76111a4b018','ef9e6d3e2d984667945228a0c7157831',NULL,NULL,NULL,NULL),('0d5d78c94af3495c909490a41ed738f6','0074d75da58445249417c76111a4b018','4a4b2b5bf36945b89bbafd7ecef9b9b2',NULL,NULL,NULL,NULL),('0f611b33d28042299b59261a70274d3a','6f67751171c9490f91c647e3088a3939','cdcb8499fee84a7aa2967b8269feea59',NULL,NULL,NULL,NULL),('13bdd985e6414a3c80c43550dacf9be7','f27aeac8a4e742a6942200b7eaebdb0f','00a6357c7ab14d9d9720124632dc948d',NULL,NULL,NULL,NULL),('14331359a259415eb1edd419cbfea243','0074d75da58445249417c76111a4b018','ab5dd0bc078443d9b7163567474526c9',NULL,NULL,NULL,NULL),('17413d4962ce488ca79a009fe64c853e','6f67751171c9490f91c647e3088a3939','f5efec389be0435d9e365e7b8c498071',NULL,NULL,NULL,NULL),('2515ac44435842afae5bf3f69cfce323','0074d75da58445249417c76111a4b018','f5efec389be0435d9e365e7b8c498071',NULL,NULL,NULL,NULL),('25f1bd8542bd413a91a166a4af120381','f27aeac8a4e742a6942200b7eaebdb0f','f0dbb3052721482d90df80128dfcff18',NULL,NULL,NULL,NULL),('283eb36aa34845b7964e6fbbfa2f81ef','7b3ddb7091004a40ad6391f414d50a65','c20c19ec0c9a4954abeca8948da17d13',NULL,NULL,NULL,NULL),('293108ca0db44d31b337bf60384c004e','0074d75da58445249417c76111a4b018','48ec7769aff1400186bdeb5da1dfe745',NULL,NULL,NULL,NULL),('2a43054695e9483393e1bae7c395802a','0074d75da58445249417c76111a4b018','375d52d5fa4a44d690e613ad740aa60d',NULL,NULL,NULL,NULL),('2e59ddd8dd5b4d75bfdb107f54cc35fa','626fca694e254c499b965d937dfaa019','3aa370c18b8841b784a4ea616576a849',NULL,NULL,NULL,NULL),('2e831d32f93d4e8987e6971237ffd3b6','0074d75da58445249417c76111a4b018','68c4c8f6bdee4dbe9d3d2a546e9ae0a9',NULL,NULL,NULL,NULL),('32bd6e9c90d0444396301b3c57725a7f','0074d75da58445249417c76111a4b018','aeafd2a9381e48268948358c4b35276f',NULL,NULL,NULL,NULL),('42bfc5bbdd9a4a2daa998b8a984c06ac','6f67751171c9490f91c647e3088a3939','00a6357c7ab14d9d9720124632dc948d',NULL,NULL,NULL,NULL),('44671d5c28d74578914b974f6dc12bb8','f27aeac8a4e742a6942200b7eaebdb0f','c20c19ec0c9a4954abeca8948da17d13',NULL,NULL,NULL,NULL),('46a5c488753148c58d39f7594a75cf9d','0074d75da58445249417c76111a4b018','d1ec24bffa654aa888fdfb331ede091a',NULL,NULL,NULL,NULL),('473b71582df64eb184f2132abd18e014','f27aeac8a4e742a6942200b7eaebdb0f','878f1a934bf044a5bee37608aa237f56',NULL,NULL,NULL,NULL),('4bf91f6cd53c4ce6aacb728ea3f449d4','f27aeac8a4e742a6942200b7eaebdb0f','ef9e6d3e2d984667945228a0c7157831',NULL,NULL,NULL,NULL),('4c627308acce4741bb529bcd9252fcc1','f27aeac8a4e742a6942200b7eaebdb0f','c45d42e50495435ab416db0ec92e481d',NULL,NULL,NULL,NULL),('50c135a25c024163bfb69ffa0ae6080e','0074d75da58445249417c76111a4b018','c20c19ec0c9a4954abeca8948da17d13',NULL,NULL,NULL,NULL),('545f0f4196b14d959bd4ac44ff181a7c','0074d75da58445249417c76111a4b018','07ba4e5b9888403780856184e6e30c6d',NULL,NULL,NULL,NULL),('551d3af9976146cd9529a97c00ee2c50','f27aeac8a4e742a6942200b7eaebdb0f','62afbed699844c90a3d7677d672508d1',NULL,NULL,NULL,NULL),('58da148c72dd4ac09db6cb40a3138c04','7b3ddb7091004a40ad6391f414d50a65','6cafc502862b4c538611ecc3988a5306',NULL,NULL,NULL,NULL),('59ed5348b1534d30a52c31b1ca8b9251','6f67751171c9490f91c647e3088a3939','d1ec24bffa654aa888fdfb331ede091a',NULL,NULL,NULL,NULL),('5a0d739a61d5452898049821fd6e634c','0074d75da58445249417c76111a4b018','d54e5e8cf6d14ba194c14a938e6915bd',NULL,NULL,NULL,NULL),('6013b98e8a494afd9c5520196892c24b','f27aeac8a4e742a6942200b7eaebdb0f','07ba4e5b9888403780856184e6e30c6d',NULL,NULL,NULL,NULL),('611806c3c79d45e9bea07db58165620c','6f67751171c9490f91c647e3088a3939','62afbed699844c90a3d7677d672508d1',NULL,NULL,NULL,NULL),('61df740299d94085bf7fcedb32ca5ff8','0074d75da58445249417c76111a4b018','745d991060c54cd8a9c490409c4aa903',NULL,NULL,NULL,NULL),('620b005fa78643c998c519196ef85626','f27aeac8a4e742a6942200b7eaebdb0f','aeafd2a9381e48268948358c4b35276f',NULL,NULL,NULL,NULL),('6aaeebf0622f4dce866531d77d412d7e','f27aeac8a4e742a6942200b7eaebdb0f','3aa370c18b8841b784a4ea616576a849',NULL,NULL,NULL,NULL),('6b90d7e878dc4fe4a5f44627ac2f6247','7b3ddb7091004a40ad6391f414d50a65','5a3ae113d7564a01855ab006a36905df',NULL,NULL,NULL,NULL),('73574a7cb7064cdf8ced0da9e368d533','0074d75da58445249417c76111a4b018','00a6357c7ab14d9d9720124632dc948d',NULL,NULL,NULL,NULL),('75b438ce4d9e4586a5b3e19ff76962b1','0d42864fe1ac4dc7a4506265554a1be3','f5efec389be0435d9e365e7b8c498071',NULL,NULL,NULL,NULL),('765ed0b807dc4e90b5ce30ccbddf0317','0074d75da58445249417c76111a4b018','0d3e4a35ad03449ba409223d99963aae',NULL,NULL,NULL,NULL),('77024414c74d4d4890c47cecdc756495','6f67751171c9490f91c647e3088a3939','d54e5e8cf6d14ba194c14a938e6915bd',NULL,NULL,NULL,NULL),('8069d9a7e5be4a7abba646209bd27431','7b3ddb7091004a40ad6391f414d50a65','4a4b2b5bf36945b89bbafd7ecef9b9b2',NULL,NULL,NULL,NULL),('81a16342df174eecadbd148814902fb1','626fca694e254c499b965d937dfaa019','4c7f081cf62a420ea7980901a29d0ec4',NULL,NULL,NULL,NULL),('868aa1216ac046aaa9989a8df3e31aea','f27aeac8a4e742a6942200b7eaebdb0f','745d991060c54cd8a9c490409c4aa903',NULL,NULL,NULL,NULL),('8913bd28efe44d5a8c87b1c729c98f0c','f27aeac8a4e742a6942200b7eaebdb0f','d54e5e8cf6d14ba194c14a938e6915bd',NULL,NULL,NULL,NULL),('8e99ccbe2f6a4f4f9a109043df6c0348','6f67751171c9490f91c647e3088a3939','07ba4e5b9888403780856184e6e30c6d',NULL,NULL,NULL,NULL),('929dc4e7221040fdb2cb7c181df48f8a','f27aeac8a4e742a6942200b7eaebdb0f','1efd3ab941164ac9a8f87aa5148d1820',NULL,NULL,NULL,NULL),('9c536d1e3cf14448916feba56eabe32d','f27aeac8a4e742a6942200b7eaebdb0f','73923860f3f2437b870f257028459172',NULL,NULL,NULL,NULL),('9d244693ccc0440bb32bbd8baea5588c','f27aeac8a4e742a6942200b7eaebdb0f','b72da734c7074ef1829103775baf1cb8',NULL,NULL,NULL,NULL),('9e006b0e8e574494b2e2173567aeab5b','f27aeac8a4e742a6942200b7eaebdb0f','f5efec389be0435d9e365e7b8c498071',NULL,NULL,NULL,NULL),('9e0392b744ba4728ab059f8f3565f7da','7b3ddb7091004a40ad6391f414d50a65','00a6357c7ab14d9d9720124632dc948d',NULL,NULL,NULL,NULL),('9f5cf3799ade46c099fb66a7fa4c222a','6f67751171c9490f91c647e3088a3939','b72da734c7074ef1829103775baf1cb8',NULL,NULL,NULL,NULL),('9f91da986e5d4513971e8f2006ff382c','0074d75da58445249417c76111a4b018','878f1a934bf044a5bee37608aa237f56',NULL,NULL,NULL,NULL),('a01d3c1c67ff4b81a303c0085efa05d5','f27aeac8a4e742a6942200b7eaebdb0f','a215acffb61e43c4803c8c0cbd99ae28',NULL,NULL,NULL,NULL),('a2ae3a6c4362435e84acb345404f8b74','f27aeac8a4e742a6942200b7eaebdb0f','6cafc502862b4c538611ecc3988a5306',NULL,NULL,NULL,NULL),('a5db2f79b81a414caae57cba2d93f5aa','0074d75da58445249417c76111a4b018','6cafc502862b4c538611ecc3988a5306',NULL,NULL,NULL,NULL),('a6b473312e3f4a13b2cebc4a0fae5a4d','6f67751171c9490f91c647e3088a3939','3aa370c18b8841b784a4ea616576a849',NULL,NULL,NULL,NULL),('aa407052aab54cb4be3da864835e730a','0074d75da58445249417c76111a4b018','b72da734c7074ef1829103775baf1cb8',NULL,NULL,NULL,NULL),('abde38450a2b4e9d948bd15feac0657f','0074d75da58445249417c76111a4b018','36e07c711c034e8da6040153e6493aa7',NULL,NULL,NULL,NULL),('b0a4d9cf0b564fbba8d0be98a225c4df','f27aeac8a4e742a6942200b7eaebdb0f','0d3e4a35ad03449ba409223d99963aae',NULL,NULL,NULL,NULL),('b6e9a442827b414bab3403bc7ebe1387','6f67751171c9490f91c647e3088a3939','6cafc502862b4c538611ecc3988a5306',NULL,NULL,NULL,NULL),('b853f68524f44626aade1a0ec9012794','0074d75da58445249417c76111a4b018','a215acffb61e43c4803c8c0cbd99ae28',NULL,NULL,NULL,NULL),('b8f88ae04de04538858daf0997ce08f5','0074d75da58445249417c76111a4b018','f0dbb3052721482d90df80128dfcff18',NULL,NULL,NULL,NULL),('b918f6d9344d4b9890e1f1bc02494a4b','f27aeac8a4e742a6942200b7eaebdb0f','5a3ae113d7564a01855ab006a36905df',NULL,NULL,NULL,NULL),('bb5f1fb6fd5c4cd29677ec418d9984b0','0074d75da58445249417c76111a4b018','62afbed699844c90a3d7677d672508d1',NULL,NULL,NULL,NULL),('bbe0551ced354e5e932938a2f5e518c5','f27aeac8a4e742a6942200b7eaebdb0f','4a4b2b5bf36945b89bbafd7ecef9b9b2',NULL,NULL,NULL,NULL),('bc53ddac77084e6a93d1e09c5db3270e','b572cff8564b4348b8ee4f2f4209b9fa','f5efec389be0435d9e365e7b8c498071',NULL,NULL,NULL,NULL),('bfb6addc00ab4c2cb3ac51e51b9e9d2b','0074d75da58445249417c76111a4b018','cdcb8499fee84a7aa2967b8269feea59',NULL,NULL,NULL,NULL),('c1084ab8c22c470aae50ecd18b44c7cb','6f67751171c9490f91c647e3088a3939','ab5dd0bc078443d9b7163567474526c9',NULL,NULL,NULL,NULL),('c27677e148d345bca46ac64dac41f19f','f27aeac8a4e742a6942200b7eaebdb0f','4c7f081cf62a420ea7980901a29d0ec4',NULL,NULL,NULL,NULL),('c461bf6086e24be0a8095659caafc5f9','6f67751171c9490f91c647e3088a3939','c20c19ec0c9a4954abeca8948da17d13',NULL,NULL,NULL,NULL),('c6cba93c651f4b489bfee278ab61c2e1','6f67751171c9490f91c647e3088a3939','f0dbb3052721482d90df80128dfcff18',NULL,NULL,NULL,NULL),('c70c25e947c949339acc0c037410dd81','0074d75da58445249417c76111a4b018','4c7f081cf62a420ea7980901a29d0ec4',NULL,NULL,NULL,NULL),('c74cb9ab0b024127981a58993f07c318','626fca694e254c499b965d937dfaa019','62afbed699844c90a3d7677d672508d1',NULL,NULL,NULL,NULL),('cab1a29cf94741528aca3d74feeff841','6f67751171c9490f91c647e3088a3939','c45d42e50495435ab416db0ec92e481d',NULL,NULL,NULL,NULL),('cfd9ce7dbcf048dcbb167d9dad1f2f34','0074d75da58445249417c76111a4b018','73923860f3f2437b870f257028459172',NULL,NULL,NULL,NULL),('d21a809fe2d9498c9fc3724d3ee7da52','0074d75da58445249417c76111a4b018','c45d42e50495435ab416db0ec92e481d',NULL,NULL,NULL,NULL),('d47376ebe40c4adf9422d08b78e2db20','0074d75da58445249417c76111a4b018','5a3ae113d7564a01855ab006a36905df',NULL,NULL,NULL,NULL),('d9e9d33511114a2e9db99eb42b388a59','f27aeac8a4e742a6942200b7eaebdb0f','ab5dd0bc078443d9b7163567474526c9',NULL,NULL,NULL,NULL),('db25c4094d28476ea275a3b52a4febc6','6f67751171c9490f91c647e3088a3939','aeafd2a9381e48268948358c4b35276f',NULL,NULL,NULL,NULL),('db4571f749024bcfb327144eb0ab6382','7b3ddb7091004a40ad6391f414d50a65','f5efec389be0435d9e365e7b8c498071',NULL,NULL,NULL,NULL),('de78dd92f0014691ad425d858cc7c4f6','f27aeac8a4e742a6942200b7eaebdb0f','d1ec24bffa654aa888fdfb331ede091a',NULL,NULL,NULL,NULL),('e8c1ad915ba540d4a622f685d027db00','6f67751171c9490f91c647e3088a3939','68c4c8f6bdee4dbe9d3d2a546e9ae0a9',NULL,NULL,NULL,NULL),('ed48e5a735194461985a43f256e24d71','f27aeac8a4e742a6942200b7eaebdb0f','36e07c711c034e8da6040153e6493aa7',NULL,NULL,NULL,NULL),('edbf819981c84ef5b27d708de3c135af','1eb2ee3af13c4effb70c6c1c7456ac3b','f5efec389be0435d9e365e7b8c498071',NULL,NULL,NULL,NULL),('f21080bb32814e8fb995c8662b3ee348','6f67751171c9490f91c647e3088a3939','48ec7769aff1400186bdeb5da1dfe745',NULL,NULL,NULL,NULL),('fabe0a22232247c8b3a1b8a784a3d1be','f27aeac8a4e742a6942200b7eaebdb0f','375d52d5fa4a44d690e613ad740aa60d',NULL,NULL,NULL,NULL),('fc73cdbabec24cbeabb64c413676003e','6f67751171c9490f91c647e3088a3939','73923860f3f2437b870f257028459172',NULL,NULL,NULL,NULL),('fcaf988e520a4e55a64ed7e6c56f57a6','6f67751171c9490f91c647e3088a3939','1efd3ab941164ac9a8f87aa5148d1820',NULL,NULL,NULL,NULL),('fd5d207ac583494d84dc929aa60ca7cb','f27aeac8a4e742a6942200b7eaebdb0f','cdcb8499fee84a7aa2967b8269feea59',NULL,NULL,NULL,NULL),('fffd446ae9cc4c4da2eb85de38cc328f','f27aeac8a4e742a6942200b7eaebdb0f','48ec7769aff1400186bdeb5da1dfe745',NULL,NULL,NULL,NULL);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` varchar(10) DEFAULT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`password`,`email`,`mobile`,`status`,`create_user_id`,`create_time`,`update_user_id`,`update_time`) values ('16ca5e0d3d4a4f988f748a5879c9ca98','kt','99d3fd0fa8fe115ef5983b5472cc95a88f2790a6fa89f8785da5afbe7b548bba','504406577@qq.com','13672336315','1',NULL,NULL,'96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 12:40:59'),('65909bf4abe8440cae422e5aa6e7f13c','admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','1234567890@qq.com',NULL,'1','96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 12:41:48','96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 12:41:48'),('6e4dd5065cf74e45a48145357c77e642','user3','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','123456@111.com',NULL,NULL,NULL,NULL,NULL,NULL),('9e48b78d6de247da9042a090c7bc69d8','user','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','1234567890@qq.com',NULL,'1','96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 12:42:11','65909bf4abe8440cae422e5aa6e7f13c','2017-07-02 19:00:08'),('efd171f2f6724e04b3e1a591301d4409','user1','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','1234567890@qq.com',NULL,'1','65909bf4abe8440cae422e5aa6e7f13c','2017-06-25 12:44:21','65909bf4abe8440cae422e5aa6e7f13c','2017-07-02 18:52:22');

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色ID',
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色关系表';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`user_id`,`role_id`,`create_user_id`,`create_time`,`update_user_id`,`update_time`) values ('041ce509b0374825b77306fb6a3979f7','65909bf4abe8440cae422e5aa6e7f13c','0074d75da58445249417c76111a4b018',NULL,NULL,NULL,NULL),('35f7c546aa754a078c8edb1001cde765','6e4dd5065cf74e45a48145357c77e642','1eb2ee3af13c4effb70c6c1c7456ac3b',NULL,NULL,NULL,NULL),('3ae7c14a0a5c457aa3145eb8f8153546','16ca5e0d3d4a4f988f748a5879c9ca98','1eb2ee3af13c4effb70c6c1c7456ac3b',NULL,NULL,NULL,NULL),('58324fd179414614b23460443de51425','96169ca8adb04ca6b63e0d492a9b2807','0d42864fe1ac4dc7a4506265554a1be3',NULL,NULL,NULL,NULL),('8472055b15974ca685e885053d19b872','9e48b78d6de247da9042a090c7bc69d8','7b3ddb7091004a40ad6391f414d50a65',NULL,NULL,NULL,NULL),('949241a2af0249fa81948c2eb8c64688','16ca5e0d3d4a4f988f748a5879c9ca98','0074d75da58445249417c76111a4b018',NULL,NULL,NULL,NULL),('9f17d09a94044b1abbb1eaaeb2863715','96169ca8adb04ca6b63e0d492a9b2807','0074d75da58445249417c76111a4b018',NULL,NULL,NULL,NULL),('a2378f3e62574d69920eb2618e900185','96169ca8adb04ca6b63e0d492a9b2807','0d42864fe1ac4dc7a4506265554a1be3',NULL,NULL,NULL,NULL),('a6f0257b38174c569e0d991b3cc02113','96169ca8adb04ca6b63e0d492a9b2807','0d42864fe1ac4dc7a4506265554a1be3',NULL,NULL,NULL,NULL),('ab98e75894cb485997c592822c4cad41','efd171f2f6724e04b3e1a591301d4409','1eb2ee3af13c4effb70c6c1c7456ac3b',NULL,NULL,NULL,NULL),('b27967fe1b234d2a849b6a7fd712489b','96169ca8adb04ca6b63e0d492a9b2807','0074d75da58445249417c76111a4b018',NULL,NULL,NULL,NULL),('b590ec1e3c1d46fb9b00287f441ae933','96169ca8adb04ca6b63e0d492a9b2807','1eb2ee3af13c4effb70c6c1c7456ac3b',NULL,NULL,NULL,NULL),('b69e74d75c254182a67064922e1d2536','96169ca8adb04ca6b63e0d492a9b2807','1eb2ee3af13c4effb70c6c1c7456ac3b',NULL,NULL,NULL,NULL),('bfb64440f825443a920bffb4be1b4312','96169ca8adb04ca6b63e0d492a9b2807','0074d75da58445249417c76111a4b018',NULL,NULL,NULL,NULL);

/*Table structure for table `tb_calendar` */

DROP TABLE IF EXISTS `tb_calendar`;

CREATE TABLE `tb_calendar` (
  `id` varchar(32) NOT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `start` varchar(100) DEFAULT NULL COMMENT '开始时间',
  `end` varchar(100) DEFAULT NULL COMMENT '结束时间',
  `color` varchar(100) DEFAULT NULL COMMENT '颜色',
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日历备忘表';


/*Table structure for table `tb_dict` */

DROP TABLE IF EXISTS `tb_dict`;

CREATE TABLE `tb_dict` (
  `id` varchar(32) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `dict_class_id` varchar(32) NOT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

/*Data for the table `tb_dict` */

insert  into `tb_dict`(`id`,`code`,`text`,`remark`,`dict_class_id`,`create_user_id`,`create_time`,`update_user_id`,`update_time`) values ('8bfaaed9f5594a4aa08cbebb0f8db418','1','菜单',NULL,'10172542c1f34489a11830ec5712f15a','96169ca8adb04ca6b63e0d492a9b2807','2017-06-23 16:30:42','65909bf4abe8440cae422e5aa6e7f13c','2017-07-02 23:58:24'),('9081106eb52c41c3b81e0cd74262e674','1','启用',NULL,'906b5e962d5445a58fbfd1fd6e996bfc','96169ca8adb04ca6b63e0d492a9b2807','2017-06-23 17:49:01','96169ca8adb04ca6b63e0d492a9b2807','2017-06-23 21:42:56'),('9301abc41a434000aa11c7ade532d242','0','目录',NULL,'10172542c1f34489a11830ec5712f15a','96169ca8adb04ca6b63e0d492a9b2807','2017-06-23 17:01:46','96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 10:22:30'),('c832bcc1002d4fd9882a5d020330c2d0','2','按钮',NULL,'10172542c1f34489a11830ec5712f15a','96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 10:23:39','65909bf4abe8440cae422e5aa6e7f13c','2017-07-02 23:58:19'),('f5440dd3c28b4b38834968225545c488','0','禁用',NULL,'906b5e962d5445a58fbfd1fd6e996bfc','96169ca8adb04ca6b63e0d492a9b2807','2017-06-23 17:49:33','96169ca8adb04ca6b63e0d492a9b2807','2017-06-23 17:49:33');

/*Table structure for table `tb_dict_class` */

DROP TABLE IF EXISTS `tb_dict_class`;

CREATE TABLE `tb_dict_class` (
  `id` varchar(32) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典分类表';

/*Data for the table `tb_dict_class` */

insert  into `tb_dict_class`(`id`,`code`,`remark`,`create_user_id`,`create_time`,`update_user_id`,`update_time`) values ('10172542c1f34489a11830ec5712f15a','MENUTYPE','菜单类型','96169ca8adb04ca6b63e0d492a9b2807','2017-06-22 00:08:56','96169ca8adb04ca6b63e0d492a9b2807','2017-06-25 10:20:34'),('906b5e962d5445a58fbfd1fd6e996bfc','USERSTATUS','用户状态','96169ca8adb04ca6b63e0d492a9b2807','2017-06-23 17:25:54','96169ca8adb04ca6b63e0d492a9b2807','2017-06-23 17:25:54');

/*Table structure for table `tb_todo` */

DROP TABLE IF EXISTS `tb_todo`;

CREATE TABLE `tb_todo` (
  `id` varchar(32) NOT NULL,
  `text` varchar(255) DEFAULT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='todo表';

#tb_customer
DROP TABLE IF EXISTS `tb_customer`;

CREATE TABLE `tb_customer` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `phone1` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `customer_group_id` varchar(32) DEFAULT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='tb_customer';



CREATE TABLE `tb_customer_group` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='tb_customer_group';



CREATE TABLE `tb_name_type` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='tb_name_type';



CREATE TABLE `tb_name_type_obj` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `name_type_id` varchar(32) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='tb_name_type_obj';

/*tb_complete_task*/


CREATE TABLE `tb_complete_task` (
  `id` varchar(32) NOT NULL,
    `customer_id` varchar(32) NOT NULL,
    `complete_num` varchar(32) NOT NULL,
    `complete_date` datetime DEFAULT NULL,

  `remark` varchar(255) DEFAULT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='tb_complete_task';






/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;



