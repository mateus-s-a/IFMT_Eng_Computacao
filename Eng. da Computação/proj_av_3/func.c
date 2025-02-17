/*
 * Projeto: Avaliação 3 - Avaliador de Expressões
 * Arquivo: func.c - espelho das funções utilizadas no programa
 * Nome: Lorena Strobel / Mateus de Souza Arruda
 * Data: 30/01/2025
 */

#include "func.h"

#ifdef _WIN32
#include <windows.h>
#endif

#define NUM_VARIAVEIS 26  // valores de A a Z
#define TAM 100           // tamanho para as strings de Entrada
#define PTAM 256          // pilhas ao longo do programa

// Função para verificar se é Windows
int ehSOWindows() {
    #ifdef _WIN32
        return 1;
    #else
        return 0;
    #endif
}

// Função para limpar a tela
void limparTela() {
    if (ehSOWindows()) system("cls");
    else printf("\033[H\033[J");  // Código ANSI para limpar tela
}

// Função para pausar
void pausar() {
    if (ehSOWindows()) system("pause");
    else {
        printf("Pressione Enter para continuar...");
        getchar();
    }
}

void definirExpressao(char *infixa) {
    printf("Digite a expressao: ");
    fgets(infixa, TAM, stdin);

    int tam = strlen(infixa);
    if (tam > 0 && infixa[tam - 1] == '\n') {
        infixa[tam - 1] = '\0';
    }
    if (validarExpressao(infixa)) {
        printf("\nExpressao incorreta, digite novamente.\n\n");
        return;
    } else {
        printf("\nExibindo no formato posfixa: %s\n\n", infixaParaPosfixa(infixa));
    }
}

float *definirValores(char *infixa) {
    float *valores = (float *)malloc(NUM_VARIAVEIS * sizeof(float)); // aloca memória para os valores das variáveis
    int atribuida[NUM_VARIAVEIS] = {0};  // 0: não atribuída, 1: atribuída

    if (infixa[0] == '\0') {
        printf("\nDefina uma expressao primeiro.\n\n");
        return NULL;
    }
    if (validarExpressao(infixa)) {
        printf("\nDigite uma expressao correta primeiro.\n\n");
        return NULL;
    }
    if (valores == NULL) {
        printf("\nErro ao alocar memoria, tente novamente\n\n");
        return NULL;
    }
    for (int i = 0; i < NUM_VARIAVEIS; i++) {
        valores[i] = 0;
    }

    // Identifica automaticamente as variaveis presentes na expressao
    int usados[NUM_VARIAVEIS] = {0};  // 0: nao usada, 1: usada
    for (int i = 0; infixa[i] != '\0'; i++) {
        if (isalpha(infixa[i])) {
            usados[toupper(infixa[i]) - 'A'] = 1;
        }
    }

    limparTela();
    printf("Digite os valores para as variaveis:\n");
    for (int i = 0; i < NUM_VARIAVEIS; i++) {
        if (usados[i]) {
            float valor;
            printf("%c: ", 'A' + i);
            scanf("%f", &valor);
            if (valor == 0) {
                // Verifica se a variável é usada como denominador
                for (int j = 0; infixa[j] != '\0'; j++) {
                    if (infixa[j] == '/' && toupper(infixa[j + 1]) == 'A' + i) {
                        printf("\nErro: Divisao por zero detectada na variavel %c.\n\n", 'A' + i);
                        free(valores);
                        while(getchar() != '\n');    // limpa o buffer do teclado
                        return NULL;
                    }
                }
            }
            valores[i] = valor;
            atribuida[i] = 1;  // Marca a variável como atribuída
        }
    }

    printf("\nValores atribuidos as variaveis:\n");
    for (int i = 0; i < NUM_VARIAVEIS; i++) {
        if (atribuida[i]) {
            printf("%c = %.2f\n", 'A' + i, valores[i]);
        }
    }
    printf("\n");

    // Limpar o buffer do teclado, se necessário
    while(getchar() != '\n');

    return valores;
}

