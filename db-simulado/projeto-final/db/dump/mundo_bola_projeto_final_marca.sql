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
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marca` (
  `marca_id` varchar(40) COLLATE utf8mb4_general_ci NOT NULL,
  `nome` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `imagem_url` text COLLATE utf8mb4_general_ci,
  `data_criacao` datetime NOT NULL,
  `data_alteracao` datetime DEFAULT NULL,
  `criador_usuario_cpf` varchar(14) COLLATE utf8mb4_general_ci NOT NULL,
  `alterador_usuario_cpf` varchar(14) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`marca_id`),
  KEY `nome` (`nome`),
  KEY `criador_usuario_cpf` (`criador_usuario_cpf`),
  KEY `alterador_usuario_cpf` (`alterador_usuario_cpf`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES ('4946112a-b895-4c8f-b5c1-1c8dc0b65dee','Adidas','https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Adidas_logo.png/1200px-Adidas_logo.png','2023-12-05 00:00:00',NULL,'29768006005',NULL),('849324c0-2d2d-4097-87f4-68dae63b2f5b','Nike','https://logospng.org/wp-content/uploads/nike.jpg','2023-12-05 00:00:00',NULL,'29768006005',NULL),('8bc9a223-3a8f-4523-aba8-dc1d9811523b','Penalty','https://seeklogo.com/images/P/penalty-logo-A248974510-seeklogo.com.png','2023-12-05 00:00:00',NULL,'71292479086',NULL);
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-06  8:42:28
