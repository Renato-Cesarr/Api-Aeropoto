package com.renato.aeroporto_api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@Table(name = "tb_aviao")
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "numeroDeSerie"
)
public class Aviao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_de_serie")
    private Long numeroDeSerie;

    @Column(name = "capacidade_maxima_kg", nullable = false)
    private Double capacidadeMaximaKg;

    @Column(name = "capacidade_maxima_pessoas", nullable = false)
    private Integer capacidadeMaximaPessoas;

    @Column(name = "fabricante", nullable = false)
    private String fabricante;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @OneToMany(mappedBy = "aviao", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference  
    private List<Passageiro> passageiros;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_fly_aware", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  
    private FlyAware flyAware;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_piloto", nullable = false)
    private Piloto piloto;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_tripulacao", nullable = false)
    private Tripulacao tripulacao;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_aeroporto")
    private Aeroporto aeroporto;

    public Long getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(Long numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
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

    public String getFabricante() {
        return fabricante; 
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public List<Passageiro> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(List<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }

    public FlyAware getFlyAware() {
        return flyAware;
    }

    public void setFlyAware(FlyAware flyAware) {
        this.flyAware = flyAware;
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

    public Aeroporto getAeroporto() {
        return aeroporto;
    }

    public void setAeroporto(Aeroporto aeroporto) {
        this.aeroporto = aeroporto;
    }
}
