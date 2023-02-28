package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private Connection conexao;
	private static Conexao instancia;
	private final String DATABASE = "esmeralda";
	private final String USER = "root";
	private final String PSW = "aluno";
	
	private Conexao() {}
	
	public static Conexao getInstancia() {
		if(instancia == null) {
			instancia = new Conexao();
		}
	return instancia;
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