package sat;

public class DemoFC2
{
	public static void main(String[] args) throws Exception
	{
		KnowledgeBase k = new KnowledgeBase("TP2_exo1");

		// Création de la BF saturée par chaînage avant et affichage
		System.out.println("Application du forward chaining");
		k.forwardChaining();
	}
}