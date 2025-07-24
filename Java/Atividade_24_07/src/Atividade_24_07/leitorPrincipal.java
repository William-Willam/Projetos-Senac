package Atividade_24_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class leitorPrincipal {

	public static void main(String[] args) {

		try {
			File arquivo = new File("alunos.txt");
			Scanner leitor = new Scanner(arquivo);

			while (leitor.hasNextLine()) {
				String linha = leitor.nextLine();
				System.out.println(linha);
			}

			leitor.close();
		} catch (FileNotFoundException erro) {
			erro.printStackTrace();
			System.out.println("Erro, arquivo não encontrado!");
		}

	}

}
