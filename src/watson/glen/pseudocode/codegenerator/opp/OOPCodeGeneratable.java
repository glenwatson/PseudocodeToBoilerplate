package watson.glen.pseudocode.codegenerator.opp;

import watson.glen.pseudocode.codegenerator.CodeGeneratable;
import watson.glen.pseudocode.codegenerator.CodeRepresentation;
import watson.glen.pseudocode.constructs.InstanceVariable;
import watson.glen.pseudocode.constructs.Method;

public interface OOPCodeGeneratable extends CodeGeneratable
{
	public CodeRepresentation generate(InstanceVariable instanceVar);
	public CodeRepresentation generate(Method method);
}
