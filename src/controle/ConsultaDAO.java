package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Consulta;
import modelo.Medico;
import modelo.Pagamento;

public class ConsultaDAO {
	private Conexao con;

	public boolean inserir(Consulta c) {

		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection co = con.conectar();
		try {
			String query = "INSERT INTO consultas (data, objetivo,encerrada, paciente_cpf,medico_crm,pagamento_idpagamento ) VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement stm = co.prepareStatement(query);

			stm.setString(2, c.getObjetivo());
			stm.setInt(3, 0);
			stm.setLong(4, c.getPaciente().getCpf());
			stm.setLong(5, c.getMedico().getCrm());
			stm.setInt(6, c.getPagamento().getIdPagamento());
			stm.setDate(1, Date.valueOf(c.getData()));

			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();

		}

		// desconectar
		con.fecharConexao();
		return false;
	}

	public boolean alterar(Consulta c) {
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

	public boolean deletar(Consulta c) {
		return false;
	}

	public ArrayList<Consulta> listarConsultas() {
		ArrayList<Consulta> consultas = new ArrayList<>();

		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection co = con.conectar();

		try {
			Statement stm = co.createStatement();
			String query = "SELECT * FROM consultas";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Integer id_consulta = rs.getInt("id_pendentes");
				Date data = rs.getDate("data");
				Boolean encerrada = rs.getBoolean("encerrada");
				String pagamento = rs.getString("pagamento");
				Consulta c = new Consulta();
				c.setId_consulta(id_consulta);
				c.setData(data.toLocalDate());
				c.setEncerrada(encerrada);
				c.setObjetivo(pagamento);
				Pagamento pag = new Pagamento();
				pag.setData_Pagamento(pagamento);
				pag.setFormaPagamento(pagamento);
				c.setPagamento(pag);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// desconectar
		con.fecharConexao();
		return null;
	}

}
