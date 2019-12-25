CREATE DATABASE  IF NOT EXISTS `qltieccuoi` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `qltieccuoi`;
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
  `MaBooking` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaSanh` int(5) NOT NULL,
  `MaMenu` int(5) NOT NULL,
  `MaNV` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `MaKH` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NgayDat` date DEFAULT NULL,
  `NgayThanhToan` date DEFAULT NULL,
  `SoBan` int(100) DEFAULT NULL,
  `Ca` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `GhiChu` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `Price` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`MaBooking`),
  KEY `fk_booking_nhanvien` (`MaNV`),
  KEY `fk_booking_khachhang` (`MaKH`),
  KEY `fk_booking_sanh_idx` (`MaSanh`),
  KEY `fk_booking_menu_idx` (`MaMenu`),
  CONSTRAINT `fk_booking_khachhang` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`),
  CONSTRAINT `fk_booking_menu` FOREIGN KEY (`MaMenu`) REFERENCES `menu` (`MaMenu`),
  CONSTRAINT `fk_booking_sanh` FOREIGN KEY (`MaSanh`) REFERENCES `sanh` (`MaSanh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES ('2b1aa8cc-35c4-4f4c-a19c-163f835cd495',18,51,'fdsfdsf568','3dcd2436-0f90-4995-8307-950978f9297d','2020-02-02','2019-12-25',30,'1','Khách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0.0000%',250000000.00),('3d90b89f-5e77-4a84-a836-5d2357cef513',5,48,'fdsfdsf568','490eed1e-2c6b-4a54-9739-cf151287bcf0','2019-12-27','2019-12-25',30,'1','Khách thanh toán trễ: -1 ngày\r\nTiền cộng thêm : -0.0100%',12285712.00),('4caab683-6c26-4abf-9b68-9d1d913f9964',17,50,'ưewqee99','47fba680-51a8-4437-8535-4fa3c34a1ca0','2020-07-02','2019-12-25',30,'2','Khách thanh toán trễ: -189 ngày\r\nTiền cộng thêm : -1.8900%',-179898664.00),('53eab04b-2064-4198-b22c-69465e59a158',5,49,'fdsfdsf568','34e26d8f-0085-4f96-a940-29699e6a7ded','2020-01-02','2019-12-25',40,'1','Khách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0.0000%',114290927.00),('DSADA44444',5,44,'ưewqee99','23156QQQQ','2019-12-12','2019-12-20',60,'1','Khách thanh toán trễ: 8 ngày\r\nTiền cộng thêm : 0.0800%',19594611.00),('DSAE123123',5,44,'fdsfdsf568','123DSAE127','2019-06-01','2019-07-01',9,'1','dsadsa',100000000.00),('ecf44c94-9557-40ba-a968-be3bc01b9130',5,47,'fdsfdsf568','b3112a57-87e7-4413-b5f1-4ab13065976a','2019-12-26','2019-12-25',20,'2','Khách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0.0000%',4530018.00);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_dichvu`
--

DROP TABLE IF EXISTS `booking_dichvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_dichvu` (
  `MaBooking` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaDV` int(5) NOT NULL,
  PRIMARY KEY (`MaBooking`,`MaDV`),
  KEY `fk_booking_dichvu_idx` (`MaDV`),
  CONSTRAINT `fk_booking_dichvu` FOREIGN KEY (`MaDV`) REFERENCES `dichvu` (`MaDV`),
  CONSTRAINT `fk_dichvu_booking` FOREIGN KEY (`MaBooking`) REFERENCES `booking` (`MaBooking`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_dichvu`
--

LOCK TABLES `booking_dichvu` WRITE;
/*!40000 ALTER TABLE `booking_dichvu` DISABLE KEYS */;
INSERT INTO `booking_dichvu` VALUES ('3d90b89f-5e77-4a84-a836-5d2357cef513',4),('53eab04b-2064-4198-b22c-69465e59a158',4),('DSADA44444',4),('ecf44c94-9557-40ba-a968-be3bc01b9130',4),('3d90b89f-5e77-4a84-a836-5d2357cef513',5),('53eab04b-2064-4198-b22c-69465e59a158',5),('DSADA44444',5),('ecf44c94-9557-40ba-a968-be3bc01b9130',5),('3d90b89f-5e77-4a84-a836-5d2357cef513',6),('53eab04b-2064-4198-b22c-69465e59a158',6),('DSADA44444',6);
/*!40000 ALTER TABLE `booking_dichvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dichvu`
--

DROP TABLE IF EXISTS `dichvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dichvu` (
  `MaDV` int(5) NOT NULL AUTO_INCREMENT,
  `Gia` decimal(11,2) DEFAULT NULL,
  `GhiChu` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `LoaiDV` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`MaDV`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dichvu`
--

LOCK TABLES `dichvu` WRITE;
/*!40000 ALTER TABLE `dichvu` DISABLE KEYS */;
INSERT INTO `dichvu` VALUES (4,1000000.00,'32123','ca si'),(5,1100006.00,NULL,'Bánh kem'),(6,4546456.11,NULL,'MC');
/*!40000 ALTER TABLE `dichvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `MaKH` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TenKH` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SDT` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`MaKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='			';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES ('123DSAE127','Nguyễn Văn A','6545666',NULL),('123QƯERWR','Lý Sơn Phi','8888888',NULL),('23156QQQQ','Long','6666666',NULL),('34e26d8f-0085-4f96-a940-29699e6a7ded','Nguyễn văn quân','09605467573',''),('3dcd2436-0f90-4995-8307-950978f9297d','Nguyễn Thị Mợt','01472583699',''),('47fba680-51a8-4437-8535-4fa3c34a1ca0','Nguyễn văn tuấn','06621646765',''),('490eed1e-2c6b-4a54-9739-cf151287bcf0','Nguyễn Văn B','06216456464',''),('b3112a57-87e7-4413-b5f1-4ab13065976a','Nguyễn Văn Toàn','0902062074','');
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
  `NgayTao` date DEFAULT NULL,
  PRIMARY KEY (`MaMenu`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (44,'2019-04-22'),(47,'2019-12-25'),(48,'2019-12-25'),(49,'2019-12-25'),(50,'2019-12-25'),(51,'2019-12-25');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `MaNV` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
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
INSERT INTO `nhanvien` VALUES ('fdsfdsf568','Admin','Nguyễn Văn A','tue123','123456'),('ưewqee99','Staff','Nguyễn Thị B','thanh123','123456');
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
  `Gia` decimal(15,2) NOT NULL,
  `LoaiSanh` enum('A','B','C','D','E') CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `GhiChu` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  PRIMARY KEY (`MaSanh`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanh`
--

LOCK TABLES `sanh` WRITE;
/*!40000 ALTER TABLE `sanh` DISABLE KEYS */;
INSERT INTO `sanh` VALUES (5,'Bronze',100000000.00,'A','20 bàn'),(15,'Silver',150000000.00,'B','30 bàn'),(16,'Gold',175000000.00,'C','45 bàn'),(17,'Plentium',200000000.00,'D','60 bàn'),(18,'Diamond',250000000.00,'E','80 bàn');
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thucpham`
--

LOCK TABLES `thucpham` WRITE;
/*!40000 ALTER TABLE `thucpham` DISABLE KEYS */;
INSERT INTO `thucpham` VALUES (7,'bún thịt nướng',60000.00,'dsads','Nước uống'),(8,'Nho',60000.61,NULL,'Tráng miệng'),(9,'Bánh mì',71111.00,NULL,'Khai vị');
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
INSERT INTO `thucpham_menu` VALUES (7,44),(8,44),(9,44),(7,47),(8,47),(7,48),(8,48),(9,48),(7,49),(8,49),(9,49),(9,50);
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

-- Dump completed on 2019-12-25 17:08:56
