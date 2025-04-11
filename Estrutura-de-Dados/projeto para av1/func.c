#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#include "func.h"

// Protótipo da função
void menuEscolhaBuscas(int *v, int tam, int num, int ini, int fim);

void menuEscolhaBuscas(int *v, int tam, int num, int ini, int fim) {
    int opcao = 0;
    
    do {
        printf("1) Busca Linear");
        printf("\n2) Busca Binaria");
        printf("\n3) Sair");
        printf("\nEscolha uma opcao de busca: ");
        scanf("%d", &opcao);
    } while (opcao < 1 || opcao > 3);
    
    switch (opcao) {
        case 1:
            printf("Modo de Busca: Busca Linear");
            (buscaLinear(v, tam, num) == -1) ? printf("\n\nNumero nao encontrado") : printf("\n\nNumero encontrado na posicao [%d]", buscaLinear(v, tam, num));
            break;
        case 2:
            menuEscolhaTipoOrdenacao(v, tam, num, ini, fim);            
            break;
        case 3:
            exit(0);
            break;
        default:
            printf("\nOpcao invalida");
            break;
    }
}

void menuEscolhaTipoOrdenacao(int *v, int tam, int num, int ini, int fim) {
    int opcao = 0;

    do {
        printf("1) Bubble Sort");
        printf("\n2) Merge Sort");
        printf("\n3) Quick Sort");
        printf("\n4) Heap Sort");
        printf("\n5) Sair");
        printf("\nEscolha uma opcao de ordenacao: ");
        scanf("%d", &opcao);
    } while (opcao < 1 || opcao > 5);

    switch (opcao) {
        case 1:
            printf("Modo de Ordenacao: Bubble Sort");
            buscaBinaria(v, tam, num, ini, fim, 1);
            (buscaBinaria(v, tam, num, ini, fim, 1) == -1) ? printf("\n\nNumero nao encontrado") : printf("\n\nNumero [%d] encontrado na posicao [%d]", num, buscaBinaria(v, tam - 1, num, ini, fim, 1));
            break;
        case 2:
            printf("Modo de Ordenacao: Merge Sort");
            buscaBinaria(v, tam, num, ini, fim, 2);
            (buscaBinaria(v, tam, num, ini, fim, 2) == -1) ? printf("\n\nNumero nao encontrado") : printf("\n\nNumero [%d] encontrado na posicao [%d]", num, buscaBinaria(v, tam - 1, num, ini, fim, 2));
            break;
        case 3:
            printf("Modo de Ordenacao: Quick Sort");
            buscaBinaria(v, tam, num, ini, fim, 3);
            (buscaBinaria(v, tam, num, ini, fim, 3) == -1) ? printf("\n\nNumero nao encontrado") : printf("\n\nNumero [%d] encontrado na posicao [%d]", num, buscaBinaria(v, tam - 1, num, ini, fim, 3));
            break;
        case 4:
            printf("Modo de Ordenacao: Heap Sort");
            buscaBinaria(v, tam, num, ini, fim, 4);
            (buscaBinaria(v, tam, num, ini, fim, 4) == -1) ? printf("\n\nNumero nao encontrado") : printf("\n\nNumero [%d] encontrado na posicao [%d]", num, buscaBinaria(v, tam - 1, num, ini, fim, 4));
            break;
        case 5:
            exit(0);
            break;
        default:
            printf("\nOpcao invalida");
            break;
    }
}

void bubbleSort(int *v, int tam) {
    // FORMA ITERATIVA
    /* for (int i = 0; i < tam - 1; i++) {
        for (int j = 0; j < tam - i - 1; j++) {
            if (v[j] > v[j + 1]) {
                int aux = v[j];
                v[j] = v[j + 1];
                v[j + 1] = aux;
            }
        }
    } */
    
    // FORMA RECURSIVA
    // Caso base: se o tamanho do arra for 1, já está ordenado
    if (tam == 1)
        return;
    
    // Uma iteração do bubble sort
    for (int i = 0; i < tam - 1; i++) {
        // Se o elemeno atual for maior que o próxim, troca os dois
        if (v[i] > v[i + 1]) {
            int temp = v[i];
            v[i] = v[i + 1];
            v[i + 1] = temp;
        }
    }
    
    // Chama recursivamente a função para o restante do array
    bubbleSort(v, tam - 1);
}

