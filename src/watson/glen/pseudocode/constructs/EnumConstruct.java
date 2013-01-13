package watson.glen.pseudocode.constructs;

import java.util.ArrayList;
import java.util.List;

public class EnumConstruct extends FirstClassMember
{
	private List<String> values;

	public EnumConstruct(String enumName)
	{
		super(enumName);
		values = new ArrayList<String>();
	}

	public EnumConstruct(String enumName, List<String> values)
	{
		super(enumName);
		this.values = values;
	}

	public List<String> getValues()
	{
		return values;
	}

	public void setValues(List<String> values)
	{
		this.enumNames = names;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(modifier);
		sb.append(" enum ");
		sb.append(name);
		sb.append("\r\n{\r\n\t");
		for(String enumName : enumNames)
		{
			sb.append(enumName);
			sb.append(",\r\n");
		}
		sb.deleteCharAt(sb.length()-1);
		
		return sb.toString();
	}
	
	
}
