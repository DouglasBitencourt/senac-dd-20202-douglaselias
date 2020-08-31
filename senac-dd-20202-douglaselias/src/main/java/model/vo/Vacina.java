package model.vo;

import java.time.LocalDate;

public class Vacina {
	PesquisadorResponsavel Pesquisador;
	private String paisOrigem;
	private int estagioPesquisa;
	private LocalDate dataInicioPesquisa;
	private String nomePesquisador;
	private int aplicacao;
	public String getPaisOrigem() {
		return paisOrigem;
	}
	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}
	public int getEstagioPesquisa() {
		return estagioPesquisa;
	}
	public void setEstagioPesquisa(int estagioPesquisa) {
		this.estagioPesquisa = estagioPesquisa;
	}
	
	public LocalDate getDataInicioPesquisa() {
		return dataInicioPesquisa;
	}
	public void setDataInicioPesquisa(LocalDate dataInicioPesquisa) {
		this.dataInicioPesquisa = dataInicioPesquisa;
	}
	public String getNomePesquisador() {
		return nomePesquisador;
	}
	public void setNomePesquisador(String nomePesquisador) {
		this.nomePesquisador = nomePesquisador;
	}
	public int getAplicacao() {
		return aplicacao;
	}
	public void setAplicacao(int aplicacao) {
		this.aplicacao = aplicacao;
	}
	
	
}
