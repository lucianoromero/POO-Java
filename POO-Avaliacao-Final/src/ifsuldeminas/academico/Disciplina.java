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
    /// ###  GETTER E SETTER #####
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
    /// ### FIM DOS GETTER E SETTER ####
	//  ### METODO ULTILIZADO PARA DESMATRICULAR ALUNOS POR USA POSSIÇÃO ###
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

	// ### METODO ULTILIZADO PARA ADICIONAR O OBJETO PROFESSOR ###
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	// ### METODO ULTILIZADO PARA REMOVER UM PROFESSOR ####
	public void removerProfessor() {
		this.professor = null;
	}

	// ### METODO ULTILIZADO PARA VERIFICAR O TOTAL DE ALUNO EM UMA 
	// ###  DISCIPLINA ELE RETORNA O VALOR 
	public int getNumerosAlunos() {
		int totaldealunosmatriculados = 0;
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i) != null) {
				totaldealunosmatriculados = totaldealunosmatriculados + 1;
			}
		}
		return totaldealunosmatriculados;
	}

	// ### METODO ULTILIZADO PARA ADICIONAR AS NOTAS 
	// ### ADICIONANDO AS NOTAS NO ARRAYLIST
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

	// ### METODO PARA ADICIONAR A FRENQUECIA NO ARRAYLIST ###
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
		
	// #### METODO ULTILIZADO PARA VERIFICAR APROVACAO 
	// #### RETORNA TRUE CASO APROVADO E FALSE SE NÃO APROVADO
	// #### RECEBE COMO PARAMENTRO A POSSICAO DO ALUNO
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

	// #### METODO ULTILIZADO PARA EXIBIR OS REPROVADOS ####
	public void exibirReprovados() {
		boolean valor;
		for (int i = 0; i < alunos.size(); i++) {
			valor = estaAprovado(i);
			if(valor == true) {
				System.out.println("Alunos Aprovados" + alunos.get(i).getNome());
			}
		}
    

	}

	// ### METODO PARA EXIBIR OS APROVADOS ####
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

	// ### METODO ULTILIZADO PARA CALCULAR A MEDICA ###
	// ### RETORNA COMO PARAMENTRO A MEDICA ###
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

	// #### METODO ULTILIZADO PARA EXIBIR A MAIOR NOTA ####
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

	// #### METODO ULTILIZADO PARA EXIBIR A MENOR NOTA ####
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

	// #### METODO ULTILIZADO PARA EXIBIR A QUANTIDADE DE REPROVADO ####
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

	// #### METODO ULTILIZADO PARA EXIBIR A QUANTIDADE DE APROVADOS ###
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

	// #### METODO ULTILIZADO PARA EXIBIR OS DADOS DO PROFESSOR ####
	public void exibirProfessor() {
		if (professor == null) {
			System.out.println("Disciplina nao possui professor");
		} else {
			System.out.println("Professor: " + professor.getNome());
		}

	}

	// #### METODO ULTILIZADO PARA EXIBIR O APROVEITAMENTO DO ALUNO ###
	// #### RETORNA COMO PARAMENTRO O APROVEITAMENTO 
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

	// #### METODO ULTILIZADO PARA EXIBIR A NOTA DO ALUNO ###
	// #### RECEBE COMO PARAMENTRO A NOTA DO ALUNO ####
	public void getNotaAluno(int posAluno) {
		for (int i = 0; i < alunos.size(); i++) {
			if (posAluno == i) {
				System.out.println("Nota do Aluno: " + notas.get(i));
			}
		}
	}

	// ### METODO ULTILIZADO PARA EXIBIR ALUNOS ACIMA DA MEDIA ###
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

	// ### METODO ULTILIZADO PARA EXIBIR ALUNOS ABAIXO DA MEDIA ###
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

	// ### METODO ULTILIZADO PARA EXIBIR APROVEITAMENTO DOS ALUNOS ###
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

	// ### METODO USADO PARA DESMATRICULAR TODOS OS ALUNOS ###
	// ### CHAMA OUTRO METODO COMO PADRAO ONDE PASSA O I COMO PARAMENTRO ###
	public void desmatricularAlunos() {
		for (int i = 0; i < alunos.size(); i++) {
			desmatriculaAluno(i);

		}
	}
	// ### METODO ULTILIZADO PARA EXIBIR AS NOTAS ###
	// ### EXIBIR NOTAS POR ORDEM ####
	public void exibirOrdenadosPorNotas(){
	 Collections.sort(notas);	
	 System.out.println("Ordem: " + notas);
	 
	}
	
	// ### METODO ULTILIZADO PARA EXIBIR DADOS DAS DISCIPLICAS ###
	public void exibirDisciplina() {
		
		
	}
	

}// FIM DA CLASSE
