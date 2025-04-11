/*
 * Projeto: Avaliação 3 - Avaliador de Expressões
 * Arquivo: menu.c - espelho do menu
 * Nome: Lorena Strobel / Mateus de Souza Arruda
 * Data: 30/01/2025
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#include "func.h"
#define TAM 100  // tamanho para as strings

char validarOpcaoMenu() {
    char linha[100];
    char op;
    
    // Lê a linha inteira
    if (fgets(linha, sizeof(linha), stdin) == NULL) {
        return '0';
    }
    
    // Remove o \n do final se existir
    int tam = strlen(linha);
    if (tam > 0 && linha[tam-1] == '\n') {
        linha[tam-1] = '\0';
        tam--;
    }
    
    // Verifica se a linha tem exatamente 1 caractere
    if (tam != 1) {
        printf("\nEntrada invalida. Digite apenas um numero entre 1 e 5.\n\n");
        return '0';
    }
    
    op = linha[0];
    
    // Verifica se é um dígito entre 1 e 5
    if (!isdigit(op) || op < '1' || op > '5') {
        printf("\nOpcao invalida. Digite um numero entre 1 e 5.\n\n");
        return '0';
    }
    
    return op;
}

void menuPrincipal() {
    char op;
    char infixa[TAM];
    infixa[0] = '\0';  // Inicializa string vazia
    
    do {
        limparTela();
        // Menu estilizado
        printf("\n======================================\n");
        printf("             MENU PRINCIPAL           \n");
        printf("======================================\n");
        printf("1 - Definir Expressao\n");
        printf("2 - Definir Valor das Variaveis\n");
        printf("3 - Avaliar Expressao\n");
        printf("4 - Salvar Historico\n");
        printf("5 - Sair\n");
        printf("======================================\n");
        printf("Opcao: ");
        
        op = validarOpcaoMenu();
        if (op == '0') {
            pausar();
            continue;
        }
        
        menuOpcoes(op, infixa);
        if (op != '5') {
            pausar();
        }
    } while (op != '5');
}

void menuOpcoes(char op, char *infixa) {
    static float *valores = NULL;
    static char posfixa[TAM] = "";
    switch (op) {
        case '1':
            limparTela();
            definirExpressao(infixa);
            strcpy(posfixa, infixaParaPosfixa(infixa));
            break;

        case '2':
            if (infixa[0] == '\0') {
                printf("\nDefina uma expressao primeiro.\n\n");
                break;
            }
            if (valores != NULL) {
                free(valores);
                valores = NULL;
            }
            valores = definirValores(infixa);
            break;

        case '3':
            avaliarExpressao(infixa, posfixa, valores);
            break;
            
        case '4':
            salvarHistoricoCompleto(infixa, posfixa, valores);
            break;

        case '5':
            printf("\nEncerrando o programa...\n");
            if (valores != NULL) {
                free(valores);
            }
            exit(0);  // encerra o programa
            break;
            
        default:
            printf("\nOpcao invalida, digite novamente.\n\n");
    }
}