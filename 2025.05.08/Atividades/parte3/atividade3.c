/*
    Faça um programa que pergunte ao usuário qual figura bidimensional ele deseja saber a área: círculo ou retângulo. 
    Esta opção deve ser registrada em um inteiro, com um valor para círculo e outro para retângulo, sendo informado ao usuário. 
    Caso o círculo seja escolhido, peça para o usuário informar o raio. 
    Caso o retângulo seja escolhido, peça para o usuário digitar a base e a altura. 
    Em seguida informe o valor da área, dependendo da figura escolhida. Obs.: utilize PI como uma constante no valor de 3.1415.
*/


#include <stdio.h>

int main(){
    int opcao;
    float retangulo, circulo, raio, base, altura;

    printf("============== Menu ================\n");
    printf("| 1- Calculo do Circulo            |\n");
    printf("| 2- Calculo do retangulo          |\n");
    printf("====================================\n");
    printf("\n");

    printf("Escolha a opcao: \n");
    scanf("%d",&opcao);

    switch (opcao)
    {
    case 1:
        printf("\n");
        printf("=================== Circulo =================\n");
        printf("\n");
        printf("Digite o raio do circulo: \n");
        scanf("%f",&raio);

        //calculo 
        circulo = 3.14 * (raio * raio);

        printf("A area do Circulo: \n%.2f", circulo);
        break;
    case 2:
        printf("\n");
        printf("=================== Retangulo =================\n");
        printf("\n");
        printf("Digite a base do Retangulo: \n");
        scanf("%f",&base);
        printf("Digite a altura do Retangulo: \n");
        scanf("%f",&altura);

        //calculo
        retangulo = base * altura;

        printf("Area do retangulo: \n%.2f", retangulo);
        break;
    default:
        printf("ERrro!!\n");
        break;
    }

    return 0;
}