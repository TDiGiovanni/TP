package veterinaryShared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IVeterinary extends Remote
{
	public String getName() throws RemoteException;
	
	public void alert(int patients) throws RemoteException;
}
