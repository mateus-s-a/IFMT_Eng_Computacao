// Definição da estrutura do nó
typedef struct No {
    int valor;
    struct No* prox;
} No;

No* criarLista();
No* inserirInicio(No* lista, int valor);
No* removerElemento(No* lista, int valor);
No* buscarElemento(No* lista, int valor);
No* destruirLista(No* lista);
void exibirLista(No* lista);