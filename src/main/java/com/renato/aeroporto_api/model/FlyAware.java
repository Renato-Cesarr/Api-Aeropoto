package com.renato.aeroporto_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name = "TB_FLWAWARE")
@Entity(name = "FlyAware")
public class FlyAware {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idRota")
	private Integer idRota;
	
	@JsonProperty("numeroDaRota")
	@NotNull(message = "numero da obrigatorio")
	private Integer numeroDaRota;
	
	@JsonProperty("origem")
	@NotBlank(message = "Origem do destino é obrigatorio")
	private String origem;
	
	@JsonProperty("destino")
	@NotBlank(message = "Destino é obrigatorio")
	private String destino;
	
	@JsonProperty("tempoEstimadoVoo")
	@NotNull(message = "Tempo de voo é obrigatorio")
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
