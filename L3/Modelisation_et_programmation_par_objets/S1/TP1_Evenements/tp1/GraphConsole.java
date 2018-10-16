package tp1;

import java.util.Scanner;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GraphConsole extends JFrame { 
	public GraphConsole() { 
		setSize(200, 200);
		setTitle("Première fenêtre");  
	}
	
	public static void main(String args[]) { 
		GraphConsole f = new GraphConsole(); 
		f.setVisible(true); 
			
		while(true) {
			System.out.println("Nouveau titre ?"); 
			Scanner sc = new Scanner(System.in); 
			String rep = sc.nextLine();  
			f.setTitle(rep);
			sc.close();
		}
	}
}
