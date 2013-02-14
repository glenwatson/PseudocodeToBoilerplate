package watson.glen.pseudocode.codegenerator.opp;

import watson.glen.pseudocode.codegenerator.CodeRepresentation;
import watson.glen.pseudocode.constructs.ClassConstruct;
import watson.glen.pseudocode.constructs.EnumConstruct;
import watson.glen.pseudocode.constructs.FirstClassCitizen;
import watson.glen.pseudocode.constructs.InstanceVariable;
import watson.glen.pseudocode.constructs.InterfaceConstruct;
import watson.glen.pseudocode.constructs.Method;


public class CSharpGenerator implements OOPCodeGeneratable
{

	@Override
	public CodeRepresentation generate(FirstClassCitizen firstClassConstruct)
	{
		throw new RuntimeException("Not implemented");
	}

	@Override
	public CodeRepresentation generate(EnumConstruct enumConstruct)
	{
		throw new RuntimeException("Not implemented");
	}

	@Override
	public CodeRepresentation generate(ClassConstruct classConstruct)
	{
		throw new RuntimeException("Not implemented");
	}

	@Override
	public CodeRepresentation generate(InterfaceConstruct interfaceConstruct)
	{
		throw new RuntimeException("Not implemented");
	}

	@Override
	public CodeRepresentation generate(InstanceVariable instanceVar)
	{
		throw new RuntimeException("Not implemented");
	}

	@Override
	public CodeRepresentation generate(Method method)
	{
		throw new RuntimeException("Not implemented");
	}
}
