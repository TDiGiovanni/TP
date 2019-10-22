package refactoringClement2;

public class Animal {
	
	private Species species;
	private int age;
	private Sex sex;
	

	
	public Animal (String name, double maxTailleAdulte, int age, Sex sex, int nbPapounes, boolean queu) {
		
		this.species = new Species();
		
		this.species.name = name;
		this.species.maxTailleAdulte = maxTailleAdulte;
		this.age = age;
		this.sex = sex;
		this.species.nbPapounnes = nbPapounes;
		this.species.queu = queu;
	}
	

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Animal [nameSpecies=" + species.name + ", maxTailleAdulte=" + species.maxTailleAdulte + ", age=" + age + ", sex="
				+ sex + ", nbPapounnes=" + species.nbPapounnes + ", queu=" + species.queu + "]";
	}
	
	
}
