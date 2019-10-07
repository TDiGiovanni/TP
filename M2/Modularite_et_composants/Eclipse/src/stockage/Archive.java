package stockage;

import java.util.HashMap;

// Classe representant une archive
// Elle herite de Directory car elle possede toutes les caracteristiques d'un dossier
// Surtout la manipulation de collection qui permet la reutilisation de methodes
public class Archive extends Directory implements IArchive
{
	public Archive(String nom)
	{
		super(nom);
	}
	
	public HashMap<?, ?> getContent()
	{
		HashMap<String,ElementStockage> map = new HashMap<String,ElementStockage>();
		
		for (ElementStockage s : elements)
		{
			map.put(s.absoluteAdress(),s);
		}
		
		return map;
	}
	
	public void extract()
	{
		for (ElementStockage s : elements)
		{
			s.parent.add(s);
		}
	}
}
