package model.vo;

import java.time.LocalDate;

public class PesquisadorVO extends PessoaVO {
	private String institui��o;

	public PesquisadorVO(int id, String nome, LocalDate dtAniversario, String sexo, String cpf, VacinaVO vacina,
			String institui��o) {
		super(id, nome, dtAniversario, sexo, cpf, vacina);
		this.institui��o = institui��o;
	}

	public PesquisadorVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getInstitui��o() {
		return institui��o;
	}

	public void setInstitui��o(String institui��o) {
		this.institui��o = institui��o;
	}

	
	
	
}
