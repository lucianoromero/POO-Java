package ifsuldeminas.funcionarios;

public class Professor {
    private String nome;
    private int suap;
    
	public Professor(String nome, int suap) {
		this.nome = nome;
		this.suap = suap;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSuap() {
		return suap;
	}
	public void setSuap(int suap) {
		this.suap = suap;
	}
	
	/// Metodo Para exibir dados do Professor
	public void exibirProfessor() {
		System.out.println("Nome: " + getNome());
		System.out.println("Suap: " + getSuap());
		
		
	}
    
    
}
