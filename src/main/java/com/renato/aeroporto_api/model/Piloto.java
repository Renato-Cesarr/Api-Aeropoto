package com.renato.aeroporto_api.model;

public class Piloto {

	private String nome;
	private LicencaDePilotoANAC licencaDePilotoANAC;
	private Integer horasDeVoo;
	private String statusDeSaude; // possivel enum

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LicencaDePilotoANAC getLicencaDePilotoANAC() {
		return licencaDePilotoANAC;
	}

	public void setLicencaDePilotoANAC(LicencaDePilotoANAC licencaDePilotoANAC) {
		this.licencaDePilotoANAC = licencaDePilotoANAC;
	}

	public Integer getHorasDeVoo() {
		return horasDeVoo;
	}

	public void setHorasDeVoo(Integer horasDeVoo) {
		this.horasDeVoo = horasDeVoo;
	}

	public String getStatusDeSaude() {
		return statusDeSaude;
	}

	public void setStatusDeSaude(String statusDeSaude) {
		this.statusDeSaude = statusDeSaude;
	}
}
