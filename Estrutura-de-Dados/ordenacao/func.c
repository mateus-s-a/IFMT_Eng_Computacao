#include <stdio.h>
#include <stdlib.h>

#include "func.h"
#include "ordenacao.h"

void menu(int *vetor, int tamanho) {
    int opcao = 0;

    do {
        system("cls");
        
        printf("<==== MENU ====>");
        printf("\n1 - Bubble Sort");
        printf("\n2 - Ordenacao por Selecao");
        printf("\n3 - Ordenacao por Insercao");
        printf("\n4 - Sair");
        printf("\n\nEscolha uma opcao: ");
        scanf("%d", &opcao);

        switch(opcao) {
            case 1: {
                bubbleSort(vetor, tamanho);
                break;
            }

            case 2: {
                ordenacaoPorSelecao(vetor, tamanho);
                break;
            }

            case 3: {
                ordenacaoPorInsercao(vetor, tamanho);
                break;
            }

            case 4: {
                printf("Saindo...");
                break;
            }

            default: {
                printf("Opcao invalida. Tente novamente.\n");
            }
        }
    } while(opcao < 1 || opcao > 4);
}


void impressaoVetor(int *vetor, int tamanho) {
    printf("\n");
    for(int i = 0; i < tamanho; i++) {
        printf("%d ", vetor[i]);
    }
}