package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table  (name = "T_CARRO")

@SequenceGenerator(name="seqCarro", sequenceName="SQ_CARRO", allocationSize = 1)

public class Carro {
	
	@Id
	@GeneratedValue (strategy=GenerationType.SEQUENCE,generator="seqCarro")
	@Column (name="ID_CARRO")
	private int id;
	
	@Column (name="VL_PRECO")
	private float preco;
	
	private String cor;
	
	@Column (name="DS_MODELO", nullable=false)
	private String modelo;
	
	@Column (name="NM_MARCA", nullable=false)
	private String marca;
	
	@Enumerated (EnumType.STRING)
	@Column (name="DS_COMBUSTIVEL")
	private Combustivel combustivel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

}
