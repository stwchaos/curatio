package controle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

	private static Connection conexao;
	private static Conexao instancia;
	private static String URL = null, URL2 = null, USER = null, PSW = null, DATABASE = null;
	
	private Conexao() {}
	
	/**
	 * Singleton
	 * @return
	 */
	public static Conexao getInstancia() {
		if(instancia == null) {
			instancia = new Conexao();
			leArquioBD("credenciais.txt");
			criaBanco();
		}
	return instancia;
	}
	
	/**
	 * @param credenciais.txt
	 */
	public static void leArquioBD(String filename) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			if(reader!=null) {
				URL = reader.readLine();
				USER = reader.readLine();
				PSW = reader.readLine();
				DATABASE = reader.readLine();
				URL2 = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo: " + e.getMessage());
			return;
		}
	}
	
	public static void criaBanco() {
		try {
			conexao = DriverManager.getConnection(URL, USER, PSW);
			
			Statement stm = conexao.createStatement();
			
			String wsql = "CREATE DATABASE IF NOT EXISTS esmeralda;";
			stm.executeUpdate(wsql);
			
			wsql = "USE esmeralda;";
			stm.executeUpdate(wsql);
			
			wsql = "CREATE TABLE IF NOT EXISTS endereco(\r\n"
					+ "  id_endereco INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  rua VARCHAR(155) NOT NULL,\r\n"
					+ "  complemento VARCHAR(155) NULL,\r\n"
					+ "  cidade VARCHAR(45) NOT NULL,\r\n"
					+ "  bairro VARCHAR(45) NOT NULL,\r\n"
					+ "  PRIMARY KEY (id_endereco));";
			stm.executeUpdate(wsql);
			
			wsql = "CREATE TABLE IF NOT EXISTS paciente (\r\n"
					+ "  cpf BIGINT(12) NOT NULL,\r\n"
					+ "  nome VARCHAR(45) NOT NULL,\r\n"
					+ "  nascimento DATETIME NOT NULL,\r\n"
					+ "  telefone BIGINT(13) NULL,\r\n"
					+ "  sexo VARCHAR(45) NOT NULL,\r\n"
					+ "  nome_social VARCHAR(45) NULL,\r\n"
					+ "  email VARCHAR(45) NOT NULL,\r\n"
					+ "  pronome VARCHAR(20) NOT NULL,\r\n"
					+ "  endereco_id_endereco INT NOT NULL,\r\n"
					+ "  cep BIGINT(11) NOT NULL,\r\n"
					+ "  numero_casa INT NOT NULL,\r\n"
					+ "  PRIMARY KEY (cpf),\r\n"
					+ "    FOREIGN KEY (endereco_id_endereco)\r\n"
					+ "    REFERENCES endereco (id_endereco));";
			stm.executeUpdate(wsql);
					
			wsql = "CREATE TABLE IF NOT EXISTS especialidade(\r\n"
					+ "  id_especialidade INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  especialidade VARCHAR(45) NOT NULL,\r\n"
					+ "  salario DOUBLE NOT NULL,\r\n"
					+ "  PRIMARY KEY (id_especialidade));";
			stm.executeUpdate(wsql);
			
			wsql = "CREATE TABLE IF NOT EXISTS usuario  (\r\n"
					+ "  id_usuario INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  login VARCHAR(255) NOT NULL,\r\n"
					+ "  senha VARCHAR(45) NOT NULL,\r\n"
					+ "  tipo_usuario INT NOT NULL,\r\n"
					+ "  PRIMARY KEY (id_usuario));\r\n";
			stm.executeUpdate(wsql);
			
			wsql = "CREATE TABLE IF NOT EXISTS medico (\r\n"
					+ "  especialidade_id_especialidade INT NOT NULL,\r\n"
					+ "  crm VARCHAR(10) NOT NULL,\r\n"
					+ "  nome VARCHAR(45) NOT NULL,\r\n"
					+ "  cpf BIGINT(11) NOT NULL,\r\n"
					+ "  sexo VARCHAR(45) NOT NULL,\r\n"
					+ "  usuario_id_usuario INT NOT NULL,\r\n"
					+ "  pronome VARCHAR(20) NOT NULL,\r\n"
					+ "  PRIMARY KEY (crm, usuario_id_usuario),\r\n"
					+ "    FOREIGN KEY (especialidade_id_especialidade)\r\n"
					+ "    REFERENCES especialidade (id_especialidade),\r\n"
					+ "    FOREIGN KEY (usuario_id_usuario)\r\n"
					+ "    REFERENCES usuario (id_usuario));";
			stm.executeUpdate(wsql);
			
			wsql = "CREATE TABLE IF NOT EXISTS pagamento (\r\n"
					+ "  id_pagamento INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  forma_pagamento VARCHAR(45) NOT NULL,\r\n"
					+ "  data_pagamento DATETIME NOT NULL,\r\n"
					+ "  cpf_pagante BIGINT NOT NULL,\r\n"
					+ "  PRIMARY KEY (id_pagamento));";
			stm.executeUpdate(wsql);
			
			wsql = "CREATE TABLE IF NOT EXISTS consulta (\r\n"
					+ "  id_consulta INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  data DATETIME NOT NULL,\r\n"
					+ "  objetivo VARCHAR(45) NOT NULL,\r\n"
					+ "  encerrada TINYINT NOT NULL,\r\n"
					+ "  paciente_cpf BIGINT(12) NOT NULL,\r\n"
					+ "  medico_crm VARCHAR(10) NOT NULL,\r\n"
					+ "  pagamento_id_pagamento INT NOT NULL,\r\n"
					+ "  falta TINYINT NOT NULL,\r\n"
					+ "  PRIMARY KEY (id_consulta),\r\n"
					+ "    FOREIGN KEY (paciente_cpf)\r\n"
					+ "    REFERENCES paciente (cpf),\r\n"
					+ "    FOREIGN KEY (medico_crm)\r\n"
					+ "    REFERENCES medico (crm),\r\n"
					+ "    FOREIGN KEY (pagamento_id_pagamento)\r\n"
					+ "    REFERENCES pagamento (id_pagamento));";
			stm.executeUpdate(wsql);
			
			wsql = "CREATE TABLE IF NOT EXISTS funcionario (\r\n"
					+ "  nome VARCHAR(255) NOT NULL,\r\n"
					+ "  sexo VARCHAR(45) NOT NULL,\r\n"
					+ "  pronome VARCHAR(20) NOT NULL,\r\n"
					+ "  cpf BIGINT(11) NOT NULL,\r\n"
					+ "  usuario_id_usuario INT NOT NULL,\r\n"
					+ "  PRIMARY KEY (cpf),\r\n"
					+ "    FOREIGN KEY (usuario_id_usuario)\r\n"
					+ "    REFERENCES usuario (id_usuario));";
			stm.executeUpdate(wsql);
			
			wsql = "CREATE TABLE IF NOT EXISTS anamnese (\r\n"
					+ "  id_anamnese INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  queixa_principal VARCHAR(255) NULL,\r\n"
					+ "  disposicao_geral VARCHAR(255) NULL,\r\n"
					+ "  alergia VARCHAR(255) NULL,\r\n"
					+ "  medicacoes_em_uso VARCHAR(255) NULL,\r\n"
					+ "  historico_doenca_atual VARCHAR(255) NULL,\r\n"
					+ "  historico_patologico_prog VARCHAR(255) NULL,\r\n"
					+ "  historico_patologico_fam VARCHAR(255) NULL,\r\n"
					+ "  historico_social VARCHAR(255) NULL,\r\n"
					+ "  trata_anteriores VARCHAR(255) NULL,\r\n"
					+ "  trata_atuais VARCHAR(255) NULL,\r\n"
					+ "  exames_apresentados VARCHAR(255) NULL,\r\n"
					+ "  consulta_id_consulta INT NOT NULL,\r\n"
					+ "  PRIMARY KEY (id_anamnese),\r\n"
					+ "    FOREIGN KEY (consulta_id_consulta)\r\n"
					+ "    REFERENCES consulta (id_consulta));";
			stm.executeUpdate(wsql);
			
			wsql = "SET SQL_SAFE_UPDATES = 0;";
			stm.executeUpdate(wsql);
			
			String query = "SELECT * FROM usuario;";
			ResultSet rs = stm.executeQuery(query);
			if(!rs.next()) {
				wsql = "INSERT INTO usuario (login, senha, tipo_usuario) VALUES (123, 123, 3);";
				stm.executeUpdate(wsql);
			}
			
			query = "SELECT * FROM especialidade;";
			rs = stm.executeQuery(query);
			if(!rs.next()) {
				wsql = "INSERT INTO especialidade (especialidade, salario) VALUES ('Urologista', 4010.30), ('Cardiologista',4800.00),('Ginecologista',4200.10),('Alergista',3800.23),('Geriatra',3200.12),('Otorrinolaringologista', 2000.00),('Podologo',3600.50),('Oncologista',5000.00),('Neurologista',6650.23),('Endocrinologista',4323.87),('Fonodiologo',8455.67), ('Cirurgião',9000.50);";
				stm.executeUpdate(wsql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
	
	public Connection conectar() {
		try {
			conexao = DriverManager.getConnection(URL + DATABASE + URL2,USER,PSW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return conexao;
	
	}
	public static boolean fecharConexao() {
		
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	

}