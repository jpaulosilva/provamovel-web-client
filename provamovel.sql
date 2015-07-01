
CREATE TABLE IF NOT EXISTS `tb_usuario` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `cep` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;



CREATE TABLE IF NOT EXISTS `tb_endereco` (
  `cep` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `estado` varchar(255) NOT NULL,
  `rua` varchar(255) NOT NULL,
  PRIMARY KEY (`cep`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `tb_usuario` ADD `facebook_id` VARCHAR(255) NULL AFTER `id`;

ALTER TABLE `tb_usuario` CHANGE `senha` `senha` VARCHAR(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL, CHANGE `cep` `cep` VARCHAR(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL;