CREATE DATABASE  IF NOT EXISTS `cocheras` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cocheras`;
-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: 127.0.0.1    Database: cocheras
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `cocheras`
--

DROP TABLE IF EXISTS `cocheras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cocheras` (
  `idCochera` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `ubicacion` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `capacidad` int NOT NULL,
  `eliminado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idCochera`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cocheras`
--

LOCK TABLES `cocheras` WRITE;
/*!40000 ALTER TABLE `cocheras` DISABLE KEYS */;
INSERT INTO `cocheras` VALUES (0,'La del Norte','Zona Norte','2 pisos y acceso para vehiculos pesados',120, null),(1,'La del Sur','Zona Sur','4 pisos para vehiculos livianos',37,null),(2,'La Cocheria','Zona Centro','2 pisos para vehiculos livianos',70,null);
/*!40000 ALTER TABLE `cocheras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `dni` varchar(8) NOT NULL,
  `idCochera` int DEFAULT NULL,
  `idTurno` int DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `email` varchar(90) NOT NULL,
  `telefono1` varchar(45) DEFAULT NULL,
  `telefono2` varchar(45) DEFAULT NULL,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`dni`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `usuario` (`usuario`),
  KEY `fk_cochera_emp_idx` (`idCochera`),
  KEY `fk_empleado_turno_idx` (`idTurno`),
  CONSTRAINT `fk_empleado_cochera` FOREIGN KEY (`idCochera`) REFERENCES `cocheras` (`idCochera`),
  CONSTRAINT `fk_empleado_turno` FOREIGN KEY (`idTurno`) REFERENCES `turnos` (`idTurno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES ('11111111',0,1,'Franco','Giannassi','drazerjx@gmail.com','753421869','682435179','drazerjx','12345'),('22222222',0,2,'Martin','Oliva','martinoliva@gmail.com','123456789','124567892','zileanswagger','54321'),('33333333',1,3,'Vittorio','Retrivi','retrovitto@gmail.com','2477582031','159263487','motiontx','24680');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingresos`
--

DROP TABLE IF EXISTS `ingresos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingresos` (
  `idIngreso` int NOT NULL AUTO_INCREMENT,
  `comprobante` varchar(45) NOT NULL,
  `tipoIngreso` varchar(45) NOT NULL,
  `idCochera` int NOT NULL,
  `nroLugar` int NOT NULL,
  `patente` varchar(7) NOT NULL,
  `fechaIngreso` datetime NOT NULL,
  `fechaRetiro` datetime DEFAULT NULL,
  `estado` varchar(45) NOT NULL,
  `precioFinal` float DEFAULT NULL,
  `autoEnCochera` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idIngreso`),
  KEY `fk_ingresos_nroLugar_idx` (`nroLugar`),
  KEY `fk_ingresos_cochera_idx` (`idCochera`),
  KEY `fk_ingresos_patente_idx` (`patente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresos`
--

LOCK TABLES `ingresos` WRITE;
/*!40000 ALTER TABLE `ingresos` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingresos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jefes`
--

DROP TABLE IF EXISTS `jefes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jefes` (
  `email` varchar(90) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jefes`
--

LOCK TABLES `jefes` WRITE;
/*!40000 ALTER TABLE `jefes` DISABLE KEYS */;
INSERT INTO `jefes` VALUES ('super@admin.com','Super','Admin','12345');
/*!40000 ALTER TABLE `jefes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lugares`
--

DROP TABLE IF EXISTS `lugares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lugares` (
  `idCochera` int NOT NULL,
  `nroLugar` int NOT NULL,
  `ocupado` varchar(5) NOT NULL,
  PRIMARY KEY (`idCochera`,`nroLugar`),
  CONSTRAINT `fk_cochID` FOREIGN KEY (`idCochera`) REFERENCES `cocheras` (`idCochera`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lugares`
--

LOCK TABLES `lugares` WRITE;
/*!40000 ALTER TABLE `lugares` DISABLE KEYS */;
INSERT INTO `lugares` VALUES (0,1,'false'),(0,2,'false'),(0,3,'false'),(0,4,'false'),(0,5,'false'),(0,6,'false'),(0,7,'false'),(0,8,'false'),(0,9,'false'),(0,10,'false'),(0,11,'false'),(0,12,'false'),(0,13,'false'),(0,14,'false'),(0,15,'false'),(0,16,'false'),(0,17,'false'),(0,18,'false'),(0,19,'false'),(0,20,'false'),(0,21,'false'),(0,22,'false'),(0,23,'false'),(0,24,'false'),(0,25,'false'),(0,26,'false'),(0,27,'false'),(0,28,'false'),(0,29,'false'),(0,30,'false'),(0,31,'false'),(0,32,'false'),(0,33,'false'),(0,34,'false'),(0,35,'false'),(0,36,'false'),(0,37,'false'),(0,38,'false'),(0,39,'false'),(0,40,'false'),(0,41,'false'),(0,42,'false'),(0,43,'false'),(0,44,'false'),(0,45,'false'),(0,46,'false'),(0,47,'false'),(0,48,'false'),(0,49,'false'),(0,50,'false'),(0,51,'false'),(0,52,'false'),(0,53,'false'),(0,54,'false'),(0,55,'false'),(0,56,'false'),(0,57,'false'),(0,58,'false'),(0,59,'false'),(0,60,'false'),(0,61,'false'),(0,62,'false'),(0,63,'false'),(0,64,'false'),(0,65,'false'),(0,66,'false'),(0,67,'false'),(0,68,'false'),(0,69,'false'),(0,70,'false'),(0,71,'false'),(0,72,'false'),(0,73,'false'),(0,74,'false'),(0,75,'false'),(0,76,'false'),(0,77,'false'),(0,78,'false'),(0,79,'false'),(0,80,'false'),(0,81,'false'),(0,82,'false'),(0,83,'false'),(0,84,'false'),(0,85,'false'),(0,86,'false'),(0,87,'false'),(0,88,'false'),(0,89,'false'),(0,90,'false'),(0,91,'false'),(0,92,'false'),(0,93,'false'),(0,94,'false'),(0,95,'false'),(0,96,'false'),(0,97,'false'),(0,98,'false'),(0,99,'false'),(0,100,'false'),(0,101,'false'),(0,102,'false'),(0,103,'false'),(0,104,'false'),(0,105,'false'),(0,106,'false'),(0,107,'false'),(0,108,'false'),(0,109,'false'),(0,110,'false'),(0,111,'false'),(0,112,'false'),(0,113,'false'),(0,114,'false'),(0,115,'false'),(0,116,'false'),(0,117,'false'),(0,118,'false'),(0,119,'false'),(0,120,'false'),(1,1,'false'),(1,2,'false'),(1,3,'false'),(1,4,'false'),(1,5,'false'),(1,6,'false'),(1,7,'false'),(1,8,'false'),(1,9,'false'),(1,10,'false'),(1,11,'false'),(1,12,'false'),(1,13,'false'),(1,14,'false'),(1,15,'false'),(1,16,'false'),(1,17,'false'),(1,18,'false'),(1,19,'false'),(1,20,'false'),(1,21,'false'),(1,22,'false'),(1,23,'false'),(1,24,'false'),(1,25,'false'),(1,26,'false'),(1,27,'false'),(1,28,'false'),(1,29,'false'),(1,30,'false'),(1,31,'false'),(1,32,'false'),(1,33,'false'),(1,34,'false'),(1,35,'false'),(1,36,'false'),(1,37,'false'),(2,1,'false'),(2,2,'false'),(2,3,'false'),(2,4,'false'),(2,5,'false'),(2,6,'false'),(2,7,'false'),(2,8,'false'),(2,9,'false'),(2,10,'false'),(2,11,'false'),(2,12,'false'),(2,13,'false'),(2,14,'false'),(2,15,'false'),(2,16,'false'),(2,17,'false'),(2,18,'false'),(2,19,'false'),(2,20,'false'),(2,21,'false'),(2,22,'false'),(2,23,'false'),(2,24,'false'),(2,25,'false'),(2,26,'false'),(2,27,'false'),(2,28,'false'),(2,29,'false'),(2,30,'false'),(2,31,'false'),(2,32,'false'),(2,33,'false'),(2,34,'false'),(2,35,'false'),(2,36,'false'),(2,37,'false'),(2,38,'false'),(2,39,'false'),(2,40,'false'),(2,41,'false'),(2,42,'false'),(2,43,'false'),(2,44,'false'),(2,45,'false'),(2,46,'false'),(2,47,'false'),(2,48,'false'),(2,49,'false'),(2,50,'false'),(2,51,'false'),(2,52,'false'),(2,53,'false'),(2,54,'false'),(2,55,'false'),(2,56,'false'),(2,57,'false'),(2,58,'false'),(2,59,'false'),(2,60,'false'),(2,61,'false'),(2,62,'false'),(2,63,'false'),(2,64,'false'),(2,65,'false'),(2,66,'false'),(2,67,'false'),(2,68,'false'),(2,69,'false'),(2,70,'false');
/*!40000 ALTER TABLE `lugares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `multiplicadores_estadias`
--

DROP TABLE IF EXISTS `multiplicadores_estadias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `multiplicadores_estadias` (
  `multiplicadorDesde` int NOT NULL,
  `porcentajeMultiplicador` float NOT NULL,
  PRIMARY KEY (`multiplicadorDesde`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `multiplicadores_estadias`
--

LOCK TABLES `multiplicadores_estadias` WRITE;
/*!40000 ALTER TABLE `multiplicadores_estadias` DISABLE KEYS */;
INSERT INTO `multiplicadores_estadias` VALUES (3,0.9),(6,0.8),(12,0.7),(24,0.6);
/*!40000 ALTER TABLE `multiplicadores_estadias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `precio_por_hora`
--

DROP TABLE IF EXISTS `precio_por_hora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `precio_por_hora` (
  `idPrecio` varchar(45) NOT NULL,
  `precio` float NOT NULL,
  PRIMARY KEY (`idPrecio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `precio_por_hora`
--

LOCK TABLES `precio_por_hora` WRITE;
/*!40000 ALTER TABLE `precio_por_hora` DISABLE KEYS */;
INSERT INTO `precio_por_hora` VALUES ('1',60);
/*!40000 ALTER TABLE `precio_por_hora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_vehiculos`
--

DROP TABLE IF EXISTS `tipos_vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos_vehiculos` (
  `idTipo` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `porcentajeMultiplicador` float NOT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_vehiculos`
--

LOCK TABLES `tipos_vehiculos` WRITE;
/*!40000 ALTER TABLE `tipos_vehiculos` DISABLE KEYS */;
INSERT INTO `tipos_vehiculos` VALUES (1,'Auto',1),(2,'Camioneta',1.2),(3,'Motocicleta',0.8),(4,'Bicicleta',0.6),(5,'Camión',2.5);
/*!40000 ALTER TABLE `tipos_vehiculos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turnos`
--

DROP TABLE IF EXISTS `turnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turnos` (
  `idTurno` int NOT NULL,
  `descripcion` varchar(6) NOT NULL,
  `horaInicio` time NOT NULL,
  `horaFin` time NOT NULL,
  PRIMARY KEY (`idTurno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turnos`
--

LOCK TABLES `turnos` WRITE;
/*!40000 ALTER TABLE `turnos` DISABLE KEYS */;
INSERT INTO `turnos` VALUES (1,'Mañana','04:00:00','12:00:00'),(2,'Tarde','12:00:00','20:00:00'),(3,'Noche','20:00:00','04:00:00');
/*!40000 ALTER TABLE `turnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculos`
--

DROP TABLE IF EXISTS `vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculos` (
  `patente` varchar(7) NOT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `idTipo` int NOT NULL,
  `propietario` varchar(45) DEFAULT NULL,
  `telefonoContacto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`patente`),
  KEY `fk_vehiculo_idx` (`idTipo`),
  CONSTRAINT `fk_vehiculo` FOREIGN KEY (`idTipo`) REFERENCES `tipos_vehiculos` (`idTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculos`
--

LOCK TABLES `vehiculos` WRITE;
/*!40000 ALTER TABLE `vehiculos` DISABLE KEYS */;
INSERT INTO `vehiculos` VALUES ('GKD-280','Megane','Auto 2 puertas','Renault',1,'Gonzalez, Rodrigo','+5493411376456'),('ICI-350','Ranger 2019','Camioneta 2 puertas utilitaria','Ford',2,'Juarez, Hernan','+5493417865123'),('MKG-462','Zr 150','Moto blanca con asiento negro','Zanella',3,'Abril, Fisher','+5493412459871'),('NAS-570','147','Auto 2 puertas','Fiat',1,'Perez, Gerardo','+5493418512659');
/*!40000 ALTER TABLE `vehiculos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-19 20:08:20
