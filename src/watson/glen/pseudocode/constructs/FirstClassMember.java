package watson.glen.pseudocode.constructs;
/**
 * Representation of a First-class citizen
 * @author glen.watson
 *
 */
public abstract class FirstClassMember extends LanguageConstruct
{
	protected AccessModifier modifier;
	public FirstClassMember(AccessModifier modifier, String name)
	{
		super(name);
		this.modifier = modifier;
	}
}
