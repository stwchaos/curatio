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
		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();

		try {
			String query = "UPDATE endereco SET rua = ?, complemento = ?, cidade = ?, bairro = ? WHERE id_endereco = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, en.getRua());
			stm.setString(2, en.getComplemento());
			stm.setString(3, en.getCidade());
			stm.setString(4, en.getBairro());
			stm.setLong(5, en.getIdEndereco());

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

	public Endereco BuscarEndereco(Endereco end) {
		con = Conexao.getInstancia();
		
		Connection c = con.conectar();
		
		Endereco en = new Endereco();
		try {
			String query = "SELECT * FROM endereco WHERE rua=? AND complemento=? AND cidade=? AND bairro=?;";
			PreparedStatement stm = c.prepareStatement(query);
			
			stm.setString(1, end.getRua());
			stm.setString(2, end.getComplemento());
			stm.setString(3, end.getCidade());
			stm.setString(4, end.getBairro());
			System.out.println(stm);
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				Long idEndereco = rs.getLong("id_endereco");
				String complemento = rs.getString("complemento");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String rua = rs.getString("rua");
				en.setIdEndereco(idEndereco);
				en.setRua(rua);
				en.setComplemento(complemento);
				en.setCidade(cidade);
				en.setBairro(bairro);
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return en;
	}
}
