package tp1;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FenFlowLayout extends JFrame { 
	private JButton[] boutons; 
  
 	public FenFlowLayout() { 
 		setSize(400, 400); 
 		setTitle("Fenêtre avec un FlowLayout"); 
   
 		boutons = new JButton[5]; 
 		for (int i = 0; i < boutons.length; i ++) 
 			boutons[i]= new JButton("Bouton "+i);
 		
 		setLayout(new FlowLayout());
 		for (int i = 0; i < boutons.length; i ++) 
 			add(boutons[i]);
 		
 		//setLayout(new GridLayout(4,3));
 	}
 	
 	public static void main(String args[]) { 
		FenFlowLayout f = new FenFlowLayout(); 
		f.setVisible(true);
	}
}
