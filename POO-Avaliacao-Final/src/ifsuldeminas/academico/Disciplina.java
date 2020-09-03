package ifsuldeminas.academico;

import ifsuldeminas.funcionarios.Professor;

import java.util.ArrayList;
import java.util.Collections;


import ifsuldeminas.alunos.Aluno;

public class Disciplina {
	private String nome;
	private int periodo;
	private int numAulasSemana;
	private int numTotalaulas;

	// Permite passar os dados completo do objeto da classe professor
	Professor professor;

	// Listas
	ArrayList<Aluno> alunos = new ArrayList<>();
	ArrayList<Double> notas = new ArrayList<>();
	ArrayList<Integer> frequencias = new ArrayList<>();

	// Construtor
	public Disciplina(String nome, int periodo, int numAulasSemana, int numSemanas) {
		this.nome = nome;
		this.periodo = periodo;
		this.numAulasSemana = numAulasSemana;
		this.numTotalaulas = numAulasSemana * numSemanas;
	}

	// Construtor completo
	public Disciplina(String nome, int periodo, int numAulasSemana, int numSemanas, Professor professor,
			ArrayList<Aluno> alunos, ArrayList<Double> notas, ArrayList<Integer> frequencias) {
		this.nome = nome;
		this.periodo = periodo;
		this.numAulasSemana = numAulasSemana;
		this.numTotalaulas = numAulasSemana * numSemanas;
		this.professor = professor;
		this.alunos = alunos;
		this.notas = notas;
		this.frequencias = frequencias;
	}

	// Metodo Matricular Aluno
	public boolean matricularAluno(Aluno aluno) {
		   //for (int i = 0; i < alunos.size(); i++) {
			//if (alunos.get(i).getRa() != alunos.get(i).getRa()) {
				alunos.add(aluno);
				notas.add((double) 0);
				frequencias.add(0);
				return true;
			//}
		//}
		//return false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public int getNumAulasSemana() {
		return numAulasSemana;
	}

	public void setNumAulasSemana(int numAulasSemana) {
		this.numAulasSemana = numAulasSemana;
	}

	public int getNumTotalaulas() {
		return numTotalaulas;
	}

	public void setNumTotalaulas(int numTotalaulas) {
		this.numTotalaulas = numTotalaulas;
	}

	// Metodo Para desmatricular Aluno
	public boolean desmatriculaAluno(int posAluno) {
		for (int i = 0; i < alunos.size(); i++) {
			if (i == posAluno) {
				alunos.add(null);
				notas.add(null);
				frequencias.add(null);
				return true;
			}
		}
		return false;
	}

	// Metodo para add proferro
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	// Metodo para remover professor
	public void removerProfessor() {
		this.professor = null;
	}

