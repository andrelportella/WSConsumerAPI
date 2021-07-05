package br.com.grupocidade.b2click.ws.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "GrupoCentroCusto")
public class Grupo_CentroCusto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_grupoCc;
	@Column()
	private String nome;
	
	public Integer getId_grupoCc() {
		return id_grupoCc;
	}
	public void setId_grupoCc(Integer id_grupoCc) {
		this.id_grupoCc = id_grupoCc;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
