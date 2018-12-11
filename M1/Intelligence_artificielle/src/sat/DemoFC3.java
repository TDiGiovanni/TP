package sat;

public class DemoFC3
{
	public static void main(String[] args) throws Exception
	{
		KnowledgeBase k = new KnowledgeBase("TP2_exo2");

		// Création de la BF saturée par chaînage avant et affichage
		System.out.println("Application du forward chaining optimisé");
		k.forwardChainingOpt();
	}
}
