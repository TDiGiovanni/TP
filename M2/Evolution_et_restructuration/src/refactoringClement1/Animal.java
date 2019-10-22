package refactoringClement1;

public class Animal {

	private int age;
	private String sex;
	
	private Espece espece = new Espece();

	public Animal (String name, double maxTailleAdulte, int age, String sex, int nbPapounes, boolean queu) {
		this.espece.nameSpecies = name;
		this.espece.maxTailleAdulte = maxTailleAdulte;
		this.age = age;
		this.sex = sex;
		this.espece.nbPapounnes = nbPapounes;
		this.espece.queu = queu;
	}
	
	public String getNameSpecies() {
		return espece.nameSpecies;
	}
	public void setNameSpecies(String nameSpecies) {
		this.espece.nameSpecies = nameSpecies;
	}
	public double getMaxTailleAdulte() {
		return espece.maxTailleAdulte;
	}
	public void setMaxTailleAdulte(double maxTailleAdulte) {
		this.espece.maxTailleAdulte = maxTailleAdulte;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getNbPapounnes() {
		return espece.nbPapounnes;
	}
	public void setNbPapounnes(int nbPapounnes) {
		this.espece.nbPapounnes = nbPapounnes;
	}
	public boolean isQueu() {
		return espece.queu;
	}
	public void setQueu(boolean queu) {
		this.espece.queu = queu;
	}

	@Override
	public String toString() {
		return "Animal [nameSpecies=" + espece.nameSpecies + ", maxTailleAdulte=" + espece.maxTailleAdulte + ", age=" + age + ", sex="
				+ sex + ", nbPapounnes=" + espece.nbPapounnes + ", queu=" + espece.queu + "]";
	}
	
	
}
