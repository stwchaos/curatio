package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static Connection conexao;
	private static Conexao instancia;
	private static final String DATABASE = "esmeralda";
	private static final String USER = "";
	private static final String PSW = "";
	
	private Conexao() {}
	
	public Conexao getInstancia() {
		if(instancia == null) {
			instancia = new Conexao();
		}
	return instancia;
	}
	
	public static Connection conectar() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/"+ DATABASE + "?serverTimeZone=UTC",USER,PSW);
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