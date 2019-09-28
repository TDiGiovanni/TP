package refactoring;

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
import org.eclipse.uml2.uml.UMLPackage;

public class LoadUML
{
	public static void main(String[] args)
	{
		// Instruction recuperant le modele sous forme d'arbre a partir de la classe racine "Model"
		Model umlP = loadModel("model/Packages.uml");
		
		// Modifier le modele UML		
		//TODO
		
		// Sauvegarder le modele avec son nouveau nom
		saveModel("model/" + umlP.getName() + ".uml", umlP);
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

		public static Model loadModel(String uri)
		{
		   Resource resource = null;
		   EPackage pack=UMLPackage.eINSTANCE;
		   
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
		   catch(Exception e)
		   {
		      System.err.println("Erreur chargement du modele : " + e);
		      e.printStackTrace();
		   }
		   
		   return (Model) resource.getContents().get(0);
		}
		
		public static void setPackage(Class c, Package p)
		{
			c.setPackage(p);
		}
		
		public static void setPrivate(Class c, String attributeName)
		{
			
		}
		
		public static void setSuperclass()
		{
			
		}
}
