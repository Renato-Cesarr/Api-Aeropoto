package com.renato.aeroporto_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name = "TB_LOCALIZACAO_AEROPORTO")
@Entity(name = "LocalizacaoAeroporto")
public class LocalizacaoAeroporto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idLocalizacao")
	private Integer idLocalizacao;
	
	@JsonProperty("endereco")
	@NotBlank(message = "Endereço é obrigatório")
	private String endereco;
	
	@JsonProperty("cidade")
	@NotBlank(message = "Cidade é obrigatória")
	private String cidade;
	
	@JsonProperty("estado")
	@NotBlank(message = "estado é obrigatório")
	private String estado;
	
	@JsonProperty("cep")
	@NotBlank(message = "cep é obrigatório")
	private String cep;

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public Integer getIdLocalizacao() {
		return idLocalizacao;
	}

	public void setIdLocalizacao(Integer idLocalizacao) {
		this.idLocalizacao = idLocalizacao;
	}

}
