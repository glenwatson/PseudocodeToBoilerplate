package watson.glen.pseudocode.constructs;

import java.util.ArrayList;
import java.util.List;

public class EnumConstruct extends FirstClassMember
{
	private List<String> enumNames;

	public EnumConstruct(AccessModifier modifier, String enumName)
	{
		super(modifier, enumName);
		enumNames = new ArrayList<String>();
	}

	public EnumConstruct(AccessModifier modifier, String enumName, List<String> values)
	{
		super(modifier, enumName);
		this.enumNames = values;
	}

	public List<String> getEnumNames()
	{
		return enumNames;
	}

	public void setEnumNames(List<String> names)
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
			sb.append(",\r\n\t");
		}
		sb.deleteCharAt(sb.length()-4);
		
		return sb.toString();
	}
	
	
}
