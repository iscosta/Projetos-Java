package br.com.fiap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_Time")
@SequenceGenerator(name="seqTime", sequenceName = "SQ_Time", allocationSize=1 )
public class Time {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "seqTime")
	@Column(name="CD_TIME")
	private int codigo;
	
	@Column(name="NM_TIME")
	private String nome;
	
	@OneToOne (mappedBy="codigoTime")
	private Tecnico tecnico;
	
	//@OneToMany(mappedBy="time",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	//private List< >
	

	public Tecnico getTecnico() {
		return tecnico;
	}
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	

}
