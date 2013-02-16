package watson.glen.pseudocode.constructs;

import java.util.ArrayList;
import java.util.List;

import watson.glen.pseudocode.codegenerator.CodeGeneratable;
import watson.glen.pseudocode.codegenerator.CodeRepresentation;

public class ClassConstruct extends FirstClassCitizen
{
	private Type inheritance;
	private List<Type> implementations;
	private List<InstanceVariable> instanceVariables;
	private List<Method> methods;
	
	public ClassConstruct(AccessModifier modifier, String className, Type inheritance, List<Type> implementations,
			List<InstanceVariable> instanceVariables, List<Method> methods)
	{
		super(modifier, className);
		this.inheritance = inheritance;
		this.implementations = implementations;
		this.instanceVariables = instanceVariables;
		this.methods = methods;
	}
	public ClassConstruct(AccessModifier modifier, String className, List<Type> implementations, List<InstanceVariable> instanceVariables,
			List<Method> methods)
	{
		this(modifier, className, null, implementations, instanceVariables, methods);
	}
	public ClassConstruct(AccessModifier modifier, String className, Type inheritance, List<InstanceVariable> instanceVariables, List<Method> methods)
	{
		this(modifier, className, new ArrayList<Type>(), instanceVariables, methods);
	}
	public ClassConstruct(AccessModifier modifier, String className, Type inheritance, List<Method> methods)
	{
		this(modifier, className, inheritance, new ArrayList<InstanceVariable>(), methods);
	}
	public ClassConstruct(AccessModifier modifier, String className)
	{
		this(modifier, className, null, new ArrayList<Method>());
	}

	public Type getInheritance()
	{
		return inheritance;
	}

	public void setInheritance(Type inheritance)
	{
		this.inheritance = inheritance;
	}

	public List<Type> getImplementations()
	{
		return implementations;
	}

	public void setImplementations(List<Type> implementations)
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
		if(implementations.size() > 0)
		{
			sb.append(" implements ");
			for(Type implementation : implementations)
			{
				sb.append(implementation.getName());
				sb.append(", ");
			}
			sb.delete(sb.length()-2, sb.length());
		}
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
		sb.append("}\r\n");
		
		return sb.toString();
	}
	@Override
	public CodeRepresentation generateUsing(CodeGeneratable generatable)
	{
		return generatable.generate(this);
	}
}
