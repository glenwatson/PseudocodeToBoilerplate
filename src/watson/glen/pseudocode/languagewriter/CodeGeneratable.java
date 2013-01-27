package watson.glen.pseudocode.languagewriter;

import watson.glen.pseudocode.constructs.LanguageConstruct;

public interface CodeGeneratable
{
	public CodeRepresentation generate(LanguageConstruct construct);
}
