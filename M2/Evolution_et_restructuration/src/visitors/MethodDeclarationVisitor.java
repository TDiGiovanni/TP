package visitors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;

// Navigates method information
public class MethodDeclarationVisitor extends ASTVisitor
{
	List<MethodDeclaration> methods = new ArrayList<MethodDeclaration>(); // All methods declared in the file
	
	public boolean visit(MethodDeclaration node)
	{
		methods.add(node);
		return super.visit(node);
	}
	
	public List<MethodDeclaration> getMethods()
	{
		return methods;
	}
	
	public void print()
	{
		for (MethodDeclaration method : getMethods())
		{
			if (method.getReturnType2() != null)
				System.out.println("\tThe method " + method.getName()
				+ " is declared with return type " + method.getReturnType2());
			else
				System.out.println("\tThe constructor " + method.getName() + " is declared");
		}
	}
}
