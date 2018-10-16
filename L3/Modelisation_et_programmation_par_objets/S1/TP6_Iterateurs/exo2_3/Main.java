package exo2_3;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		// Exo 2
		FeuilleSalaire f= new FeuilleSalaire("Employeur",
											"Employé",
											"Convention collective",
											10,
											20,
											30);
		
		IterateurFeuilleSalaire ite= f.iterator();
		
		while (ite.hasNext())
			System.out.println(ite.next());
		
		// Exo 3
		FeuilleSalaire f2= new FeuilleSalaire("Employeur2",
											"Employé2",
											"Convention collective2",
											102,
											202,
											302);
		
		ArrayList<FeuilleSalaire> liste= new ArrayList<FeuilleSalaire>();
		liste.add(f);
		liste.add(f2);
		
		CollectionFeuillesSalaire c= new CollectionFeuillesSalaire(liste);
		
		c.print();
		c.print2();
	}
}
