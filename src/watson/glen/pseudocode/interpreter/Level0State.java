package watson.glen.pseudocode.interpreter;

import watson.glen.pseudocode.constructs.ClassConstruct;
import watson.glen.pseudocode.constructs.EnumConstruct;
import watson.glen.pseudocode.constructs.InterfaceConstruct;
import watson.glen.pseudocode.constructs.LanguageConstruct;

public enum Level0State
{
	Class(new ClassConstruct()),
	Interface(new InterfaceConstruct()),
	Enum(new EnumConstruct());
	
	private LanguageConstruct construct;
	Level0State(LanguageConstruct construct)
	{
		this.construct = construct;
	}
	
	public LanguageConstruct getConstruct()
	{
		return construct;
	}
}
