package stockage;

import java.util.ArrayList;
import java.util.Collection;

import visitors.Visitor;

// Classe representant un dossier
public class Directory extends ElementStockage
{
	protected Collection<ElementStockage> elements; // Pour la coherence interne du dossier,
													// il est fondamental que la collection de ses elements soit inaccessible aux clients
	
	public Directory(String nom)
	{
		super(nom, 4);
		elements = new ArrayList<ElementStockage>();
	}
	
	// Somme des tailles des differents elements presents dans ce dossier
	public int size()
	{
		int somme = basicSize;
		
		for (ElementStockage s : elements)
		{
			somme = somme + s.size();
		}
		
		return somme;
	}
	
	// Affiche l'ecran la liste des elements qu'il contient
	public void ls()
	{
		for (ElementStockage s : elements)
		{
			System.out.println(s.name);
		}
	}
	
	// Retourne le nombre d'elements du dossier
	public int numberOfElements()
	{
		return elements.size();
	}
	
	public int getCount()
	{
		int count = 0;
		
		for (ElementStockage element : elements)
			count += 1 + element.getCount();
		
		return count;
	}
	
	// Ajoute l'element 'e' dans le dossier
	public boolean add(ElementStockage e)
	{
		e.nouveauParent(this);	// Le repertoire courant devient le pere de l'element 'e'
		return elements.add(e); // Ajout de l'element 'e' a la collection
	}
	
	// Supprime et retourne vrai si la suppression de l'élément 'e' s'est bien passé, faux sinon ('e' non present ou erreur)
	public boolean remove(ElementStockage e)
	{
		for (ElementStockage s : elements)
		{
			if (s.name == e.name)
				return elements.remove(s); // Suppression de l'element 'e' dans la collection
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
	
	// Rend la collection des adresses absolues de nom "nom" que le repertoire contient
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
	// le repertoire contient directement ou par transitivite
	public ArrayList<String> findR(String nom)
	{
		ArrayList<String> collection = new ArrayList<String>();
		ArrayList<String> temporaire ; // Collection temporaire servant  stocker les adresses absolues obtenues par transitivite
			
		for (ElementStockage s : elements)
		{
			if (s.name == nom)
				collection.add(s.absoluteAdress());
			
			if (s instanceof Directory) // Si l'element de stockage est un dossier, lance la recherche sur 's' (appel recursif)
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

	public void accept(Visitor v)
	{
		for (ElementStockage element : elements)
			element.accept(v); // Recursive call on all the elements in the directory
		
		v.visit(this);
	}
}
	
	
	
	
	
	

