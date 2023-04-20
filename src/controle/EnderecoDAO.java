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

	public boolean inserir(Endereco en) {
		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO endereco (rua, complemento, cidade, bairro) VALUES (?, ?, ?, ?);";
			PreparedStatement stm = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stm.setString(1, en.getRua());
			stm.setString(2, en.getComplemento());
			stm.setString(3, en.getCidade());
			stm.setString(4, en.getBairro());

			stm.executeUpdate();
			
			ResultSet rs= stm.getGeneratedKeys();
            if (rs.next()) 
            {
              en.setIdEndereco(rs.getLong(1));;
            }
            return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return false;
	}

	public boolean alterar(Endereco en) {
		Connection c = Conexao.getInstancia().conectar();

		try {
			String query = "UPDATE endereco SET rua = ?, complemento = ?, cidade = ?, bairro = ? WHERE id_endereco = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, en.getRua());
			stm.setString(4, en.getComplemento());
			stm.setString(5, en.getCidade());
			stm.setString(6, en.getBairro());
			stm.setLong(7, en.getIdEndereco());

			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
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
				Long cep = rs.getLong("cep");
				String complemento = rs.getString("complemento");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String rua = rs.getString("rua");
				Endereco en = new Endereco();
				en.setIdEndereco(idEndereco);
				en.setRua(rua);
				en.setComplemento(complemento);
				en.setCidade(cidade);
				en.setBairro(bairro);
				enderecos.add(en);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return enderecos;
	}
}
