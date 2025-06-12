#include <stdio.h>

int main(){
    //variaveis
    char nome[50];
    int idade;

    //entrada de dados
    printf("Digite seu nome: ");
    scanf("%s",&nome);
    printf("\n");
    printf("Digite sua idade: ");
    scanf("%d",&idade);

    //processamento de dados
    printf("\n");
    printf("===================================\n");
    printf("Seu nome: %s\n", nome);
    printf("Sua idade: %d\n", idade);
    printf("===================================\n");

    //Condicional
    //=============================== IF E ELSE ===========================
    if (idade >= 18){
        printf("Permitido!! \n");
    }else{
        printf("Acesso Negado!!! \n");
    }
    


    //fim do codigo
    return 0;
}