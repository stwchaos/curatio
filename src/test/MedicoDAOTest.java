package test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import controle.Conexao;
import controle.MedicoDAO;
import controle.UsuarioDAO;
import junit.framework.Assert;
import modelo.Especialidade;
import modelo.Medico;
import modelo.TipoUsuario;
import modelo.Usuario;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MedicoDAOTest {

	@Test
	@Order(1)
	void inserirMedicoSucessoTeste() {
		MedicoDAO dao = new MedicoDAO();
		Especialidade e = new Especialidade();
		Usuario usuario = new Usuario();
		Medico medico = new Medico();

		e.setEspecialidade("Urologista");
		e.setIdEspecialidade(1);
		e.setSalario(4010.3);

		usuario.setId(1);
		usuario.setLogin("tantofaz");
		usuario.setSenha("doremifa");
		usuario.setTipo(TipoUsuario.MEDICO);

		medico.setCrm(123456l);
		medico.setNome("Gabriel do Rosario Batista");
		medico.setCpf(123456789109l);
		medico.setSexo("Masculino");
		medico.setPronome("Ele/Dele");
		medico.setEspecialidade(e);
		medico.setUsuario(usuario);

		assertTrue(dao.inserir(medico));
		// dao.deletar(medico);
	}

	@Test
	@Order(2)
	public void testListar() {
	    MedicoDAO mdao = new MedicoDAO();
	    ArrayList<Medico> lm = mdao.listarProfissionais();
	    System.out.println(lm.size());
	    
	    assertTrue(!lm.isEmpty());
	    Medico primeiroMedico = lm.get(0);
	    assertNotNull(primeiroMedico.getCrm());
	    assertNotNull(primeiroMedico.getEspecialidade());
	}



	@Test
	@Order(3)
	public void testAlterar() {

		// inserirMedicoSucessoTeste();
		MedicoDAO mdao = new MedicoDAO();

		ArrayList<Medico> lm = mdao.listarProfissionais();
		System.out.println(lm.size());
		Medico m = lm.get(0);
		m.setCpf(55555l);
		System.out.println(mdao.alterar(m));

		assertTrue(mdao.alterar(m));

	}

	@Test
	@Order(4)
	public void testDeletar() {

		MedicoDAO mdao = new MedicoDAO();

		ArrayList<Medico> lm = mdao.listarProfissionais();
		System.out.println(lm.size());
		Medico m = lm.get(0);
		assertTrue(mdao.deletar(m));
	}

}
