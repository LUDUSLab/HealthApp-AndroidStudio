DROP TABLE IF EXISTS `historicomedicamento`;
CREATE TABLE IF NOT EXISTS `historicomedicamento` (
  `idHistoricoMedicamento` int(11) NOT NULL AUTO_INCREMENT,
  `horaPrevista` varchar(45) DEFAULT NULL,
  `horaReal` varchar(45) DEFAULT NULL,
  `statusMedicamento` varchar(45) DEFAULT NULL,
  `idMedicamento` int(11) NOT NULL,
  PRIMARY KEY (`idHistoricoMedicamento`)
);


DROP TABLE IF EXISTS `medicamento`;
CREATE TABLE IF NOT EXISTS `medicamento` (
  `idMedicamento` int(11) NOT NULL AUTO_INCREMENT,
  `nomeMedicamento` varchar(45) DEFAULT NULL,
  `qtdMedicamento` int(11) DEFAULT NULL,
  `corMedicamento` varchar(45) DEFAULT NULL,
  `horaMedicamento` varchar(45) DEFAULT NULL,
  `idTratamento` int(11) NOT NULL,
  PRIMARY KEY (`idMedicamento`)
);


DROP TABLE IF EXISTS `paciente`;
CREATE TABLE IF NOT EXISTS `paciente` (
  `idPaciente` int(11) NOT NULL AUTO_INCREMENT,
  `nomePaciente` varchar(45) DEFAULT NULL,
  `nDeRegistroDaUnidadeSaude` varchar(45) DEFAULT NULL,
  `cartaoNacionalDeSaude` varchar(45) DEFAULT NULL,
  `dataDeNascimento` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `tuberculose` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPaciente`)
);


DROP TABLE IF EXISTS `responsavel`;
CREATE TABLE IF NOT EXISTS `responsavel` (
  `idResponsavel` int(11) NOT NULL AUTO_INCREMENT,
  `nomeResponsavel` varchar(45) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idResponsavel`)
);


DROP TABLE IF EXISTS `tratamento`;
CREATE TABLE IF NOT EXISTS `tratamento` (
  `idTratamento` int(11) NOT NULL AUTO_INCREMENT,
  `nomeTratamento` varchar(40) NOT NULL,
  `dataInicio` varchar(45) DEFAULT NULL,
  `dataTermino` varchar(45) DEFAULT NULL,
  `idPaciente` int(11) NOT NULL,
  `idResponsavel` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTratamento`)
);