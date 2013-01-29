package watson.glen.pseudocode.interpreter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import watson.glen.pseudocode.constructs.AccessModifier;
import watson.glen.pseudocode.constructs.ClassConstruct;
import watson.glen.pseudocode.constructs.EnumConstruct;
import watson.glen.pseudocode.constructs.FirstClassMember;
import watson.glen.pseudocode.constructs.InstanceVariable;
import watson.glen.pseudocode.constructs.InterfaceConstruct;
import watson.glen.pseudocode.constructs.LanguageConstruct;
import watson.glen.pseudocode.constructs.Method;
import watson.glen.pseudocode.constructs.MethodLine;
import watson.glen.pseudocode.constructs.MethodSignature;
import watson.glen.pseudocode.constructs.Type;
import watson.glen.pseudocode.constructs.VariableDeclaration;
import watson.glen.pseudocode.interpreter.exception.MissingAccessModifierException;
import watson.glen.pseudocode.interpreter.exception.NotAMethodSignatureException;
import watson.glen.pseudocode.tokenizer.LineToken;
import watson.glen.pseudocode.tokenizer.Token;

/**
 * Performs syntactic & semantic analysis
 * @author glen.watson
 *
 */
public class Parser
{
	private final String TAB = "\t";
	List<LanguageConstruct> constructs = new LinkedList<LanguageConstruct>();
	private Level0State lvl0State;
	private ClassConstruct currentClass;
	private InterfaceConstruct currentInterface;
	private EnumConstruct currentEnum;
	
