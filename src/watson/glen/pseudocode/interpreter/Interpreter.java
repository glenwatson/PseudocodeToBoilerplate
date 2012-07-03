package watson.glen.pseudocode.interpreter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import watson.glen.pseudocode.constructs.AccessModifier;
import watson.glen.pseudocode.constructs.ClassConstruct;
import watson.glen.pseudocode.constructs.Comment;
import watson.glen.pseudocode.constructs.LanguageConstruct;
import watson.glen.pseudocode.constructs.MethodSignature;
import watson.glen.pseudocode.constructs.VariableDeclaration;
import watson.glen.pseudocode.tokenizer.LineToken;
import watson.glen.pseudocode.tokenizer.Token;

public class Interpreter
{
	private static final String TAB = "\t";
	private static Level0State lvl0State;
	/*//method signature regex
	private static final String tabs = "("+TAB+")*";
	private static final String accessModifier = "[\\+\\-#]";
	private static final String generic ="<[a-zA-Z_][a-zA-Z0-9_]*>";
	private static final String type ="([a-zA-Z_][a-zA-Z0-9_]*("+generic+")?)";
	private static final String name = "([a-z_][a-zA-Z0-9_]*)";
	
	private static final String parameter = "("+name+" : "+type+")";
	private static final String parameters = "("+parameter+", )*"+parameter;
	private static final String parameterList = "\\(("+parameters+"|"+parameter+"?)\\)";
	
	private static final String methodSigRegex = tabs + accessModifier + " " + name + parameterList + " : " + type;
	//end method signature regex
*/
	
	public static List<LanguageConstruct> interpret(List<LineToken> lineTokens)
	{
		List<LanguageConstruct> constructs = new LinkedList<LanguageConstruct>();
		
		for (LineToken lineToken : lineTokens)
		{
			Queue<Token> tokens = toQueue(lineToken.getTokens());
			parseTokenLine(tokens);
		}
		
		return constructs;
		
	}

	private static void parseTokenLine(Queue<Token> tokens)
	{
		int indentionLevel = getIndendation(tokens);
		switch(indentionLevel)
		{
			case 0: //Class, Interface, Enum
				parseLevel0(tokens);
				break;
			case 1:
				parseLevel1(tokens);
				break;
			default:
				parseLevelGreaterThan2(tokens);
				break;
		}
	}

	private static void parseLevel0(Queue<Token> tokens)
	{
		String first = tokens.poll().getValue();
		switch(first)
		{
			case "class":
				lvl0State = Level0State.Class("");
				break;
			case "interface":
				lvl0State = Level0State.Interface;
				break;
			case "enum":
				lvl0State = Level0State.Enum;
				break;
			default:
				lvl0State = null;
		}
		
		//if there are values here,
		//	Init new class/interface/enum
		//	parse the values
		//	update lvl0State
	}

	private static void parseLevel1(Queue<Token> tokens)
	{
		switch(lvl0State)
		{
			case Class: //Instance variables, Method signatures,
				lvl0State = Level0State.Class;
				break;
			case Interface: //Method signatures
					
				break;
			case Enum: //Enum values
				
				break;
		}
	}

	private static void parseLevelGreaterThan2(Queue<Token> tokens)
	{
		switch(lvl0State)
		{
			case Class: //Method lines
				
				break;
			case Interface: //Umm, no?
				
				break;
			case Enum: //Nope
				
				break;
		}
	}
	
	private static int getIndendation(Queue<Token> tokens)
	{
		int indention = 0;
		while(tokens.size() > 0 && tokens.peek().getValue().equals(TAB))
		{
			tokens.poll();
			indention++;
		}
		return indention;
	}
	
	private static Comment parseComment(Queue<Token> tokens)
	{
		StringBuilder sb = new StringBuilder();
		Token token;
		while((token = tokens.poll()) != null)
		{
			sb.append(token.getValue());
		}
		return new Comment(sb.toString());
	}
	
