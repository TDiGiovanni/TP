package visitors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;

public class Main
{
	public static void main(String[] args) throws IOException 
	{
		ParseFilesInPackage("stockage");
	}
	
	// Loops directory to get file list
	public static void ParseFilesInPackage(String packageName) throws IOException
	{
		String path = new File(".").getCanonicalPath() + File.separator + "src" + File.separator + packageName + File.separator;
		File root = new File(path);
		File[] files = root.listFiles();
		String filePath = null;
 
		 for (File f : files)
		 {
			 filePath = f.getAbsolutePath();
			 if (f.isFile())
			 {
				 System.out.println("\nReading file " + f.getName() + ":");
				 parse(readFileToString(filePath));
			 }
		 }
	}
	
	// Reads file content into a string
	public static String readFileToString(String filePath) throws IOException
	{
		StringBuilder fileData = new StringBuilder(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
 
		char[] buf = new char[10];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1)
		{
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
 
		reader.close();
 
		return fileData.toString();	
	}
	
	// Uses ASTParse to parse the string
	public static void parse(String source)
	{
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setSource(source.toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
 
		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
		
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
}
