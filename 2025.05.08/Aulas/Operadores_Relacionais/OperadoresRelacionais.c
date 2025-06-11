#include <stdio.h>

int main(){
    int a = 10, b = 20;
    _Bool igual = (a == b);
    _Bool maiorQue = (a>b);

    printf("E igual: %d\n", igual);
    printf("E maior que: %d\n", maiorQue);

    return 0;
}