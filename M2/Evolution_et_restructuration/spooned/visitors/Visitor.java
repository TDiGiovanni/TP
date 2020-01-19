package visitors;


import stockage.Directory;
import stockage.File;
import stockage.Link;
import stockage.SymbolicLink;


public abstract class Visitor {
    public abstract void visit(Directory d);

    public abstract void visit(File f);

    public abstract void visit(Link l);

    public abstract void visit(SymbolicLink sl);
}

