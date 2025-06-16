#include <stdio.h>

// função
int soma(int a, int b){
    return a + b;
};

int main(){
    //variaveis
    int x = 5, y = 3;

    //chamada da função
    int resultado = soma(x,y);

    //saida de dados
    printf("a soma de %d e %d: %d\n", x, y, resultado);

    return 0;
}