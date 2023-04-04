package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Endereco;

public class EnderecoDAO {
	private Conexao con;

	public int inserir(Endereco en) {
		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();
		int last_inserted_id = 0;
		try {
			String query = "INSERT INTO endereco (rua, cep, numero_casa, complemento, cidade, bairro) VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement stm = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stm.setString(1, en.getRua());
			stm.setLong(2, en.getCep());
			stm.setFloat(3, en.getNumCasa());
			stm.setString(4, en.getComplemento());
			stm.setString(5, en.getCidade());
			stm.setString(6, en.getBairro());

			int retorno = stm.executeUpdate();

			if (retorno == 0) {
				
			} else {
				ResultSet rs = stm.getGeneratedKeys();
				if (rs.next()) {
					last_inserted_id = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return last_inserted_id;
	}

	public boolean alterar(Endereco en) {
		Connection c = Conexao.getInstancia().conectar();

		try {
			String query = "UPDATE endereco SET rua = ?, cep = ?, numero_casa = ?, complemento = ?, cidade = ?, bairro = ? WHERE id_endereco = ?";
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
				Integer numCasa = rs.getInt("numero_casa");
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
				enderecos.add(en);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// desconectar
		con.fecharConexao();
		return enderecos;
	}
}
