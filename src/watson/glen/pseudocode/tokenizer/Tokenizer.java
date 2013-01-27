/**
 * Performs the work of a lexical analyzer
 * Jan 27, 2013
 */
package watson.glen.pseudocode.tokenizer;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author glen.watson
 *
 */
public class Tokenizer
{
	private static String tab = "\\t";
	private static String wordOrName = "[a-zA-Z][\\w\\d]+";
	private static String comments = "//|/\\*|\\*/";
	private static String specialCharacters = "[^\\s]+?";
	private static Pattern tokenizePattern = Pattern.compile(tab+"|"+comments+"|"+wordOrName+"|"+specialCharacters);
	
	/**
	 * Parses the stream into tokens
	 * @param inStream the data to tokenize
	 * @return this entire stream as tokens, listed by line
	 */
	public static List<LineToken> tokenize(InputStream inStream)
	{
		List<LineToken> lineTokens = new LinkedList<LineToken>();
		try(Scanner scan = new Scanner(inStream))
		{
			while(scan.hasNext())
			{
				String line = scan.nextLine();
				System.out.println("read line: "+line);
				LineToken lineToken = Tokenizer.tokenizeLine(line);
				lineTokens.add(lineToken);
			}
		}
		return lineTokens;
	}

	private static LineToken tokenizeLine(String line)
	{
		Matcher matcher = tokenizePattern.matcher(line);
		
		List<Token> tokens = new LinkedList<Token>();
		boolean lineComment = false;
		
		while(matcher.find() && !lineComment)
		{
			String group = matcher.group();
			if(group.equals("//"))
			{
				group = line.substring(matcher.start());
				lineComment = true;
			}
			Token token = new Token(group);
			tokens.add(token);
		}
		
		LineToken lineToken = new LineToken();
		lineToken.setTokens(tokens);
		return lineToken;
	}
}
