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
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i) != null) {
				alunos.remove(posAluno);
				notas.remove(posAluno);
				frequencias.remove(posAluno);
				return true;
			}
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
	public void removerProvessor() {
		this.professor = null;
	}

	// ##########################################################
	// ### METODO QUE RETORNA O NUMERO DE ALUNOS MATRICULADOS ###
	public void getNumerosAlunos() {
		int quantidade = 0;
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i) != null) {
				quantidade = quantidade + 1;
			}
		}
		System.out.println("Quantidade de Alunos Matriculados: " + quantidade);
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
	public void estaAprovado(int posAluno) {
		for (int i = 0; i < alunos.size(); i++) {
			if (i == posAluno) {
				if ((notas.get(i) >= 6) || (frequencias.get(i) >= 75)) {
					System.out.println("Aprovado" + alunos.get(i).getNome());
				}
			}
		}
	}

	public void exibirfrequencia() {
		for (int i = 0; i < frequencias.size(); i++) {
			System.out.println("Dados " +   notas.get(i) + " #### " + frequencias.get(i) + " ### " + alunos.get(i).getNome());
		}

	}

}// FIM DA CLASSE
