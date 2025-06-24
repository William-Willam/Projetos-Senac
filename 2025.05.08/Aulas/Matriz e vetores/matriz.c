#include <stdio.h>

int main() {
    // Declaração e inicialização de um array de preços
    float precos_produtos[3] = {19.99, 45.50, 9.75}; // Inicialização direta

    printf("Precos dos Produtos:\n");

    // Loop para iterar sobre o array e imprimir cada preço
    for (int i = 0; i < 3; i++) {
        printf("Produto %d: R$ %.2f\n", i + 1, precos_produtos[i]);
    }

    // Exemplo: Ajustar um preço (aumentar em 10%)
    precos_produtos[0] = precos_produtos[0] * 1.10;
    printf("\nNovo preco do Produto 1 (com 10%% de aumento): R$ %.2f\n", precos_produtos[0]);

    return 0;
}
