grammar LanguageCode;


program
    : statement+
    ;

statement
    : assignment
    | print
    | readCommand
    | ifStatement
    | whileStatement
    | doWhileStatement
    ;
    
// Loops Rules
whileStatement
    : WHILE '(' condition ')' '{' statement+ '}'
    ;

doWhileStatement
    : DO '{' statement+ '}'
    WHILE '(' condition ')' ';'
    ;

// Condition If-Else Rule
ifStatement
    : IF '(' condition ')' '{' statement+ '}'
    (ELSE '{' statement+ '}')?      // 'else' é opcional definido com '?'
    ;

condition
    : expr (GT | LT | EQ) expr
    ;


assignment
    : ID '=' (STRING | expr) ';'
    ;


// Others Rules
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



// Lexer (cada um é um Token)
DO      : 'do' ;
WHILE   : 'while' ;
IF      : 'if' ;
ELSE    : 'else' ;
READ    : 'read' ;

GT      : '>' ;
LT      : '<' ;
EQ      : '==' ;

ADD     : '+' ;
SUB     : '-' ;
MUL     : '*' ;
DIV     : '/' ;

LPAREN  : '(';
RPAREN  : ')';
LBRACE  : '{';
RBRACE  : '}';
SEMI    : ';';

INT     : [0-9]+ ;
FLOAT   : [0-9]+ '.' [0-9]+ ;
STRING  : '"' ~["]* '"' ;

ID      : [a-zA-Z][a-zA-Z_0-9]* ;
WS      : [ \t\r\n]+ -> skip ;