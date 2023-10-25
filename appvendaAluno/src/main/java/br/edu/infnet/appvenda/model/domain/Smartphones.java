package br.edu.infnet.appvenda.model.domain;

public class Smartphones extends Produto {

	private int garantiaMeses;
	private int armazenamento;

	@Override
	public String toString() {
		return String.format("%s - %d - %d", super.toString(), garantiaMeses, armazenamento);
	}
	
	public int getGarantiaMeses() {
		return garantiaMeses;
	}
	public void setGarantiaMeses(int garantiaMeses) {
		this.garantiaMeses = garantiaMeses;
	}

	public int getArmazenamento() {
		return armazenamento;
	}

	public void setArmazenamento(int armazenamento) {
		this.armazenamento = armazenamento;
	}
}