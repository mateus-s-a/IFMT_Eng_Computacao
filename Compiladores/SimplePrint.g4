grammar SimplePrint;

start:
    'print' STRING ';'
    ;

STRING : '"' ~["]* '"' ; 
WS : [ \t\r\n]+ -> skip ;