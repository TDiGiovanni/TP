package dico;

public class OrderedDictionary extends AbstractDictionary {
	// Constructeurs
	public OrderedDictionary() {
		keys = new Object[0];
		values = new Object[0];
	}

	public OrderedDictionary(int size) {
		keys = new Object[size];
		values = new Object[size];
	}
	
	// Renvoie l'index auquel est rangé k, -1 s'il n'existe pas
	public int indexOf(Object k) {
		for (int i = 0; i < keys.length; i++)
			if (keys[i] != null && keys[i].equals(k))
				return i;
		
		return -1;
	}

	// Renvoie l'index où la nouvelle valeur doit être rangée
	public int newIndexOf(Object k) {
		if (indexOf(k) != -1)
			return indexOf(k);
		
		int cell = firstEmptyCell();
		if (cell == -1) {
			grow();
			return keys.length - 1;
		}
		else
			return cell;
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
	
	public int firstEmptyCell() {
		for (int i = 0; i < keys.length; i++)
			if (keys[i] == null)
				return i;
		
		return -1;
	}
	
}
