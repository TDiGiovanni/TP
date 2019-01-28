package veterinary;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class File extends UnicastRemoteObject implements IFile
{
	private static final long serialVersionUID = 1L;
	protected String suivi;
	
	protected File() throws RemoteException
	{
		super();
		this.suivi = "Unknown";
	}
	
	public String getSuivi() throws RemoteException
	{
		return this.suivi;
	}
	
	public void setSuivi(String suivi) throws RemoteException
	{
		this.suivi = suivi;
	}
}
