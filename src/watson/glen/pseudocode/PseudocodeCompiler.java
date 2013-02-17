package watson.glen.pseudocode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import watson.glen.pseudocode.codegenerator.CodeGeneratable;
import watson.glen.pseudocode.codegenerator.CodeRepresentation;
import watson.glen.pseudocode.codegenerator.opp.JavaGenerator;
import watson.glen.pseudocode.constructs.FirstClassCitizen;
import watson.glen.pseudocode.interpreter.Parser;
import watson.glen.pseudocode.tokenizer.LineToken;
import watson.glen.pseudocode.tokenizer.Tokenizer;
import watson.glen.pseudocode.writer.CodeWriter;

/**
 * @author glen.watson
 */
public class PseudocodeCompiler
{
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws FileNotFoundException
	{
		//Set up arguments
		Options options = new Options();
		options.addOption("v", false, "be verbose");
		Option i = OptionBuilder.withArgName("file")
	        .hasArg()
	        .withDescription("input file. The file containing the pseudocode.")
	        .create('i');
		Option o = OptionBuilder.withArgName("folder")
	        .hasArg()
	        .withDescription("output folder. The folder to write the output files to.")
	        .create('o');
		Option h = OptionBuilder
		        .withDescription("displays help")
		        .create("help");
		options.addOption(i);
		options.addOption(o);
		options.addOption(h);
		
		try
		{
			CommandLine cmd = new PosixParser().parse(options, args);
			if(cmd.hasOption("help"))
			{
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp("PseudocodeCompiler", options);
			}
			else
			{
				String fileName = cmd.getOptionValue('i');
				String outputDirectory = cmd.getOptionValue('o');
				
				compile(fileName, outputDirectory);
			}
			
		} catch (ParseException e1)
		{
			System.err.println("Bad arguments: " + e1.getMessage());
		}
	}

	private static void compile(String fileName, String outputDirectory) throws FileNotFoundException
	{
		FileInputStream inStream = new FileInputStream(fileName);
		
		List<LineToken> lineTokens = Tokenizer.tokenize(inStream);
		List<FirstClassCitizen> constructs = new Parser().interpret(lineTokens);
		
		List<CodeRepresentation> languageRepresentation = generate(new JavaGenerator(), constructs);
		
		try
		{
			CodeWriter.WriteCode(new File(outputDirectory), languageRepresentation);
		} catch (IOException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("Complete");
	}
	
	private static List<CodeRepresentation> generate(CodeGeneratable generator, List<FirstClassCitizen> constructs)
	{
		List<CodeRepresentation> representations = new LinkedList<>();
		for(FirstClassCitizen construct : constructs)
		{
			representations.add(construct.generateUsing(generator));
		}
		return representations;
	}
	
}
