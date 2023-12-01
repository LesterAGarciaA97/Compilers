package com.vorozco;

import java.io.*;

%%

%public

%class IdLexer

NUM = [0-9]
KEYWORD = [if||IF||WHILE||while||ELSE||else]
DIAGONAL = [/]
DOBLEDIAGONAL = [//]
LETTER = [a-zA-Z]
WHITESPACE = [ \t\r]
ESPACIODOBLE = {FINLINEA}|[ \t\r]
NEWLINE = [ \n]
PUNTO = ["."]
ARROBA = [@]
DOMINIO = ["https:"||"http:"]
WEB = ["www."]
INICIO = ["+"]
CODIGOAREA = ["502"]
FINALWEB = [".com"]
FINLINEA = [\r|\n|\r\n]
ESPACIOS = [ ]

%type Token

%eofval{

    return new Token(TokenConstants.EOF, null);

%eofval}

%%

//Regular expression for webpages
""https:|http:""{DOBLEDIAGONAL}{WEB}?({LETTER}|{NUM})+{FINALWEB}?{PUNTO}?({LETTER}|{NUM})?{PUNTO}?({LETTER}|{NUM})?{PUNTO}?({LETTER}|{NUM})? {return new Token(TokenConstants.DOMAIN,yytext());}
//{DOMINIO}{DOBLEDIAGONAL}{WEB}?({LETTER}|{NUM})+{FINALWEB}?{PUNTO}?({LETTER}|{NUM})?{PUNTO}?({LETTER}|{NUM})?{PUNTO}?({LETTER}|{NUM})? {return new Token(TokenConstants.DOMAIN,yytext());}
//Regular expression for keywords
if|IF|WHILE|while|ELSE|else {return new Token(TokenConstants.KEYWORD,yytext());}
//Regular expression for ID
{LETTER}({LETTER}|{NUM})* {return new Token(TokenConstants.ID,yytext());}
//Regular expression for numbers
{NUM}* {return new Token(TokenConstants.NUM,yytext());}
//Regular expression for phone numbers
"+"?"502"{WHITESPACE}?{NUM}{NUM}{NUM}{NUM}{WHITESPACE}?{NUM}{NUM}{NUM}{NUM} {return new Token(TokenConstants.PHONE,yytext());}
//Regular expression for simple comment
{DIAGONAL}{DIAGONAL}({LETTER}|{NUM})* {return new Token(TokenConstants.COMMENT,yytext());}
//Regular exression for Real numbers
{NUM}+{PUNTO}{NUM}+ {return new Token(TokenConstants.REAL,yytext());}
//Regular expression for email
{LETTER}+{ARROBA}{LETTER}+{FINALWEB}?{PUNTO}?({LETTER}|{NUM})?{PUNTO}?({LETTER}|{NUM})?{PUNTO}?({LETTER}|{NUM})? {return new Token(TokenConstants.EMAIL,yytext());}
//Regultar expression for spaces
{ESPACIOS} {/*igonre*/}
//Regultar expression for enter
{NEWLINE} {/*igonre*/}
//Regultar expression for whitespaces
{WHITESPACE} {/*igonre*/}
//Regular expression to evaluate Pacman symbol
[":V"] {throw new java.io.IOException("pacman no pasara"+ yytext());}