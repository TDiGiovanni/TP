package p;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Personne> liste = new ArrayList<Personne>();
		liste.add(new Personne("Fletcher",18));
		liste.add(new Personne("Fletcher",25));
		liste.add(new Personne("Aztec",31));
		liste.add(new Personne("Eloret",17));
		System.out.println(Collections.max(liste));
		System.out.println(Collections.min(liste));
		
		Collections.sort(liste);
		System.out.println(liste);
		System.out.println(Collections.max(liste,new ComparateurPersonnes()));
	}
}
