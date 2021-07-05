package br.com.grupocidade.b2click.ws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Agente")
public class Agente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id_agente;
	@Column()
	private String cpfCnpj;
	@Column()
	private String nome;
	@Column()
	private String cidade;
	@Column()
	private String bairro;
	@Column()
	private String negocio;
	@Column()
	private String grupo;
	
	public String getId_agente() {
		return id_agente;
	}
	public void setId_agente(String id_agente) {
		this.id_agente = id_agente;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getNegocio() {
		return negocio;
	}
	public void setNegocio(String negocio) {
		this.negocio = negocio;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	

}
