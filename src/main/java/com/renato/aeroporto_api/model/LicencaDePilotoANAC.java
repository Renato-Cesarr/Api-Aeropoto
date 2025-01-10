package com.renato.aeroporto_api.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Table(name = "tb_licenca_de_piloto_anac")
@Entity(name = "LicencaDePilotoANAC")
public class LicencaDePilotoANAC {

    @Id
    @JsonProperty("numeroDaLicenca")
    @NotNull(message = "Número da licença é obrigatório")
    private Integer numeroDaLicenca;

    @JsonProperty("tipoDaLicenca")
    @NotNull(message = "Tipo da licença é obrigatório")
    private String tipoDaLicenca;

    @JsonProperty("dataEmissao")
    @NotNull(message = "Data de emissão é obrigatória")
    private Date dataEmissao;

    @JsonProperty("dataValidade")
    @NotNull(message = "Data de validade é obrigatória")
    private Date dataValidade;

    @JsonProperty("situacao")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Situação é obrigatória")
    private SituacaoLicenca situacao;

    public Integer getNumeroDaLicenca() {
        return numeroDaLicenca;
    }

    public void setNumeroDaLicenca(Integer numeroDaLicenca) {
        this.numeroDaLicenca = numeroDaLicenca;
    }

    public String getTipoDaLicenca() {
        return tipoDaLicenca;
    }

    public void setTipoDaLicenca(String tipoDaLicenca) {
        this.tipoDaLicenca = tipoDaLicenca;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public SituacaoLicenca getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoLicenca situacao) {
        this.situacao = situacao;
    }

    public enum SituacaoLicenca {
        ATIVA,
        SUSPENSA,
        CANCELADA,
        VENCIDA;
    }
}
