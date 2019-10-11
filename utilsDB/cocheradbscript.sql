-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: cocheradb
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cocheras` (
  `idCochera` int(11) NOT NULL AUTO_INCREMENT,
  `ubicacion` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idCochera`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cocheras`
--

LOCK TABLES `cocheras` WRITE;
/*!40000 ALTER TABLE `cocheras` DISABLE KEYS */;
INSERT INTO `cocheras` VALUES (1,'Zona Norte','2 pisos y acceso para vehiculos pesados'),(2,'Zona Sur','4 pisos para vehiculos livianos'),(3,'Zona Centro','2 pisos para vehiculos livianos');
/*!40000 ALTER TABLE `cocheras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `empleados` (
  `dni` varchar(8) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `email` varchar(90) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES ('12345678','Juan','Perez','jp@gmail.com','jp99','12345'),('33333333','Hernan','Juarez','hj@yahoo.com','hj96','24680'),('44444444','Lucas','Lopez','ll@hotmai.com','ll97','67890');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadias`
--

DROP TABLE IF EXISTS `estadias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `estadias` (
  `patente` varchar(7) NOT NULL,
  `idCochera` int(11) NOT NULL,
  `nroLugar` int(11) NOT NULL,
  `fechaIngreso` datetime NOT NULL,
  `fechaRetiro` datetime NOT NULL,
  `estado` varchar(45) NOT NULL,
  `precioFinal` decimal(5,0) DEFAULT NULL,
  PRIMARY KEY (`patente`,`idCochera`,`nroLugar`,`fechaIngreso`),
  KEY `fk_estadias1_idx` (`idCochera`,`nroLugar`),
  CONSTRAINT `fk_idCoch` FOREIGN KEY (`idCochera`) REFERENCES `cocheras` (`idCochera`),
  CONSTRAINT `fk_pat` FOREIGN KEY (`patente`) REFERENCES `vehiculos` (`patente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadias`
--

LOCK TABLES `estadias` WRITE;
/*!40000 ALTER TABLE `estadias` DISABLE KEYS */;
/*!40000 ALTER TABLE `estadias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jefes`
--

DROP TABLE IF EXISTS `jefes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `jefes` (
  `dni` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `email` varchar(90) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jefes`
--

LOCK TABLES `jefes` WRITE;
/*!40000 ALTER TABLE `jefes` DISABLE KEYS */;
/*!40000 ALTER TABLE `jefes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lugares`
--

DROP TABLE IF EXISTS `lugares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lugares` (
  `idCochera` int(11) NOT NULL,
  `nroLugar` int(11) NOT NULL,
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
/*!40000 ALTER TABLE `lugares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `multiplicadores_estadias`
--

DROP TABLE IF EXISTS `multiplicadores_estadias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `multiplicadores_estadias` (
  `multiplicadorDesde` int(11) NOT NULL,
  `porcentajeMultiplicador` decimal(3,0) NOT NULL,
  PRIMARY KEY (`multiplicadorDesde`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `multiplicadores_estadias`
--

LOCK TABLES `multiplicadores_estadias` WRITE;
/*!40000 ALTER TABLE `multiplicadores_estadias` DISABLE KEYS */;
/*!40000 ALTER TABLE `multiplicadores_estadias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `precio_por_hora`
--

DROP TABLE IF EXISTS `precio_por_hora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `precio_por_hora` (
  `precio` decimal(5,0) NOT NULL,
  PRIMARY KEY (`precio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `precio_por_hora`
--

LOCK TABLES `precio_por_hora` WRITE;
/*!40000 ALTER TABLE `precio_por_hora` DISABLE KEYS */;
/*!40000 ALTER TABLE `precio_por_hora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_turnos`
--

DROP TABLE IF EXISTS `tipos_turnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipos_turnos` (
  `idTipoTurno` int(11) NOT NULL,
  `descripcion` varchar(6) NOT NULL,
  PRIMARY KEY (`idTipoTurno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_turnos`
--

LOCK TABLES `tipos_turnos` WRITE;
/*!40000 ALTER TABLE `tipos_turnos` DISABLE KEYS */;
INSERT INTO `tipos_turnos` VALUES (1,'Mañana'),(2,'Tarde'),(3,'Noche');
/*!40000 ALTER TABLE `tipos_turnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_vehiculos`
--

DROP TABLE IF EXISTS `tipos_vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipos_vehiculos` (
  `idTipo` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_vehiculos`
--

LOCK TABLES `tipos_vehiculos` WRITE;
/*!40000 ALTER TABLE `tipos_vehiculos` DISABLE KEYS */;
INSERT INTO `tipos_vehiculos` VALUES (1,'Camioneta'),(2,'auto');
/*!40000 ALTER TABLE `tipos_vehiculos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turnos`
--

DROP TABLE IF EXISTS `turnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `turnos` (
  `idCochera` int(11) NOT NULL,
  `dni` varchar(8) NOT NULL,
  `idTipoTurno` int(11) NOT NULL,
  PRIMARY KEY (`dni`,`idCochera`,`idTipoTurno`),
  KEY `fk_cocheras_empleados2_idx` (`dni`),
  KEY `fk_cocheras_empleados1_idx` (`idCochera`),
  KEY `fk_cocheras_tipoTurno_idx` (`idTipoTurno`),
  CONSTRAINT `fk_coch_empleados2` FOREIGN KEY (`dni`) REFERENCES `empleados` (`dni`),
  CONSTRAINT `fk_cocheras_empleados1` FOREIGN KEY (`idCochera`) REFERENCES `cocheras` (`idCochera`),
  CONSTRAINT `fk_cocheras_tipoTurno` FOREIGN KEY (`idTipoTurno`) REFERENCES `tipos_turnos` (`idTipoTurno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turnos`
--

LOCK TABLES `turnos` WRITE;
/*!40000 ALTER TABLE `turnos` DISABLE KEYS */;
INSERT INTO `turnos` VALUES (1,'12345678',1),(1,'44444444',2),(2,'33333333',1),(2,'33333333',2),(3,'44444444',3);
/*!40000 ALTER TABLE `turnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculos`
--

DROP TABLE IF EXISTS `vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vehiculos` (
  `patente` varchar(7) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `idTipo` int(11) NOT NULL,
  PRIMARY KEY (`patente`),
  KEY `fk_vehiculos_idx` (`idTipo`),
  CONSTRAINT `fk_vehiculos` FOREIGN KEY (`idTipo`) REFERENCES `tipos_vehiculos` (`idTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculos`
--

LOCK TABLES `vehiculos` WRITE;
/*!40000 ALTER TABLE `vehiculos` DISABLE KEYS */;
INSERT INTO `vehiculos` VALUES ('124','147','auto 2 puertas','Fiat',2),('321','Megane','auto 2 puertas','Renault',2),('432','Ranger 2019','camioneta 2 puertas utilitaria','Ford',1);
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

-- Dump completed on 2019-10-11 14:17:38
