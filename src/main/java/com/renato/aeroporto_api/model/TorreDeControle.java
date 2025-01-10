package com.renato.aeroporto_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name = "TB_TORRE_DE_CONTROLE")
@Entity(name = "TorreDeControle")
public class TorreDeControle {

	@Id
	@JsonProperty("nome")
	@NotBlank(message = "Informe um nome para torre de controle")
	private String nome;

	@JsonProperty
	@NotNull(message = "Informe o trafico atual")
	private Integer trafegoAereoAtual;

	@JsonProperty
	@NotBlank(message = "Infome o equipamento de comunicação")
	private String equipamentoComunicacao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTrafegoAereoAtual() {
		return trafegoAereoAtual;
	}

	public void setTrafegoAereoAtual(Integer trafegoAereoAtual) {
		this.trafegoAereoAtual = trafegoAereoAtual;
	}

	public String getEquipamentoComunicacao() {
		return equipamentoComunicacao;
	}

	public void setEquipamentoComunicacao(String equipamentoComunicacao) {
		this.equipamentoComunicacao = equipamentoComunicacao;
	}
}
