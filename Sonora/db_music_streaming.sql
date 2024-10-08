CREATE DATABASE  IF NOT EXISTS `db_music_streaming` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_music_streaming`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: db_music_streaming
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `album` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `artist_id` bigint DEFAULT NULL,
  `genre_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmwc4fyyxb6tfi0qba26gcf8s1` (`artist_id`),
  KEY `FKmhihrmrx2f1mhqtrbagwru45g` (`genre_id`),
  CONSTRAINT `FKmhihrmrx2f1mhqtrbagwru45g` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`),
  CONSTRAINT `FKmwc4fyyxb6tfi0qba26gcf8s1` FOREIGN KEY (`artist_id`) REFERENCES `artist` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES (1,'Chegou a Hora de Recomeçar',1,1),(2,'Felicidade Instantânea',1,1),(3,'NX Zero',2,1),(4,'Em Comum',2,1),(5,'Detonautas',3,1),(6,'Roque Marciano',3,1),(7,'The Dark Side of the Moon',4,1),(8,'The Wall',4,1),(9,'A Momentary Lapse of Reason',4,1),(10,'Abbey Road',5,1);
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artist`
--

DROP TABLE IF EXISTS `artist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artist` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artist`
--

LOCK TABLES `artist` WRITE;
/*!40000 ALTER TABLE `artist` DISABLE KEYS */;
INSERT INTO `artist` VALUES (1,'CPM 22','Brazil'),(2,'NX Zero','Brazil'),(3,'Detonautas','Brazil'),(4,'Pink Floyd','England'),(5,'The Beatles','England');
/*!40000 ALTER TABLE `artist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genre` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (1,'Rock'),(2,'Pop');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `music`
--

DROP TABLE IF EXISTS `music`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `music` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `album_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1gpg5o9xo7gkxeietx17guu2g` (`album_id`),
  CONSTRAINT `FK1gpg5o9xo7gkxeietx17guu2g` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `music`
--

LOCK TABLES `music` WRITE;
/*!40000 ALTER TABLE `music` DISABLE KEYS */;
INSERT INTO `music` VALUES (1,'Desconfio',1),(2,'Sonhos e Planos',1),(3,'Vidas que se Encontram',1),(4,'Dias Atrás',1),(5,'Amigos Perdidos',1),(6,'Especial Como Você',1),(7,'Não Sei Viver Sem Ter Você',1),(8,'Atordoado',1),(9,'Garota da TV',1),(10,'Ontem',1),(11,'Coragem',1),(12,'Argumento',1),(13,'Peter',1),(14,'Mentiras Novas',1),(15,'Felicidade Instantânea',2),(16,'Um Minuto Para o Fim do Mundo',2),(17,'Apostas & Certezas',2),(18,'Irreversível',2),(19,'Não Vá Embora',2),(20,'A Cura',2),(21,'Recíproca',2),(22,'Pensamentos Negativos',2),(23,'Cidade em Chamas',2),(24,'Park, Park',2),(25,'Jovem, Alcoólatra, Suicida',2),(26,'Crise de Existência',2),(27,'Contagem Regressiva',2),(28,'Reflexões',2),(29,'Depois do Fim',2),(30,'Repetição',2),(31,'Álem de Mim',3),(32,'Consequência',3),(33,'Razões e Emoções',3),(34,'Um Pouco Mais',3),(35,'Ilusão',3),(36,'Apenas Um Olhar',3),(37,'Pela Última Vez',3),(38,'La Prision',3),(39,'Incompleta',3),(40,'Círculos',3),(41,'Tarde Demais',3),(42,'Uma Chance',3),(43,'Mentiras e Fracassos',3),(44,'Um Outro Caminho',3),(45,'Sem Hora Pra Voltar',4),(46,'Maré',4),(47,'Ligação',4),(48,'Hoje o Céu Abriu',4),(49,'Espero Um Sinal',4),(50,'Em Comum',4),(51,'Intro',4),(52,'Guerra Por Paz',4),(53,'Você Me Fez',4),(54,'Pedido',4),(55,'Estrada',4),(56,'Nada Mais é Como Era Antes',4),(57,'No Way Out',5),(58,'Outro Lugar',5),(59,'Quando o Sol se For',5),(60,'Ei Perae!!!',5),(61,'Olhos Certos',5),(62,'Nem Me Lembro Mais',5),(63,'O Bem e o Mal',5),(64,'Ladrão de Gravata',5),(65,'Mais Além',5),(66,'Que Diferença Faz',5),(67,'Outro Lugar - Versão Especial',5),(68,'O Amanhã',6),(69,'Nada Vai Mudar',6),(70,'O Dia que Não Terminou',6),(71,'Mercador das Almas',6),(72,'Só Por Hoje',6),(73,'Com Você',6),(74,'Silêncio',6),(75,'Meu Bem',6),(76,'Tênis Roque',6),(77,'Tô Aprendendo a Viver Sem Você',6),(78,'Send U Back',6),(79,'Speak to Me',7),(80,'Breathe (In the Air)',7),(81,'On the Run',7),(82,'Time',7),(83,'The Great Gig in the Sky',7),(84,'Money',7),(85,'Us and Them',7),(86,'Any Colour You Like',7),(87,'Brain Damage',7),(88,'Eclipse',7),(89,'In the Flesh?',8),(90,'The Thin Ice',8),(91,'Another Brick in the Wall, Pt. 1',8),(92,'The Happiest Days of Our Lives',8),(93,'Another Brick in the Wall, Pt. 2',8),(94,'Mother',8),(95,'Goodbye Blue Sky',8),(96,'Empty Spaces',8),(97,'Young Lust',8),(98,'One of My Turns',8),(99,'Don\'t Leave Me Now',8),(100,'Another Brick in the Wall, Pt. 3',8),(101,'Goodbye Cruel World',8),(102,'Hey You',8),(103,'Is There Anybody Out There?',8),(104,'Nobody Home',8),(105,'Vera',8),(106,'Bring the Boys Back Home',8),(107,'Comfortably Numb',8),(108,'The Show Must Go On',8),(109,'In The Flesh',8),(110,'Run Like Hell',8),(111,'Waiting for the Worms',8),(112,'Stop',8),(113,'The Trial',8),(114,'Outside the Wall',8),(115,'Signs of Life',9),(116,'Learning to Fly',9),(117,'The Dogs of War',9),(118,'One Slip',9),(119,'On the Turning Away',9),(120,'Yet Another Movie',9),(121,'Round and Around',9),(122,'A New Machine, Pt. 1',9),(123,'Terminal Frost',9),(124,'A New Machine, Pt. 2',9),(125,'Sorrow',9),(126,'Come Together',10),(127,'Something',10),(128,'Maxwell\'s Silver Hammer',10),(129,'Oh! Darling',10),(130,'Octopus\'s Garden',10),(131,'I Want You',10),(132,'Here Comes The Sun',10),(133,'Because',10),(134,'You Never Give Me Your Money',10),(135,'Sun King',10),(136,'Mean Mr Mustard',10),(137,'Polythene Pam',10),(138,'She Came In Through the Bathroom Window',10),(139,'Golden Slumbers',10),(140,'Carry That Weight',10),(141,'The End',10),(142,'Her Majesty',10);
/*!40000 ALTER TABLE `music` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist`
--

LOCK TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
INSERT INTO `playlist` VALUES (1,'Favorites'),(2,'Brazil');
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist_music`
--

DROP TABLE IF EXISTS `playlist_music`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist_music` (
  `id_playlist` bigint NOT NULL,
  `id_music` bigint NOT NULL,
  KEY `FK7ct0ntqcg5tsxlhxogwdjnw5m` (`id_music`),
  KEY `FKfkkmfgpk5esbfn6u47dkecvlj` (`id_playlist`),
  CONSTRAINT `FK7ct0ntqcg5tsxlhxogwdjnw5m` FOREIGN KEY (`id_music`) REFERENCES `music` (`id`),
  CONSTRAINT `FKfkkmfgpk5esbfn6u47dkecvlj` FOREIGN KEY (`id_playlist`) REFERENCES `playlist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist_music`
--

LOCK TABLES `playlist_music` WRITE;
/*!40000 ALTER TABLE `playlist_music` DISABLE KEYS */;
INSERT INTO `playlist_music` VALUES (1,4),(1,7),(1,16),(1,18),(1,33),(1,42),(1,46),(1,47),(1,58),(1,107),(1,116);
/*!40000 ALTER TABLE `playlist_music` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-03 19:14:47
