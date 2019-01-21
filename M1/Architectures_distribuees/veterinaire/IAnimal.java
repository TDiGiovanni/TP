package veterinaire;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAnimal extends Remote
{
	public String print() throws RemoteException;
}
