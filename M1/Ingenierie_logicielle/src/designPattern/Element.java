package designPattern;

public abstract class Element {
	protected String name; // Nom de l'élément
	protected Container fatherContainer; // Conteneur de l'élément
	protected int basicSize; // Taille de l'élément (lorsqu'il est vide)
	
	// Renvoie la taille de l'élément
	public abstract int size();
	
	// Renvoie l'adresse absolue de l'élément (sous forme de chaine de caractères)
	public String absoluteAddress() {
		if (fatherContainer == null)
			return "/" + this.name;
		
		return fatherContainer.absoluteAddress() + "/" + this.name;
	}
	
	// Affiche l'élément
	public abstract void print();
}
