package csp;

import java.io.BufferedReader;
import java.util.ArrayList;

public class ConstraintDif extends Constraint {
	
	// Constructeurs
	public ConstraintDif(ArrayList<String> var) {
		super(var);
	}
	
	public ConstraintDif(ArrayList<String> var, String name) {
		super(var,name);
	}
	
	public ConstraintDif(BufferedReader in) throws Exception{
		super(in);
	}

	public boolean violation(Assignment a) {
		for (String var : varList)
			if (!a.containsKey(var)) // Si une des variables de la contrainte n'est pas dans l'assignation
				return false;
			
		for (String var : varList) {
			Object valVar = a.get(var);
			for (String otherVar : varList) {
				Object valOtherVar = a.get(otherVar);
				if (!otherVar.equals(var)
					&& valOtherVar.equals(valVar))
					return true;
			}
		}
		
		return false;
	}
	
	public boolean violationOpt(Assignment a) {
		for (String var : varList) {
			if (a.containsKey(var)) { // Vérification de var dans l'assignation
				Object valVar = a.get(var);
				for (String otherVar : varList) {
					if (a.containsKey(otherVar)) { // Vérification de otherVar dans l'assignation
						Object valOtherVar = a.get(otherVar);
						if (!otherVar.equals(var)
								&& valOtherVar.equals(valVar))
							return true;
					}
				}
			}
		}

		return false;
	}
	
	public String toString() {
		return "\n\t Dif "+ name + " " + varList; 
	}
}
