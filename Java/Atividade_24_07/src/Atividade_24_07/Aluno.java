package Atividade_24_07;

public class Aluno {
	// Atributos
	String nome;
	double nota1, nota2, nota3;
	double media;

	// construtores
	public Aluno(String nome, double nota1, double nota2, double nota3, double media) {
		super();
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.media = media;
	}

	// Get e Set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public double getNota3() {
		return nota3;
	}

	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	// metodos
	public double calcularMedia() {
		return media = (nota1 + nota2 + nota3)/3;
	}
	
	public void ExibirMedia() {
		System.out.println("Médias das notas: " + media);
	}

}
