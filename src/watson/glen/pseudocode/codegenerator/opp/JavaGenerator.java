package watson.glen.pseudocode.codegenerator.opp;

import watson.glen.pseudocode.codegenerator.CodeRepresentation;
import watson.glen.pseudocode.constructs.AccessModifier;
import watson.glen.pseudocode.constructs.ClassConstruct;
import watson.glen.pseudocode.constructs.EnumConstruct;
import watson.glen.pseudocode.constructs.InstanceVariable;
import watson.glen.pseudocode.constructs.InterfaceConstruct;
import watson.glen.pseudocode.constructs.Method;
import watson.glen.pseudocode.constructs.MethodLine;
import watson.glen.pseudocode.constructs.MethodSignature;
import watson.glen.pseudocode.constructs.Type;
import watson.glen.pseudocode.constructs.VariableDeclaration;


public class JavaGenerator implements OOPCodeGeneratable
{
	private static final String JAVA_EXTENSION = ".java";
	
	@Override
	public CodeRepresentation generate(ClassConstruct classConstruct)
	{
		String representation = generateClass(classConstruct);
		return new CodeRepresentation(classConstruct.getName()+JAVA_EXTENSION, representation);
	}
	
	@Override
	public CodeRepresentation generate(EnumConstruct enumConstruct)
	{
		String representation = generateEnum(enumConstruct);
		return new CodeRepresentation(enumConstruct.getName()+JAVA_EXTENSION, representation);
	}
	
	@Override
	public CodeRepresentation generate(InterfaceConstruct interfaceConstruct)
	{
		String representation = generateInterface(interfaceConstruct);
		return new CodeRepresentation(interfaceConstruct.getName()+JAVA_EXTENSION, representation);
	}
	
	private String generateClass(ClassConstruct classConstruct)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(generate(classConstruct.getModifier()));
		sb.append("class ");
		sb.append(classConstruct.getName());
		if(classConstruct.getInheritance() != null)
		{
			sb.append(" extends ");
			sb.append(generate(classConstruct.getInheritance()));
		}
		if(classConstruct.getImplementations().size() > 0)
		{
			sb.append(" implements ");
			for(Type implementation : classConstruct.getImplementations())
			{
				sb.append(generate(implementation));
				sb.append(", ");
			}
			sb.delete(sb.length()-2, sb.length());
		}
		sb.append("\r\n{\r\n");
		
		for(InstanceVariable instanceVariable : classConstruct.getInstanceVariables())
		{
			sb.append(generate(instanceVariable));
			sb.append("\r\n");
		}
		sb.append("\r\n");
		
		for(Method method : classConstruct.getMethods())
		{
			sb.append(generate(method));
			sb.append("\r\n");
		}
		sb.append("}\r\n");
		
		return sb.toString();
	}
	
	public String generateEnum(EnumConstruct enumConstruct)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(generate(enumConstruct.getModifier()));
		sb.append(" enum ");
		sb.append(enumConstruct.getName());
		sb.append("\r\n{\r\n\t");
		for(String enumName : enumConstruct.getEnumNames())
		{
			sb.append(enumName);
			sb.append(",\r\n\t");
		}
		sb.deleteCharAt(sb.length()-4);
		
		return sb.toString();
	}
	
	public String generateInterface(InterfaceConstruct interfaceConstruct)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(generate(interfaceConstruct.getModifier()));
		sb.append("interface ");
		sb.append(interfaceConstruct.getName());
		if (interfaceConstruct.getInheritances().size() > 0)
		{
			sb.append(" extends ");
			for (Type implementation : interfaceConstruct.getInheritances())
			{
				sb.append(generate(implementation));
				sb.append(", ");
			}
			sb.delete(sb.length() - 2, sb.length());
		}
		sb.append("\r\n{\r\n");
		
		if (interfaceConstruct.getMethodSignatures().size() > 0)
			for (MethodSignature signature : interfaceConstruct.getMethodSignatures())
			{
				sb.append(generate(signature));
				sb.append("\r\n");
			}
		else
			sb.append("\r\n");
		
		sb.append("}\r\n");
		return sb.toString();
	}
	
	private String generate(AccessModifier accessModifier)
	{
		String representation = null;
		switch(accessModifier)
		{
			case publicModifier:
				representation = "public ";
			case privateModifier:
				representation = "private ";
			case protectedModifier:
				representation = "protected ";
			case defaultModifier:
				representation = "";
		}
		return representation;
	}
	
	private String generate(InstanceVariable instanceVar)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\t");
		sb.append(instanceVar.getModifier());
		if(instanceVar.isStatic())
			sb.append("static ");
		if(instanceVar.isFinal())
			sb.append("final ");
		sb.append(generate(instanceVar.getVariable()));
		return sb.toString();
	}
	
	private String generate(Method method)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(generate(method.getMethodSignature()));
		sb.append("\r\n\t{\r\n");
		for (MethodLine methodLine : method.getLines())
		{
			sb.append(generate(methodLine));
			sb.append("\r\n");
		}
		sb.append("\t}\r\n");
		return sb.toString();
	}
	
	private String generate(MethodLine methodline)
	{
		return "\t\t// "+methodline.getValue();
	}
	
	private String generate(MethodSignature methodSig)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\t");
		sb.append(generate(methodSig.getModifier()));
		if (methodSig.isStatic())
		{
			sb.append("static ");
		}
		sb.append(generate(methodSig.getReturnType()));
		sb.append(" ");
		sb.append(methodSig.getMethodName());
		
		sb.append("(");
		if(methodSig.getParameters().size() > 0)
		{
			for(VariableDeclaration varDeclartion : methodSig.getParameters())
			{
				sb.append(generate(varDeclartion));
				sb.append(", ");
			}
			sb.delete(sb.length() - 2, sb.length());
		}
		sb.append(")");
		
		return sb.toString();
	}
	
	private String generate(Type type)
	{
		return type.getName();
	}
	
	private String generate(VariableDeclaration varDeclaration)
	{
		String result = generate(varDeclaration.getType()) + " " + varDeclaration.getVariableName();
		if(varDeclaration.getInitalValue() != null)
			result += " = " + varDeclaration.getInitalValue();
		return result;
	}
}
