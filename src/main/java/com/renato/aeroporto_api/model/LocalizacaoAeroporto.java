package com.renato.aeroporto_api.model;

public class LocalizacaoAeroporto {

	private String endereco;
	private String cidade;
	private String estado;
	private String cep;

	public LocalizacaoAeroporto() {
	}

	public LocalizacaoAeroporto(String endereco, String cidade, String estado, String cep) {
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "LocalizacaoAeroporto{" + "endereco='" + endereco + '\'' + ", cidade='" + cidade + '\'' + ", estado='"
				+ estado + '\'' + ", cep='" + cep + '\'' + '}';
	}
}
