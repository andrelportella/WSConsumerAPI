package br.com.grupocidade.b2click.ws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Natureza")
public class Natureza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id_natureza;
	@Column()
	private Integer numero;
	@Column()
	private String nome;
	@Column()
	private Integer id_grupoNat;

	public String getId_natureza() {
		return id_natureza;
	}

	public void setId_natureza(String id_natureza) {
		this.id_natureza = id_natureza;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId_grupoNat() {
		return id_grupoNat;
	}

	public void setId_grupoNat(Integer id_grupoNat) {
		this.id_grupoNat = id_grupoNat;
	}

}
