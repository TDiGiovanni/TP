package dico;

public class SortedDictionary extends AbstractDictionary {
	// Constructeurs
	public SortedDictionary() {
		keys = new Object[10];
		values = new Object[10];
	}

	public SortedDictionary(int size) {
		keys = new Object[size];
		values = new Object[size];
	}
	
	// Renvoie l'index auquel est rangé k, -1 s'il n'existe pas
	public int indexOf(Object k) {
		int index = keys.length / 2;
		
		while (index > 0 && index < keys.length) {
			if (keys[index].compareTo(k) == 0)
				return index;
			
			if (keys[index].compareTo(k) < 0)
				index = (index + keys.length) / 2;
			
			else
				index = index / 2;
		}
		
		if (keys[0].equals(k))
			return 0;
		
		return -1;
	}

	// Renvoie l'index où la nouvelle valeur doit être rangée
	public int newIndexOf(Object k) {
		if (indexOf(k) != -1)
			return indexOf(k);
		
		for (int i = 0; i < keys.length; i++)
			if (keys[i].compareTo(k) > 0)
				return i;
		
		grow();
		
		return keys.length - 1;
	}

	// Agrandit le dictionnaire
	public void grow() {
		Object[] tempKeys = keys.clone();
		keys = new Object[tempKeys.length + 1];
		
		Object[] tempValues = values.clone();
		values = new Object[tempValues.length + 1];
		
		for (int i = 0; i < tempKeys.length; i++) {
			keys[i] = tempKeys[i];
			values[i] = tempValues[i];
		}
	}

}
