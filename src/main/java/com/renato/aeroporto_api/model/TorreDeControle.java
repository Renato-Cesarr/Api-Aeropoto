	package com.renato.aeroporto_api.model;
	
	public class TorreDeControle {
		private String nome;
		private Integer trafegoAereoAtual;
		private String equipamentoComunicacao;
	
		public String getNome() {
			return nome;
		}
	
		public void setNome(String nome) {
			this.nome = nome;
		}
	
		public Integer getTrafegoAereoAtual() {
			return trafegoAereoAtual;
		}
	
		public void setTrafegoAereoAtual(Integer trafegoAereoAtual) {
			this.trafegoAereoAtual = trafegoAereoAtual;
		}
	
		public String getEquipamentoComunicacao() {
			return equipamentoComunicacao;
		}
	
		public void setEquipamentoComunicacao(String equipamentoComunicacao) {
			this.equipamentoComunicacao = equipamentoComunicacao;
		}
	}
