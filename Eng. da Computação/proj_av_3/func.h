/*
 * Projeto: Avaliação 3 - Avaliador de Expressões
 * Arquivo: func.h - protótipo das funções do programa
 * Nome: Lorena Strobel / Mateus de Souza Arruda
 * Data: 30/01/2025
 */

#ifndef FUNC_H
#define FUNC_H

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

#include "pilha1.h"
#include "pilha2.h"

// Funções principais do programa
void menuPrincipal();
void menuOpcoes(char op, char *infixa);
void definirExpressao(char *infixa);
float *definirValores(char *infixa);
void avaliarExpressao(char *infixa, char *posfixa, float *valores);
int validarExpressao(char *infixa);

// Funções de pilha char
int vaziaChar(Pilhachar C);
int cheiaChar(Pilhachar C);
void destroiChar(Pilhachar *p);

// Funções de pilha float
int vaziaFloat(Pilhafloat F);
int cheiaFloat(Pilhafloat F);
void destroiFloat(Pilhafloat *p);

// Funções para as expressões
int prioridade(char operador);
char *infixaParaPosfixa(char *infixa);
float avaliarPosfixa(char *posfixa, float *valores);

// Funções de utilidade do sistema
void limparTela(void);
void pausar(void);
int ehSOWindows(void);
char validarOpcaoMenu(void);

void salvarHistoricoCompleto(char *infixa, char *posfixa, float *valores); // nova função para salvar o histórico

#endif // FUNC_H