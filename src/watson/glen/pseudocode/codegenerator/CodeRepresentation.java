package watson.glen.pseudocode.codegenerator;

public class CodeRepresentation
{
	private String filePath;
	private String representation;
	
	public CodeRepresentation(String filePath, String representation)
	{
		super();
		this.filePath = filePath;
		this.representation = representation;
	}
	
	public String getFilePath()
	{
		return filePath;
	}
	
	public String getRepresentation()
	{
		return representation;
	}
}
