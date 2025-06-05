#include <stdio.h>

int main()
{

   // variaveis
   int num, num2;
   int soma;

   printf("\n");
   printf("===================================\n");
   printf("=         calculo de soma         =\n");
   printf("===================================\n");
   printf("\n"); 
   // recebimento de dados
   printf("Digite o primeiro numero: \n");
   scanf("%d", &num);

   printf("\n");

   printf("Digite o primeiro numero: \n");
   scanf("%d", &num2);

   // processamento de dados
   soma = num + num2;
   printf("\n");

   // saida de dados
   printf("\n");
   printf("=================  Resultado ===================\n");
   printf("a soma dos valores: %d", soma);
}

