package sat;

import java.util.ArrayList;
import java.util.Scanner;

public class DemoBC
{
	public static void main(String[] args) throws Exception
	{
		KnowledgeBase k = new KnowledgeBase("TP2_exo1");

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

			// Recherche par chaînage arrière
			k.clear();
			if (k.backwardChainingOpt(goal, new ArrayList<Atom>(), 0))
				System.out.println("But prouvé");
			else
				System.out.println("But impossible à prouver");
		}

		sc.close();
		System.out.println("Application fermée");
	}
}
