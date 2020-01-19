package visitors;


import stockage.Directory;
import stockage.File;
import stockage.Link;
import stockage.SymbolicLink;


// Resets the size of all files
public class RazVisitor extends Visitor {
    public void visit(Directory d) {
    }

    public void visit(File f) {
        f.setContent("");
    }

    public void visit(Link l) {
    }

    public void visit(SymbolicLink sl) {
    }
}

