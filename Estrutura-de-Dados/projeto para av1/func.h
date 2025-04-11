#ifndef BUSCAS_H
#define BUSCAS_H

void menuEscolhaBuscas(int *v, int tam, int num, int ini, int fim);

void bubbleSort(int *v, int tam);
void mergeSort(int *v, int ini, int fim);
void quickSort(int *v, int ini, int fim);
void heapSort(int *v, int tam);

int buscaLinear(int *v, int tam, int num);
int buscaBinaria(int *v, int tam, int num, int ini, int fim, int opcao);

#endif // BUSCAS_H