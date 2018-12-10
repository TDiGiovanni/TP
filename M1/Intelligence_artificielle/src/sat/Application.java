package sat;

import java.util.ArrayList;
import java.util.Scanner;

public class Application
{
	public static void main(String[] args) throws Exception
	{
		KnowledgeBase k = new KnowledgeBase("Reunion");
		System.out.println(k);

		// Création de la BF saturée par chaînage avant et affichage
		System.out.println("Application du forward chaining");
		k.forwardChainingOpt();
		k.printSaturatedFactBase();

		// Recherche infinie de buts à prouver (recherche dans BF saturée et par chaînage arrière)
		Scanner sc = new Scanner(System.in);
		String input = ""; 							// Input de l'utilisateur
		Atom goal = null; 							// Résultat à prouver
		ArrayList<Atom> allAtoms = k.getAllAtoms(); // Liste de tous les atomes
		boolean goodInput = false; 					// True si l'input correspond à un atome existant, false sinon
		
		while (true)
		{
			System.out.println("\nEntrez un atome à prouver (ou quit pour quitter) :");
			input = sc.nextLine();
			
			if (input.equals("quit"))
				break;
			
			// Recherche de l'atome correspondant
			for (Atom currentFact : allAtoms)
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
				System.out.println("Recherche dans la BF saturée : atome trouvé");
			else
				System.out.println("Recherche dans la BF saturée : atome impossible à trouver");
			
			// Recherche par chaînage arrière
			if (k.backwardChainingOpt(goal, new ArrayList<Atom>()))
				System.out.println("Recherche par chaînage arrière : but prouvé");
			else
				System.out.println("Recherche par chaînage arrière : but impossible à prouver");
		}

		sc.close();
		System.out.println("Application fermée");
	}
}
