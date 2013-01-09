package watson.glen.pseudocode.constructs;

import java.util.ArrayList;
import java.util.List;

public class InterfaceConstruct extends FirstClassMember
{
	private List<MethodSignature> methodSignatures;

	public InterfaceConstruct(String interfaceName)
	{
		super(interfaceName);
		this.methodSignatures = new ArrayList<MethodSignature>();
	}

	public InterfaceConstruct(String interfaceName, List<MethodSignature> methodSignatures)
	{
		super(interfaceName);
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
	
}
