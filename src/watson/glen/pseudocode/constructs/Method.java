package watson.glen.pseudocode.constructs;

import java.util.ArrayList;
import java.util.List;

public class Method extends LanguageConstruct
{
	private MethodSignature methodSignature;
	private List<Line> lines;
	
	public Method(MethodSignature methodSignature, List<Line> lines)
	{
		super();
		this.methodSignature = methodSignature;
		this.lines = lines;
	}
	
	public Method(MethodSignature methodSignature)
	{
		super();
		this.methodSignature = methodSignature;
		this.lines = new ArrayList<Line>();
	}
	
	public MethodSignature getMethodSignature()
	{
		return methodSignature;
	}
	
	public void setMethodSignature(MethodSignature methodSignature)
	{
		this.methodSignature = methodSignature;
	}
	
	public List<Line> getLines()
	{
		return lines;
	}
	
	public void setLines(List<Line> lines)
	{
		this.lines = lines;
	}
	
	
}
