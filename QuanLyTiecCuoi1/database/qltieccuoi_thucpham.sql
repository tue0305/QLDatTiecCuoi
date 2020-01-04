-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: qltieccuoi
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thucpham`
--

LOCK TABLES `thucpham` WRITE;
/*!40000 ALTER TABLE `thucpham` DISABLE KEYS */;
INSERT INTO `thucpham` VALUES (10,'Súp hải sản',350000.00,'','Khai vị'),(11,'Bánh tart Tôm',0.00,'Tặng ','Khai vị'),(12,'Bánh tart gà',0.00,'Tặng\n','Khai vị'),(13,'Gỏi củ hủ dừa',450000.00,'','Khai vị'),(14,'Mực chiên giòn',450000.00,'','Khai vị'),(15,'Salad tổng hợp',0.00,'Tặng\n','Khai vị'),(16,'Xúc xích trân châu',200000.00,'','Khai vị'),(17,'Canh bào ngư',450000.00,'','Khai vị'),(18,'Gà phi lê tùng lộ',700000.00,'Chỉ có vào thứ 7 và chủ nhật','Món chính'),(19,'Bò Úc tiêu đen',700000.00,'Chỉ có vào thứ 7 và chủ nhật','Món chính'),(20,'Tôm càng tương đen',700000.00,'Càng xanh','Món chính'),(21,'Thăn bò sốt tiêu đen',700000.00,'Bò New Zealand','Món chính'),(22,'Cơm chiên kiểu Indonesia',700000.00,'','Món chính'),(23,'Bò áp chảo',700000.00,'Bò Úc','Món chính'),(24,'Bánh choux cream',300000.00,'','Tráng miệng'),(25,'Chè nhãn nhục hạt sen',300000.00,'','Tráng miệng'),(26,'Rau câu hạt chia',300000.00,'','Tráng miệng'),(27,'Chè thái lan',300000.00,'','Tráng miệng'),(28,'Nước suối',150000.00,'Thùng','Nước uống'),(29,'Bia Heineken',350000.00,'Thùng	','Nước uống'),(30,'Bia 333',350000.00,'Thùng	','Nước uống'),(31,'Coca',250000.00,'Thùng','Nước uống'),(32,'Trà đá',0.00,'Miễn phí','Nước uống');
/*!40000 ALTER TABLE `thucpham` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-04 22:44:11
