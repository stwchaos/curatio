
package modelo;

import java.util.ArrayList;

public class Anamnese {

	private Consulta consulta;
	private Integer idAnamnese;
	private String queixaPrincipal;
	private String disposicaoGeral;
	private String alergia;
	private String medicacoesEmUso;
	private String historicoDoencaAtual;
	private String historicoPatologicoProg;
	private String historicoPatologicoFam;
	private String historicoSocial;
	private String trataAnteriores;
	private String trataAtuais;
	private String examesApresentados;
	private Usuario usuario;
	
	
	public String getHistoricoDoencaAtual() {
		return historicoDoencaAtual;
	}
	
	public void setHistoricoDoencaAtual(String historicoDoencaAtual) {
		this.historicoDoencaAtual = historicoDoencaAtual;
	}
	
	public String getHistoricoPatologicoProg() {
		return historicoPatologicoProg;
	}
	
	public void setHistoricoPatologicoProg(String historicoPatologicoProg) {
		this.historicoPatologicoProg = historicoPatologicoProg;
	}
	
	public String getHistoricoPatologicoFam() {
		return historicoPatologicoFam;
	}
	
	public void setHistoricoPatologicoFam(String historicoPatologicoFam) {
		this.historicoPatologicoFam = historicoPatologicoFam;
	}
	
	public String getHistoricoSocial() {
		return historicoSocial;
	}
	
	public void setHistoricoSocial(String historicoSocial) {
		this.historicoSocial = historicoSocial;
	}
	
	public String getTrataAnteriores() {
		return trataAnteriores;
	}
	
	public void setTrataAnteriores(String trataAnteriores) {
		this.trataAnteriores = trataAnteriores;
	}
	
	public String getTrataAtuais() {
		return trataAtuais;
	}
	
	public void setTrataAtuais(String trataAtuais) {
		this.trataAtuais = trataAtuais;
	}
	
	
	public String getExamesApresentados() {
		return examesApresentados;
	}
	
	public void setExamesApresentados(String examesApresentados) {
		this.examesApresentados = examesApresentados;
	}
	
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
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	
}
