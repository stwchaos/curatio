package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Medico;
import modelo.TipoUsuario;
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
			PreparedStatement stm = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stm.setString(1, u.getLogin());
			stm.setString(2, u.getSenha());
			stm.setInt(3, u.getTipo().tipo);
			stm.executeUpdate();
			
            ResultSet rs= stm.getGeneratedKeys();
            if (rs.next()) 
            {
              u.setId(rs.getInt(1));
            }

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}

		// desconectar
	
		return false;
	}

	public boolean alterar(Usuario u) {
		Connection c = Conexao.getInstancia().conectar();

		try {
			String query = "UPDATE usuario SET login = ?, senha = ?, tipo_usuario = ? WHERE id_usuario = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setString(1, u.getLogin());
			stm.setString(2, u.getSenha());
			stm.setInt(3, u.getTipo().tipo);
			stm.setLong(4, u.getId());
			
			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}

		return false;
	}

	public boolean deletar(Usuario u) {
		con = Conexao.getInstancia();
		
		Connection co = con.conectar();
		
		try {
			String query = "DELETE FROM usuario WHERE id_usuario = ?;";
			PreparedStatement stm = co.prepareStatement(query);
			stm.setLong(1, u.getId());
			
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
				Integer id = rs.getInt("id_usuario");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				Integer tipo = rs.getInt("tipo_usuario");
				Usuario u = new Usuario();
				u.setId(id);
				u.setLogin(login);
				u.setSenha(senha);
				u.setTipo(TipoUsuario.ObterTipo(tipo));
				usuarios.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}

		// desconectar
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
