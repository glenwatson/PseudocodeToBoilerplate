package watson.glen.pseudocode.codegenerator.opp;

import watson.glen.pseudocode.codegenerator.CodeGeneratable;
import watson.glen.pseudocode.codegenerator.CodeRepresentation;
import watson.glen.pseudocode.constructs.ClassConstruct;
import watson.glen.pseudocode.constructs.EnumConstruct;
import watson.glen.pseudocode.constructs.FirstClassMember;
import watson.glen.pseudocode.constructs.InterfaceConstruct;

public class OOPCodeGenerator implements CodeGeneratable
{
	private OOPCodeGeneratable oppGenerator;
	
	public OOPCodeGenerator(OOPCodeGeneratable generator)
	{
		oppGenerator = generator; 
	}
	
	@Override
	public CodeRepresentation generate(FirstClassMember firstClassConstruct)
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
	
}
