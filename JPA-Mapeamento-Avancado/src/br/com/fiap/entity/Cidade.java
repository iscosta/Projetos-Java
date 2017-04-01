package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_CIDADE")
@IdClass(CidadePK.class)
public class Cidade {

	@Id
	@Column(name = "NM_CIDADE")
	private String nome;

	@Id
	@ManyToOne
	private Estado estado;

	@Column(name = "NR_DDD")
	private int ddd;

	@Column(name = "NR_IDH")
	private float idh;

	public Cidade(String nome, Estado estado, int ddd, float idh) {
		super();
		this.nome = nome;
		this.estado = estado;
		this.ddd = ddd;
		this.idh = idh;
	}

	public Cidade() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public float getIdh() {
		return idh;
	}

	public void setIdh(float idh) {
		this.idh = idh;
	}

}
