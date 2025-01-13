package com.renato.aeroporto_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "tb_passageiro")
public class Passageiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_bilhete")
    private Long numeroBilhete;

    @Column(name = "assento", nullable = false)
    private String assento;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "status_embarque")
    private String statusEmbarque;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_aviao")
    @JsonBackReference  
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  
    private Aviao aviao;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_carga")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  
    private Carga carga;

    public Long getNumeroBilhete() {
        return numeroBilhete;
    }

    public void setNumeroBilhete(Long numeroBilhete) {
        this.numeroBilhete = numeroBilhete;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatusEmbarque() {
        return statusEmbarque;
    }

    public void setStatusEmbarque(String statusEmbarque) {
        this.statusEmbarque = statusEmbarque;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

	public Carga getCarga() {
		return carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
	}
}