package watson.glen.pseudocode.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import watson.glen.pseudocode.codegenerator.CodeRepresentation;

public class CodeWriter
{
	public static void WriteCode(List<CodeRepresentation> codeFiles) throws IOException
	{
		for(CodeRepresentation code : codeFiles)
			WriteCode(code);
	}
	public static void WriteCode(CodeRepresentation code) throws IOException
	{
		System.out.println("Writing to "+code.getFilePath());
		File f = new File(code.getFilePath());
		
		FileWriter fw = new FileWriter(f, true);
		
		fw.write(code.getRepresentation());
		fw.close();
	}
}
