package modelo;

import java.time.LocalDate;

public class Paciente {
	private Long cpf;
	private String nome;
	private LocalDate nascimento;
	private Integer telefone;
	private String sexo;
	private String nomeSocial;
	private String email;
	
	public Long getCpf() {
		return cpf;
	}
	public String getNome() {
		return nome;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public Integer getTelefone() {
		return telefone;
	}
	public String getSexo() {
		return sexo;
	}
	public String getNomeSocial() {
		return nomeSocial;
	}
	public String getEmail() {
		return email;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
}
