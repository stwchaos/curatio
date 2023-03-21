package modelo;

public class Usuario {

	private Long id;
	private String login;
	private String senha;
	private Integer tipo;

	/*
	 * tipo = 1 -> medico
	 * tipo = 2 -> secretaria
	 * tipo = 3 -> adm
	 * tipo = 4 -> outros
	 */
	
	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
