package veterinaire;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEspece extends Remote
{
	public String getName() throws RemoteException;
	public int getAverageLifespan() throws RemoteException;
}
