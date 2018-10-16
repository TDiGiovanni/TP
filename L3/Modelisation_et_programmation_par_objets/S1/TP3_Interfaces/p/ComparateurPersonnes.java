package p;

import java.util.*;

public class ComparateurPersonnes implements Comparator<Personne>{
	@Override
	public int compare(Personne p1, Personne p2) {
		return p1.getAge()-p2.getAge();
	}
	
}
