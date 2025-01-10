package com.renato.aeroporto_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name = "tb_flwaware") 
@Entity(name = "FlyAware")
public class FlyAware {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idRota")
    private Integer idRota;

    @JsonProperty("numeroDaRota")
    @NotNull(message = "Numero da rota é obrigatório")
    private Integer numeroDaRota;

    @JsonProperty("origem")
    @NotBlank(message = "Origem do destino é obrigatória")
    private String origem;

    @JsonProperty("destino")
    @NotBlank(message = "Destino é obrigatório")
    private String destino;

    @JsonProperty("tempoEstimadoVoo")
    @NotNull(message = "Tempo de voo é obrigatório")
    private Float tempoEstimadoVoo; 

    public Integer getIdRota() {
        return idRota;
    }

    public void setIdRota(Integer idRota) {
        this.idRota = idRota;
    }

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

    public Float getTempoEstimadoVoo() {
        return tempoEstimadoVoo;
    }

    public void setTempoEstimadoVoo(Float tempoEstimadoVoo) {
        this.tempoEstimadoVoo = tempoEstimadoVoo;
    }
}
