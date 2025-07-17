package Atividade;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954);
		
		//exibir dados
		livro1.exibirInformacao();
		livro1.SetAno(1955);
	    livro1.exibirInformacao();
	}

}
