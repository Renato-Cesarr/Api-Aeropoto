package com.renato.aeroporto_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_flwaware")
public class FlyAware {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rota")
    private Long idRota;

    @Column(name = "destino", nullable = false)
    private String destino;

    @Column(name = "numero_da_rota", nullable = false)
    private Integer numeroDaRota;

    @Column(name = "origem", nullable = false)
    private String origem;

    @Column(name = "tempo_estimado_voo", nullable = false)
    private Double tempoEstimadoVoo;

	public Long getIdRota() {
		return idRota;
	}

	public void setIdRota(Long idRota) {
		this.idRota = idRota;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Integer getNumeroDaRota() {
		return numeroDaRota;
	}

	public void setNumeroDaRota(Integer numeroDaRota) {
		this.numeroDaRota = numeroDaRota;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public Double getTempoEstimadoVoo() {
		return tempoEstimadoVoo;
	}

	public void setTempoEstimadoVoo(Double tempoEstimadoVoo) {
		this.tempoEstimadoVoo = tempoEstimadoVoo;
	}

}
