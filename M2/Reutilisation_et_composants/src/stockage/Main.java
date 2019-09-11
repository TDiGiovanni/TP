package stockage;

import visitors.*;

public class Main
{
	public static void main(String[] args) 
	{		
		Directory pastis = new Directory("Pastis");
		Directory eau = new Directory("Eau");
		File martini = new File("Martini.class", "Martini");
		File ricard = new File("Ricard", "Ricard");
		File glacon = new File("Glaçons.class", "Glaçons");

		pastis.add(martini);
		pastis.add(ricard);
		pastis.add(eau);
		eau.add(glacon);
		
		RazVisitor razV = new RazVisitor();
		razV.Visit(pastis);
		
		CountVisitor countV = new CountVisitor();
		//countV.Visit(pastis);
	}
}