void merge(int *v, int ini, int meio, int fim) {
    int *temp = (int *) malloc((fim - ini + 1) * sizeof(int));
    int p1 = ini, p2 = meio + 1, i = 0;

    while (p1 <= meio && p2 <= fim) {
        if (v[p1] < v[p2])
            temp[i++] = v[p1++];
        else
            temp[i++] = v[p2++];
    }

    while (p1 <= meio)
        temp[i++] = v[p1++];
    while (p2 <= fim)
        temp[i++] = v[p2++];

    for (int j = 0, k = ini; j < i; j++, k++) {
        v[k] = temp[j];
    }

    free(temp);
}

void mergeSort(int *v, int ini, int fim) {
    if (ini < fim) {
        int meio = (ini + fim) / 2;
        mergeSort(v, ini, meio);
        mergeSort(v, meio + 1, fim);
        merge(v, ini, meio, fim);
    }
}

int particiona(int *v, int ini, int fim) {
    int esq, dir, pivo, aux;

    esq = ini;
    dir = fim;
    pivo = v[ini]; // pivo = primeiro elemento

    while (esq <= dir) {
        while (esq <= dir && v[esq] <= pivo) // avança posição da esquerda
            esq++;
        while (esq <= dir && v[dir] > pivo) // recua posição da direita
            dir--;
        
        if (esq <= dir) { // trocar esquerda e direita
            aux = v[esq];
            v[esq] = v[dir];
            v[dir] = aux;
            esq++;
            dir--;
        }
    }

    v[ini] = v[dir];
    v[dir] = pivo;

    return dir;
}

void quickSort(int *v, int ini, int fim) {
    int pivo;

    if (fim > ini) {
        pivo = particiona(v, ini, fim); // separa os dados em 2 partições

        quickSort(v, ini, pivo - 1); // chama a função para a metade esquerda
        quickSort(v, pivo + 1, fim); // chama a função para a metade direita
    }
}

void criaHeap(int *v, int ini, int fim) {
    int aux = v[ini];
    int j = 2 * ini + 1;

    while (j <= fim) {
        if (j < fim && v[j] < v[j + 1]) // pai tem 2 filhos? quem é o maior?
            j++;
        if (aux < v[j]) { // filho maior que o pai? filho se torna pai, repetir o processo
            v[ini] = v[j];
            ini = j;
            j = 2 * ini + 1;
        } else {
            break; // Se o pai for maior ou igual ao filho, sai do loop
        }
    }

    v[ini] = aux; // antigo pai ocupa lugar do último filho analisado
}

void heapSort(int *v, int tam) {
    int i, aux;

    for (i = (tam - 1) / 2; i >= 0; i--) // cria heap a partir dos dados
        criaHeap(v, i, tam - 1);
    
    for (i = tam - 1; i > 0; i--) { // pegar o maior elemento do heap e colocar na sua posição correspondente ao array
        aux = v[0];
        v[0] = v[i];
        v[i] = aux;

        criaHeap(v, 0, i - 1); // reconstruir o heap
    }
}

int buscaLinear(int *v, int tam, int num) {
    // FORMA ITERATIVA
    // for (int i = 0; i < tam; i++) {
    //     if (v[i] == num)
    //         return i;
    // }

    // return -1;
    

    // FORMA RECURSIVA
    if (tam == 0)
        return -1;
    else if (v[tam - 1] == num)
        return tam - 1;
    else
        return buscaLinear(v, tam - 1, num);
}

int buscaBinaria(int *v, int tam, int num, int ini, int fim, int opcao) {
    if (opcao == 1)
        bubbleSort(v, tam);
    else if (opcao == 2)
        mergeSort(v, ini, fim);
    else if (opcao == 3)
        quickSort(v, ini, fim);
    else
        heapSort(v, tam);
    

    // FORMA ITERATIVA
    // while (ini <= fim) {
    //     int meio = (ini + fim) / 2;

    //     if (v[meio] == num)
    //         return meio;
    //     else if (v[meio] < num)
    //         ini = meio + 1;
    //     else
    //         fim = meio - 1;
    // }

    // return -1;

    
    // FORMA RECURSIVA
    if (ini <= fim) {
        int meio = (ini + fim) / 2;

        if (v[meio] == num)
            return meio;
        else if (v[meio] < num)
            return buscaBinaria(v, tam, num, meio + 1, fim, opcao);
        else
            return buscaBinaria(v, tam, num, ini, meio - 1, opcao);
    }

    return -1;
}