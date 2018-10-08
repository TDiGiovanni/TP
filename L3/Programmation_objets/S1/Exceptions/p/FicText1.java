package p;

import java.io.*;

public class FicText1 {
	public static void main (String args[]) throws IOException {
		BufferedReader lectureClavier = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter ecritureFichier = new BufferedWriter(new FileWriter("test.txt"));
		System.out.println("Entrez des lignes");
		String s = lectureClavier.readLine();
		while (s.length()!=0) {
			
		}
	}
}
