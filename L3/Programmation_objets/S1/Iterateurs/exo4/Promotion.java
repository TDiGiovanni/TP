package exo4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Promotion {
	private ArrayList<Etudiant> listeEtu;
	
	public Promotion(ArrayList<Etudiant> l) {
		this.listeEtu=l;
	}
	
	// Renvoie l'âge minimum des étudiants inscrits via eCandidat
	public double ageMinECandidat() {
		return listeEtu.stream()
						.filter(e->e.getCandidature()==Candidature.eCandidat)
						.mapToDouble(e->e.getAge())
						.min()
						.getAsDouble();
	}
	
	// Renvoie le nombre d'étudiants inscrits via une candidature donnée
	public double nbEtu(Candidature c) {
		return listeEtu.stream()
						.filter(e->e.getCandidature()==c)
						.count();
	}
	
	// Renvoie le nombre d'étudiants d'âge maximal
	public Etudiant[] listeAgeMax() {
		return listeEtu.stream()
						.filter(e->e.getAge()==listeEtu.stream()
														.mapToDouble(e2->e2.getAge())
														.max()
														.getAsDouble())
						.toArray(Etudiant[]::new);
	}
	
	public List<Etudiant> listeEtuNomCommencePar(String s) {
		return listeEtu.stream()
						.filter(e->e.getNom().startsWith(s))
						.sorted((e1,e2)->e1.getNom().compareTo(e2.getNom()))
						.collect(Collectors.toList());
	}
}
