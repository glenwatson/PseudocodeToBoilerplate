package watson.glen.pseudocode.codegenerator;

import watson.glen.pseudocode.constructs.ClassConstruct;
import watson.glen.pseudocode.constructs.EnumConstruct;
import watson.glen.pseudocode.constructs.InterfaceConstruct;

public interface CodeGeneratable
{
	public CodeRepresentation generate(EnumConstruct enumConstruct);
	public CodeRepresentation generate(ClassConstruct classConstruct);
	public CodeRepresentation generate(InterfaceConstruct interfaceConstruct);
}
