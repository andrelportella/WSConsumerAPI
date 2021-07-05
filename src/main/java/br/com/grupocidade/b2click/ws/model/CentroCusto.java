package br.com.grupocidade.b2click.ws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CentroCusto")
public class CentroCusto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_centroCusto;
	@Column()
	private String nome;
	@Column()
	private Integer id_grupoCc;
	

}
