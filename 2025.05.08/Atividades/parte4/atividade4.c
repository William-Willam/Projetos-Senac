#include <stdio.h>

int main() {
    int num;

    printf("Digite um número inteiro de 1 a 10: ");
    scanf("%d", &num);

    if (num < 1 || num > 10) {
        printf("Número inválido. Por favor, digite um número de 1 a 10.\n");
        return 1;
    }

    printf("Tabuada de multiplicação de %d:\n", num);
    for (int i = 1; i <= 10; i++) {
        printf("%d x %d = %d\n", num, i, num * i);
    }

    return 0;
}
