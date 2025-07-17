package Atividade;

public class Carro extends Veiculo {

	public Carro(String nome, String tipo) {
		super(nome, tipo);
	}

	@Override
	public void mover() {
		System.out.println("O carro está andando na estrada.");
	}

	@Override
	public void tipoCombustivel() {
		System.out.println("Tipo de combustivel: Gasolina!");
	}

}
