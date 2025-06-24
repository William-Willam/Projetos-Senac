/*
    Faça um programa que peça para o usuário digitar diversos valores de compras não negativos 
    e apresente a soma desses valores quando o usuário digitar o valor zero.
*/

#include <stdio.h>

int main() {
    float valor, soma = 0;

    printf("Digite os valores das compras (digite 0 para finalizar):\n");

    while (1) {
        scanf("%f", &valor);
        if (valor == 0) {
            break;
        }
        if (valor < 0) {
            printf("Por favor, digite um valor não negativo.\n");
            continue;
        }
        soma += valor;
    }

    printf("A soma dos valores das compras é: %.2f\n", soma);

    return 0;
}
