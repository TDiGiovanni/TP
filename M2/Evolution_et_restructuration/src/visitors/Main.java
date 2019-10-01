package visitors;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class Main
{
	protected static int packageCount = 0;
	protected static int classCount = 0;
	protected static int attributeCount = 0;
	protected static int methodCount = 0;
	protected static int lineCount = 0;
	protected static List<TypeDeclaration> allClasses = new ArrayList<>();
	protected static MethodDeclaration mostParametersMethod = null;
	
	public static void main(String[] args) throws IOException 
	{
		int x = 5;
		
		// Gets user input
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the absolute path of the source code you want to analyse:");
		String path = s.next();
		if (path.equals("default"))
			path = "C:\\Users\\Thomas\\Documents\\Repositories\\GitHub\\TP\\M2\\Reutilisation_et_composants\\Eclipse\\src";
		System.out.println("Enter which part you want to test (1, 2, or 3):");
		int partNumber = s.nextInt();
		s.close();
		
		// Parses the files based on the user input
		parseFilesInDirectory(path, partNumber);
		
		// Prints all the statistics for part 2
		if (partNumber == 2)
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
			
			System.out.println("Classes with more than " + x + " methods: ");
			for (TypeDeclaration classType : allClasses)
				if (classType.getMethods().length > x)
					System.out.println(classType.getName());
			
			System.out.println("10% of methods with the most lines of code: ");
			//TODO
			
			System.out.println("Method with the most parameters: " + mostParametersMethod.getName());
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
				 if (partNumber == 1)
					 firstParse(path, FileUtils.readFileToString(f));
				 else if (partNumber == 2)
				 {
					 lineCount += FileUtils.readLines(f).size();
					 secondParse(path, FileUtils.readFileToString(f));
				 }
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
	
	// PART 1	
	// Uses ASTParse to parse the source file, also prints all the informations asked
	public static void firstParse(String sourcePath, String sourceFile)
	{
		CompilationUnit cu = setUpParser(sourcePath, sourceFile);
		
		// Navigates class declarations and its attributes
		TypeDeclarationVisitor typeDeclarationVisitor = new TypeDeclarationVisitor();
		cu.accept(typeDeclarationVisitor);
		typeDeclarationVisitor.print();
		
		// Navigates methods declarations
		MethodDeclarationVisitor methodDeclarationVisitor = new MethodDeclarationVisitor();
		cu.accept(methodDeclarationVisitor);
		methodDeclarationVisitor.print();
		
		for (MethodDeclaration method : methodDeclarationVisitor.getMethods())
		{
			System.out.println("\tIn the method " + method.getName() + ":");
			
			// Navigates methods invocations inside method
			MethodInvocationVisitor methodInvocationVisitor = new MethodInvocationVisitor();
			method.accept(methodInvocationVisitor);
			methodInvocationVisitor.print();
			
			// Navigates variables inside method
			VariableDeclarationFragmentVisitor variableDeclarationFragmentVisitor = new VariableDeclarationFragmentVisitor();
			method.accept(variableDeclarationFragmentVisitor);
			variableDeclarationFragmentVisitor.print();
		}
	}
	
	// PART 2	
	// Uses ASTParse to parse the source file
	public static void secondParse(String sourcePath, String sourceFile)
	{
		CompilationUnit cu = setUpParser(sourcePath, sourceFile);
		
		// Navigates class declarations and its attributes
		TypeDeclarationVisitor typeDeclarationVisitor = new TypeDeclarationVisitor();
		cu.accept(typeDeclarationVisitor);
		classCount += typeDeclarationVisitor.getTypes().size();
		attributeCount += typeDeclarationVisitor.getAttributeCount();
		allClasses.addAll(typeDeclarationVisitor.getTypes());
		
		// Navigates methods declarations
		MethodDeclarationVisitor methodDeclarationVisitor = new MethodDeclarationVisitor();
		cu.accept(methodDeclarationVisitor);
		methodCount += methodDeclarationVisitor.getMethods().size();
		
		// Checks for the method with the most parameters
		for (MethodDeclaration method : methodDeclarationVisitor.getMethods())
		{
			if (mostParametersMethod == null || method.parameters().size() > mostParametersMethod.parameters().size())
				mostParametersMethod = method;
		}
	}
	
	// Sorts the array of classes, used to show the relevant statistic
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
	
	// PART 3
	//TODO
}
