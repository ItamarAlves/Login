# MySQL-Front 5.0  (Build 1.0)

DROP DATABASE IF EXISTS `crazyhack`;
CREATE DATABASE `crazyhack` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `crazyhack`;

#
# Table structure for table usuario
#

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `login` varchar(40) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
INSERT INTO `usuario` VALUES (1,'administrator','adm','adm123');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

CREATE TABLE `diretorio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `diretorio` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
INSERT INTO `diretorio` VALUES (1,'/index?acao=listarProdutos');
/*!40000 ALTER TABLE `diretorio` ENABLE KEYS */;
UNLOCK TABLES;

CREATE TABLE `produto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) DEFAULT NULL,
  `marca` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
INSERT INTO `produto` VALUES (1,'GUITARRA FLOYD 2 MG-230','MEMPHIS');
INSERT INTO `produto` VALUES (2,'GUITARRA LES PAUL','SHELTER');
INSERT INTO `produto` VALUES (3,'GUITARRA STRATOCASTER','FENDER');
INSERT INTO `produto` VALUES (4,'GUITARRA EXPLORER','GIBSON');
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;
