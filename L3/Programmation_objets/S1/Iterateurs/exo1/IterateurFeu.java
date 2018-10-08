package exo1;

import java.awt.Color;
import java.util.Iterator;

public class IterateurFeu implements Iterator<Color>{
	private Color[] couleursFeu;
	private int currentColor;
	
	public IterateurFeu(Color[] couleursFeu) {
		this.couleursFeu= couleursFeu;
		this.currentColor= 0;
	}

	public Color[] getCouleursFeu() {
		return couleursFeu;
	}

	public void setCouleursFeu(Color[] couleursFeu) {
		this.couleursFeu = couleursFeu;
	}
	
	public int getCurrentColor() {
		return currentColor;
	}

	public void setCurrentColor(int currentColor) {
		this.currentColor = currentColor;
	}
	
	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Color next() {
		Color c= couleursFeu[currentColor];
		
		currentColor++;
		currentColor= currentColor%couleursFeu.length;
		
		return c;
	}
}
