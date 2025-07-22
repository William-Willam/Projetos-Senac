package Polimorfismo;

public class Anta extends Animal implements Nadador {

	public Anta(String nome, int idade, double peso) {
		super(nome, idade, peso);
	}
	
	@Override
	public void emitirSom() {
		System.out.println("cui cui cui...");
	}
	
	@Override
	public void nadar() {
		System.out.println("Anta nadando!");
	}
}