	private static MethodSignature parseMethodSignature(List<Token> tokenList) throws NotAMethodSignatureException
	{
		Queue<Token> tokens = toQueue(tokenList);
		AccessModifier modifier = null;
		String returnType = null;
		String methodName = null;
		List<VariableDeclaration> parameters = null;
		
		int indention = getIndendation(tokens);
		modifier = parseModifier(tokens);
		boolean isStatic = parseStatic(tokens);
		methodName = parseMethodName(tokens);
		parameters = parseParameterList(tokens);
		returnType = parseType(tokens);
		
		
		MethodSignature sig = new MethodSignature(modifier, isStatic, returnType, methodName, parameters);
		return sig;
	}

	private static Queue<Token> toQueue(List<Token> tokenList)
	{
		LinkedList<Token> llQueue = new LinkedList<>(tokenList);
//		Collections.copy(llQueue, tokenList);
		return llQueue;
	}
	
	private static boolean parseStatic(Queue<Token> tokens)
	{
		if(tokens.size() > 0 && tokens.peek().getValue().equals("_"))
		{
			tokens.poll();
			return true;
		}
		return false;
	}

	private static String parseType(Queue<Token> tokens) throws NotAMethodSignatureException
	{
		if(tokens.size() == 0)
			throw new NotAMethodSignatureException("No type given");
		return tokens.poll().getValue();
	}

	private static List<VariableDeclaration> parseParameterList(Queue<Token> tokens) throws NotAMethodSignatureException
	{
		if(tokens.size() == 0 || !tokens.poll().getValue().equals("("))
			throw new NotAMethodSignatureException("No \"(\" after method name");
		
		if(tokens.size() == 0)
			throw new NotAMethodSignatureException("No parameter list or closing paren \")\" after opening paren \"(\"");
		boolean endOfParameterList = !tokens.peek().getValue().equals(")");
		List<VariableDeclaration> varDeclarations = endOfParameterList ? parseParameters(tokens) : new ArrayList<VariableDeclaration>();
		
		if(tokens.size() == 0 || !tokens.poll().getValue().equals(")"))
			throw new NotAMethodSignatureException("No closing \")\" in parameter list");
		return varDeclarations;
	}

	private static List<VariableDeclaration> parseParameters(Queue<Token> tokens) throws NotAMethodSignatureException
	{
		List<VariableDeclaration> varDeclarations = new LinkedList<>();
		varDeclarations.add(parseParameter(tokens));
		while(!tokens.peek().getValue().equals(")"))
		{
			if(!tokens.poll().getValue().equals(","))
				throw new NotAMethodSignatureException("No \",\" in between parameters");
			varDeclarations.add(parseParameter(tokens));
		}
		return varDeclarations;
	}
	
	private static VariableDeclaration parseParameter(Queue<Token> tokens) throws NotAMethodSignatureException
	{
		if(tokens.size() < 3)
			throw new NotAMethodSignatureException("Invalid parameter list variable declaration");
		
		String variableName = tokens.poll().getValue();
		if(!tokens.poll().getValue().equals(":"))
			throw new NotAMethodSignatureException("No \":\" in parameter list variable declaration");
		String type = tokens.poll().getValue();
		return new VariableDeclaration(type, variableName);
	}

	private static String parseMethodName(Queue<Token> tokens) throws NotAMethodSignatureException
	{
		if(tokens.size() < 1)
			throw new NotAMethodSignatureException("No method name");
		return tokens.poll().getValue();
	}

	private static AccessModifier parseModifier(Queue<Token> tokens) throws NotAMethodSignatureException
	{
		if(tokens.size() < 1)
			throw new NotAMethodSignatureException("No access modifier");
		
		AccessModifier modifier;
		switch(tokens.poll().getValue())
		{
			case "+":
				modifier = AccessModifier.publicModifier;
				break;
			case "-":
				modifier = AccessModifier.privateModifier;
				break;
			case "#":
				modifier = AccessModifier.protectedModifier;
				break;
			case "~":
				modifier = AccessModifier.defaultModifier;
				break;
			default:
				modifier = AccessModifier.publicModifier;
				break;
		}
		return modifier;
	}
}
