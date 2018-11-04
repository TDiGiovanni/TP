package csp_etud;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;

/* (non-Javadoc)
 *  Choix de codage :
 *		Variable = String
 *      Valeur = Object
 *		un domaine = ArrayList<Object>
 *
 *  un réseau de contrainte (X,D,C) est représenté par :
 * 		- X les variables et D les domaines sont représentés par un ensemble de 
 *		couples (variable,domaine) utilisant une HashMap<String,ArrayList<Object>>
 *		- C les contraintes est une simple liste de contraintes : ArrayList<Constraint>
 *
 *  On pourra, pour optimiser la structure d'un réseau de contraintes, ajouter
 * une HashMap (variable, liste de contraintes) qui permet d'associer à
 * chaque variable la liste des contraintes qui portent sur elle.
 *
*/
/**
 * Structure de manipulation d'un réseau de contraintes (X,D,C)
 *
 */
public class Network {
	
	private HashMap<String,ArrayList<Object>> varDom; // Associe à chaque variable de X un domaine de D
	private ArrayList<Constraint> constraints; // Ensemble des contraintes C
	
	
	/**
	 * Construit un réseau de contraintes sans variable (ni contrainte)
	 */
	public Network() {
		varDom = new HashMap<String,ArrayList<Object>>();
		constraints = new ArrayList<Constraint>();
	}
	
	
	/**
	 * Construit un réseau de contraintes à partir d'une représentation textuelle au 
	 * format :
	 * <p> nombre de variables
	 * <p> nom de la variable 1 ; val1 ; val2 ; ...
	 * <p> nom de la variable 2 ; val1 ; val2 ; ...
	 * <p> ...
	 * <p> nombre de contraintes
	 * <p> type de la contrainte 1   (pour l'instant uniquement 'ext')
	 * <p> nom de la 1ère variable de la contrainte 1 ; nom de la 2nde var de la contrainte 1 ; ...
	 * <p> nombre de tuples de valeurs pour cette contrainte 
	 * <p> val1 ; val2 ; ...
	 * <p> val1 ; val2 ; ... 
	 * <p> type de la contrainte 2   (pour l'instant uniquement 'ext')
	 * <p> nom de la 1ière variable de la contrainte 2 ; nom de la 2nde var de la contrainte 2 ; ...
	 * <p> nombre de tuples de valeurs pour cette contrainte 
	 * <p> val1 ; val2 ; ...
	 * <p> val1 ; val2 ; ... 
	 * <p> ...
	 * 
	 * @param in le buffer de lecture de la représentation textuelle de la contrainte
	 * @throws Exception en cas de problème dans l'analyse textuelle
	 */
	public Network(BufferedReader in) throws Exception {
		varDom = new HashMap<String,ArrayList<Object>>();
		constraints = new ArrayList<Constraint>();
		
		// Les variables et domaines
		int nbVariables = Integer.parseInt(in.readLine());	// le nombre de variables
		for (int i = 0; i < nbVariables; i++) {
			String[] varDeclaration = in.readLine().split(";"); // Var;Val1;Val2;Val3;...
			ArrayList<Object> dom = new ArrayList<Object>();
			varDom.put(varDeclaration[0], dom);
			for (int j = 1; j < varDeclaration.length; j++)
				dom.add(varDeclaration[j]);
		}
		
		// Les contraintes
		int nbConstraints = Integer.parseInt(in.readLine()); // le nombre de contraintes
		for(int k = 0; k < nbConstraints; k++) {
			Constraint c = null;
			
			String type = in.readLine().trim();	// Type de la contrainte
			
			if (type.equals("ext")) {
				c = new ConstraintExt(in);
				
				if (c.varList.size() == 1) { // Si la contrainte en extension est d'arité 1, on réduit le domaine de la variable concernée et supprime la contrainte
					ArrayList<Object> domaine = new ArrayList<Object>();
					
					for (int i = 0; i < ((ConstraintExt)c).getTuples().size(); i++) {
						Object constraintVal = ((ConstraintExt)c).getTuples().get(i).get(0);
						domaine.add(constraintVal);
					}
					
					varDom.put(c.varList.get(0), domaine);
					c = null;
				}
			}
			
			else if(type.equals("dif")) c = new ConstraintDif(in);
			
			else if(type.equals("eq")) c = new ConstraintEq(in);
			
			else if(type.equals("exp")) c = new ConstraintExp(in);
			
			else System.err.println("Type contrainte inconnu : " + type);
			
			if (c != null)
				addConstraint(c);
		}
	}
	
	
	/**
	 * Ajoute une nouvelle variable dans le réseau avec un domaine vide
	 * (ne fait rien si la variable existe déjà : message d'avertissement)
	 * 
	 * @param var la variable à ajouter
	 */
	public void addVariable(String var) {
		if(varDom.get(var)==null) varDom.put(var, new ArrayList<Object>());
		else System.err.println("Variable " + var + " deja existante");
	}

	
	/**
	 * Ajoute une nouvelle valeur au domaine d'une variable du réseau
	 * 
	 * @param var la variable à laquelle il faut ajouter la valeur
	 * @param val la valeur à ajouter
	 */
	public void addValue(String var, Object val) {
		if(varDom.get(var)==null) System.err.println("Variable " + var + " non existante");
		else {
			ArrayList<Object> dom = varDom.get(var);
			if (!dom.add(val)) // add retourne vrai si la valeur était effectivement nouvelle
				System.err.println("La valeur " + val + " est déjà dans le domaine de la variable " + var); 
		}
	}
	
	
	/**
	 * Ajoute une contrainte dans le réseau. Les variables de la
	 * contrainte doivent déjà exister dans le réseau.
	 * 
	 * @param c la contrainte à ajouter
	 */
	public void addConstraint(Constraint c) {		
		// Attention !! On ne vérifie pas que les valeurs des contraintes sont "compatibles" avec les domaines
		if(!varDom.keySet().containsAll(c.getVars())) // si l'une des variables de la contrainte n'existe pas das le réseau
			System.err.println("La contrainte " + c.getName() + " contient des variables (" + c.getVars()
					+ ") non déclarées dans le CSP dont les variables sont " + varDom.keySet());
		else constraints.add(c);
	}
	
	
	/**
	 * Retourne le nombre de variables du réseau
	 * 
	 * @return le nombre de variables
	 */
	public int getVarNumber() {
		return varDom.size();
	}

	
	/**
	 * Retourne la taille du domaine d'une variable du réseau.
	 * 
	 * @param var la variable dont on veut connaître la taille de son domaine
	 * @return le nombre de valeurs de Dom(var)
	 */
	public int getDomSize(String var) {
		return varDom.get(var).size();
	}
	
	
	/**
	 * Retourne le nombre de contraintes du réseau
	 * 
	 * @return le nombre de contraintes
	 */
	public int getConstraintNumber(){
		return constraints.size();
	}
	
	
	/**
	 * Retourne la liste des variables du réseau
	 * 
	 * @return la liste des variables
	 */
	public ArrayList<String> getVars() {
		return new ArrayList<String>(varDom.keySet());
	}

	
	/**
	 * Retourne le domaine d'une variable
	 * 
	 * @param var la variable dont on veut le domaine
	 *  @return la liste des valeurs du domaine d'une variable
	 */
	public ArrayList<Object> getDom(String var) {
		return varDom.get(var);
	}
	

	/**
	 * Retourne la liste des contraintes du réseau
	 * 
	 * @return la liste des contraintes
	 */
	public ArrayList<Constraint> getConstraints() {
		return constraints;
	}
	
	
	/**
	 * Retourne la liste des contraintes du réseau contenant une
	 * certaine variable 
	 * 
	 * @param var la variable dont on veut connaitre les contraintes
	 * @return la liste des contraintes contenant var
	 */
	public ArrayList<Constraint> getConstraints(String var) {						
		ArrayList<Constraint> selected = new ArrayList<Constraint>();
		for(Constraint c : constraints)
			if(c.getVars().contains(var)) selected.add(c);
		return selected;											
	}																		
	
		
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Variables et domaines : " + varDom + "\nContraintes : " + constraints;
	}
	
}

