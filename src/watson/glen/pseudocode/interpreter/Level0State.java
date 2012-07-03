package watson.glen.pseudocode.interpreter;

import watson.glen.pseudocode.constructs.ClassConstruct;
import watson.glen.pseudocode.constructs.EnumConstruct;
import watson.glen.pseudocode.constructs.InterfaceConstruct;
import watson.glen.pseudocode.constructs.LanguageConstruct;

public enum Level0State
{
	Class,
	Interface,
	Enum;
	
	private LanguageConstruct construct;
	
	private Level0State() {}
	
	public LanguageConstruct getConstruct()
	{
		return construct;
	}

	public static Level0State Class(String className)
	{
		Level0State returnValue = Level0State.Class;
		returnValue.construct = new ClassConstruct(className);
		return returnValue;
	}
	
	public static Level0State Interface(String interfaceName)
	{
		Level0State returnValue = Level0State.Interface;
		returnValue.construct = new InterfaceConstruct(interfaceName);
		return returnValue;
	}
	
	public static Level0State Enum(String enumName)
	{
		Level0State returnValue = Level0State.Enum;
		returnValue.construct = new EnumConstruct(enumName);
		return returnValue;
	}
}
