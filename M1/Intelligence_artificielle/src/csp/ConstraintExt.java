package csp;

import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * Pour manipuler des contraintes en extension
 *
 */
public class ConstraintExt extends Constraint{
	
	private ArrayList<ArrayList<Object>> tuples; // Ensemble des tuples de la contrainte
	
	/**
	 * Construit une contrainte d'extension vide à partir
	 * d'une liste de variables
	 * 
	 * @param var la liste de variables
	 */
	public ConstraintExt(ArrayList<String> var) {
		super(var);
		tuples = new ArrayList<ArrayList<Object>>();
	}
	
	/**
	 * Construit une contrainte d'extension vide à partir
	 * d'une liste de variables et d'un nom
	 * 
	 * @param var la liste de variables
	 * @param name son nom
	 */
	public ConstraintExt(ArrayList<String> var, String name) {
		super(var,name);
		tuples = new ArrayList<ArrayList<Object>>();
	}
	
	/**
	 * Construit une contrainte en extension à partir d'une représentation
	 * textuelle de la contrainte. La liste de variables est donnée sous la forme : Var1;Var2;...
	 * Puis le nombre de tuples est indiqué et enfin chaque tupe est donné sous la forme d'une
	 * suite de valeurs "String" : Val1;Val2;...
	 * Aucune vérification n'est prévue si la syntaxe n'est pas respectée !!
	 * 
	 * @param in le buffer de lecture de la représentation textuelle de la contrainte
	 * @throws Exception en cas d'erreur de format
	 */
	public ConstraintExt(BufferedReader in) throws Exception{
		super(in);
		tuples = new ArrayList<ArrayList<Object>>();
		
		int nbTuples = Integer.parseInt(in.readLine()); // Nombre de tuples de valeurs
		for(int i = 0; i < nbTuples; i++) {
			ArrayList<Object> tuple = new ArrayList<Object>();
			
			for (String v : in.readLine().split(";"))
				tuple.add(v); // Val1;Val2;...;Val(arity)
			
			if(tuple.size() != varList.size()) 
				System.err.println("Le tuple " + tuple + " n'a pas l'arité " + varList.size() + " de la contrainte " + name);
			else if(!getTuples().add(tuple))
				System.err.println("Le tuple " + tuple + " est déjà présent dans la contrainte "+ name);
		}
	}
	
	
	public ArrayList<ArrayList<Object>> getTuples() {
		return tuples;
	}
	
	
	/**
	 * Ajoute un tuple de valeur à la contrainte
	 * 
	 * @param valTuple le tuple à ajouter
	 */
	public void addTuple(ArrayList<Object> valTuple) {
		if(valTuple.size() != varList.size()) 
			System.err.println("Le tuple " + valTuple + " n'a pas l'arité " + varList.size() + " de la contrainte " + name);
		else if(!getTuples().add(valTuple)) System.err.println("Le tuple " + valTuple + " est déjà présent dans la contrainte "+ name);
	}
	

	/**
	 * Teste si une assignation viole la contrainte.
	 * La violation "classique" n'est avérée que si :
     *      - toutes les variables de la contrainte ont une valeur associée dans l'assignation testée
     *      - le tuple de valeurs pour les variables de la contrainte dans l'assignation testée n'appartient
     *        pas aux tuples autorisés par la contrainte
	 * @param a l'assignation à tester
	 * @return vrai ssi l'assignation viole la contrainte
	 */
	public boolean violation(Assignment a) {
		for (String var : varList)
			if (!a.containsKey(var)) // Si une des variables de la contrainte n'est pas dans l'assignation
				return false;
		
		int indexVar = 0, indexTuple = 0;
		while (indexVar < varList.size() && indexTuple < getTuples().size()) {
			ArrayList<Object> t = getTuples().get(indexTuple);
			Object valConstraint = t.get(indexVar);
			Object valAssignment = a.get(varList.get(indexVar));
			
			if (valConstraint.equals(valAssignment))
				indexVar++;
			else {
				indexVar = 0;
				indexTuple++;
			}
		}
		
		if (indexVar == varList.size())
			return false;
		
		return true;
	}
	
	public boolean violationOpt(Assignment a) {
		int indexVar = 0, indexTuple = 0;
		while (indexVar < varList.size() && indexTuple < getTuples().size()) {
			ArrayList<Object> t = getTuples().get(indexTuple);
			Object valConstraint = t.get(indexVar);
			Object valAssignment = a.get(varList.get(indexVar));
			
			if (valAssignment == null || valConstraint.equals(valAssignment))
				indexVar++;
			else {
				indexVar = 0;
				indexTuple++;
			}
		}
		
		if (indexVar == varList.size())
			return false;
		
		return true;
	}
	
	
	/* (non-Javadoc)
	 * @see Constraint#toString()
	 */
	public String toString() {
		return "\n\t Ext "+ name + " " + varList + " : " + getTuples(); 
	}

}
