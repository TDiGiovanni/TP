package csp_etud;

import java.io.BufferedReader;
import java.io.FileReader;

public class Application {

	public static void main(String[] args) throws Exception {
		String fileName = "Coloration.txt" ; // Nom du fichier
		System.out.println("Chargement du fichier : " +
							new java.io.File( "." ).getCanonicalPath() +
							"/" + fileName);
		BufferedReader readFile = new BufferedReader(new FileReader (fileName));
		Network myNetwork = new Network(readFile);
		readFile.close();
		System.out.println("Réseau récupéré : " + myNetwork);
		
		CSP myCSP = new CSP(myNetwork);
		System.out.println(myCSP.searchSolution());;
		//System.out.println(myCSP.searchAllSolutions());
	}

}
