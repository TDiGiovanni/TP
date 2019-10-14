package visitors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class Tracker
{
	// Statistics
	protected final int maxMethods = 5;
	
	public int packageCount;
	public int classCount;
	public int attributeCount;
	public int methodCount;
	public int lineCount;
	public List<TypeDeclaration> allClasses;
	public MethodDeclaration mostParametersMethod;
	
	// Call graph
	public Map<String, List<String>> callGraph;
	
	// Coupling graph
	public List<Cluster> clusters;
	
	// Default constructor
	public Tracker()
	{
		this.packageCount = 0;
		this.classCount = 0;
		this.attributeCount = 0;
		this.methodCount = 0;
		this.lineCount = 0;
		this.allClasses = new ArrayList<>();
		this.mostParametersMethod = null;
		this.callGraph = new HashMap<>();
		this.clusters = new ArrayList<>();
	}
	
	// Prints all the stats and graphs
	public void print()
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("\nEnter anything to print the statistics");
		s.next();
		printStatistics();
		
		System.out.println("\nEnter anything to print the call graph");
		s.next();
		printCallGraph();
		
		System.out.println("\nEnter anything to print the coupling graph");
		s.next();
		printCouplingGraph();
		
		System.out.println("\nEnter anything to print the cluster tree");
		s.next();
		createClusterTree();
		printClusterTree();
		
		s.close();
	}
	
	// STATISTICS
	// Sorts the array of classes given as a parameter by number of attributes, returns a list of the first 10% only
	protected List<TypeDeclaration> sortClassesByAttributes()
	{
		Collections.sort(allClasses, new Comparator<TypeDeclaration>()
		{
			@Override
		    public int compare(TypeDeclaration class2, TypeDeclaration class1)
		    {
		        return Integer.compare(class1.getFields().length, class2.getFields().length);
		    }
		});
		
		List<TypeDeclaration> resultClasses = new ArrayList<>();
		for (int i = 0; i < (allClasses.size() / 10); i++)
			resultClasses.add(allClasses.get(i));
			
		return resultClasses;
	}
	
	// Sorts the array of classes given as a parameter by number of methods, returns a list of the first 10% only
	protected List<TypeDeclaration> sortClassesByMethods()
	{
		Collections.sort(allClasses, new Comparator<TypeDeclaration>()
		{
			@Override
		    public int compare(TypeDeclaration class2, TypeDeclaration class1)
		    {
		        return Integer.compare(class1.getMethods().length, class2.getMethods().length);
		    }
		});
		
		List<TypeDeclaration> resultClasses = new ArrayList<>();
		for (int i = 0; i < (allClasses.size() / 10); i++)
			resultClasses.add(allClasses.get(i));
			
		return resultClasses;
	}
	
	// Prints all the statistics
	public void printStatistics()
	{
		System.out.println("Number of packages: " + packageCount);
		System.out.println("Number of classes: " + classCount);
		System.out.println("Number of methods: " + methodCount);
		System.out.println("Number of lines of code: " + lineCount);
		
		System.out.println("Average number of attributes per class: " + (float) attributeCount / classCount);
		System.out.println("Average number of methods per class: " + (float) methodCount / classCount);
		System.out.println("Average number of lines of code per method: " + (float) lineCount / methodCount);
		
		System.out.println("10% of classes with the most attributes: ");
		List<TypeDeclaration> tempAttributeClasses = sortClassesByAttributes();
		for (TypeDeclaration attributeClass : tempAttributeClasses)
			System.out.println("- " + attributeClass.getName());
		
		System.out.println("10% of classes with the most methods: ");
		List<TypeDeclaration> tempMethodClasses = sortClassesByMethods();
		for (TypeDeclaration methodClass : tempMethodClasses)
			System.out.println("- " + methodClass.getName());
		
		List<TypeDeclaration> tempBothClasses = new ArrayList<>();
		for (TypeDeclaration attributeClass : tempAttributeClasses)
			if (tempMethodClasses.contains(attributeClass))
				tempBothClasses.add(attributeClass);
		System.out.println("Classes in both: ");
		for (TypeDeclaration bothClass : tempBothClasses)
			System.out.println("- " + bothClass.getName());
		
		System.out.println("Classes with more than " + maxMethods + " methods: ");
		for (TypeDeclaration classType : allClasses)
			if (classType.getMethods().length > maxMethods)
				System.out.println("- " + classType.getName());
		
		System.out.println("10% of methods with the most lines of code: ");
		//TODO: calculate lines of code
		
		System.out.println("Method with the most parameters: " + mostParametersMethod.getName());
	}
	
	// CALL GRAPH
	// Prints the call graph
	public void printCallGraph()
	{
		for (String callingClass : callGraph.keySet())
		{
			System.out.println("\n" + callingClass + " calls:");
			
			for (String calledClass : callGraph.get(callingClass))
				System.out.println("--> " + calledClass);
		}
	}
	
	// COUPLING GRAPH	
	// Increments the coupling value bewteen two classes
	public void incrementCoupling(String firstClassName, String secondClassName)
	{
		Cluster firstClass = null,
				secondClass = null;
		
		// Navigate to find the corresponding classes
		for (Cluster cluster : clusters)
		{			
			if (cluster.getName().equals(firstClassName))
				firstClass = cluster;
			
			if (cluster.getName().equals(secondClassName))
				secondClass = cluster;
		}
		
		// Create the class if it doesn't exist yet
		if (secondClass == null)
		{
			secondClass = new Cluster(secondClassName);
			clusters.add(secondClass);
		}
		
		// Increment
		if (firstClass != secondClass)
			firstClass.increment(secondClass);
	}
	
	// Prints all coupled classes
	public void printCouplingGraph()
	{
		for (Cluster cluster : clusters)
		{
			if (!cluster.coupling.isEmpty())
			{
				System.out.println("\n" + cluster.getName() + " is coupled with:");
				
				for (Cluster coupledCluster : cluster.coupling.keySet())
					System.out.println(coupledCluster.getName()
							+ " - "
							+ (float) cluster.coupling.get(coupledCluster) / Cluster.getTotalCoupling());
			}
		}
	}
	
	// Creates a cluster tree of classes depending on their coupling
	public void createClusterTree()
	{
		while (clusters.size() > 1)
		{
			// Get the two most coupled classes
			List<Cluster> mostCoupledClusters = getMostCoupledClusters();
			Cluster firstCluster = mostCoupledClusters.get(0);
			Cluster secondCluster = mostCoupledClusters.get(1);
			
			// Group them to create a new cluster
			Cluster newCluster = new Cluster(firstCluster, secondCluster);
			updateCoupling(firstCluster, secondCluster, newCluster);
			
			// Remove them from the list
			clusters.remove(firstCluster);
			clusters.remove(secondCluster);
			
			// Add the new cluster to the list
			clusters.add(newCluster);
		}
	}
	
	// Gets the two most coupled clusters
	protected List<Cluster> getMostCoupledClusters()
	{
		List<Cluster> result = new ArrayList<>();
		Cluster firstCluster = null,
				secondCluster = null;
		int couplingValue = 0;
		
		for (Cluster cluster : clusters)
		{
			for (Cluster coupledCluster : cluster.getCoupling().keySet())
			{
				if (clusters.contains(coupledCluster) && cluster.getCoupling().get(coupledCluster) > couplingValue)
				{
					firstCluster = cluster;
					secondCluster = coupledCluster;
					couplingValue = cluster.getCoupling().get(coupledCluster);
				}
			}
		}
		
		if (couplingValue == 0)
		{
			firstCluster = clusters.get(0);
			secondCluster = clusters.get(1);
		}
		
		result.add(firstCluster);
		result.add(secondCluster);
		
		return result;
	}
	
	// Adds the coupling to "newCluster" to the clusters coupled to "firstCluster" or "secondCluster"
	protected void updateCoupling(Cluster firstCluster, Cluster secondCluster, Cluster newCluster)
	{
		for (Cluster cluster : clusters)
		{
			if (cluster.getCoupling().containsKey(firstCluster))
				cluster.updateCoupling(firstCluster, newCluster);
			
			if (cluster.getCoupling().containsKey(secondCluster))
				cluster.updateCoupling(secondCluster, newCluster);
		}
	}
	
	// Prints the cluster tree
	public void printClusterTree()
	{
		clusters.get(0).toString();
	}
	
	//
	public void selectClusters()
	{
		Stack<Cluster> stack = new Stack<>();
		stack.push(clusters.get(0));
		
		while (!stack.isEmpty())
		{
			Cluster root = stack.pop(),
					leftChild = root.getFirstCluster(),
					rightChild = root.getSecondCluster();
			
			if (true)
				;
			else
			{
				stack.push(leftChild);
				stack.push(rightChild);
			}
		}
		
		return;
	}
}
