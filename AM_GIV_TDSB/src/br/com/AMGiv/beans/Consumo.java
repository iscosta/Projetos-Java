package br.com.AMGiv.beans;

public class Consumo {

	private int quantidade;
	private Double totalConsumo;
	private String dataConsumo;
	private int codConsumo;
	private String tipoServico;
	private Hospedagem hospedagem;
	private Funcionario funcionario;

	public Consumo(int quantidade, Double totalConsumo, String dataConsumo,
			int codConsumo, String tipoServico, Hospedagem hospedagem,
			Funcionario funcionario) {
		super();
		this.quantidade = quantidade;
		this.totalConsumo = totalConsumo;
		this.dataConsumo = dataConsumo;
		this.codConsumo = codConsumo;
		this.tipoServico = tipoServico;
		this.hospedagem = hospedagem;
		this.funcionario = funcionario;
	}

	public Consumo() {
		super();
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getTotalConsumo() {
		return totalConsumo;
	}

	public void setTotalConsumo(Double totalConsumo) {
		this.totalConsumo = totalConsumo;
	}

	public String getDataConsumo() {
		return dataConsumo;
	}

	public void setDataConsumo(String dataConsumo) {
		this.dataConsumo = dataConsumo;
	}

	public int getCodConsumo() {
		return codConsumo;
	}

	public void setCodConsumo(int codConsumo) {
		this.codConsumo = codConsumo;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public Hospedagem getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	
}
