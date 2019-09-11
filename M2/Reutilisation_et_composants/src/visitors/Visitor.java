package visitors;

import stockage.*;

public abstract class Visitor
{
	public abstract void Visit(Directory d);
	public abstract void Visit(File f);
	public abstract void Visit(Link l);
	public abstract void Visit(SymbolicLink sl);
}
