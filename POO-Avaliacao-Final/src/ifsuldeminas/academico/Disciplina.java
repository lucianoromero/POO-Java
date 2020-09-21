package ifsuldeminas.academico;

import ifsuldeminas.funcionarios.Professor;

import java.util.ArrayList;

import ifsuldeminas.alunos.Aluno;

public class Disciplina {
	/**
	 * @author Luciano Luiz Romero
	 * @version 1.0
	 */
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

	// ### ULTILIZADO CONSTRUTOR ####
	public Disciplina(String nome, int periodo, int numAulasSemana, int numSemanas) {
		this.nome = nome;
		this.periodo = periodo;
		this.numAulasSemana = numAulasSemana;
		this.numTotalaulas = numAulasSemana * numSemanas;
		this.professor = null;
	}

	// #### CONSTRUTOR COMPLETO ####
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

	// ################################################
	// ### METODO ULTILIZADO PARA MATRICULAR ALUNOS ###
	public boolean matricularAluno(Aluno aluno) {
		alunos.add(aluno);
		notas.add((double) 0);
		frequencias.add(0);
		return true;
	}

	// ##################################################
	// ### METODO ULTILIZADO PARA DESMATRICULAR ALUNO ###
	// ### DESMATRICULA CONFORME POSSICAO INFORMADA ###
	public boolean desmatricularAluno(int posAluno) {
		if (alunos.get(posAluno) != null) {
			alunos.remove(posAluno);
			notas.remove(posAluno);
			frequencias.remove(posAluno);
			return true;
		}

		return false;
	}

	// ############################################################
	// ### METODO ULTILIZADO PARA ADICIONAR O OBJETO PROFESSOR ###
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	// ################################################
	// ### METODO ULTILIZADO PARA REMOVER PROFESSOR ###
	public void removerProfessor() {
		this.professor = null;
	}

	// ##########################################################
	// ### METODO QUE RETORNA O NUMERO DE ALUNOS MATRICULADOS ###
	public int getNumerosAlunos() {
		return alunos.size();
	}

	// ##############################################
	// ### METODO ULTILIZADO PARA ADICIONAR NOTAS ###
	public boolean addNota(int posAluno, double nota) {
		notas.add(posAluno, nota);
		return true;
	}

	// ######################################################
	// ### METODO ULTILIZADO PARA ADCIONAR AS FREQUENCIAS ###
	public boolean addFrequencia(int posAluno, int frequenciaTotal) {
		frequencias.add(posAluno, frequenciaTotal);
		return true;
	}

	// ##############################################################
	// ### METODO PARA VERIFICAR SE O ALUNO ESTRA APROVADO OU NAO ###
	public boolean estaAprovado(int posAluno) {
		if ((notas.get(posAluno) >= 6) || (frequencias.get(posAluno) >= 75)) {
			return true;
		} else {
			return false;
		}
	}

	// #######################################
	// ### METODO PARA EXIBIR REPROVADOS #####
	public void exibirReprovados() {
		int total = 0;
		if (getNumerosAlunos() == 0) {
			System.out.println("Disciplina nao possui alunos matriculados");
		} else {
			for (int i = 0; i < alunos.size(); i++) {
				if (estaAprovado(i) == false) {
					System.out.println("Alunos Reprovados: " + alunos.get(i).getNome() + " Notas: " + notas.get(i)
							+ " Frequencia: " + frequencias.get(i));
					total = total + 1;
				}
			}
			if (total == 0) {
				System.out.println("Não ha alunos reprovados");
			}
		}
	}

	// #####################################
	// ### METODO PARA EXIBIR APROVADOS ###
	public void exibirAprovados() {
		int total = 0;
		if (getNumerosAlunos() == 0) {
			System.out.println("Disciplina nao possui alunos matriculados");
		} else {
			for (int i = 0; i < alunos.size(); i++) {
				if (estaAprovado(i) == true) {
					System.out.println("Alunos Aprovados: " + alunos.get(i).getNome() + " Notas: " + notas.get(i)
							+ " Frequencia: " + frequencias.get(i));
					total = total + 1;
				}
			}
			if (total == 0) {
				System.out.println("Não ha alunos Aprovados");
			}
		}
	}

	// #####################################
	// ### RETORNO DO CALCULO DAS MEDIAS ###
	public double calcularMedia() {
		double total = 0;
		for (int i = 0; i < alunos.size(); i++) {
			total = total + notas.get(i);
		}
		total = total / getNumerosAlunos();
		return total;
	}

	// ###########################
	// ### EXIBIR A MAIOR NOTA ###
	public void exibirMaiorNota() {
		Double maior = (double) 0;
		int possicao = 0;
		for (int i = 0; i < alunos.size(); i++) {
			if (notas.get(i) > maior) {
				maior = notas.get(i);
				possicao = i;
			}
		}
		System.out
				.println("Aluno com a maior nota: " + alunos.get(possicao).getNome() + " Nota: " + notas.get(possicao));

	}

