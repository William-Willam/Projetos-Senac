package br.com.banco.model;

public abstract class Conta {
	// Atributo
	private int numero;
	private String titular;
	private double saldo;

	// construtor
	public Conta(int numero, String titular, double saldo) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}

	// Get e Set
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	// metodos
	public abstract void sacar(double valor);

	public abstract void depositar(double valor);

	public void exibirSaldo() {
		System.out.println("Saldo: R$ " + String.format("%.2f", saldo));
	}
}
