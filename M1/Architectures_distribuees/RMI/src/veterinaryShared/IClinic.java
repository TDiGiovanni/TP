package veterinaryShared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClinic extends Remote
{	
	public IAnimal getAnimal(String name) throws RemoteException;
	
	public void add(IAnimal patient) throws RemoteException;
	
	//public void remove(IAnimal patient) throws RemoteException;
	
	public void login(IVeterinary veterinary) throws RemoteException;
	
	public void logout(IVeterinary veterinary) throws RemoteException;
}
