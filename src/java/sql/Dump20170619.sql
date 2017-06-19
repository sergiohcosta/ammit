-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ammit
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
  `codigofonte` longblob,
  `codigofonte_linguagem` varchar(10) DEFAULT NULL,
  `questao` int(11) NOT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `conteudo` text,
  PRIMARY KEY (`id`),
  KEY `fk_casoteste_questao1_idx` (`questao`),
  CONSTRAINT `fk_casoteste_questao1` FOREIGN KEY (`questao`) REFERENCES `questao` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casoteste`
--

LOCK TABLES `casoteste` WRITE;
/*!40000 ALTER TABLE `casoteste` DISABLE KEYS */;
INSERT INTO `casoteste` VALUES (13,'i[1:100,2]',1,'','','#include <stdio.h>\r\n//corrige se A+B=C\r\nvoid main(void){\r\n	int a, b, c;\r\n	scanf(\"%d %d %d\", &a, &b, &c);\r\n	if(a+b==c)\r\n		printf(\"%d\", 0);\r\n	else\r\n		printf(\"%d\", 1);\r\n	return;\r\n}','C',30,'Soma n√∫meros aleat√≥rios','n√∫meros aleat√≥rios'),(14,'',0,'132131 1321321','1231321',NULL,'C',30,'aszxcvbn','sdfghjk'),(15,'i[1:100,2]',20,'','','#include <stdio.h>\r\n//soma A+B\r\nvoid main(void){\r\n	int a, b;\r\n	scanf(\"%d %d\", &a, &b);\r\n	printf(\"%d\", a+b);\r\n	return;\r\n}','C',31,'CT Usando Ammit','Caso de teste usando Ammit'),(16,'',0,'13 39\r\n<--FIM-->\r\n29 23\r\n<--FIM-->\r\n17 87\r\n<--FIM-->\r\n74 50\r\n<--FIM-->\r\n69 48\r\n<--FIM-->\r\n85 58\r\n<--FIM-->\r\n9 53\r\n<--FIM-->\r\n7 88\r\n<--FIM-->\r\n19 82\r\n<--FIM-->\r\n51 72\r\n<--FIM-->\r\n20 18\r\n<--FIM-->\r\n65 91\r\n<--FIM-->\r\n96 49\r\n<--FIM-->\r\n24 72\r\n<--FIM-->\r\n84 27\r\n<--FIM-->\r\n78 34\r\n<--FIM-->\r\n47 87\r\n<--FIM-->\r\n25 73\r\n<--FIM-->\r\n78 71\r\n<--FIM-->\r\n91 8\r\n<--FIM-->','52\r\n<--FIM-->\r\n52\r\n<--FIM-->\r\n104\r\n<--FIM-->\r\n124\r\n<--FIM-->\r\n117\r\n<--FIM-->\r\n143\r\n<--FIM-->\r\n62\r\n<--FIM-->\r\n95\r\n<--FIM-->\r\n101\r\n<--FIM-->\r\n123\r\n<--FIM-->\r\n38\r\n<--FIM-->\r\n156\r\n<--FIM-->\r\n145\r\n<--FIM-->\r\n96\r\n<--FIM-->\r\n111\r\n<--FIM-->\r\n112\r\n<--FIM-->\r\n134\r\n<--FIM-->\r\n98\r\n<--FIM-->\r\n149\r\n<--FIM-->\r\n99\r\n<--FIM-->',NULL,'C',31,'CT Manual - Sa√≠da Manual','Caso de teste manual com sa√≠das manuais'),(17,'i[1:100,2]',20,'','','#include <stdio.h>\r\n//soma A+B\r\nvoid main(void){\r\n	int a, b;\r\n	scanf(\"%d %d\", &a, &b);\r\n	printf(\"%d\", a+b);\r\n	return;\r\n}','C',32,'Ammit','ammit'),(18,'',0,'2 12\r\n<--FIM-->\r\n78 24\r\n<--FIM-->\r\n37 3\r\n<--FIM-->\r\n6 15\r\n<--FIM-->\r\n12 86\r\n<--FIM-->','14\r\n<--FIM-->\r\n102\r\n<--FIM-->\r\n40\r\n<--FIM-->\r\n21\r\n<--FIM-->\r\n98\r\n<--FIM-->',NULL,'C',32,'manual','manual'),(19,'i',1,'','','MZê\0\0\0\0\0\0\0ˇˇ\0\0∏\0\0\0\0\0\0\0@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Ä\0\0\0∫\0¥	\Õ!∏L\Õ!This program cannot be run in DOS mode.\r\r\n$\0\0\0\0\0\0\0PE\0\0L\0\0\0\0\0\0\0\0\0\0\0\0\0\‡\0\0\0\0\0\0\0\0\0\0\0\0\0\0Ä\0\0\0\0\0\0 \0\0\0\0@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\00\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0  \0\0(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0H \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0.text\0\0\0(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0 \0\0`.data\0\0\0\‡\0\0\0\0 \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0@\0\0¿\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Uâ\ÂÅ\Ï\0\0\0êçEÙPçE¯PçE¸P∏\0 @\0P\Ë\◊\0\0\0É\ƒãE¸ãM¯»ãMÙ9\»Ö\0\0\0∏\0\0\0\0P∏	 @\0P\Ë∏\0\0\0É\ƒ\È\0\0\0∏\0\0\0P∏ @\0P\Ëü\0\0\0É\ƒ\È\0\0\0\0\…\√\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Uâ\ÂÅ\Ï\0\0\0ê∏\0\0\0\0âE\Ï∏\0\0\0P∏\0\0\0P\Ëe\0\0\0É\ƒ∏\0\0\0P\Ë_\0\0\0É\ƒçE\ÏP∏\0\0\0\0PçEÙPçE¯PçE¸P\ËI\0\0\0É\ƒãEÙPãE¯PãE¸P\ËˇˇˇÉ\ƒâEãEP\Ë.\0\0\0É\ƒ\…\√\0ˇ%H @\0\0\0ˇ%L @\0\0\0ˇ%P @\0\0\0ˇ%T @\0\0\0ˇ%X @\0\0\0ˇ%\\ @\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0%d %d %d\0%d\0%d\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0d \0\0\0\0\0\0\0\0\0\0Ä \0\0H \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ã \0\0ì \0\0ú \0\0© \0\0∫ \0\0\  \0\0\0\0\0\0ã \0\0ì \0\0ú \0\0© \0\0∫ \0\0\  \0\0\0\0\0\0msvcrt.dll\0\0\0scanf\0\0\0printf\0\0\0_controlfp\0\0\0__set_app_type\0\0\0__getmainargs\0\0\0exit\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','C',33,'Caso teste','dcfvgyhj');
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
  CONSTRAINT `fk_questao_usuario` FOREIGN KEY (`professor`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questao`
--

LOCK TABLES `questao` WRITE;
/*!40000 ALTER TABLE `questao` DISABLE KEYS */;
INSERT INTO `questao` VALUES (26,'T√≠tulo','Enunciado',1),(30,'Soma','Dados x e y imprima x+y',15),(31,'Somar dois n√∫meros','Dados x e y retorne x+y',15),(32,'Soma - s√≥ ammit','soma s√≥ ammit',15),(33,'Teste remover caso teste','rdcvygbjhn',15);
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
  `aluno` int(11) NOT NULL,
  `questao` int(11) NOT NULL,
  `codfonte` longblob,
  `estado` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_resposta_aluno` (`aluno`),
  KEY `fk_resposta_questao` (`questao`),
  CONSTRAINT `fk_resposta_aluno` FOREIGN KEY (`aluno`) REFERENCES `usuario` (`id`),
  CONSTRAINT `fk_resposta_questao` FOREIGN KEY (`questao`) REFERENCES `questao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resposta`
--

LOCK TABLES `resposta` WRITE;
/*!40000 ALTER TABLE `resposta` DISABLE KEYS */;
INSERT INTO `resposta` VALUES (1,16,30,NULL,-1),(2,16,26,'#include <stdio.h>\r\n//intencionalmente soma errado o valor de A+B\r\nvoid main(void){\r\n	int a, b, i;\r\n	scanf(\"%d %d\", &a, &b);\r\n	for(i=0; i<b; i++)\r\n		a++;\r\n	printf(\"%d\", a+b);\r\n	return;\r\n}',-1),(3,16,31,'MZê\0\0\0\0\0\0\0ˇˇ\0\0∏\0\0\0\0\0\0\0@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Ä\0\0\0∫\0¥	\Õ!∏L\Õ!This program cannot be run in DOS mode.\r\r\n$\0\0\0\0\0\0\0PE\0\0L\0\0\0\0\0\0\0\0\0\0\0\0\0\‡\0\0\0\0\0\0\0\0\0\0\0\0\0\0@\0\0\0\0\0\0 \0\0\0\0@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\00\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0  \0\0(\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0H \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0.text\0\0\0\Ë\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0 \0\0`.data\0\0\0\‡\0\0\0\0 \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0@\0\0¿\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0Uâ\ÂÅ\Ï\0\0\0êçE¯PçE¸P∏\0 @\0P\Ëõ\0\0\0É\ƒãE¸ãM¯\»P∏ @\0P\Ëå\0\0\0É\ƒ\È\0\0\0\0\…\√\0\0Uâ\ÂÅ\Ï\0\0\0ê∏\0\0\0\0âE\Ï∏\0\0\0P∏\0\0\0P\Ëe\0\0\0É\ƒ∏\0\0\0P\Ë_\0\0\0É\ƒçE\ÏP∏\0\0\0\0PçEÙPçE¯PçE¸P\ËI\0\0\0É\ƒãEÙPãE¯PãE¸P\Ë]ˇˇˇÉ\ƒâEãEP\Ë.\0\0\0É\ƒ\…\√\0ˇ%H @\0\0\0ˇ%L @\0\0\0ˇ%P @\0\0\0ˇ%T @\0\0\0ˇ%X @\0\0\0ˇ%\\ @\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0%d %d\0%d\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0d \0\0\0\0\0\0\0\0\0\0Ä \0\0H \0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ã \0\0ì \0\0ú \0\0© \0\0∫ \0\0\  \0\0\0\0\0\0ã \0\0ì \0\0ú \0\0© \0\0∫ \0\0\  \0\0\0\0\0\0msvcrt.dll\0\0\0scanf\0\0\0printf\0\0\0_controlfp\0\0\0__set_app_type\0\0\0__getmainargs\0\0\0exit\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0',-1),(4,16,31,'#include <stdio.h>\r\n//soma A+B\r\nvoid main(void){\r\n	int a, b;\r\n	scanf(\"%d %d\", &a, &b);\r\n	printf(\"%d\", a+b);\r\n	return;\r\n}',-1),(5,16,31,'#include <stdio.h>\r\n//soma A+B\r\nvoid main(void){\r\n	int a, b;\r\n	scanf(\"%d %d\", &a, &b);\r\n	printf(\"%d\", a+b);\r\n	return;\r\n}',-1),(6,16,31,'#include <stdio.h>\r\n//soma A+B\r\nvoid main(void){\r\n	int a, b;\r\n	scanf(\"%d %d\", &a, &b);\r\n	printf(\"%d\", a+b);\r\n	return;\r\n}',-4),(7,16,31,'#include <stdio.h>\r\n//soma A+B\r\nvoid main(void){\r\n	int a, b;\r\n	scanf(\"%d %d\", &a, &b);\r\n	printf(\"%d\", a+b);\r\n	return;\r\n}',-4),(8,16,31,'#include <stdio.h>\r\n//soma A+B atrav√©s de um la√ßo for (propositalmente ineficiente)\r\nvoid main(void){\r\n	int a, b, i;\r\n	scanf(\"%d %d\", &a, &b);\r\n	for(i=0; i<b; i++)\r\n		a++;\r\n	printf(\"%d\", a);\r\n	return;\r\n}',2),(9,16,31,'#include <stdio.h>\r\n//soma A+B\r\nvoid main(void){\r\n	int a, b;\r\n	scanf(\"%d %d\", &a, &b);\r\n	printf(\"%d\", a+b);\r\n	return;\r\n}',0),(10,16,32,'#include <stdio.h>\r\n//soma A+B\r\nvoid main(void){\r\n	int a, b;\r\n	scanf(\"%d %d\", &a, &b);\r\n	printf(\"%d\", a+b);\r\n	return;\r\n}',0),(11,16,32,'#include <stdio.h>\r\n//soma A+B\r\nvoid main(void){\r\n	int a, b;\r\n	scanf(\"%d %d\", &a, &b);\r\n	printf(\"%d\", a+b);\r\n	return;\r\n}',0);
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Administrador','admin','˝A£vA\‚0≥ø8[t#º\ŒhR°','ø¶ \—\Í	\0\0\0\0\0\0\0\0\0\0\0\0','Admin',1),(2,'Professor 1','prof1@prof1.com','v\ÕLJ)\Ó\…\’\n.sy¥5Àéññ`','\€K™\ÔÚ\ﬂ\0\0\0\0\0\0\0\0\0\0\0\0','Professor',1),(3,'Professor 2','prof2@prof2.com','äÒmsU\ƒp¶˚v8µTä^`','iû\Í2G\‚\“','Professor',1),(4,'Professor 3','prof3@prof3.com','ºo\ƒ\‹\ÿ\ÍÄ\ﬁÇÜ≤ò∏\Ë·ÑêG','\ƒZIÜ^Ù\nÅ','Professor',1),(5,'Aluno 1','aluno1@aluno1.com','©éò\œH5S\‹7•D5+	Ω',' ˝.ëÜ\Ÿ®','Aluno',1),(6,'Professor 4','prof4@prof4.com','66\÷Ÿßn◊åG?\Œ?\'{^¶†Ω','qrX\¬¡;∏','Professor',1),(7,'Aluno 2','aluno2@aluno2.com','\”X\Ï)øP6⁄üó[Äjâ\ÿÛM/','ç9ºn&','Aluno',1),(8,'Professor 5','prof5@prof5.com','A\ÿ7lPJ‘ù∏≥u[=öY(Äº¡','ò›Ü˝JJ\⁄P','Professor',1),(9,'Professor 6','prof6@prof6.com','G}íû5l_l•Jù\Á\”*\ƒ\Á|Cù',')ªà©,','Professor',1),(10,'Professor 8','prof8@prof8.com','w\È:\–\›S\≈m¡£≥K<Ø?','±µsF\·!|•','Professor',1),(14,'alunooo','aluno@oo','v≤ÜÇR°@∂\ﬁscS•ô*VÉ&b','®ã\Ÿ\÷\…\ƒE','Professor',1),(15,'profteste','prof@t','∑8rã\'2è¿€ÇmW4@\…&º\ÕI','\ÿ\ÊX˜∑Hü\Á','Professor',1),(16,'alun','alu@n','∂Z∫&s>]°#¡à≥\'OŸÑ>MZ\∆','\‘\‘N6Ùô9','Aluno',1);
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

-- Dump completed on 2017-06-19  1:52:29
