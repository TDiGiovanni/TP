package dico;

public abstract class AbstractDictionary implements IDictionary {
	// Tableau des clés
	protected Object[] keys;
	
	// Tableau des valeurs
	protected Object[] values;

	// Renvoie la valeur de la clé k
	public Object get(Object k) {
		int i = indexOf(k);
		
		if (i == -1)
			return null;
		
		return values[i];
	}
	
	// Ajoute une nouvelle valeur au dictionnaire
	public void put(Object k, Object v) {
		int i = indexOf(k);
		
		if (i == -1) {
			int j = newIndexOf(k);
			keys[j] = k;
			values[j] = v;
		}
		
		else values[i] = v;
	}
	
	// Vérifie si le dictionnaire est vide
	public boolean isEmpty() {
		for (int i = 0; i < keys.length; i++)
			if (keys[i] != null)
				return false;
		
		return true;
	}
	
	// Vérifie si la clé est déjà présente dans le dictionnaire
	public boolean containsKey(Object k) {
		for (int i = 0; i < keys.length; i++)
			if (keys[i] != null && keys[i].equals(k))
				return true;
		
		return false;
	}
	
	// Renvoie l'index auquel est rangé k, -1 s'il n'existe pas
	public abstract int indexOf(Object k);
	
	// Renvoie l'index où la nouvelle valeur doit être rangée
	public abstract int newIndexOf(Object k);
}
