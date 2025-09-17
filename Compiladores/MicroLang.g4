grammar LanguageCode;

// *** PARSER ***
programa
    : 'programa' ID bloco
    ;

bloco
    : '{' (declaracao)* (comando)* '}'
    ;

declaracao
    : tipo ID ('=' expr)? ';'       // declaração possui o tipo e opcionalmente pode ser declara já contendo uma atribuição
    ;

tipo
    : 'inteiro'
    | 'real'
    | 'texto'
    ;
    
comando                             // integra todas as REGRAS funcionais ao "menu" principal
    : escrita
    | leitura
    | atribuicao
    | enquanto
    | repita
    | laco_para
    | loop_infinito
    ;


// *** E/S REGRAS ***
escrita
    : 'escrever' (STRING| expr) ';'         // 'escrever' é um token implícito, ou seja, é "declarado" do Lexer como um Token, mas não tecnicamente
    ;

leitura
    : 'ler' ID ';'
    ;

atribuicao
    : ID '=' expr ';'
    ;


// *** REGRAS DE LOOPS ***
enquanto                                        // while
    : 'enquanto' '(' condicao ')' bloco
    ;

repita                                          // do...while
    : 'repita' bloco 'ate' '(' condicao ')' ';'
    ;

laco_para                                       // for
    : 'para' '(' atribuicao condicao ';' incremento ')' bloco
    ;

loop_infinito
    : 'loop' bloco
    ;

incremento                                      // incremento para o loop 'for' => 'para'
    :
    ;

condicao
    : expr OP_REL expr
    ;


// *** REGRAS DAS EXPRESSÕES ***
expr
    : termo (OP_ADD termo)*
    ;
    
termo
    : fator (OP_MUL fator)*
    ;

fator
    : tipo
    | ID
    | '(' expr ')'
    ;




// *** LEXER (cada um é um Token) ***
OP_REL  : '==' | '!=' | '>' | '<' | '>=' | '<=' ;
OP_ADD  : '+' | '-' ;
OP_MUL  : '*' | '/' ;
OP_INC  : '++' | '--' ;

NUMERO  : [0-9]+ ('.' [0-9]+)? ;
STRING  : '"' ~["]* '"' ;

ID      : [a-zA-Z][a-zA-Z_0-9]* ;
WS      : [ \t\r\n]+ -> skip ;