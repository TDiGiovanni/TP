package exo1;

import java.awt.Color;

public class Feu implements Iterable<Color>{
	private Color[] couleurs;
	
	public Feu() {
		this.couleurs= new Color[]{Color.green,Color.orange,Color.red};
	}
	
	public Feu(Color[] couleurs) {
		this.couleurs= couleurs;
	}
	
	@Override
	public IterateurFeu iterator() {
		return new IterateurFeu(couleurs);
	}

	public Color[] getCouleurs() {
		return couleurs;
	}

	public void setCouleurs(Color[] couleurs) {
		this.couleurs = couleurs;
	}
}
