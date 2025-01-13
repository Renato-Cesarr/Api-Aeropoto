package com.renato.aeroporto_api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_carga")
public class Carga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_identificador_carga")
    private Long numeroIdentificadorCarga;

    @Column(name = "peso_total_carga")
    private Double pesoTotalCarga;

    @Column(name = "status_da_carga")
    private StatusCarga statusDaCarga;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_de_carga_ticket_da_carga")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoDeCarga tipoDeCarga;
    
    public enum StatusCarga {
        EM_PROCESSO, ENTREGUE, PENDENTE;
    }

	public Long getNumeroIdentificadorCarga() {
		return numeroIdentificadorCarga;
	}

	public void setNumeroIdentificadorCarga(Long numeroIdentificadorCarga) {
		this.numeroIdentificadorCarga = numeroIdentificadorCarga;
	}

	public Double getPesoTotalCarga() {
		return pesoTotalCarga;
	}

	public void setPesoTotalCarga(Double pesoTotalCarga) {
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

}
