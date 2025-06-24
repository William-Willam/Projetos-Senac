#include <stdio.h>

int main() {
    // Declaração e inicialização de uma matriz 3x4 (3 filiais, 4 meses)
    // Cada linha representa uma filial, cada coluna um mês
    int vendas_filiais[3][4] = {
        {10000, 12000, 11000, 13000}, // Vendas da Filial 1 (Meses 1-4)
        {8000, 9500, 10500, 11000},   // Vendas da Filial 2 (Meses 1-4)
        {15000, 14000, 16000, 17000}  // Vendas da Filial 3 (Meses 1-4)
    };

    printf("Vendas Mensais por Filial:\n");

    // Loops aninhados para iterar sobre a matriz
    // O loop externo para as linhas (filiais)
    for (int i = 0; i < 3; i++) {
        printf("Filial %d:\n", i + 1);
        // O loop interno para as colunas (meses)
        for (int j = 0; j < 4; j++) {
            printf(" Mes %d: %d\n", j + 1, vendas_filiais[i][j]);
        }
    }

    // Exemplo: Calcular o total de vendas da Filial 2
    int total_vendas_filial2 = 0;
    for (int j = 0; j < 4; j++) {
        total_vendas_filial2 += vendas_filiais[1][j]; // Acessando a linha 1 (Filial 2)
    }

    printf("\nTotal de vendas da Filial 2: %d\n", total_vendas_filial2);

    // Exemplo: Calcular o total de vendas do Mes 3 para todas as filiais
    int total_vendas_mes3 = 0;
    for (int i = 0; i < 3; i++) {
        total_vendas_mes3 += vendas_filiais[i][2]; // Acessando a coluna 2 (Mes 3)
    }

    printf("Total de vendas do Mes 3 (todas as filiais): %d\n", total_vendas_mes3);

    return 0;
}
