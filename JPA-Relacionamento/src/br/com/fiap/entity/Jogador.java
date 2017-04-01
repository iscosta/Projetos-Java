package br.com.fiap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_Jogador")
@SequenceGenerator(name="seqJogador", sequenceName = "SQ_Jogador", allocationSize=1 )
public class Jogador {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "seqJogador")
	@Column (name="CD_JOGADOR")
	private int codigo;
	
	@Column (name="NM_JOGADOR")
	private String nome;
	
	
	
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
