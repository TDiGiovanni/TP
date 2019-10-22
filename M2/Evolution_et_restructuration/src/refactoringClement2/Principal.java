/*
 * Une classe Animal avec une class interne et une énumeration
 * Extraire cette classe et cette énumération dans un autre classe. (principal ?)
 */

package refactoringClement2;

public class Principal {
	
	public static void main(String[] args) {
		
		Animal alphaPanda = new Animal("panda", 1.80, 2, Sex.mal, 4, true);
		Animal alphaSerpent = new Animal("serpent", 2.0, 4, Sex.femelle, 0, true);
		
		Animal betaPanda = new Animal("panda", 1.80, 3, Sex.femelle, 4, true);
		Animal betaSerpent = new Animal("serpent", 2.0, 1, Sex.mal, 0, true);
		
		Animal escargo = new Animal("escargo", 0.1, 1, Sex.ermafrodite, 0, true);
		
		Animal humain = new Animal("humain", 2.0, 34, Sex.mal, 4, false);
		
		
		System.out.println(alphaPanda);
		System.out.println(betaPanda);
		
		System.out.println(alphaSerpent);
		System.out.println(betaSerpent);
		
		System.out.println(escargo);
		System.out.println(humain);
		
	}

}
