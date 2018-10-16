package tp1;

import java.awt.FlowLayout;
import javax.swing.*; 
 
@SuppressWarnings("serial")
public class FenBouton extends JFrame {
	private JButton bouton;
	
	public FenBouton() { 
		setSize(400, 400);
		setTitle("Fenêtre à un bouton");
		this.bouton = new JButton("Hello!");
		this.add(bouton);
		setLayout(new FlowLayout());
		this.add(new JButton("Testestestest"));
	}

	public JButton getBouton() {
		return bouton;
	}

	public void setBouton(JButton bouton) {
		this.bouton = bouton;
	}
	
	public static void main(String args[]) {
		FenBouton f = new FenBouton(); 
		f.setVisible(true); 
	}
}
