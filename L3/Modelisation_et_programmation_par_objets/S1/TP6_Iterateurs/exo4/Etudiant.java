package exo4;

public class Etudiant {
	private String nom;
	private String prenom;
	private double age;
	private Candidature candidature;
	
	public Etudiant(String n, String p, double a, Candidature c) {
		this.nom=n;
		this.prenom=p;
		this.age=a;
		this.candidature=c;
	}
	
	// Accesseurs
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	
	public Candidature getCandidature() {
		return candidature;
	}
	public void setCandidature(Candidature candidature) {
		this.candidature = candidature;
	}
}
