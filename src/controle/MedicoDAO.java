package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Especialidade;
import modelo.Medico;
import modelo.Usuario;

public class MedicoDAO {
	private Conexao con;

	public boolean inserir(Medico m) {
		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO medico (crm, nome, cpf, sexo, pronome, especialidade_id_especialidade, usuario_id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setLong(1, m.getCrm());
			stm.setString(2, m.getNome());
			stm.setLong(3, m.getCpf());
			stm.setString(4, m.getSexo());
			stm.setString(5, m.getPronome());
			stm.setLong(6, m.getEspecialidade().getId_especialidade());
			stm.setLong(7, m.getUsuario().getId());

			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// desconectar
		con.fecharConexao();
		return false;
	}

	public boolean alterar(Medico m) {
		Connection c = Conexao.getInstancia().conectar();

		try {
			String query = "UPDATE medico SET nome = ?, sexo = ?, pronome = ?, usuario_id_usuario = ?, especialidade_id_especialidade = ?  WHERE crm = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, m.getNome());
			stm.setString(2, m.getSexo());
			stm.setString(3, m.getPronome());
			stm.setLong(4, m.getUsuario().getId());
			stm.setLong(5, m.getEspecialidade().getId_especialidade());
			stm.setLong(6, m.getCrm());

			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.fecharConexao();
		return false;
	}

	public boolean deletar(Medico p) {
		return false;
	}

	public ArrayList<Medico> listarProfissionais() {
		ArrayList<Medico> medicos = new ArrayList<>();

		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();

		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM ((medico \r\n"
					+ " INNER JOIN usuario ON medico.usuario_id_usuario = usuario.id_usuario)\r\n"
					+ " INNER JOIN especialidade ON medico.especialidade_id_especialidade = especialidade.id_especialidade);";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Long crm = rs.getLong("crm");
				Long cpf = rs.getLong("cpf");
				String nome = rs.getString("nome");
				String sexo = rs.getString("sexo");
				String pronome = rs.getString("pronome");
				Long especialidadeId = rs.getLong("especialidade_id_especialidade");
				Long usuarioId = rs.getLong("usuario_id_usuario");
				
				Medico m = new Medico();
				Especialidade e = new Especialidade();
				Usuario u = new Usuario();
				m.setCrm(crm);
				m.setCpf(cpf);
				m.setNome(nome);
				m.setSexo(sexo);
				m.setPronome(pronome);
				m.setUsuario();
				medicos.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// desconectar
		con.fecharConexao();
		return medicos;
	}

	
}
