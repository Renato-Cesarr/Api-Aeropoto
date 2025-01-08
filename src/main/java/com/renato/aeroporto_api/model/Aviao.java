package com.renato.aeroporto_api.model;

public class Aviao {
	private String modelo;
	private String fabricante;
	private Integer numeroDeSerie;
	private Double capacidadeMaximaKg;
	private Integer capacidadeMaximaPessoas;
	private Piloto piloto;
	private Tripulacao tripulacao;
	private FlyAware flyAware;
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
