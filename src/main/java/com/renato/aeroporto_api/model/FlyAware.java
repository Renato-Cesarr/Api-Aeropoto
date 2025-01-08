package com.renato.aeroporto_api.model;

public class FlyAware {
	private Integer numeroDaRota;
	private String origem;
	private String destino;
	private Double tempoEstimadoVoo;

	public Integer getNumeroDaRota() {
		return numeroDaRota;
	}

	public void setNumeroDaRota(Integer numeroDaRota) {
		this.numeroDaRota = numeroDaRota;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Double getTempoEstimadoVoo() {
		return tempoEstimadoVoo;
	}

	public void setTempoEstimadoVoo(Double tempoEstimadoVoo) {
		this.tempoEstimadoVoo = tempoEstimadoVoo;
	}
}
