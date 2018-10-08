package exo2;

public class PersonnageBonus extends Personnage {
	private int seuilBonus;
	
	// Constructeurs
	public PersonnageBonus() {
		super();
		this.seuilBonus=0;
	}
	
	public PersonnageBonus(String n, int nbp, int nbv, int sb) {
		super(n,nbp,nbv);
		this.seuilBonus=sb;
	}
	
	// Accesseurs
	public int getSeuilBonus() {
		return seuilBonus;
	}
	public void setSeuilBonus(int seuilBonus) {
		this.seuilBonus = seuilBonus;
	}
	
	@Override
	@Todo(kind= TaskKind.Test,
			version= "1.0",
			duration= 5)
	public void setNbPoints(int nbp) {
		super.setNbPoints(nbp);
		if (this.getNbPoints()>this.seuilBonus)
			this.setNbVies(this.getNbVies()+1);
	}
}
