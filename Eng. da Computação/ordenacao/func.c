#include <stdio.h>
#include <stdlib.h>

#include "func.h"
#include "ordenacao.h"

void menu() {
    int opcao;

    printf("<==== MENU ====>");
    printf("\n1 - Bubble Sort");
    printf("\n2 - Ordenação por Seleção");
    printf("\n3 - Ordenação por Inserção");
    printf("\n4 - Sair");
    printf("\n\nEscolha uma opção: ");
    scanf("%d", &opcao);
}