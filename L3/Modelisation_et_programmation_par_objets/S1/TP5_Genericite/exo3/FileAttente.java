package exo3;

import java.util.ArrayList;

public class FileAttente<A extends ElementAvecPriorite> {
	protected ArrayList<A> contenu;
	
	public FileAttente() {
		this.contenu= new ArrayList<A>();
	}
	
	public void entre(A a) {
		contenu.add(a);
	}
	
	public A sort() {
		A a= null;
		
		if (!contenu.isEmpty()) {
			a=contenu.get(0);
		
			for (A i : contenu)
				if (i.priorite()<a.priorite())
					a=i;
			
			contenu.remove(a);
		}
		
		return a;
	}
	
	public boolean estVide() {
		return contenu.isEmpty();
	}
	
	public String toString() {
		return ""+contenu;
	}
}
