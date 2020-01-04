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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-04 22:44:11
