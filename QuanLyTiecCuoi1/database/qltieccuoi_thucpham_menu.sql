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

-- Dump completed on 2020-01-04 22:44:11
