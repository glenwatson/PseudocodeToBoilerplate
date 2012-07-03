package watson.glen.pseudocode.constructs;

import java.util.ArrayList;
import java.util.List;

public class ClassConstruct extends LanguageConstruct
{
	private AccessModifier modifier;
	private String className;
	private String inheritance;
	private List<String> implementations;
	private List<InstanceVariable> instanceVariables;
	private List<Method> methods;
	
	public ClassConstruct()
	{
		this.modifier = AccessModifier.publicModifier;
		this.implementations = new ArrayList<String>();
		this.methods = new ArrayList<>();
	}
	
	public ClassConstruct(AccessModifier modifier, String className, String inheritance, List<String> implementations,
			List<InstanceVariable> instanceVariables, List<Method> methods)
	{
		super();
		this.modifier = modifier;
		this.className = className;
		this.inheritance = inheritance;
		this.implementations = implementations;
		this.instanceVariables = instanceVariables;
		this.methods = methods;
	}
	public ClassConstruct(AccessModifier modifier, String className, List<String> implementations, List<InstanceVariable> instanceVariables,
			List<Method> methods)
	{
		super();
		this.modifier = modifier;
		this.className = className;
		this.implementations = implementations;
		this.instanceVariables = instanceVariables;
		this.methods = methods;
	}
	public ClassConstruct(AccessModifier modifier, String className, String inheritance, List<InstanceVariable> instanceVariables, List<Method> methods)
	{
		super();
		this.modifier = modifier;
		this.className = className;
		this.inheritance = inheritance;
		this.implementations = new ArrayList<String>();
		this.instanceVariables = instanceVariables;
		this.methods = methods;
	}
	public ClassConstruct(AccessModifier modifier, String className, String inheritance, List<Method> methods)
	{
		super();
		this.modifier = modifier;
		this.className = className;
		this.implementations = new ArrayList<String>();
		this.inheritance = inheritance;
		this.methods = methods;
	}

	public ClassConstruct(String className)
	{
		super();
		this.className = className;
		this.modifier = AccessModifier.publicModifier;
		this.implementations = new ArrayList<String>();
		this.methods = new ArrayList<>();
	}
	public AccessModifier getModifier()
	{
		return modifier;
	}

	public void setModifier(AccessModifier modifier)
	{
		this.modifier = modifier;
	}

	public String getClassName()
	{
		return className;
	}

	public void setClassName(String className)
	{
		this.className = className;
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
	
}
