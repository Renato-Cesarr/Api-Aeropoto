package com.renato.aeroporto_api.model;

import java.util.Date;

public class LicencaDePilotoANAC {

	private Integer numeroDaLincenca;
	private String tipoDaLicenca;
	private Date dataEmissao;
	private Date dataValidade;
	private String situacao; // possivel enum

	public Integer getNumeroDaLincenca() {
		return numeroDaLincenca;
	}

	public void setNumeroDaLincenca(Integer numeroDaLincenca) {
		this.numeroDaLincenca = numeroDaLincenca;
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

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
