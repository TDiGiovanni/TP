package exo1;

public class Main {
	public static void main(String[] args) {
		Feu f= new Feu();
		IterateurFeu ite= f.iterator();
		
		for (int i=0; i<12; i++)
			System.out.println(ite.next());
	}
}
