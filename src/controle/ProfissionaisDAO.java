package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Paciente;
import modelo.Profissionais;

public class ProfissionaisDAO {
	private Conexao con;

	public boolean inserir(Profissionais p) {
		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO profissionais (cpf_profissionais, nome_profissionais, senha) VALUES (?, ?, ?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setLong(1, 123);
			stm.setString(2, "ProfissionalTeste");
			stm.setString(3, "admin");

			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// desconectar
		con.fecharConexao();
		return false;
	}

	public boolean alterar(Profissionais p) {
		Connection c = Conexao.getInstancia().conectar();

		try {
			String query = "UPDATE paciente SET nome_profissionais = ?, senha = ? WHERE cpf_profissionais = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, p.getNomeProfissionais());
			stm.setLong(2, p.getCpfProfissionais());
			stm.setString(3, p.getSenha());

			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.fecharConexao();
		return false;
	}

	public boolean deletar(Profissionais p) {
		return false;
	}

	public ArrayList<Profissionais> listarProfissionais() {
		ArrayList<Profissionais> profissionais = new ArrayList<>();

		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();

		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM profissionais";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Long cpf = rs.getLong("cpf_profissionais");
				String nome = rs.getString("nome_profissionais");
				String senha = rs.getString("senha");
				Profissionais p = new Profissionais();
				p.setCpfProfissionais(cpf);
				p.setNomeProfissionais(nome);
				p.setSenha(senha);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// desconectar
		con.fecharConexao();
		return null;
	}

}
