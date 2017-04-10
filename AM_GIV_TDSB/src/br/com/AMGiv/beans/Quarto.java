package br.com.AMGiv.beans;

public class Quarto{
	
	private int numQuarto;
	private String  tipoQuarto;
	private int numAndar;
	private int capacidade;
	private boolean status;
	
	public Quarto(int numQuarto,
			String tipoQuarto, int numAndar, int capacidade, boolean status) {
		super();		
		this.numQuarto = numQuarto;
		this.tipoQuarto = tipoQuarto;
		this.numAndar = numAndar;
		this.capacidade = capacidade;
		this.status = status;
	}	

	public Quarto() {
		super();
	}

	public int getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}

	public String getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(String tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public int getNumAndar() {
		return numAndar;
	}

	public void setNumAndar(int numAndar) {
		this.numAndar = numAndar;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	

}
