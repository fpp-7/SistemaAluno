package br.com.menu.model;


public class Aluno {

	private int rgm;
	private String nome;
	private String email;
	private String dtaNascimento;
	private String UF;
	private String municipio;
	private String endereco;
	private String cpf;
	private String celular;


	public Aluno() {

	}
	
	public Aluno(int rgm, String nome) {
		this.rgm = rgm;
		this.nome = nome;
	}

	
	public Aluno(int rgm, String nome, String cpf, String endereco, String UF, String municipio, 
			 String celular, String dtaNascimento, String email) {
		
	this.rgm = rgm;
	this.nome = nome;
	this.email = email;
	this.dtaNascimento = dtaNascimento;
	this.UF = UF;
	this.municipio = municipio;
	this.endereco = endereco;
	this.cpf = cpf;
	this.celular = celular;
}
	
	public int getRgm() {
		return rgm;
	}



	public void setRgm(int rgm) {
		this.rgm = rgm;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getDtaNascimento() {
		return dtaNascimento;
	}



	public void setDtaNascimento(String dtaNascimento) {
		this.dtaNascimento = dtaNascimento;
	}



	public String getUF() {
		return UF;
	}



	public void setUF(String uF) {
		UF = uF;
	}



	public String getMunicipio() {
		return municipio;
	}



	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
}

