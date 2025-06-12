#include <stdio.h>

int main()
{
    // variaveis
    int dia;

    // entrada de dados
    printf("Escolha um dia semana (ex: 1 para segunda): ");
    scanf("%d", &dia);

    // processamento de dados
    switch (dia)
    {
    case 1:
        printf("\n");
        printf("================================\n");
        printf("      Segunda - feira !!        \n");
        printf("     Dia de ficar em casa !     \n");
        printf("================================\n");
        break;

    case 2:
        printf("\n");
        printf("================================\n");
        printf("      Terca - feira !!          \n");
        printf("     Dia de ficar em casa !     \n");
        printf("================================\n");
        break;
    case 3:
        printf("\n");
        printf("================================\n");
        printf("      Quarta - feira !!         \n");
        printf("     Dia de ficar em casa !     \n");
        printf("================================\n");
        break;

    case 4:
        printf("\n");
        printf("==========================================\n");
        printf("            Quinta - feira !!             \n");
        printf("     Dia de pensar em sair de casa !      \n");
        printf("==========================================\n");
        break;

    case 5:
        printf("\n");
        printf("==========================================\n");
        printf("            Sexta - feira !!              \n");
        printf("          Dia de sair de casa !           \n");
        printf("==========================================\n");
        break;

    case 6:
        printf("\n");
        printf("==========================================\n");
        printf("                Sabado !!                 \n");
        printf("           Dia de se divertir !!          \n");
        printf("==========================================\n");
        break;

    case 7:
        printf("\n");
        printf("==========================================\n");
        printf("                Domingo !!                \n");
        printf("           Dia de ficar em casa !         \n");
        printf("==========================================\n");
        break;

    default:
        printf("\n");
        printf("==========================================\n");
        printf("           Nao existe esse dia !!         \n");
        printf("           Melhor Vc ficar casa !         \n");
        printf("==========================================\n");
        break;
        break;
    }
}