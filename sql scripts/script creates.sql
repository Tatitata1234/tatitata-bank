-- MySQL Script generated by MySQL Workbench
-- Mon Mar 11 23:20:26 2024
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
CREATE SCHEMA IF NOT EXISTS `tatitata_bank` DEFAULT CHARACTER SET utf8 ;
USE `tatitata_bank` ;

-- -----------------------------------------------------
-- Table `mydb`.`emprego`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tatitata_bank`.`emprego` ;

CREATE TABLE IF NOT EXISTS `tatitata_bank`.`emprego` (
  `id_emprego` BIGINT NOT NULL auto_increment,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `salario` NUMERIC NOT NULL,
  `data_inicial` TIMESTAMP NOT NULL,
  `data_final` TIMESTAMP NULL,
  `ativo` char not null  default 'S',
  PRIMARY KEY (`id_emprego`),
  UNIQUE INDEX `idemprego_UNIQUE` (`id_emprego` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`pessoa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tatitata_bank`.`pessoa` ;

CREATE TABLE IF NOT EXISTS `tatitata_bank`.`pessoa` (
  `id_pessoa` BIGINT NOT NULL auto_increment,
  `nome` VARCHAR(45) NOT NULL,
  `id_emprego` BIGINT NOT NULL,
  `apelido` VARCHAR(45) NULL,
  `ativo` char not null  default 'S',
  PRIMARY KEY (`id_pessoa`),
  UNIQUE INDEX `idpessoa_UNIQUE` (`id_pessoa` ASC) VISIBLE,
  INDEX `fk_pessoa_emprego_idx` (`id_emprego` ASC) VISIBLE,
  CONSTRAINT `fk_pessoa_emprego`
    FOREIGN KEY (`id_emprego`)
    REFERENCES `tatitata_bank`.`emprego` (`id_emprego`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tipo_registro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tatitata_bank`.`tipo_registro` ;

CREATE TABLE IF NOT EXISTS `tatitata_bank`.`tipo_registro` (
  `id_tipo_registro` BIGINT NOT NULL auto_increment,
  `nome` VARCHAR(45) NOT NULL,
  `entrada` CHAR NOT NULL,
  `ativo` char not null  default 'S',
  PRIMARY KEY (`id_tipo_registro`),
  UNIQUE INDEX `idtipo_registro_UNIQUE` (`id_tipo_registro` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`registro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tatitata_bank`.`registro` ;

CREATE TABLE IF NOT EXISTS `tatitata_bank`.`registro` (
  `id_registro` BIGINT NOT NULL auto_increment,
  `valor` NUMERIC(10,5) NOT NULL,
  `id_tipo_registro` BIGINT NOT NULL,
  `id_pessoa` BIGINT NOT NULL,
  `ativo` char not null default 'S',
  `competencia` timestamp not null, 
  PRIMARY KEY (`id_registro`),
  UNIQUE INDEX `idregistro_UNIQUE` (`id_registro` ASC) VISIBLE,
  INDEX `fk_pessoa_registro_idx` (`id_pessoa` ASC) VISIBLE,
  INDEX `fk_tipo_registro_registro_idx` (`id_tipo_registro` ASC) VISIBLE,
  CONSTRAINT `fk_pessoa_registro`
    FOREIGN KEY (`id_pessoa`)
    REFERENCES `tatitata_bank`.`pessoa` (`id_pessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipo_registro_registro`
    FOREIGN KEY (`id_tipo_registro`)
    REFERENCES `tatitata_bank`.`tipo_registro` (`id_tipo_registro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

select * from emprego
