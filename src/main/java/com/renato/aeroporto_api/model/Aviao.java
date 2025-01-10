package com.renato.aeroporto_api.model;

import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "numeroDeSerie",
    "modelo",
    "fabricante",
    "capacidadeMaximaKg",
    "capacidadeMaximaPessoas",
    "piloto",
    "tripulacao",
    "flyAware",
    "passageiro"
})
@Table(name = "TB_AVIAO")
@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Aviao {

    @Id
    @Column(name = "numero_de_serie")
    @JsonProperty("numeroDeSerie")
    @NotNull(message = "Número de série é obrigatório")
    private Integer numeroDeSerie;

    @NotNull
    @Column(name = "modelo", nullable = false, length = 255)
    @JsonProperty("modelo")
    @NotBlank(message = "Modelo é obrigatório")
    private String modelo;

    @NotNull
    @Column(name = "fabricante", nullable = false, length = 255)
    @JsonProperty("fabricante")
    @NotBlank(message = "Fabricante é obrigatório")
    private String fabricante;

    @NotNull
    @Column(name = "capacidade_maxima_kg", nullable = false)
    @JsonProperty("capacidadeMaximaKg")
    private Double capacidadeMaximaKg;

    @NotNull
    @Column(name = "capacidade_maxima_pessoas", nullable = false)
    @JsonProperty("capacidadeMaximaPessoas")
    private Integer capacidadeMaximaPessoas;

    @NotNull
    @OneToOne
    @JoinColumn(name = "fk_piloto", unique = true, nullable = false)
    @JsonProperty("piloto")
    private Piloto piloto;

    @NotNull
    @OneToOne
    @JoinColumn(name = "fk_tripulacao", unique = true, nullable = false)
    @JsonProperty("tripulacao")
    private Tripulacao tripulacao;

    @NotNull
    @OneToOne
    @JoinColumn(name = "fk_fly_aware", unique = true, nullable = false)
    @JsonProperty("flyAware")
    private FlyAware flyAware;

    @OneToMany(targetEntity = Passageiro.class)
    @JoinColumn(name = "fk_aviao")
    @JsonProperty("passageiro")
    private List<Passageiro> passageiro;

    @ManyToOne
    @JoinColumn(name = "fk_aeroporto")
    @JsonProperty("aeroporto")
    private Aeroporto aeroporto;

    public Aeroporto getAeroporto() {
		return aeroporto;
	}

	public void setAeroporto(Aeroporto aeroporto) {
		this.aeroporto = aeroporto;
	}

	public Integer getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(Integer numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Double getCapacidadeMaximaKg() {
        return capacidadeMaximaKg;
    }

    public void setCapacidadeMaximaKg(Double capacidadeMaximaKg) {
        this.capacidadeMaximaKg = capacidadeMaximaKg;
    }

    public Integer getCapacidadeMaximaPessoas() {
        return capacidadeMaximaPessoas;
    }

    public void setCapacidadeMaximaPessoas(Integer capacidadeMaximaPessoas) {
        this.capacidadeMaximaPessoas = capacidadeMaximaPessoas;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Tripulacao getTripulacao() {
        return tripulacao;
    }

    public void setTripulacao(Tripulacao tripulacao) {
        this.tripulacao = tripulacao;
    }

    public FlyAware getFlyAware() {
        return flyAware;
    }

    public void setFlyAware(FlyAware flyAware) {
        this.flyAware = flyAware;
    }

    public List<Passageiro> getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(List<Passageiro> passageiro) {
        this.passageiro = passageiro;
    }
}
