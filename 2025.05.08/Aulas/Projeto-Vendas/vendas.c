#include <stdio.h>
#include <string.h>

int main()
{
    char nomeProduto[50];
    int quantidade, numProduto;
    float preco, totalProduto, totalDia;
    char continuar;

    do
    {
        printf("===============================================\n");
        printf("             Registre suas vendas              \n");
        printf("===============================================\n");
        printf("\n");

        printf("Quantas vendas foram vendidas hoje: ");
        scanf("%d", &numProduto);

        for (int i = 1; i <= numProduto; i++)
        {
            printf("\n Produto %d: \n", i);

            printf("Nome do Produto: ");
            scanf("%s", &nomeProduto);

            printf("Quantidade vendidas: ");
            scanf("%d", &quantidade);

            if (quantidade < 0)
            {
                printf("Quantidade invalida. Ignorando Produto");
                continue;
            }

            printf("Preco unitario: R$ ");
            scanf("%f", &preco);

            if (preco < 0){
                printf("Quantidade invalida. Ignorando Produto");
                continue;
            }
            totalProduto = quantidade * preco;
            printf("Total do produto %s: R$ %.2f\n", nomeProduto, totalProduto);

            totalDia += totalProduto;
        }

        printf("\n Total geral das vendas do dia: R$ %.2f \n", totalDia);
        printf("\n");

        printf("Deseja continuar! (sim = s ou S) (nao = n ou N)");
        scanf(" %c", &continuar);

    } while (continuar == "s" || continuar == "S");

    printf("Fim do sistema! \n");
    return 0;
}