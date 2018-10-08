package exo2_3;

import java.util.Iterator;

public class IterateurFeuilleSalaire implements Iterator<Object> {
	private Object[] champsFeuille= new Object[6];
	private int currentChamp;
	
	public IterateurFeuilleSalaire(Object[] champsFeuille) {
		this.champsFeuille= champsFeuille;
		this.currentChamp= 0;
	}
	
	@Override
	public boolean hasNext() {
		if (currentChamp<champsFeuille.length)
			return true;
		else
			return false;
	}

	@Override
	public Object next() {
		Object o= champsFeuille[currentChamp];
		
		currentChamp++;
		
		return o;
	}

}
