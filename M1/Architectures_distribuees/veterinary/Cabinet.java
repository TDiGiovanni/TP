package veterinary;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Cabinet extends UnicastRemoteObject implements ICabinet
{
	private static final long serialVersionUID = 1L;
	protected List<IAnimal> patients;
	protected List<Veterinary> veterinaries;

	protected Cabinet() throws RemoteException
	{
		super();
		patients = new ArrayList<IAnimal>();
		veterinaries = new ArrayList<Veterinary>();
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
	
	public void login(Veterinary veterinary) throws RemoteException
	{
		veterinaries.add(veterinary);
	}
	
	public void logout(Veterinary veterinary) throws RemoteException
	{
		veterinaries.remove(veterinary);
	}
	
	public void checkThreshold() throws RemoteException
	{
		if (patients.size() == 1
				|| patients.size() == 5
				|| patients.size() == 10)
			for (Veterinary veterinary : veterinaries)
				veterinary.alert(patients.size());
	}
}
