package model.vo;

import java.time.LocalDate;

public class PessoaVO {
		private int id;
		private String nome;
		private LocalDate dtAniversario;
		private String sexo;
		private String cpf;
		private VacinaVO vacina;
		
		public PessoaVO(int id, String nome, LocalDate dtAniversario, String sexo, String cpf, VacinaVO vacina) {
			super();
			this.id = id;
			this.nome = nome;
			this.dtAniversario = dtAniversario;
			this.sexo = sexo;
			this.cpf = cpf;
			this.vacina = vacina;
		}

		public PessoaVO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public LocalDate getDtAniversario() {
			return dtAniversario;
		}

		public void setDtAniversario(LocalDate dtAniversario) {
			this.dtAniversario = dtAniversario;
		}

		public String getSexo() {
			return sexo;
		}

		public void setSexo(String sexo) {
			this.sexo = sexo;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public VacinaVO getVacina() {
			return vacina;
		}

		public void setVacina(VacinaVO vacina) {
			this.vacina = vacina;
		}
		
		
		
		
	
		
}