	// ##########################
	// ### EXIBIR MENOR NOTA ###
	public void exibirMenorNota() {
		Double menor = (double) 15;
		int possicao = 0;
		for (int i = 0; i < alunos.size(); i++) {
			if (notas.get(i) < menor) {
				menor = notas.get(i);
				possicao = i;
			}
		}
		System.out
				.println("Aluno com a menor nota: " + alunos.get(possicao).getNome() + " Nota: " + notas.get(possicao));

	}

	// #####################################
	// ### RETORNA O TOTAL DE REPROVADOS ###
	public int getQuantidadeReprovados() {
		int retorno = 0;
		for (int i = 0; i < alunos.size(); i++) {
			if (estaAprovado(i) == false) {
				retorno = retorno + 1;

			}

		}
		return retorno;
	}

	// ####################################
	// ### RETORNA O TOTAL DE APROVADOS ###
	public int getQuantidadeAprovados() {
		int retorno = 0;
		for (int i = 0; i < alunos.size(); i++) {
			if (estaAprovado(i) == true) {
				retorno = retorno + 1;

			}

		}
		return retorno;
	}

	// ######################################
	// ## MOSTRAR INFORMACAO DO PROFESSOR ##
	public void exibirProfessor() {
		if (this.professor == null) {
			System.out.println("Disciplina nao possui professor");
		} else {
			System.out.println("Nome: " + professor.getNome() + " Suap: " + professor.getSuap());
		}
	}

	// #########################################
	// ### RETORNA O APROVEITAMENTO DO ALUNO ###
	public double getAproveitamentoAluno(int posAluno) {
		double retorno = 0;

		if (frequencias.get(posAluno) == 100) {
			retorno = 100;
		}
		if (frequencias.get(posAluno) <= 50) {
			retorno = 50;
		}

		return retorno;
	}

	// ###################################
	// ### RETORNA A NOTA DE UM ALUNO ####
	public double getNotaAluno(int posAluno) {
		double retorno = 0;
		retorno = notas.get(posAluno);
		return retorno;
	}

	// ##################################################
	// ### METODO QUE EXIBE OS ALUNOS ASSIMA DA MEDIA ###
	public void exibirAlunosAcimasMedia() {
		if (getNumerosAlunos() == 0) {
			System.out.println("Disciplina nao possui alunos matriculados");
		} else {
			for (int i = 0; i < alunos.size(); i++) {
				if (notas.get(i) >= calcularMedia()) {
					System.out.println("Alunos Acima da media: " + alunos.get(i).getNome() + " Notas: " + notas.get(i));
				}
			}

		}
	}

	// ###################################################
	// ### METODO QUE EXIBE OS ALUNOS A BAIXO DA MEDIA ###
	public void exibirAlunosAbaixoMedia() {
		if (getNumerosAlunos() == 0) {
			System.out.println("Disciplina nao possui alunos matriculados");
		} else {
			for (int i = 0; i < alunos.size(); i++) {
				if (notas.get(i) < calcularMedia()) {
					System.out
							.println("Alunos Abaixo da media: " + alunos.get(i).getNome() + " Notas: " + notas.get(i));
				}
			}

		}
	}

	// #########################################
	// ### EXIBIR NOME NOTA E APROVEITAMENTO ###
	public void exibirAlunoNotasAproveitamento() {
		for (int i = 0; i < alunos.size(); i++) {
			System.out.println("Nome: " + alunos.get(i).getNome());
			System.out.println("Nota: " + notas.get(i));
			System.out.println("Aproveitamento: " + getAproveitamentoAluno(i));
			System.out.println("===================");
		}

	}

	// ##############################################
	// ### METODO PARA DESMATRICULAR TODOS ALUNOS ###
	public void desmatricularAlunos() {
		for (int i = 0; i < alunos.size(); i++) {
			desmatricularAluno(i);
		}
	}

	/// #############################################
	/// ### EXIBIR IMFORMAÇOES DA DISCIPLIA TODAS ###
	public void exibirDisciplina() {
		if (getNumerosAlunos() == 0) {
			System.out.println("Disciplina nao possui alunos matriculados");
		} else {
			exibirProfessor();
			System.out.println("===================");
			System.out.println("======Alunos=======");
			exibirAlunoNotasAproveitamento();
			System.out.println("======Media Total=======");
			System.out.println(calcularMedia());
			System.out.println("======Quantidade de Alunos=======");
			System.out.println(getNumerosAlunos());
			System.out.println("======Reprovados=======");
			System.out.println(getQuantidadeReprovados());
			System.out.println("======Aprovados=======");
			System.out.println(getQuantidadeAprovados());
		}

	}

}// FIM DA CLASSE