void avaliarExpressao(char *infixa, char *posfixa, float *valores) {
    if (infixa[0] == '\0') {
        printf("\nDefina uma expressao primeiro.\n\n");
        return;
    }
    if (validarExpressao(infixa)) {
        printf("\nDefina uma expressao correta primeiro e depois seus valores na opcao 2.\n\n");
        return;
    }
    if (valores == NULL) {
        printf("\nDefina os valores das variaveis primeiro.\n\n");
        return;
    }
    
    float resultado = avaliarPosfixa(posfixa, valores);
    
    limparTela();
    printf("\nExpressao: %s\n", infixa);
    for (int i = 0; i < NUM_VARIAVEIS; i++) {
        if (valores[i] != 0 || strchr(infixa, 'A' + i)) {
            printf("%c = %.2f\n", 'A' + i, valores[i]);
        }
    }
    printf("\nResultado: %.2f\n\n", resultado);
}

int validarExpressao(char *infixa) {
    Pilhachar P = pilhachar(PTAM);  // Pilha para verificar parênteses
    int ultimo_foi_operador = 0;            // se foi operador
    int ultimo_foi_parenteses_aberto = 0;   // se foi '('
    int parenteses_balanceados = 1;         // se foi ')'
    int encontrou_operando = 0;             // se a expressão tem ao menos um operando

    for (int i = 0; infixa[i] != '\0'; i++) {
        char c = infixa[i];  // Caractere atual da expressão

        if (isspace(c)) {
            continue;  // ignora espaços em branco
        }
        if (c == '(') {
            if (i > 0 && infixa[i - 1] != '+' && infixa[i - 1] != '-' && infixa[i - 1] != '*' && infixa[i - 1] != '/' && infixa[i - 1] != '(') {
                parenteses_balanceados = 0;
                break;  // inválida falta um operador antes de '('
            }
            empilhaChar(c, P);                 // Empilha o parêntese
            ultimo_foi_operador = 1;          // esperando um operador ou'('
            ultimo_foi_parenteses_aberto = 1;  // parêntese aberto encontrado
        } else if (c == ')') {
            if (vaziaChar(P))  // fecha um parêntese sem abrir antes
            {
                parenteses_balanceados = 0;
                break;  // expressão inválida: mais ')' que '('
            }
            desempilhaChar(P);                 // Desempilha o parêntese de fechamento
            ultimo_foi_operador = 0;          // esperando um operando ou outro ')'
            ultimo_foi_parenteses_aberto = 0;  // evita casos como 'A(B+C)'
        } else if (isalpha(c)) {
            encontrou_operando = 1;  // expressão tem ao menos um operando
            // se não for o primeiro caractere e o anterior não for um operador ou '('
            if (i > 0 && !ultimo_foi_operador && !ultimo_foi_parenteses_aberto) {
                parenteses_balanceados = 0;
                break;  // se não for encontrado um operador depois retorna erro
            }
            ultimo_foi_operador = 0;
            ultimo_foi_parenteses_aberto = 0;
        } else if (strchr("+-*/", c)) {
            if (ultimo_foi_operador || i == 0 || ultimo_foi_parenteses_aberto) {
                parenteses_balanceados = 0;
                break;  // Exemplo inválido: (+A) ou A++
            }
            ultimo_foi_operador = 1;  // esperando um operando ou '('
            ultimo_foi_parenteses_aberto = 0;
        } else {
            parenteses_balanceados = 0;
            break;  // algum caractere diferente dos válidos foi encontrado, indicando erro
        }
    }
    if (!vaziaChar(P))  // '(' sem fechar
    {
        parenteses_balanceados = 0;  // inválida
    }
    destroiChar(&P);    // libera memória

    return !(parenteses_balanceados && encontrou_operando);  // 1 se a expressão é inválida 0 se é válida
}

int prioridade(char operador) {
    switch (operador) {
        case '(':
            return 0;
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        default:
            return -1;  // operador inválido
    }
}

