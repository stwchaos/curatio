package modelo;

import java.time.LocalDate;

public class Consulta {

	private Integer id_consulta;
	private LocalDate data;
	private String objetivo;
	private Boolean encerrada;
	private Pagamento pagamento;
	private Paciente paciente;
	private Medico medico;

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

	public Integer getId_consulta() {
		return id_consulta;
	}

	public void setId_consulta(Integer id_consulta) {
		this.id_consulta = id_consulta;
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
