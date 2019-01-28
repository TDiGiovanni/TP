package veterinary;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICabinet extends Remote
{	
	public IAnimal getAnimal(String name) throws RemoteException;
	
	public void add(IAnimal patient) throws RemoteException;
}
