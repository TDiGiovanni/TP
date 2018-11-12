package sat;

import java.util.*;

public class FactBase
{
	private ArrayList<Atom> atoms; // Ensemble des atomes
	
	/**
	 * Constructeur : cree une base de faits vide
	 */
	public FactBase()
	{
		atoms = new ArrayList<Atom>();
	}
	
	/**
	 * Constructeur : initialise avec une chaine de caractères correspondant à des atomes
	 * @param factList : les faits, passés sous la forme "atom1;...;atomk"
	 */
	public FactBase(String factList)
	{
		this(); // appel au constructeur sans paramètres
		createFactBase(factList);	
	}
	
	/**
	 * Remplit la base de faits avec la chaine de caractères passée en paramètre
	 * @param factList: les faits, passés sous la forme "atom1;...;atomk"
	 */
	private void createFactBase(String factList)
	// Prérequis : le format de la base de faits est supposé correct
   	{
   		StringTokenizer st = new StringTokenizer(factList,";");
   		while(st.hasMoreTokens())
   		{
   			String s = st.nextToken(); // 's' représente un atome
   			Atom a = new Atom(s);
   			atoms.add(a);// On ajoute un atome a la liste des atomes
   		}
   	}

	/**
	 * Ajoute des atomes à la base de faits s'ils n'apparaissent pas déjà
	 * @param atomList la liste d'atomes à ajouter (seuls ceux n'apparaissant pas dans la base seront ajoutés)
	 */
	public void addAtoms(ArrayList<Atom> atomList)
	{
		for(int i = 0; i < atomList.size(); i++)
		{
			Atom a = atomList.get(i);
			
			if (!belongsAtom(a))
				addAtomWithoutCheck(a);
		}
	}
	
	/**
	 * Ajoute un atome à la base de faits (meme s'il y est déjà) 
	 * @param a l'atome à ajouter 
	 */
	public void addAtomWithoutCheck(Atom a)
	{
		atoms.add(a);
	}

	/**
	 * Retourne la liste des atomes de la base de faits
	 * @return la liste des atomes de la base de faits
	 */
	public ArrayList<Atom> getAtoms() 
	{
		return atoms;
	}
	
	/**
	 * teste si la base est vide
	 * @return vrai si la base est vide
	 */
	public boolean isEmpty() 
	{
		return atoms.isEmpty();
	}
	
	/**
	 * retourne le nombre de faits dans la base
	 * @return le nombre de faits dans la base
	 */
	public int size()
	{
		return atoms.size();
	}	
	
	/**
	 * Teste l'appartenance d'un atome à la base de faits
	 * @param a l'atome dont on teste l'existence
	 * @return vrai si l'atome existe déjà, faux sinon
	 */
	public boolean belongsAtom(Atom a)
	{
		for (int i = 0; i < atoms.size(); i++)
			if (atoms.get(i).equals(a))
				return true;
		
		return false;
	}
	
	/**
	 * Retourne une description de la base de faits
	 * @return description de la base de faits
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String s = "";
		
		if (atoms.size() == 0)
			s = "La base de faits est vide !";
		else
		{
			s = "La base contient "+atoms.size()+ " faits : \n";
			
			for (int i = 0; i < atoms.size()-1; i++)
				s += atoms.get(i) + " ; ";	
			
			s += atoms.get(atoms.size()-1) + "\n";
		}
		
		return s;
	}
}
	