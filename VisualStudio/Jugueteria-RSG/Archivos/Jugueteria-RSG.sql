-- MySQL Script generated by MySQL Workbench
-- Thu Dec 23 12:49:29 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jugueteria` DEFAULT CHARACTER SET utf8 ;
USE `jugueteria` ;

-- -----------------------------------------------------
-- Table `mydb`.`Juguetes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jugueteria`.`Juguetes` (
  `codigoJug` VARCHAR(25) NOT NULL,
  `nombreJug` VARCHAR(45) NOT NULL,
  `descripcionJug` TEXT NOT NULL,
  `imagenJug` LONGBLOB NOT NULL,
  `importeJug` decimal(10,2) NOT NULL,
  PRIMARY KEY (`CodigoJug`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;