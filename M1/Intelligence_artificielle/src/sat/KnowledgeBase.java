package sat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class KnowledgeBase
{
	private FactBase initialFactBase; 		// Base de faits initiale
	private FactBase saturatedFactBase; 	// Base de faits saturée par la base de règles
	private RuleBase ruleBase; 				// Base de règles
	private ArrayList<Atom> alreadyProven;	// Liste des faits déjà prouvés par backwardChainingOpt
	private ArrayList<Atom> alreadyFailed;	// Liste des faits déjà réfutés par backwardChainingOpt

	// Constructeur par défaut
	public KnowledgeBase()
	{
		this.initialFactBase = new FactBase();
		this.saturatedFactBase = new FactBase();
		this.ruleBase = new RuleBase();
		this.alreadyProven = new ArrayList<Atom>();
		this.alreadyFailed = new ArrayList<Atom>();
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

		this.alreadyProven = new ArrayList<Atom>();
		this.alreadyFailed = new ArrayList<Atom>();
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

	public ArrayList<Atom> getAlreadyProven()
	{
		return this.alreadyProven;
	}

	public ArrayList<Atom> getAlreadyFailed()
	{
		return this.alreadyFailed;
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

	// Renvoie une map qui associe à chaque symbole la liste des règles où il apparait en hypotèse
	public HashMap<Atom,ArrayList<Rule>> getHypothesisMap()
	{
		HashMap<Atom, ArrayList<Rule>> result = new HashMap<Atom, ArrayList<Rule>>();

		for (Rule currentRule : this.getRuleBase().getRules())
			for (Atom currentFact : currentRule.getHypothesis())
			{
				ArrayList<Rule> ruleList = result.get(currentFact);

				if (ruleList == null) // Si la liste n'existe pas, on la crée
				{
					ruleList = new ArrayList<Rule>();
					ruleList.add(currentRule);
					result.put(currentFact, ruleList);
				}
				else // Sinon on ajoute l'élément
					ruleList.add(currentRule);
			}

		return result;
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
	@SuppressWarnings("unchecked")
	public void forwardChainingOpt()
	{
		ArrayList<Atom> newFacts = (ArrayList<Atom>) this.getInitialFactBase().getAtoms().clone();
		HashMap<Atom,ArrayList<Rule>> hypothesis = this.getHypothesisMap();

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
				if (hypothesis.get(currentFact) != null
						&& hypothesis.get(currentFact).contains(currentRule)) // Si la règle est concernée
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
	@SuppressWarnings("unchecked")
	public boolean backwardChaining(Atom goal, ArrayList<Atom> alreadyChecked)
	{
		if (this.initialFactBase.belongsAtom(goal))
			return true;

		for (Rule currentRule : this.ruleBase.getRules())
		{
			if (currentRule.getConclusion().equals(goal))
			{
				boolean belongs = false;

				for (Atom currentFact : currentRule.getHypothesis())
					if (alreadyChecked.contains(currentFact))
					{
						belongs = true;
						break;
					}

				if (belongs)  // Pour éviter les boucles infinies, si une des hypothèses a déjà été vérifiée
					continue; // On passe à la prochaine règle

				ArrayList<Atom> tempAlreadyChecked = (ArrayList<Atom>) alreadyChecked.clone();
				tempAlreadyChecked.add(goal);

				int i = 0;
				while (i < currentRule.getHypothesis().size()
						&& backwardChaining(currentRule.getHypothesis().get(i), tempAlreadyChecked))
					i++;

				if (i == currentRule.getHypothesis().size()) // On a prouvé toutes les hypothèses
					return true;
			}
		}

		return false; // Aucune des règles ne permettent de prouver le fait
	}

	// Prouver un but en montrant que toutes ses hypothèses sont vraies, version optimisée
	@SuppressWarnings("unchecked")
	public boolean backwardChainingOpt(Atom goal, ArrayList<Atom> alreadyChecked)
	{
		if (this.initialFactBase.belongsAtom(goal) || this.alreadyProven.contains(goal))
			return true;

		if (this.alreadyFailed.contains(goal))
			return false;

		for (Rule currentRule : this.ruleBase.getRules())
		{
			if (currentRule.getConclusion().equals(goal))
			{
				boolean belongs = false;

				for (Atom currentFact : currentRule.getHypothesis())
					if (alreadyChecked.contains(currentFact))
					{
						belongs = true;
						break;
					}

				if (belongs)  // Pour éviter les boucles infinies, si une des hypothèses a déjà été vérifiée
					continue; // On passe à la prochaine règle

				ArrayList<Atom> tempAlreadyChecked = (ArrayList<Atom>) alreadyChecked.clone();
				tempAlreadyChecked.add(goal);

				int i = 0;
				while (i < currentRule.getHypothesis().size()
						&& backwardChainingOpt(currentRule.getHypothesis().get(i), tempAlreadyChecked))
					i++;

				if (i == currentRule.getHypothesis().size()) // Si on a prouvé toutes les hypothèses
				{
					this.alreadyProven.add(goal);
					return true;
				}
			}
		}

		this.alreadyFailed.add(goal);
		return false; // Aucune des règles ne permettent de prouver le fait
	}
}
