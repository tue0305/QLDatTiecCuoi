-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: qltieccuoi
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `MaBooking` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaSanh` int(5) NOT NULL,
  `MaMenu` int(5) NOT NULL,
  `MaDV` int(5) NOT NULL,
  `MaNV` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaKH` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NgayDat` date DEFAULT NULL,
  `NgayThanhToan` date DEFAULT NULL,
  `SoBan` int(100) DEFAULT NULL,
  `Ca` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `GhiChu` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `Price` decimal(13,2) DEFAULT NULL,
  PRIMARY KEY (`MaBooking`),
  KEY `fk_booking_nhanvien` (`MaNV`),
  KEY `fk_booking_khachhang` (`MaKH`),
  KEY `fk_booking_sanh_idx` (`MaSanh`),
  KEY `fk_booking_menu_idx` (`MaMenu`),
  KEY `fk_booking_dichvu_idx` (`MaDV`),
  CONSTRAINT `fk_booking_dichvu` FOREIGN KEY (`MaDV`) REFERENCES `dichvu` (`MaDV`),
  CONSTRAINT `fk_booking_khachhang` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`),
  CONSTRAINT `fk_booking_menu` FOREIGN KEY (`MaMenu`) REFERENCES `menu` (`MaMenu`),
  CONSTRAINT `fk_booking_nhanvien` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`),
  CONSTRAINT `fk_booking_sanh` FOREIGN KEY (`MaSanh`) REFERENCES `sanh` (`MaSanh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES ('DSADA44444',5,44,4,'fdsfdsf568','23156QQQQ','2019-06-08',NULL,6,'1','',9900000.00),('DSAE123123',5,44,4,'fdsfdsf568','123DSAE127','2019-06-01','2019-07-01',9,'1','dsadsa',100000000.00);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dichvu`
--

DROP TABLE IF EXISTS `dichvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dichvu` (
  `MaDV` int(5) NOT NULL AUTO_INCREMENT,
  `TenDV` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Gia` decimal(11,2) DEFAULT NULL,
  `LoaiDV` enum('Ca sĩ','MC','Bánh kem') CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `GhiChu` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  PRIMARY KEY (`MaDV`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dichvu`
--

LOCK TABLES `dichvu` WRITE;
/*!40000 ALTER TABLE `dichvu` DISABLE KEYS */;
INSERT INTO `dichvu` VALUES (4,'Sơn Tùng',1000000.00,'Ca sĩ','32123');
/*!40000 ALTER TABLE `dichvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `MaKH` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TenKH` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SDT` int(11) NOT NULL,
  PRIMARY KEY (`MaKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='			';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES ('123DSAE127','Nguyễn Văn A',6545666),('123QƯERWR','Lý Sơn Phi',8888888),('23156QQQQ','Long',6666666);
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `MaMenu` int(5) NOT NULL AUTO_INCREMENT,
  `Price` decimal(11,2) NOT NULL,
  `NgayTao` date DEFAULT NULL,
  `TenMenu` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`MaMenu`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (44,30000.00,'2019-04-22','sad');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `MaNV` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ChucVu` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TenNV` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `UserName` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Password` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MaNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES ('fdsfdsf568','Admin','Nguyễn Văn A','tue123','123456');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanh`
--

DROP TABLE IF EXISTS `sanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanh` (
  `MaSanh` int(5) NOT NULL AUTO_INCREMENT,
  `TenSanh` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Gia` decimal(11,2) NOT NULL,
  `LoaiSanh` enum('A','B','C','D','E') CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `GhiChu` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  PRIMARY KEY (`MaSanh`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanh`
--

LOCK TABLES `sanh` WRITE;
/*!40000 ALTER TABLE `sanh` DISABLE KEYS */;
INSERT INTO `sanh` VALUES (5,'L',30000.00,'B','12323'),(9,'aaaa',5000000.00,'A','1111'),(10,'xxx',555555.00,'A','dsads'),(11,'xxxa',555555.00,'A','dsads');
/*!40000 ALTER TABLE `sanh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thucpham`
--

DROP TABLE IF EXISTS `thucpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thucpham` (
  `MaTP` int(10) NOT NULL AUTO_INCREMENT,
  `TenTP` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Price` decimal(11,2) NOT NULL,
  `GhiChu` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `LoaiTP` enum('Khai vị','Món chính','Tráng miệng','Nước uống') CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MaTP`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thucpham`
--

LOCK TABLES `thucpham` WRITE;
/*!40000 ALTER TABLE `thucpham` DISABLE KEYS */;
INSERT INTO `thucpham` VALUES (7,'bún thịt nướng',60000.00,'dsads','Nước uống');
/*!40000 ALTER TABLE `thucpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thucpham_menu`
--

DROP TABLE IF EXISTS `thucpham_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thucpham_menu` (
  `MaTP` int(10) NOT NULL,
  `MaMenu` int(5) NOT NULL,
  `SoLuong` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MaTP`,`MaMenu`),
  KEY `fk_thucpham_menu_idx` (`MaMenu`),
  CONSTRAINT `fk_menu_thucpham` FOREIGN KEY (`MaTP`) REFERENCES `thucpham` (`MaTP`),
  CONSTRAINT `fk_thucpham_menu` FOREIGN KEY (`MaMenu`) REFERENCES `menu` (`MaMenu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thucpham_menu`
--

LOCK TABLES `thucpham_menu` WRITE;
/*!40000 ALTER TABLE `thucpham_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `thucpham_menu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-08 16:24:51
