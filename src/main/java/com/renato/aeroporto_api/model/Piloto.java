package com.renato.aeroporto_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name = "TB_PILOTO")
@Entity(name = "Piloto")
public class Piloto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("idPiloto")
	private Integer idPiloto;

	@JsonProperty("nome")
	@NotBlank(message = "Nome é obrigatório")
	private String nome;

	@JsonProperty("horasDeVoo")
	@NotNull(message = "Horas de voo são obrigatórias")
	@Min(value = 0, message = "Horas de voo não podem ser negativas")
	private Integer horasDeVoo;

	@JsonProperty("statusDeSaude")
	@NotNull(message = "Status de saúde é obrigatório")
	@Enumerated(EnumType.STRING)
	private StatusDeSaude statusDeSaude;
	
	@OneToOne(targetEntity = LicencaDePilotoANAC.class)
	@JoinColumn(name = "fk_LicencaDePilotoANAC")
	@JsonProperty("LicencaDePilotoANAC")
	@NotNull(message = "Licenca De Piloto nao pode ser vazio")
	private LicencaDePilotoANAC licencaDePilotoANAC;

	public Integer getIdPiloto() {
		return idPiloto;
	}

	public void setIdPiloto(Integer idPiloto) {
		this.idPiloto = idPiloto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LicencaDePilotoANAC getLicencaDePilotoANAC() {
		return licencaDePilotoANAC;
	}

	public void setLicencaDePilotoANAC(LicencaDePilotoANAC licencaDePilotoANAC) {
		this.licencaDePilotoANAC = licencaDePilotoANAC;
	}

	public Integer getHorasDeVoo() {
		return horasDeVoo;
	}

	public void setHorasDeVoo(Integer horasDeVoo) {
		this.horasDeVoo = horasDeVoo;
	}

	public StatusDeSaude getStatusDeSaude() {
		return statusDeSaude;
	}

	public void setStatusDeSaude(StatusDeSaude statusDeSaude) {
		this.statusDeSaude = statusDeSaude;
	}

	public enum StatusDeSaude {
		APTO, INAPTO, EM_RECUPERACAO;
	}
}
