package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name="T_ESTADO")
@SecondaryTable (name="T_ESTADO_INFO")
public class Estado {

	@Id
	@Column(length=2, name="SG_ESTADO")
	private String sigla;
	
	@Column(name="NM_ESTADO")
	private String nome;
	
	@Column(name="NR_POPULACAO", table="T_ESTADO_INFO")
	private long populacao;

	
	public Estado(String sigla, String nome, long populacao) {
		super();
		this.sigla = sigla;
		this.nome = nome;
		this.populacao = populacao;
	}
		

	public Estado() {
		super();
	}


	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}
	
	
	
}
