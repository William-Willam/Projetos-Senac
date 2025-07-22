package Atividade;

public abstract class Animal {
	// Atributo
	String nome;
	String peso;

	// construtor
	public Animal(String nome, String peso) {
		super();
		this.nome = nome;
		this.peso = peso;
	}

	// getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	// metodos
	public abstract void emitirSom();

	public void dormir() {
		System.out.println("O animal está dormindo!");
	}

}
