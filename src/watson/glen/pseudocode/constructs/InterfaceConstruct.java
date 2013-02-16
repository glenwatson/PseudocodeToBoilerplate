package watson.glen.pseudocode.constructs;

import java.util.ArrayList;
import java.util.List;

import watson.glen.pseudocode.codegenerator.CodeGeneratable;
import watson.glen.pseudocode.codegenerator.CodeRepresentation;

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
	public CodeRepresentation generateUsing(CodeGeneratable generatable)
	{
		return generatable.generate(this);
	}
}
