package veterinaryShared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAnimal extends Remote
{
	public String getName() throws RemoteException;
	
	public ISpecies getSpecies() throws RemoteException;
	
	public IFile getFile() throws RemoteException;
	
	public String print() throws RemoteException;
}
