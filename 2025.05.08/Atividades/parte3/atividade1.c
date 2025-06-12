/* Faça um programa que peça ao usuário digitar um número inteiro e indique se o número digitado é positivo, negativo ou nulo. */

#include <stdio.h>

int main(){
    //variaveis
    int numero;

    // entrada de dados
    printf("Digite um numero inteiro: ");
    scanf("%d", &numero);

    // processamento e saida de dados
    if (numero > 0){
        printf("Positivo: %d\n", numero);
    }else if( numero == 0){
         printf("Nulo: %d\n", numero);
    }else{
         printf("Negativo: %d\n", numero);
    }
    
    return 0;

}