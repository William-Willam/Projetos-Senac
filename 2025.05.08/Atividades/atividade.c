/*
    Faça um programa que calcula e imprime na tela a velocidade de um objeto. 
    Os dados (distância e tempo) devem ser informados pelo usuário. Dica: lembre que v = d/t.

*/

#include <stdio.h>

int main(){
    //variaveis
    float distância;
    float velocidade,tempo;

    // entrada de dados
    printf("Informe a distancia percorrida: ");
    scanf("%f",&distância);
    printf("\n");
    printf("Informe o tempo ocorrido: ");
    scanf("%f",&tempo);
    printf("\n");

    //processamento dos dados
    velocidade = (distância / tempo);

    //Saida de Dados
    printf("A velocidade foi: %f\n", velocidade);
}