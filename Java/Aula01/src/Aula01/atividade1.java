package Aula01;

import java.util.Scanner;

public class atividade1 {

    public static void main(String[] args) {
        double nota1;
        double nota2;
        double media;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a primeira nota: ");
        nota1 = scanner.nextDouble();

        System.out.print("Digite a segunda nota: ");
        nota2 = scanner.nextDouble();

        media = (nota1 + nota2) / 2;
        System.out.println("Média: " + media);

        if (media >= 5) {
            System.out.println("Aprovado!");
        } else {
            System.out.println("Reprovado!");
        }

        scanner.close();
    }
}

