package veterinaryShared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISpecies extends Remote
{
	public String getName() throws RemoteException;
	
	public int getAverageLifespan() throws RemoteException;
}