	private Method currentMethod;
	/*
	//method signature regex
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
	
	public List<LanguageConstruct> interpret(List<LineToken> lineTokens)
	{
		parseLineTokens(lineTokens);
		return constructs;
	}
	
	private void parseLineTokens(List<LineToken> lineTokens)
	{
		for(LineToken lineToken : lineTokens)
		{
			System.out.println("parsing: "+lineToken);
			parseTokens(lineToken.getTokens());
		}
	}

	private void parseTokens(List<Token> tokens)
	{
		Queue<Token> tokenQueue = toTokenQueue(tokens);
		int indentionLevel = getIndendation(tokenQueue);
		if(tokens.size() > 0)
		{
			switch(indentionLevel)
			{
				case 0: //Class, Interface, Enum
					parseLevel0(tokenQueue);
					break;
				case 1:
					parseLevel1(tokenQueue);
					break;
				default:
					parseLevelGreaterThan2(tokenQueue);
					break;
			}
		}
	}
	
	private int getIndendation(Queue<Token> tokens)
	{
		int indention = 0;
		while(tokens.size() > 0 && tokens.peek().getValue().equals(TAB))
		{
			tokens.poll();
			indention++;
		}
		return indention;
	}
	
	private FirstClassMember getFirstClassMember()
	{
		switch(lvl0State)
		{
			case Class:
				return currentClass;
			case Interface:
				return currentInterface;
			case Enum:
				return currentEnum;
		}
		return null;
	}
	
	/* Level 0 */
	private void parseLevel0(Queue<Token> tokens)
	{
		try
		{
			AccessModifier modifier = parseModifier(tokens);
			String first = tokens.poll().getValue();
			String name = tokens.poll().getValue();
			switch(first)
			{
				case "class":
					lvl0State = Level0State.Class;
					currentClass = new ClassConstruct(modifier, name);
					Type superClass = parseInheritance(tokens);
					if(superClass != null)
					{
						currentClass.setInheritance(superClass);
					}
					List<Type> implementations = parseImplementations(tokens);
					if(implementations.size() > 0)
					{
						currentClass.setImplementations(implementations);
					}
					constructs.add(currentClass);
					break;
				case "interface":
					lvl0State = Level0State.Interface;
					currentInterface = new InterfaceConstruct(modifier, name);
					List<Type> inheritanceList = parseInheritanceList(tokens);
					if(inheritanceList.size() > 0)
					{
						currentInterface.setInheritances(inheritanceList);
					}
					constructs.add(currentInterface);
					break;
				case "enum":
					lvl0State = Level0State.Enum;
					currentEnum = new EnumConstruct(modifier, name);
					constructs.add(currentEnum);
					break;
				default:
					lvl0State = null;
			}
		} catch (MissingAccessModifierException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		//if there are values here,
		//	Init new class/interface/enum
		//	parse the values
		//	update lvl0State
	}
	
	private Type parseInheritance(Queue<Token> tokens)
	{
		Type type = null;
		if(tokens.size() >= 2 && tokens.peek().getValue().equals("extends"))
		{
			tokens.poll();
			type = new Type(tokens.poll().getValue());
		}
		return type;
	}
	
	private List<Type> parseImplementations(Queue<Token> tokens)
	{
		List<Type> implementations = null;
		if(tokens.size() >= 2 && tokens.peek().getValue().equals("implements"))
		{
			tokens.poll();
			implementations = parseTypeList(tokens);
		}
		else
			implementations = new LinkedList<Type>();
		return implementations;
	}
	
	private List<Type> parseInheritanceList(Queue<Token> tokens)
	{
		List<Type> inheritances = null;
		if(tokens.size() >= 2 && tokens.peek().getValue().equals("extends"))
		{
			tokens.poll();
			inheritances = parseTypeList(tokens);
		}
		else
			inheritances = new LinkedList<Type>();
		return inheritances;
	}

	private List<Type> parseTypeList(Queue<Token> tokens)
	{
		List<Type> typeList = new LinkedList<Type>();
		while(tokens.size() > 0)
		{
			typeList.add(new Type(tokens.poll().getValue()));
			if(tokens.size() > 0 && tokens.peek().getValue().equals(","))
			{
				tokens.poll();
			}
		}
		return typeList;
	}

	/* Level 1*/
	private void parseLevel1(Queue<Token> tokens)
	{
		switch(lvl0State)
		{
			case Class: //Instance variables, Method signatures,
				try
				{
					parseClassInternals(tokens);
				} catch (NotAMethodSignatureException e)
				{
					System.out.println(e.getMessage());
					e.printStackTrace();
				} catch (MissingAccessModifierException e)
				{
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				break;
			case Interface: //Method signatures
				try
				{
					parseInterfaceMethodSignature(tokens);
				} catch (NotAMethodSignatureException e)
				{
					System.out.println(e.getMessage());
				} catch (MissingAccessModifierException e)
				{
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				break;
			case Enum: //Enum values
				parseEnumValues(tokens);
				break;
			default:
				assert false : lvl0State;
		}
	}

	private void parseClassInternals(Queue<Token> tokens) throws NotAMethodSignatureException, MissingAccessModifierException
	{
		if(tokens.size() > 0)
		{
			//parse either an class level variable or a method
			AccessModifier modifier = parseModifier(tokens);
			boolean isStatic = parseStatic(tokens);
			String name = parseName(tokens);
			String nextToken = tokens.peek().getValue();
			if(nextToken.equals(":"))
			{
				tokens.poll(); //eat the colon
				Type returnType = parseType(tokens);
				VariableDeclaration declaration = new VariableDeclaration(returnType, name);
				if(tokens.size() >= 2 && tokens.poll().getValue().equals("="))
				{
					String initalVariableValue = tokens.poll().getValue();
					declaration.setInitalValue(initalVariableValue);
				}
				InstanceVariable instanceVar = new InstanceVariable(modifier, declaration);
				currentClass.getInstanceVariables().add(instanceVar);
			} else if(nextToken.equals("("))
			{
				List<VariableDeclaration> parameters = parseParameterList(tokens);
				if(!tokens.poll().getValue().equals(":"))
					throw new NotAMethodSignatureException("Missing colon (:) preceding return type on method signature");
				Type returnType = parseType(tokens);
				MethodSignature signature = new MethodSignature(modifier, isStatic, returnType, name, parameters);
				currentMethod = new Method(signature);
				currentClass.getMethods().add(currentMethod);
			}
		}
	}

	private void parseInterfaceMethodSignature(Queue<Token> tokens) throws NotAMethodSignatureException, MissingAccessModifierException
	{
		parseMethodSignature(tokens);
	}

	private void parseEnumValues(Queue<Token> tokens)
	{
		while(tokens.size() > 0)
		{
			String value = tokens.poll().getValue();
			currentEnum.getEnumNames().add(value);
			if(tokens.size()>0 && tokens.peek().equals(","))
				tokens.poll();
		}
	}
	
	/* Level >= 2 */
	private void parseLevelGreaterThan2(Queue<Token> tokens)
	{
		switch(lvl0State)
		{
			case Class: //Actual code
				currentMethod.getLines().add(parseMethodLine(tokens));
				break;
			case Interface: //Umm, no?
				//throw new 
				break;
			case Enum: //Nope
				//throw new 
				break;
			default:
				assert false : lvl0State;
		}
	}
	
	private MethodLine parseMethodLine(Queue<Token> tokens)
	{
		StringBuilder sb = new StringBuilder();
		Token token;
		while((token = tokens.poll()) != null)
		{
			sb.append(token.getValue());
		}
		return new MethodLine(sb.toString());
	}
	
	private MethodSignature parseMethodSignature(Queue<Token> tokens) throws NotAMethodSignatureException, MissingAccessModifierException
	{
		AccessModifier modifier = parseModifier(tokens);
		boolean isStatic = parseStatic(tokens);
		String methodName = parseName(tokens);
		List<VariableDeclaration> parameters = parseParameterList(tokens);
		if(!tokens.poll().getValue().equals(":"))
			throw new NotAMethodSignatureException("Missing colon (:) preceding return type on method signature");
		Type returnType = parseType(tokens);
		
		MethodSignature sig = new MethodSignature(modifier, isStatic, returnType, methodName, parameters);
		return sig;
	}
	
	private Queue<Token> toTokenQueue(List<Token> tokenList)
	{
		LinkedList<Token> llQueue = new LinkedList<>(tokenList);
		return llQueue;
	}
	
	private Queue<LineToken> toLineTokenQueue(List<LineToken> lineTokenList)
	{
		LinkedList<LineToken> llQueue = new LinkedList<>(lineTokenList);
		return llQueue;
	}
	
	private boolean parseStatic(Queue<Token> tokens)
	{
		if(tokens.size() > 0 && tokens.peek().getValue().equals("_"))
		{
			tokens.poll();
			return true;
		}
		return false;
	}
	
	private Type parseType(Queue<Token> tokens) throws NotAMethodSignatureException
	{
		if(tokens.size() == 0)
			throw new NotAMethodSignatureException("No type given");
		return new Type(tokens.poll().getValue());
	}

	private List<VariableDeclaration> parseParameterList(Queue<Token> tokens) throws NotAMethodSignatureException
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

	private List<VariableDeclaration> parseParameters(Queue<Token> tokens) throws NotAMethodSignatureException
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
	
	private VariableDeclaration parseParameter(Queue<Token> tokens) throws NotAMethodSignatureException
	{
		if(tokens.size() < 3)
			throw new NotAMethodSignatureException("Invalid parameter list variable declaration");
		
		String variableName = tokens.poll().getValue();
		if(!tokens.poll().getValue().equals(":"))
			throw new NotAMethodSignatureException("No \":\" in parameter list variable declaration");
		String type = tokens.poll().getValue();
		return new VariableDeclaration(new Type(type), variableName);
	}

	private String parseName(Queue<Token> tokens)
	{
		return tokens.poll().getValue();
	}

	private AccessModifier parseModifier(Queue<Token> tokens) throws MissingAccessModifierException
	{
		if(tokens.size() < 1)
			throw new MissingAccessModifierException();
		
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
