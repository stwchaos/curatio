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
					String query = "INSERT INTO especialidade (especialidade, salario) VALUES (?, ?);";
					PreparedStatement stm = c.prepareStatement(query);

					stm.setString(1, es.getEspecialidade());
					stm.setDouble(1, es.getSalario());

					stm.executeUpdate();
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return false;
	}
	
	public boolean alterar(Especialidade es) {
		Connection c = Conexao.getInstancia().conectar();

		try {
			String query = "UPDATE especialidade SET especialidade = ?, salario = ? WHERE id_especialidade = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, es.getEspecialidade());
			stm.setDouble(2, es.getSalario());
			stm.setInt(1, es.getIdEspecialidade());
			
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
				Double salario = rs.getDouble("salario");
				Especialidade e = new Especialidade();
				e.setIdEspecialidade(id_especialidade);
				e.setEspecialidade(especialidade);
				e.setSalario(salario);
				especialidades.add(e);
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}

	// desconectar
	return especialidades;
			
		}
}

