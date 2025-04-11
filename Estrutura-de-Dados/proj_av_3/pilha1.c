/*
 * Projeto: Avaliação 3 - Avaliador de Expressões
 * Arquivo: pilha1.c - espelho das funções da pilha de caracteres
 * Nome: Lorena Strobel / Mateus de Souza Arruda
 * Data: 30/01/2025
 */

#include "pilha1.h"


Pilhachar pilhachar(int m) {
    Pilhachar C = malloc(sizeof(struct pilhac));
    C->max = m;
    C->topo = -1;
    C->dados = malloc(m * sizeof(Dadoschar));
    return C;  // retorna a pilha c
}

void empilhaChar(Dadoschar x, Pilhachar C) {
    if (cheiaChar(C)) {
        printf("Pilha cheia, nao eh possivel inserir mais itens.\n");
    } else {
        C->topo++;              // incrementando para poder adicionar um novo item
        C->dados[C->topo] = x;  // adicionar o item;
    }
}

Dadoschar desempilhaChar(Pilhachar C) {
    if (vaziaChar(C)) {
        printf("A pilha está vazia.\n");
        return '\0';
    } else {
        Dadoschar x = C->dados[C->topo];  // copiando o item removido
        C->topo--;                        // removendo o item
        return x;                         // devolvendo o item que foi removido
    }
}

Dadoschar topoChar(Pilhachar C) {
    if (vaziaChar(C)) {
        printf("Pilha vazia.\n");
        return '\0';
    } else {
        return C->dados[C->topo];
    }
}

// Funções de verificação e destruição (movidas de func.c)
int vaziaChar(Pilhachar C) {
    return (C->topo == -1);
}

int cheiaChar(Pilhachar C) {
    return (C->topo == C->max - 1);
}

void destroiChar(Pilhachar *p) {
    free((*p)->dados);
    free(*p);
    *p = NULL;
}