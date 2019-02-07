package veterinaryShared;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Clinic extends UnicastRemoteObject implements IClinic
{
	private static final long serialVersionUID = 1L;
	protected List<IAnimal> patients;
	protected List<IVeterinary> veterinaries;

	public Clinic() throws RemoteException
	{
		super();
		patients = new ArrayList<IAnimal>();
		veterinaries = new ArrayList<IVeterinary>();
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
		this.checkThreshold();
	}
	
	public void remove(IAnimal patient) throws RemoteException
	{
		patients.remove(patient);
		System.out.println("Patient " + patient.getName() + " removed");
		this.checkThreshold();
	}
	
	public void print() throws RemoteException
	{
		for (IAnimal patient : patients)
			System.out.println(patient.print());
	}
	
	public void login(IVeterinary veterinary) throws RemoteException
	{
		veterinaries.add(veterinary);
		System.out.println("Veterinary " + veterinary.getName() + " logged in");
	}
	
	public void logout(IVeterinary veterinary) throws RemoteException
	{
		veterinaries.remove(veterinary);
		System.out.println("Veterinary " + veterinary.getName() + " logged out");
	}
	
	public void checkThreshold() throws RemoteException
	{
		if (patients.size() == 1
				|| patients.size() == 5
				|| patients.size() == 10)
		{
			System.out.println("Warning: " + patients +" patients currently registered");
			for (IVeterinary veterinary : veterinaries)
				veterinary.alert(patients.size());
		}
	}
}
