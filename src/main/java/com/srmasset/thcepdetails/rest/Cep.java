package com.srmasset.thcepdetails.rest;

public class Cep {

	private String estado;
	private String cidade;
	private String bairro;
	private String logradouro;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	@Override
	public String toString() {
		return "Detalhes do cep: \n estado =" + estado + "\n cidade=" + cidade + ",\n bairro =" + bairro + ",\n logradouro =" + logradouro;
	}
	
}
