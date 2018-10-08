package dico;

public interface IDictionary {	
	// Renvoie la valeur correspondante à la clé k
	Object get(Object k);
	
	// Ajoute une entrée au dictionnaire
	void put(Object k, Object v);
	
	// Teste si le dictionnaire est vide
	boolean isEmpty();
	
	// Teste si le dictionnaire contient déjà la clé
	boolean containsKey(Object k);
}
