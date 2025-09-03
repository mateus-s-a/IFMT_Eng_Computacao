grammar LanguageCode;


program
    : statement+
    ;

statement
    : assignment
    | print
    ;
    
assignment
    : ID '=' INT ';'
    ;

print
    : 'print' (STRING | ID) ';'
    ;


INT     : [0-9]+ ;
ID      : [a-zA-Z][a-zA-Z0-9]* ;
STRING  : '"' ~["]* '"' ;
WS      : [ \t\r\n]+ -> skip ;
