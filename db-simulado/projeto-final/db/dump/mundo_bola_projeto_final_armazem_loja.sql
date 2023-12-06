-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: mundo_bola_projeto_final
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `armazem_loja`
--

DROP TABLE IF EXISTS `armazem_loja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `armazem_loja` (
  `loja_id` varchar(40) COLLATE utf8mb4_general_ci NOT NULL,
  `bola_id` varchar(40) COLLATE utf8mb4_general_ci NOT NULL,
  `quantidade_bola` int NOT NULL,
  PRIMARY KEY (`loja_id`,`bola_id`),
  KEY `bola_id` (`bola_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `armazem_loja`
--

LOCK TABLES `armazem_loja` WRITE;
/*!40000 ALTER TABLE `armazem_loja` DISABLE KEYS */;
INSERT INTO `armazem_loja` VALUES ('3c7f85ad-0314-4f7c-977c-9b16e19782c8','a4216a2e-a33a-4857-b47d-1d17b921c1a6',6),('3c7f85ad-0314-4f7c-977c-9b16e19782c8','da6d14aa-9125-4f5a-871e-bbca635c9255',4),('3c7f85ad-0314-4f7c-977c-9b16e19782c8','a27a1d9e-07b3-4ed5-bee0-1d66ee9a7054',0),('3c7f85ad-0314-4f7c-977c-9b16e19782c8','f6c7214f-5041-4096-91f2-26db7d4341df',20),('3c7f85ad-0314-4f7c-977c-9b16e19782c8','0309d77c-c7c1-4eb7-b2ba-457b7eafade4',3),('3c7f85ad-0314-4f7c-977c-9b16e19782c8','e859e886-31dc-4fee-8d4f-01fbd565cabd',8);
/*!40000 ALTER TABLE `armazem_loja` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-06  8:42:26
