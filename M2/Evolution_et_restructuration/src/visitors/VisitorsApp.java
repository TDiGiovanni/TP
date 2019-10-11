package visitors;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class VisitorsApp
{
	protected static final int maxMethods = 5;
	
	protected static float packageCount = 0;
	protected static float classCount = 0;
	protected static float attributeCount = 0;
	protected static float methodCount = 0;
	protected static float lineCount = 0;
	protected static List<TypeDeclaration> allClasses = new ArrayList<>();
	protected static MethodDeclaration mostParametersMethod = null;
	protected static Map<String, List<String>> callGraph = new HashMap<>();
	protected static List<Pair> pairs = new ArrayList<>();
	
	public static void main(String[] args) throws IOException 
	{
		// Gets user input
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the absolute path of the source code you want to analyse:");
		String path = s.next();
		if (path.equals("default"))
			path = "C:\\Users\\Thomas\\Documents\\Repositories\\GitHub\\TP\\M2\\Modularite_et_composants\\Eclipse\\src";
		int partNumber = -1;
		do
		{
			System.out.println("Enter which part you want to test (1 or 2):");
			partNumber = s.nextInt();
		}
		while (partNumber != 1 && partNumber != 2);
		s.close();
		
		// Parses the files based on the user input
		parseFilesInDirectory(path, partNumber);
		
		// Prints all the stuff needed
		if (partNumber == 2)
		{
			printStatistics();
			printCallGraph();
			printPairsGraph();
		}
	}
	
	// Reads the directory given by the path to parse all the files (recursive)
	public static void parseFilesInDirectory(String path, int partNumber) throws IOException
	{
		File root = new File(path);
		File[] files = root.listFiles();
 
		 for (File f : files)
		 {
			 if (f.isFile()) // Parse if it's a file
			 {
				 lineCount += FileUtils.readLines(f, Charset.defaultCharset()).size();
				 
				 if (partNumber == 1)
					 firstParse(path, FileUtils.readFileToString(f, Charset.defaultCharset()));
				 else if (partNumber == 2)
					 secondParse(path, FileUtils.readFileToString(f, Charset.defaultCharset()));
			 }
			 else if (f.isDirectory()) // Call the method again if it's a directory
			 {
				 packageCount++;
				 parseFilesInDirectory(f.getAbsolutePath(), partNumber);
			 }
		 }
	}
	
	// Sets up the parser
	public static CompilationUnit setUpParser(String sourcePath, String sourceFile)
	{
		@SuppressWarnings("deprecation")
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		String[] classpath = {"C:\\Program Files\\Java\\jdk-12.0.2\\lib\\jrt-fs.jar"};
		String[] sources = {sourcePath};
		parser.setEnvironment(classpath, sources, new String[] {"UTF-8"}, true);
		parser.setUnitName("");
		parser.setResolveBindings(true);
		parser.setBindingsRecovery(true);
		parser.setSource(sourceFile.toCharArray());
		return (CompilationUnit) parser.createAST(null);
	}
	
	// TP2.1	
	// Uses ASTParse to parse the source file, also prints all the informations asked
	public static void firstParse(String sourcePath, String sourceFile)
	{
		CompilationUnit cu = setUpParser(sourcePath, sourceFile);
		
		// Navigates type declarations inside each file
		TypeDeclarationVisitor typeDeclarationVisitor = new TypeDeclarationVisitor();
		cu.accept(typeDeclarationVisitor);
		typeDeclarationVisitor.print();
		
		// Navigates methods declarations inside each type
		MethodDeclarationVisitor methodDeclarationVisitor = new MethodDeclarationVisitor();
		cu.accept(methodDeclarationVisitor);
		methodDeclarationVisitor.print();
		
		for (MethodDeclaration method : methodDeclarationVisitor.getMethods())
		{
			System.out.println("\tIn the method " + method.getName() + ":");
			
			// Navigates method invocations inside each method
			MethodInvocationVisitor methodInvocationVisitor = new MethodInvocationVisitor();
			method.accept(methodInvocationVisitor);
			methodInvocationVisitor.print();
			
			// Navigates variables inside each method
			VariableDeclarationFragmentVisitor variableDeclarationFragmentVisitor = new VariableDeclarationFragmentVisitor();
			method.accept(variableDeclarationFragmentVisitor);
			variableDeclarationFragmentVisitor.print();
		}
	}
	
	// TP2.2	
	// Uses ASTParse to parse the source file
	public static void secondParse(String sourcePath, String sourceFile)
	{
		CompilationUnit cu = setUpParser(sourcePath, sourceFile);

		// Navigates type declarations inside each file
		TypeDeclarationVisitor typeDeclarationVisitor = new TypeDeclarationVisitor();
		cu.accept(typeDeclarationVisitor);
		classCount += typeDeclarationVisitor.getTypes().size();
		attributeCount += typeDeclarationVisitor.getAttributeCount();
		allClasses.addAll(typeDeclarationVisitor.getTypes());
		for (TypeDeclaration type : typeDeclarationVisitor.getTypes())
		{
			// Navigates method declarations inside each type
			MethodDeclarationVisitor methodDeclarationVisitor = new MethodDeclarationVisitor();
			type.accept(methodDeclarationVisitor);
			methodCount += methodDeclarationVisitor.getMethods().size();
			for (MethodDeclaration method : methodDeclarationVisitor.getMethods())
			{
				// Checks for the method with the most parameters
				if (mostParametersMethod == null || method.parameters().size() > mostParametersMethod.parameters().size())
					mostParametersMethod = method;
				
				String callingMethod = type.getName().toString() + "." + method.getName().toString(); // Key of callGraph

				// Navigates method invocations inside each method (for the call graph)
				MethodInvocationVisitor methodInvocationVisitor = new MethodInvocationVisitor();
				method.accept(methodInvocationVisitor);
				for (MethodInvocation methodInvocation : methodInvocationVisitor.getMethods())
				{
					List<String> calledMethods = callGraph.get(callingMethod); // Value of callGraph
					
					// Initialises the list if the method has not called any other methods yet
					if (calledMethods == null)
					{
						calledMethods = new ArrayList<String>();
						callGraph.put(callingMethod, calledMethods);
					}
					
					// Resolves the binding for the called methods
					String calledMethod = null;
					Expression expression = methodInvocation.getExpression();
					ITypeBinding binding = null;
					if (expression != null)
						binding = expression.resolveTypeBinding();
					if (binding != null)
					{
						calledMethod = binding.getName() + "." + methodInvocation.getName();
						createPair(type.getName().toString(), binding.getName());
					}
					if (calledMethod != null && !calledMethods.contains(calledMethod))
						calledMethods.add(calledMethod);					
				}
			}
		}
	}
	
	// Sorts the array of classes given as a parameter, used to show the relevant statistic
	public static List<TypeDeclaration> sortClassesByAttributes(List<TypeDeclaration> classes)
	{
		Collections.sort(classes, new Comparator<TypeDeclaration>()
		{
			@Override
		    public int compare(TypeDeclaration class2, TypeDeclaration class1)
		    {
		        return Integer.compare(class1.getFields().length, class2.getFields().length);
		    }
		});
		
		List<TypeDeclaration> resultClasses = new ArrayList<>();
		for (int i = 0; i < (classes.size() / 10); i++)
			resultClasses.add(classes.get(i));
			
		return resultClasses;
	}
	
	// Sorts the array of classes given as a parameter, used to show the relevant statistic
	public static List<TypeDeclaration> sortClassesByMethods(List<TypeDeclaration> classes)
	{
		Collections.sort(classes, new Comparator<TypeDeclaration>()
		{
			@Override
		    public int compare(TypeDeclaration class2, TypeDeclaration class1)
		    {
		        return Integer.compare(class1.getMethods().length, class2.getMethods().length);
		    }
		});
		
		List<TypeDeclaration> resultClasses = new ArrayList<>();
		for (int i = 0; i < (classes.size() / 10); i++)
			resultClasses.add(classes.get(i));
			
		return resultClasses;
	}
	
	// Prints all the statistics demanded
	public static void printStatistics()
	{
		System.out.println("Number of packages: " + packageCount);
		System.out.println("Number of classes: " + classCount);
		System.out.println("Number of methods: " + methodCount);
		System.out.println("Number of lines of code: " + lineCount);
		
		System.out.println("Average number of attributes per class: " + attributeCount / classCount);
		System.out.println("Average number of methods per class: " + methodCount / classCount);
		System.out.println("Average number of lines of code per method: " + lineCount / methodCount);
		
		System.out.println("10% of classes with the most attributes: ");
		List<TypeDeclaration> tempAttributeClasses = sortClassesByAttributes(allClasses);
		for (TypeDeclaration attributeClass : tempAttributeClasses)
			System.out.println(attributeClass.getName());
		
		System.out.println("10% of classes with the most methods: ");
		List<TypeDeclaration> tempMethodClasses = sortClassesByMethods(allClasses);
		for (TypeDeclaration methodClass : tempMethodClasses)
			System.out.println(methodClass.getName());
		
		List<TypeDeclaration> tempBothClasses = new ArrayList<>();
		for (TypeDeclaration attributeClass : tempAttributeClasses)
			if (tempMethodClasses.contains(attributeClass))
				tempBothClasses.add(attributeClass);
		System.out.println("Classes in both: ");
		for (TypeDeclaration bothClass : tempBothClasses)
			System.out.println(bothClass.getName());
		
		System.out.println("Classes with more than " + maxMethods + " methods: ");
		for (TypeDeclaration classType : allClasses)
			if (classType.getMethods().length > maxMethods)
				System.out.println(classType.getName());
		
		System.out.println("10% of methods with the most lines of code: ");
		//TODO: Calculate lines of code
		
		System.out.println("Method with the most parameters: " + mostParametersMethod.getName());
	}
	
	// Prints the call graph
	public static void printCallGraph()
	{
		System.out.println("Call graph:");
		
		for (String callingClass : callGraph.keySet())
		{
			System.out.println(callingClass);
			
			for (String calledClass : callGraph.get(callingClass))
				System.out.println("--> " + calledClass);
		}
	}
	
	// TP3
	// Creates the pair if it doesn't exist, otherwise increment the value
	public static void createPair(String firstClass, String secondClass)
	{
		Pair pair = getPair(firstClass, secondClass);
		
		if (pair == null)
			pairs.add(new Pair(firstClass, secondClass));
		else
			pair.increment();
	}
	
	// Gets the pair of the two classes
	public static Pair getPair(String firstClass, String secondClass)
	{		
		for (Pair pair : pairs)
			if ((pair.getFirst().equals(firstClass) && pair.getSecond().equals(secondClass))
					|| (pair.getFirst().equals(secondClass) && pair.getSecond().equals(firstClass)))
				return pair;
		
		return null;
	}
	
	// Adds up the values of all pairs
	public static int getTotalPairValue()
	{
		int result = 0;
		
		for (Pair pair : pairs)
				result += pair.getValue();
		
		return result;
	}
	
	// Prints the graph of all pairs
	public static void printPairsGraph()
	{
		System.out.println("Pairs graph:");
		
		for (Pair pair : pairs)
			if (pair.getValue() != 0)
				System.out.println(pair.getFirst() + " - " + pair.getValue() + " - " + pair.getSecond());
	}
	
	// Sorts the array given as a parameter
	public static List<Pair> sortPairs(List<Pair> pairs)
	{
		Collections.sort(pairs, new Comparator<Pair>()
		{
			@Override
		    public int compare(Pair pair2, Pair pair1)
		    {
		        return Integer.compare(pair1.getValue(), pair2.getValue());
		    }
		});
		
		List<Pair> resultPairs = new ArrayList<>();
		for (int i = 0; i < (pairs.size() / 10); i++)
			resultPairs.add(pairs.get(i));
			
		return resultPairs;
	}
	
	// Creates a clustering of classes
	public static void cluster()
	{
		List<Pair> sortedPairs = sortPairs(pairs);
		Pair firstPair = null,
				secondPair = null,
				newPair = null;
		
		while (!sortedPairs.isEmpty())
		{
			firstPair = sortedPairs.get(0);
			secondPair = sortedPairs.get(1);
			newPair = new Pair(firstPair.getFirst() + "-" +firstPair.getSecond(),
					secondPair.getFirst() + "-" +secondPair.getSecond(),
					firstPair.getValue() + secondPair.getValue());
		}
	}
}
