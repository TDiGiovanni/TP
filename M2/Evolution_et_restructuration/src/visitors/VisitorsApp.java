package visitors;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
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

import spoon.Launcher;

public class VisitorsApp
{
	protected static Tracker tracker = new Tracker();
	
	public static void main(String[] args) throws IOException 
	{
		// Get user input
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the absolute path of the source code you want to analyse:");
		String path = s.next();
		if (path.equals("default"))
			path = "C:\\Users\\Thomas\\Documents\\Repositories\\GitHub\\TP\\M2\\Modularite_et_composants\\Eclipse\\Others\\src";
		
		System.out.println("With Spoon? (y/n)");
		String spoon = null;
		do
		{
			spoon = s.next();
			if (path.equals("default"))
				path = "C:\\Users\\Thomas\\Documents\\Repositories\\GitHub\\TP\\M2\\Modularite_et_composants\\Eclipse\\Others\\src";
		}
		while (!spoon.equals("y") && !spoon.equals("n"));
		
		// Parse the files based on the user input
		if (spoon.equals("y"))
			spoonParse(path);
		else
			parseFilesInDirectory(path);
		
		// Print everything
		tracker.print();
		
		s.close();
	}
	
	// Reads the directory given by the path to parse all the files (recursive)
	protected static void parseFilesInDirectory(String path) throws IOException
	{
		File root = new File(path);
		File[] files = root.listFiles();
 
		 for (File f : files)
		 {
			 if (f.isFile()) // Parse if it's a file
			 {
				 tracker.lineCount += FileUtils.readLines(f, Charset.defaultCharset()).size();
				 
				 parse(path, FileUtils.readFileToString(f, Charset.defaultCharset()));
			 }
			 else if (f.isDirectory()) // Call the method again if it's a directory
			 {
				 tracker.packageCount++;
				 
				 parseFilesInDirectory(f.getAbsolutePath());
			 }
		 }
	}
	
	// Sets up the parser
	protected static CompilationUnit setUpParser(String sourcePath, String sourceFile)
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
	
	// Uses ASTParse to parse the source file, also prints the relevant informations
	protected static void parse(String sourcePath, String sourceFile)
	{
		CompilationUnit cu = setUpParser(sourcePath, sourceFile);

		// Visit the file to look for declared types, and updates all the tracker infos
		TypeDeclarationVisitor typeDeclarationVisitor = new TypeDeclarationVisitor();
		cu.accept(typeDeclarationVisitor);
		typeDeclarationVisitor.print();
		tracker.classCount += typeDeclarationVisitor.getTypes().size();
		tracker.attributeCount += typeDeclarationVisitor.getAttributeCount();
		tracker.allClasses.addAll(typeDeclarationVisitor.getTypes());
		
		// Navigate type declarations from the visitor
		for (TypeDeclaration type : typeDeclarationVisitor.getTypes())
		{
			String typeName = type.getName().toString();
			
			// Create our representation of the class (if it hasn't been done yet)
			boolean isCreated = false;
			for (Cluster cluster : tracker.clusters)
			{
				if (cluster.getName().equals(typeName))
				{
					isCreated = true;
				}
			}
			if (!isCreated)
			{
				tracker.clusters.add(new Cluster(typeName));
			}
			
			// Visit the type to look for declared methods, and updates all the tracker infos
			MethodDeclarationVisitor methodDeclarationVisitor = new MethodDeclarationVisitor();
			type.accept(methodDeclarationVisitor);
			methodDeclarationVisitor.print();
			tracker.methodCount += methodDeclarationVisitor.getMethods().size();
			
			// Navigate method declarations from the visitor
			for (MethodDeclaration method : methodDeclarationVisitor.getMethods())
			{
				System.out.println("\tIn the method " + method.getName() + ":");
				
				// Name of the declared method
				String methodName = typeName + "." + method.getName().toString();
				
				// Visit the method declared to look for variable declarations
				VariableDeclarationFragmentVisitor variableDeclarationFragmentVisitor = new VariableDeclarationFragmentVisitor();
				method.accept(variableDeclarationFragmentVisitor);
				variableDeclarationFragmentVisitor.print();
				
				// Check for the method with the most parameters
				if (tracker.mostParametersMethod == null || method.parameters().size() > tracker.mostParametersMethod.parameters().size())
					tracker.mostParametersMethod = method;
				

				// Visit the method declared to look for invoked methods, and updates all the tracker infos
				MethodInvocationVisitor methodInvocationVisitor = new MethodInvocationVisitor();
				method.accept(methodInvocationVisitor);
				methodInvocationVisitor.print();
				
				// Navigate method invocations from the visitor
				for (MethodInvocation methodInvocation : methodInvocationVisitor.getMethods())
				{
					// Get the list of methods called by the method declared
					List<String> calledMethods = tracker.callGraph.get(methodName);
					
					// Initialise the list if the method has not called any other method yet
					if (calledMethods == null)
					{
						calledMethods = new ArrayList<String>();
						tracker.callGraph.put(methodName, calledMethods);
					}
					
					// Resolve the binding for the current method invocation
					String calledClass = null,
							calledMethod = null;
					Expression expression = methodInvocation.getExpression();
					ITypeBinding binding = null;
					if (expression != null)
						binding = expression.resolveTypeBinding();
					
					// Add it to the list if the binding worked, and increment the coupling between the two classes
					if (binding != null)
					{
						calledClass = binding.getName();
						calledMethod = calledClass + "." + methodInvocation.getName();
						tracker.incrementCoupling(typeName, calledClass);
					}
					if (calledMethod != null && !calledMethods.contains(calledMethod))
						calledMethods.add(calledMethod);
				}
			}
		}
	}
	
	// Spoon usage
	protected static void spoonParse(String sourcePath)
	{
		Launcher launcher = new Launcher();
		
		launcher.addInputResource(sourcePath);

		launcher.buildModel();
	}
}
