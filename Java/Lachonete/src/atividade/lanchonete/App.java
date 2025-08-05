package atividade.lanchonete;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// leitura do teclado
		Scanner entrada = new Scanner(System.in);

		// Variaveis
		String[] produtos = { "Hambúrguer", "Batata Frita", "Refrigerante", "Milk-shake" };
		double[] preco = { 15.50, 8.00, 6.00, 12.00 };
		int[] quantidades = new int[produtos.length];

		double totalPedido = 0.0;

		// --- 2. Exibir o Cardápio ---
		System.out.println("--- Bem-vindo à Lanchonete! ---");
		System.out.println("---------------- Cardápio ----------------");
		for (int i = 0; i < produtos.length; i++) {
			System.out.printf("%d. %-15s - R$ %.2f\n", (i + 1), produtos[i], preco[i]);
		}
		System.out.println("------------------------------------------");
		System.out.println();

		// --- 3. Coletar o Pedido ---
		System.out.println("Por favor, informe a quantidade desejada para cada item:");
		for (int i = 0; i < produtos.length; i++) {
			while (true) {
				System.out.print("Quantidade de " + produtos[i] + ": ");
				try {
					int quantidade = entrada.nextInt();
					if (quantidade >= 0) {
						quantidades[i] = quantidade;
						break; // Sai do loop 'while' se a entrada for válida.
					} else {
						System.out.println("Por favor, insira um número não negativo.");
					}
				} catch (java.util.InputMismatchException e) {
					System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
					entrada.next(); // Limpa a entrada para evitar loop infinito.
				}
			}
		}

		// --- 4. Calcular o Total do Pedido e Gerar Relatório ---
		System.out.println();
		System.out.println("--- Resumo do seu Pedido ---");
		System.out.println("------------------------------------------");
		boolean pedidoVazio = true;

		for (int i = 0; i < produtos.length; i++) {
			if (quantidades[i] > 0) {
				double subtotal = quantidades[i] * preco[i];
				System.out.printf("%d x %-15s: R$ %.2f\n", quantidades[i], produtos[i], subtotal);
				totalPedido += subtotal;
				pedidoVazio = false;
			}
		}

		if (pedidoVazio) {
			System.out.println("Seu carrinho está vazio. Volte sempre!");
		} else {
			System.out.println("------------------------------------------");
			System.out.printf("Valor Total: R$ %.2f\n", totalPedido);
		}

		entrada.close();
	}

}
