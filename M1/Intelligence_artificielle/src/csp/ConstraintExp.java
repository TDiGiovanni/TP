package csp;

import java.io.BufferedReader;
import java.util.ArrayList;

import javax.script.*;

public class ConstraintExp extends Constraint {
	protected String expression;
	protected static ScriptEngineManager manager = new ScriptEngineManager();
	
	// Constructeurs
	public ConstraintExp(ArrayList<String> var, String expression) {
		super(var);
		this.expression = expression;
	}

	public ConstraintExp(ArrayList<String> var, String name, String expression) {
		super(var,name);
		this.expression = expression;
	}

	public ConstraintExp(BufferedReader in) throws Exception {
		super(in);
		expression = in.readLine();
	}
		
	public boolean violation(Assignment a) {
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		boolean exprNoViolation = true;
		
		for (String var : varList) {
			if (!a.containsKey(var)) // Si une des variables de la contrainte n'est pas dans l'assignation
				return false;
			
			engine.put(var, a.get(var));
		}
		
		try {
			exprNoViolation = (boolean) engine.eval(expression);
		}
		catch (ScriptException e) {
			e.printStackTrace();
		}

		return !exprNoViolation;
	}
	
	public boolean violationOpt(Assignment a) {
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		boolean exprNoViolation = true;
		
		for (String var : varList) {
			if (a.containsKey(var))
				engine.put(var, a.get(var));
		}
		
		try {
			exprNoViolation = (boolean) engine.eval(expression);
		}
		catch (ScriptException e) {
			return false;
		}

		return !exprNoViolation;
	}
	
	public String toString() {
		return "\n\t Exp "+ name + " " + expression; 
	}
}