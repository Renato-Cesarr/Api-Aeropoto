package com.renato.aeroporto_api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@JsonPropertyOrder({
    "codigoIATA",
    "nomeAeroporto",
    "permitidoPousoAeronaves",
    "portoesDeEmbarque",
    "capacidadeDeArmazenamentoDeCombustivel",
    "limiteMaximoAeronaves",
    "localizacaoAeroporto",
    "avioes"
})
@Table(name = "TB_AEROPORTO")
@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Aeroporto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoiata")
    @JsonProperty("codigoIATA")
    private Integer codigoIATA;

    @NotNull
    @Column(name = "nome_aeroporto", nullable = false, length = 255)
    @JsonProperty("nomeAeroporto")
    private String nomeAeroporto;

    @NotNull
    @Column(name = "permitido_pouso_aeronaves", nullable = false)
    @JsonProperty("permitidoPousoAeronaves")
    private Boolean permitidoPousoAeronaves;

    @NotNull
    @ElementCollection
    @CollectionTable(
        name = "PORTOES_EMBARQUE",
        joinColumns = @JoinColumn(name = "fk_aeroporto")
    )
    @Column(name = "portoes_de_embarque", nullable = false)
    @JsonProperty("portoesDeEmbarque")
    private List<Integer> portoesDeEmbarque;

    @Column(name = "capacidade_de_armazenamento_de_combustivel")
    @JsonProperty("capacidadeDeArmazenamentoDeCombustivel")
    private Double capacidadeDeArmazenamentoDeCombustivel;

    @Column(name = "limite_maximo_aeronaves")
    @JsonProperty("limiteMaximoAeronaves")
    private Integer limiteMaximoAeronaves;

    @NotNull
    @OneToOne
    @JoinColumn(name = "fk_localizacao_aeroporto", unique = true, nullable = false)
    @JsonProperty("localizacaoAeroporto")
    private LocalizacaoAeroporto localizacaoAeroporto;

    @OneToMany(mappedBy = "aeroporto", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty("avioes")
    private List<Aviao> avioes;
    
    public List<Aviao> getAvioes() {
		return avioes;
	}

	public void setAvioes(List<Aviao> avioes) {
		this.avioes = avioes;
	}


    public Integer getCodigoIATA() {
        return codigoIATA;
    }

    public void setCodigoIATA(Integer codigoIATA) {
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

    public List<Integer> getPortoesDeEmbarque() {
        return portoesDeEmbarque;
    }

    public void setPortoesDeEmbarque(List<Integer> portoesDeEmbarque) {
        this.portoesDeEmbarque = portoesDeEmbarque;
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

    public LocalizacaoAeroporto getLocalizacaoAeroporto() {
        return localizacaoAeroporto;
    }

    public void setLocalizacaoAeroporto(LocalizacaoAeroporto localizacaoAeroporto) {
        this.localizacaoAeroporto = localizacaoAeroporto;
    }
}
