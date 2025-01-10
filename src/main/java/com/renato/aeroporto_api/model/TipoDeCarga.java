package com.renato.aeroporto_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_tipo_de_carga")
public class TipoDeCarga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("ticketDaCarga")
    private Integer ticketDaCarga;

    @JsonProperty("categoriaCarga")
    @NotBlank(message = "Categoria da carga é obrigatória")
    private String categoriaCarga;

    @JsonProperty("cargaFragil")
    private Boolean cargaFragil;

    @JsonProperty("temperaturaDaCarga")
    private Double temperaturaDaCarga;

    @Enumerated(EnumType.STRING)
    @Column(name = "classificacao_periculosidade") 
    @JsonProperty("classificacaoPericulosidade")
    @NotNull(message = "Classificação de periculosidade é obrigatória")
    private ClassificacaoPericulosidade classificacaoPericulosidade;

    public Integer getTicketDaCarga() {
        return ticketDaCarga;
    }

    public void setTicketDaCarga(Integer ticketDaCarga) {
        this.ticketDaCarga = ticketDaCarga;
    }

    public String getCategoriaCarga() {
        return categoriaCarga;
    }

    public void setCategoriaCarga(String categoriaCarga) {
        this.categoriaCarga = categoriaCarga;
    }

    public Boolean getCargaFragil() {
        return cargaFragil;
    }

    public void setCargaFragil(Boolean cargaFragil) {
        this.cargaFragil = cargaFragil;
    }

    public Double getTemperaturaDaCarga() {
        return temperaturaDaCarga;
    }

    public void setTemperaturaDaCarga(Double temperaturaDaCarga) {
        this.temperaturaDaCarga = temperaturaDaCarga;
    }

    public ClassificacaoPericulosidade getClassificacaoPericulosidade() {
        return classificacaoPericulosidade;
    }

    public void setClassificacaoPericulosidade(ClassificacaoPericulosidade classificacaoPericulosidade) {
        this.classificacaoPericulosidade = classificacaoPericulosidade;
    }

    public enum ClassificacaoPericulosidade {
        BAIXA,
        MEDIA,
        ALTA
    }
}
