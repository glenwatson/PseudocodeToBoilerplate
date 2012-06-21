package watson.glen.pseudocode.constructs;

import java.util.ArrayList;
import java.util.List;

public class Method extends LanguageConstruct
{
	private MethodSignature methodSignature;
	private List<MethodLine> lines;
	
	public Method(MethodSignature methodSignature, List<MethodLine> lines)
	{
		super();
		this.methodSignature = methodSignature;
		this.lines = lines;
	}
	
	public Method(MethodSignature methodSignature)
	{
		super();
		this.methodSignature = methodSignature;
		this.lines = new ArrayList<MethodLine>();
	}
	
	public MethodSignature getMethodSignature()
	{
		return methodSignature;
	}
	
	public void setMethodSignature(MethodSignature methodSignature)
	{
		this.methodSignature = methodSignature;
	}
	
	public List<MethodLine> getLines()
	{
		return lines;
	}
	
	public void setLines(List<MethodLine> lines)
	{
		this.lines = lines;
	}
	
	
}
