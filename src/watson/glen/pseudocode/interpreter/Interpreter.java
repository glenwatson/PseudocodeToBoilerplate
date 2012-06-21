package watson.glen.pseudocode.interpreter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import watson.glen.pseudocode.constructs.AccessModifier;
import watson.glen.pseudocode.constructs.LanguageConstruct;
import watson.glen.pseudocode.constructs.MethodSignature;
import watson.glen.pseudocode.constructs.VariableDeclaration;
import watson.glen.pseudocode.tokenizer.LineToken;
import watson.glen.pseudocode.tokenizer.Token;

public class Interpreter
{
	//method signature regex
	private static final String tabs = "(\t)*";
	private static final String accessModifier = "[\\+\\-#]";
	private static final String generic ="<[a-zA-Z_][a-zA-Z0-9_]*>";
	private static final String type ="([a-zA-Z_][a-zA-Z0-9_]*("+generic+")?)";
	private static final String name = "([a-z_][a-zA-Z0-9_]*)";
	
	private static final String parameter = "("+name+" : "+type+")";
	private static final String parameters = "("+parameter+", )*"+parameter;
	private static final String parameterList = "\\(("+parameters+"|"+parameter+"?)\\)";
	
	private static final String methodSigRegex = tabs + accessModifier + " " + name + parameterList + " : " + type;
	//end method signature regex
	private static final String TAB = "\t";
	
	public static List<LanguageConstruct> interpret(List<LineToken> lineTokens)
	{
		List<LanguageConstruct> constructs = new LinkedList<LanguageConstruct>();
		
		for (LineToken lineToken : lineTokens)
		{
			try
			{
				//	+ methodName(parameterName : parameterType) : returnType
				MethodSignature sig = parseMethodSignature(lineToken.getTokens());
//				constructs.add(sig);
			} catch (NotAMethodSignatureException e)
			{
				e.printStackTrace();
				//I don't know what to do here
			}
		}
		
		return constructs;
		
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
