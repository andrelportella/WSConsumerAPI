package br.com.grupocidade.b2click.ws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Grupo_Natureza")
public class Grupo_Natureza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_grupoNat;
	@Column()
	private String nome;

	public Integer getId_grupoNat() {
		return id_grupoNat;
	}

	public void setId_grupoNat(Integer id_grupoNat) {
		this.id_grupoNat = id_grupoNat;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
