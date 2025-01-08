package com.renato.aeroporto_api.model;

public class Carga {
	private Integer numeroIdentificadorCarga;
	private Double pesoTotalCarga;
	private String statusDaCarga; // possivel enum
	private TipoDeCarga tipoDeCarga;

	public Integer getNumeroIdentificadorCarga() {
		return numeroIdentificadorCarga;
	}

	public void setNumeroIdentificadorCarga(Integer numeroIdentificadorCarga) {
		this.numeroIdentificadorCarga = numeroIdentificadorCarga;
	}

	public Double getPesoTotalCarga() {
		return pesoTotalCarga;
	}

	public void setPesoTotalCarga(Double pesoTotalCarga) {
		this.pesoTotalCarga = pesoTotalCarga;
	}

	public String getStatusDaCarga() {
		return statusDaCarga;
	}

	public void setStatusDaCarga(String statusDaCarga) {
		this.statusDaCarga = statusDaCarga;
	}

	public TipoDeCarga getTipoDeCarga() {
		return tipoDeCarga;
	}

	public void setTipoDeCarga(TipoDeCarga tipoDeCarga) {
		this.tipoDeCarga = tipoDeCarga;
	}

	
}
