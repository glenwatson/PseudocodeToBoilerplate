package watson.glen.pseudocode.constructs;


public class InstanceVariable
{
	private AccessModifier modifier;
	private VariableDeclaration variable;
	
	public InstanceVariable(AccessModifier modifier, VariableDeclaration variable)
	{
		super();
		this.modifier = modifier;
		this.variable = variable;
	}
	
	public AccessModifier getModifier()
	{
		return modifier;
	}
	
	public void setModifier(AccessModifier modifier)
	{
		this.modifier = modifier;
	}
	
	public VariableDeclaration getVariable()
	{
		return variable;
	}
	
	public void setVariable(VariableDeclaration variable)
	{
		this.variable = variable;
	}
	
	
}
