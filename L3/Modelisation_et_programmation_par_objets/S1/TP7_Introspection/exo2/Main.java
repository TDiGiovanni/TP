package exo2;

@SuppressWarnings("rawtypes")
public class Main {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//Personnage p1= new PersonnageBonus();
		//Personnage p2= new PersonnageInvisible();
		
		//Personnage pf= FabriquePerso.nouveauPerso("PersonnageInvisible");
		//FabriquePerso.changerValeurs(pf);
		//FabriquePerso.changerType(pf,"PersonnageBonus");
		
		Class[] classes= {Personnage.class,
							PersonnageInvisible.class,
							PersonnageBonus.class};
		ManipAnnotation.afficheTodo(classes);
		ManipAnnotation.afficheTodoKind(classes,TaskKind.Test);
		ManipAnnotation.afficheTodoDuree(classes,"1.0");
	}
}
