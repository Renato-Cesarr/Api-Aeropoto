package com.renato.aeroporto_api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_licenca_de_piloto_anac")
public class LicencaDePilotoAnac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_da_licenca")
    private Long numeroDaLicenca;

    @Column(name = "data_emissao", nullable = false)
    private LocalDateTime dataEmissao;

    @Column(name = "data_validade", nullable = false)
    private LocalDateTime dataValidade;

    @Column(name = "situacao", nullable = false)
    private SituacaoLicenca situacao;

    @Column(name = "tipo_da_licenca", nullable = false)
    private String tipoDaLicenca;

    public enum SituacaoLicenca {
        ATIVA, SUSPENSA, CANCELADA, VENCIDA;
    }

    public Long getNumeroDaLicenca() {
        return numeroDaLicenca;
    }

    public void setNumeroDaLicenca(Long numeroDaLicenca) {
        this.numeroDaLicenca = numeroDaLicenca;
    }

    public LocalDateTime getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public LocalDateTime getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDateTime dataValidade) {
        this.dataValidade = dataValidade;
    }

    public SituacaoLicenca getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoLicenca situacao) {
        this.situacao = situacao;
    }

    public String getTipoDaLicenca() {
        return tipoDaLicenca;
    }

    public void setTipoDaLicenca(String tipoDaLicenca) {
        this.tipoDaLicenca = tipoDaLicenca;
    }
}
