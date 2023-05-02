package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Funcionario;

public class FuncionarioDAO {

	private Conexao con;

	public boolean inserir(Funcionario f) {
		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO Funcionario (nome,pronome,sexo,cpf,data_nascimento) VALUES (?, ?, ?, ?);";
			PreparedStatement stm = c.prepareStatement(query);
			
			stm.setString(1,f.getNome());
			stm.setString(2,f.getPronome());
			stm.setString(3,f.getSexo());
			stm.setLong(4,f.getCpf());
			stm.setDate(5,Date.valueOf(f.getDataNascimento()));
			
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
			String query = "UPDATE medico SET nome = ?, pronome = ?, sexo = ?, cpf = ?, data_nascimento = ?,  usuario_id_usuario = ?  WHERE id_funcionario = ?";
			PreparedStatement stm = co.prepareStatement(query);
			
			stm.setString(1,f.getNome());
			stm.setString(2,f.getPronome());
			stm.setString(3,f.getSexo());
			stm.setLong(4,f.getCpf());
			stm.setDate(5,Date.valueOf(f.getDataNascimento()));
			stm.setLong(6,f.getUsuario().getId());
			stm.setLong(7,f.getIdFuncionario());

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
			String query = "DELETE FROM funcionario WHERE id_funcionario = ?;";
			PreparedStatement stm = co.prepareStatement(query);
			stm.setLong(1,f.getIdFuncionario());
			
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
	
	
	
}
