package watson.glen.pseudocode.constructs;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public enum AccessModifier
{
	publicModifier,
	privateModifier,
	protectedModifier,
	defaultModifier;
	
	@Override
	public String toString()
	{
		switch(this)
		{
			case publicModifier:
				return "public ";
			case privateModifier:
				return "private ";
			case protectedModifier:
				return "protected ";
			case defaultModifier:
				return "";
		}
		throw new NotImplementedException();
	}
}
