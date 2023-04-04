package controle;

import modelo.Pagamento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PagamentoDAO {
	private Conexao con;
	
	public boolean inserir(Pagamento p) {
		
		con = Conexao.getInstancia();
		
		Connection c = con.conectar();
		
		try {
			String query = "INSERT INTO pagamento (forma_pagamento,data_pagamento) VALUES (?,?);";
			PreparedStatement stm = c.prepareStatement(query);
			
			stm.setString(1,p.getFormaPagamento());
			stm.setDate(2, Date.valueOf(p.getData_Pagamento()));
			
			stm.executeUpdate();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
			
		return false;
	}
		
	}
	
