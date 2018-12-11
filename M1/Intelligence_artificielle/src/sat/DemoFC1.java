package sat;

public class DemoFC1
{
	public static void main(String[] args) throws Exception
	{
		KnowledgeBase k = new KnowledgeBase("Anniversaire");
		System.out.println(k);

		// Création de la BF saturée par chaînage avant et affichage
		System.out.println("Application du forward chaining");
		k.forwardChaining();
		k.printSaturatedFactBase();
		
		// Création de la BF saturée par chaînage avant optimisé et affichage
		System.out.println("Application du forward chaining optimisé");
		k.forwardChainingOpt();
		k.printSaturatedFactBase();
	}
}
