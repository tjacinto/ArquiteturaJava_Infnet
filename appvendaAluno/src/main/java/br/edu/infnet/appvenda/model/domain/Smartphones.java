package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "TbSmartphones")
public class Smartphones extends Produto {
	@PositiveOrZero
	private int garantiaMeses;
	@Positive
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