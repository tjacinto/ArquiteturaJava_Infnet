package br.edu.infnet.appvenda.model.domain;

public class Eletroportateis extends Produto {
	private int voltagem;
	private String bateria;

	@Override
	public String toString() {
		return String.format("%s - %d - %s ", super.toString(), voltagem, bateria);
	}
	
	public int getVoltagem() {
		return voltagem;
	}

	public void setVoltagem(int voltagem) {
		this.voltagem = voltagem;
	}

	public String getBateria() {
		return bateria;
	}

	public void setBateria(String bateria) {
		this.bateria = bateria;
	}

}
