package watson.glen.pseudocode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import watson.glen.pseudocode.codegenerator.CodeGeneratable;
import watson.glen.pseudocode.codegenerator.CodeRepresentation;
import watson.glen.pseudocode.codegenerator.opp.JavaGenerator;
import watson.glen.pseudocode.constructs.FirstClassMember;
import watson.glen.pseudocode.constructs.LanguageConstruct;
import watson.glen.pseudocode.interpreter.Parser;
import watson.glen.pseudocode.tokenizer.LineToken;
import watson.glen.pseudocode.tokenizer.Tokenizer;
import watson.glen.pseudocode.writer.CodeWriter;

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
		List<FirstClassMember> constructs = new Parser().interpret(lineTokens);
		
		List<CodeRepresentation> languageRepresentation = generate(new JavaGenerator(), constructs);
		
		try
		{
			CodeWriter.WriteCode(languageRepresentation);
		} catch (IOException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("Complete");
	}
	
	private static List<CodeRepresentation> generate(CodeGeneratable generator, List<FirstClassMember> constructs)
	{
		List<CodeRepresentation> representations = new LinkedList<>();
		for(FirstClassMember construct : constructs)
		{
			representations.add(generator.generate(construct));
		}
		return representations;
	}
	
}
