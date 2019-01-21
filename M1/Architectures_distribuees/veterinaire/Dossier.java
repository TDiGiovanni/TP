package veterinaire;

import java.rmi.RemoteException;

public class Dossier implements IDossier
{
	protected String suivi;
	
	public String getSuivi() throws RemoteException
	{
		return this.suivi;
	}
	
	public void setSuivi(String suivi) throws RemoteException
	{
		this.suivi = suivi;
	}
}
