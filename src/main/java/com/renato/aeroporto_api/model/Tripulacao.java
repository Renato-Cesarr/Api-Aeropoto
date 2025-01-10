package com.renato.aeroporto_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name = "TB_tripulacao")
@Entity(name = "Tripulacao")
public class Tripulacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("idTripulacao")
	private Integer idTripulacao;
	
	@JsonProperty("nome")
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@JsonProperty("funcao")
	@NotBlank(message = "Informe a funcao do tripulante")
	private String funcao;
	
	@JsonProperty("numeroVoo")
	@NotNull(message = "Infome o numero do voo atual")
	private Integer numeroVoo;
	
	@JsonProperty("licenciamento")
	@NotBlank(message = "infome o licenciamento do tripulante")
	private String licenciamento;
	
	@JsonProperty("horasDeVoo")
	@NotNull(message = "Infome as horas de voo do tripulante")
	private Integer horasDeVoo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Integer getNumeroVoo() {
		return numeroVoo;
	}

	public void setNumeroVoo(Integer numeroVoo) {
		this.numeroVoo = numeroVoo;
	}

	public String getLicenciamento() {
		return licenciamento;
	}

	public void setLicenciamento(String licenciamento) {
		this.licenciamento = licenciamento;
	}

	public Integer getHorasDeVoo() {
		return horasDeVoo;
	}

	public void setHorasDeVoo(Integer horasDeVoo) {
		this.horasDeVoo = horasDeVoo;
	}
}
