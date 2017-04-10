package br.com.AMGiv.beans;

public class Cliente {
	
	private int codCliente;
	private String email;
	private String senha;
	private String nome;
	private int quartoPreferido;
	private long cpf ;
	private String rg;
	private String dataNascimento;	

	public Cliente(int codCliente, String email, String senha, String nome,
			int quartoPreferido, long cpf, String rg, String dataNascimento) {
		super();
		this.codCliente = codCliente;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.quartoPreferido = quartoPreferido;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
	}

	public Cliente() {
		super();
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getQuartoPreferido() {
		return quartoPreferido;
	}

	public void setQuartoPreferido(int quartoPreferido) {
		this.quartoPreferido = quartoPreferido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}	

}
