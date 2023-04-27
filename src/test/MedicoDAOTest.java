package test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controle.MedicoDAO;
import junit.framework.Assert;
import modelo.Especialidade;
import modelo.Medico;
import modelo.TipoUsuario;
import modelo.Usuario;

class MedicoDAOTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void inserirMedicoSucessoTeste() throws Exception{
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
		
	}

}
