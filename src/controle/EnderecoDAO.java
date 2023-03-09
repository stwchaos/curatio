package controle;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Consultas;
import modelo.Endereco;

public class EnderecoDAO {
	private Conexao con;

	public boolean inserir(Endereco en) {
		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO endereco (cep) VALUES (?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setLong(1, 123456);

			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// desconectar
		con.fecharConexao();
		return false;
	}

	public boolean alterar(Endereco en) {
		Connection c = Conexao.getInstancia().conectar();

		try {
			String query = "UPDATE endereco SET cep = ? WHERE cep = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, en.getCep());

			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.fecharConexao();
		return false;
	}

	public boolean deletar(Endereco en) {
		return false;
	}

	public ArrayList<Endereco> listarEndereco() {
		ArrayList<Endereco> endereco = new ArrayList<>();

		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();

		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM endereco";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Long cep = rs.getLong("cep");
				Endereco en = new Endereco();
				en.setCep(cep);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// desconectar
		con.fecharConexao();
		return null;
	}
}
