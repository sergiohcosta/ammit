-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ammit
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `casoteste`
--

DROP TABLE IF EXISTS `casoteste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `casoteste` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ammit_seed` varchar(100) DEFAULT NULL,
  `ammit_qtde` int(11) DEFAULT NULL,
  `entrada` text,
  `saida` text,
  `codigofonte` longtext,
  `codigofonte_linguagem` varchar(10) DEFAULT NULL,
  `questao` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_casoteste_questao1_idx` (`questao`),
  CONSTRAINT `fk_casoteste_questao1` FOREIGN KEY (`questao`) REFERENCES `questao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casoteste`
--

LOCK TABLES `casoteste` WRITE;
/*!40000 ALTER TABLE `casoteste` DISABLE KEYS */;
/*!40000 ALTER TABLE `casoteste` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questao`
--

DROP TABLE IF EXISTS `questao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `enunciado` text COLLATE utf8mb4_unicode_ci,
  `professor` int(11) NOT NULL,
  PRIMARY KEY (`id`,`professor`),
  KEY `fk_questao_usuario_idx` (`professor`),
  CONSTRAINT `fk_questao_usuario` FOREIGN KEY (`professor`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questao`
--

LOCK TABLES `questao` WRITE;
/*!40000 ALTER TABLE `questao` DISABLE KEYS */;
INSERT INTO `questao` VALUES (1,'titulo 1','enunciado 1',2),(5,'titulo 2','enunciado 2',3),(8,'qqqqqqqqqq','wwwwwwwww',2),(11,'Uma pergunta do prof2','um enunciado que nao importa',3),(15,'adasdsad','saasasda',1),(16,'drgdfdfgdfggf','sdfasfdadfasfd',4),(17,'cvbsadsdsdsa','rtsdadfgth',4);
/*!40000 ALTER TABLE `questao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resposta`
--

DROP TABLE IF EXISTS `resposta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resposta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` tinyint(1) DEFAULT NULL,
  `aluno` int(11) NOT NULL,
  PRIMARY KEY (`id`,`aluno`),
  KEY `fk_resposta_usuario1_idx` (`aluno`),
  CONSTRAINT `fk_resposta_usuario1` FOREIGN KEY (`aluno`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resposta`
--

LOCK TABLES `resposta` WRITE;
/*!40000 ALTER TABLE `resposta` DISABLE KEYS */;
/*!40000 ALTER TABLE `resposta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pwd` blob NOT NULL,
  `salt` blob NOT NULL,
  `perfil` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `situacao` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'11111','11111@11111.111','˝A£vA\‚0≥ø8[t#º\ŒhR°','ø¶ \—\Í	\0\0\0\0\0\0\0\0\0\0\0\0','Professor',1),(2,'prof1','prof1@prof1.com','v\ÕLJ)\Ó\…\’\n.sy¥5Àéññ`','\€K™\ÔÚ\ﬂ\0\0\0\0\0\0\0\0\0\0\0\0','Professor',1),(3,'prof2','prof2@prof2.com','äÒmsU\ƒp¶˚v8µTä^`','iû\Í2G\‚\“','Professor',1),(4,'prof3@prof3.com','prof3@prof3.com','ºo\ƒ\‹\ÿ\ÍÄ\ﬁÇÜ≤ò∏\Ë·ÑêG','\ƒZIÜ^Ù\nÅ','Professor',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-12  1:12:08
