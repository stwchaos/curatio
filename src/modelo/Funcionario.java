package modelo;

import java.time.LocalDate;

public class Funcionario {
	
	Usuario usuario;
	Long idFuncionario;
	Long cpf;
	String nome;
	String pronome;
	String sexo;
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public String getPronome() {
		return pronome;
	}
	public void setPronome(String pronome) {
		this.pronome = pronome;
	}
	LocalDate dataNascimento;
	
	public Long getIdFuncionario() {
		return idFuncionario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	} 


	
}
