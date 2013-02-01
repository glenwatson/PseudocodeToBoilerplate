package watson.glen.pseudocode.codegenerator;

import watson.glen.pseudocode.constructs.LanguageConstruct;

public interface CodeGeneratable
{
	public CodeRepresentation generate(LanguageConstruct construct);
}
