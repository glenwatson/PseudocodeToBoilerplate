/**
 * Performs the work of a lexical analyzer
 * Jan 27, 2013
 */
package watson.glen.pseudocode.tokenizer;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/**
 * @author glen.watson
 *
 */
public class Tokenizer
{
	/**
	 * Parses the stream into tokens
	 * @param inStream the data to tokenize
	 * @return this entire stream as tokens, listed by line
	 */
	public static List<LineToken> tokenize(InputStream inStream)
	{
		List<LineToken> lineTokens = new LinkedList<LineToken>();
		try(Scanner scan = new Scanner(inStream))
		{
			while(scan.hasNext())
			{
				String line = scan.nextLine();
				System.out.println("read line: "+line);
				LineToken lineToken = LineTokenizer.tokenize(line);
				lineTokens.add(lineToken);
			}
		}
		return lineTokens;
	}
}
