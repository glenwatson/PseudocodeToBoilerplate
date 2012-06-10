package watson.glen.pseudocode.tokenizer;

import java.util.ArrayList;
import java.util.List;

public class LineToken
{
	private int tabs;
	private List<Token> tokens;
	
	public LineToken()
	{
		super();
		this.tokens = new ArrayList<Token>();
	}
	public LineToken(int tabs)
	{
		super();
		this.tabs = tabs;
		this.tokens = new ArrayList<Token>();
	}
	public int getTabs()
	{
		return tabs;
	}
	public void setTabs(int tabs)
	{
		this.tabs = tabs;
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
