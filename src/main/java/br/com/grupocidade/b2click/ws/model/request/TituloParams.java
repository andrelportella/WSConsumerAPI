package br.com.grupocidade.b2click.ws.model.request;

public class TituloParams {
	
	private String dataInicial;
	private String dataFinal;
	private String cpfCnpj;
	private String documento;
	private Integer codVenda;
	private String tipo;
	private String situacao;
	private Integer pdv;
	private Integer codEmpresa;
	
	public String getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}
	public String getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public Integer getCodVenda() {
		return codVenda;
	}
	public void setCodVenda(Integer codVenda) {
		this.codVenda = codVenda;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Integer getPdv() {
		return pdv;
	}
	public void setPdv(Integer pdv) {
		this.pdv = pdv;
	}
	public Integer getCodEmpresa() {
		return codEmpresa;
	}
	public void setCodEmpresa(Integer codEmpresa) {
		this.codEmpresa = codEmpresa;
	}
	
	

}
