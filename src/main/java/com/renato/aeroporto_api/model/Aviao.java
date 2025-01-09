package com.renato.aeroporto_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name = "TB_AVIAO")
@Entity(name = "Aviao")

public class Aviao {
	@Id
	@JsonProperty("numeroDeSerie")
	@NotNull(message ="Numero de serie é obrigatorio")
	private Integer numeroDeSerie;

	@JsonProperty("modelo")
	@NotBlank(message = "Numero modelo obrigatorio")
	private String modelo;
	
	@JsonProperty("fabricante")
	@NotBlank(message = "Nome fabricante obrigatorio")
	private String fabricante;
	
	@JsonProperty("capacidadeMaximaKg")
	@NotNull(message = "Capacidade maxima de Kg obrigatorio")
	private Double capacidadeMaximaKg;
	
	@JsonProperty("capacidadeMaximaPessoas")
	@NotBlank(message = "Capacidade maxima pessoas obrigatorio")
	private Integer capacidadeMaximaPessoas;
	
	@OneToOne(targetEntity = Piloto.class)
	@JoinColumn(name = "fk_piloto")
	@JsonProperty("piloto")
	@NotNull(message = "piloto nao pode ser vazio")
	private Piloto piloto;
	
	@OneToOne(targetEntity = Tripulacao.class)
	@JoinColumn(name = "fk_tripulacao")
	@JsonProperty("tripulacao")
	@NotNull(message = "piloto nao pode ser vazio")
	private Tripulacao tripulacao;
	
	@OneToOne(targetEntity =  FlyAware.class)
	@JoinColumn(name = "fk_flyAware")
	@JsonProperty("flwAware")
	@NotNull(message = "FlwAware nao pode ser vazio")
	private FlyAware flyAware;
	
	@OneToMany(targetEntity = Passageiro.class)
	@JoinColumn(name = "fk_passageiro")
	@JsonProperty("fk_passageiro")
	@NotNull(message = "fk_passageiro nao pode ser vazio")
	private Passageiro passageiro;
	

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Integer getNumeroDeSerie() {
		return numeroDeSerie;
	}

	public void setNumeroDeSerie(Integer numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}

	public Double getCapacidadeMaximaKg() {
		return capacidadeMaximaKg;
	}

	public void setCapacidadeMaximaKg(Double capacidadeMaximaKg) {
		this.capacidadeMaximaKg = capacidadeMaximaKg;
	}

	public Integer getCapacidadeMaximaPessoas() {
		return capacidadeMaximaPessoas;
	}

	public void setCapacidadeMaximaPessoas(Integer capacidadeMaximaPessoas) {
		this.capacidadeMaximaPessoas = capacidadeMaximaPessoas;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public Tripulacao getTripulacao() {
		return tripulacao;
	}

	public void setTripulacao(Tripulacao tripulacao) {
		this.tripulacao = tripulacao;
	}

	public FlyAware getFlyAware() {
		return flyAware;
	}

	public void setFlyAware(FlyAware flyAware) {
		this.flyAware = flyAware;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
}
