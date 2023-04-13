package modelo;

import java.util.ArrayList;

public class Anamnese {

	private String queixaPrincipal;
	private String disposicaoGeral;
	private String alergia;
	private String medicacoesEmUso;
	
	public String getQueixaPrincipal() {
		return queixaPrincipal;
	}
	public void setQueixaPrincipal(String queixaPrincipal) {
		this.queixaPrincipal = queixaPrincipal;
	}
	public String getDisposicaoGeral() {
		return disposicaoGeral;
	}
	public void setDisposicaoGeral(String disposicaoGeral) {
		this.disposicaoGeral = disposicaoGeral;
	}
	public String getAlergias() {
		return alergia;
	}
	public void setAlergias(String alergias) {
		this.alergia = alergia;
	}
	public String getMedicacoesEmUso() {
		return medicacoesEmUso;
	}
	public void setMedicacoesEmUso(String medicacoesEmUso) {
		this.medicacoesEmUso = medicacoesEmUso;
	}

}
