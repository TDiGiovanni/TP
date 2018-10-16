package tp1;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MaFrame extends JFrame {
	public MaFrame() { 
		super(); // sinon, serait ajouté par le compilateur 
		setTitle("Ma petite application"); 
		setSize(400,400);  
		setLocation(100,100);
 	}
	
	public static void main(String args[]) { 
		MaFrame f= new MaFrame();
		f.setVisible(true);
	}
}
