package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Especialidade;
import modelo.Funcionario;
import modelo.Medico;
import modelo.TipoUsuario;
import modelo.Usuario;

public class FuncionarioDAO {

	private Conexao con;

	public boolean inserir(Funcionario f) {
		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO funcionario (nome,pronome,sexo,cpf) VALUES (?, ?, ?, ?);";
			PreparedStatement stm = c.prepareStatement(query);
			
			stm.setString(1,f.getNome());
			stm.setString(2,f.getPronome());
			stm.setString(3,f.getSexo());
			stm.setLong(4,f.getCpf());
		
			
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

	public boolean alterar(Funcionario f) {
		con = Conexao.getInstancia();
		
		Connection co = con.conectar();

		try {
			String query = "UPDATE funcionario SET nome = ?, pronome = ?, sexo = ?,usuario_id_usuario = ?  WHERE cpf = ?";
			PreparedStatement stm = co.prepareStatement(query);
			
			stm.setString(1,f.getNome());
			stm.setString(2,f.getPronome());
			stm.setString(3,f.getSexo());
			stm.setLong(4,f.getUsuario().getId());
			
			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return false;
	}
	
	public boolean deletar(Funcionario f) {
		con = Conexao.getInstancia();
		
		Connection co = con.conectar();
		
		try {
			String query = "DELETE FROM funcionario WHERE cpf = ?;";
			PreparedStatement stm = co.prepareStatement(query);
			stm.setLong(1,f.getCpf());
			
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
	
	public ArrayList<Funcionario> listarFuncionarios() {
		ArrayList<Funcionario> funcionarios = new ArrayList<>();

		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();

		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM funcionario INNER JOIN usuario ON funcionario.usuario_id_usuario = usuario.id_usuario";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				String nome = rs.getString("nome");
				String sexo = rs.getString("sexo");
				String pronome = rs.getString("pronome");
				Long cpf = rs.getLong("cpf");
				Integer idUsuario = rs.getInt("id_usuario");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				Integer tipoUsuario = rs.getInt("tipo_usuario");

				Funcionario f = new Funcionario();
				f.setCpf(cpf);
				f.setNome(nome);
				f.setPronome(pronome);
				f.setSexo(sexo);
				
				Usuario u = new Usuario();
				u.setId(idUsuario);
				u.setLogin(login);
				u.setSenha(senha);
				u.setTipo(TipoUsuario.ObterTipo(tipoUsuario));	
				f.setUsuario(u);
				
				funcionarios.add(f);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return funcionarios;
	}
	
}
