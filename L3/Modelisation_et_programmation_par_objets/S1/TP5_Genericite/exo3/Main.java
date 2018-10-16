package exo3;

public class Main {
	
	public static void main(String[] args) {
		FileAttente<Personne> file= new FileAttente<Personne>();
		
		Personne bernard= new Personne("Bernard",62);
		Personne michel= new Personne("Michel",2);
		Personne gerard= new Personne("Gérard",43);
		Personne truc= new Personne("truc",14);
		
		file.entre(bernard);
		file.entre(gerard);
		file.entre(truc);
		file.entre(michel);
		
		file.sort();
		
		System.out.println(file.toString());
	}
}
