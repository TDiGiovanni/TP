package exo2;

public class PersonnageInvisible extends Personnage {
	private boolean invisible;
	private double duree;
	private double cd;
	
	// Constructeurs
	public PersonnageInvisible() {
		super();
		this.invisible= false;
		this.duree= 0;
		this.cd= 0;
	}
	
	public PersonnageInvisible(String n, int nbp, int nbv, boolean inv, double duree, double cd) {
		super(n,nbp,nbv);
		this.invisible=inv;
		this.duree= duree;
		this.cd=cd;
	}
	
	// Accesseurs
	public boolean isInvisible() {
		return invisible;
	}
	public void setInvisible(boolean invisible) {
		this.invisible = invisible;
	}

	public double getDuree() {
		return duree;
	}
	public void setDuree(double duree) {
		this.duree = duree;
	}

	public double getCd() {
		return cd;
	}
	public void setCd(double cd) {
		this.cd = cd;
	}
	
	@Todo(kind= TaskKind.Test,
			version= "1.0",
			duration= 5)
	public void passerInvisible() {
		this.invisible=true;
		System.out.println("Le personnage "+this.getNom()+" est maintenant invisible.");
	}
}
