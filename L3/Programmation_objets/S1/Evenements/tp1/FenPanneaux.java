package tp1;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FenPanneaux extends JFrame {  
	protected JPanel pRouge, pBleu, pJaune;
	protected JButton b1,b2,b3;
	protected JTextField texte;
  
	public FenPanneaux() {
		setTitle("Fenêtre à panneaux"); 
		
		pRouge = new JPanel(); 
		pRouge.setBackground(Color.red);
		
		pBleu = new JPanel(); 
		pBleu.setBackground(Color.blue);
		
		pJaune = new JPanel(); 
		pJaune.setBackground(Color.yellow);
		
		add(pRouge,"North");
		add(pBleu,"Center");
		add(pJaune,"East");
		
		pRouge.setPreferredSize(new Dimension(400,100));
		pJaune.setPreferredSize(new Dimension(100,200));
		
		b1 = new JButton("b1"); pJaune.add(b1);
		b2 = new JButton("b2"); pJaune.add(b2);
		b3 = new JButton("b3"); pJaune.add(b3);
		texte = new JTextField("Hello",20); 
		pBleu.add(texte);

		pack();    
 }
  
	public static void main(String args[]) {  
		FenPanneaux f = new FenPanneaux();
		f.setVisible(true);
	}
}
