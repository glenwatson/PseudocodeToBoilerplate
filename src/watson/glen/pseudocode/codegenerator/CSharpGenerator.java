package watson.glen.pseudocode.codegenerator;

import watson.glen.pseudocode.constructs.ClassConstruct;
import watson.glen.pseudocode.constructs.EnumConstruct;
import watson.glen.pseudocode.constructs.InstanceVariable;
import watson.glen.pseudocode.constructs.InterfaceConstruct;
import watson.glen.pseudocode.constructs.LanguageConstruct;
import watson.glen.pseudocode.constructs.Method;


public class CSharpGenerator implements CodeGeneratable
{
	
	@Override
	public CodeRepresentation generate(LanguageConstruct construct)
	{
		throw new RuntimeException("Not implemented");
	}

	@Override
	public CodeRepresentation generate(EnumConstruct enumConstruct)
	{
		throw new RuntimeException("Not implemented");
	}

	@Override
	public CodeRepresentation generate(InstanceVariable instanceVariable)
	{
		throw new RuntimeException("Not implemented");
	}

	@Override
	public CodeRepresentation generate(ClassConstruct cClassConstruct)
	{
		throw new RuntimeException("Not implemented");
	}

	@Override
	public CodeRepresentation generate(Method method)
	{
		throw new RuntimeException("Not implemented");
	}

	@Override
	public CodeRepresentation generate(InterfaceConstruct interfaceConstruct)
	{
		throw new RuntimeException("Not implemented");
	}
}
