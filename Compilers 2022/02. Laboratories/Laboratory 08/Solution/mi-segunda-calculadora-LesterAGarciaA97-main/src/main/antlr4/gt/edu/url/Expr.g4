//Incializar
grammar Expr;

//Gramatica
//Codigo inicial como comentario
    //prog:   WS+ ;
    //WS  :   [ \t]+ -> skip ; // toss out whitespace
prog: stat+ ;
stat: expr NEWLINE                  # printExpr
    | ID '=' expr NEWLINE           # assign
    | NEWLINE                       # blank
    ;

//Creacion de la regla expr...
expr: ACUMU expr                    # Acumu
    | expr ('**') expr              # Pot
    | expr op=('*'|'/') expr        # MultDiv
    | expr op=('+'|'-'|'%') expr    # AddSubMod
    | DOUBLE                        # double
    | INT                           # int
    | ID                            # id
    | '(' expr ')'                  # parens
    ;

//Lexemas
MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
ACUMU: '++';
POT: '**';
MOD: '%';
ID: [a-zA-Z]+;
DOUBLE: [0-9.]+;
INT: [0-9]+;
NEWLINE: '\r'?'\n';
WS: [ \t]+ -> skip;