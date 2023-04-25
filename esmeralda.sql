
CREATE DATABASE esmeralda;
USE esmeralda;

-- -----------------------------------------------------
-- Table `esmeralda`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS endereco(
  id_endereco INT NOT NULL AUTO_INCREMENT,
  rua VARCHAR(155) NOT NULL,
  complemento VARCHAR(155) NULL,
  cidade VARCHAR(45) NOT NULL,
  bairro VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_endereco));


-- -----------------------------------------------------
-- Table `esmeralda`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS anamnese(
  id_anamnese INT NOT NULL AUTO_INCREMENT,
  queixa_principial VARCHAR(255) ,
  disposicao_geral VARCHAR(255) ,
  alergia VARCHAR(255) ,
  medicacoes_em_uso VARCHAR(255) ,
  PRIMARY KEY (id_anamnese));
 
 
CREATE TABLE IF NOT EXISTS paciente(
  cpf BIGINT(12) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  nascimento DATETIME NOT NULL,
  telefone BIGINT NULL,
  sexo VARCHAR(45) NOT NULL,
  nome_social VARCHAR(45) NULL,
  email VARCHAR(45) NOT NULL,
  pronome VARCHAR(20) NOT NULL,
  endereco_id_endereco INT NOT NULL,
  anamnese_id_anamnese INT NOT NULL,
  cep BIGINT(11) NOT NULL,
  numero_casa INT NOT NULL,
  PRIMARY KEY (cpf, anamnese_id_anamnese),
	FOREIGN KEY (endereco_id_endereco)
    REFERENCES endereco(id_endereco),
    FOREIGN KEY (anamnese_id_anamnese)
    REFERENCES anamnese(id_anamnese));
-- Table `esmeralda`.`especialidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS especialidade(
  id_especialidade INT NOT NULL AUTO_INCREMENT,
  especialidade VARCHAR(45) NOT NULL,
  salario DOUBLE NOT NULL,
  PRIMARY KEY (id_especialidade));
-- -----------------------------------------------------
-- Table `esmeralda`.` usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS usuario  (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  login VARCHAR(255) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  tipo_usuario INT NOT NULL,
  PRIMARY KEY (id_usuario));

-- -----------------------------------------------------
-- Table `esmeralda`.`medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS medico(
  especialidade_id_especialidade INT NOT NULL,
  crm BIGINT(6) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  cpf BIGINT(11) NOT NULL,
  sexo VARCHAR(45) NOT NULL,
 usuario_id_usuario INT NOT NULL,
  pronome VARCHAR(20) NOT NULL,
  PRIMARY KEY (crm,  usuario_id_usuario),
    FOREIGN KEY (especialidade_id_especialidade)
    REFERENCES especialidade (id_especialidade),
    FOREIGN KEY (usuario_id_usuario)
    REFERENCES usuario (id_usuario));
    
-- -----------------------------------------------------
-- Table `esmeralda`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS funcionario (
  idfuncionario INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  sexo VARCHAR(45) NOT NULL,
  telefone BIGINT NOT NULL,
  data_nascimento DATE NOT NULL,
  usuario_id_usuario INT NOT NULL,
  PRIMARY KEY (idfuncionario,usuario_id_usuario),
    FOREIGN KEY (usuario_id_usuario)
    REFERENCES usuario (id_usuario));
    
    
    -- -----------------------------------------------------
-- Table `esmeralda`.`pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS pagamento(
  idpagamento INT NOT NULL AUTO_INCREMENT,
  forma_pagamento VARCHAR(45) NOT NULL,
  data_pagamento DATETIME NOT NULL,
  paciente_cpf BIGINT(12) NOT NULL,
  PRIMARY KEY (idpagamento),
    FOREIGN KEY (paciente_cpf)
    REFERENCES paciente (cpf));
    
    -- -----------------------------------------------------
-- Table `esmeralda`.`consulta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS consulta (
  id_pendentes INT NOT NULL AUTO_INCREMENT,
  data DATETIME NOT NULL,
  objetivo VARCHAR(45) NOT NULL,
  encerrada TINYINT NOT NULL,
  paciente_cpf BIGINT(12) NOT NULL,
  medico_crm BIGINT(6) NOT NULL,
  pagamento_idpagamento INT NOT NULL,
  PRIMARY KEY (id_pendentes),
    FOREIGN KEY (paciente_cpf)
    REFERENCES paciente (cpf),
    FOREIGN KEY (medico_crm)
    REFERENCES medico (crm),
    FOREIGN KEY (pagamento_idpagamento)
    REFERENCES pagamento (idpagamento));