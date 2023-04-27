package controle;

import modelo.Pagamento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PagamentoDAO {
	private Conexao con;
	
	public boolean inserir(Pagamento p) {
		
		con = Conexao.getInstancia();
		
		Connection c = con.conectar();
		
		try {
			String query = "INSERT INTO pagamento (forma_pagamento, data_pagamento, cpf_pagante) VALUES (?, ?, ?);";
			PreparedStatement stm = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			stm.setString(1, p.getFormaPagamento());
			stm.setDate(2, Date.valueOf(p.getData_Pagamento()));
			stm.setLong(3, p.getCpfPagante());
			
			stm.executeUpdate();
			
			ResultSet rs= stm.getGeneratedKeys();
            if (rs.next()) 
            {
              p.setIdPagamento(rs.getInt(1));;
            }    
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
			
		return false;
	}
		
	}
	
