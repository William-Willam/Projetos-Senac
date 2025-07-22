package Atividade;

public class Peixe extends Animal implements Aquatico {

	public Peixe(String nome, String peso) {
		super(nome, peso);
	}

	@Override
	public void emitirSom() {
		System.out.println("O peixe faz bolhas.");
	}

	@Override
	public void nadar() {
		System.out.println("O peixe está nadando.");
	}

	@Override
	public void dormir() {
		System.out.println("O animal está dormindo");
	}
}
