package csp_etud;

import java.io.BufferedReader;
import java.util.ArrayList;

public class ConstraintDif extends Constraint {
	
	// Constructeurs
	public ConstraintDif(ArrayList<String> var) {
		super(var);
		tuples = new ArrayList<ArrayList<Object>>();
	}
	
	public ConstraintDif(ArrayList<String> var, String name) {
		super(var,name);
		tuples = new ArrayList<ArrayList<Object>>();
	}
	
	public ConstraintDif(BufferedReader in) throws Exception{
		super(in);
		tuples = new ArrayList<ArrayList<Object>>();
		int nbTuples = Integer.parseInt(in.readLine());		// nombre de tuples de valeurs
		for(int j=1;j<=nbTuples;j++) {
			ArrayList<Object> tuple = new ArrayList<Object>();
			for (String v : in.readLine().split(";")) tuple.add(v);	// Val1;Val2;...;Val(arity)
			if(tuple.size() != varList.size()) 
				System.err.println("Le tuple " + tuple + " n'a pas l'arité " + varList.size() + " de la contrainte " + name);
			else if(!tuples.add(tuple)) System.err.println("Le tuple " + tuple + " est déjà présent dans la contrainte "+ name);
		}
	}

	public boolean violation(Assignment a) {
		// TODO
		for (String var : varList)
			if (!a.containsKey(var)) // Si une des variables de la contrainte n'est pas dans l'assignation
				return false;
		
		int indexVar = 0, indexTuple = 0;
		while (indexVar < varList.size() && indexTuple < tuples.size()) {
			ArrayList<Object> t = tuples.get(indexTuple);
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
		return false;
	}
}
