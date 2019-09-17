package test;

import Maps.*;

import java.util.ArrayList;

import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;

public class Test
{
	public static void main(String[] args)
	{		
		// Je charge l'instance map.xmi du méta-modèle maps.ecore
		Resource resource = loadModel("model/Maps.xmi", MapsPackage.eINSTANCE);
		if (resource == null)
			System.err.println(" Erreur de chargement du modèle");
		
		// Instruction récupérant le modèle sous forme d'arbre à partir de la classe racine "map"
		Map myMap = (Map) resource.getContents().get(0);
			
		for (Road road : getStreets(myMap))
			System.out.println(road.getName());
	}
	
	public static Resource loadModel(String uri, EPackage pack)
	{
		   Resource resource = null;
		   
		   try
		   {
		      URI uriUri = URI.createURI(uri);
		      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		      resource = (new ResourceSetImpl()).createResource(uriUri);
		      XMLResource.XMLMap xmlMap = new XMLMapImpl();
		      xmlMap.setNoNamespacePackage(pack);
		      java.util.Map options = new java.util.HashMap();
		      options.put(XMLResource.OPTION_XML_MAP, xmlMap);
		      resource.load(options);
		   }
		   catch (Exception e)
		   {
		      System.err.println("ERREUR chargement du modèle : "+e);
		      e.printStackTrace();
		   }
		   
		   return resource;
	}
	
	// Returns all the streets
	public static EList<Road> getStreets(Map map)
	{		
		return map.getRoads();
	}
	
	// Returns all pedestrians over 1000m length
	public static ArrayList<Road> getPedestriansOver1000(Map map)
	{
		ArrayList<Road> result = new ArrayList<>();
		
		for (Road road : map.getRoads())
			if (road.getLength() > 1000)
				result.add(road);
				
		return result;
	}
	
	// Returns all roads adjacent to "streetName"
	public static EList<Road> getAdjacentStreets(Map map, String streetName)
	{
		for (Road road : map.getRoads())
			if (road.getName() == streetName)
				return road.getMeet();
		
		return null;
	}
	
	// Returns all the roads bordering "squareName"
	public static EList<Road> getBorderingStreets(Map map, String squareName)
	{
		for (PublicSpace publicSpace : map.getSpaces())
			if (publicSpace.getName() == squareName)
				return publicSpace.getBorderedBy();
		
		return null;
	}
}