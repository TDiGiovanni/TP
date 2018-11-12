package sat;

import java.util.ArrayList;

public class RuleBase
{
	private ArrayList<Rule> rules; // Ensemble des règles

	/**
	 * Constructeur : cree une base de règles vide
	 */
	public RuleBase()
	{
		rules = new ArrayList<Rule>();
	}

	/**
	 * Ajoute une regle à la base de règles (sans verifier si elle y est déjà)
	 * @param r regle a ajouter
	 */
	public void addRule(Rule r)
	{
		rules.add(r);
	}
	
	/**
	 * Retourne le nombre de regles
	 * @return le nombre de regles dans la base
	 */
	public int size()
	{ 
		return rules.size();
	}
	
	/**
	 * Teste si la base est vide
	 * @return vrai si la base est vide
	 */
	public boolean isEmpty() 
	{
		return rules.isEmpty();
	}
	
	/**
	 * Retourne la règle de rang i
	 * @param i le rang de la règle (débute à 0)
	 * @return la règle de rang i
	 */
	public Rule getRule(int i)
	{
		return rules.get(i);
	}
	
	/**
	 * Retourne une description de la base de règles
	 * @return description de la base de faits
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String s = "La base contient " + rules.size() + " règles : \n";
		
		for (int i = 0; i < rules.size(); i++)
			s += "\t R" + (i+1) + " : " + rules.get(i) + "\n";	
		
		return s;
	}
}
