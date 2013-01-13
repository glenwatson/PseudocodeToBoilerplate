package watson.glen.pseudocode.constructs;

import java.util.ArrayList;
import java.util.List;

public class InterfaceConstruct extends FirstClassMember
{
	private List<MethodSignature> methodSignatures;

	public InterfaceConstruct(AccessModifier modifier, String interfaceName)
	{
		super(modifier, interfaceName);
		this.methodSignatures = new ArrayList<MethodSignature>();
	}

	public InterfaceConstruct(AccessModifier modifier, String interfaceName, List<MethodSignature> methodSignatures)
	{
		super(modifier, interfaceName);
		this.methodSignatures = methodSignatures;
	}

	public List<MethodSignature> getMethodSignatures()
	{
		return methodSignatures;
	}

	public void setMethodSignatures(List<MethodSignature> methodSignatures)
	{
		this.methodSignatures = methodSignatures;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(modifier);
		sb.append(" interface ");
		sb.append(name);
		sb.append("\r\n");
		
		return sb.toString();
	}
	
}
