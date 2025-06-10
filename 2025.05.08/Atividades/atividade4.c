/*

    Crie duas variáveis ‘a’ e ‘b’ e troque os valores delas. Atribua os valores das variáveis diretamente pelo programa (em vez de ler pelo teclado) 
    e imprima os valores de ‘a’ e ‘b’ antes e depois da troca. Por exemplo, 
    para ’a’ = 1 e ‘b’ = 3, ao final do programa ‘a’ deverá ter 3 e ‘b’ deverá ter 1. Dica: utilize uma variável auxiliar para não perder os valores na hora da troca.

*/

#include <stdio.h>

int main() {
    // 1. Declarando e atribuindo valores iniciais às variáveis 'a' e 'b'
    int a = 1; 
    int b = 3; 

    // 2. Imprimindo os valores ANTES da troca
    printf("Antes da troca:\n");
    printf("Valor de 'a': %d\n", a);
    printf("Valor de 'b': %d\n", b);
    printf("\n"); 

    // 3. Realizando a troca de valores usando uma variável auxiliar
    int temp; 

    temp = a; 
    a = b;    
    b = temp; 

    // 4. Imprimindo os valores DEPOIS da troca
    printf("Depois da troca:\n");
    printf("Valor de 'a': %d\n", a);
    printf("Valor de 'b': %d\n", b);

    return 0; 
}
