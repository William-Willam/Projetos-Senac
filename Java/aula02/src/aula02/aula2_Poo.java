package aula02;

public class aula2_Poo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pessoa pessoa1 = new Pessoa();
		pessoa1.nomeCompleto = "William dos Santos";
		pessoa1.cpf = "051.000.681-89";
		pessoa1.idade = 28;
		pessoa1.genero = 'M';
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.nomeCompleto = "Guilherme Matador";
		pessoa2.cpf = "123.000.456-89";
		pessoa2.idade = 17;
		pessoa2.genero = 'M';
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.nomeCompleto = "Kalebe erik";
		pessoa3.cpf = "123.000.897-89";
		pessoa3.idade = 19;
		pessoa3.genero = 'M';
		
		//exibir dados
		pessoa1.exibirDados();
		System.out.println();
		pessoa2.exibirDados();
		System.out.println();
		pessoa3.exibirDados();
	}

}
