package mapsTest;

import Maps.*;

import java.util.ArrayList;

import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLResource.XMLMap;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;

public class Test
{
	public static void main(String[] args)
	{		
		// Je charge l'instance map.xmi du meta-modele maps.ecore
		Resource resource = loadModel("model/Maps.xmi", MapsPackage.eINSTANCE);
		if (resource == null)
			System.err.println(" Erreur de chargement du modÃ¨le");
		
		// Instruction recuperant le modele sous forme d'arbre a partir de la classe racine "map"
		Map myMap = (Map) resource.getContents().get(0);
		
		System.out.println("List of all the streets :");
		for (Street street : getStreets(myMap))
			System.out.println(street.getName());
		
		System.out.println("List of all the pedestrians over 1000m length :");
		for (Pedestrian pedestrian : getPedestriansOver1000(myMap))
			System.out.println(pedestrian.getName());
		
		System.out.println("List of all the roads adjacents to st1:");
		for (Road road : getAdjacentStreets(myMap, "st1"))
			System.out.println(road.getName());
		
		System.out.println("List of all the roads bordering sq1 :");
		for (Road road : getBorderingStreets(myMap, "sq1"))
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
		      java.util.Map<String, XMLMap> options = new java.util.HashMap<String, XMLMap>();
		      options.put(XMLResource.OPTION_XML_MAP, xmlMap);
		      resource.load(options);
		   }
		   catch (Exception e)
		   {
		      System.err.println("ERREUR chargement du modèle : " + e);
		      e.printStackTrace();
		   }
		   
		   return resource;
	}
	
	// Returns all the streets
	public static ArrayList<Street> getStreets(Map map)
	{
		ArrayList<Street> result = new ArrayList<>();
		
		for (Road road : map.getRoads())
			if (road instanceof Street)
				result.add((Street) road);
				
		return result;
	}
	
	// Returns all pedestrians over 1000m length
	public static ArrayList<Pedestrian> getPedestriansOver1000(Map map)
	{
		ArrayList<Pedestrian> result = new ArrayList<>();
		
		for (Road road : map.getRoads())
			if (road instanceof Pedestrian
					&& road.getLength() > 1000)
				result.add((Pedestrian) road);
				
		return result;
	}
	
	// Returns all roads adjacent to "streetName"
	public static EList<Road> getAdjacentStreets(Map map, String streetName)
	{
		for (Road road : map.getRoads())
			if (road instanceof Street
					&& road.getName().equals(streetName))
				return road.getMeet();
		
		return null;
	}
	
	// Returns all the roads bordering "squareName"
	public static EList<Road> getBorderingStreets(Map map, String squareName)
	{
		for (PublicSpace publicSpace : map.getSpaces())
			if (publicSpace instanceof Square
					&& publicSpace.getName().equals(squareName))
				return publicSpace.getBorderedBy();
		
		return null;
	}
}