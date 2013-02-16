package watson.glen.pseudocode.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import watson.glen.pseudocode.codegenerator.CodeRepresentation;

public class CodeWriter
{
	public static void WriteCode(File directory, List<CodeRepresentation> codeFiles) throws IOException
	{
		//assert !directory.isDirectory() : directory.getPath() +" is not a directory";
		for(CodeRepresentation code : codeFiles)
			WriteCode(directory, code);
	}
	public static void WriteCode(File directory, CodeRepresentation code) throws IOException
	{
		System.out.println("Writing to "+code.getFilePath());
		File f = new File(directory.getPath(), code.getFilePath());
		
		FileWriter fw = new FileWriter(f);
		
		fw.write(code.getRepresentation());
		fw.close();
	}
}
