package Atividade_24_07;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class principal {

	public static void main(String[] args) {
		try {
			//Gerando o arquivo
			PrintWriter arquivo = new PrintWriter(new FileWriter("alunos.txt", true));
			
			//Objetos
			Aluno aluno1 = new Aluno("William", 5, 6, 7, 0);
			Aluno aluno2 = new Aluno("Adriel", 10, 9, 8, 0);
			
			// aluno 1
			arquivo.println("-------------- Aluno e Notas ---------------------");
			arquivo.println("Nome: " + aluno1.getNome());
			arquivo.println("Nota 1: " + aluno1.getNota1());
			arquivo.println("Nota 2: " + aluno1.getNota2());
			arquivo.println("Nota 3: " + aluno1.getNota3());
			arquivo.println("Média: " + aluno1.calcularMedia());
			arquivo.println("--------------------------------------------------");

			arquivo.println();
			
			// aluno 2
			arquivo.println("-------------- Aluno e Notas ---------------------");
			arquivo.println("Nome: " + aluno2.getNome());
			arquivo.println("Nota 1: " + aluno2.getNota1());
			arquivo.println("Nota 2: " + aluno2.getNota2());
			arquivo.println("Nota 3: " + aluno2.getNota3());
			arquivo.println("Média: " + aluno2.calcularMedia());
			arquivo.println("--------------------------------------------------");
			arquivo.println();

			System.out.println("Gravado com sucesso!");

			arquivo.close();
		} catch (IOException error) {
			error.printStackTrace();
			System.out.println("Erro de criação do arquivo!");
		}
	}
}
