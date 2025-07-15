package aula02;

public class Pessoa {
	
	//Atributos
	String nomeCompleto;
	String cpf;
	int idade;
	char genero;
	
	//Métodos
	void exibirDados() {
		System.out.println("Nome Completo: "+nomeCompleto);
		System.out.println("CPF: "+cpf);
		System.out.println("Idade: "+idade);
		System.out.println("Genero: "+genero);
	}

}
