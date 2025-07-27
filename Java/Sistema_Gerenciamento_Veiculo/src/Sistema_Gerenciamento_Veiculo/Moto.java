package Sistema_Gerenciamento_Veiculo;

public class Moto extends Veiculo implements Operacoes {
	// atributo somente da moto
	int cilindradas;

	public Moto(String marca, String modelo, int ano, double preco, boolean disponivel, int cilindradas) {
		super(marca, modelo, ano, preco, disponivel);
		this.cilindradas = cilindradas;
	}

	// GET E SET
	public int getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(int cilindradas) {
		this.cilindradas = cilindradas;
	}

	// Metodos
	@Override
	public void ligar() {
		System.out.println("A moto está ligada!");
	}

	@Override
	public void desligar() {
		System.out.println("A moto está desligada!");

	}

	@Override
	public void exibirInformacoes() {
		System.out.println("Moto: " + getMarca() + " " + getModelo() + ", Ano: " + getAno() + ", Preço: R$" + getPreco()
				+ ", Cilindradas: " + cilindradas + ", Disponível: " + disponivel);

	}

	@Override
	public double calcularSeguro() {
		return getPreco() * 0.06 * (1 + (2025 - getAno()) * 0.01);
	}
}
