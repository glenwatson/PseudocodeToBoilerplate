package watson.glen.pseudocode.constructs;

public class VariableDeclaration
{
	private String type;
	private String variableName;
	private String initalValue;
	
	public VariableDeclaration(String type, String variableName)
	{
		super();
		this.type = type;
		this.variableName = variableName;
	}
	
	public VariableDeclaration(String type, String variableName, String initalValue)
	{
		super();
		this.type = type;
		this.variableName = variableName;
		this.initalValue = initalValue;
	}

	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
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

	@Override
	public String toString()
	{
		String result = type + " " + variableName;
		if(initalValue != null)
			result += initalValue;
		return result;
	}
}
