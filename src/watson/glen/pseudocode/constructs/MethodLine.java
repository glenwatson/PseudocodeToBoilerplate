package watson.glen.pseudocode.constructs;

public abstract class MethodLine
{
	private String value;
	
	public MethodLine()
	{
		super();
		value = "";
	}
	
	public MethodLine(String value)
	{
		super();
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}
	
	
}
