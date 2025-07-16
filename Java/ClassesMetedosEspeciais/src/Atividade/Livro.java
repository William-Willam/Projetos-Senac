package Atividade;

public class Livro {

	// Atributos
	private String titulo;
	private String autor;
	private int ano;

	// metodos contrutores
	public Livro(String titulo, String autor, int ano) {
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
	}

	// Getters e Setters
	public void SetAno() {
	}
	
	public int GetAno() {
		
	}

	public void exibirInformacao() {
		System.out.println("Título: " + titulo + "  Autor: " + autor + " Ano de publicação: " + ano);
	}
}
