package watson.glen.pseudocode.constructs;

public class InstanceVariable extends SecondClassMember
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
	
	@Override
	public String getName()
	{
		return variable.getVariableName();
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\t");
		if(modifier != AccessModifier.defaultModifier)
		{
			sb.append(modifier);
			sb.append(" ");
		}
		sb.append(variable);
		return sb.toString();
	}
	
}
