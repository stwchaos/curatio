package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Anamnese;
import modelo.Medico;

 public class AnamneseDAO {

	
	private Conexao con;

	public boolean inserir(Anamnese a) {
		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO anamnese (queixa_principal, disposicao_geral, alergia, medicacoes_em_uso) VALUES (null, null, null, null);";
			PreparedStatement stm = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stm.executeUpdate();
			
			ResultSet rs= stm.getGeneratedKeys();
            if (rs.next()) 
            {
              a.setIdAnamnese(rs.getInt(1));
            }
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return false;
	}

 
	public boolean alterar(Anamnese a) {
		Connection c = Conexao.getInstancia().conectar();

		try {
			String query = "UPDATE anamnese SET queixa_principal = ?, diposicao_geral = ?, alergia = ?, medicacoes_em_uso = ? WHERE id_anamnese = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, a.getQueixaPrincipal());
			stm.setString(2, a.getDisposicaoGeral());
			stm.setString(3, a.getAlergia());
			stm.setString(4, a.getMedicacoesEmUso());
			stm.setInt(5, a.getIdAnamnese());
			

			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return false;
	}

	public boolean deletar(Medico p) {
		return false;
	}
 

 
 }
