package br.com.AMGiv.beans;

import java.util.List;

public class Pagamento {

	private String dataHoraSaida;
	private Hospedagem hospedagem;
	private List<Consumo> consumo;
	private String tipoFormaPag;
	private Double valorTotal;
	
	public Pagamento(String dataHoraSaida, Hospedagem hospedagem,
			List<Consumo> consumo, String tipoFormaPag, Double valorTotal) {
		super();
		this.dataHoraSaida = dataHoraSaida;
		this.hospedagem = hospedagem;
		this.consumo = consumo;
		this.tipoFormaPag = tipoFormaPag;
		this.valorTotal = valorTotal;
	}
	
	public Pagamento() {
		super();
	}
	
	public String getDataHoraSaida() {
		return dataHoraSaida;
	}
	public void setDataHoraSaida(String dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
	}
	public Hospedagem getHospedagem() {
		return hospedagem;
	}
	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}

	public List<Consumo> getConsumo() {
		return consumo;
	}

	public void setConsumo(List<Consumo> consumo) {
		this.consumo = consumo;
	}

	public String getTipoFormaPag() {
		return tipoFormaPag;
	}
	public void setTipoFormaPag(String tipoFormaPag) {
		this.tipoFormaPag = tipoFormaPag;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
}
