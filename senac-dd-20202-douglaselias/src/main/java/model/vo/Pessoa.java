package model.vo;

public class Pessoa {
	private String nome;
	private String dataNascimento;
	private boolean sexo;
	private String cpf;
	private int reacao;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public boolean isSexo() {
		return sexo;
	}
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getReacao() {
		return reacao;
	}
	public void setReacao(int reacao) {
		this.reacao = reacao;
	}
	
	
}
