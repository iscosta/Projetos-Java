package br.com.AMGiv.beans;

public class ReservaQuarto {
	
	private Funcionario funcionario;	
	private int codReserva;	
	private	String dataFinal;
	private String dataInicio;
	private String dataSolicitacao;
	private int qntAdultos;
	private int qntCriancas;		
	private int capaciPessoaQuarto;
	private Quarto quarto;
	private Cliente cliente;
	private int status;
	private String observacao;
	private double totalReservaQuarto;	
	
	
	public ReservaQuarto(Funcionario funcionario, int codReserva,
			String dataFinal, String dataInicio, String dataSolicitacao,
			int qntAdultos, int qntCriancas, int capaciPessoaQuarto,
			Quarto quarto, Cliente cliente, int status, String observacao,
			double totalReservaQuarto) {
		super();
		this.funcionario = funcionario;
		this.codReserva = codReserva;
		this.dataFinal = dataFinal;
		this.dataInicio = dataInicio;
		this.dataSolicitacao = dataSolicitacao;
		this.qntAdultos = qntAdultos;
		this.qntCriancas = qntCriancas;
		this.capaciPessoaQuarto = capaciPessoaQuarto;
		this.quarto = quarto;
		this.cliente = cliente;
		this.status = status;
		this.observacao = observacao;
		this.totalReservaQuarto = totalReservaQuarto;
	}
	
	public ReservaQuarto() {
		super();
	}
	
	
	public double getTotalReservaQuarto() {
		return totalReservaQuarto;
	}

	public void setTotalReservaQuarto(double totalReservaQuarto) {
		this.totalReservaQuarto = totalReservaQuarto;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public int getCodReserva() {
		return codReserva;
	}

	public void setCodReserva(int codReserva) {
		this.codReserva = codReserva;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(String dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public int getQntAdultos() {
		return qntAdultos;
	}

	public void setQntAdultos(int qntAdultos) {
		this.qntAdultos = qntAdultos;
	}

	public int getQntCriancas() {
		return qntCriancas;
	}

	public void setQntCriancas(int qntCriancas) {
		this.qntCriancas = qntCriancas;
	}

	public int getCapaciPessoaQuarto() {
		return capaciPessoaQuarto;
	}

	public void setCapaciPessoaQuarto(int capaciPessoaQuarto) {
		this.capaciPessoaQuarto = capaciPessoaQuarto;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}	
	
}
