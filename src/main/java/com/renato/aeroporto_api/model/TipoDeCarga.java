package com.renato.aeroporto_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipo_de_carga")
public class TipoDeCarga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_da_carga")
    private Long ticketDaCarga;

    @Column(name = "carga_fragil")
    private Boolean cargaFragil;

    @Column(name = "categoria_carga")
    private String categoriaCarga;

    @Column(name = "classificacao_periculosidade")
    private ClassificacaoPericulosidade classificacaoPericulosidade;

    @Column(name = "temperatura_da_carga")
    private Double temperaturaDaCarga;

    public enum ClassificacaoPericulosidade {
        BAIXA, MEDIA, ALTA;
    }

	public Long getTicketDaCarga() {
		return ticketDaCarga;
	}

	public void setTicketDaCarga(Long ticketDaCarga) {
		this.ticketDaCarga = ticketDaCarga;
	}

	public Boolean getCargaFragil() {
		return cargaFragil;
	}

	public void setCargaFragil(Boolean cargaFragil) {
		this.cargaFragil = cargaFragil;
	}

	public String getCategoriaCarga() {
		return categoriaCarga;
	}

	public void setCategoriaCarga(String categoriaCarga) {
		this.categoriaCarga = categoriaCarga;
	}

	public ClassificacaoPericulosidade getClassificacaoPericulosidade() {
		return classificacaoPericulosidade;
	}

	public void setClassificacaoPericulosidade(ClassificacaoPericulosidade classificacaoPericulosidade) {
		this.classificacaoPericulosidade = classificacaoPericulosidade;
	}

	public Double getTemperaturaDaCarga() {
		return temperaturaDaCarga;
	}

	public void setTemperaturaDaCarga(Double temperaturaDaCarga) {
		this.temperaturaDaCarga = temperaturaDaCarga;
	}

}
