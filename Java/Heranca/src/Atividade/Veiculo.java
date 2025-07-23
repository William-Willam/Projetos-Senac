package Atividade;

public class Veiculo {
	String nome;
	String tipo;
	
	// construtor
	public Veiculo(String nome, String tipo) {
		super();
		this.nome = nome;
		this.tipo = tipo;
	}
	
	// getter e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	// Açoes
	public void mover() {
		System.out.println("O veiculo está andando ...");
	}
	
	public void tipoCombustivel() {
		System.out.println("Tipo de combustivel");
	}
	

}
