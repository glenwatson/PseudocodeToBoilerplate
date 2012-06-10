package watson.glen.pseudocode.constructs;

import java.util.ArrayList;
import java.util.List;

public class EnumConstruct extends LanguageConstruct
{
	private List<String> values;

	public EnumConstruct()
	{
		super();
		values = new ArrayList<String>();
	}

	public EnumConstruct(List<String> values)
	{
		super();
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
