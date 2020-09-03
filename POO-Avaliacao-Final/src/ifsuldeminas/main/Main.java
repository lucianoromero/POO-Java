package ifsuldeminas.main;

import ifsuldeminas.funcionarios.Professor;
import ifsuldeminas.alunos.Aluno;

import java.util.Scanner;

import ifsuldeminas.academico.Disciplina;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Ultilizando o primerio construtor 
		Disciplina materia1 = new Disciplina("Matematica", 1, 5, 4);

		// Criando Objeto Aluno
		Aluno aluno1 = new Aluno("Lucas", 1001, "Informatica");
		Aluno aluno2 = new Aluno("Antonio", 1002, "Informatica");
		Aluno aluno3 = new Aluno("Giulia", 1003, "Informatica");
		Aluno aluno4 = new Aluno("Jeferson", 1004, "Informatica");
		Aluno aluno5 = new Aluno("Joao", 1005, "Informatica");
		Aluno aluno6 = new Aluno("Lucia", 1006, "Informatica");
		Aluno aluno7 = new Aluno("Rafael", 1007, "Informatica");
		Aluno aluno8 = new Aluno("Vinicio", 1008, "Informatica");
		Aluno aluno9 = new Aluno("Pedro", 1009, "Informatica");
		Aluno aluno10 = new Aluno("Maria", 1010, "Informatica");

		// Matriculando os Alunos
		materia1.matricularAluno(aluno1);
		materia1.matricularAluno(aluno2);
		materia1.matricularAluno(aluno3);
		materia1.matricularAluno(aluno4);
		materia1.matricularAluno(aluno5);
		materia1.matricularAluno(aluno6);
		materia1.matricularAluno(aluno7);
		materia1.matricularAluno(aluno8);
		materia1.matricularAluno(aluno9);
		materia1.matricularAluno(aluno10);

		// Configurando as notas dos Alunos
		materia1.addNota(0, 6);
		materia1.addNota(1, 4);
		materia1.addNota(2, 2);
		materia1.addNota(3, 1);
		materia1.addNota(4, 5);
		materia1.addNota(5, 6);
		materia1.addNota(6, 7);
		materia1.addNota(7, 8);
		materia1.addNota(8, 9);
		materia1.addNota(9, 9);
		// Configurando Frequencia
		materia1.addFrequencia(0, 50);
		materia1.addFrequencia(1, 50);
		materia1.addFrequencia(2, 100);
		materia1.addFrequencia(3, 50);
		materia1.addFrequencia(4, 100);
		materia1.addFrequencia(5, 50);
		materia1.addFrequencia(6, 100);
		materia1.addFrequencia(7, 50);
		materia1.addFrequencia(8, 50);
		materia1.addFrequencia(9, 100);
		// Criando um Ojeto provessor
		Professor professor1 = new Professor("Fernando", 777);
		// Colocando o Professor na Materia
		materia1.setProfessor(professor1);

		// ### testes ###
       materia1.exibirAlunoNotasAproveitamento();
       
		// ### Menu ###
        /*
		int opcao;
		// Estrutura de Repeticao
		do {
			System.out.println("Bem Vindo ao Sistema do If");
			System.out.println("Selecione a opcao");
			System.out.println("Opcao:0 - Desmatricular todos Alunos, remover professor e finalizar programa");
			System.out.println("Opcao:1 - Imprimir informacoes da disciplica");
			System.out.println("Opcao:2 - Apresentar numeros de reprovados e aprovados");
			System.out.println("Opcao:3 - Imprimir aprovados");
			System.out.println("Opcao:4 - Imprimir reprovados");
			System.out.println("Opcao:5 - Imprimir Aluno com a Maior nota e Menor nota");
			System.out.println("Opcao:6 - Imprimir Professor responsavel");
			System.out.println("Opcao:7 - Imprimir media total da turma e listar todos os alunos acima da media");
			System.out.println("Opcao:8 - Imprimir media total da turma e listar todos os alunos a baixo da media");
			System.out.println("Opcao:9 - Imprimir nome dos alunos e suas respecitivas notas e aproveitamento");
			System.out.println("Opcao:10 -Imprimir alunos ordenados por notas");
			System.out.println("Opcao:11 - Matricular Aluno");
			opcao = sc.nextInt();

			switch (opcao) {
			case 0:
				materia1.removerProfessor();
				materia1.desmatricularAlunos();
				System.out.println("Vc saiu do Sistema !");
				break;
			case 1:
				materia1.exibirDisciplina();
				break;
			case 2:
				materia1.exibirAprovados();
				//materia1.exibirReprovados();
				break;
			case 3:
				materia1.exibirAprovados();
				System.out.println("#################");
				break;
			case 4:
				materia1.exibirReprovados();
				System.out.println("#################");
				break;
			case 5:
				materia1.exibirMaiorNota();
				System.out.println("#################");
				materia1.exibirMenorNota();
				System.out.println("#################");
				break;
			case 6:
				materia1.exibirProfessor();
				System.out.println("#################");
				break;
			case 7:
				materia1.
				System.out.println("#################");
				break;
			case 8:
				System.out.println("#################");
				break;
			case 9:
				System.out.println("#################");
				break;
			case 10:
				System.out.println("#################");
				break;
			case 11:
				System.out.println("#################");
				break;

			}

		} while (opcao != 0);

		sc.close(); 
		*/
	}

}
