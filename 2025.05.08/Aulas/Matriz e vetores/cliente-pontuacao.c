#include <stdio.h>

int main() {
    // Declaração de um array de inteiros para armazenar notas individuais (prova1, prova2)
    int postman_clients[10];

    // Atribuição de valores ao array
    postman_clients[0] = 5;
    postman_clients[1] = 7;
    postman_clients[2] = 8;
    postman_clients[3] = 6;
    postman_clients[4] = 9;
    postman_clients[5] = 4;
    postman_clients[6] = 7;
    postman_clients[7] = 8;
    postman_clients[8] = 6;
    postman_clients[9] = 10;

    // Impressão e descrição dos valores dos elementos
    printf("Postmane e os clientes:\n");
    printf("Cliente %d teve %d\n", 1, postman_clients[0]);
    printf("Cliente %d teve %d\n", 2, postman_clients[1]);
    printf("Cliente %d teve %d\n", 3, postman_clients[2]);
    printf("Cliente %d teve %d\n", 4, postman_clients[3]);
    printf("Cliente %d teve %d\n", 5, postman_clients[4]);
    printf("Cliente %d teve %d\n", 6, postman_clients[5]);
    printf("Cliente %d teve %d\n", 7, postman_clients[6]);
    printf("Cliente %d teve %d\n", 8, postman_clients[7]);

    // Cálculo da média
    int soma_postmanes = 0;
    for (int i = 0; i < 10; i++) {
        soma_postmanes += postman_clients[i];
    }
    double media_postmanes = (double)soma_postmanes / 10.0;
    printf("Média de Postmanes: %.2lf\n", media_postmanes);

    return 0;
}
