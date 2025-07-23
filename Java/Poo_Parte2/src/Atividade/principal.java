package Atividade;

public class principal {

	public static void main(String[] args) {
		// instancias
		Cachorro c1 = new Cachorro("Krypto", "168.00");
		Peixe p1 = new Peixe("Free Whily", "1Toneladas");
		
		//exibir
		c1.emitirSom();
		c1.dormir();
		
		p1.emitirSom();
		p1.dormir();
		p1.nadar();
	}

}
