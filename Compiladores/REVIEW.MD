### Diferença na criação dos tokens `print` e `read`:

**Maneira Rápida**: ao escrever um texto entre aspas simples *direto* na regra do `Parser` (`'print'`), o ANTLR é inteligente o suficiente para criar uma "token implícito" nos bastidores, fazendo o trabalho do `Lexer`. Sendo ótimo para gramáticas pequenas e simples.
```antlr
print
    : 'print' (STRING | ID) ';'
    ;
```

<br>

**Maneira Formal**: ao criar um token explícito no `Lexer` (como `READ : 'read' ;`), se diz da forma mais organizada e formal; prática recomendada, especialmente em gramáticas maiores, por duas razões principais:

- **Clareza**: fica claro para leitura do código e quais são todas as "palavras-chave" da linguagem;
- **Evita Ambiguidade**: se não definíssemos `PRINT` e `READ`, a regra `ID` (que reconhece qualquer palavra) poderia capturá-los.
```antlr
READ : 'read' ;
```

<br><br>

### Opcional em ANTLR
Por exemplo, na condição `if-else`, `else` é considerado opcional, dizendo que a gramática deve aceitar um bloco `else` se ele estiver lá, mas não retornar um erro se não estiver.

Em ANTLR, o símbolo de interrogação `?` marca algo como "opcional" (zero ou uma vez):
```antlr
condition
    : expr (GT | LT | EQ) expr
    ;

ifStatement
    : IF '(' condition ')' '{' statement+ '}'
    (ELSE '{' statement+ '}')?
    ;
```