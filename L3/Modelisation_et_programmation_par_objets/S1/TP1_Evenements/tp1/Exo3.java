package tp1;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class Exo3 extends JFrame {
	private JPanel p1, p2, p3;
	private JLabel l1, l2, l3;
	private JCheckBox check1, check2, check3;
	private JRadioButton r1= new JRadioButton(),
			r2= new JRadioButton(),
			r3= new JRadioButton();
	private JComboBox combo1;
	
	public Exo3() {
		setTitle("Exercice 3");
		
		p1= new JPanel();
		p1.setBackground(Color.green);
		p1.setPreferredSize(new Dimension(400,100));
		p2= new JPanel();
		p2.setBackground(Color.yellow);
		p2.setPreferredSize(new Dimension(400,100));
		p3= new JPanel();
		p3.setBackground(Color.blue);
		p3.setPreferredSize(new Dimension(400,100));
		
		l1= new JLabel("Couleur de texte :");
		p1.add(l1);
		l2= new JLabel("Couleur de fond");
		p2.add(l2);
		l3= new JLabel("Style");
		p3.add(l3);
		
		check1= new JCheckBox();
		check2= new JCheckBox();
		check3= new JCheckBox();
		
		pack();
	}
	
	public static void main(String args[]) {
		Exo3 f= new Exo3();
		f.setVisible(true);
	}
}
