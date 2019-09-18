package visitors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import stockage.Directory;
import stockage.File;
import stockage.Link;
import stockage.SymbolicLink;

// Deletes all ".class" files
// Usage of a lambda function to potentially change the contained string that we are looking for
public class JavaCleanVisitor extends Visitor
{
	protected Function<String, Boolean> function;
	protected Map<Directory, List<File>> filesToDelete;
	
	public JavaCleanVisitor(Function<String, Boolean> function)
	{
		this.function = function;
		this.filesToDelete = new HashMap<>();
	}
	
	@Override
	public void visit(Directory d)
	{
		d.remove(filesToDelete.get(d));
	}

	@Override
	public void visit(File f)
	{
		if (function.apply(f.getName()))
			f.getParent().remove(f);
	}

	@Override
	public void visit(Link l)
	{
		
	}

	@Override
	public void visit(SymbolicLink sl)
	{
		
	}
}
