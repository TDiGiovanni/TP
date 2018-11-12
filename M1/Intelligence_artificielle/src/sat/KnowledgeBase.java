package sat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class KnowledgeBase
{
	private FactBase initialFactBase;
	private RuleBase ruleBase;
	private FactBase saturatedFactBase;
	
	// Constructeur par défaut
	public KnowledgeBase()
	{
		this.initialFactBase = new FactBase();
		this.ruleBase = new RuleBase();
		this.saturatedFactBase = new FactBase();
	}
	
	// Constructeur à partir d'un fichier texte
	public KnowledgeBase(String fileName) throws Exception
	{
		String path = "SAT/" + fileName + ".txt" ;
		System.out.println("Chargement du fichier : "
							+ new java.io.File(".").getCanonicalPath()
							+ "/" + path);
		BufferedReader readFile = new BufferedReader(new FileReader (path));
		
		// Création de la base de faits initiale
		String line = readFile.readLine(); // Représentée par la première ligne du fichier
		this.initialFactBase = new FactBase(line);
		
		// Création de la base de règles
		this.ruleBase = new RuleBase();		
		line = readFile.readLine();
		while (line != null && line.length() != 0) // Tant qu'on peut lire une règle (une ligne non vide)
		{
			this.ruleBase.addRule(new Rule(line)); // On l'ajoute à la base
			line = readFile.readLine();
		}
		
		readFile.close();
		
		// Création de la base de faits saturée
		this.saturatedFactBase = new FactBase();
	}
	
	// Accesseurs en lecture
	public FactBase getInitialFactBase()
	{
		return this.initialFactBase;
	}
	
	public RuleBase getRuleBase()
	{
		return this.ruleBase;
	}
	
	public FactBase getSaturatedFactBase()
	{
		return this.saturatedFactBase;
	}
	
	@Override
	public String toString()
	{
		String result = "\nBF initiale : \n" + getInitialFactBase().toString() + "\n";
		result += "BR : \n" + this.getRuleBase().toString() + "\n";
		result += "BF saturée : \n" + this.getSaturatedFactBase().toString();
		
		return result;
	}
	
	// Affiche la base de faits saturée seulement
	public void printSaturatedFactBase()
	{
		System.out.println("\nBF saturée : " + this.saturatedFactBase.toString());
	}
	
	// Crée la base de faits saturée à partir de la base de règles, version naïve
	public void forwardChaining()
	{
		boolean end = false;
		
		ArrayList<Boolean> ruleApplied = new ArrayList<Boolean>();
		for (int i = 0; i < this.ruleBase.size(); i++)
			ruleApplied.add(false);
		
		while (!end)
		{
			ArrayList<Atom> newFacts = new ArrayList<Atom>();
			for (int i = 0; i < this.ruleBase.size(); i++)
			{
				if (!ruleApplied.get(i)) // Si on n'a pas déjà appliqué la règle
				{
					Rule currentRule = this.ruleBase.getRule(i);
					if (this.initialFactBase.getAtoms().containsAll(currentRule.getHypothesis())) // Si la règle est applicable
					{
						ruleApplied.set(i, true);
						if (!this.initialFactBase.getAtoms().contains(currentRule.getConclusion())
								&& !newFacts.contains(currentRule.getConclusion())) // Si la règle est utile
							newFacts.add(currentRule.getConclusion());
					}
				}
			}
			
			if (newFacts.isEmpty())
				end = true;
			else
				this.initialFactBase.addAtoms(newFacts);
		}
	}
	
	
	// Crée la base de faits saturée à partir de la base de règles, version optimisée
	public void forwardChainingOpt()
	{
		//TODO
	}
}
