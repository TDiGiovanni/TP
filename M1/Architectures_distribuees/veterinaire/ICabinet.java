package veterinaire;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICabinet extends Remote
{	
	public Animal getAnimal(String name) throws RemoteException;
	
	public void add(Animal patient) throws RemoteException;
}
