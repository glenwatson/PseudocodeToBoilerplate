package watson.glen.pseudocode.constructs;

import java.util.LinkedList;
import java.util.List;

public class MethodSignature
{
	private AccessModifier modifier;
	private boolean isStatic;
	private Type returnType;
	private String methodName;
	private List<VariableDeclaration> parameters;
	
	public MethodSignature(AccessModifier modifier, boolean isStatic, Type returnType, String methodName, List<VariableDeclaration> parameters)
	{
		super();
		this.modifier = modifier;
		this.isStatic = isStatic;
		this.returnType = returnType;
		this.methodName = methodName;
		this.parameters = parameters;
	}
	
	public MethodSignature(AccessModifier modifier, boolean isStatic, Type returnType, String methodName)
	{
		this(modifier, isStatic, returnType, methodName, new LinkedList<VariableDeclaration>());
	}
	
	public AccessModifier getModifier()
	{
		return modifier;
	}
	
	public void setModifier(AccessModifier modifier)
	{
		this.modifier = modifier;
	}
	
	public boolean isStatic()
	{
		return isStatic;
	}
	
	public void setStatic(boolean isStatic)
	{
		this.isStatic = isStatic;
	}
	
	public Type getReturnType()
	{
		return returnType;
	}
	
	public void setReturnType(Type returnType)
	{
		this.returnType = returnType;
	}
	
	public String getMethodName()
	{
		return methodName;
	}
	
	public void setMethodName(String methodName)
	{
		this.methodName = methodName;
	}
	
	public List<VariableDeclaration> getParameters()
	{
		return parameters;
	}
	
	public void setParameters(List<VariableDeclaration> parameters)
	{
		this.parameters = parameters;
	}
	
}
