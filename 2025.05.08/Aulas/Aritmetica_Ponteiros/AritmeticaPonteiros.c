#include <stdio.h>

int main(){
    int array[5] = (1,2,3,4,5);
    int * ponteiro1 = &array[2];
    int * ponteiro2 = &array[5];

    printf("A diferenca entre o ponteiro 1 e 2: %d", ponteiro1 - ponteiro2);
    return 0;
}