package visitors;

import stockage.Directory;
import stockage.File;
import stockage.Link;
import stockage.SymbolicLink;

public class CountVisitor extends Visitor
{
	protected int count;
	
	public CountVisitor()
	{
		super();
		this.count = 0;
	}
	
	public int getCount()
	{
		return this.count;
	}
	
	public void Visit(Directory d)
	{
		
	}

	public void Visit(File f)
	{
		
	}

	public void Visit(Link l)
	{
		
	}

	public void Visit(SymbolicLink sl)
	{
		
	}
}
