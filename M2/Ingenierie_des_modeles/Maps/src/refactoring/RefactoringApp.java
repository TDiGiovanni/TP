package refactoring;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLResource.XMLMap;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

public class RefactoringApp
{
	public static void main(String[] args)
	{
		// Recuperation du modele
		Model model = loadModel("model/Packages.uml");
		Package p1 = (Package) model.getMember("p1");
		Package p2 = (Package) model.getMember("p2");
		Class c = (Class) p1.getMember("C");
		Class superc = (Class) p1.getMember("Superc");
		
		// Modification du modele
		setPackage(c, p2);
		
		//setPrivate(c, "a1", );
		
		EList<String> attributesNames = new BasicEList<>();
		EList<Type> attributesTypes = new BasicEList<>();
		setSuperclass(c, "m1", attributesNames, attributesTypes, superc);
		
		// Sauvegarde du nouveau modele
		saveModel("model/Result.uml", model);
	}
	
	public static Model loadModel(String uri)
	{
		Resource resource = null;
		EPackage pack = UMLPackage.eINSTANCE;
		
		try
		{
			URI uriUri = URI.createURI(uri);
		    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("uml", new XMIResourceFactoryImpl());
		    resource = (new ResourceSetImpl()).createResource(uriUri);
		    XMLResource.XMLMap xmlMap = new XMLMapImpl();
		    xmlMap.setNoNamespacePackage(pack);
		    java.util.Map<String, XMLMap> options = new java.util.HashMap<>();
		    options.put(XMLResource.OPTION_XML_MAP, xmlMap);
		    resource.load(options);
		}
		catch (Exception e)
		{
			System.err.println("Erreur chargement du modele : " + e);
		    e.printStackTrace();
		}
		   
		return (Model) resource.getContents().get(0);
	}
	
	public static void saveModel(String uri, EObject root)
	{
		Resource resource = null;
		
		try
		{
			URI uriUri = URI.createURI(uri);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		    resource = (new ResourceSetImpl()).createResource(uriUri);
		    resource.getContents().add(root);
		    resource.save(null);
		}
		catch (Exception e)
		{
			System.err.println("Erreur sauvegarde du modele : " + e);
		    e.printStackTrace();
		}
	}
	
	// Sets the package of 'c' to 'p'
	public static void setPackage(Class c, Package p)
	{
		c.setPackage(p);
	}
	
	// Sets a given attribute of 'c' to private and creates a getter and setter for it
	public static void setPrivate(Class c, String attributeName, Type attributeType)
	{
		// Switches the attribute to private
		c.getAttribute(attributeName, attributeType).setVisibility(VisibilityKind.PRIVATE_LITERAL);
		
		// Creates the getter
		c.createOwnedOperation("get" + attributeName, null, null, attributeType);
		
		// Creates the setter
		EList<String> parameterNames = new BasicEList<>();
		EList<Type> parametersTypes = new BasicEList<>();
		parameterNames.add(attributeName);
		parametersTypes.add(attributeType);
		c.createOwnedOperation("set" + attributeName, parameterNames, parametersTypes, null);
	}
	
	// Pulls back up a method of 'c' to its superclass
	// Fails if: - the given method doesn't exist in 'c'
	//			 - the given superclass is not a superclass of 'c'
	//			 - the given method already exists in the given superclass
	public static void setSuperclass(Class c, String methodName, EList<String> methodAttributesNames, EList<Type> methodAttributesTypes, Class superclass)
	{		
		superclass.createOwnedOperation(methodName, methodAttributesNames, methodAttributesTypes);
	}
}
