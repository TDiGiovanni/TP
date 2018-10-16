package exo2;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("rawtypes")
public class FabriquePerso {
	// Fabrique un personnage de type "nom"
	public static Personnage nouveauPerso(String nom) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class c= Class.forName(nom);
		Personnage p= (Personnage) c.newInstance();
		
		return p;
	}
	
	// Récupère toutes les classes de la classe c (sauf Object)
	private static ArrayList<Class> getSuperclasses(Class c) {
		ArrayList<Class> result= new ArrayList<Class>();
		result.add(c);
		Class sc= c.getSuperclass();
		
		while (!(sc.getName().equals("java.lang.Object"))) {
			result.add(sc);
			sc=sc.getSuperclass();
		}
		
		return result;
	}
	
	// Récupère tous les attributs de la classe c
	private static ArrayList<Field> getAttributs(Class c) {
		ArrayList<Field> result= new ArrayList<Field>();
		ArrayList<Class> superclasses= getSuperclasses(c);
		
		for (Class i: superclasses)
			for (Field f: i.getDeclaredFields())
				result.add(f);
		
		return result;
	}
	
	// Change la valeur de tous les attributs pour le personnage p
	public static Personnage changerValeurs(Personnage p) throws IllegalArgumentException, IllegalAccessException {
		ArrayList<Field> attributs= getAttributs(p.getClass());
		Scanner sc= new Scanner(System.in);
		
		for (Field a: attributs) {
			System.out.println("Entrez une valeur pour l'attribut "+a.getName()+" (l'ancienne valeur est "+a.get(p)+") : ");
			a.set(p,sc.nextLine());
		}
		
		sc.close();
		
		return p;
	}
	
	public static Personnage changerType(Personnage p, String nom) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Personnage newp= nouveauPerso(nom);
		ArrayList<Field> attributsP= getAttributs(p.getClass());
		ArrayList<Field> attributsNewp= getAttributs(newp.getClass());
		Scanner sc= new Scanner(System.in);
		
		for (Field a: attributsNewp) {
			if (attributsP.contains(a))
				for (int i=0; i<attributsP.size(); i++)
					if (attributsP.get(i).getName()==a.getName())
						a.set(newp,attributsP.get(i).getName());
			else {
				System.out.println("Entrez une valeur pour l'attribut "+a.getName()+" : ");
				a.set(p,sc.nextLine());
			}
		}
		
		sc.close();
		
		return newp;
	}
}
