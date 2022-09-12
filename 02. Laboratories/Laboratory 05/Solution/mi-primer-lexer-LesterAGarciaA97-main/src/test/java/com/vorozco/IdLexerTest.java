package com.vorozco;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class IdLexerTest {

    @Test
    public void matchId() throws IOException {
        Reader targetReader = new StringReader("abc");
        IdLexer lexer = new IdLexer(targetReader);
        Token token = lexer.yylex();
        assertEquals(TokenConstants.ID, token.getTokenType());
    }

    @Test
    public void matchNum() throws IOException {
        Reader targetReader = new StringReader("12345");
        IdLexer lexer = new IdLexer(targetReader);
        Token token = lexer.yylex();
        assertEquals(TokenConstants.NUM, token.getTokenType());
    }

    @Test
    public void matchReal() throws IOException {
        Reader targetReader = new StringReader("12345.3");
        IdLexer lexer = new IdLexer(targetReader);
        Token token = lexer.yylex();
        assertEquals(TokenConstants.REAL, token.getTokenType());
    }

    @Test
    public void matchKeywords() throws IOException {
        Reader targetReader = new StringReader("while");
        IdLexer lexer = new IdLexer(targetReader);
        Token token = lexer.yylex();
        assertEquals(TokenConstants.KEYWORD, token.getTokenType());
    }

    @Test
    public void matchComment() throws IOException {
        Reader targetReader = new StringReader("//comentario sin sentido");
        IdLexer lexer = new IdLexer(targetReader);
        Token token = lexer.yylex();
        assertEquals(TokenConstants.COMMENT, token.getTokenType());
    }

    @Test
    public void matchDomain() throws IOException {
        Reader targetReader = new StringReader("https://www.url.edu.gt");
        IdLexer lexer = new IdLexer(targetReader);
        Token token = lexer.yylex();
        assertEquals(TokenConstants.DOMAIN, token.getTokenType());
    }

    @Test
    public void matchEmail() throws IOException {
        Reader targetReader = new StringReader("info@pikachu.pika.gt");
        IdLexer lexer = new IdLexer(targetReader);
        Token token = lexer.yylex();
        assertEquals(TokenConstants.EMAIL, token.getTokenType());
    }

    @Test
    public void matchPhone() throws IOException {
        Reader targetReader = new StringReader("+502 7873 0000");
        IdLexer lexer = new IdLexer(targetReader);
        Token token = lexer.yylex();
        assertEquals(TokenConstants.PHONE, token.getTokenType());
    }

}
