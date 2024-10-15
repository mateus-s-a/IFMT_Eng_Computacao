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



int valorMinimo(int *vetor, int i, int tamanho) {
    int j, k = i;

    for(j = (i + 1); j < tamanho; j++) {
        if(vetor[k] > vetor[j]) {
            k = j;
        }
    }

    return k;
}

void ordenacaoPorSelecao(int *vetor, int tamanho) {
    int i, k, temp;

    for(i = 0; i < (tamanho - 1); i++) {
        k = valorMinimo(vetor, i, tamanho);
        temp = vetor[i];
        vetor[i] = vetor[k];
        vetor[k] = temp;
    }
}



void ordenacaoPorInsercao(int *vetor, int tamanho) {
    int i, j, temp;

    for(i = 1; i < tamanho; i++) {
        temp = vetor[i];
        for(j = (i - 1); (j >= 0) && (temp < vetor[j]); j--) {
            vetor[j + 1] = vetor[j];
        }
        vetor[j + 1] = temp;
    }
}