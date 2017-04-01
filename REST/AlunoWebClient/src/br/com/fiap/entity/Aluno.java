package br.com.fiap.entity;

import java.util.Calendar;

public class Aluno {

	private int id;
	
	private String nome;
	
	private String turma;
	
	private Calendar dataNascimento;
	
	private String telefone;
	
	private String endereco;
	
	private Sexo sexo;

	public Aluno() {
		super();
	}
	
	

	public Aluno(int id, String nome, String turma, Calendar dataNascimento, String telefone, String endereco,
			Sexo sexo) {
		super();
		this.id = id;
		this.nome = nome;
		this.turma = turma;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.endereco = endereco;
		this.sexo = sexo;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}


	
}
