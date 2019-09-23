package stockage;

import java.util.ArrayList;
import java.util.Collection;

// Classe représentant un dossier
public class Directory extends ElementStockage
{
	// Pour la cohérence interne du dossier, il est fondamental que la collection
	// de ses éléments soit inaccessible aux clients.
	protected Collection<ElementStockage> elements;
	
	public Directory(String nom)
	{
		super(nom, 4);
		elements = new ArrayList<ElementStockage>();
	}
	
	// Somme des tailles des différents éléments présents dans ce dossier
	public int size()
	{
		int somme = basicSize;
		
		for (ElementStockage s : elements)
		{
			somme = somme + s.size();
		}
		
		return somme;
	}
	
	// Affiche  l'écran la liste des éléments qu'il contient
	public void ls()
	{
		for (ElementStockage s : elements)
		{
			System.out.println(s.name);
		}
	}
	
	// Retourne le nombre d'éléments du dossier
	public int nbElm()
	{
		return elements.size();
	}
	
	public int getCount()
	{
		int count = 0;
		
		for (ElementStockage s : elements)
		{
			count = count + 1 + s.getCount();
		}
		
		return count;
	}
	
	// Ajoute l'élément 'e' dans le dossier
	public boolean add(ElementStockage e)
	{
		e.nouveauParent(this);	// Le répertoire courant devient le père de l'élément 'e'
		return elements.add(e); // Ajout de l'élément 'e' à la collection
	}
	
	// Supprime et retourne vrai si la suppression de l'élément 'e' s'est bien passé, faux sinon ('e' non présent ou erreur)
	public boolean remove(ElementStockage e)
	{
		for (ElementStockage s : elements)
		{
			if (s.name == e.name)
				return elements.remove(s); // Suppression de l'élément 'e' dans la collection
		}
			
		return false;
	}
	
	public boolean includes(ElementStockage e)
	{
		return elements.contains(e);
	}
	
	// Rend l'element de nom "nom" s'il existe (sinon retourne null)
	public ElementStockage findElement(String nom)
	{
		for (ElementStockage s : elements)
		{
			if (s.name.equals(nom))
				return s;
		}
		
		return null;
	}
	
	// Rend la collection des adresses absolues de nom "nom" que le répertoire contient
	public ArrayList<String> find(String nom)
	{
		ArrayList<String> collection = new ArrayList<String>();
			
		for (ElementStockage s : elements)
		{
			if (s.name.equals(nom))
				collection.add(s.absoluteAdress());
		}
			
		return collection;
	}
	
	// Rend la collection des adresses absolues de nom "nom" que 
	// le répertoire contient directement ou par transitivité
	public ArrayList<String> findR(String nom)
	{
		ArrayList<String> collection = new ArrayList<String>();
		ArrayList<String> temporaire ; // Collection temporaire servant  stocker les adresses absolues obtenues par transitivité
			
		for (ElementStockage s : elements)
		{
			if (s.name == nom)
				collection.add(s.absoluteAdress());
			
			if (s instanceof Directory) // Si l'élément de stockage est un dossier, lance la recherche sur s (appel récursif)
			{
				temporaire = ((Directory) s).findR(nom);
			
				for (String es : temporaire)
					collection.add(es);
			}
		}
		return collection;
	}

	// Affiche le contenu de la collection "liste"
	public void afficheCollection(ArrayList<String> liste)
	{
		for (String s : liste)
			System.out.println(s);
	}
}
	
	
	
	
	
	

