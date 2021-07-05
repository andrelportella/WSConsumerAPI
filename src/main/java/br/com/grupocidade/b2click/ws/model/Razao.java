package br.com.grupocidade.b2click.ws.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "RAZAO")
public class Razao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "CODIGO_EMPRESA")
	private Integer codEmpresa;
	
	@Column(name = "ACESSO", length = 50)
	private String acesso;
	
	@Column(name = "NOME", length = 200)
	private String nome;
	
	@Column(name = "ORIGEM", length = 200)
	private String origem;
	
	@Column(name = "LANCAMENTO")
	private Integer lancamento;
	
	@Column(name = "PLANILHA")
	private Integer planilha;
	
	@Column(name = "DOCUMENTO")
	private String documento;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA")
	private Date data;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_EXTRATO")
	private Date dataExtrato;
	
	@Column(name = "CONTRAPARTIDA", length = 200)
	private String contrapartida;
	
	@Column(name = "CENTRO_CUSTO", length = 50)
	private String centroCusto;
	
	@Column(name = "HISTORICO", length = 2000)
	private String historico;
	
	@Column(name = "DEBITO")
	private double debito;
	
	@Column(name = "CREDITO")
	private double credito;
	
	@Column(name = "SALDO")
	private double saldo;
	
	@Column(name = "TIPO_SALDO", length = 20)
	private String tipoSaldo;
	
	@Column(name = "AGENTE")
	private Integer agente;
	
	@Column(name = "NOME_AGENTE", length = 2000)
	private String nomeAgente;
	
	@Column(name = "ID_SISTEMA")
	private Integer idSistema;
	
	@Column(name = "ID_EMPRESA")
	private Integer idEmpresa;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_ALTERACAO")
	private Date dataAlteracao;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_IMPORTACAO")
	private Date dataImportacao;

	///
	
	
	@PreUpdate
	public void preUpdate() {
		dataAlteracao = new Date();
	}

	@PrePersist
	public void prePersist() {
		dataImportacao = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(Integer codEmpresa) {
		this.codEmpresa = codEmpresa;
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

	public Integer getLancamento() {
		return lancamento;
	}

	public void setLancamento(Integer lancamento) {
		this.lancamento = lancamento;
	}

	public Integer getPlanilha() {
		return planilha;
	}

	public void setPlanilha(Integer planilha) {
		this.planilha = planilha;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getDataExtrato() {
		return dataExtrato;
	}

	public void setDataExtrato(Date dataExtrato) {
		this.dataExtrato = dataExtrato;
	}

	public String getContrapartida() {
		return contrapartida;
	}

	public void setContrapartida(String contrapartida) {
		this.contrapartida = contrapartida;
	}

	public String getCentroCusto() {
		return centroCusto;
	}

	public void setCentroCusto(String centroCusto) {
		this.centroCusto = centroCusto;
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

	public String getTipoSaldo() {
		return tipoSaldo;
	}

	public void setTipoSaldo(String tipoSaldo) {
		this.tipoSaldo = tipoSaldo;
	}

	public Integer getAgente() {
		return agente;
	}

	public void setAgente(Integer agente) {
		this.agente = agente;
	}

	public String getNomeAgente() {
		return nomeAgente;
	}

	public void setNomeAgente(String nomeAgente) {
		this.nomeAgente = nomeAgente;
	}

	public Integer getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(Integer idSistema) {
		this.idSistema = idSistema;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}	
	
}
