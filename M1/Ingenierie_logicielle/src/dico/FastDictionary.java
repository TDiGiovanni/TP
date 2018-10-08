package dico;

public class FastDictionary extends AbstractDictionary {
	// Constructeurs
	public FastDictionary() {
		keys = new Object[10];
		values = new Object[10];
	}

	public FastDictionary(int size) {
		keys = new Object[size];
		values = new Object[size];
	}
	
	// Renvoie l'index auquel est rangé k, -1 s'il n'existe pas
	public int indexOf(Object k) {
		int index = k.hashCode() % keys.length;
		 
		 do {
			 if (keys[index] != null && keys[index].equals(k))
				 return index;
			 
			 if (index == keys.length-1)
				 index = 0;
			 else
				 index++;
			 
		 } while (index != k.hashCode() % keys.length);
		 
		 return -1;
	}

	// Renvoie l'index où la nouvelle valeur doit être rangée
	public int newIndexOf(Object k) {
		if (indexOf(k) != -1)
			return indexOf(k);
		
		if (mustGrow())
			grow();
		
		int index = k.hashCode() % keys.length;
		
		while (keys[index] != null) {
			if (index == keys.length-1)
				index = 0;
			else
				index++;
		}
		
		return index;
	}
	
	// Renvoie le nombre d'éléments dans le dictionnaire
	public double size() {
		double s = 0;
		
		for (int i = 0; i < keys.length; i++)
			if (keys[i] != null)
				s++;
		
		return s;
	}
	
	// Vérifie si le dictionnaire doit être agrandi
	public boolean mustGrow() {
		if (size()/(double)keys.length >= 0.75)
			return true;
		
		return false;
	}
	
	// Agrandit le dictionnaire
	public void grow() {
		Object[] tempKeys = keys.clone();
		keys = new Object[tempKeys.length*2 +1];
		
		Object[] tempValues = values.clone();
		values = new Object[tempValues.length*2 +1];
		
		for (int i = 0; i < tempKeys.length; i++) {
			keys[i] = tempKeys[i];
			values[i] = tempValues[i];
		}
	}
	
}
