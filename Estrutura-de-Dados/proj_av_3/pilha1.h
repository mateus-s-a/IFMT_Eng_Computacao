/*
 * Projeto: Avaliação 3 - Avaliador de Expressões
 * Arquivo: pilha1.h - protótipo das funções da pilha de caracteres
 * Nome: Lorena Strobel / Mateus de Souza Arruda
 * Data: 30/01/2025
 */

#ifndef PILHA1_H
#define PILHA1_H

#include <stdio.h>
#include <stdlib.h>

typedef char Dadoschar;

// estrutura pilha de caracteres
typedef struct pilhac {
    int max;           // tamanho da pilha
    int topo;          // topo da pilha
    Dadoschar *dados;  // ponteiro para os itens da pilha
} *Pilhachar;

Pilhachar pilhachar(int tam);
void empilhaChar(Dadoschar x, Pilhachar C);
Dadoschar desempilhaChar(Pilhachar C);
Dadoschar topoChar(Pilhachar C);

// Novos protótipos para evitar avisos de declaração implícita
int vaziaChar(Pilhachar C);
int cheiaChar(Pilhachar C);
void destroiChar(Pilhachar *p);

#endif // PILHA1_H