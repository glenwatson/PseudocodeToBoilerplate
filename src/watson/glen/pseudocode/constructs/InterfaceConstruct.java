package watson.glen.pseudocode.constructs;

import java.util.ArrayList;
import java.util.List;

public class InterfaceConstruct extends FirstClassCitizen
{
	private List<MethodSignature> methodSignatures;
	private List<Type> inheritances;
	
	public InterfaceConstruct(AccessModifier modifier, String name, List<MethodSignature> methodSignatures, List<Type> inheritances)
	{
		super(modifier, name);
		this.methodSignatures = methodSignatures;
		this.inheritances = inheritances;
	}
	
	public InterfaceConstruct(AccessModifier modifier, String interfaceName, List<MethodSignature> methodSignatures)
	{
		this(modifier, interfaceName, methodSignatures, new ArrayList<Type>());
	}
	
	public InterfaceConstruct(AccessModifier modifier, String interfaceName)
	{
		this(modifier, interfaceName, new ArrayList<MethodSignature>());
	}
	
	public List<MethodSignature> getMethodSignatures()
	{
		return methodSignatures;
	}
	
	public void setMethodSignatures(List<MethodSignature> methodSignatures)
	{
		this.methodSignatures = methodSignatures;
	}
	
	public List<Type> getInheritances()
	{
		return inheritances;
	}
	
	public void setInheritances(List<Type> inheritances)
	{
		this.inheritances = inheritances;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(modifier);
		sb.append("interface ");
		sb.append(name);
		if (inheritances.size() > 0)
		{
			sb.append(" extends ");
			for (Type implementation : inheritances)
			{
				sb.append(implementation.getName());
				sb.append(", ");
			}
			sb.delete(sb.length() - 2, sb.length());
		}
		sb.append("\r\n{\r\n");
		
		if (methodSignatures.size() > 0)
			for (MethodSignature signature : methodSignatures)
			{
				sb.append(signature);
				sb.append("\r\n");
			}
		else
			sb.append("\r\n");
		
		sb.append("}\r\n");
		return sb.toString();
	}
}
