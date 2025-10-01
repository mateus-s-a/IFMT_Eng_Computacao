grammar MicroLang;

// --- REGRAS DO PARSER ---
programa
    : PROGRAMA ID bloco
    ;

bloco
    : LBRACE declaracao* comando* RBRACE
    ;

comando
    : escrita
    | leitura
    | atribuicao
    ;

atribuicao
    : ID ATTR expressao SEMI
    ;

escrita
    : ESCREVER (expressao | STRING) SEMI
    ;

leitura
    : LER ID SEMI
    ;

expressao
    : ID
    ;

declaracao
    : tipo ID SEMI
    ;

tipo
    : TIPO_INTEIRO
    | TIPO_REAL
    | TIPO_TEXTO
    ;






// --- TOKENS DO LEXER ---
// Keywords dos Tipos
ESCREVER    : 'escrever' ;
LER         : 'ler' ;

PROGRAMA        : 'programa' ;
TIPO_INTEIRO    : 'inteiro' ;
TIPO_REAL       : 'real' ;
TIPO_TEXTO      : 'texto' ;

STRING  : '"' ~["]* '"' ;
ID      : [a-zA-Z][a-zA-Z0-9]* ;

LBRACE  : '{' ;
RBRACE  : '}' ;
SEMI    : ';' ;
ATTR    : '=' ;

OP_ADD  : '+' | '-' ;
OP_MUL  : '*' | '/' ;

WS : [ \t\r\n]+ -> skip ;