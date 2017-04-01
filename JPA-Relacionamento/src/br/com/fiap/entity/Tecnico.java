package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_TECNICO")
@SequenceGenerator(name="seqTecnico", sequenceName = "SQ_TECNICO", allocationSize=1 )
public class Tecnico {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "seqTecnico")
	@Column(name="CD_TECNICO")
	private int codigo;
	
	@Column(name="NM_TECNICO")
	private String nome;
	
	@OneToOne
	@JoinColumn(name="CD_TIME")
	private Time time;
	

	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	

}
