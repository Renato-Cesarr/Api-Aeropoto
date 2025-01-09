package com.renato.aeroporto_api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name = "TB_AEROPORTO")
@Entity(name = "Aeroporto")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Aeroporto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("códigoIATA")
	private Integer códigoIATA;

	@JsonProperty("nomeAeroporto")
	@NotNull
	private String nomeAeroporto;

	@JsonProperty("permitidoPousoAeronaves")
	@Column(unique = true)
	@NotBlank
	private Boolean permitidoPousoAeronaves;

	@JsonProperty("portoesDeEmbarque")
	@NotBlank(message = "{informe pelo menos 1 portão}")
	private List<Integer> portoesDeEmbarque;

	@JsonProperty("capacidadeDeArmazenamentoDeCombustivel")
	private Double capacidadeDeArmazenamentoDeCombustivel;

	@JsonProperty("limiteMaximoAeronaves")
	private Integer limiteMaximoAeronaves;

	@NotNull
	@OneToOne(targetEntity = LocalizacaoAeroporto.class)
	@JoinColumn(name = "fk_localizacaoAeroporto")
	private LocalizacaoAeroporto localizacaoAeroporto;


	@NotNull
	@OneToMany(targetEntity = TorreDeControle.class)
	@JoinColumn(name = "fk_torreDeControle")
	private TorreDeControle torreDeControle;


	@NotNull
	@OneToMany(targetEntity = Aviao.class)
	@JoinColumn(name = "fk_aviao")
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

	public Integer getCódigoIATA() {
		return códigoIATA;
	}

	public void setCódigoIATA(Integer códigoIATA) {
		this.códigoIATA = códigoIATA;
	}

}
