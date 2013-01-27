package watson.glen.pseudocode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import watson.glen.pseudocode.constructs.LanguageConstruct;
import watson.glen.pseudocode.interpreter.Interpreter;
import watson.glen.pseudocode.languagewriter.FileSystemWriter;
import watson.glen.pseudocode.tokenizer.LineToken;
import watson.glen.pseudocode.tokenizer.LineTokenizer;
import watson.glen.pseudocode.tokenizer.Tokenizer;

/**
 * @author glen.watson
 *
 */
public class PseudocodeCompiler
{
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		String fileName = "test.txt";
		FileInputStream inStream = new FileInputStream(fileName);
		
		List<LineToken> lineTokens = Tokenizer.tokenize(inStream);
		List<LanguageConstruct> constructs = new Interpreter().interpret(lineTokens);
		
		FileSystemWriter.output(constructs);
//		new Scanner(System.in).nextLine();
	}

}
