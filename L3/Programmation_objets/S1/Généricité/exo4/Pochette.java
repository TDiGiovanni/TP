package exo4;

import java.util.ArrayList;

public class Pochette {
	private String  theme;
	private ArrayList<Document> collection;
	
	public Pochette() {
		this.theme="Inconnu";
		this.collection= new ArrayList<Document>();
	}
	
	public Pochette(String theme) {
		this.theme=theme;
		this.collection= new ArrayList<Document>();
	}
	
	public String getTheme() {
		return theme;
	}
	
	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	public ArrayList<Document> getCollection() {
		return collection;
	}
	
	public void setCollection(ArrayList<Document> collection) {
		this.collection = collection;
	}
	
	public void ajouter(Document d) {
		this.collection.add(d);
	}
	
	public int nbDocs() {
		return this.collection.size();
	}
}
