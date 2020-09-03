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

	// ### METODO ULTILIZADO PARA MATRICULAR ALUNOS ###
	
}// FIM DA CLASSE
