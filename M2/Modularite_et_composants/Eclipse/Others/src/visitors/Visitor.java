package visitors;

import stockage.*;

public abstract class Visitor
{
	public abstract void visit(Directory d);
	public abstract void visit(File f);
	public abstract void visit(Link l);
	public abstract void visit(SymbolicLink sl);
}
