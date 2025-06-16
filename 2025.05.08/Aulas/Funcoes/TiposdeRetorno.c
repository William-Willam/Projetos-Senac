/*Tipo de retornos e parametros*/

#include <stdio.h>

//função sem parametros e sem retorno
void saudacacao(){
    printf("Bem vindo, mano vey! \n");
};

// função com parametros e sem retorno
void exibirMensagem(char mensagem[]){
    printf("Mensagem Recebida: %s \n", mensagem);
};

//função com parametros e com retorno
int soma(int a, int b){
    return a + b;
};

int main(){
    saudacacao();
    exibirMensagem("Palmeira nao tem mundial \n");
    
    int x =5, y=3;
    int resultado = soma(x,y);

    printf("a soma de %d e %d: %d\n", x, y, resultado);

    return 0;
}