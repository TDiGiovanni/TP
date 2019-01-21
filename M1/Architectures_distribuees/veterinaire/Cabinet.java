package veterinaire;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Cabinet extends UnicastRemoteObject implements ICabinet
{
	protected List<Animal> patients;

	protected Cabinet() throws RemoteException
	{
		patients = new ArrayList<Animal>();
	}
	
	public Animal getAnimal(String name) throws RemoteException
	{
		for (Animal patient : patients)
			if (patient.nom.equals(name))
				return patient;
		
		return null;
	}
	
	public void add(Animal patient) throws RemoteException
	{
		patients.add(patient);
	}
	
	public void remove(Animal patient) throws RemoteException
	{
		patients.remove(patient);
	}
	
	public boolean checkThreshold()
	{
		if (patients.size() == 100
				|| patients.size() == 500
				|| patients.size() == 1000)
			return true;
		return false;
	}
}
