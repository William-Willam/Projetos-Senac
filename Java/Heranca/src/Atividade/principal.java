package Atividade;

public class principal {

	public static void main(String[] args) {
		Bicicleta bike1 = new Bicicleta("Gios", "Aro 18");
		Carro carro1 = new Carro("Vectra", "Automático");

		// exibir
		System.out.println(bike1.getNome() + " " + bike1.getTipo());
		bike1.mover();
		bike1.tipoCombustivel();

		System.out.println();

		System.out.println(carro1.getNome() + " " + carro1.getTipo());
		carro1.mover();
		carro1.tipoCombustivel();

	}

}
