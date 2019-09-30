package visitors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodInvocation;

// Navigates methods invocation inside method
public class MethodInvocationVisitor extends ASTVisitor
{
	List<MethodInvocation> methods = new ArrayList<MethodInvocation>();
	
	public boolean visit(MethodInvocation node)
	{
		methods.add(node);
		return super.visit(node);
	}

	public List<MethodInvocation> getMethods()
	{
		return methods;
	}
	
	public void print()
	{
		for (MethodInvocation methodInvocation : getMethods())
		{
			ITypeBinding binding = methodInvocation.getExpression().resolveTypeBinding();
			System.out.println("\t\tCall to the method " + methodInvocation.getName()
			+ (binding == null? "": ", of the class " + methodInvocation.getExpression().resolveTypeBinding().getName()));
		}
	}
}
