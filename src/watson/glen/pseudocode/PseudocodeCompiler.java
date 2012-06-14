package watson.glen.pseudocode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import watson.glen.pseudocode.constructs.LanguageConstruct;
import watson.glen.pseudocode.interpreter.Interpreter;
import watson.glen.pseudocode.languagewriter.FileSystemWriter;
import watson.glen.pseudocode.tokenizer.LineToken;
import watson.glen.pseudocode.tokenizer.LineTokenizer;

/**
 * @author glen.watson
 *
 */
public class PseudocodeCompiler
{
	
	private static final String accessModifier = "[\\+\\-#]";
	//private static final String methodModifiers ="(static|final|static final)";
	private static final String generic ="<[a-zA-Z_][a-zA-Z0-9_]*>";
	private static final String type ="([a-zA-Z_][a-zA-Z0-9_]*("+generic+")?)";
	private static final String name = "([a-z_][a-zA-Z0-9_]*)";
	
	private static final String parameter = "("+name+" : "+type+")";
	private static final String parameters = "("+parameter+", )*"+parameter;
	private static final String parameterList = "\\(("+parameters+"|"+parameter+"?)\\)";
	
	private static final String methodSigRegex = accessModifier + " " + name + parameterList + " : " + type; 
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		String fileName = "test.txt";
		FileInputStream inStream = new FileInputStream(fileName);
		Scanner scan = new Scanner(inStream);
		Pattern methodSigPattern = Pattern.compile(methodSigRegex);
		
		while(scan.hasNext())
		{
			String line = scan.nextLine();
				Matcher methodSigMatch = methodSigPattern.matcher(line);
				if(methodSigMatch.find())
					System.out.println(methodSigMatch.group());
				else
					System.out.println("No Match");
		}
		
		/*
		
		List<LineToken> lineTokens = new LinkedList<LineToken>();
		while(scan.hasNext())
		{
			LineToken lineToken = LineTokenizer.Tokenize(scan.nextLine());
			lineTokens.add(lineToken);
		}
		
		List<LanguageConstruct> constructs = Interpreter.interpret(lineTokens);
		
		FileSystemWriter.output(constructs);*/
//		new Scanner(System.in).nextLine();
	}

}
