/*
 * Ici il faut extraire des classes (deux extraction possible) de la classe Animal
 * Le fait de redonner les attribut d'une même espèce pour tous les animals n'est pas pratique
 * Il faudrait pouvoir créer les espèces puis les animaux avec pour attribus les espèces (et non directement leur propriété).
 * Le sex aussi pause problèmes avec un simple string. (manque de rigeur en cas d'erreur exemple : "mal" et "homme" -> Juste le sex mal 
 */

package refactoringClement1;

public class Principal {
	
	public static void main(String[] args) {
		
		Animal alphaPanda = new Animal("panda", 1.80, 2, "mal", 4, true);
		Animal alphaSerpent = new Animal("serpent", 2.0, 4, "femelle", 0, true);
		
		Animal betaPanda = new Animal("panda", 1.80, 3, "femelle", 4, true);
		Animal betaSerpent = new Animal("serpent", 2.0, 1, "mal", 0, true);
		
		Animal escargo = new Animal("escargo", 0.1, 1, "ermafrodite", 0, true);
		
		Animal humain = new Animal("humain", 2.0, 34, "mal", 4, false);
		
		
		System.out.println(alphaPanda);
		System.out.println(betaPanda);
		
		System.out.println(alphaSerpent);
		System.out.println(betaSerpent);
		
		System.out.println(escargo);
		System.out.println(humain);
		
	}

}
