package sat;

import java.util.ArrayList;
import java.util.Scanner;

public class Application
{
	public static void main(String[] args) throws Exception
	{
		KnowledgeBase k = new KnowledgeBase("Reunion");
		System.out.println(k);

		// Création de la BF saturée par chaînage avant
		System.out.println("Application du forward chaining");
		k.forwardChainingOpt();

		// Recherche d'un but (recherche dans BF saturée et chaînage arrière)
		Scanner sc = new Scanner(System.in);
		String input = "";
		Atom goal = null;
		boolean goodInput = false;
		
		while (true)
		{
			System.out.println("\nEntrez un but (ou quit pour quitter) :");
			input = sc.nextLine();
			
			if (input.equals("quit"))
				break;
			
			// Recherche de l'atome correspondant
			for (Atom currentFact : k.getAllAtoms())
			{
				if (currentFact.toString().equals(input))
				{
					goal = currentFact;
					goodInput = true;
					break;
				}
			}
			
			// Mauvais input utilisateur
			if (!goodInput)
			{
				System.out.println("Impossible de trouver ce fait dans la base de connaissances");
				continue;
			}
			
			// Recherche dans la BF saturée
			if (k.getSaturatedFactBase().belongsAtom(goal))
				System.out.println("Recherche dans la BF saturée : but prouvé");
			else
				System.out.println("Recherche dans la BF saturée : but non prouvé");
			
			// Recherche par chaînage arrière
			if (k.backwardChaining(goal, new ArrayList<Atom>()))
				System.out.println("Recherche par chaînage arrière : but prouvé");
			else
				System.out.println("Recherche par chaînage arrière : but non prouvé");
		}

		sc.close();
		System.out.println("Application fermée");
	}
}
