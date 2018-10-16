package exo2;

public abstract class Personnage {
	private String nom;
	private int nbPoints;
	private int nbVies;
	
	//Constructeurs
	public Personnage() {
		this.nom= "";
		this.nbPoints= 0;
		this.nbVies= 0;
	}
	
	public Personnage(String n, int nbp, int nbv) {
		this.nom=n;
		this.nbPoints=nbp;
		this.nbVies=nbv;
	}
	
	// Accesseurs
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Todo(kind= TaskKind.Test,
			version= "1.0",
			duration= 5)
	public int getNbPoints() {
		return nbPoints;
	}
	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}
	
	public int getNbVies() {
		return nbVies;
	}
	public void setNbVies(int nbVies) {
		this.nbVies = nbVies;
	}
}
