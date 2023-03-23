package modelo;

import java.time.LocalDate;

public class Paciente {
	private Long cpf;
	private String nome;
	private LocalDate nascimento;
	private Long telefone;
	private String sexo;
	private String nomeSocial;
	private String email;
	private String pronome;
	private Endereco endereco;
	
	public String getPronome() {
		return pronome;
	}
	public void setPronome(String pronome) {
		this.pronome = pronome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Long getCpf() {
		return cpf;
	}
	public String getNome() {
		return nome;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public Long getTelefone() {
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
	public void setTelefone(Long telefone) {
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
