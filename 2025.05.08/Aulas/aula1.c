#include <stdio.h>

int main() {
    // vairiaveis
    int idade = 20;
    float valorDoPgto = 12.45;
    double velParticula = 2.92817029837;
    char tipoHabilitacao; 

    // entrada de dados
    printf("Informe a idade: ");
    scanf("%d", &idade);

    printf("Valor do Pagamento: ");
    scanf("%f", &valorDoPgto);

    printf("Velocidade da Particula: ");
    scanf("%lf", &velParticula);

    getchar(); 

    printf("Tipo de habilitacao: ");
    scanf("%c", &tipoHabilitacao);

    // saida
    printf("\nDados Informados:\n");
    printf("Idade: %d\n", idade);
    printf("Valor do Pagamento: %.2f\n", valorDoPgto); 
    printf("Velocidade da Particula: %lf\n", velParticula);
    printf("Tipo de habilitacao: %c\n", tipoHabilitacao);

    return 0;
}


/*
    Somente em C

    * tipo da variavel e o tipo k
    int                    %d 
    float                  %f
    double                 %lf
    char                   %c
    string                 %s
*/