package ifsuldeminas.alunos;

public class Aluno {
	private String nome;
	private int ra;
	private int periodo;
	private String curso;

	public Aluno(String nome, int ra, String curso) {
		if(ra > 1000 || ra < 9999 ) {
		this.nome = nome;
		this.ra = ra;
		this.curso = curso;
		this.periodo = 1;
		}
	}

	public Aluno(String nome, int ra, int periodo, String curso) {
		if(ra > 1000 || ra < 9999 ) {
		this.nome = nome;
		this.ra = ra;
		this.periodo = periodo;
		this.curso = curso;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
    // Metodo para exibir as informacao dos alunos	
	public void exibirAluno() {
		System.out.println("Nome: " + getNome());
		System.out.println("Ra: " + getRa());
		System.out.println("Periodo: " + getPeriodo());
		System.out.println("Curso: "+ getCurso());
	}

}
