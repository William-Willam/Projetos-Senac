/*
     Faça um programa que leia três caracteres do teclado e informe na tela 
     a palavra formada pelos três caracteres em ordem inversa de entrada separados pelo caractere ‘-’.
*/

#include <stdio.h> 

int main() {
    
    char char1, char2, char3;

    
    printf("Digite o primeiro caractere: ");
    scanf(" %c", &char1); 

    
    printf("Digite o segundo caractere: ");
    scanf(" %c", &char2);

    
    printf("Digite o terceiro caractere: ");
    scanf(" %c", &char3);

    
    printf("A palavra formada em ordem inversa: %c-%c-%c\n", char3, char2, char1);

    return 0;
}   