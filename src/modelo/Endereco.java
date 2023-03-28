package modelo;

public class Endereco {

	private long idEndereco;
	private String rua;
	private Long cep;
	private Integer numCasa;
	private String complemento;
	private String cidade;
	private String bairro;
	
	public long getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(long idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Long getCep() {
		return cep;
	}
	public void setCep(Long cep) {
		this.cep = cep;
	}
	public Integer getNumCasa() {
		return numCasa;
	}
	public void setNumCasa(Integer numCasa) {
		this.numCasa = numCasa;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}
