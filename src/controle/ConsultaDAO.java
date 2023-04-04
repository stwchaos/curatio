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

public class ConsultaDAO {
	private Conexao con;
//TODO arrumar comandos sql
	public boolean inserir(Consulta c) {

		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection co = con.conectar();
		try {
			String query = "INSERT INTO consultas (data, objetivo, encerrada, pagamento_id_pagamento, profissionais_cpf_profissionais, paciente_cpf) VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement stm = co.prepareStatement(query);

			stm.setString(2, c.getObjetivo());
			stm.setInt(3, 0);
			stm.setInt(4, c.getPagamento().getIdPagamento());
			stm.setDouble(5, c.getMedico().getCrm());
			stm.setLong(6, c.getPaciente().getCpf());
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
			stm.setInt(4, c.getPagamento().getIdPagamento());

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
				Integer pagamento = rs.getInt("pagamento");
				String objetivo = rs.getString(""
				Consulta c = new Consulta();
				c.setIdConsulta(id_consulta);
				c.setData(data.toLocalDate());
				c.setEncerrada(encerrada);
				c.setObjetivo(pagamento);
				c.getPagamento().setIdPagamento("id_pagamento");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// desconectar
		con.fecharConexao();
		return null;
	}

}
