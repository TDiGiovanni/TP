package veterinaire;

import java.rmi.RemoteException;

public class Espece implements IEspece
{
	protected String name;
	protected int averageLifespan;
	
	public String getName() throws RemoteException
	{
		return this.name;
	}
	
	public int getAverageLifespan() throws RemoteException
	{
		return this.averageLifespan;
	}
}
