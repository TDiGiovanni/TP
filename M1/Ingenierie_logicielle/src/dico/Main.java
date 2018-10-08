package dico;

public class Main {

	public static void main(String[] args) {
		// Ordered
		OrderedDictionary ordered = new OrderedDictionary();
		
		System.out.println("Ajout de 0"); ordered.put(0, "zero");
		System.out.println("Ajout de 1"); ordered.put(1, "un");
		System.out.println("Ajout de 2"); ordered.put(2, "deux");
		
		// Fast
		FastDictionary fast = new FastDictionary();

		System.out.println("Ajout de 36"); fast.put(36, "trente six");		
		System.out.println("Ajout de 200"); fast.put(200, "deux cents");
		System.out.println("Ajout de 42"); fast.put(42, "quarante deux");
		/*
		// Sorted
		SortedDictionary sorted = new SortedDictionary();
		
		System.out.println("Ajout de 1"); sorted.put(1, "un");
		System.out.println("Ajout de 0"); sorted.put(0, "zero");
		System.out.println("Ajout de 2"); sorted.put(2, "deux");*/
	}

}
