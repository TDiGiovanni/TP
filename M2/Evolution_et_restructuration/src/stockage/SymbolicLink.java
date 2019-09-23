package stockage;

// Classe représentant un lien symbolique
public class SymbolicLink extends ElementStockage
{
		private ElementStockage reference; // Fait référence un autre élément de stockage
		
		public SymbolicLink(String nom)
		{
			super(nom, 0);
			reference = null;
		}
		
		public SymbolicLink(String nom, ElementStockage e)
		{
			super(nom, 0);
			reference = e;
		}
		
		// Ici, il est choisi comme option que la taille d'un lien symbolique correspond  la taille de sa référence
		public int size()
		{
			if (reference == null)
			return 0;
			
			else return reference.size();
		}
		
		// Affiche le symbole du lien puis l'adresse absolue de sa référence
		public void cat()
		{
			System.out.println("ln -s " + reference.absoluteAdress() + " " + name);
		}
}
