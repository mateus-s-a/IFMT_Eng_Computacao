grammar LanguageCode;


program
    : statement+
    ;

statement
    : assignment
    | print
    ;
    
assignment
    : ID '=' (INT | STRING) ';'
    ;

expr
    : term ( (ADD | SUB) term )*
    ;
    
term
    : factor ( (MUL | DIV) factor )*
    ;

factor
    : ID
    | INT
    ;

print
    : 'print' (STRING | ID) ';'
    ;



INT     : [0-9]+ ;
ADD : '+' ;
ADD : '+' ;
ADD : '+' ;
ADD : '/' ;
ID      : [a-zA-Z][a-zA-Z0-9]* ;
STRING  : '"' ~["]* '"' ;
WS      : [ \t\r\n]+ -> skip ;
