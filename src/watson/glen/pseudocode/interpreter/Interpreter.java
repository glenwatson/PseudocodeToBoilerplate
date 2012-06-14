package watson.glen.pseudocode.interpreter;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import watson.glen.pseudocode.constructs.AccessModifier;
import watson.glen.pseudocode.constructs.LanguageConstruct;
import watson.glen.pseudocode.constructs.MethodSignature;
import watson.glen.pseudocode.constructs.VariableDeclaration;
import watson.glen.pseudocode.tokenizer.LineToken;
import watson.glen.pseudocode.tokenizer.Token;

public class Interpreter
{
	public static List<LanguageConstruct> interpret(List<LineToken> lineTokens)
	{
		
		for (LineToken lineToken : lineTokens)
		{
			//	+ methodName(parameterName : parameterType) : returnType
			MethodSignature sig = parseMethodSignature(lineToken.getTokens());
			
		}
		
		List<LanguageConstruct> constructs = new LinkedList<LanguageConstruct>();
		
		return constructs;
		
	}
	
	private static MethodSignature parseMethodSignature(List<Token> tokens)
	{
		AccessModifier modifier = null;
		String returnType = null;
		String methodName = null;
		List<VariableDeclaration> parameters = null;
		
		int indention = 0;
		for (Token token : tokens)
		{
			if(token.getValue().equals("\\t"))
			{
				indention++;
				continue;
			}
		}
		
		modifier = parseModifier(tokens.get(indention));
		methodName = parseMethodName(tokens.get(indention+1));
		parameters = parseParameters(indention+2, tokens);
		int returnTypePosition = 3+(parameters.size()*3)+(Math.abs(parameters.size()-1));
		returnType = parseType(tokens.get(indention+returnTypePosition));
//		
		
		
		MethodSignature sig = null;
		if(modifier != null && returnType != null && methodName != null && parameters != null)
			sig = new MethodSignature(modifier, returnType, methodName, parameters);
		return sig;
	}

	private static String parseType(Token token)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private static List<VariableDeclaration> parseParameters(int i, List<Token> tokens)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private static String parseMethodName(Token token)
	{
		String value = token.getValue();
		
		return value;
	}

	private static AccessModifier parseModifier(Token token)
	{
		AccessModifier modifier;
		switch(token.getValue())
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
			default:
				modifier = null;
				break;
		}
		return modifier;
	}
}
