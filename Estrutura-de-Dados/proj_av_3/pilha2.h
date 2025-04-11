/*
 * Projeto: Avaliação 3 - Avaliador de Expressões
 * Arquivo: pilha2.h - protótipo das funções da pilha float
 * Nome: Lorena Strobel / Mateus de Souza Arruda
 * Data: 30/01/2025
 */

#ifndef PILHA2_H
#define PILHA2_H

#include <stdio.h>
#include <stdlib.h>

typedef float Dadosfloat;

// estrutura pilha de floats
typedef struct pilhaf {
    int max;            // tamanho da pilha
    int topo;           // topo da pilha
    Dadosfloat *dados;  // ponteiro para os itens da pilha
} *Pilhafloat;

Pilhafloat pilhaFloat(int tam);
void empilhaFloat(Dadosfloat x, Pilhafloat F);
Dadosfloat desempilhaFloat(Pilhafloat F);
Dadosfloat topoFloat(Pilhafloat F);

// Novos protótipos para evitar avisos de declaração implícita
int vaziaFloat(Pilhafloat F);
int cheiaFloat(Pilhafloat F);
void destroiFloat(Pilhafloat *p);

#endif // PILHA2_H