char *infixaParaPosfixa(char *infixa) {
    static char posfixa[PTAM];
    int j = 0;
    Pilhachar P = pilhachar(PTAM);

    for (int i = 0; infixa[i]; i++) {
        if (infixa[i] == '(') {
            empilhaChar('(', P);
        } else if (isalpha(infixa[i]) || isdigit(infixa[i])) {
            posfixa[j++] = infixa[i];
        } else if (strchr("+-/*", infixa[i])) {
            while (!vaziaChar(P) && prioridade(topoChar(P)) >= prioridade(infixa[i])) {
                posfixa[j++] = desempilhaChar(P);
            }
            empilhaChar(infixa[i], P);
        } else if (infixa[i] == ')') {
            while (topoChar(P) != '(') {
                posfixa[j++] = desempilhaChar(P);
            }
            desempilhaChar(P);
        }
    }
    while (!vaziaChar(P)) {
        posfixa[j++] = desempilhaChar(P);
    }

    posfixa[j] = '\0';
    destroiChar(&P);

    return posfixa;
}

float avaliarPosfixa(char *posfixa, float *valores) {
    Pilhafloat P = pilhaFloat(PTAM);

    for (int i = 0; posfixa[i]; i++) {
        if (isalpha(posfixa[i])) {
            empilhaFloat(valores[toupper(posfixa[i]) - 'A'], P);
        } else if (isdigit(posfixa[i])) {
            empilhaFloat(posfixa[i] - '0', P);
        } else if (strchr("+-/*", posfixa[i])) {
            float y = desempilhaFloat(P);
            float x = desempilhaFloat(P);
            switch (posfixa[i]) {
                case '+':
                    empilhaFloat(x + y, P);
                    break;
                case '-':
                    empilhaFloat(x - y, P);
                    break;
                case '*':
                    empilhaFloat(x * y, P);
                    break;
                case '/':
                    empilhaFloat(x / y, P);
                    break;
            }
        }
    }
    
    float resultado = desempilhaFloat(P);
    destroiFloat(&P);
    
    return resultado;
}

void salvarHistoricoCompleto(char *infixa, char *posfixa, float *valores) {
    if (infixa[0] == '\0') {
        printf("\nNenhuma expressao definida para salvar.\n\n");
        return;
    }
    if (valores == NULL) {
        printf("\nValores das variaveis nao foram definidos.\n\n");
        return;
    }

    float resultado = avaliarPosfixa(posfixa, valores);
    FILE *fp = fopen("historico.txt", "a+");
    if (fp == NULL) {
        printf("Erro ao abrir arquivo de historico.\n");
        return;
    }

    static int contagem = 1; // Contador estático para número de expressão no 'historico.txt'
    
    // Verifica se o arquivo já existe e ajusta o contador
    fseek(fp, 0, SEEK_END);
    if (ftell(fp) != 0) {
        rewind(fp);
        char linha[256];
        while (fgets(linha, sizeof(linha), fp)) {
            if (strstr(linha, "********* EXPRESSAO")) {
                sscanf(linha, "********* EXPRESSAO %d *********", &contagem);
                contagem++;
            }
        }
    }

    fprintf(fp, "********* EXPRESSAO %d *********\n", contagem);
    fprintf(fp, "EXPRESSAO INFIXA.....: %s\n", infixa);
    fprintf(fp, "EXPRESSAO POSFIXA....: %s\n", posfixa);
    fprintf(fp, "VALORES DAS VARIAVEIS:\n");
    for (int i = 0; i < NUM_VARIAVEIS; i++) {
        if (valores[i] != 0 || strchr(infixa, 'A' + i)) { // inclui variáveis usadas na expressão
            fprintf(fp, "%c = %.2f\n", 'A' + i, valores[i]);
        }
    }
    fprintf(fp, "RESULTADO............: %.2f\n", resultado);
    fprintf(fp, "\n---------------------------------------------\n\n");
    fclose(fp);
    printf("\nHistorico salvo com sucesso.\n\n");

    contagem++; // Incrementa o contador para a próxima expressão
}
