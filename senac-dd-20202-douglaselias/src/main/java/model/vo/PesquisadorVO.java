package model.vo;

import java.time.LocalDate;

public class PesquisadorVO extends PessoaVO {
	private String instituição;

	public PesquisadorVO(int id, String nome, LocalDate dtAniversario, String sexo, String cpf, VacinaVO vacina,
			String instituição) {
		super(id, nome, dtAniversario, sexo, cpf, vacina);
		this.instituição = instituição;
	}

	public PesquisadorVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getInstituição() {
		return instituição;
	}

	public void setInstituição(String instituição) {
		this.instituição = instituição;
	}

	
	
	
}
