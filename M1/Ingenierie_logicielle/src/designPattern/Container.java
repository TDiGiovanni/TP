package designPattern;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Container extends Element {
	protected Collection<Element> content; // Contenu du conteneur
	
	@Override
	public int size() {
		int sum = 0;
		
		for (Element e : content)
			sum += e.size();
		
		return sum + basicSize;
	}
	
	@Override
	public void print() {
		for (Element e : content)
			System.out.print(e.name + " ");
	}

	// Renvoie le nombre d'éléments dans le conteneur
	public int nbElem() {
		return content.size();
	}

	// Rend la collection d'adresses absolues des éléments de nom "name"
	public Collection<String> find(String name) {
		Collection<String> addresses = new ArrayList<String>();
		
		for (Element e : content)
			if (e.name.equals(name))
				addresses.add(e.absoluteAddress());
		
		return addresses;
	}

	// Rend la collection d'adresses absolues des éléments de nom "name" (version récursive)
	public Collection<String> findR(String name) {
		Collection<String> addresses = new ArrayList<String>();
		
		for (Element e : content) {
			if (e.name.equals(name))
				addresses.add(e.absoluteAddress());
			
			if (e.basicSize == 4)
				((Container) e).findR(name);
		}
		
		return addresses;
	}
}
