package modelo;

import java.util.ArrayList;

public class Anamnese {

	private String queixaPrincipal;
	private String disposicaoGeral;
	private ArrayList<String> alergias;
	private ArrayList<String> medicacoesEmUso;
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
	public ArrayList<String> getAlergias() {
		return alergias;
	}
	public void setAlergias(ArrayList<String> alergias) {
		this.alergias = alergias;
	}
	public ArrayList<String> getMedicacoesEmUso() {
		return medicacoesEmUso;
	}
	public void setMedicacoesEmUso(ArrayList<String> medicacoesEmUso) {
		this.medicacoesEmUso = medicacoesEmUso;
	}

}
