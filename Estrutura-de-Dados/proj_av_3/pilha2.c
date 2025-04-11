/*
 * Projeto: Avaliação 3 - Avaliador de Expressões
 * Arquivo: pilha2.c - espelho das funções da pilha float
 * Nome: Lorena Strobel / Mateus de Souza Arruda
 * Data: 30/01/2025
 */

#include "pilha2.h"


Pilhafloat pilhaFloat(int m) {
    Pilhafloat F = malloc(sizeof(struct pilhaf));
    F->max = m;
    F->topo = -1;
    F->dados = malloc(m * sizeof(Dadosfloat));
    return F;  // retorna a pilha criada
}

void empilhaFloat(Dadosfloat x, Pilhafloat F) {
    if (cheiaFloat(F)) {
        printf("Pilha cheia, nao eh possivel inserir mais itens.\n");
    } else {
        F->topo++;              // incrementando para poder adicionar um novo item
        F->dados[F->topo] = x;  // adicionar o item;
    }
}

Dadosfloat desempilhaFloat(Pilhafloat F) {
    if (vaziaFloat(F)) {
        printf("A pilha esta vazia.\n");
        return 0;
    } else {
        Dadosfloat x = F->dados[F->topo];  // copiando o item removido
        F->topo--;                         // removendo o item
        return x;                          // devolvendo o item que foi removido
    }
}

Dadosfloat topoFloat(Pilhafloat F) {
    if (vaziaFloat(F)) {
        printf("Pilha vazia.\n");
        return 0;
    } else {
        return F->dados[F->topo];
    }
}

// Funções de verificação e destruição (movidas de func.c)
int vaziaFloat(Pilhafloat F) {
    return (F->topo == -1);
}

int cheiaFloat(Pilhafloat F) {
    return (F->topo == F->max - 1);
}

void destroiFloat(Pilhafloat *p) {
    free((*p)->dados);
    free(*p);
    *p = NULL;
}