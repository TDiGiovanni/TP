package veterinary;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IVeterinary extends Remote
{
	public void alert(int patients) throws RemoteException;
}
