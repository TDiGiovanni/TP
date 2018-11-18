package sat;

public class Application
{
	public static void main(String[] args) throws Exception
	{
		KnowledgeBase k = new KnowledgeBase("Reunion");
		System.out.println(k);
		
		System.out.println("\nApplication du forward chaining");
		k.forwardChainingOpt();
		
		k.printSaturatedFactBase();
	}
}
