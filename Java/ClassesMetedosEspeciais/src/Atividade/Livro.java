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
	public int GetAno() {
		return ano;
	}

	public void SetAno(int ano) {
		this.ano = ano;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void exibirInformacao() {
		System.out.println("Título: " + titulo + " Autor: " + autor + " Ano de publicação: " + ano);
	}
}
