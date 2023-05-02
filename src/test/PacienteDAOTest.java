package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import controle.PacienteDAO;
import modelo.Anamnese;
import modelo.Endereco;
import modelo.Paciente;

class PacienteDAOTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	void inserirPacienteSucessoTeste() throws Exception{
		
		PacienteDAO mdao = new PacienteDAO();
		Endereco endereco = new Endereco();
		Anamnese anamnese = new Anamnese();
		Paciente paciente = new Paciente();
		
		endereco.setIdEndereco(1l);
		anamnese.setIdAnamnese(1);
		
		paciente.setNome("Luis Eduardo");
		paciente.setCpf(48672134l);
		paciente.setCep(12345678l);
		paciente.setEmail("misomania@gmail.com");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse("18/09/2019",formatter);
		paciente.setNascimento(date);
		paciente.setNumCasa(1);
		paciente.setPronome("Ele/Dele");
		paciente.setSexo("Masculino");
		paciente.setTelefone(47895321l);
		
		
	}
	
}
