package watson.glen.pseudocode.tokenizer;

public class Token
{
	private String value;

	public Token(String value)
	{
		super();
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}
	
	@Override
	public String toString()
	{
		return value;
	}
}
