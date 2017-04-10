package br.com.AMGiv.beans;

public class Funcionario {

	private String nome;
	private int cargo;
	private int codFuncionario;
	private String dtAdmissao;
	
	public Funcionario(String nome, int cargo, int codFuncionario, String dtAdmissao) {
		super();
		this.nome = nome;			
		this.cargo = cargo;
		this.codFuncionario = codFuncionario;
		this.dtAdmissao = dtAdmissao;
	}	
	
	public Funcionario() {
		super();
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCargo() {
		return cargo;
	}
	public void setCargo(int cargo) {
		this.cargo = cargo;
	}
	public int getCodFuncionario() {
		return codFuncionario;
	}
	public void setCodFuncionario(int codFuncionario) {
		this.codFuncionario = codFuncionario;
	}
	public String getDtAdmissao() {
		return dtAdmissao;
	}
	public void setDtAdmissao(String dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}
	
	
	
}
