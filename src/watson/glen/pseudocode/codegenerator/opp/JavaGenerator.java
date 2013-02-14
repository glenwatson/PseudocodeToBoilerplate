package watson.glen.pseudocode.codegenerator.opp;

import watson.glen.pseudocode.codegenerator.CodeRepresentation;
import watson.glen.pseudocode.constructs.AccessModifier;
import watson.glen.pseudocode.constructs.ClassConstruct;
import watson.glen.pseudocode.constructs.EnumConstruct;
import watson.glen.pseudocode.constructs.FirstClassMember;
import watson.glen.pseudocode.constructs.InstanceVariable;
import watson.glen.pseudocode.constructs.InterfaceConstruct;
import watson.glen.pseudocode.constructs.Method;


public class JavaGenerator implements OOPCodeGeneratable
{
	
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
	
	private String generate(AccessModifier accessModifier)
	{
		String representation = null;
		switch(accessModifier)
		{
			case publicModifier:
				representation = "public ";
			case privateModifier:
				representation = "private ";
			case protectedModifier:
				representation = "protected ";
			case defaultModifier:
				representation = "";
		}
		return representation;
	}
}
