// Binôme :
// Hellin Alexandre
// Di Giovanni Thomas

import org.antlr.v4.runtime.*;
import java.io.IOException;

public class PPTest {
    public static void main(String[] args) throws IOException{
	CharStream stream;
	if (args.length != 0)
	    stream = CharStreams.fromString(args[0]);
	else
	    stream = CharStreams.fromFileName("../TestProgram.txt");
	
        PPLexer lexer = new PPLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PPParser parser = new PPParser(tokens);
        Program program = parser.prog().value;
        System.out.println(program);
    }
}
