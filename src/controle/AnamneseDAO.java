package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Anamnese;
import modelo.Medico;
import modelo.TipoUsuario;
import modelo.Usuario;

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

	public ArrayList<Anamnese> listarAnamnese() {
		ArrayList<Usuario> anamneses = new ArrayList<>();

		// instanciar
		con = Conexao.getInstancia();

		// conectar
		Connection c = con.conectar();

		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM anamnese";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Integer id = rs.getInt("id_anamnese");
				
				Anamnese a = new Anamnese();
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// desconectar
		con.fecharConexao();
		return null;
	}
	
 
	
 }
