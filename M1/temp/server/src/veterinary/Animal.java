package veterinary;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import veterinary.IAnimal;
import veterinary.IFile;
import veterinary.ISpecies;

public class Animal extends UnicastRemoteObject implements IAnimal
{
	private static final long serialVersionUID = 1L;
	protected String name;
	protected String ownerName;
	protected Species species;
	protected String breed;
	protected File file;

	public Animal() throws RemoteException
	{
		super();
		this.name = "Unknown";
		this.ownerName = "Unknown";
		this.species = null;
		this.breed = "Unknown";
		this.file = null;

	}

	public Animal(String nom) throws RemoteException
	{
		super();
		this.name = nom;
		this.ownerName = "Unknown";
		this.species = null;
		this.breed = "Unknown";
		this.file = null;
	}

	public Animal(String nom, String nomMaitre, Species species, String breed, File file) throws RemoteException
	{
		this.name = nom;
		this.ownerName = nomMaitre;
		this.species = species;
		this.breed = breed;
		this.file = file;
	}

	public String getName() throws RemoteException
	{
		return this.name;
	}

	public ISpecies getSpecies() throws RemoteException
	{
		return (ISpecies) this.species;
	}

	public IFile getFile() throws RemoteException
	{
		return this.file;
	}

	public String print() throws RemoteException
	{
		String result = "Nom : " + name 
				+ "\nOwner name: " + this.ownerName;

		if (this.species != null)
			result += "\nSpecies: " + species.getName();
		
		result += "\nBreed: " + this.breed;

		if (this.file != null)
			result += "\nFile: " + file.getSuivi();
		
		return result;
	}
}
