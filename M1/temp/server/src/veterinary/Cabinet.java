package veterinary;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import veterinary.IAnimal;
import veterinary.ICabinet;

public class Cabinet extends UnicastRemoteObject implements ICabinet
{
	private static final long serialVersionUID = 1L;
	protected List<IAnimal> patients;

	protected Cabinet() throws RemoteException
	{
		super();
		patients = new ArrayList<IAnimal>();
	}
	
	public IAnimal getAnimal(String name) throws RemoteException
	{
		for (IAnimal patient : patients)
			if (patient.getName().equals(name))
				return patient;
		
		return null;
	}
	
	public void add(IAnimal patient) throws RemoteException
	{
		patients.add(patient);
		System.out.println("Patient " + patient.getName() + " added");
	}
	
	public void remove(IAnimal patient) throws RemoteException
	{
		patients.remove(patient);
		System.out.println("Patient " + patient.getName() + " removed");
	}
	
	public void print() throws RemoteException
	{
		for (IAnimal patient : patients)
			System.out.println(patient.print());
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
