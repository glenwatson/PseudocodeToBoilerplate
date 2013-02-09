package watson.glen.pseudocode.codegenerator;

import watson.glen.pseudocode.constructs.ClassConstruct;
import watson.glen.pseudocode.constructs.EnumConstruct;
import watson.glen.pseudocode.constructs.InstanceVariable;
import watson.glen.pseudocode.constructs.InterfaceConstruct;
import watson.glen.pseudocode.constructs.LanguageConstruct;
import watson.glen.pseudocode.constructs.Method;

public interface CodeGeneratable
{
	public CodeRepresentation generate(LanguageConstruct construct);
	public CodeRepresentation generate(EnumConstruct enumConstruct);
	public CodeRepresentation generate(InstanceVariable instanceVariable);
	public CodeRepresentation generate(ClassConstruct classConstruct);
	public CodeRepresentation generate(Method method);
	public CodeRepresentation generate(InterfaceConstruct interfaceConstruct);
}
