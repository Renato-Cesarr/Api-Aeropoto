package com.renato.aeroporto_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@JsonPropertyOrder({
    "numeroIdentificadorCarga",
    "pesoTotalCarga",
    "statusDaCarga",
    "tipoDeCarga"
})
@Table(name = "tb_carga")
@Entity(name = "Carga")
public class Carga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("numeroIdentificadorCarga")
    private Integer numeroIdentificadorCarga;

    @JsonProperty("pesoTotalCarga")
    private Float pesoTotalCarga;

    @JsonProperty("statusDaCarga")
    @Enumerated(EnumType.STRING)
    private StatusCarga statusDaCarga;

    @OneToOne(targetEntity = TipoDeCarga.class)
    @JoinColumn(name = "tipo_de_carga_ticket_da_carga") 
    private TipoDeCarga tipoDeCarga;

    public Integer getNumeroIdentificadorCarga() {
        return numeroIdentificadorCarga;
    }

    public void setNumeroIdentificadorCarga(Integer numeroIdentificadorCarga) {
        this.numeroIdentificadorCarga = numeroIdentificadorCarga;
    }

    public Float getPesoTotalCarga() {
        return pesoTotalCarga;
    }

    public void setPesoTotalCarga(Float pesoTotalCarga) {
        this.pesoTotalCarga = pesoTotalCarga;
    }

    public StatusCarga getStatusDaCarga() {
        return statusDaCarga;
    }

    public void setStatusDaCarga(StatusCarga statusDaCarga) {
        this.statusDaCarga = statusDaCarga;
    }

    public TipoDeCarga getTipoDeCarga() {
        return tipoDeCarga;
    }

    public void setTipoDeCarga(TipoDeCarga tipoDeCarga) {
        this.tipoDeCarga = tipoDeCarga;
    }

    public enum StatusCarga {
        EM_PROCESSO("Em processo"),
        ENTREGUE("Entregue"),
        PENDENTE("Pendente");

        private final String descricao;

        StatusCarga(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }
}
