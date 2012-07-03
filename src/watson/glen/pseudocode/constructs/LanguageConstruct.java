package watson.glen.pseudocode.constructs;

public abstract class LanguageConstruct
{
	protected String name;

	public LanguageConstruct(String name)
	{
		super();
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
}
