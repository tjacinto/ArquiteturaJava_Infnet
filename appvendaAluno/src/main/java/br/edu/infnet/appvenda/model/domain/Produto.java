package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TbProduto")
@Inheritance(strategy = InheritanceType.JOINED)
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Positive
	private int codigo;
	@Size(min = 2, max = 100, message = "A descricao deve ter entre {min} e {max} caracteres.")
	@Pattern(regexp = "^[A-Z]*$", message = "A descricao deve conter apenas letras maiúsculas.")
	private String descricao;
	@PositiveOrZero
	private float preco;
	@NotNull
	private boolean estoque;
	@Size(min = 2, max = 50, message = "O fabricante deve ter entre {min} e {max} caracteres.")
	private String fabricante;
	@Size(min = 2, max = 50, message = "O modelo deve ter entre {min} e {max} caracteres.")
	private String modelo;
	@ManyToOne
	@JoinColumn(name = "idVendedor")
	private Vendedor vendedor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return String.format("%s - %d - %.2f - %s - %s - %s - vendedor [%s]", descricao, codigo, preco, estoque,
				fabricante, modelo, vendedor);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public boolean isEstoque() {
		return estoque;
	}

	public void setEstoque(boolean estoque) {
		this.estoque = estoque;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
}