grammar LanguageCode;


program
    : statement+
    ;

statement
    : assignment
    | print
    | readCommand
    ;
    
assignment
    : ID '=' (STRING | expr) ';'
    ;

print
    : 'print' (STRING | ID) ';'         // 'print' é um token implícito
    ;

readCommand
    : READ ID ';'
    ;


// Expression Rules
expr
    : term ( (ADD | SUB) term )*
    ;
    
term
    : factor ( (MUL | DIV) factor )*
    ;

factor
    : ID
    | INT
    | FLOAT
    | '(' expr ')'
    ;



// Lexer Rules
READ    : 'read' ;
ADD     : '+' ;
SUB     : '-' ;
MUL     : '*' ;
DIV     : '/' ;
FLOAT   : [0-9]+'.'[0-9]+ ;
INT     : [0-9]+ ;
ID      : [a-zA-Z][a-zA-Z_0-9]* ;
STRING  : '"' ~["]* '"' ;
WS      : [ \t\r\n]+ -> skip ;
