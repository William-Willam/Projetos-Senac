package Polimorfismo;

public class principal {

	public static void main(String[] args) {
		Anta a1 = new Anta("Ervaldo", 14, 22.0);
		Peixe p1 = new Peixe("Pirarucu", 12.0);

		// Exibir
		System.out.println("Nome: " + a1.getNome() + " - " + "Idade: " + a1.idade + " - " + " Peso: " + a1.peso);
		a1.emitirSom();
		a1.nadar();
		
		System.out.println("-------------------------------------------------------");
		
		System.out.println("Nome: " + p1.getEspecie() + " - " + " Peso: " + p1.peso);
		p1.nadar();
	}

}
