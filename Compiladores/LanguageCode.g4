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
    | '(' expr ')'
    ;



// Lexer Rules
READ    : 'read' ;
ADD     : '+' ;
SUB     : '-' ;
MUL     : '*' ;
DIV     : '/' ;
INT     : [0-9]+ ;
ID      : [a-zA-Z][a-zA-Z0-9]* ;
STRING  : '"' ~["]* '"' ;
WS      : [ \t\r\n]+ -> skip ;
