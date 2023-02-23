package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Consultas;
import modelo.Profissionais;

public class ConsultasDAO {
	private Conexao con;

	public boolean inserir(Consultas c) {
		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection co = con.conectar();
		try {
			String query = "INSERT INTO consultas (data, objetivo, encerrada, pagamento) VALUES (?, ?, ?, ?);";
			PreparedStatement stm = co.prepareStatement(query);

			stm.setDate(1, Date.valueOf(LocalDate.of(2000, 01, 01)));
			stm.setString(2, "Transplante de coração");
			stm.setBoolean(3, true);
			stm.setString(4, "Cartão de Crédito");

			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// desconectar
		con.fecharConexao();
		return false;
	}

	public boolean alterar(Consultas c) {
		Connection co = Conexao.getInstancia().conectar();

		try {
			String query = "UPDATE consultas SET data = ?, objetivo = ?, encerrada = ?, pagamento = ? WHERE id_pendentes = ?";
			PreparedStatement stm = co.prepareStatement(query);
			stm.setDate(1, Date.valueOf(c.getData()));
			stm.setString(2, c.getObjetivo());
			stm.setBoolean(3, c.getEncerrada());
			stm.setString(4, c.getPagamento());

			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.fecharConexao();
		return false;
	}

	public boolean deletar(Consultas c) {
		return false;
	}

	public ArrayList<Consultas> listarConsultas() {
		ArrayList<Consultas> consultas = new ArrayList<>();

		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection co = con.conectar();

		try {
			Statement stm = co.createStatement();
			String query = "SELECT * FROM consultas";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Date data = rs.getDate("data");
				Boolean encerrada = rs.getBoolean("encerrada");
				String pagamento = rs.getString("pagamento");
				Consultas c = new Consultas();
				c.setData(data.toLocalDate());
				c.setEncerrada(encerrada);
				c.setObjetivo(pagamento);
				c.setPagamento(pagamento);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// desconectar
		con.fecharConexao();
		return null;
	}

}
