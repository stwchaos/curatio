package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Especialidade;

public class EspecialidadeDAO {
	private Conexao con;
	
	public boolean inserir(Especialidade es) {
		// instanciar
				con = Conexao.getInstancia();

				// conectar
				Connection c = con.conectar();
				try {
					String query = "INSERT INTO especialidade (especialidade) VALUES (?);";
					PreparedStatement stm = c.prepareStatement(query);

					stm.setString(1, "Cardiologista");

					stm.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				// desconectar
				con.fecharConexao();
				return false;
	}
	
	public boolean alterar(Especialidade es) {
		Connection c = Conexao.getInstancia().conectar();

		try {
			String query = "UPDATE especialidade SET especialidade = ? WHERE id_especialidade = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, es.getEspecialidade());
			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.fecharConexao();
		return false;
	}
	
	public boolean deletar(Especialidade es) {
		return false;
	}
	
	public ArrayList<Especialidade> listarEspecialidade(){
		ArrayList<Especialidade> especialidades = new ArrayList();
		
		// instanciar
				con = Conexao.getInstancia();

		// conectar
		Connection co = con.conectar();
		
		try {
			Statement stm = co.createStatement();
			String query = "SELECT * FROM especialidade";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				Integer id_especialidade = rs.getInt("id_especialidade");
				String especialidade = rs.getString("especialidade");
				Especialidade e = new Especialidade();
				e.setId_especialidade(id_especialidade);
				e.setEspecialidade(especialidade);
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}

	// desconectar
	con.fecharConexao();
	return null;
			
		}
}

