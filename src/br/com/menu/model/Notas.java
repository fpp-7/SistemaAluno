package br.com.menu.model;

public class Notas {
	
	private int rgm;
	private String semestre;
	private String disciplina;
	private int falta;
	private String nota;
	private String rgmSemestreDisciplina;

	public Notas() {
		super();
	}
	
	public Notas(int rgm, String semestre, String disciplina, int falta, String nota) {
		super();
		this.rgm = rgm;
		this.semestre = semestre;
		this.disciplina = disciplina;
		this.falta = falta;
		this.nota = nota;
	}

	public String getRgmSemestreDisciplina() {
		return rgmSemestreDisciplina;
	}

	public void setRgmSemestreDisciplina(String rgmSemestreDisciplina) {
		this.rgmSemestreDisciplina = rgmSemestreDisciplina;
	}

	public int getRgm() {
		return rgm;
	}

	public void setRgm(int rgm) {
		this.rgm = rgm;
	}
	
	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public int getFalta() {
		return falta;
	}

	public void setFalta(int falta) {
		this.falta = falta;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}
}
