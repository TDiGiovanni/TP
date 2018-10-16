package p;

import p.Todo.TaskKind;

public class Personne implements Comparable<Personne>{
	
	private String nom;
	private int age;
	
	public Personne(String s, int i) {
		this.nom=s;
		this.age=i;
	}
	
	@Todo(kind=TaskKind.Enhance,version="1.0",duration=10)
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String s) {
		this.nom=s;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int i) {
		this.age=i;
	}

	@Override
	public int compareTo(Personne p) {
		return 0;
	}
}
