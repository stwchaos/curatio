package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

	private Connection conexao;
	private static Conexao instancia;
	private final String DATABASE = "esmeralda";
	private final String USER = "root";
	private final String PSW = "aluno";
	
	private Conexao() {}
	
	/**
	 * Singleton
	 * @return
	 */
	public static Conexao getInstancia() {
		if(instancia == null) {
			instancia = new Conexao();
		}
	return instancia;
	}
	
	public void criaBanco() {
		final String user = "root", psw = "aluno";
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/", user, psw);
			
			Statement stm = conexao.createStatement();
			
			String wsql = "CREATE DATABASE esmeralda;";
			stm.executeUpdate(wsql);
			
			wsql = "USE esmeralda;";
			stm.executeUpdate(wsql);
			
			wsql = "CREATE TABLE IF NOT EXISTS endereco("
					+ "  id_endereco INT NOT NULL AUTO_INCREMENT,"
					+ "  rua VARCHAR(155) NOT NULL,"
					+ "  cep BIGINT(11) NOT NULL,"
					+ "  numero_casa INT NOT NULL,"
					+ "  complemento VARCHAR(155) NULL,"
					+ "  cidade VARCHAR(45) NOT NULL,"
					+ "  bairro VARCHAR(45) NOT NULL,"
					+ " PRIMARY KEY (id_endereco));";
			stm.executeUpdate(wsql);
			
			wsql = "CREATE TABLE IF NOT EXISTS paciente("
					+ "  cpf BIGINT(12) NOT NULL,"
					+ "  nome VARCHAR(45) NOT NULL,"
					+ "  nascimento DATETIME NOT NULL,"
					+ "  telefone INT NULL,"
					+ "  sexo VARCHAR(45) NOT NULL,"
					+ "  nome_social VARCHAR(45) NULL,"
					+ "  email VARCHAR(45) NOT NULL,"
					+ "  pronome VARCHAR(20) NOT NULL,"
					+ "  endereco_id_endereco INT NOT NULL,"
					+ "  PRIMARY KEY (cpf),"
					+ "    FOREIGN KEY (endereco_id_endereco)"
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
			
			wsql = "CREATE TABLE IF NOT EXISTS medico(\r\n"
					+ "  especialidade_id_especialidade INT NOT NULL,\r\n"
					+ "  crm BIGINT(6) NOT NULL,\r\n"
					+ "  nome VARCHAR(45) NOT NULL,\r\n"
					+ "  cpf BIGINT(11) NOT NULL,\r\n"
					+ "  sexo VARCHAR(45) NOT NULL,\r\n"
					+ " usuario_id_usuario INT NOT NULL,\r\n"
					+ "  pronome VARCHAR(20) NOT NULL,\r\n"
					+ "  PRIMARY KEY (crm),\r\n"
					+ "    FOREIGN KEY (especialidade_id_especialidade)\r\n"
					+ "    REFERENCES especialidade (id_especialidade),\r\n"
					+ "    FOREIGN KEY (usuario_id_usuario)\r\n"
					+ "    REFERENCES usuario (id_usuario));";
			stm.executeUpdate(wsql);
			
			wsql = "CREATE TABLE IF NOT EXISTS funcionario (\r\n"
					+ "  id_funcionario INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  nome VARCHAR(255) NOT NULL,\r\n"
					+ "  sexo VARCHAR(45) NOT NULL,\r\n"
					+ "  telefone BIGINT NOT NULL,\r\n"
					+ "  data_nascimento DATE NOT NULL,\r\n"
					+ "  usuario_id_usuario INT NOT NULL,\r\n"
					+ "  PRIMARY KEY (idfuncionario),\r\n"
					+ "  \r\n"
					+ "    FOREIGN KEY (usuario_id_usuario)\r\n"
					+ "    REFERENCES usuario (id_usuario));";
			stm.executeUpdate(wsql);
			
			wsql = "CREATE TABLE IF NOT EXISTS pagamento(\r\n"
					+ "  id_pagamento INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  forma_pagamento VARCHAR(45) NOT NULL,\r\n"
					+ "  data_pagamento DATETIME NOT NULL,\r\n"
					+ "  paciente_cpf BIGINT(12) NOT NULL,\r\n"
					+ "  PRIMARY KEY (idpagamento),\r\n"
					+ "    FOREIGN KEY (paciente_cpf)\r\n"
					+ "    REFERENCES paciente (cpf));\r\n";
			stm.executeUpdate(wsql);
			
			wsql = "CREATE TABLE IF NOT EXISTS consulta (\r\n"
					+ "  id_pendentes INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  data DATETIME NOT NULL,\r\n"
					+ "  objetivo VARCHAR(45) NOT NULL,\r\n"
					+ "  encerrada TINYINT NOT NULL,\r\n"
					+ "  paciente_cpf BIGINT(12) NOT NULL,\r\n"
					+ "  medico_crm BIGINT(6) NOT NULL,\r\n"
					+ "  pagamento_idpagamento INT NOT NULL,\r\n"
					+ "  PRIMARY KEY (id_pendentes),\r\n"
					+ "    FOREIGN KEY (paciente_cpf)\r\n"
					+ "    REFERENCES paciente (cpf),\r\n"
					+ "    FOREIGN KEY (medico_crm)\r\n"
					+ "    REFERENCES medico (crm),\r\n"
					+ "    FOREIGN KEY (pagamento_idpagamento)\r\n"
					+ "    REFERENCES pagamento (idpagamento));";
			stm.executeUpdate(wsql);
			
			Connection c = conectar();
			String query = "INSERT INTO usuario (login, senha, tipo_usuario) VALUES (?, ?, ?);";
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setString(1, "123");
			pstm.setString(2, "123");
			pstm.setInt(3, 1);
			
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection conectar() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/"+ DATABASE + "?serverTimeZone=UTC",USER,PSW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return conexao;
	
	}
	public boolean fecharConexao() {
		
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	

}