#include <stdio.h>

void bubbleSort(int *vetor, int n) {
    int i, j;

    for(i = 1; i < n; i++) {
        for(j = 0; j < (n - i); j++) {
            if(vetor[j] > vetor[j + 1]) {
                int temp = vetor[j];
                vetor[j] = vetor[j + 1];
                vetor[j + 1] = temp;
            }
        }
    }

    for(i = 0; i < n; i++) {
        printf("%d ", vetor[i]);
    }
    printf("\n");
}

int valorMinimo(int *vetor, int i, int n) {
    int j, k = i;

    for(j = (i + 1); j < n; j++) {
        if(vetor[k] > vetor[j]) {
            k = j;
        }
    }
    
    

    return k;
}

void ordenacaoPorSelecao(int *vetor, int n) {
    int i, k, temp;

    for(i = 0; i < (n - 1); i++) {
        k = valorMinimo(vetor, 0, 9);
        temp = vetor[i];
        vetor[i] = vetor[k];
        vetor[k] = temp;
    }

    for(i = 0; i < n; i++) {
        printf("%d ", vetor[i]);
    }
    printf("\n");
}

int main() {
    int vetor[] = {92, 80, 71, 63, 55, 41, 39, 27, 14};

    bubbleSort(vetor, 9);
    valorMinimo(vetor, 0, 9);
    ordenacaoPorSelecao(vetor, 9);
    
    
    

    return 0;
}
