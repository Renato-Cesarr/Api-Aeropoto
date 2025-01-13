package com.renato.aeroporto_api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_aeroporto")
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "codigoIATA"
)
public class Aeroporto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoiata")
    private Long codigoIATA;

    @Column(name = "nome_aeroporto", nullable = false)
    private String nomeAeroporto;

    @Column(name = "permitido_pouso_aeronaves", nullable = false)
    private Boolean permitidoPousoAeronaves;

    @Column(name = "capacidade_de_armazenamento_de_combustivel")
    private Double capacidadeDeArmazenamentoDeCombustivel;

    @Column(name = "limite_maximo_aeronaves")
    private Integer limiteMaximoAeronaves;

    @ElementCollection
    @Column(name = "portoes_de_embarque")
    private List<Integer> portoesDeEmbarque;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_localizacao_aeroporto", unique = true)
    private LocalizacaoAeroporto localizacaoAeroporto;

    @OneToMany(mappedBy = "aeroporto", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Aviao> avioes;

    // Getters e Setters
    public Long getCodigoIATA() {
        return codigoIATA;
    }

    public void setCodigoIATA(Long codigoIATA) {
        this.codigoIATA = codigoIATA;
    }

    public String getNomeAeroporto() {
        return nomeAeroporto;
    }

    public void setNomeAeroporto(String nomeAeroporto) {
        this.nomeAeroporto = nomeAeroporto;
    }

    public Boolean getPermitidoPousoAeronaves() {
        return permitidoPousoAeronaves;
    }

    public void setPermitidoPousoAeronaves(Boolean permitidoPousoAeronaves) {
        this.permitidoPousoAeronaves = permitidoPousoAeronaves;
    }

    public Double getCapacidadeDeArmazenamentoDeCombustivel() {
        return capacidadeDeArmazenamentoDeCombustivel;
    }

    public void setCapacidadeDeArmazenamentoDeCombustivel(Double capacidadeDeArmazenamentoDeCombustivel) {
        this.capacidadeDeArmazenamentoDeCombustivel = capacidadeDeArmazenamentoDeCombustivel;
    }

    public Integer getLimiteMaximoAeronaves() {
        return limiteMaximoAeronaves;
    }

    public void setLimiteMaximoAeronaves(Integer limiteMaximoAeronaves) {
        this.limiteMaximoAeronaves = limiteMaximoAeronaves;
    }

    public List<Integer> getPortoesDeEmbarque() {
        return portoesDeEmbarque;
    }

    public void setPortoesDeEmbarque(List<Integer> portoesDeEmbarque) {
        this.portoesDeEmbarque = portoesDeEmbarque;
    }

    public LocalizacaoAeroporto getLocalizacaoAeroporto() {
        return localizacaoAeroporto;
    }

    public void setLocalizacaoAeroporto(LocalizacaoAeroporto localizacaoAeroporto) {
        this.localizacaoAeroporto = localizacaoAeroporto;
    }

    public List<Aviao> getAvioes() {
        return avioes;
    }

    public void setAvioes(List<Aviao> avioes) {
        this.avioes = avioes;
    }
}
