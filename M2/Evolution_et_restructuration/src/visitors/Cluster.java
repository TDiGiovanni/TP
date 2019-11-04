package visitors;

import java.util.HashMap;
import java.util.Map;

// Represents a cluster of classes (at least one), and a node in the cluster tree
public class Cluster
{
	protected static int totalCoupling = 0; // Total value of all the coupling between all classes
	
	protected String name;
	protected Cluster firstCluster; 		// Empty if there is just one class
	protected Cluster secondCluster; 		// Empty if there is just one class
	protected Map<Cluster, Integer> coupling;
	
	// Constructors
	public Cluster(String newName)
	{
		this.name = newName;
		this.firstCluster = null;
		this.secondCluster = null;
		this.coupling = new HashMap<>();
	}
	
	public Cluster(Cluster newFirstClass, Cluster newSecondClass)
	{
		this.name = newFirstClass.getName() + "-" + newSecondClass.getName();
		this.firstCluster = newFirstClass;
		this.secondCluster = newSecondClass;
		
		// Merge the coupling of the two child clusters
		this.coupling = new HashMap<>(this.firstCluster.getCoupling());
		this.secondCluster.getCoupling().forEach(
			    (key, value) -> this.coupling.merge(key, value, (v1, v2) -> v1 + v2)
			);
		this.coupling.remove(newFirstClass);
		this.coupling.remove(newSecondClass);
	}
	
	// Getters and setters
	public String getName()
	{
		return this.name;
	}

	public Cluster getFirstCluster()
	{
		return this.firstCluster;
	}
	
	public Cluster getSecondCluster()
	{
		return this.secondCluster;
	}
	
	public Map<Cluster, Integer> getCoupling()
	{
		return this.coupling;
	}
	
	public static int getTotalCoupling()
	{
		return totalCoupling;
	}
	
	// Adds the coupling of "oldCluster" to "newCluster"
	public void updateCoupling(Cluster oldCluster, Cluster newCluster)
	{
		Integer oldValue = this.coupling.get(oldCluster),
				newValue = this.coupling.get(newCluster);
		
		if (newValue == null)
			newValue = 0;
		
		this.coupling.put(newCluster, newValue + oldValue);
	}
	
	// Increments the coupling with another class
	public void increment(Cluster incrementedClass)
	{		
		totalCoupling++;
		
		Integer oldValue = coupling.get(incrementedClass);
		if (oldValue == null)
			oldValue = 0;
		
		coupling.put(incrementedClass, oldValue + 1);
	}
	
	// Prints the tree
    public void print(String prefix, boolean isTail)
    {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + this.getName());

        if (firstCluster != null)
        {
        	firstCluster.print(prefix + (isTail ? "    " : "│   "), (secondCluster == null ? true : false));
        }

        if (secondCluster != null)
        {
        	secondCluster.print(prefix + (isTail ?"    " : "│   "), true);
        }
    }
}
