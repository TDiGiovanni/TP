package exo1;

public interface iPile<A> {
	boolean estVide();
	
	void empile(A a);
	A depile();
	
	int nbElems();
	
	A sommet();
}
