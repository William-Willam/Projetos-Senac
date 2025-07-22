package Atividade;

public class Ave extends Animal implements Aero {

	public Ave(String nome, String peso) {
		super(nome, peso);
	}

	@Override
	public void emitirSom() {
		System.out.println("A ave está cantando.");
	}

	@Override
	public void voar() {
		System.out.println("A ave está voando!");
	}
	
	@Override
	public void dormir(){
		System.out.println("O animal está dormindo!");
	}

}
