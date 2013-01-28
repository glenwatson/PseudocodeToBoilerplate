package watson.glen.pseudocode.constructs;


public class InstanceVariable extends SecondClassMember
{
	private AccessModifier modifier;
	private VariableDeclaration variable;
	
	public InstanceVariable(AccessModifier modifier, VariableDeclaration variable)
	{
		super(variable.getVariableName());
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

	@Override
	public String toString()
	{
		return modifier.toString() +" "+ variable.toString();
	}
	
	
}
