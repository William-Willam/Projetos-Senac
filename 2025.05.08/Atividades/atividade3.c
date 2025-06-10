#include <stdio.h> 
#include <math.h>  

int main()
{
    // Variáveis - Usando double para números reais (com casas decimais)
    double a, b, c;
    double delta;
    double x1, x2; 

    // Entrada de dados
    printf("--- Calculadora de Raizes de Equacao do Segundo Grau ---\n\n");

    printf("Insira o coeficiente 'a': ");
    scanf("%lf", &a); 
    printf("Insira o coeficiente 'b': ");
    scanf("%lf", &b); 
    printf("Insira o coeficiente 'c': ");
    scanf("%lf", &c); 
    printf("\n");

    // Processamento dos dados - Cálculo do discriminante (delta)
    delta = (b * b) - (4 * a * c);

    // Verificando as condições para raízes reais
    if (delta >= 0) { 
        if (delta == 0) {
            x1 = -b / (2 * a);
            printf("A equacao possui UMA raiz real (ou duas iguais): %.2f\n", x1);
        } else { 
            x1 = (-b + sqrt(delta)) / (2 * a); 
            x2 = (-b - sqrt(delta)) / (2 * a); 
            printf("A equacao possui DUAS raizes reais distintas: %.2f e %.2f\n", x1, x2);
        }
    } else {
        printf("A equacao NAO possui raizes reais (Delta < 0).\n");
    }

    return 0; 
}