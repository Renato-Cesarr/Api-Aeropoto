package com.renato.aeroporto_api.model;

public class Passageiro {

	private String nome;
	private Integer numeroBilhete;
	private String assento;
	private String statusEmbarque; // possivel enum
	private Carga carga;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumeroBilhete() {
		return numeroBilhete;
	}

	public void setNumeroBilhete(Integer numeroBilhete) {
		this.numeroBilhete = numeroBilhete;
	}

	public String getAssento() {
		return assento;
	}

	public void setAssento(String assento) {
		this.assento = assento;
	}

	public String getStatusEmbarque() {
		return statusEmbarque;
	}

	public void setStatusEmbarque(String statusEmbarque) {
		this.statusEmbarque = statusEmbarque;
	}

	public Carga getCarga() {
		return carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
	}
}
