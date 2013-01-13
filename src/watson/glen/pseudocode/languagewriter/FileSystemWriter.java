package watson.glen.pseudocode.languagewriter;

import java.util.List;

import watson.glen.pseudocode.constructs.LanguageConstruct;

public class FileSystemWriter
{
	public static void output(List<LanguageConstruct> constructs)
	{
		for(LanguageConstruct construct : constructs)
		{
			System.out.println(construct);			
		}
	}
}
