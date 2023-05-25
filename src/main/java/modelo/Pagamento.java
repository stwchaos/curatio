package modelo;

import java.time.LocalDate;

public class Pagamento {

	private Integer idPagamento;
	private String formaPagamento;
	private LocalDate dataPagamento;
	private Long cpfPagante;
	
	public Long getCpfPagante() {
		return cpfPagante;
	}
	public void setCpfPagante(Long cpfPagante) {
		this.cpfPagante = cpfPagante;
	}
	public Integer getIdPagamento() {
		return idPagamento;
	}
	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public LocalDate getData_Pagamento() {
		return dataPagamento;
	}
	public void setData_Pagamento(LocalDate data_Pagamento) {
		this.dataPagamento = data_Pagamento;
	}


}
