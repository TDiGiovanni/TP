package exo2_3;

public class FeuilleSalaire implements Iterable<Object> {
	private String nomEmployeur;
	private String nomEmploye;
	private String conventionCollective;
	private double nbHeuresPayees;
	private double prelevementsFiscaux;
	private double netAPayer;
	
	public FeuilleSalaire(String nomEmployeur, String nomEmploye, String CC, double nbHP, double PP, double net) {
		this.nomEmployeur= nomEmployeur;
		this.nomEmploye= nomEmploye;
		this.conventionCollective= CC;
		this.nbHeuresPayees= nbHP;
		this.prelevementsFiscaux= PP;
		this.netAPayer= net;
	}
	
	@Override
	public IterateurFeuilleSalaire iterator() {
		Object[] feuille= {this.nomEmployeur,
							this.nomEmploye,
							this.conventionCollective,
							this.nbHeuresPayees,
							this.prelevementsFiscaux,
							this.netAPayer};
		
		return new IterateurFeuilleSalaire(feuille);
	}
	
	@Override
	public String toString() {
		return this.nomEmployeur+" "+
				this.nomEmploye+" "+
				this.conventionCollective+" "+
				this.nbHeuresPayees+" "+
				this.prelevementsFiscaux+" "+
				this.netAPayer;
	}
}
