package gt.edu.url;
import java_cup.runtime.*;

%%
%public
%class MyLexer
%cup
digit = [0-9]
letter = [a-zA-Z]
whitespace = [ \t\n]

%{
    StringBuffer strig = new StringBuffer();

    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

%eofval{
    return symbol(MyParserSym.EOF);
%eofval}


%%

{digit}+ {return symbol(MyParserSym.NUMBER, Double.valueOf(yytext())); }
"(" { return symbol(MyParserSym.LPAREN, yytext()); }
")" { return symbol(MyParserSym.RPAREN, yytext()); }
"+" { return symbol(MyParserSym.PLUS, yytext()); }
"-" { return symbol(MyParserSym.MINUS, yytext()); }
"*" { return symbol(MyParserSym.TIMES, yytext()); }
"/" { return symbol(MyParserSym.DIVISION, yytext()); }
"%" { return symbol(MyParserSym.MOD, yytext()); }
"++" { return symbol(MyParserSym.ACCUM, yytext()); }

{whitespace}+ { /*SKIP WHITESPACES */ }
[^]                             { throw new Error("Cadena ilegal <"+
                                                        yytext()+">"); }