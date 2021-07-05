package br.com.grupocidade.b2click.ws.model.request;

public class RazaoWS {

	private int cod_empresa;
	private String acesso;
	private String nome;
	private String origem;
	private int lancamento;
	private int planilha;
	private String documento;
	private String data;
	private String data_extrato;
	private String contrapartida;
	private String centro_custo;
	private String historico;
	private double debito;
	private double credito;
	private double saldo;
	private String tipo_saldo;
	private int agente;
	private String nome_agente;

	public int getCod_empresa() {
		return cod_empresa;
	}

	public void setCod_empresa(int cod_empresa) {
		this.cod_empresa = cod_empresa;
	}

	public String getAcesso() {
		return acesso;
	}

	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public int getLancamento() {
		return lancamento;
	}

	public void setLancamento(int lancamento) {
		this.lancamento = lancamento;
	}

	public int getPlanilha() {
		return planilha;
	}

	public void setPlanilha(int planilha) {
		this.planilha = planilha;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getData_extrato() {
		return data_extrato;
	}

	public void setData_extrato(String data_extrato) {
		this.data_extrato = data_extrato;
	}

	public String getContrapartida() {
		return contrapartida;
	}

	public void setContrapartida(String contrapartida) {
		this.contrapartida = contrapartida;
	}

	public String getCentro_custo() {
		return centro_custo;
	}

	public void setCentro_custo(String centro_custo) {
		this.centro_custo = centro_custo;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public double getDebito() {
		return debito;
	}

	public void setDebito(double debito) {
		this.debito = debito;
	}

	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getTipo_saldo() {
		return tipo_saldo;
	}

	public void setTipo_saldo(String tipo_saldo) {
		this.tipo_saldo = tipo_saldo;
	}

	public int getAgente() {
		return agente;
	}

	public void setAgente(int agente) {
		this.agente = agente;
	}

	public String getNome_agente() {
		return nome_agente;
	}

	public void setNome_agente(String nome_agente) {
		this.nome_agente = nome_agente;
	}

}
