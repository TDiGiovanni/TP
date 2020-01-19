package visitors;


import stockage.Directory;
import stockage.File;
import stockage.Link;
import stockage.SymbolicLink;


public class CountVisitor extends Visitor {
    protected int count;

    public CountVisitor() {
        super();
        this.count = 0;
    }

    public int getCount() {
        return this.count;
    }

    public void visit(Directory d) {
    }

    public void visit(File f) {
        if (f.size() > 10)
            this.count++;

    }

    public void visit(Link l) {
    }

    public void visit(SymbolicLink sl) {
    }
}

