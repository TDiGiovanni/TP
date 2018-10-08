package exo1;

import java.lang.reflect.Method;
import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class ClasseArrayList {
	private ArrayList liste;
	
	// Constructeurs
	public ClasseArrayList() {
		this.liste= new ArrayList();
	}
	
	public ClasseArrayList(ArrayList l) {
		this.liste= l;
	}

	// Accesseurs
	public ArrayList getListe() {
		return liste;
	}

	public void setListe(ArrayList liste) {
		this.liste = liste;
	}
	
	// Retourne les méthodes de la classe de l'objet i dans la liste
	public Method[] getMethodes(int i) {
		Class c= liste.get(i).getClass();
		return c.getMethods();
	}
	
	// Retourne la classe commune à tous les éléments la plus spécifique
	public Class getClasseCommune() {
		ArrayList<ArrayList<Class>> superclasses= new ArrayList<ArrayList<Class>>();
		
		// Pour chaque élément de "liste", on crée la liste de toutes ses classes
		// et on l'ajoute à "superclasses"
		for (Object o: liste) {
			ArrayList<Class> classes= new ArrayList<Class>();
			classes.add(o.getClass());
			Class sc= o.getClass().getSuperclass();
		
			while (sc.getName()!=null) {
				classes.add(sc);
				sc=sc.getSuperclass();
			}
			
			superclasses.add(classes);
		}
		
		// Chercher la plus petite classe commune à chaque élément de "superclasses"
		return null;
	}
}
