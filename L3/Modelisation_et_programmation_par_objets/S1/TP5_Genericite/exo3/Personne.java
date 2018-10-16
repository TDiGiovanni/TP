package exo3;

public class Personne implements ElementAvecPriorite{
	private String nom;
	private int age;
	
	public Personne() {}
	
	public Personne(String n, int a) {
		this.nom=n;
		this.age=a;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String n) {
		this.nom=n;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int a) {
		this.age=a;
	}
	
	public String toString() {
		return this.nom+" "+this.age;
	}

	@Override
	public int priorite() {
		if (this.getAge()<12)
			return 1;
		
		if (this.getAge()>60)
			return 2;
		
		else return 3;
	}
}
