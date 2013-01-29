package watson.glen.pseudocode.constructs;
/**
 * Representation of a First-class citizen
 * @author glen.watson
 *
 */
public abstract class FirstClassMember extends LanguageConstruct
{
	protected AccessModifier modifier;
	protected String name;
	
	public FirstClassMember(AccessModifier modifier, String name)
	{
		super();
		this.modifier = modifier;
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
}
