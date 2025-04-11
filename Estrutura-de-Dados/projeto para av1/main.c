#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "func.h"


int main() {
    int tamanho, numero;

    printf("Digite o tamanho do vetor: ");
    scanf("%d", &tamanho);
    printf("Digite o numero a ser procurado e buscado: ");
    scanf("%d", &numero);
    
    int ini = 0;
    int fim = tamanho - 1;
    int* vetor = malloc(tamanho * sizeof(int));
    
    printf("\n");
    for (int i = 0; i < tamanho; i++) {
        printf("Digite um valor para a posicao [%d]: ", i);
        scanf("%d", &vetor[i]);
    }
    
    printf("\n");
    menuEscolhaBuscas(vetor, tamanho, numero, ini, fim);
    
    free(vetor);
    
    return 0;
}