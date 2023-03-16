package modelo;

public class Medico {

	private Long cpfProfissionais;
	private String nomeProfissionais;
	private Usuario usuario;
	private String senha;

	/*
	 * 
	 * INSERT
	 * 
	 * Medico med = new Medico(); med.getUsuario().setLogin();
	 * med.getUsuario().setLogin(); 
	 * med.setSetCpf();
	 * med.setNome();
	 * 
	 * 
	 * SELECT = SELECT * FROM medicos INNER JOIN usuario INNER JOIN especialidade ==
	 */

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getCpfProfissionais() {
		return cpfProfissionais;
	}

	public void setCpfProfissionais(Long cpfProfissionais) {
		this.cpfProfissionais = cpfProfissionais;
	}

	public String getNomeProfissionais() {
		return nomeProfissionais;
	}

	public void setNomeProfissionais(String nomeProfissionais) {
		this.nomeProfissionais = nomeProfissionais;
	}

}
