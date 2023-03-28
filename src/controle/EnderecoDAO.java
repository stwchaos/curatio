package controle;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Consulta;
import modelo.Endereco;

public class EnderecoDAO {
	private Conexao con;

	public boolean inserir(Endereco en) {
		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO endereco (rua, cep, num_casa, complemento, cidade, bairro) VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, en.getRua());
			stm.setLong(2, en.getCep());
			stm.setFloat(3, en.getNumCasa());
			stm.setString(4,  en.getComplemento());
			stm.setString(5, en.getCidade());
			stm.setString(6, en.getBairro());

			stm.executeUpdate();
			return true;
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
			String query = "UPDATE endereco SET rua = ?, cep = ?, num_casa = ?, complemento = ?, cidade = ?, bairro = ? WHERE id_endereco = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, en.getRua());
			stm.setLong(2, en.getCep());
			stm.setFloat(3, en.getNumCasa());
			stm.setString(4, en.getComplemento());
			stm.setString(5, en.getCidade());
			stm.setString(6, en.getBairro());
			stm.setLong(7, en.getIdEndereco());

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
		ArrayList<Endereco> enderecos = new ArrayList<>();

		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();

		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM endereco";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Long idEndereco = rs.getLong("id_endereco");
				String rua = rs.getString("rua");
				Long cep = rs.getLong("cep");
				Integer numCasa = rs.getInt("num_casa");
				String complemento = rs.getString("complemento");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				Endereco en = new Endereco();
				en.setIdEndereco(idEndereco);
				en.setRua(rua);
				en.setCep(cep);
				en.setNumCasa(numCasa);
				en.setComplemento(complemento);
				en.setCidade(cidade);
				en.setBairro(bairro);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// desconectar
		con.fecharConexao();
		return enderecos;
	}
}
