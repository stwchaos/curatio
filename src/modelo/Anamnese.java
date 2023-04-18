package modelo;

import java.util.ArrayList;

public class Anamnese {

	private Integer idAnamnese;
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
	public String getAlergia() {
		return alergia;
	}
	public void setAlergia(String alergias) {
		this.alergia = alergia;
	}
	public String getMedicacoesEmUso() {
		return medicacoesEmUso;
	}
	public void setMedicacoesEmUso(String medicacoesEmUso) {
		this.medicacoesEmUso = medicacoesEmUso;
	}

	public Integer getIdAnamnese() {
		return idAnamnese;
	}
	public void setIdAnamnese(Integer idAnamnese) {
		this.idAnamnese = idAnamnese;
	}
	
	
}
