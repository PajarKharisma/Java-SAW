/*
SQLyog Professional v12.5.1 (64 bit)
MySQL - 10.1.25-MariaDB : Database - db_saw
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_saw` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_saw`;

/*Table structure for table `tbl_kriteria` */

DROP TABLE IF EXISTS `tbl_kriteria`;

CREATE TABLE `tbl_kriteria` (
  `id_kriteria` varchar(5) NOT NULL,
  `nama_kriteria` varchar(30) DEFAULT NULL,
  `bobot` decimal(5,0) DEFAULT NULL,
  `flag` enum('benefit','cost') DEFAULT NULL,
  PRIMARY KEY (`id_kriteria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_kriteria` */

insert  into `tbl_kriteria`(`id_kriteria`,`nama_kriteria`,`bobot`,`flag`) values 
('C1','Tes Skill',40,'benefit'),
('C2','Komunikasi',20,'benefit'),
('C3','Penampilan',20,'benefit'),
('C4','Kepribadian',15,'benefit'),
('C5','Pengalaman Kerja',5,'benefit');

/*Table structure for table `tbl_pelamar` */

DROP TABLE IF EXISTS `tbl_pelamar`;

CREATE TABLE `tbl_pelamar` (
  `id_pelamar` varchar(5) NOT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `telp` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_pelamar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_pelamar` */

insert  into `tbl_pelamar`(`id_pelamar`,`nama`,`alamat`,`telp`) values 
('A1','Adit','Jalan','08xx'),
('A2','Bowo','Jalan','08xx'),
('A3','Agung','Jalan','08xx'),
('A4','Julian','Jalan','08xx'),
('A5','Fauzan','Jalan','08xx'),
('A6','Ari','Jalan','08xx'),
('A7','Heri','Jalan','08xx'),
('A8','Indra','Jalan','08xx');

/*Table structure for table `tbl_pengguna` */

DROP TABLE IF EXISTS `tbl_pengguna`;

CREATE TABLE `tbl_pengguna` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_pengguna` */

insert  into `tbl_pengguna`(`id`,`username`,`password`) values 
(3,'admin','202cb962ac59075b964b07152d234b70');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
