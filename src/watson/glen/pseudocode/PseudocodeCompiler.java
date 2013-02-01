package watson.glen.pseudocode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

import watson.glen.pseudocode.constructs.LanguageConstruct;
import watson.glen.pseudocode.interpreter.Parser;
import watson.glen.pseudocode.languagewriter.CodeGeneratable;
import watson.glen.pseudocode.languagewriter.CodeRepresentation;
import watson.glen.pseudocode.tokenizer.LineToken;
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
		String fileName;
		if(args.length >= 1)
		{
			fileName = args[0];
		}
		else
		{
			System.out.println("Please supply a text file to parse");
			fileName = "test.txt";
		}
		FileInputStream inStream = new FileInputStream(fileName);
		
		List<LineToken> lineTokens = Tokenizer.tokenize(inStream);
		List<LanguageConstruct> constructs = new Parser().interpret(lineTokens);
		
		
		dumpConstructs(constructs);
//		new Scanner(System.in).nextLine();
	}
	
	private List<CodeRepresentation> generate(CodeGeneratable generator, List<LanguageConstruct> constructs)
	{
		List<CodeRepresentation> representations = new LinkedList<>();
		for(LanguageConstruct construct : constructs)
		{
			representations.add(generator.generate(construct));
		}
		return representations;
	}
	
	private static void dumpConstructs(List<LanguageConstruct> constructs)
	{
		for(LanguageConstruct construct : constructs)
		{
			System.out.println(construct);			
		}
	}
}
