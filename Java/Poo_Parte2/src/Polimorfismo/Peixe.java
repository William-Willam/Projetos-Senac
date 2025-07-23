package Polimorfismo;

public class Peixe implements Nadador {
	//atributos
	String especie;
	double peso;
	
	// construtor
	public Peixe(String especie, double peso) {
		super();
		this.especie = especie;
		this.peso = peso;
	}
	
	// get e set
	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public void nadar() {
		System.out.println("Peixe nadando!");
	}
}
