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
INSERT INTO `booking` VALUES ('0b1dcdf0-752f-4886-bbe5-584705ae3d4a',22,72,'1121','cbb02753-6c5a-4dfc-ba0f-6ac03346a76a','2019-02-05','2019-02-05',25,'2','Tiệc Cưới\r\n\rKhách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0,0000%',109500000.00),('0c41299a-8737-4e2d-afdf-c4f0ed25c426',24,71,'1121','e53c4569-5c71-401b-a829-6bf475577121','2019-03-16','2019-03-16',100,'1','Hội Nghị\r\n\rKhách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0,0000%',25000000.00),('2a348781-8db5-419a-a545-f3c4926da652',25,78,'1121','b16df22a-719a-4346-aabd-e20713cc46c8','2019-01-22','2019-01-22',45,'2','Tiệc Cưới\r\n\rKhách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0,0000%',165500000.00),('2ace7c17-b42c-41b4-a7b4-6a369e6b9975',22,74,'1121','92e8ef1e-aa6e-4665-9c8b-63b38dcfb727','2019-11-30','2019-11-30',10,'2','Tiệc Sinh Nhật\r\n\rKhách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0,0000%',44500000.00),('39b55390-6c90-4bb6-ab02-880b97bc9184',23,70,'1121','22275fa4-db73-4f9a-b7c5-09788eeb32c1','2019-10-23','2019-10-23',70,'1','Tiệc Cưới\r\n\rKhách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0,0000%',256500000.00),('5270107e-6d60-4330-9858-1c01330ce6fd',21,73,'1121','1543ace3-014e-480c-9393-916c2f6a4315','2019-09-29','2019-09-29',35,'1','Tiệc Cưới\r\n\rKhách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0,0000%',161250000.00),('5a16d94b-2a2d-4294-8707-e8400ff6403c',21,82,'1122','96be395e-bf1c-4662-9e27-379fe886db7f','2018-01-23','2018-01-23',41,'1','Tiệc Cưới\r\n\rKhách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0,0000%',165950000.00),('5bab2a19-4524-4661-a919-492c8fc75d80',23,68,'1121','9442181c-59ee-40ab-a849-0e61e11e45f8','2018-02-07','2018-02-07',20,'2','Tiệc Sinh Nhật\r\n\rKhách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0,0000%',66000000.00),('5eeca677-923b-4c93-9d14-61e5bc556c69',25,84,'1122','cff56451-ca89-485c-b9bf-57aa964d49f0','2018-03-25','2018-03-25',36,'1','Tiệc Cưới\r\n\rKhách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0,0000%',145900000.00),('71a3f8e9-e380-4283-a39f-73ce1b9b7c5e',22,69,'1121','d5eb252c-cd10-4981-8ff8-34af41eeabe1','2018-11-16','2018-11-16',50,'1','Tiệc Cưới\r\n\rKhách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0,0000%',194000000.00),('811e6e59-2d0b-40aa-8576-c47c05f53bc3',24,81,'1122','57f35f25-1ea6-42db-9b07-5e3b1fde65f2','2018-12-15','2018-12-15',50,'2','Tiệc Cưới\r\n\rKhách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0,0000%',234500000.00),('87b3bc16-ebbd-47d6-9d15-6abcb376007b',23,85,'1122','8fc3945a-b637-48b7-af5f-936156f25d0c','2020-01-02','2020-01-04',31,'1','Tiệc Cưới\r\n\rKhách thanh toán trễ: 2 ngày\r\nTiền cộng thêm : 0,0200%',121737000.00),('96208212-419c-4034-8689-06020fdeeb25',25,76,'1121','3fd015b1-b12e-4ea1-9890-0a51ab64238b','2018-04-21','2018-04-21',30,'2','Tiệc Cưới\r\n\rKhách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0,0000%',114000000.00),('a59f7944-f75e-48f7-ba09-c5e525277d38',21,86,'1122','d15ff332-f36a-48c3-895f-34c1d4daa2f8','2020-01-08',NULL,12,'2','Tiệc Sinh Nhật\r\n',NULL),('b030271e-9e53-41da-b094-752eead9759e',21,67,'1121','2e11f133-78ba-4a88-b499-1070add72ef2','2017-01-05','2017-01-04',60,'1','Tiệc cưới\r\n\rKhách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0,0000%',227500000.00),('b940efbd-bd67-47dc-85f1-5d8c05bab0c2',24,77,'1121','ee896567-8639-4443-b940-4c548c19f635','2017-11-03','2017-11-03',25,'1','Tiệc Cưới\r\n\rKhách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0,0000%',90750000.00),('bd683d9c-3d37-40de-93d3-3ad1384b436d',23,79,'1121','26748a60-8443-432f-a896-d383fd45fc13','2017-05-06','2017-05-06',45,'2','Tiệc Cưới\r\n\rKhách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0,0000%',182250000.00),('de2a3968-cdad-4185-8e1b-b1b8218caa22',23,80,'1121','6a52ef97-1f74-4066-b5af-4037b8af614b','2017-12-06','2017-12-06',41,'2','Tiệc Cưới\r\n\rKhách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0,0000%',117300000.00),('ef27531b-7418-4ce7-b57b-5f7cc6612832',23,75,'1121','5ce650aa-23c3-470d-819b-ac0011154ebd','2020-01-04','2020-01-04',35,'2','Tiệc Cưới\r\n\rKhách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0,0000%',134750000.00),('f569ee19-cbfb-432d-86d7-cccd380c305b',23,83,'1122','8d4e5cbb-931a-4c44-afc5-0d4660af1205','2019-05-23','2019-05-23',35,'2','Tiệc Cưới\r\n\rKhách thanh toán trễ: 0 ngày\r\nTiền cộng thêm : 0,0000%',139750000.00);
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
INSERT INTO `booking_dichvu` VALUES ('39b55390-6c90-4bb6-ab02-880b97bc9184',8),('5bab2a19-4524-4661-a919-492c8fc75d80',8),('71a3f8e9-e380-4283-a39f-73ce1b9b7c5e',8),('a59f7944-f75e-48f7-ba09-c5e525277d38',8),('b940efbd-bd67-47dc-85f1-5d8c05bab0c2',8),('bd683d9c-3d37-40de-93d3-3ad1384b436d',8),('0b1dcdf0-752f-4886-bbe5-584705ae3d4a',9),('2a348781-8db5-419a-a545-f3c4926da652',9),('2ace7c17-b42c-41b4-a7b4-6a369e6b9975',9),('5270107e-6d60-4330-9858-1c01330ce6fd',9),('5a16d94b-2a2d-4294-8707-e8400ff6403c',9),('5eeca677-923b-4c93-9d14-61e5bc556c69',9),('71a3f8e9-e380-4283-a39f-73ce1b9b7c5e',9),('87b3bc16-ebbd-47d6-9d15-6abcb376007b',9),('b030271e-9e53-41da-b094-752eead9759e',9),('bd683d9c-3d37-40de-93d3-3ad1384b436d',9),('ef27531b-7418-4ce7-b57b-5f7cc6612832',9),('f569ee19-cbfb-432d-86d7-cccd380c305b',9),('5eeca677-923b-4c93-9d14-61e5bc556c69',10),('71a3f8e9-e380-4283-a39f-73ce1b9b7c5e',10),('811e6e59-2d0b-40aa-8576-c47c05f53bc3',10),('96208212-419c-4034-8689-06020fdeeb25',10),('b030271e-9e53-41da-b094-752eead9759e',10),('bd683d9c-3d37-40de-93d3-3ad1384b436d',10),('de2a3968-cdad-4185-8e1b-b1b8218caa22',10),('f569ee19-cbfb-432d-86d7-cccd380c305b',10),('0b1dcdf0-752f-4886-bbe5-584705ae3d4a',11),('2a348781-8db5-419a-a545-f3c4926da652',11),('39b55390-6c90-4bb6-ab02-880b97bc9184',11),('5a16d94b-2a2d-4294-8707-e8400ff6403c',11),('71a3f8e9-e380-4283-a39f-73ce1b9b7c5e',11),('811e6e59-2d0b-40aa-8576-c47c05f53bc3',11),('96208212-419c-4034-8689-06020fdeeb25',11),('b940efbd-bd67-47dc-85f1-5d8c05bab0c2',11),('bd683d9c-3d37-40de-93d3-3ad1384b436d',11),('de2a3968-cdad-4185-8e1b-b1b8218caa22',11),('2ace7c17-b42c-41b4-a7b4-6a369e6b9975',12),('39b55390-6c90-4bb6-ab02-880b97bc9184',12),('5270107e-6d60-4330-9858-1c01330ce6fd',12),('a59f7944-f75e-48f7-ba09-c5e525277d38',12),('b030271e-9e53-41da-b094-752eead9759e',12),('bd683d9c-3d37-40de-93d3-3ad1384b436d',12),('ef27531b-7418-4ce7-b57b-5f7cc6612832',12),('f569ee19-cbfb-432d-86d7-cccd380c305b',12),('5a16d94b-2a2d-4294-8707-e8400ff6403c',13),('5eeca677-923b-4c93-9d14-61e5bc556c69',13),('811e6e59-2d0b-40aa-8576-c47c05f53bc3',13),('b030271e-9e53-41da-b094-752eead9759e',13),('bd683d9c-3d37-40de-93d3-3ad1384b436d',13);
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dichvu`
--

LOCK TABLES `dichvu` WRITE;
/*!40000 ALTER TABLE `dichvu` DISABLE KEYS */;
INSERT INTO `dichvu` VALUES (8,2000000.00,'','MC Nam'),(9,2500000.00,'','MC Nữ'),(10,5000000.00,'','Bàn VIP'),(11,5000000.00,'','Ban nhạc biểu diễn'),(12,2000000.00,'','Trang trí hoa tươi'),(13,2000000.00,'','Vũ đoàn khai mạc');
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
  `SDT` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`MaKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='			';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES ('1543ace3-014e-480c-9393-916c2f6a4315','Bành Văn Lân','0859278845','101 Hoà Hưng, phường 12, Quận 10'),('22275fa4-db73-4f9a-b7c5-09788eeb32c1','Nguyễn Thị Tươi','0859278865','165 Bạch Đằng, Quận Tân Bình'),('26748a60-8443-432f-a896-d383fd45fc13','Phạm Thị Xuân','0859278845','Số 113 115, Đường Thích Quảng Đức, Phường 4, Quận Phú Nhuận'),('2e11f133-78ba-4a88-b499-1070add72ef2','Trần Văn Vàng','0855927887','25A Lam Sơn, Quận Tân Bình'),('3fd015b1-b12e-4ea1-9890-0a51ab64238b','Nguyễn Thị Hồng Ngọc','0955155485','Số 865 Âu Cơ, Phường Tân Sơn Nhì, Quận Tân Phú'),('57f35f25-1ea6-42db-9b07-5e3b1fde65f2','Nguyễn Văn Hải','054584815','Số 62, Đường Bình Giã, Phường 13, Quận Tân Bình'),('5ce650aa-23c3-470d-819b-ac0011154ebd','Lê Văn Hà','085925455','19-21-23 Phạm Viết Chánh, phường Nguyễn Cư Trinh, Quận 1'),('6a52ef97-1f74-4066-b5af-4037b8af614b','Trần Thị Lan Ngọc','09659254545',' 115, Đường Thích Quảng Đức, Phường 4, Quận Phú Nhuận'),('8d4e5cbb-931a-4c44-afc5-0d4660af1205','Phạm Kiều An','0264554654','Số 2, Đường Bình Giã, Phường 13, Quận Tân Bình'),('8fc3945a-b637-48b7-af5f-936156f25d0c','Lê Văn Nam','0558489489','14A Bis Đặng Văn Ngữ, phường 10, Quận Phú Nhuận'),('92e8ef1e-aa6e-4665-9c8b-63b38dcfb727','Nguyễn Văn Ngãi','0859254854','10A Hoàng Hoa Thám, phường 7, Quận Bình Thạnh'),('9442181c-59ee-40ab-a849-0e61e11e45f8','Nguyễn Văn Khôi','0859278845','48A D2, Quận Bình Thạnh'),('96be395e-bf1c-4662-9e27-379fe886db7f','Phạm Thị Kiều','0958785515','Số 63, Đường Bình Giã, Phường 13, Quận Tân Bình'),('b16df22a-719a-4346-aabd-e20713cc46c8','Nguyễn Thị Bích Lan ','0952154455','88 Phạm Viết Chánh, phường Nguyễn Cư Trinh, Quận 1'),('cbb02753-6c5a-4dfc-ba0f-6ac03346a76a','Nguyễn Văn Thoại ','0958875442','129 - 131 Đường Số 3, Cư xá Đô Thành, Quận 3'),('cff56451-ca89-485c-b9bf-57aa964d49f0','Nguyễn Thị Nở','05223516545','Số 22, Đường Bình Giã, Phường 13, Quận Tân Bình'),('d15ff332-f36a-48c3-895f-34c1d4daa2f8','Phạm Thị Ngọc','06554555','475A Điện Biên Phủ, phường 25, Quận Bình Thạnh'),('d5eb252c-cd10-4981-8ff8-34af41eeabe1','Bình Văn Hỡi','0859245453','191 Nguyễn Hồng Đào, Quận Tân Bình'),('e53c4569-5c71-401b-a829-6bf475577121','Nguyễn Trần Lê Trúc Anh','0859278874','77 Trần Thiện Chánh, Quận 10'),('ee896567-8639-4443-b940-4c548c19f635','Lê Văn Lợi ','0596464645','19-21-23 Phạm Viết Chánh, phường Nguyễn Cư Trinh, Quận 1');
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
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (67,'2020-01-04'),(68,'2020-01-04'),(69,'2020-01-04'),(70,'2020-01-04'),(71,'2020-01-04'),(72,'2020-01-04'),(73,'2020-01-04'),(74,'2020-01-04'),(75,'2020-01-04'),(76,'2020-01-04'),(77,'2020-01-04'),(78,'2020-01-04'),(79,'2020-01-04'),(80,'2020-01-04'),(81,'2020-01-04'),(82,'2020-01-04'),(83,'2020-01-04'),(84,'2020-01-04'),(85,'2020-01-04'),(86,'2020-01-04');
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
INSERT INTO `nhanvien` VALUES ('1121','Nhân Viên','Tuệ','tue123','123456'),('1122','Nhân Viên','Thành','thanh123','123456'),('1123','Admin','Admin','admin','123456');
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanh`
--

LOCK TABLES `sanh` WRITE;
/*!40000 ALTER TABLE `sanh` DISABLE KEYS */;
INSERT INTO `sanh` VALUES (21,'Diamond',15000000.00,'A','Diện tích: 576 m2 \nLớp học: 400 \nBàn chữ U: 130\nBàn tròn: 450'),(22,'Royal',12000000.00,'B','Diện tích: 400 m2 \nLớp học: 200 \nBàn chữ U: 240 \nBàn tròn: 200'),(23,'Galaxy',13000000.00,'C','Diện tích: 576 m2 \nLớp học: 400 \nBàn chữ U: 130 \nBàn tròn: 450'),(24,'Classic',10000000.00,'D','Diện tích: 400 m2 \nLớp học: 200 \nBàn chữ U: 100 \nBàn tròn: 240'),(25,'Gold',14000000.00,'E','Diện tích: 450 m2 \nLớp học: 200 \nBàn chữ U: 100 \nBàn tròn: 240');
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
INSERT INTO `thucpham_menu` VALUES (12,67),(14,67),(18,67),(20,67),(21,67),(26,67),(28,67),(30,67),(11,68),(13,68),(18,68),(19,68),(25,68),(28,68),(31,68),(32,68),(11,69),(13,69),(18,69),(20,69),(22,69),(25,69),(28,69),(29,69),(32,69),(11,70),(13,70),(18,70),(19,70),(22,70),(26,70),(28,70),(29,70),(28,71),(14,72),(15,72),(19,72),(20,72),(21,72),(26,72),(28,72),(30,72),(31,72),(32,72),(10,73),(15,73),(18,73),(19,73),(20,73),(22,73),(24,73),(29,73),(31,73),(11,74),(16,74),(21,74),(22,74),(23,74),(28,74),(29,74),(32,74),(14,75),(15,75),(19,75),(20,75),(21,75),(24,75),(28,75),(30,75),(12,76),(14,76),(18,76),(20,76),(21,76),(25,76),(28,76),(32,76),(10,77),(11,77),(19,77),(21,77),(22,77),(28,77),(29,77),(12,78),(13,78),(18,78),(20,78),(21,78),(26,78),(29,78),(32,78),(12,79),(14,79),(19,79),(20,79),(22,79),(25,79),(28,79),(30,79),(32,79),(13,80),(18,80),(21,80),(25,80),(28,80),(32,80),(13,81),(15,81),(18,81),(20,81),(21,81),(24,81),(27,81),(28,81),(29,81),(30,81),(31,81),(15,82),(17,82),(19,82),(20,82),(21,82),(26,82),(30,82),(31,82),(32,82),(14,83),(15,83),(19,83),(21,83),(22,83),(27,83),(28,83),(30,83),(15,84),(19,84),(20,84),(22,84),(24,84),(26,84),(29,84),(30,84),(12,85),(14,85),(19,85),(20,85),(21,85),(25,85),(28,85),(29,85),(32,85),(10,86),(11,86),(19,86),(21,86),(24,86),(30,86);
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

-- Dump completed on 2020-01-05  0:31:06
