CREATE DATABASE esmeralda;
USE esmeralda;

-- -----------------------------------------------------
-- Table `esmeralda`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS endereco (
  cep VARCHAR(10) NOT NULL,
  PRIMARY KEY (cep));


-- -----------------------------------------------------
-- Table `esmeralda`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS paciente (
  cpf BIGINT(12) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  nascimento DATETIME NOT NULL,
  telefone INT NULL,
  sexo VARCHAR(45) NOT NULL,
  nome_social VARCHAR(45) NULL,
  email VARCHAR(45) NOT NULL,
  endereco_cep VARCHAR(10) NOT NULL,
  PRIMARY KEY (cpf),
    FOREIGN KEY (endereco_cep) REFERENCES endereco (cep));


-- -----------------------------------------------------
-- Table `esmeralda`.`especialidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS especialidade (
  id_especialidade INT NOT NULL AUTO_INCREMENT,
  especialidade VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_especialidade));


-- -----------------------------------------------------
-- Table `esmeralda`.`profissionais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS profissionais (
  especialidade_id_especialidade INT NOT NULL,
  cpf_profissionais BIGINT(12) NOT NULL,
  nome_profissionais VARCHAR(45) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  PRIMARY KEY (cpf_profissionais),
    FOREIGN KEY (especialidade_id_especialidade)
    REFERENCES especialidade (id_especialidade));


-- -----------------------------------------------------
-- Table `esmeralda`.`consultas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS consultas(
  id_pendentes INT NOT NULL AUTO_INCREMENT,
  data DATETIME NOT NULL,
  objetivo VARCHAR(45) NOT NULL,
  encerrada TINYINT NOT NULL,
  paciente_cpf BIGINT(12) NOT NULL,
  pagamento VARCHAR(45) NOT NULL,
  profissionais_cpf_profissionais BIGINT(12) NOT NULL,
  PRIMARY KEY (id_pendentes),
    FOREIGN KEY (paciente_cpf)
    REFERENCES paciente (cpf),
    FOREIGN KEY (profissionais_cpf_profissionais)
    REFERENCES profissionais (cpf_profissionais));
