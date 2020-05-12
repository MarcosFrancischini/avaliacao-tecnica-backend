-- -----------------------------------------------------
-- Criação do banco de dados
-- -----------------------------------------------------
CREATE DATABASE `avaliacao`;
USE `avaliacao`;

-- -----------------------------------------------------
-- Schema da avaliação técnica
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `avaliacao`;

CREATE SCHEMA `avaliacao`;
USE `avaliacao`;

-- -----------------------------------------------------
-- Tabela `categoria_cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `categoria_cursos` (
  `codigo` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Tabela `cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cursos` (
  `codigo` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) DEFAULT NULL,
  `data_inicio` DATETIME(6) DEFAULT NULL,
  `data_termino` DATETIME(6) DEFAULT NULL,
  `codigo_categoria` BIGINT(20) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_categoria` (`codigo_categoria`),
  CONSTRAINT `fk_categoria` FOREIGN KEY (`codigo_categoria`) REFERENCES `categoria_cursos` (`codigo`)
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Adicionando alguns cursos
-- -----------------------------------------------------

INSERT INTO categoria_cursos(CODIGO, DESCRICAO) VALUES(1, 'Comportamental');
INSERT INTO categoria_cursos(CODIGO, DESCRICAO) VALUES(2, 'Programação');
INSERT INTO categoria_cursos(CODIGO, DESCRICAO) VALUES(3, 'Qualidade');
INSERT INTO categoria_cursos(CODIGO, DESCRICAO) VALUES(4, 'Processos');

INSERT INTO cursos(DESCRICAO, DATA_INICIO, DATA_TERMINO, CODIGO_CATEGORIA)
VALUES('Comunicação 1', '2020-05-18 08:00:00', '2020-05-25 17:00:00', 1);

INSERT INTO cursos(DESCRICAO, DATA_INICIO, DATA_TERMINO, CODIGO_CATEGORIA)
VALUES('Java 1', '2020-05-26 08:00:00', '2020-06-02 17:00:00', 2);

INSERT INTO cursos(DESCRICAO, DATA_INICIO, DATA_TERMINO, CODIGO_CATEGORIA)
VALUES('Testes 1', '2020-06-03 08:00:00', '2020-06-10 17:00:00', 3);

INSERT INTO cursos(DESCRICAO, DATA_INICIO, DATA_TERMINO, CODIGO_CATEGORIA)
VALUES('DevOps 1', '2020-06-11 08:00:00', '2020-06-18 17:00:00', 4);


