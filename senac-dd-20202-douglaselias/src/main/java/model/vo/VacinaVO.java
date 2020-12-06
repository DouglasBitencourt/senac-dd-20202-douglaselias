package model.vo;

import java.time.LocalDate;

public class VacinaVO {
	private int id;
	private String pais;
	private String estagio;
	private LocalDate dtInicio;
	private PesquisadorVO pesquisador;
	private int evaluation;
	public VacinaVO(int id, String pais, String estagio, LocalDate dtInicio, PesquisadorVO pesquisador,
			int evaluation) {
		super();
		this.id = id;
		this.pais = pais;
		this.estagio = estagio;
		this.dtInicio = dtInicio;
		this.pesquisador = pesquisador;
		this.evaluation = evaluation;
	}
	public VacinaVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEstagio() {
		return estagio;
	}
	public void setEstagio(String estagio) {
		this.estagio = estagio;
	}
	public LocalDate getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(LocalDate dtInicio) {
		this.dtInicio = dtInicio;
	}
	public PesquisadorVO getPesquisador() {
		return pesquisador;
	}
	public void setPesquisador(PesquisadorVO pesquisador) {
		this.pesquisador = pesquisador;
	}
	public int getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}
	
	
}
