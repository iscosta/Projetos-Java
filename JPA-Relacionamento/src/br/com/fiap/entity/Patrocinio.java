package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_Patrocinio")
@SequenceGenerator(name="seqPatrocinio", sequenceName = "SQ_Patrocinio", allocationSize=1 )
public class Patrocinio {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "seqPatrocinio")
	@Column (name="CD_PATROCINIO")
	private int codigo;
	
	@Column (name="VL_PATROCINIO")
	private double valor;

	@Column (name="NM_EMPRESA")
	private String nome;
	
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
	
}
