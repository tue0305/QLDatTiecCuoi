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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-04 22:44:11
