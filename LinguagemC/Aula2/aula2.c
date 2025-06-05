#include <stdio.h>

int main(){
    int idade = 18;
    float altura = 1.83;
    char letra = 'A'; // Corrigido: Use aspas simples para um único caractere

    printf("Idade: %d\n", idade);
    printf("Altura: %.2f\n", altura); // Corrigido: Use %f para float
    printf("Letra: %c\n", letra);
    return 0; // É uma boa prática retornar 0 de main para indicar execução bem-sucedida
}