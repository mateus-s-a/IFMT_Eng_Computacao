#include <stdio.h>
#include <stdlib.h>

#include "func.h"

// Função para criar uma nova lista (inicialmente vazia)
No* criarLista() {
    return NULL; // Retorna uma lista vazia
}

// Função para inserir um elemento no início da lista
No* inserirInicio(No* lista, int valor) {
    No* novo = (No*) malloc(sizeof(No));
    
    if (novo == NULL) {
        printf("Erro ao alocar memória.\n");
        exit(1);
    }
    
    novo->valor = valor;
    novo->prox = lista; // O novo nó aponta para o antigo primeiro nó
    
    return novo; // O novo nó passa a ser o início da lista
}

// Função para remover um elemento da lista (primeira ocorrência)
No* removerElemento(No* lista, int valor) {
    No* atual = lista;
    No* anterior = NULL;
    
    // Busca pelo elemento a ser removido
    while (atual != NULL && atual->valor != valor) {
        anterior = atual;
        atual = atual->prox;
    }
    
    if (atual == NULL) {
        printf("Elemento %d não encontrado.\n", valor);
        return lista;
    }
    
    // Se o elemento é o primeiro da lista
    if (anterior == NULL)
        lista = atual->prox;
    else
        anterior->prox = atual->prox; // Anterior aponta para o próximo do nó atual
    
    free(atual); // Libera o nó removido
    printf("Elemento %d removido.\n", valor);
    
    return lista;
}

// Função para buscar um elemento na lista
No* buscarElemento(No* lista, int valor) {
    No* atual = lista;
    
    while (atual != NULL) {
        if (atual->valor == valor) {
            printf("Elemento %d encontrado.\n", valor);
            return atual; // Retorna o ponteiro para o nó encontrado
        }
        atual = atual->prox;
    }
    printf("Elemento %d não encontrado.\n", valor);
    
    return NULL;
}

// Função para destruir a lista e liberar a memória
No* destruirLista(No* lista) {
    No* atual = lista;
    
    while (atual != NULL) {
        No* temp = atual;
        atual = atual->prox;
        
        free(temp); // Libera cada nó
    }
    printf("Lista destruída.\n");
    
    return NULL; // Retorna uma lista vazia
}

// Função para exibir todos os elementos da lista
void exibirLista(No* lista) {
    No* atual = lista;
    
    while (atual != NULL) {
        printf("%d -> ", atual->valor);
        atual = atual->prox;
    }
    printf("NULL\n");
}