package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Medico;
import modelo.Usuario;

public class UsuarioDAO {
	private Conexao con;

	public boolean inserir(Usuario u) {
		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO usuario (login, senha, tipo_usuario) VALUES (?, ?, ?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, u.getLogin());
			stm.setString(2, u.getSenha());
			stm.setInt(3, u.getTipo());

			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// desconectar
		con.fecharConexao();
		return false;
	}

	public boolean alterar(Usuario u) {
		Connection c = Conexao.getInstancia().conectar();

		try {
			String query = "UPDATE usuario SET login = ?, senha = ?, tipo_usuario = ? WHERE id_usuario = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, u.getLogin());
			stm.setString(2, u.getSenha());
			stm.setInt(3, u.getTipo());
			stm.setLong(4, u.getIdUsuario());
			
			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.fecharConexao();
		return false;
	}

	public boolean deletar(Usuario u) {
		return false;
	}

	public ArrayList<Usuario> listarUsuario() {
		ArrayList<Usuario> usuarios = new ArrayList<>();

		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();

		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM usuario";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Long id = rs.getLong("id_usuario");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				Integer tipo = rs.getInt("tipo_usuario");
				Usuario u = new Usuario();
				u.setIdUsuario(id);;
				u.setLogin(login);
				u.setSenha(senha);
				u.setTipo(tipo);
				usuarios.add(u);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// desconectar
		con.fecharConexao();
		return usuarios;
	}
	
	public Usuario efetuarLogin(String login, String senha) {
		Usuario usuario = null;
		for (Usuario u : listarUsuario()) {
			if ((u.getLogin().equals(login)) && (u.getSenha().equals(senha))) {
				usuario = u;
			}
		}
		return usuario;
	}
}
