package p;

import java.io.*;
import java.util.Scanner;

public class FicText2 {
	public static void main (String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le chemin du fichier à lire : ");
		String chemin = sc.nextLine();
		
		try {
			BufferedReader lectureFichier = new BufferedReader(new FileReader(chemin));
		
			int k= 0;
			String s = lectureFichier.readLine();
			while (s != null) {
				System.out.println(s);
				s = lectureFichier.readLine();
				k++;
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Le fichier spécifié n'existe pas. Entrez un nouveau chemin : ");
			chemin = sc.nextLine();
		}
		
		sc.close();
		lectureFichier.close();
		System.out.println("Fin du fichier. Il contient "+k+" lignes.");
	}
}
