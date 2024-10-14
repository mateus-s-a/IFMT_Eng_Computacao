#include <stdio.h>
#include <stdlib.h>

#include "func.h"
#include "ordenacao.h"


void bubbleSort(int* vetor, int tamanho) {
    int i, j;

    for(i = 1; i < tamanho; i++) {
        for(j = 0; j < (tamanho - 1); j++) {
            if(vetor[j] > vetor[j + 1]) {
                int temp = vetor[j];
                vetor[j] = vetor[j + 1];
                vetor[j + 1] = temp;
            }
        }
    }
}