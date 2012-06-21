package watson.glen.pseudocode.tokenizer;

import java.util.ArrayList;
import java.util.List;

public class LineToken
{
	private List<Token> tokens;
	
	public LineToken()
	{
		super();
		this.tokens = new ArrayList<Token>();
	}

	public List<Token> getTokens()
	{
		return tokens;
	}
	
	public void setTokens(List<Token> tokens)
	{
		this.tokens = tokens;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		for(Token token : tokens)
		{
			sb.append(token.getValue());
			sb.append(' ');
		}
		sb.deleteCharAt(sb.length()-1);
		
		return sb.toString();
		
	}
	
}
