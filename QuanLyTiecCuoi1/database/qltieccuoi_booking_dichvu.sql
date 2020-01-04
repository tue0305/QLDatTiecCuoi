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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-04 22:44:11
