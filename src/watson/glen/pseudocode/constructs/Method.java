package watson.glen.pseudocode.constructs;

import java.util.LinkedList;
import java.util.List;

public class Method extends SecondClassMember
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
		this.lines = new LinkedList<MethodLine>();
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
	
	@Override
	public String getName()
	{
		return methodSignature.getMethodName();
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(methodSignature);
		sb.append("\r\n\t{\r\n");
		for (MethodLine methodLine : lines)
		{
			sb.append(methodLine);
			sb.append("\r\n");
		}
		sb.append("\t}\r\n");
		return sb.toString();
	}
}
