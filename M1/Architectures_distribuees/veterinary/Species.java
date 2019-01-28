package veterinary;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Species extends UnicastRemoteObject implements Remote
{
	private static final long serialVersionUID = 1L;
	protected String name;
	protected int averageLifespan;
	
	protected Species(String name, int lifespan) throws RemoteException
	{
		super();
		this.name = name;
		this.averageLifespan = lifespan;
	}
	
	public String getName() throws RemoteException
	{
		return this.name;
	}
	
	public int getAverageLifespan() throws RemoteException
	{
		return this.averageLifespan;
	}
}
