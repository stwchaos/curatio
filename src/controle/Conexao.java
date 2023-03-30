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
			
			String wsql = "CREATE  DATABASE IF NOT EXISTS esmeralda;";
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
					+ "  PRIMARY KEY (id_funcionario),\r\n"
					+ "  \r\n"
					+ "    FOREIGN KEY (usuario_id_usuario)\r\n"
					+ "    REFERENCES usuario (id_usuario));";
			stm.executeUpdate(wsql);
			
			wsql = "CREATE TABLE IF NOT EXISTS pagamento(\r\n"
					+ "  id_pagamento INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  forma_pagamento VARCHAR(45) NOT NULL,\r\n"
					+ "  data_pagamento DATETIME NOT NULL,\r\n"
					+ "  paciente_cpf BIGINT(12) NOT NULL,\r\n"
					+ "  PRIMARY KEY (id_pagamento),\r\n"
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
					+ "  pagamento_id_pagamento INT NOT NULL,\r\n"
					+ "  PRIMARY KEY (id_pendentes),\r\n"
					+ "    FOREIGN KEY (paciente_cpf)\r\n"
					+ "    REFERENCES paciente (cpf),\r\n"
					+ "    FOREIGN KEY (medico_crm)\r\n"
					+ "    REFERENCES medico (crm),\r\n"
					+ "    FOREIGN KEY (pagamento_id_pagamento)\r\n"
					+ "    REFERENCES pagamento (id_pagamento));";
			stm.executeUpdate(wsql);
			
			Connection c = conectar();
			wsql = "INSERT INTO usuario (login, senha, tipo_usuario) VALUES (123, 123, 1);";
			stm.executeUpdate(wsql);
			wsql = "INSERT INTO especialidade (especialidade, salario) VALUES (\"Urologista\", 4010.30), (\"Cardiologista\",4800.00),(\"Ginecologista\",4200.10),(\"Alergista\",3800.23),(\"Geriatra\",3200.12),(\"Otorrino\"),(\"Podologo\",3600.50),(\"Oncologista\",5000.00),(\"Neurologista\",6650.23),(\"Endocrinologista\",4323.87),(\"Fonodiologo\",8455.67), (\"Cirurgião\",9000.50);";
			stm.executeUpdate(wsql);
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