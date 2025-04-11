#include <stdio.h>
#include <stdlib.h>

#include "func.h"

// Função principal para testar as operações
int main() {
    No* lista = criarLista(); // Criação da lista vazia
    
    // Inserindo de elementos na lista
    lista = inserirInicio(lista, 10);
    lista = inserirInicio(lista, 30);
    lista = inserirInicio(lista, 20);
    
    printf("Lista após inserções:\n");
    exibirLista(lista);
    
    // Busca por elementos
    buscarElemento(lista, 20);
    buscarElemento(lista, 40);
    
    // Remoção de um elemento
    lista = removerElemento(lista, 20);
    printf("Lista após remoção:\n");
    exibirLista(lista);
    
    // Destruição da lista
    lista = destruirLista(lista);
    
    return 0;
}