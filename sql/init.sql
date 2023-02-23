/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.7.22 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE
DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE
`test`;

/*Table structure for table `pf_test_t` */

DROP TABLE IF EXISTS `pf_test`;

CREATE TABLE `pf_test`
(
    `id`           char(32)     NOT NULL COMMENT '主键ID',
    `create_time`  datetime(6) DEFAULT NULL COMMENT '创建时间',
    `age`          int(10) DEFAULT NULL COMMENT '年龄',
    `birthday`     date                  DEFAULT NULL COMMENT '生日',
    `name`         varchar(255) NOT NULL DEFAULT '' COMMENT '名字',
    `sex`          varchar(10)           DEFAULT '男' COMMENT '性别',
    `department`   varchar(100)          DEFAULT '技术部' COMMENT '部门',
    `home_address` varchar(255) NOT NULL DEFAULT '' COMMENT '家庭住址',
    `event_status` varchar(64)           DEFAULT 'EVENT_UNPUBLISHED' COMMENT '事件状态(-2事件未发布 -1关闭事件 0办理中 1事件结束)',
    `is_marry`     bit(1)                DEFAULT b'0' COMMENT '是否结婚(1 是 0 否)',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `pf_test_t` */

insert into `pf_test`(`id`, `create_time`, `age`, `birthday`, `name`, `sex`, `department`, `home_address`,
                      `event_status`, `is_marry`)
values ('402881876b1b10cf016b1b137a070030', '2019-06-03 10:03:09.703000', 20, '2019-06-03', '李三', '男', '信息部', '',
        'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b137bbe0031', '2019-06-03 10:03:10.142000', 23, '2019-06-03', '张思', '男', '信息部', '',
        'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b137c8a0032', '2019-06-03 10:03:10.346000', 19, '2019-06-03', '牛莉', '女', '技术部', '',
        'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b137d6b0033', '2019-06-03 10:03:10.571000', 33, '2019-06-03', '许绍洋', '男', '技术部',
        '', 'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b1384930034', '2019-06-03 10:03:12.403000', 23, '2019-06-03', '林志颖', '男', '财务部',
        '', 'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b1385740035', '2019-06-03 10:03:12.628000', 34, '2019-06-03', '林丹', '女', '技术部', '',
        'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b1386470036', '2019-06-03 10:03:12.839000', 23, '2019-06-03', '姚明', '男', '技术部', '',
        'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b1386ff0037', '2019-06-03 10:03:13.023000', 32, '2019-06-03', '库里', '男', '信息部', '',
        'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b1389080038', '2019-06-03 10:03:13.544000', 55, '2019-06-03', '斯蒂芬', '男', '技术部',
        '', 'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b1389e00039', '2019-06-03 10:03:13.760000', 45, '2019-06-03', '詹姆斯', '男', '信息部',
        '', 'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b138acd003a', '2019-06-03 10:03:13.997000', 34, '2019-06-03', '科比', '男', '技术部', '',
        'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b138ba2003b', '2019-06-03 10:03:14.210000', 32, '2019-06-03', '赵薇', '女', '财务部', '',
        'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b13a9f4003c', '2019-06-03 10:03:21.972000', 38, '2019-06-03', '黄晓明', '男', '技术部',
        '', 'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b13aad2003d', '2019-06-03 10:03:22.194000', 43, '2019-06-03', '刘亦菲', '女', '信息部',
        '', 'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b13adfd003e', '2019-06-03 10:03:23.005000', 38, '2019-06-03', '鹿晗', '男', '技术部', '',
        'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b13af07003f', '2019-06-03 10:03:23.271000', 32, '2019-06-03', '吴亦凡', '男', '财务部',
        '', 'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b13b0c40040', '2019-06-03 10:03:23.716000', 24, '2019-06-03', '黄磊', '男', '财务部', '',
        'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b13b1a80041', '2019-06-03 10:03:23.944000', 38, '2019-06-03', '海清', '女', '技术部', '',
        'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b13b46b0042', '2019-06-03 10:03:24.651000', 20, '2019-06-03', '赵文卓', '男', '技术部',
        '', 'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b13b5460043', '2019-06-03 10:03:24.870000', 23, '2019-06-03', '李连杰', '男', '技术部',
        '', 'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b13b6570044', '2019-06-03 10:03:25.143000', 39, '2019-06-03', '乔丹', '男', '技术部', '',
        'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b13b7380045', '2019-06-03 10:03:25.368000', 43, '2019-06-03', '艾佛森', '女', '技术部',
        '', 'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b13b8170046', '2019-06-03 10:03:25.591000', 58, '2019-06-03', '马龙', '男', '信息部', '',
        'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b13b9120047', '2019-06-03 10:03:25.842000', 44, '2019-06-03', '张继科', '男', '技术部',
        '', 'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b13bc3d0048', '2019-06-03 10:03:26.653000', 55, '2019-06-03', '张怡宁', '女', '财务部',
        '', 'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b13bd540049', '2019-06-03 10:03:26.932000', 22, '2019-06-03', '王楠', '女', '技术部', '',
        'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b13be2c004a', '2019-06-03 10:03:27.148000', 51, '2019-06-03', '李毅', '男', '技术部', '',
        'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b13fc84004b', '2019-06-03 10:03:43.108000', 34, '2019-06-03', '梅西', '男', '技术部', '',
        'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b13fd43004c', '2019-06-03 10:03:43.299000', 63, '2019-06-03', '姆巴佩', '男', '信息部',
        '', 'EVENT_UNPUBLISHED', '\0'),
       ('402881876b1b10cf016b1b13fdf1004d', '2019-06-03 10:03:43.473000', 18, '2019-06-03', '郑秀文', '女', '技术部',
        '', 'EVENT_UNPUBLISHED', '\0');

CREATE TABLE `pf_user_t`
(
    `id`         varchar(64) NOT NULL,
    `created_dt` DATETIME COMMENT '创建时间',
    `name`       VARCHAR(255) COMMENT '名称',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
