package com.renato.aeroporto_api.model;

public class TipoDeCarga {

	private String categoraCarga;
	private Boolean cargaFragil;
	private Double temperaturaDaCarga;
	private Boolean classificacaoPericulosidade;

	public String getCategoraCarga() {
		return categoraCarga;
	}

	public void setCategoraCarga(String categoraCarga) {
		this.categoraCarga = categoraCarga;
	}

	public Boolean getCargaFragil() {
		return cargaFragil;
	}

	public void setCargaFragil(Boolean cargaFragil) {
		this.cargaFragil = cargaFragil;
	}

	public Double getTemperaturaDaCarga() {
		return temperaturaDaCarga;
	}

	public void setTemperaturaDaCarga(Double temperaturaDaCarga) {
		this.temperaturaDaCarga = temperaturaDaCarga;
	}

	public Boolean getClassificacaoPericulosidade() {
		return classificacaoPericulosidade;
	}

	public void setClassificacaoPericulosidade(Boolean classificacaoPericulosidade) {
		this.classificacaoPericulosidade = classificacaoPericulosidade;
	}
}
