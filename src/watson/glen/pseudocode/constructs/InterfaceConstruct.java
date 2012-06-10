package watson.glen.pseudocode.constructs;

import java.util.ArrayList;
import java.util.List;

public class InterfaceConstruct extends LanguageConstruct
{
	private List<MethodSignature> methodSignatures;

	public InterfaceConstruct()
	{
		super();
		this.methodSignatures = new ArrayList<MethodSignature>();
	}

	public InterfaceConstruct(List<MethodSignature> methodSignatures)
	{
		super();
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
