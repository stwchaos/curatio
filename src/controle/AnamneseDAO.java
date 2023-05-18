package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Anamnese;
import modelo.Consulta;

 public class AnamneseDAO {
	
	private Conexao con;

	public boolean inserir(Anamnese a) {
		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO anamnese (queixa_principal, disposicao_geral, alergia, medicacoes_em_uso,historico_doenca_atual,historico_patologico_prog,historico_patologico_fam,historico_social,trata_anteriores,trata_atuais,exames_apresentados,consulta_id_consulta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1,a.getQueixaPrincipal());
			stm.setString(2,a.getDisposicaoGeral());
			stm.setString(3,a.getAlergia());
			stm.setString(4,a.getMedicacoesEmUso());
			stm.setString(5,a.getHistoricoDoencaAtual());
			stm.setString(6,a.getHistoricoPatologicoProg());
			stm.setString(7,a.getHistoricoPatologicoFam());
			stm.setString(8,a.getHistoricoSocial());
			stm.setString(9,a.getTrataAnteriores());
			stm.setString(10,a.getTrataAtuais());
			stm.setString(11,a.getExamesApresentados());
			stm.setInt(12,a.getConsulta().getIdConsulta());
			
			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return false;
	}
	
	public boolean alterar(Anamnese a) {
		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();
		try {
			String query = "UPDATE anamnese SET queixa_principal = ?, disposicao_geral = ?, alergia = ?, medicacoes_em_uso = ?, historico_doenca_atual = ?, historico_patologico_prog = ?, historico_patologico_fam = ?, historico_social = ?, trata_anteriores = ?, trata_atuais = ?, exames_apresentados = ? WHERE id_anamnese = ?;";
			PreparedStatement stm = c.prepareStatement(query);
			
			stm.setString(1,a.getQueixaPrincipal());
			stm.setString(2,a.getDisposicaoGeral());
			stm.setString(3,a.getAlergia());
			stm.setString(4,a.getMedicacoesEmUso());
			stm.setString(5,a.getHistoricoDoencaAtual());
			stm.setString(6,a.getHistoricoPatologicoProg());
			stm.setString(7,a.getHistoricoPatologicoFam());
			stm.setString(8,a.getHistoricoSocial());
			stm.setString(9,a.getTrataAnteriores());
			stm.setString(10,a.getTrataAtuais());
			stm.setString(11,a.getExamesApresentados());
			stm.setLong(12, a.getIdAnamnese());
			
			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return false;
	}

	public ArrayList<Anamnese> listarAnamnese() {
		ArrayList<Anamnese> anamneses = new ArrayList<>();

		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();

		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM anamnese INNER JOIN consulta ON consulta_id_consulta = id_consulta;";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Integer id = rs.getInt("id_anamnese");
				String queixaPrincipal = rs.getString("queixa_principal");
				String disposicaoGeral = rs.getString("disposicao_geral");
				String alergia = rs.getString("alergia");
				String medicacoesEmUso = rs.getString("medicacoes_em_uso");
				String historicoDoencaAtual = rs.getString("historico_doenca_atual");
				String historicoPatoloProg = rs.getString("historico_patologico_prog");
				String historicoPatolFam = rs.getString("historico_patologico_fam");
				String historicoSocial = rs.getString("historico_social");
				String trataAnteriores = rs.getString("trata_anteriores");
				String trataAtuais = rs.getString("trata_atuais");
				String examesApresentados = rs.getString("exames_apresentados");
				Long consultaId = rs.getLong("id_consulta");
				
				Anamnese a = new Anamnese();
				a.setIdAnamnese(id);
				a.setQueixaPrincipal(queixaPrincipal);
				a.setDisposicaoGeral(disposicaoGeral);
				a.setAlergia(alergia);
				a.setMedicacoesEmUso(medicacoesEmUso);
				a.setHistoricoDoencaAtual(historicoDoencaAtual);
				a.setHistoricoPatologicoProg(historicoPatoloProg);
				a.setHistoricoPatologicoFam(historicoPatoloProg);
				a.setHistoricoSocial(historicoSocial);
				a.setTrataAnteriores(trataAnteriores);
				a.setTrataAtuais(trataAtuais);
				a.setExamesApresentados(examesApresentados);
				
				ConsultaDAO cDao = new ConsultaDAO();
				ArrayList<Consulta> consultas = cDao.listarConsultas();
				for (Consulta consulta : consultas) {
					if(consultaId.equals(consulta.getIdConsulta())) {
						a.setConsulta(consulta);
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		// desconectar
		
		return anamneses;
	}

	public Anamnese buscarAnamnesePorIdConsulta(Integer idConsulta) {
		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();
				
		String query = "SELECT * FROM anamnese INNER JOIN consulta ON consulta_id_consulta = id_consulta WHERE id_consulta=?;";

		try {
			PreparedStatement stm = c.prepareStatement(query);
			stm.setInt(1, idConsulta);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				Integer id = rs.getInt("id_anamnese");
				String queixaPrincipal = rs.getString("queixa_principal");
				String disposicaoGeral = rs.getString("disposicao_geral");
				String alergia = rs.getString("alergia");
				String medicacoesEmUso = rs.getString("medicacoes_em_uso");
				String historicoDoencaAtual = rs.getString("historico_doenca_atual");
				String historicoPatoloProg = rs.getString("historico_patologico_prog");
				String historicoPatolFam = rs.getString("historico_patologico_fam");
				String historicoSocial = rs.getString("historico_social");
				String trataAnteriores = rs.getString("trata_anteriores");
				String trataAtuais = rs.getString("trata_atuais");
				String examesApresentados = rs.getString("exames_apresentados");
				Integer consultaId = rs.getInt("id_consulta");
				
				Anamnese a = new Anamnese();
				a.setIdAnamnese(id);
				a.setQueixaPrincipal(queixaPrincipal);
				a.setDisposicaoGeral(disposicaoGeral);
				a.setAlergia(alergia);
				a.setMedicacoesEmUso(medicacoesEmUso);
				a.setHistoricoDoencaAtual(historicoDoencaAtual);
				a.setHistoricoPatologicoProg(historicoPatoloProg);
				a.setHistoricoPatologicoFam(historicoPatolFam);
				a.setHistoricoSocial(historicoSocial);
				a.setTrataAnteriores(trataAnteriores);
				a.setTrataAtuais(trataAtuais);
				a.setExamesApresentados(examesApresentados);
				
				ConsultaDAO cDao = new ConsultaDAO();
				ArrayList<Consulta> consultas = cDao.listarConsultas();
				for (Consulta consulta : consultas) {
					if(consultaId.equals(consulta.getIdConsulta())) {
						a.setConsulta(consulta);
					}
				}
			
				return a;
			}
			
		} catch (SQLException e) {
			// Trate a exceção ou a propague para cima
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
	return null;
	}
 }
