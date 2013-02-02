package watson.glen.pseudocode.codegenerator;

import watson.glen.pseudocode.constructs.AccessModifier;
import watson.glen.pseudocode.constructs.ClassConstruct;
import watson.glen.pseudocode.constructs.EnumConstruct;
import watson.glen.pseudocode.constructs.InstanceVariable;
import watson.glen.pseudocode.constructs.InterfaceConstruct;
import watson.glen.pseudocode.constructs.Method;
import watson.glen.pseudocode.constructs.MethodLine;
import watson.glen.pseudocode.constructs.MethodSignature;
import watson.glen.pseudocode.constructs.Type;
import watson.glen.pseudocode.constructs.VariableDeclaration;


public class JavaGenerator implements CodeGeneratable
{

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

	@Override
	public CodeRepresentation generate(VariableDeclaration variableDeclaration)
	{
		throw new RuntimeException("Not implemented");
	}

	@Override
	public CodeRepresentation generate(Type type)
	{
		throw new RuntimeException("Not implemented");
	}

	@Override
	public CodeRepresentation generate(AccessModifier accessModifier)
	{
		throw new RuntimeException("Not implemented");
	}

	@Override
	public CodeRepresentation generate(MethodLine methodLine)
	{
		throw new RuntimeException("Not implemented");
	}

	@Override
	public CodeRepresentation generate(MethodSignature methodSignature)
	{
		throw new RuntimeException("Not implemented");
	}
	
}
