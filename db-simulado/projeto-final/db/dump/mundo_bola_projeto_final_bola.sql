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
-- Table structure for table `bola`
--

DROP TABLE IF EXISTS `bola`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bola` (
  `bola_id` varchar(40) COLLATE utf8mb4_general_ci NOT NULL,
  `nome` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `preco` decimal(6,2) NOT NULL,
  `marca_id` varchar(36) COLLATE utf8mb4_general_ci NOT NULL,
  `descricao` text COLLATE utf8mb4_general_ci,
  `imagem_url` text COLLATE utf8mb4_general_ci,
  `data_criacao` datetime NOT NULL,
  `data_alteracao` datetime DEFAULT NULL,
  `criador_usuario_cpf` varchar(14) COLLATE utf8mb4_general_ci NOT NULL,
  `alterador_usuario_cpf` varchar(14) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`bola_id`),
  KEY `nome` (`nome`),
  KEY `marca_id` (`marca_id`),
  KEY `criador_usuario_cpf` (`criador_usuario_cpf`),
  KEY `alterador_usuario_cpf` (`alterador_usuario_cpf`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bola`
--

LOCK TABLES `bola` WRITE;
/*!40000 ALTER TABLE `bola` DISABLE KEYS */;
INSERT INTO `bola` VALUES ('a4216a2e-a33a-4857-b47d-1d17b921c1a6','Total90',99.90,'849324c0-2d2d-4097-87f4-68dae63b2f5b','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc congue. ','https://assets-mantosdofutebol.sfo2.digitaloceanspaces.com/wp-content/uploads/2017/03/bola-PL-Nike-Total-90-Aerrow-2004-2005.jpg','2023-12-05 00:00:00',NULL,'29768006005',NULL),('da6d14aa-9125-4f5a-871e-bbca635c9255','Jabulani',1090.90,'4946112a-b895-4c8f-b5c1-1c8dc0b65dee','Lorem ipsum dolor sit amet. ','https://s2.glbimg.com/7dzisN-U42ChaQeJA8HPH9F8L4sp0re7dXrg1kCDpXpIoz-HdGixxa_8qOZvMp3w/s.glbimg.com/es/ge/f/original/2012/08/12/jabu.jpg','2023-12-05 00:00:00',NULL,'29768006005',NULL),('a27a1d9e-07b3-4ed5-bee0-1d66ee9a7054','Penalty Lider Campo',299.90,'8bc9a223-3a8f-4523-aba8-dc1d9811523b',NULL,'https://d2p7wtszppk2p4.cloudfront.net/Custom/Content/Products/51/33/51330_bola-campo-lider-xxi-bc-lj-pt-t-u-pr-7852-5213031710_l4_637570278602232766.jpg','2023-12-05 00:00:00',NULL,'29768006005',NULL),('f6c7214f-5041-4096-91f2-26db7d4341df','Bola Society Penalty Se7e R2 Ko X',249.90,'8bc9a223-3a8f-4523-aba8-dc1d9811523b','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer imperdiet tincidunt tortor non condimentum. Proin egestas accumsan nibh a iaculis. Suspendisse non leo erat. Sed lobortis ligula id tellus pretium. ','https://images-americanas.b2w.io/produtos/7332761295/imagens/bola-de-futebol-society-penalty-se7e-r2-ko-x-pt-az-e-pt-am/7332761367_3_large.jpg','2023-12-05 00:00:00',NULL,'29768006005',NULL),('0309d77c-c7c1-4eb7-b2ba-457b7eafade4','Bola Nike Premier League Academy',199.90,'849324c0-2d2d-4097-87f4-68dae63b2f5b','A Bola de Futebol Premier League Academy tem sulcos inovadores projetados para um giro consistente quando a bola está no ar. ','https://imgnike-a.akamaihd.net/768x768/0243935B.jpg','2023-12-05 00:00:00',NULL,'29768006005',NULL),('e859e886-31dc-4fee-8d4f-01fbd565cabd','Bola Al Rihla Pro',999.90,'4946112a-b895-4c8f-b5c1-1c8dc0b65dee','\"Al Rihla\" significa \"A Jornada\", e a bola é só o começo. O resto da sua jornada no futebol ainda vai ser escrito. Com estrutura sem costuras, esta bola oficial da Copa do Mundo FIFA Catar 2022™ adidas Al Rihla Pro representa um novo conceito de alta precisão. ','https://assets.adidas.com/images/h_840,f_auto,q_auto:sensitive,fl_lossy,c_fill,g_auto/aa6f6d655b3d40a1a71cae680085031a_9366/Bola_Al_Rihla_Pro_Branco_H57783.jpg','2023-12-05 00:00:00',NULL,'29768006005',NULL);
/*!40000 ALTER TABLE `bola` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-06  8:42:27
