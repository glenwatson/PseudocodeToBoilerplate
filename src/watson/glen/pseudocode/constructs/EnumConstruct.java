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
		this.values = values;
	}
	
	
}