	// Metodo para ternar o numero de alunos add em uma diciplina
	public int getNumerosAlunos() {
		int totaldealunosmatriculados = 0;
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i) != null) {
				totaldealunosmatriculados = totaldealunosmatriculados + 1;
			}
		}
		return totaldealunosmatriculados;
	}

	// Metodo para add Nota
	public boolean addNota(int posAluno, double nota) {
		//if (nota < 0 && nota > 10) {
			for (int i = 0; i < alunos.size(); i++) {
				if (i == posAluno) {
					notas.add(nota);
					return true;
				}
			}
		//}
		return false;
	}

	// Metodo para add Frenquencia do Aluno
	public boolean addFrequencia(int posAluno, int frequenciaTotal) {
		if (frequenciaTotal < 0 && this.numTotalaulas > 10) {
			for (int i = 0; i < alunos.size(); i++) {
				if (i == posAluno) {
					frequencias.add(frequenciaTotal);
					return true;
				}
			}
		}
		return false;
	}
    /// ###################  teste de for #####################
	public void teste () {
		System.out.println("TESTE");
		for (int i = 0; i < alunos.size(); i++) {
			System.out.println("Valores" );
		}
		System.out.println("Nada");
	}
		
	// Metodo para verificar se esta aprovado
	public boolean estaAprovado(int posAluno) {
		for (int i = 0; i < alunos.size(); i++) {
			if (i == posAluno) {
				if (notas.get(i) >= 6 && frequencias.get(i) >= 75) {
					return true;
				}
			}
		}
		return false;
	}

	// Metodos para exibir Reprovados
	public void exibirReprovados() {
		boolean valor;
		for (int i = 0; i < alunos.size(); i++) {
			valor = estaAprovado(i);
			if(valor == true) {
				System.out.println("Alunos Aprovados" + alunos.get(i).getNome());
			}
		}
    

	}

	// Metodo para exibir Aprovados
	public void exibirAprovados() {
		int totalreprovado = 0;
		int totalalunos = 0;
		for (int i = 0; i < alunos.size(); i++) {
			if (notas.get(i) < 6 && frequencias.get(i) < 75) {
				totalreprovado = totalreprovado + 1;
			}
			if (alunos.get(i) != null) {
				totalalunos = totalalunos + 1;
			}
		}
		if (alunos.size() == totalreprovado) {
			System.out.println("Nao ha alunos aprovados");
		}
		if (alunos.size() == totalalunos) {
			System.out.println("Disciplina não possui alunos matriculados");
		}

	}

	// Metodo Calcular Media
	public double calcularMedia() {
		double mediatotal;
		double media = 0;
		int total = 0;
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i) != null) {
				media = media + notas.get(i);
				total = total + 1;
			}
		}
		mediatotal = media / total;
		return mediatotal;

	}

	// Exibir Maior nota
	public void exibirMaiorNota() {
		double maior = 0;
		for (int i = 0; i < alunos.size(); i++) {
			if (notas.get(i) > maior) {
				maior = notas.get(i);
			}
		}
		for (int i = 0; i < alunos.size(); i++) {
			if ( i == maior) {
				System.out.println("Aluno Com Maior nota");
				System.out.println("Nome: " + alunos.get(i).getNome());
				System.out.println("RA: " + alunos.get(i).getRa());
			}
		}

	}

	// Exibir aluno com menor nota
	public void exibirMenorNota() {
		double menor = 0;
		for (int i = 0; i < alunos.size(); i++) {
			if (notas.get(i) < menor) {
				menor = notas.get(i);
			}
		}

		for (int i = 0; i < alunos.size(); i++) {
			if (i == menor) {
				System.out.println("Aluno Com Menor nota");
				System.out.println("Nome: " + alunos.get(i).getNome());
				System.out.println("RA: " + alunos.get(i).getRa());
			}
		}

	}

	// Quantidades de Reprovados
	public void getQuantidadeReprovados() {
		int totalreprovado = 0;
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i) != null) {
				if (notas.get(i) < 6 && frequencias.get(i) < 75) {
					totalreprovado = totalreprovado + 1;
				}
			}
		}
		System.out.println("Total de Alunos Reprovados" + totalreprovado);
	}

	// Quantidades de Aprovados
	public void getQuantidadeAprovados() {
		int totalAprovados = 0;
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i) != null) {
				if (notas.get(i) > 6 && frequencias.get(i) > 75) {
					totalAprovados = totalAprovados + 1;
				}
			}

		}
		System.out.println("Total de Alunos Reprovados" + totalAprovados);
	}

	// Exibir Professor
	public void exibirProfessor() {
		if (professor == null) {
			System.out.println("Disciplina nao possui professor");
		} else {
			System.out.println("Professor: " + professor.getNome());
		}

	}

	// Aproveitamento do Aluno
	public int getAproveitamentoAluno(int posAluno) {
		double metade = this.numTotalaulas / 2;
		int retorno = 0;
		for (int i = 0; i < alunos.size(); i++) {
			if (posAluno == i) {
				if (frequencias.get(i) == this.numTotalaulas) {
					retorno = 100;
				}
				if (frequencias.get(i) <= metade) {
					retorno = 50;
				}

			}
		}
		return retorno;

	}

	// Nota do aluno
	public void getNotaAluno(int posAluno) {
		for (int i = 0; i < alunos.size(); i++) {
			if (posAluno == i) {
				System.out.println("Nota do Aluno: " + notas.get(i));
			}
		}
	}

	// Exibir Alunos Acima da media
	public void exibirAlunosAcimaMedia() {
		double mediatotal = calcularMedia();
		int totalalunos = getNumerosAlunos();
		if (totalalunos != 0) {
			System.out.println("Alunos Acima da Media");
			for (int i = 0; i < alunos.size(); i++) {
				if (notas.get(i) >= mediatotal) {
					System.out.println("Nome: " + alunos.get(i).getNome());
				}
			}
		} else {
			System.out.println("Disciplina nao possui alunos matriculados ");
		}
	}

	// Exibir Alunos a Baixo da Media
	public void exibirAlunosAbaixoMedia() {
		double mediatotal = calcularMedia();
		int totalalunos = getNumerosAlunos();
		if (totalalunos != 0) {
			System.out.println("Alunos Abaixo da Media");
			for (int i = 0; i < alunos.size(); i++) {
				if (notas.get(i) < mediatotal) {
					System.out.println("Nome: " + alunos.get(i).getNome());
				}
			}
		} else {
			System.out.println("Disciplina nao possui alunos matriculados ");
		}
	}

	// Exibir Aproveitamento
	public void exibirAlunoNotaAproveitamento() {
		int totalalunos = getNumerosAlunos();
		if (totalalunos > 0) {
			for (int i = 0; i < alunos.size(); i++) {
				if (alunos.get(i) != null) {
					System.out.println("Nome : " + alunos.get(i).getNome());
					System.out.println("Notas : " + notas.get(i));
					System.out.println("Aproveitamento : " + getAproveitamentoAluno(i));
				}
			}

		} else {
			System.out.println("Disciplina nao possui alunos matriculados ");
		}

	}

	// Metodo para Desmatricular todos Alunos
	public void desmatricularAlunos() {
		for (int i = 0; i < alunos.size(); i++) {
			desmatriculaAluno(i);

		}
	}
	//Exibir ordem por Notas 
	public void exibirOrdenadosPorNotas(){
	 Collections.sort(notas);	
	 System.out.println("Ordem: " + notas);
	 
	}
	
	public void exibirDisciplina() {
		
		
	}
	

}// FIM DA CLASSE
