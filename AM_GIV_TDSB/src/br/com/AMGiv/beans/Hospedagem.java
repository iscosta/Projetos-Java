package br.com.AMGiv.beans;

public class Hospedagem {
	
	private ReservaQuarto reservaQuarto;
	private Funcionario funcionario;
	private int codHospedagem;
	private String dataHoraEntrada;
	
	public Hospedagem(ReservaQuarto reservaQuarto, Funcionario funcionario,
			int codHospedagem, String dataHoraEntrada) {
		super();
		this.reservaQuarto = reservaQuarto;
		this.funcionario = funcionario;
		this.codHospedagem = codHospedagem;
		this.dataHoraEntrada = dataHoraEntrada;
	}

	public Hospedagem() {
		super();
	}

	public ReservaQuarto getReservaQuarto() {
		return reservaQuarto;
	}

	public void setReservaQuarto(ReservaQuarto reservaQuarto) {
		this.reservaQuarto = reservaQuarto;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public int getCodHospedagem() {
		return codHospedagem;
	}

	public void setCodHospedagem(int codHospedagem) {
		this.codHospedagem = codHospedagem;
	}

	public String getDataHoraEntrada() {
		return dataHoraEntrada;
	}

	public void setDataHoraEntrada(String dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}
	
	
	
	
}
