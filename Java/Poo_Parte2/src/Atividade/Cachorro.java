package Atividade;

public class Cachorro extends Animal implements Terreste {

	public Cachorro(String nome, String peso) {
		super(nome, peso);
	}

	@Override
	public void emitirSom() {
		System.out.println("O cachorro está latindo.");
	}

	@Override
	public void andar() {
		System.out.println("O cachorro está andando.");

	}
	
	@Override
	public void dormir() {
		System.out.println("O animal está dormindo");
	}
}
