package com.vorozco;

import picocli.CommandLine;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "Lexer", mixinStandardHelpOptions = true, version = "0.0.1",
description = "Simple lexer that recognizes ID, NUM, REAL, KEYWORD, COMMENT, DOMAIN, EMAIL, PHONE and EOF")
public class App implements Callable<Integer> {
    @CommandLine.Option(names = {"-f","--file"}, description = "File to read", required = false)
    private File file;
    @Override
    public Integer call() throws Exception {
        if(file != null){
            BufferedReader bfr = Files.newBufferedReader(file.toPath());
            IdLexer lexer = new IdLexer(bfr);
            Token token = lexer.yylex();
            while(token.getTokenType() != TokenConstants.EOF){
                //System.out.println(token);
                //token = lexer.yylex();
                try{
                    System.out.println(token);
                    token = lexer.yylex();
                }
                catch(IOException e){
                    System.out.println("pacman no pasara");
                }
            }
        }else{
            Scanner scanner = new Scanner(System.in);
            String input = "";
            while (!input.equals("exit")) {
                System.out.println("Por favor ingrese la cadena a evaluar ");
                input = scanner.nextLine();
                if (input.equals("exit")) {
                    break;
                }else if(input.equals(":")){
                    System.out.println("pacman no pasara");
                }
                IdLexer idLexer = new IdLexer(new StringReader(input));
                Token token = idLexer.yylex();
                System.out.println(token);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}