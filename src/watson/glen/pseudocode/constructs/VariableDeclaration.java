package watson.glen.pseudocode.constructs;

public class VariableDeclaration
{
	private Type type;
	private String variableName;
	private String initalValue;
	
	public VariableDeclaration(Type type, String variableName)
	{
		super();
		this.type = type;
		this.variableName = variableName;
	}
	
	public VariableDeclaration(Type type, String variableName, String initalValue)
	{
		this(type, variableName);
		this.initalValue = initalValue;
	}

	public Type getType()
	{
		return type;
	}
	
	public void setType(Type type)
	{
		this.type = type;
	}
	
	public String getVariableName()
	{
		return variableName;
	}
	
	public void setVariableName(String variableName)
	{
		this.variableName = variableName;
	}
	
	public String getInitalValue()
	{
		return initalValue;
	}

	public void setInitalValue(String initalValue)
	{
		this.initalValue = initalValue;
	}

}
