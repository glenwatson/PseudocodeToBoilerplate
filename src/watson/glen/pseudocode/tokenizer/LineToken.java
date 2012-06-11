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
	
	
	
}
