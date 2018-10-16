package exo1;

import java.util.ArrayList;

public class Main {
	@SuppressWarnings({"rawtypes","unchecked"})
	public static void main(String[] args) {
		ArrayList l= new ArrayList();
		
		l.add(0);
		l.add(true);
		l.add(45.8);
		
		ClasseArrayList c= new ClasseArrayList(l);
		c.getClasseCommune();
	}
}
