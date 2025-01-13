package com.renato.aeroporto_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tripulacao")
public class Tripulacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tripulacao")
    private Long idTripulacao;

    @Column(name = "funcao", nullable = false)
    private String funcao;

    @Column(name = "horas_de_voo", nullable = false)
    private Integer horasDeVoo;

    @Column(name = "licenciamento", nullable = false)
    private String licenciamento;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "numero_voo", nullable = false)
    private Integer numeroVoo;

	public Long getIdTripulacao() {
		return idTripulacao;
	}

	public void setIdTripulacao(Long idTripulacao) {
		this.idTripulacao = idTripulacao;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Integer getHorasDeVoo() {
		return horasDeVoo;
	}

	public void setHorasDeVoo(Integer horasDeVoo) {
		this.horasDeVoo = horasDeVoo;
	}

	public String getLicenciamento() {
		return licenciamento;
	}

	public void setLicenciamento(String licenciamento) {
		this.licenciamento = licenciamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumeroVoo() {
		return numeroVoo;
	}

	public void setNumeroVoo(Integer numeroVoo) {
		this.numeroVoo = numeroVoo;
	}

}
