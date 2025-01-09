package com.renato.aeroporto_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name = "TB_PASSAGEIRO")
@Entity(name = "Passageiro")
public class Passageiro {

	@Id
	@JsonProperty("numeroBilhete")
	@NotNull(message = "Número do bilhete é obrigatório")
	private Integer numeroBilhete;

	@JsonProperty("nome")
	@NotBlank(message = "Nome é obrigatório")
	private String nome;

	@JsonProperty("assento")
	@NotBlank(message = "Assento é obrigatório")
	private String assento;

	@JsonProperty("statusEmbarque")
	@NotNull(message = "Status de embarque é obrigatório")
	@Enumerated(EnumType.STRING)
	private StatusEmbarque statusEmbarque;

	@OneToMany
	@JsonProperty("carga")
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

	public StatusEmbarque getStatusEmbarque() {
		return statusEmbarque;
	}

	public void setStatusEmbarque(StatusEmbarque statusEmbarque) {
		this.statusEmbarque = statusEmbarque;
	}

	public Carga getCarga() {
		return carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
	}

	public enum StatusEmbarque {
		CHECK_IN, EMBARCADO, NAO_EMBARCADO, CANCELADO;
	}
}
