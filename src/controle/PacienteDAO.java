package controle;

import modelo.Paciente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class PacienteDAO {
	private Conexao con;

	public boolean inserir(Paciente p) {
		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO pessoa (cpf, nome, nascimento, telefone, sexo, nome_social, email) VALUES (?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setLong(1, 123);
			stm.setString(2, "PacienteTeste");
			stm.setDate(3, Date.valueOf(LocalDate.of(2000, 01, 01)));
			stm.setString(5, "Cadeira");
			stm.setString(7, "teste@gmail.com");

			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// desconectar
		con.fecharConexao();
		return false;
	}

	public boolean alterar(Paciente p) {
		Connection c = Conexao.getInstancia().conectar();

		try {
			String query = "UPDATE paciente SET nome = ?, nascimento = ?, telefone = ?, sexo = ?, nome_social = ?, email = ? WHERE cpf = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, p.getNome());
			stm.setLong(2, p.getCpf());
			stm.setDate(3, Date.valueOf(p.getNascimento()));
			stm.setLong(4, p.getTelefone());
			stm.setString(5, p.getSexo());
			stm.setString(6, p.getNomeSocial());
			
			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.fecharConexao();
		return false;
	}

	public boolean deletar(Paciente p) {
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
			String query = "SELECT * FROM paciente";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Long cpf = rs.getLong("cpf");
				String nome = rs.getString("nome");
				Date nascimento = rs.getDate("nascimento");
				Integer telefone = rs.getInt("telefone");
				String sexo = rs.getString("sexo");
				String nomeSocial = rs.getString("nome_social");
				String email = rs.getString("email");
				Paciente p = new Paciente();
				p.setCpf(cpf);
				p.setNome(nome);
				p.setNascimento(nascimento.toLocalDate());
				p.setTelefone(telefone);
				p.setSexo(sexo);
				p.setNomeSocial(nomeSocial);
				p.setEmail(email);
				pacientes.add(p);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// desconectar
		con.fecharConexao();
		return pacientes;
	}
}
