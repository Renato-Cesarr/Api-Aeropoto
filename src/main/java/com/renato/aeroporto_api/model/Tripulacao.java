package com.renato.aeroporto_api.model;

public class Tripulacao {

	private String nome;
	private String funcao;
	private Integer numeroVoo;
	private String licenciamento;
	private Integer horasDeVoo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Integer getNumeroVoo() {
		return numeroVoo;
	}

	public void setNumeroVoo(Integer numeroVoo) {
		this.numeroVoo = numeroVoo;
	}

	public String getLicenciamento() {
		return licenciamento;
	}

	public void setLicenciamento(String licenciamento) {
		this.licenciamento = licenciamento;
	}

	public Integer getHorasDeVoo() {
		return horasDeVoo;
	}

	public void setHorasDeVoo(Integer horasDeVoo) {
		this.horasDeVoo = horasDeVoo;
	}
}
