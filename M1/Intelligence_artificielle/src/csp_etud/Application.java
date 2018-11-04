package csp_etud;

import java.io.BufferedReader;
import java.io.FileReader;

public class Application {

	public static void main(String[] args) throws Exception {
		String fileName = "CSP/4reinesExp.txt" ; // Nom du fichier à récupérer ici
		System.out.println("Chargement du fichier : " +
							new java.io.File( "." ).getCanonicalPath() +
							"/" + fileName);
		BufferedReader readFile = new BufferedReader(new FileReader (fileName));
		Network myNetwork = new Network(readFile);
		readFile.close();
		System.out.println("Réseau récupéré : \n" + myNetwork);
		
		CSP myCSP = new CSP(myNetwork);
		
		System.out.println("\nRecherche d'une solution...");
		System.out.println(myCSP.searchSolution());
		
		System.out.println("\nRecherche de toutes les solutions...");
		System.out.println(myCSP.searchAllSolutions());
	}

}
