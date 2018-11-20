package sat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class KnowledgeBase
{
	private FactBase initialFactBase; 	// Base de faits initiale
	private FactBase saturatedFactBase; // Base de faits saturée par la base de règles
	private RuleBase ruleBase; 			// Base de règles
	ArrayList<Atom> alreadyProven;
	ArrayList<Atom> alreadyFailed;

	// Constructeur par défaut
	public KnowledgeBase()
	{
		this.initialFactBase = new FactBase();
		this.saturatedFactBase = new FactBase();
		this.ruleBase = new RuleBase();
	}

	// Constructeur à partir d'un fichier texte
	public KnowledgeBase(String fileName) throws Exception
	{
		String path = "SAT/" + fileName + ".txt" ;
		System.out.println("Chargement du fichier : "
				+ new java.io.File(".").getCanonicalPath()
				+ "/" + path);
		BufferedReader readFile = new BufferedReader(new FileReader (path));

		// Création des bases de faits
		String line = readFile.readLine(); // Représentée par la première ligne du fichier
		this.initialFactBase = new FactBase(line);
		this.saturatedFactBase = new FactBase(line);

		// Création de la base de règles
		this.ruleBase = new RuleBase();		
		line = readFile.readLine();
		while (line != null && line.length() != 0) // Tant qu'on peut lire une règle (une ligne non vide)
		{
			this.ruleBase.addRule(new Rule(line)); // On l'ajoute à la base
			line = readFile.readLine();
		}

		readFile.close();
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

	// Renvoie une liste de tous les atomes de la base
	public ArrayList<Atom> getAllAtoms()
	{
		ArrayList<Atom> result = new ArrayList<Atom>();

		for (Atom currentFact : this.initialFactBase.getAtoms())
			result.add(currentFact);

		for (Rule currentRule : this.ruleBase.getRules())
		{
			for (Atom currentFact : currentRule.getHypothesis())
				if (!result.contains(currentFact))
					result.add(currentFact);

			if (!result.contains(currentRule.getConclusion()))
				result.add(currentRule.getConclusion());
		}

		return result;
	}

	@Override
	public String toString()
	{
		String result = "\nBF initiale : \n" + getInitialFactBase().toString() + "\n";
		result += "BF saturée : \n" + this.getSaturatedFactBase().toString() + "\n";
		result += "BR : \n" + this.getRuleBase().toString();

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
		boolean noNewFacts = false;

		ArrayList<Boolean> ruleApplied = new ArrayList<Boolean>();
		for (int i = 0; i < this.ruleBase.size(); i++)
			ruleApplied.add(false);

		while (!noNewFacts)
		{
			ArrayList<Atom> newFacts = new ArrayList<Atom>();
			for (int i = 0; i < this.ruleBase.size(); i++)
			{
				if (!ruleApplied.get(i)) // Si on n'a pas déjà appliqué la règle
				{
					Rule currentRule = this.ruleBase.getRule(i);
					if (this.saturatedFactBase.getAtoms().containsAll(currentRule.getHypothesis())) // Si la règle est applicable
					{
						ruleApplied.set(i, true);
						if (!this.saturatedFactBase.getAtoms().contains(currentRule.getConclusion())
								&& !newFacts.contains(currentRule.getConclusion())) // Si la règle est utile
							newFacts.add(currentRule.getConclusion());
					}
				}
			}

			if (newFacts.isEmpty())
				noNewFacts = true;
			else
			{
				this.saturatedFactBase.addAtoms(newFacts);
				newFacts.clear();
			}
		}
	}


	// Crée la base de faits saturée à partir de la base de règles, version optimisée
	public void forwardChainingOpt()
	{
		ArrayList<Atom> newFacts = this.initialFactBase.getAtoms();

		ArrayList<Integer> count = new ArrayList<Integer>();
		for (int i = 0; i < this.ruleBase.size(); i++)
			count.add(this.ruleBase.getRule(i).getHypothesis().size()); // Nombre de littéraux dans l'hypothèse

		while (!newFacts.isEmpty())
		{
			Atom currentFact = newFacts.get(0);
			newFacts.remove(0);

			for (int i = 0; i < this.ruleBase.size(); i++)
			{
				Rule currentRule = this.ruleBase.getRule(i);
				if (currentRule.getHypothesis().contains(currentFact)) // Si la règle contient le currentFact
				{
					count.set(i, count.get(i) - 1); // On décrémente le compteur
					if (count.get(i) == 0) // Si la règle est applicable
					{
						if (!this.saturatedFactBase.getAtoms().contains(currentRule.getConclusion())
								&& !newFacts.contains(currentRule.getConclusion())) // Si la règle est utile
						{
							newFacts.add(currentRule.getConclusion());
							this.saturatedFactBase.addAtomWithoutCheck(currentRule.getConclusion());
						}
					}
				}
			}
		}
	}

	// Prouver un but en montrant que toutes ses hypothèses sont vraies
	public boolean backwardChaining(Atom goal, ArrayList<Atom> alreadyChecked)
	{
		if (this.initialFactBase.belongsAtom(goal))
			return true;

		for (Rule currentRule : this.ruleBase.getRules())
			if (currentRule.getConclusion().equals(goal))
			{
				for (Atom currentFact : currentRule.getHypothesis())
				{
					if (alreadyChecked.contains(currentFact)) // Pour éviter les boucles infinies
						break; 								  // On passe à la prochaine règle si une des hypothèses a déjà été vérifiée

					int factsProven = 0;
					alreadyChecked.add(goal);
					while (factsProven < currentRule.getHypothesis().size() && backwardChaining(currentFact, alreadyChecked))
						factsProven++;

					if (factsProven == currentRule.getHypothesis().size()) // On a prouvé toutes les hypothèses
						return true;
				}
			}

		return false; // Aucune des règles ne permettent de prouver le fait
	}

	// Prouver un but en montrant que toutes ses hypothèses sont vraies, version optimisée
	public boolean backwardChainingOpt(Atom goal)
	{
		return false;
	}
}
