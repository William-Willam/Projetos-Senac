package Atividade;

public class Bicicleta extends Veiculo {

	public Bicicleta(String nome, String tipo) {
		super(nome, tipo);
	}
	
	@Override
	public void mover() {
		System.out.println("A bicicleta está sendo pedalada.");
	}
	
	@Override
	public void tipoCombustivel() {
		System.out.println("Tipo de combustivel: Nenhum (movido a pedalada!)");
	}
	
}
