package model.vo;

import java.time.LocalDate;

public class PublicoGeralVO extends PessoaVO {
		
	private boolean voluntarios;
	

	public PublicoGeralVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PublicoGeralVO(int id, String nome, LocalDate dtAniversario, String sexo, String cpf, VacinaVO vacina,
			boolean voluntarios) {
		super(id, nome, dtAniversario, sexo, cpf, vacina);
		this.voluntarios = voluntarios;
	}

	public boolean isVoluntarios() {
		return voluntarios;
	}

	public void setVoluntarios(boolean voluntarios) {
		this.voluntarios = voluntarios;
	}

	
	
	

}
