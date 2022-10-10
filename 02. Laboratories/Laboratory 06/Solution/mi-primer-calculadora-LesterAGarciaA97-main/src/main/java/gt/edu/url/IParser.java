package gt.edu.url;

import picocli.CommandLine;

import java.io.File;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "iparser", mixinStandardHelpOptions = true, version = "0.0.1",
        description = "Reads and operates arithmetic expressions (plus and times only)")
public class IParser implements Callable<Integer> {

    @CommandLine.Option(names = {"-f","--file"}, description = "File to read", required = false)
    private File file;

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        if(file != null) {
            MyParser parser = new MyParser(new MyLexer(Files.newBufferedReader(file.toPath())));
            System.out.println(parser.parse().value);
        } else {
            Scanner scanner = new Scanner(System.in);
            String input = "";
            while (!input.equals("exit")) {
                System.out.print("Ingrese cadena para analizar > ");
                input = scanner.nextLine();
                if(input.equals("exit")) {
                    break;
                }
                MyLexer lexer = new MyLexer(new StringReader(input));
                MyParser parser = new MyParser(lexer);
                System.out.println(parser.parse().value);
            }
        }
        return 0;
    }

    // this example implements Callable, so parsing, error handling and handling user
    // requests for usage help or version help can be done with one line of code.
    public static void main(String... args) {
        int exitCode = new CommandLine(new IParser()).execute(args);
        System.exit(exitCode);
    }
}
