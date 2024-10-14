#include <stdio.h>
#include <stdlib.h>

#include "func.c"
#include "ordenacao.h"

int main() {
    int tamanho;

    printf("Digite o tamanho para o vetor: ");
    scanf("%d", &tamanho);

    int* vetor = (int*) malloc(tamanho * sizeof(int));

    if(vetor == NULL) {
        printf("Erro ao alocar memória.\n");
        return 1; // Sai do programa em caso de erro da alocação de memória
    }

    for(int i = 0; i < tamanho; i++) {
        printf("Digite o valor para o vetor[%d]: ", i);
        scanf("%d", &vetor[i]);
    }
}