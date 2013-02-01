package watson.glen.pseudocode.codegenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CodeWriter
{
	public static void WriteCode(List<CodeRepresentation> codeFiles) throws IOException
	{
		for(CodeRepresentation code : codeFiles)
			WriteCode(code);
	}
	public static void WriteCode(CodeRepresentation code) throws IOException
	{
		File f = new File(code.getFilePath());
		
		FileWriter fw = new FileWriter(f, true);
		
		fw.write(code.getRepresentation());
		fw.close();
	}
}
