package visitors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class TypeDeclarationVisitor extends ASTVisitor
{
	protected List<TypeDeclaration> types = new ArrayList<TypeDeclaration>(); 	// All the classes declared in the file
	protected int attributeCount = 0;											// Number of attributes declared in the file
	
	public boolean visit(TypeDeclaration node)
	{
		types.add(node);
		attributeCount += node.getFields().length;
		return super.visit(node);
	}
	
	public List<TypeDeclaration> getTypes()
	{
		return types;
	}
	
	public int getAttributeCount()
	{
		return attributeCount;
	}
	
	public void print()
	{
		for (TypeDeclaration declaration : getTypes())
		{
			// Type
			System.out.println("\nDeclaration of the class " + declaration.getName()
			+ (declaration.getSuperclassType() != null? ", its superclass is " + declaration.getSuperclassType(): ""));

			// Attributes
			if (declaration.getFields().length != 0)
			{
				System.out.println("\tIts attributes are:");
				for (int i = 0; i < declaration.getFields().length; i++)
					System.out.print("\t\t" + declaration.getFields()[i]);
			}
			else
				System.out.println("\tIt has no attributes");
		}
	}
}
