package watson.glen.pseudocode.constructs;

import java.util.ArrayList;
import java.util.List;

public class ClassConstruct extends FirstClassMember
{
	private String inheritance;
	private List<String> implementations;
	private List<InstanceVariable> instanceVariables;
	private List<Method> methods;
	
	public ClassConstruct(AccessModifier modifier, String className, String inheritance, List<String> implementations,
			List<InstanceVariable> instanceVariables, List<Method> methods)
	{
		super(modifier, className);
		this.inheritance = inheritance;
		this.implementations = implementations;
		this.instanceVariables = instanceVariables;
		this.methods = methods;
	}
	public ClassConstruct(AccessModifier modifier, String className, List<String> implementations, List<InstanceVariable> instanceVariables,
			List<Method> methods)
	{
		this(modifier, className, null, implementations, instanceVariables, methods);
	}
	public ClassConstruct(AccessModifier modifier, String className, String inheritance, List<InstanceVariable> instanceVariables, List<Method> methods)
	{
		this(modifier, className, new ArrayList<String>(), instanceVariables, methods);
	}
	public ClassConstruct(AccessModifier modifier, String className, String inheritance, List<Method> methods)
	{
		this(modifier, className, inheritance, new ArrayList<InstanceVariable>(), methods);
	}
	public ClassConstruct(AccessModifier modifier, String className)
	{
		this(modifier, className, null, new ArrayList<Method>());
	}

	public String getInheritance()
	{
		return inheritance;
	}

	public void setInheritance(String inheritance)
	{
		this.inheritance = inheritance;
	}

	public List<String> getImplementations()
	{
		return implementations;
	}

	public void setImplementations(List<String> implementations)
	{
		this.implementations = implementations;
	}

	public List<InstanceVariable> getInstanceVariables()
	{
		return instanceVariables;
	}

	public void setInstanceVariables(List<InstanceVariable> instanceVariables)
	{
		this.instanceVariables = instanceVariables;
	}

	public List<Method> getMethods()
	{
		return methods;
	}

	public void setMethods(List<Method> methods)
	{
		this.methods = methods;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(modifier);
		sb.append("class ");
		sb.append(name);
		if(inheritance != null)
		{
			sb.append(" extends ");
			sb.append(inheritance);
		}
		sb.append(" ");
		for(String implementation : implementations)
		{
			sb.append(implementation);
			sb.append(", ");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("\r\n{\r\n");
		
		for(InstanceVariable instanceVariable : instanceVariables)
		{
			sb.append(instanceVariable);
			sb.append("\r\n");
		}
		sb.append("\r\n");
		
		for(Method method : methods)
		{
			sb.append(method);
			sb.append("\r\n");
		}
		sb.append("}");
		
		return sb.toString();
	}
}
