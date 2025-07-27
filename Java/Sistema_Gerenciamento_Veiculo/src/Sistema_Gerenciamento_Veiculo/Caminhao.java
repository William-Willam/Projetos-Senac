package Sistema_Gerenciamento_Veiculo;

public class Caminhao extends Veiculo implements Operacoes {
	// atributo somente do caminhao
	double capacidadeCarga;

	public Caminhao(String marca, String modelo, int ano, double preco, boolean disponivel, double capacidadeCarga) {
		super(marca, modelo, ano, preco, disponivel);
		this.capacidadeCarga = capacidadeCarga;
	}

	// GET E SET
	public double getCapacidadeCarga() {
		return capacidadeCarga;
	}

	public void setCapacidadeCarga(double capacidadeCarga) {
		this.capacidadeCarga = capacidadeCarga;
	}

	@Override
	public void ligar() {
		System.out.println("Caminhão ligado.");
	}

	@Override
	public void desligar() {
		System.out.println("Caminhão desligado.");
	}

	@Override
	public void exibirInformacoes() {
		System.out.println("Caminhão: " + getMarca() + " " + getModelo() + ", Ano: " + getAno() + ", Preço: R$"
				+ getPreco() + ", Carga: " + capacidadeCarga + " toneladas, Disponível: " + disponivel);
	}

	@Override
	public double calcularSeguro() {
		return getPreco() * 0.05 * (1 + (2025 - getAno()) * 0.01);
	}
}
