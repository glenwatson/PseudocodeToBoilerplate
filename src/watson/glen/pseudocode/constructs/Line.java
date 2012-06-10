package watson.glen.pseudocode.constructs;

public abstract class Line extends LanguageConstruct
{
	private String value;
	
	public Line()
	{
		super();
		value = "";
	}
	
	public Line(String value)
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
