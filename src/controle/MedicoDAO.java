package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

import modelo.Especialidade;
import modelo.Medico;
import modelo.TipoUsuario;
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
		} finally {
			con.fecharConexao();
		}

		// desconectar
		return false;
	}

	public boolean alterar(Medico m) {
		con = Conexao.getInstancia();
		
		Connection co = con.conectar();

		try {
			String query = "UPDATE medico SET nome = ?, sexo = ?, pronome = ?, usuario_id_usuario = ?, especialidade_id_especialidade = ?  WHERE crm = ?";
			PreparedStatement stm = co.prepareStatement(query);
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
		} finally {
			con.fecharConexao();
		}
		return false;
	}

	public boolean deletar(Medico m) {
		con = Conexao.getInstancia();
		
		Connection co = con.conectar();
		
		try {
			String query = "DELETE FROM medico WHERE crm = ?;";
			PreparedStatement stm = co.prepareStatement(query);
			stm.setLong(1, m.getCrm());
			
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
				Integer idUsuario = rs.getInt("id_usuario");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				Integer tipoUsuario = rs.getInt("tipo_usuario");
				Integer idEspecialidade = rs.getInt("id_especialidade");
				String especialidade = rs.getString("especialidade");
				Double salario = rs.getDouble("salario");
				
				Medico m = new Medico();
				m.setCrm(crm);
				m.setCpf(cpf);
				m.setNome(nome);
				m.setSexo(sexo);
				m.setPronome(pronome);
				
				Usuario u = new Usuario();
				u.setId(idUsuario);
				u.setLogin(login);
				u.setSenha(senha);
				u.setTipo(TipoUsuario.ObterTipo(tipoUsuario));	
				m.setUsuario(u);
				
				Especialidade e = new Especialidade();
				e.setEspecialidade(especialidade);
				e.setId_especialidade(idEspecialidade);
				e.setSalario(salario);
				m.setEspecialidade(e);
				medicos.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		// desconectar
		return medicos;
	}

	
}
