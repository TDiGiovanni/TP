package exo1;

import java.util.LinkedList;

public class Pile<A> implements iPile<A> {
	private LinkedList<A> chaine = new LinkedList<A>();
	
	@Override
	public boolean estVide() {
		return chaine.isEmpty();
	}

	@Override
	public void empile(A a) {
		chaine.add(a);
	}

	@Override
	public A depile() {
		return chaine.removeLast();
	}

	@Override
	public int nbElems() {
		return chaine.size();
	}

	@Override
	public A sommet() {
		return chaine.getLast();
	}
	
	@Override
	public String toString() {
		if (estVide())
			return "La pile est vide.";
		
		String s="";
		
		for (int i=0; i<nbElems()-1; i++)
			s+=chaine.get(i)+"-";
		s+=chaine.get(nbElems()-1);
		
		return s;
	}
}
