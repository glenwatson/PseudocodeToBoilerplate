package watson.glen.pseudocode.constructs;

public class InstanceVariable extends SecondClassCitizen
{
	private AccessModifier modifier;
	private VariableDeclaration variable;
	private boolean isStatic;
	private boolean isFinal;
	
	public InstanceVariable(AccessModifier modifier, VariableDeclaration variable, boolean isStatic, boolean isFinal)
	{
		super();
		this.modifier = modifier;
		this.variable = variable;
		this.isStatic = isStatic;
		this.isFinal = isFinal;
	}

	public InstanceVariable(AccessModifier modifier, VariableDeclaration variable)
	{
		this(modifier, variable, false, false);
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
	
	public boolean isStatic()
	{
		return isStatic;
	}

	public void setStatic(boolean isStatic)
	{
		this.isStatic = isStatic;
	}

	public boolean isFinal()
	{
		return isFinal;
	}

	public void setFinal(boolean isFinal)
	{
		this.isFinal = isFinal;
	}

	@Override
	public String getName()
	{
		return variable.getVariableName();
	}
	
}
