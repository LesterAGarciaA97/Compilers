package gt.edu.url;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import picocli.CommandLine;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.Callable;

@CommandLine.Command(name="MiSegundaCalculadora", mixinStandardHelpOptions = true, version = "0.0.1", description = "Laboratorio 08")
public class MyParser implements Callable<Integer>{

    @CommandLine.Option(names = {"f", "--file"}, description = "FIle to read", required = false)
    private File file;
    public Integer call() throws Exception{

        if(file != null){
            CharStream fileStream = CharStreams.fromFileName(file.getAbsolutePath());
            analyze(fileStream);
        }else{
            String input = "";
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.print("Ingrese una expresion > ");
                input = scanner.nextLine();
                if (input.equals("exit")){ continue ;};
                analyze(CharStreams.fromString(input + "\n"));
            }while(!input.equals("exit"));
        }
        return 0;
    }
    public static void main( String[] args )
    {
        int exitCode = new CommandLine(new MyParser()).execute(args);
        System.exit(exitCode);
    }
    public Double evalExp(String exp){
        //Implemente su código aca
        //return 0.00;
        CharStream input = CharStreams.fromString(exp);
        return analyze(CharStreams.fromString(exp+ "\n"));
    }
    private Double analyze(CharStream stream){
        ExprLexer lexer = new ExprLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);

        ParseTree tree = parser.prog();
        MyExprVisitor myEV = new MyExprVisitor();
        return myEV.visit(tree);
    }
}