package visitors;


import java.util.ArrayList;
import java.util.Collection;
import stockage.Directory;
import stockage.File;
import stockage.Link;
import stockage.SymbolicLink;


// Searches for all elements named "name"
public class FindVisitor extends Visitor {
    String name;

    Collection<String> addresses;

    public FindVisitor(String name) {
        this.name = name;
        this.addresses = new ArrayList<>();
    }

    public Collection<String> find() {
        return addresses;
    }

    @Override
    public void visit(Directory d) {
        if (d.getName().equals(name))
            addresses.add(d.absoluteAdress());

    }

    @Override
    public void visit(File f) {
        if (f.getName().equals(name))
            addresses.add(f.absoluteAdress());

    }

    @Override
    public void visit(Link l) {
        if (l.getName().equals(name))
            addresses.add(l.absoluteAdress());

    }

    @Override
    public void visit(SymbolicLink sl) {
        if (sl.getName().equals(name))
            addresses.add(sl.absoluteAdress());

    }
}

