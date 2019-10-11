package stockage;

import visitors.Visitor;

// Classe abstraite correspondant a tout element de stockage memoire
public abstract class ElementStockage 
{
	protected String name; 		// Nom
	protected int basicSize;	// Espace de base qu'il occupe en memoire
	protected Directory parent; // Dossier parent 
	
	public ElementStockage(String nom, int t)
	{
		name = nom;
		basicSize = t;
		parent = null;
	}
	
	public ElementStockage(String nom, int t, Directory d)
	{
		name = nom;
		basicSize = t;
		parent = d;
	}
	
	public String toString()
	{
		return this.getClass().getName() + " " + this.name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public Directory getParent()
	{
		return parent;
	}

	// Méthode abstraite car specifique aux differentes parametrisations 
	// (retourne la taille de l'element de stockage)
	public abstract int size(); 

	// Retourne l'adresse absolue de l'element
	public String absoluteAdress()
	{
		if (parent != null) // S'il a un parent
			return (parent.absoluteAdress() + "/" + name);
		else
			return (name); // Ici on est a la racine, on suppose que son nom est racine
	}
	
	public void nouveauParent(Directory d)
	// 'd' devient le nouveau parent de l'element de stockage
	{
		parent = d;
	}
	
	// Retourne la taille en bits de l'element
	public int bitSize()
	{
		return this.size() * 8;
	}
	
	public int getCount()
	{
		return 0;
	}
	
	public abstract void accept(Visitor v);
}
