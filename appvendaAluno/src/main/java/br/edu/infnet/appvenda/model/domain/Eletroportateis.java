package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TbEletroportateis")
public class Eletroportateis extends Produto {
	@Positive
	private int voltagem;
	@Size(min = 3, max = 50)
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
