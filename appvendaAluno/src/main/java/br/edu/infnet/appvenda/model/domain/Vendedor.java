package br.edu.infnet.appvenda.model.domain;

public class Vendedor {
	String nome;
	String cpf;
	String email;
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s", nome, cpf, email);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
