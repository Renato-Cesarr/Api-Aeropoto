package com.renato.aeroporto_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name = "tb_tripulacao") 
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
    @NotBlank(message = "Informe a função do tripulante")
    private String funcao;

    @JsonProperty("numeroVoo")
    @NotNull(message = "Informe o número do voo atual")
    private Integer numeroVoo;

    @JsonProperty("licenciamento")
    @NotBlank(message = "Informe o licenciamento do tripulante")
    private String licenciamento;

    @JsonProperty("horasDeVoo")
    @NotNull(message = "Informe as horas de voo do tripulante")
    private Integer horasDeVoo;

    public Integer getIdTripulacao() {
        return idTripulacao;
    }

    public void setIdTripulacao(Integer idTripulacao) {
        this.idTripulacao = idTripulacao;
    }

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
