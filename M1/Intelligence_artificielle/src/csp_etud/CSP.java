package csp_etud;

import java.util.ArrayList;

/**
 * Solveur : permet de résoudre un problème de contrainte par Backtrack : 
 * 	Calcul d'une solution, 
 * 	Calcul de toutes les solutions
 */
public class CSP {

		private Network network; // Réseau à résoudre
		private ArrayList<Assignment> solutions; // Solutions du réseau (résultat de searchAllSolutions)
		private Assignment currentAssignment; // Assignation courante (résultat de searchSolution)
		int exploredNodes; // Compteur de noeuds explorés

		
		/**
		 * Crée un problème de résolution de contraintes pour un réseau donné
		 * 
		 * @param r le réseau de contraintes à résoudre
		 */
		public CSP(Network r) {
			network = r;
			solutions = new ArrayList<Assignment>();
			currentAssignment = new Assignment();

		}
		
		 
		/**
		 * Cherche une solution au réseau de contraintes
		 * 
		 * @return une assignation solution du réseau, ou null si pas de solution
		 */
		public Assignment searchSolution() {
			exploredNodes = 1;
			
			Assignment solution = backtrack();
			
			System.out.println(exploredNodes + " noeuds ont été explorés.");
			
			return solution;
		}

		
		/**
		 * Exécute l'algorithme de backtrack à la recherche d'une solution en étendant l'assignation courante
		 * Utilise l'attribut currentAssignment
		 * @return la prochaine solution ou null si pas de nouvelle solution
		 */
		private Assignment backtrack() {
			if (currentAssignment.size() == network.getVarNumber())
				return currentAssignment;
			
			String currentVar = chooseVar();
			
			ArrayList<Object> domaineTrie = tri(network.getDom(currentVar));
			
			for (Object val : domaineTrie) {
				currentAssignment.put(currentVar, val);
				exploredNodes++;
			
				if (consistant(currentVar)) {
					Assignment suite = backtrack();
					if (suite != null)
						return suite;
					else
						currentAssignment.remove(currentVar);
				}
				else
					currentAssignment.remove(currentVar);
			}
			
			return null;
		}
		
		
		/**
		 * Calcule toutes les solutions au réseau de contraintes
		 * 
		 * @return la liste des assignations solutions
		 * 
		 */
		public ArrayList<Assignment> searchAllSolutions() {
			solutions.clear();
			exploredNodes = 1;
			
			backtrackAll();
						
			System.out.println(exploredNodes + " noeuds ont été explorés.");			
			
			return solutions;
		}
		
		/**
		 * Exécute l'algorithme de backtrack à la recherche de toutes les solutions
		 * étendant l'assignation courante
		 */
		private void backtrackAll() {
			/*
			while (backtrack() != null) {
				solutions.add(currentAssignment);
			}
			*/
			
			if (currentAssignment.size() == network.getVarNumber()) {
				solutions.add(currentAssignment.clone());
				currentAssignment.clear();
			}
			
			String currentVar = chooseVar();
			
			ArrayList<Object> domaineTrie = tri(network.getDom(currentVar));
			
			for (Object val : domaineTrie) {
				currentAssignment.put(currentVar, val);
				exploredNodes++;
			
				if (consistant(currentVar)) {
					Assignment suite = backtrack();
					if (suite != null) {
						solutions.add(currentAssignment.clone());
						currentAssignment.clear();
					}
					else
						currentAssignment.remove(currentVar);
				}
				else
					currentAssignment.remove(currentVar);
			}
		}
    
  			
		/**
		 * Retourne la prochaine variable à assigner étant donné currentAssignment (qui doit contenir la solution partielle courante)
		 *  
		 * @return une variable non encore assignée, sinon null
		 */
		private String chooseVar() {
			ArrayList<String> varList = network.getVars();
			
			for (String var : varList)
				if (!currentAssignment.containsKey(var))
					return var;
			
		    return null;
		}
		
		
		/**
		 * Fixe un ordre de prise en compte des valeurs d'un domaine
		 * 
		 * @param values une liste de valeurs
		 * @return une liste de valeurs
		 */
		private ArrayList<Object> tri(ArrayList<Object> values) {
			// TODO Faire un vrai tri
			return values;
		}
		
		
		/**
		 * Teste si l'assignation courante stockée dans l'attribut currentAssignment est consistante, c'est à dire qu'elle
		 * ne viole aucune contrainte.
		 * 
		 * @param lastAssignedVar la variable que l'on vient d'assigner à cette étape
		 * @return vrai ssi l'assignment courante ne viole aucune contrainte
		 */
		private boolean consistant(String lastAssignedVar) {
			ArrayList<Constraint> contraintesConcernees = network.getConstraints(lastAssignedVar);
			
			for (Constraint c : contraintesConcernees)
				if (c.violation(currentAssignment))
					return false;
			
			return true;
		}
		
}
