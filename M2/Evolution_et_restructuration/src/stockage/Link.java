package stockage;

public class Link extends ElementStockage
{
		public ElementStockage reference;
		
		public Link(String nom)
		{
			super(nom, 0);
			reference = null;
		}
		
		public Link(String nom, ElementStockage e)
		{
			super(nom, 0);
			reference = e;
		}
		
		public int size()
		{
			if (reference == null)
				return 0;
			else
				return reference.size();
		}
		
		// Affiche le symbole du lien puis l'adresse absolue de sa référence
		public void cat()
		{
			System.out.println("ln -s " + reference.absoluteAdress() + " " + name) ;
		}
}
