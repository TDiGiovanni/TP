package csp_etud;

import java.io.BufferedReader;
import java.util.ArrayList;

public class ConstraintDif extends Constraint {
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
		// TODO Auto-generated method stub
		return false;
	}
}
