package com.renato.aeroporto_api.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_piloto")
public class Piloto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_piloto")
    private Long idPiloto;

    @Column(name = "horas_de_voo", nullable = false)
    private Integer horasDeVoo;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "status_de_saude", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusSaude statusDeSaude;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_licenca_de_piloto_anac") 
    private LicencaDePilotoAnac licencaDePilotoAnac;

    public enum StatusSaude {
        APTO, INAPTO, EM_RECUPERACAO;
    }

    public Long getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(Long idPiloto) {
        this.idPiloto = idPiloto;
    }

    public Integer getHorasDeVoo() {
        return horasDeVoo;
    }

    public void setHorasDeVoo(Integer horasDeVoo) {
        this.horasDeVoo = horasDeVoo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusSaude getStatusDeSaude() {
        return statusDeSaude;
    }

    public void setStatusDeSaude(StatusSaude statusDeSaude) {
        this.statusDeSaude = statusDeSaude;
    }

    public LicencaDePilotoAnac getLicencaDePilotoAnac() {
        return licencaDePilotoAnac;
    }

    public void setLicencaDePilotoAnac(LicencaDePilotoAnac licencaDePilotoAnac) {
        this.licencaDePilotoAnac = licencaDePilotoAnac;
    }
}
