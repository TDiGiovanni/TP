package visitors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class TypeDeclarationVisitor extends ASTVisitor
{
	List<TypeDeclaration> types = new ArrayList<TypeDeclaration>();
	
	public boolean visit(TypeDeclaration node)
	{
		types.add(node);
		return super.visit(node);
	}
	
	public List<TypeDeclaration> getTypes()
	{
		return types;
	}
	
	public void print()
	{
		for (TypeDeclaration declaration : getTypes())
		{
			System.out.println("\tDeclaration of type " + declaration.getName()
			+ (declaration.getSuperclassType() != null? ", its superclass is " + declaration.getSuperclassType(): ""));
			
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
