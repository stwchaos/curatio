package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;
import modelo.Pagamento;

public class ConsultaDAO {
	private Conexao con;

	public boolean inserir(Consulta c) {

		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection co = con.conectar();
		try {
			String query = "INSERT INTO consulta (data, objetivo, encerrada, pagamento_id_pagamento, medico_crm, paciente_cpf, falta) VALUES (?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement stm = co.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stm.setString(2, c.getObjetivo());
			stm.setBoolean(3, c.getEncerrada());
			stm.setInt(4, c.getPagamento().getIdPagamento());
			stm.setLong(5, c.getMedico().getCrm());
			stm.setLong(6, c.getPaciente().getCpf());
			stm.setBoolean(7, c.getFalta());
			String dateFormat = "yyyy-MM-dd'T'HH:mm:ss";
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			java.util.Date dataHora = null;
			try {
				dataHora = sdf.parse(c.getData().atTime(c.getHorario()).format(dtf));
			} catch (ParseException e) {
				e.printStackTrace();
			}
					
					//Date.valueOf(c.getData().atTime(c.getHorario()));
			//dataHora.setHours(c.getHorario().getHours());
			//dataHora.setMinutes(c.getHorario().getMinutes());
		
			stm.setTimestamp(1, new Timestamp(dataHora.getTime()));
			System.out.println(stm);
			stm.executeUpdate();
			
			ResultSet rs= stm.getGeneratedKeys();
            if (rs.next()) 
            {
              c.setIdConsulta(rs.getInt(1));
            }
            
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return false;
	}

	public boolean alterar(Consulta c) {
		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection co = con.conectar();

		try {
			String query = "UPDATE consulta SET data = ?, objetivo = ?, medico_crm = ?, falta = false WHERE id_consulta = ?;";
			PreparedStatement stm = co.prepareStatement(query);
			String dateFormat = "yyyy-MM-dd'T'HH:mm:ss";
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			java.util.Date dataHora = null;
			try {
				dataHora = sdf.parse(c.getData().atTime(c.getHorario()).format(dtf));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			stm.setTimestamp(1, new Timestamp(dataHora.getTime()));
			stm.setString(2, c.getObjetivo());
			stm.setLong(3, c.getMedico().getCrm());
			stm.setInt(4, c.getIdConsulta());

			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return false;
	}

	public boolean deletar(Consulta c) {
		con = Conexao.getInstancia();
		
		Connection co = con.conectar();
		
		try {
			String query = "DELETE FROM consulta WHERE id_consulta = ?;";
			PreparedStatement stm = co.prepareStatement(query);
			stm.setLong(1, c.getIdConsulta());
			
			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
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
			String query = "SELECT * FROM (consulta INNER JOIN pagamento ON consulta.pagamento_id_pagamento = pagamento.id_pagamento);";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Integer idConsulta = rs.getInt("id_consulta");
				Timestamp data = rs.getTimestamp("data");
				Boolean encerrada = rs.getBoolean("encerrada");
				String objetivo = rs.getString("objetivo");
				Integer idPagamento = rs.getInt("id_pagamento");
				String pagamento = rs.getString("forma_pagamento");
				Date dataPagamento = rs.getDate("data_pagamento");
				Long cpfPagante = rs.getLong("cpf_pagante");
				Long pacienteCpf = rs.getLong("paciente_cpf");
				Long medicoCrm = rs.getLong("medico_crm");
				Boolean falta = rs.getBoolean("falta");
				
				Consulta c = new Consulta();
				c.setIdConsulta(idConsulta);
				c.setData(data.toLocalDateTime().toLocalDate());
				c.setHorario(data.toLocalDateTime().toLocalTime());
				c.setEncerrada(encerrada);
				c.setObjetivo(objetivo);
				c.setFalta(falta);
				
				MedicoDAO mDao = new MedicoDAO();
				ArrayList<Medico> medicos = mDao.listarProfissionais();
				for (Medico medico : medicos) {
					if(medico.getCrm().equals(medicoCrm)) {
						c.setMedico(medico);
					}
				}
				
				PacienteDAO pDao = new PacienteDAO();
				ArrayList<Paciente> pacientes = pDao.listarPacientes();
				for (Paciente paciente : pacientes) {
					if(paciente.getCpf().equals(pacienteCpf)) {
						c.setPaciente(paciente);
					}
				}
				
				Pagamento p = new Pagamento();
				p.setCpfPagante(cpfPagante);
				p.setData_Pagamento(dataPagamento.toLocalDate());
				p.setFormaPagamento(pagamento);
				p.setIdPagamento(idPagamento);
				c.setPagamento(p);
				
				consultas.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return consultas;
	}

	public void consultaRealizada(Consulta c) {
		// instanciar
		con = Conexao.getInstancia();
		
		// conectar
		Connection co = con.conectar();

		try {
			String query = "UPDATE consulta SET encerrada = true, falta = 0 WHERE id_consulta = ?;";
			PreparedStatement stm = co.prepareStatement(query);
			stm.setInt(1, c.getIdConsulta());

			stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
	}
	
	public void consultaFalta() {
		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection co = con.conectar();
		
		try {
			String query = "UPDATE consulta SET falta = 1 WHERE data < now() AND encerrada = 0;";
			PreparedStatement stm = co.prepareStatement(query);
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
	}
}