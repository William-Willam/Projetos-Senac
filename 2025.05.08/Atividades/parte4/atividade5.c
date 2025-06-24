#include <stdio.h>

int main() {
    int idade, maior_idade = 0, quantidade_mulheres = 0, total_moradores = 0;
    char sexo;
    float salario, soma_salarios = 0;
    int salario_abaixo_500 = 0;

    printf("Digite as informações dos moradores (idade, sexo, salário). Digite 0 para idade para finalizar.\n");

    while (1) {
        printf("Idade: ");
        scanf("%d", &idade);
        if (idade == 0) {
            break;
        }

        printf("Sexo (m/f): ");
        scanf(" %c", &sexo);

        printf("Salário: ");
        scanf("%f", &salario);

        if (idade > maior_idade) {
            maior_idade = idade;
        }

        soma_salarios += salario;
        total_moradores++;

        if (sexo == 'f') {
            quantidade_mulheres++;
        }

        if (salario < 500) {
            salario_abaixo_500 = 1;
        }
    }

    float media_salarial = soma_salarios / total_moradores;

    printf("A maior idade é: %d\n", maior_idade);
    printf("A média salarial é: %.2f\n", media_salarial);
    printf("A quantidade de mulheres é: %d\n", quantidade_mulheres);
    printf("Existe salário abaixo de 500: %s\n", salario_abaixo_500 ? "Sim" : "Não");

    return 0;
}
