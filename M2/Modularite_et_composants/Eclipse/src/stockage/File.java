package stockage;

import visitors.Visitor;

// Classe représentant un fichier
public class File extends ElementStockage
{
	protected String content;
	
	public File(String nom)
	{
		super(nom, 0);
		this.content = "";
	}
	
	public File(String nom, String contenu)
	{
		super(nom, 0);
		this.content = contenu;
	}
	
	public int size()
	{
		return content.length();
	}
	
	public void cat()
	{
		System.out.println(content);
	}
	
	public boolean contains(String sub)
	{
		return (content.indexOf(sub) != -1);
	}
	
	// Changes the content to 'c'
	public void setContent(String c)
	{
		content = c;
	}

	public void accept(Visitor v)
	{
		v.visit(this);
	}
}
