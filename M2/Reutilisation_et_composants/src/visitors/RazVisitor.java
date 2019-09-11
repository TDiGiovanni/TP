package visitors;

import stockage.*;

// Resets the size of all files
public class RazVisitor extends Visitor
{
	public void Visit(Directory d)
	{
		if (d.size() != 0)
			System.out.println("Directory " + d.getName() + " not empty");
	}

	public void Visit(File f)
	{
		f.setContent(null);
	}

	public void Visit(Link l)
	{
		if (l.size() != 0)
			System.out.println("Link " + l.getName() + " not empty");
	}

	public void Visit(SymbolicLink sl)
	{
		if (sl.size() != 0)
			System.out.println("Symbolic link " + sl.getName() + " not empty");
	}
}
