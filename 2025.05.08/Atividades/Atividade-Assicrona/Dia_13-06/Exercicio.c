#include <stdio.h>


int main(){
    // variaveis
    char nome[50];
    int idade;
    int ingresso;

    // entrada de dados
    printf("==================================================\n");
    printf("||              Bem-vindo ao Evento             ||\n");
    printf("||      A seguir informe os dados solicitados   ||\n");
    printf("==================================================\n");
    
    printf("\n");
    printf("Informe o seu nome: \n");
    fflush(stdin); 
    fgets(nome, sizeof(nome), stdin); 

    printf("Informe a sua idade: \n");
    scanf("%d", &idade);
    
    printf("Você possui ingresso? (1 para sim, 0 para não): \n");
    scanf("%d", &ingresso);
    printf("\n");

    //processamento dos dados e saída de dados
    if(idade >= 18 && ingresso == 1){
        printf("Você está autorizado a entrar no evento.\n");
    }
    else if(idade < 18 && ingresso == 1){
        printf("Você não está autorizado a entrar no evento, pois é menor de idade.\n");
    }
    else if(idade >= 18 && ingresso == 0){
        printf("Você não está autorizado a entrar no evento, pois não possui ingresso.\n");
    }
    else{
        printf("Você não está autorizado a entrar no evento, pois é menor de idade e não possui ingresso.\n");
    }

    return 0;
}