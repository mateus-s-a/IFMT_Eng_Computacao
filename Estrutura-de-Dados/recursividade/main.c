#include <stdio.h>

int fatorialIterativo(int n) {
    int fat = 1;
    
    for(int i = n; i > 0; i--) {
        fat = fat * i;
    }

    return fat;
}

int fatorialRecursivo(int n) {
    int fat;

    if((n == 1) || (n == 0)) {
        return (1);
    } else {
        return (n * fatorialRecursivo(n - 1));
    }
}

int main() {
    printf("%d", fatorialIterativo(5));
    printf("\n");
    printf("%d", fatorialRecursivo(5));
    
    return 0;
}