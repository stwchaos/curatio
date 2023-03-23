package modelo;

import java.time.LocalDate;

public class Consulta {

	private Integer idConsulta;
	private LocalDate data;
	private String objetivo;
	private Boolean encerrada;
	private String pagamento;
	private Paciente paciente;
	private Medico profissional;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getProfissional() {
		return profissional;
	}

	public void setProfissional(Medico profissional) {
		this.profissional = profissional;
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

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

}
