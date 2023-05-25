package modelo;

public enum TipoUsuario {
	MEDICO(1), SECRETARIA(2), ADMIN(3);
	
	TipoUsuario(int tipo) {
		this.tipo = tipo;
	}

	public int tipo;
	
	public static TipoUsuario ObterTipo(int i) {
		switch(i) {
		case 1:
			return MEDICO;
		case 3:
			return ADMIN;
		default:
			return SECRETARIA;
		}
	}
}
