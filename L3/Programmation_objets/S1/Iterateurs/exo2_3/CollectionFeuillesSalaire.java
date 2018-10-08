package exo2_3;

import java.util.ArrayList;

public class CollectionFeuillesSalaire {
	private ArrayList<FeuilleSalaire> liste;
	
	public CollectionFeuillesSalaire(ArrayList<FeuilleSalaire> liste) {
		this.liste= liste;
	}
	
	public void print() {
		liste.stream()
			.forEach(f->System.out.println(f));
	}
	
	public void print2() {
		liste.forEach(f->System.out.println(f));
	}
	
	public void sort() {
		
	}
}
