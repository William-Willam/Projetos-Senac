/*

Faça um programa que peça ao usuário digitar três números reais e imprima o maior número digitado. 
Caso os valores sejam iguais, qualquer um deles pode ser impresso.

*/

#include <stdio.h>

int main(){
    // variaveis
    int num1, num2, num3;

    //entrada de dados
    printf("Digite o primeiro numero inteiro: \n");
    scanf("%d",&num1);
    printf("\n");
    printf("Digite o segundo numero inteiro: \n");
    scanf("%d",&num2);
    printf("\n");
    printf("Digite o terceiro numero inteiro: \n");
    scanf("%d",&num3);


    //processamento e saida de dados
    if(num1 > num2 && num1 > num3){
        printf("O numero maior: \n%d", num1);
    }else if (num2 > num1 && num2 > num3){
        printf("O numero maior: \n%d", num2);
    }else if (num3 > num1 && num3 > num2){
       printf("O numero maior: \n%d", num3);
    }
    
    return 0;
    

}