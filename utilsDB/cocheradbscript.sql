-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cocheradb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cocheradb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cocheradb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `cocheradb` ;

-- -----------------------------------------------------
-- Table `cocheradb`.`cocheras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cocheradb`.`cocheras` (
  `idCochera` INT(11) NOT NULL auto_increment,
  `ubicacion` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCochera`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cocheradb`.`empleados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cocheradb`.`empleados` (
  `dni` INT(8) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `email` VARCHAR(90) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`dni`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cocheradb`.`cocheras_empleados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cocheradb`.`cocheras_empleados` (
  `idCochera` INT(11) NOT NULL,
  `dni` INT(8) NOT NULL,
  `turno` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCochera`,`dni`),
  INDEX `fk_cocheras_empleados2_idx` (`dni` ASC) VISIBLE,
  INDEX `fk_cocheras_empleados1_idx` (`idCochera` ASC) VISIBLE,
  CONSTRAINT `fk_cocheras_empleados1`
    FOREIGN KEY (`idCochera`)
    REFERENCES `cocheradb`.`cocheras` (`idCochera`),
  CONSTRAINT `fk_cocheras_empleados2`
    FOREIGN KEY (`dni`)
    REFERENCES `cocheradb`.`empleados` (`dni`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cocheradb`.`tipos_vehiculos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cocheradb`.`tipos_vehiculos` (
  `idTipo` INT(11) NOT NULL  auto_increment,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cocheradb`.`vehiculos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cocheradb`.`vehiculos` (
  `patente` varchar(7) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `idTipo` INT(11) NOT NULL,
  PRIMARY KEY (`patente`),
  INDEX `fk_vehiculos_idx` (`idTipo` ASC) VISIBLE,
  CONSTRAINT `fk_vehiculos`
    FOREIGN KEY (`idTipo`)
    REFERENCES `cocheradb`.`tipos_vehiculos` (`idTipo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cocheradb`.`estadias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cocheradb`.`estadias` (
  `patente` varchar(7) NOT NULL,
  `idCochera` INT(11) NOT NULL,
  `nroLugar` INT(11) NOT NULL,
  `fechaIngreso` DATETIME NOT NULL,
  `fechaRetiro` DATETIME NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `precioFinal` DECIMAL(5,2) NULL DEFAULT NULL,
  PRIMARY KEY (`patente`, `idCochera`, `nroLugar`, `fechaIngreso`),
  INDEX `fk_estadias1_idx` (`idCochera` ASC, `nroLugar` ASC) VISIBLE,
  CONSTRAINT `fk_estadias2`
    FOREIGN KEY (`patente`)
    REFERENCES `cocheradb`.`vehiculos` (`patente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cocheradb`.`jefes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cocheradb`.`jefes` (
  `dni` INT(8) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `email` VARCHAR(90) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`dni`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cocheradb`.`lugares`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cocheradb`.`lugares` (
  `idCochera` INT(11) NOT NULL,
  `nroLugar` INT(11) NOT NULL auto_increment,
  `ocupado` bit NOT NULL,
  PRIMARY KEY (`idCochera`, `nroLugar`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cocheradb`.`multiplicadores_estadias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cocheradb`.`multiplicadores_estadias` (
  `multiplicadorDesde` INT(11) NOT NULL,
  `porcentajeMultiplicador` DECIMAL(3,0) NOT NULL,
  PRIMARY KEY (`multiplicadorDesde`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cocheradb`.`precio_por_hora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cocheradb`.`precio_por_hora` (
  `precio` DECIMAL(5,2) NOT NULL,
  PRIMARY KEY (`precio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
