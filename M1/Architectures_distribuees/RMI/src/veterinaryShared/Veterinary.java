package veterinaryShared;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Veterinary extends UnicastRemoteObject implements IVeterinary
{
	private static final long serialVersionUID = 1L;
	protected String name;
	
	public Veterinary() throws RemoteException
	{
		this.name = "Unknown";
	}
	
	public Veterinary(String name) throws RemoteException
	{
		this.name = name;
	}
	
	public String getName() throws RemoteException
	{
		return this.name;
	}
	
	public void alert(int patients) throws RemoteException
	{
		System.out.println("Warning: " + patients +" patients currently registered");
	}
}
