package modelo;

import java.time.LocalDate;

public class Consulta {

	private Integer idConsulta;
	private LocalDate data;
	private String objetivo;
	private Boolean encerrada;
	private Pagamento pagamento;
	private Paciente paciente;
	private Medico medico;
	private Boolean falta;

	public Boolean getFalta() {
		return falta;
	}

	public void setFalta(Boolean falta) {
		this.falta = falta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}
	

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Boolean getEncerrada() {
		return encerrada;
	}

	public void setEncerrada(Boolean encerrada) {
		this.encerrada = encerrada;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

}
