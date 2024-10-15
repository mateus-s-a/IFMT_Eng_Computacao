#include <stdio.h>
#include <stdlib.h>

#include "func.h"
#include "ordenacao.h"

int main() {
    system("cls");
    
    int tamanho;

    printf("Digite o tamanho para o vetor: ");
    scanf("%d", &tamanho);

    int* vetor = (int*) malloc(tamanho * sizeof(int));

    if(vetor == NULL) {
        printf("\nErro ao alocar memoria.\n");
        return 1; // Sai do programa em caso de erro da alocação de memória
    }

    printf("\n");
    for(int i = 0; i < tamanho; i++) {
        printf("Digite o valor para o vetor[%d]: ", i);
        scanf("%d", &vetor[i]);
    }

    menu(vetor, tamanho);
    impressaoVetor(vetor, tamanho);
    
    free(vetor);

    return 0;
}