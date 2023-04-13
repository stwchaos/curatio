package modelo;

public class Usuario {

	private Integer id;
	private String login;
	private String senha;
	private TipoUsuario tipo;

	/*
	 * tipo = 1 -> medico
	 * tipo = 2 -> secretaria
	 * tipo = 3 -> adm
	 * tipo = 4 -> outros
	 */
	
	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario medico) {
		this.tipo = medico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
