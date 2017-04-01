package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_PROFISSAO")

@SequenceGenerator(name = "seqProfissao", sequenceName = " SEQ_T_PROFISSAO", allocationSize = 1)

public class Profissao {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProfissao")
	@Column(name = "CD_PROFISSAO")

	private int codigo;

	@Column(name = "DS_CARGO", nullable = false, length =80)
	private String cargo;

	@Column(name = "VL_SALARIO")
	private double salario;

	@Enumerated(EnumType.STRING)
	@Column (name = "DS_NIVEL")
	private Nivel nivel;

	@Column (name = "DT_CADASTRO")
	@Temporal(TemporalType.DATE)
	private Calendar dataCadastro;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
