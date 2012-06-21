package watson.glen.pseudocode.tokenizer;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineTokenizer
{
	private static String tab = "\\t";
	private static String wordOrName = "[a-zA-Z][\\w\\d]+";
	private static String specialCharacters = "[^\\s]+?";
	private static Pattern tokenizePattern = Pattern.compile(tab+"|"+wordOrName+"|"+specialCharacters);
	
	public static LineToken Tokenize(String line)
	{
		Matcher matcher = tokenizePattern.matcher(line);
		
		List<Token> tokens = new LinkedList<Token>();
		
		while(matcher.find())
		{
			Token token = new Token(matcher.group());
			tokens.add(token);
		}
		
		LineToken lineToken = new LineToken();
		lineToken.setTokens(tokens);
		return lineToken;
	}
}
