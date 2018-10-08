package exo4;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Etudiant e1= new Etudiant("etu1",
								"etu1",
								18,
								Candidature.eCandidat);
		
		Etudiant e2= new Etudiant("etu2",
				"etu2",
				23,
				Candidature.eCandidat);
		
		Etudiant e3= new Etudiant("etu3",
				"etu3",
				27,
				Candidature.eCandidat);
		
		Etudiant e4= new Etudiant("etu4",
				"etu4",
				17,
				Candidature.campusFrance);
		
		Etudiant e5= new Etudiant("etu5",
				"etu5",
				27,
				Candidature.campusFrance);
		
		Etudiant e6= new Etudiant("etu6",
				"etu6",
				12,
				Candidature.autre);
		
		ArrayList<Etudiant> listeEtu= new ArrayList<Etudiant>();
		listeEtu.add(e1);
		listeEtu.add(e2);
		listeEtu.add(e3);
		listeEtu.add(e4);
		listeEtu.add(e5);
		listeEtu.add(e6);
		
		Promotion p= new Promotion(listeEtu);
		
		System.out.println("Âge min eCandidat : "+p.ageMinECandidat());
		
		System.out.println("Nb étudiants eCandidat : "+p.nbEtu(Candidature.eCandidat));
		System.out.println("Nb étudiants campus France : "+p.nbEtu(Candidature.campusFrance));
		System.out.println("Nb étudiants autres : "+p.nbEtu(Candidature.autre));
		
		Etudiant[] liste= p.listeAgeMax();
		System.out.println("Liste des étudiants d'âge max :");
		for (Etudiant e : liste)
			System.out.println(e.getNom()+" "+e.getPrenom());
		
		List<Etudiant> liste2;²
	}
}
