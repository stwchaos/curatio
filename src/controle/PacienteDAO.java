package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Anamnese;
import modelo.Endereco;
import modelo.Especialidade;
import modelo.Medico;
import modelo.Paciente;
import modelo.TipoUsuario;
import modelo.Usuario;

public class PacienteDAO {
	private Conexao con;

	public boolean inserir(Paciente p) {
		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO paciente (cpf, nome, nascimento, telefone, sexo, nome_social, email, pronome, endereco_id_endereco, cep, numero_casa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setLong(1, p.getCpf());
			stm.setString(2, p.getNome());
			stm.setDate(3, Date.valueOf(p.getNascimento()));
			stm.setLong(4, p.getTelefone());
			stm.setString(5, p.getSexo());
			stm.setString(6, p.getNomeSocial());
			stm.setString(7, p.getEmail());
			stm.setString(8, p.getPronome());
			stm.setDouble(9, p.getEndereco().getIdEndereco());
			stm.setDouble(10, p.getCep());
			stm.setDouble(11, p.getNumCasa());

			stm.executeUpdate();
			
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// desconectar
			con.fecharConexao();
		}

		return false;
	}

	public boolean alterar(Paciente p) {
		Connection c = Conexao.getInstancia().conectar();

		try {
			String query = "UPDATE paciente SET nome = ?, nascimento = ?, telefone = ?, sexo = ?, nome_social = ?, email = ?, pronome = ?, endereco_id_endereco = ?, cep = ?, numero_casa = ? WHERE cpf = ?;";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, p.getNome());
			stm.setDate(2, Date.valueOf(p.getNascimento()));
			stm.setLong(3, p.getTelefone());
			stm.setString(4, p.getSexo());
			stm.setString(5, p.getNomeSocial());
			stm.setString(6, p.getEmail());
			stm.setString(7, p.getPronome());
			stm.setDouble(8, p.getEndereco().getIdEndereco());
			stm.setLong(9, p.getCep());
			stm.setLong(10, p.getNumCasa());
			stm.setLong(11, p.getCpf());

			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return false;
	}

	public boolean deletar(Paciente p) {
		con = Conexao.getInstancia();
		
		Connection co = con.conectar();
		
		try {
			String query = "DELETE FROM paciente WHERE cpf = ?;";
			PreparedStatement stm = co.prepareStatement(query);
			stm.setLong(1, p.getCpf());
			
			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return false;
	}

	public ArrayList<Paciente> listarPacientes() {
		ArrayList<Paciente> pacientes = new ArrayList<>();

		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();

		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM paciente INNER JOIN endereco ON paciente.endereco_id_endereco = endereco.id_endereco;";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Long cpf = rs.getLong("cpf");
				String nome = rs.getString("nome");
				Date nascimento = rs.getDate("nascimento");
				Long telefone = rs.getLong("telefone");
				String sexo = rs.getString("sexo");
				String nomeSocial = rs.getString("nome_social");
				String email = rs.getString("email");
				String pronome = rs.getString("pronome");
				Long idEndereco = rs.getLong("id_endereco");
				String rua = rs.getString("rua");
				Long cep = rs.getLong("cep");
				Integer numCasa = rs.getInt("numero_casa");
				String complemento = rs.getString("complemento");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				
				Paciente p = new Paciente();
				p.setCpf(cpf);
				p.setNome(nome);
				p.setNascimento(nascimento.toLocalDate());
				p.setTelefone(telefone);
				p.setSexo(sexo);
				p.setNomeSocial(nomeSocial);
				p.setEmail(email);
				p.setPronome(pronome);
				p.setCep(cep);
				p.setNumCasa(numCasa);
				
				Endereco e = new Endereco();
				e.setBairro(bairro);
				e.setCidade(cidade);
				e.setComplemento(complemento);
				e.setIdEndereco(idEndereco);
				e.setRua(rua);
				p.setEndereco(e);
				
				pacientes.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return pacientes;
	}
	public ArrayList<Paciente> listarPesquisa(String pesquisa){
		ArrayList<Paciente> pacientes = new ArrayList<>();

		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();

		try {
			String query = "SELECT * FROM (paciente INNER JOIN endereco ON paciente.endereco_id_endereco = endereco.id_endereco) WHERE nome LIKE ? or nome_social LIKE ?;";
			
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, "%"+pesquisa+"%");
			stm.setString(2, "%"+pesquisa+"%");

			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				Long cpf = rs.getLong("cpf");
				String nome = rs.getString("nome");
				Date nascimento = rs.getDate("nascimento");
				Long telefone = rs.getLong("telefone");
				String sexo = rs.getString("sexo");
				String nomeSocial = rs.getString("nome_social");
				String email = rs.getString("email");
				String pronome = rs.getString("pronome");
				Long idEndereco = rs.getLong("id_endereco");
				String rua = rs.getString("rua");
				Long cep = rs.getLong("cep");
				Integer numCasa = rs.getInt("numero_casa");
				String complemento = rs.getString("complemento");
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				
				Paciente p = new Paciente();
				p.setCpf(cpf);
				p.setNome(nome);
				p.setNascimento(nascimento.toLocalDate());
				p.setTelefone(telefone);
				p.setSexo(sexo);
				p.setNomeSocial(nomeSocial);
				p.setEmail(email);
				p.setPronome(pronome);
				p.setCep(cep);
				p.setNumCasa(numCasa);
				
				Endereco e = new Endereco();
				e.setBairro(bairro);
				e.setCidade(cidade);
				e.setComplemento(complemento);
				e.setIdEndereco(idEndereco);
				e.setRua(rua);
				p.setEndereco(e);
				
				pacientes.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return pacientes;
	}
}


