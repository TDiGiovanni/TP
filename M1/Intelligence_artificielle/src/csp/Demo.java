package csp;

import java.io.BufferedReader;
import java.io.FileReader;

public class Demo {
	
	public static void main(String[] args) throws Exception {
		// CSP1
		String fileName = "CSP/Evaluation/csp1.txt" ;
		BufferedReader readFile = new BufferedReader(new FileReader (fileName));
		
		Network networkCSP1 = new Network(readFile);
		CSP CSP1 = new CSP(networkCSP1);
		
		System.out.println("Problème csp1");
		
		System.out.println("searchSol : ");
		System.out.println(CSP1.searchSolution());
		
		System.out.println("searchAllSol : ");
		System.out.println(CSP1.searchAllSolutions());
		
		// CSP2
		fileName = "CSP/Evaluation/csp2.txt" ;
		readFile = new BufferedReader(new FileReader (fileName));
		
		Network networkCSP2 = new Network(readFile);
		CSP CSP2 = new CSP(networkCSP2);
		
		System.out.println("\nProblème csp2");
		
		System.out.println("searchSol : ");
		System.out.println(CSP2.searchSolution());
		
		System.out.println("searchAllSol : ");
		System.out.println(CSP2.searchAllSolutions());
		
		// 5Reines
		fileName = "CSP/Evaluation/5reines.txt" ;
		readFile = new BufferedReader(new FileReader (fileName));
		
		Network network5reines = new Network(readFile);
		CSP CSP5reines = new CSP(network5reines);
		
		System.out.println("\nProblème 5reines");
		
		System.out.println("searchSol : ");
		System.out.println(CSP5reines.searchSolution());
		
		System.out.println("searchAllSol : ");
		System.out.println(CSP5reines.searchAllSolutions());
		
		// 8Reines
		fileName = "CSP/Evaluation/8reines.txt" ;
		readFile = new BufferedReader(new FileReader (fileName));
		
		Network network8reines = new Network(readFile);
		CSP CSP8reines = new CSP(network8reines);
		
		System.out.println("\nProblème 8reines");
		
		System.out.println("searchSol : ");
		System.out.println(CSP8reines.searchSolution());
		
		System.out.println("searchAllSol : ");
		System.out.println(CSP8reines.searchAllSolutions());
		
		// Colore
		fileName = "CSP/Evaluation/colore.txt" ;
		readFile = new BufferedReader(new FileReader (fileName));

		Network networkColore = new Network(readFile);
		CSP CSPColore = new CSP(networkColore);

		System.out.println("\nProblème colore");

		System.out.println("searchSol : ");
		System.out.println(CSPColore.searchSolution());

		System.out.println("searchAllSol : ");
		System.out.println(CSPColore.searchAllSolutions());
		
		// 5ReinesExp
		fileName = "CSP/Evaluation/5reinesExp.txt" ;
		readFile = new BufferedReader(new FileReader (fileName));
		
		Network network5ReinesExp = new Network(readFile);
		CSP CSP5ReinesExp = new CSP(network5ReinesExp);
		
		System.out.println("\nProblème 5reinesExp");
		
		System.out.println("searchSol : ");
		System.out.println(CSP5ReinesExp.searchSolution());
		
		System.out.println("searchAllSol : ");
		System.out.println(CSP5ReinesExp.searchAllSolutions());
		
		// CryptoMoney
		fileName = "CSP/Evaluation/cryptoMoney.txt" ;
		readFile = new BufferedReader(new FileReader (fileName));
		
		Network networkCryptoMoney = new Network(readFile);
		CSP CSPCryptoMoney = new CSP(networkCryptoMoney);
		
		System.out.println("\nProblème cryptoMoney");
		
		System.out.println("searchSol : ");
		System.out.println(CSPCryptoMoney.searchSolution());
		
		System.out.println("searchAllSol : ");
		System.out.println(CSPCryptoMoney.searchAllSolutions());
		
		// CryptoMoneyIntension
		fileName = "CSP/Evaluation/cryptoMoneyIntension.txt" ;
		readFile = new BufferedReader(new FileReader (fileName));
		
		Network networkCryptoMoneyInt = new Network(readFile);
		CSP CSPCryptoMoneyInt = new CSP(networkCryptoMoneyInt);
		
		System.out.println("\nProblème cryptoMoneyIntension");
		
		System.out.println("searchSol : ");
		System.out.println(CSPCryptoMoneyInt.searchSolution());
		
		readFile.close();
	}
	
}
