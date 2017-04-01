package br.com.fiap.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqPessoa",sequenceName="SEQ_T_PESSOA", allocationSize=1)
@Inheritance(strategy=InheritanceType.JOINED)

//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="TIPO") //Altera o nome da coluna que armazena o tipo
public class Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqPessoa")
	private int codigo;
	
	private String Pessoa;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPessoa() {
		return Pessoa;
	}

	public void setPessoa(String pessoa) {
		Pessoa = pessoa;
	}
	
	
	
}
