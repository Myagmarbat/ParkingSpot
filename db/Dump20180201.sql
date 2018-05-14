-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 10.10.11.170    Database: spotsystem
-- ------------------------------------------------------
-- Server version	5.5.46

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
-- Table structure for table `alien`
--

DROP TABLE IF EXISTS `alien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alien` (
  `aid` int(11) NOT NULL,
  `aname` varchar(45) DEFAULT NULL,
  `tech` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alien`
--

LOCK TABLES `alien` WRITE;
/*!40000 ALTER TABLE `alien` DISABLE KEYS */;
INSERT INTO `alien` VALUES (1,'hi','hi'),(2,'asdf','asdf');
/*!40000 ALTER TABLE `alien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car_type`
--

DROP TABLE IF EXISTS `car_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car_type` (
  `car_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `price` decimal(8,2) DEFAULT NULL,
  `wash_price` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`car_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_type`
--

LOCK TABLES `car_type` WRITE;
/*!40000 ALTER TABLE `car_type` DISABLE KEYS */;
INSERT INTO `car_type` VALUES (1,'REGULAR',10.00,5.00),(2,'LARGE',15.00,8.00);
/*!40000 ALTER TABLE `car_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `customer_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'JOHN','SMITH','john@gmail.com','2000 North court',3),(2,'Flinstone','Fred','22',NULL,NULL),(3,'last','firsat','test@test.mn',NULL,NULL),(4,'last','firsat','test@test.mn',NULL,NULL),(5,'last','firsat','test@test.mn',NULL,NULL),(6,'sss','2','test@test.mn',NULL,NULL),(7,'testok','name2','test1@test.mn',NULL,NULL),(8,'test3','3','test@test.mn',NULL,NULL),(9,'test5','5','test@test.mn',NULL,NULL),(10,'test','test','test4@test.mn',NULL,NULL),(11,'Cust','Cust Last','asd@gmak.cl',NULL,NULL),(12,'Customer','CustomerLastNAme','asd@gmak.cl',NULL,NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_address`
--

DROP TABLE IF EXISTS `customer_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(45) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_address`
--

LOCK TABLES `customer_address` WRITE;
/*!40000 ALTER TABLE `customer_address` DISABLE KEYS */;
INSERT INTO `customer_address` VALUES (1,'FF','1000 N','52555','IA'),(2,'City','null','8922','IO');
/*!40000 ALTER TABLE `customer_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_type`
--

DROP TABLE IF EXISTS `customer_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_type` (
  `customer_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  PRIMARY KEY (`customer_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_type`
--

LOCK TABLES `customer_type` WRITE;
/*!40000 ALTER TABLE `customer_type` DISABLE KEYS */;
INSERT INTO `customer_type` VALUES (1,'GOLD',15),(2,'SILVER',10),(3,'BRONZE',5),(4,'GUEST',0);
/*!40000 ALTER TABLE `customer_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parking`
--

DROP TABLE IF EXISTS `parking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parking` (
  `parking_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`parking_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parking`
--

LOCK TABLES `parking` WRITE;
/*!40000 ALTER TABLE `parking` DISABLE KEYS */;
INSERT INTO `parking` VALUES (1,'Park1'),(2,'Park2'),(3,'Park3'),(4,'name'),(5,'test1'),(6,'test2'),(7,'test3'),(8,'test3'),(9,'test3'),(10,'test3'),(11,''),(12,''),(13,''),(14,''),(15,'park1'),(16,'park1'),(17,'park1 '),(18,'123'),(19,'qwe'),(20,'eeee'),(21,'as'),(22,'park1'),(23,'park'),(24,'park4');
/*!40000 ALTER TABLE `parking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `checkin_date` datetime DEFAULT NULL,
  `checkout_date` datetime DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `wash_requested` tinyint(1) NOT NULL DEFAULT '0',
  `washed` tinyint(1) NOT NULL DEFAULT '0',
  `car_type_id` int(11) NOT NULL,
  `duration` int(11) DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` VALUES (1,1,'2018-01-30 20:15:26','2018-01-30 22:15:26',6000,1,1,1,7200),(2,2,'2018-01-30 20:36:57','2018-02-02 18:15:26',10000,1,1,2,250709),(3,1,'2018-02-01 11:34:07',NULL,NULL,1,0,1,NULL),(4,1,'2018-02-01 14:33:50','2018-02-01 19:16:07',NULL,0,1,1,16937),(5,1,'2018-02-01 14:34:26','2018-02-01 19:21:35',NULL,0,0,2,17229),(6,NULL,'2018-02-01 14:58:12','2018-02-01 19:21:39',NULL,0,0,2,15807),(7,NULL,'2018-02-01 15:01:29','2018-02-01 19:39:32',NULL,1,1,2,16683),(8,3,'2018-02-01 15:13:05','2018-02-01 19:39:39',NULL,0,0,2,15994),(9,2,'2018-02-01 15:13:51','2018-02-01 19:39:35',NULL,0,0,2,15944),(10,6,'2018-02-01 15:14:52','2018-02-01 19:40:18',NULL,0,0,1,15926),(11,5,'2018-02-01 15:18:14','2018-02-01 19:40:41',NULL,0,0,1,15747),(12,3,'2018-02-01 15:31:36','2018-02-01 19:40:48',NULL,0,0,1,14952),(13,6,'2018-02-01 15:43:07','2018-02-01 19:40:51',NULL,0,0,2,14264),(14,9,'2018-02-01 15:43:55','2018-02-01 19:41:00',NULL,0,0,2,14225),(15,3,'2018-02-01 15:46:05','2018-02-01 19:40:54',NULL,0,0,2,14089),(16,9,'2018-02-01 15:46:25','2018-02-01 19:40:57',NULL,0,0,1,14072),(17,NULL,'2018-02-01 15:46:54','2018-02-01 19:41:14',NULL,0,0,2,14060),(18,2,'2018-02-01 15:47:59','2018-02-01 19:41:03',NULL,0,0,1,13984),(19,1,'2018-02-01 15:53:06','2018-02-01 19:41:07',NULL,0,0,1,13681),(20,NULL,'2018-02-01 17:03:01','2018-02-01 19:41:10',NULL,0,0,2,9489),(21,NULL,'2018-02-01 17:04:30','2018-02-01 19:41:17',NULL,0,0,2,9407),(22,NULL,'2018-02-01 17:05:20','2018-02-01 19:41:28',NULL,0,0,1,9368),(23,NULL,'2018-02-01 17:06:05','2018-02-01 19:41:21',NULL,0,0,2,9316),(24,NULL,'2018-02-01 17:17:38','2018-02-01 19:41:31',NULL,0,0,1,8633),(25,NULL,'2018-02-01 17:18:55','2018-02-01 19:41:36',NULL,0,0,1,8561),(26,NULL,'2018-02-01 17:20:29','2018-02-01 19:41:40',NULL,0,0,1,8471),(27,NULL,'2018-02-01 17:21:20','2018-02-01 19:41:50',NULL,0,0,1,8430),(28,NULL,'2018-02-01 18:35:25',NULL,NULL,0,0,1,NULL),(29,NULL,'2018-02-01 19:11:29','2018-02-01 19:41:59',NULL,0,0,1,1830),(30,NULL,'2018-02-01 19:42:06','2018-02-01 19:42:51',NULL,1,1,1,45),(31,NULL,'2018-02-01 19:43:35','2018-02-01 19:43:39',NULL,0,0,1,4),(32,NULL,'2018-02-01 19:45:24',NULL,NULL,0,0,1,NULL),(33,NULL,'2018-02-01 20:37:46',NULL,NULL,1,1,1,NULL),(34,NULL,'2018-02-01 20:37:51',NULL,NULL,0,0,1,NULL),(35,NULL,'2018-02-01 20:37:56',NULL,NULL,1,1,1,NULL),(36,NULL,'2018-02-01 20:38:01',NULL,NULL,1,1,1,NULL),(37,NULL,'2018-02-01 20:38:12',NULL,NULL,0,0,1,NULL),(38,NULL,'2018-02-01 20:39:04',NULL,NULL,0,0,2,NULL),(39,NULL,'2018-02-01 20:39:09',NULL,NULL,0,0,1,NULL),(40,NULL,'2018-02-01 20:45:01',NULL,NULL,1,0,2,NULL),(41,1,'2018-02-01 21:06:51',NULL,NULL,1,0,1,NULL);
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record_spot`
--

DROP TABLE IF EXISTS `record_spot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record_spot` (
  `record_id` int(11) NOT NULL,
  `spot_id` int(11) NOT NULL,
  PRIMARY KEY (`record_id`,`spot_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record_spot`
--

LOCK TABLES `record_spot` WRITE;
/*!40000 ALTER TABLE `record_spot` DISABLE KEYS */;
INSERT INTO `record_spot` VALUES (1,1),(2,2),(4,1),(4,2),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(12,1),(13,1),(14,1),(15,1),(16,1),(17,1),(18,1),(19,1),(20,1),(21,1),(22,1),(23,1),(24,1),(25,1),(26,1),(27,1),(28,88),(29,3),(30,4),(31,5),(32,8),(33,9),(34,33),(35,38),(36,44),(37,52),(38,96),(39,105),(40,89),(41,6);
/*!40000 ALTER TABLE `record_spot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spot`
--

DROP TABLE IF EXISTS `spot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spot` (
  `spot_id` int(11) NOT NULL AUTO_INCREMENT,
  `row` int(11) DEFAULT NULL,
  `col` int(11) DEFAULT NULL,
  `available` int(1) NOT NULL DEFAULT '0',
  `parking_id` int(11) DEFAULT NULL,
  `spot_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`spot_id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spot`
--

LOCK TABLES `spot` WRITE;
/*!40000 ALTER TABLE `spot` DISABLE KEYS */;
INSERT INTO `spot` VALUES (1,1,1,0,1,1),(2,2,1,1,1,1),(3,3,1,1,1,1),(4,4,2,1,1,1),(5,5,2,1,1,1),(6,1,2,1,2,1),(7,2,3,1,2,2),(8,1,1,0,10,1),(9,1,2,0,10,1),(10,1,3,0,10,1),(11,1,4,0,10,1),(12,1,5,0,10,1),(13,1,6,0,10,1),(14,1,7,0,10,1),(15,1,8,0,10,1),(16,1,9,0,10,1),(17,1,10,0,10,1),(18,2,11,0,10,2),(19,2,12,0,10,2),(20,2,13,0,10,2),(21,2,14,0,10,2),(22,2,15,0,10,2),(23,3,16,0,10,1),(24,3,17,0,10,1),(25,3,18,0,10,1),(26,3,19,0,10,1),(27,3,20,0,10,1),(28,3,21,0,10,1),(29,3,22,0,10,1),(30,3,23,0,10,1),(31,3,24,0,10,1),(32,3,25,0,10,1),(33,3,26,0,10,1),(34,3,27,0,10,1),(35,3,28,0,10,1),(36,3,29,0,10,1),(37,3,30,0,10,1),(38,4,31,0,10,1),(39,4,32,0,10,1),(40,4,33,0,10,1),(41,4,34,0,10,1),(42,4,35,0,10,1),(43,4,36,0,10,1),(44,4,37,0,10,1),(45,4,38,0,10,1),(46,4,39,0,10,1),(47,4,40,0,10,1),(48,4,41,0,10,1),(49,4,42,0,10,1),(50,4,43,0,10,1),(51,4,44,0,10,1),(52,4,45,0,10,1),(53,4,46,0,10,1),(54,4,47,0,10,1),(55,4,48,0,10,1),(56,4,49,0,10,1),(57,4,50,0,10,1),(58,4,51,0,10,1),(59,4,52,0,10,1),(60,4,53,0,10,1),(61,5,54,0,10,2),(62,5,55,0,10,2),(63,5,56,0,10,2),(64,5,57,0,10,2),(65,5,58,0,10,2),(66,5,59,0,10,2),(67,5,60,0,10,2),(68,5,61,0,10,2),(69,5,62,0,10,2),(70,5,63,0,10,2),(71,5,64,0,10,2),(72,5,65,0,10,2),(73,1,1,0,23,1),(74,1,2,0,23,1),(75,1,3,0,23,1),(76,1,4,0,23,1),(77,2,5,0,23,2),(78,2,6,0,23,2),(79,2,7,0,23,2),(80,2,8,0,23,2),(81,2,9,0,23,2),(82,3,10,0,23,1),(83,3,11,0,23,1),(84,3,12,0,23,1),(85,3,13,0,23,1),(86,3,14,0,23,1),(87,3,15,0,23,1),(88,1,1,0,24,2),(89,1,2,1,24,2),(90,1,3,0,24,2),(91,1,4,0,24,2),(92,1,5,0,24,2),(93,1,6,1,24,2),(94,1,7,0,24,2),(95,1,8,0,24,2),(96,1,9,0,24,2),(97,1,10,0,24,2),(98,1,11,1,24,2),(99,1,12,0,24,2),(100,2,13,0,24,1),(101,2,14,0,24,1),(102,2,15,0,24,1),(103,2,16,0,24,1),(104,2,17,1,24,1),(105,2,18,1,24,1),(106,2,19,0,24,1),(107,2,20,0,24,1),(108,2,21,0,24,1),(109,2,22,0,24,1);
/*!40000 ALTER TABLE `spot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spot_type`
--

DROP TABLE IF EXISTS `spot_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spot_type` (
  `spot_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `price` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`spot_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spot_type`
--

LOCK TABLES `spot_type` WRITE;
/*!40000 ALTER TABLE `spot_type` DISABLE KEYS */;
INSERT INTO `spot_type` VALUES (1,'parking',NULL),(2,'hotel',NULL);
/*!40000 ALTER TABLE `spot_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `staff_id` int(11) NOT NULL,
  `staff_name` varchar(45) DEFAULT NULL,
  `staff_pass` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'mum','mum');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-01 21:39:03
