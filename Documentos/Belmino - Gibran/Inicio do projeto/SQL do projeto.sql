CREATE DATABASE  IF NOT EXISTS `aplicar_prova` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `aplicar_prova`;
-- MySQL dump 10.13  Distrib 5.5.43, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: aplicar_prova
-- ------------------------------------------------------
-- Server version	5.5.43-0ubuntu0.14.04.1

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
-- Table structure for table `alunos`
--

DROP TABLE IF EXISTS `alunos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alunos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `matricula` varchar(7) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alunos`
--

LOCK TABLES `alunos` WRITE;
/*!40000 ALTER TABLE `alunos` DISABLE KEYS */;
INSERT INTO `alunos` VALUES (1,'Gibran','123'),(2,'Gibran','1232');
/*!40000 ALTER TABLE `alunos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplinas`
--

DROP TABLE IF EXISTS `disciplinas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplinas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplinas`
--

LOCK TABLES `disciplinas` WRITE;
/*!40000 ALTER TABLE `disciplinas` DISABLE KEYS */;
INSERT INTO `disciplinas` VALUES (1,'Tecnologias de Internet'),(2,'Algoritmos');
/*!40000 ALTER TABLE `disciplinas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opcoes`
--

DROP TABLE IF EXISTS `opcoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opcoes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enunciado` varchar(255) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `resposta` varchar(255) DEFAULT NULL,
  `id_questao` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_questao` (`id_questao`),
  CONSTRAINT `opcoes_ibfk_1` FOREIGN KEY (`id_questao`) REFERENCES `questoes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opcoes`
--

LOCK TABLES `opcoes` WRITE;
/*!40000 ALTER TABLE `opcoes` DISABLE KEYS */;
INSERT INTO `opcoes` VALUES (1,'<negrito>',0,'',1),(2,'<bold>',0,'',1),(3,'<b>',0,'',1),(4,'<n>',0,'',1),(5,'<italico>',0,'',2),(6,'<italic>',0,'',2),(7,'<i>',0,'',2),(8,'',0,'5',3),(9,'<ul>',0,'',4),(10,'<ol>',0,'',4),(11,'<list>',0,'',4),(12,'<dl>',0,'',4);
/*!40000 ALTER TABLE `opcoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provas`
--

DROP TABLE IF EXISTS `provas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `id_disciplina` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_disciplina` (`id_disciplina`),
  CONSTRAINT `provas_ibfk_1` FOREIGN KEY (`id_disciplina`) REFERENCES `disciplinas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provas`
--

LOCK TABLES `provas` WRITE;
/*!40000 ALTER TABLE `provas` DISABLE KEYS */;
INSERT INTO `provas` VALUES (1,'Primeira prova',1);
/*!40000 ALTER TABLE `provas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provas_questoes`
--

DROP TABLE IF EXISTS `provas_questoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provas_questoes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_questao` int(11) NOT NULL,
  `id_prova` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_questao` (`id_questao`),
  KEY `id_prova` (`id_prova`),
  CONSTRAINT `provas_questoes_ibfk_1` FOREIGN KEY (`id_questao`) REFERENCES `questoes` (`id`),
  CONSTRAINT `provas_questoes_ibfk_2` FOREIGN KEY (`id_prova`) REFERENCES `provas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provas_questoes`
--

LOCK TABLES `provas_questoes` WRITE;
/*!40000 ALTER TABLE `provas_questoes` DISABLE KEYS */;
INSERT INTO `provas_questoes` VALUES (1,1,1),(2,2,1),(3,2,1),(4,3,1),(5,4,1);
/*!40000 ALTER TABLE `provas_questoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provas_questoes_opcoes_aluno`
--

DROP TABLE IF EXISTS `provas_questoes_opcoes_aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provas_questoes_opcoes_aluno` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_prova_questao` int(11) NOT NULL,
  `id_opcao` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL,
  `status` char(1) DEFAULT NULL,
  `resposta` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_prova_questao` (`id_prova_questao`),
  KEY `id_opcao` (`id_opcao`),
  KEY `id_aluno` (`id_aluno`),
  CONSTRAINT `provas_questoes_opcoes_aluno_ibfk_1` FOREIGN KEY (`id_prova_questao`) REFERENCES `provas_questoes` (`id`),
  CONSTRAINT `provas_questoes_opcoes_aluno_ibfk_2` FOREIGN KEY (`id_opcao`) REFERENCES `opcoes` (`id`),
  CONSTRAINT `provas_questoes_opcoes_aluno_ibfk_3` FOREIGN KEY (`id_aluno`) REFERENCES `alunos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provas_questoes_opcoes_aluno`
--

LOCK TABLES `provas_questoes_opcoes_aluno` WRITE;
/*!40000 ALTER TABLE `provas_questoes_opcoes_aluno` DISABLE KEYS */;
/*!40000 ALTER TABLE `provas_questoes_opcoes_aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questoes`
--

DROP TABLE IF EXISTS `questoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questoes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enunciado` varchar(255) NOT NULL,
  `tipo` char(1) DEFAULT NULL,
  `id_topico` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_topico` (`id_topico`),
  CONSTRAINT `questoes_ibfk_1` FOREIGN KEY (`id_topico`) REFERENCES `topicos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questoes`
--

LOCK TABLES `questoes` WRITE;
/*!40000 ALTER TABLE `questoes` DISABLE KEYS */;
INSERT INTO `questoes` VALUES (1,'Qual a tag para negrito?','M',1),(2,'Qual tag para italico?','M',1),(3,'Qual tag para italico?','M',1),(4,'Qual a tag para itálico?','M',1),(5,'Qual a versão atual do HTML?','S',1),(6,'Quais tags são usadas para criar listas?','V',1);
/*!40000 ALTER TABLE `questoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topicos`
--

DROP TABLE IF EXISTS `topicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topicos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `id_disciplina` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_disciplina` (`id_disciplina`),
  CONSTRAINT `topicos_ibfk_1` FOREIGN KEY (`id_disciplina`) REFERENCES `disciplinas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topicos`
--

LOCK TABLES `topicos` WRITE;
/*!40000 ALTER TABLE `topicos` DISABLE KEYS */;
INSERT INTO `topicos` VALUES (1,'Front End',1),(2,'Back End',1);
/*!40000 ALTER TABLE `topicos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-20  0:07:02
