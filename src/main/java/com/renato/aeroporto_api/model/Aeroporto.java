package com.renato.aeroporto_api.model;

import java.util.List;

public class Aeroporto {
	private String nomeAeroporto;
	private LocalizacaoAeroporto localizacaoAeroporto;
	private Boolean permitidoPousoAeronaves;
	private List<Integer> portoesDeEmbarque;
	private Integer limiteMaximoAeronaves;
	private Double capacidadeDeArmazenamentoDeCombustivel;
	private TorreDeControle torreDeControle;
	private Aviao aviao;

	public String getNomeAeroporto() {
		return nomeAeroporto;
	}

	public void setNomeAeroporto(String nomeAeroporto) {
		this.nomeAeroporto = nomeAeroporto;
	}

	public LocalizacaoAeroporto getLocalizacaoAeroporto() {
		return localizacaoAeroporto;
	}

	public void setLocalizacaoAeroporto(LocalizacaoAeroporto localizacaoAeroporto) {
		this.localizacaoAeroporto = localizacaoAeroporto;
	}

	public Boolean getPermitidoPousoAeronaves() {
		return permitidoPousoAeronaves;
	}

	public void setPermitidoPousoAeronaves(Boolean permitidoPousoAeronaves) {
		this.permitidoPousoAeronaves = permitidoPousoAeronaves;
	}

	public List<Integer> getPortoesDeEmbarque() {
		return portoesDeEmbarque;
	}

	public void setPortoesDeEmbarque(List<Integer> portoesDeEmbarque) {
		this.portoesDeEmbarque = portoesDeEmbarque;
	}

	public Integer getLimiteMaximoAeronaves() {
		return limiteMaximoAeronaves;
	}

	public void setLimiteMaximoAeronaves(Integer limiteMaximoAeronaves) {
		this.limiteMaximoAeronaves = limiteMaximoAeronaves;
	}

	public Double getCapacidadeDeArmazenamentoDeCombustivel() {
		return capacidadeDeArmazenamentoDeCombustivel;
	}

	public void setCapacidadeDeArmazenamentoDeCombustivel(Double capacidadeDeArmazenamentoDeCombustivel) {
		this.capacidadeDeArmazenamentoDeCombustivel = capacidadeDeArmazenamentoDeCombustivel;
	}

	public TorreDeControle getTorreDeControle() {
		return torreDeControle;
	}

	public void setTorreDeControle(TorreDeControle torreDeControle) {
		this.torreDeControle = torreDeControle;
	}

	public Aviao getAviao() {
		return aviao;
	}

	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}
	

}
