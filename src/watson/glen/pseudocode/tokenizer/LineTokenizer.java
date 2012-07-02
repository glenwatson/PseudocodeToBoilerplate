package watson.glen.pseudocode.tokenizer;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineTokenizer
{
	private static String tab = "\\t";
	private static String wordOrName = "[a-zA-Z][\\w\\d]+";
	private static String comments = "//|/\\*|\\*/";
	private static String specialCharacters = "[^\\s]+?";
	private static Pattern tokenizePattern = Pattern.compile(tab+"|"+comments+"|"+wordOrName+"|"+specialCharacters);
	
	public static LineToken Tokenize(String line)
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
