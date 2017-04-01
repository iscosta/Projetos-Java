package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="T_BEBIDA")
@SequenceGenerator (name="seqBebida", sequenceName="SEQ_T_BEBIDA", allocationSize=1)
public class Bebida {
	
	@Id
	@GeneratedValue (strategy=GenerationType.SEQUENCE, generator="seqBebida")
	@Column(name="CD_BEBIDA", nullable=false)
	private int codigo;
	
	@Column (name="NM_BEBIDA")
	private String nome;
	
	@Column (name="VL_BEBIDA")
	private double preco;
	
	private int estoque;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataValidade;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public Calendar getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	} 

}
