package watson.glen.pseudocode.codegenerator;

import watson.glen.pseudocode.constructs.AccessModifier;
import watson.glen.pseudocode.constructs.ClassConstruct;
import watson.glen.pseudocode.constructs.EnumConstruct;
import watson.glen.pseudocode.constructs.InstanceVariable;
import watson.glen.pseudocode.constructs.InterfaceConstruct;
import watson.glen.pseudocode.constructs.LanguageConstruct;
import watson.glen.pseudocode.constructs.Method;
import watson.glen.pseudocode.constructs.MethodLine;
import watson.glen.pseudocode.constructs.MethodSignature;
import watson.glen.pseudocode.constructs.Type;
import watson.glen.pseudocode.constructs.VariableDeclaration;

public interface CodeGeneratable
{
	public CodeRepresentation generate(LanguageConstruct construct);
	public CodeRepresentation generate(EnumConstruct enumConstruct);
	public CodeRepresentation generate(InstanceVariable instanceVariable);
	public CodeRepresentation generate(ClassConstruct cClassConstruct);
	public CodeRepresentation generate(Method method);
	public CodeRepresentation generate(InterfaceConstruct interfaceConstruct);
	public CodeRepresentation generate(VariableDeclaration variableDeclaration);
	public CodeRepresentation generate(Type type);
	public CodeRepresentation generate(AccessModifier accessModifier);
	public CodeRepresentation generate(MethodLine methodLine);
	public CodeRepresentation generate(MethodSignature methodSignature);
}
