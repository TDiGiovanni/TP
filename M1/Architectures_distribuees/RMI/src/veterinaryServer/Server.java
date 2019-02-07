package veterinaryServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import veterinaryShared.Clinic;

public class Server
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("java.security.policy", "securityServer.policy");
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new SecurityManager());
		
		Clinic clinic = new Clinic();
		/*
		Species s = new Species("speciesTest",10);
		File f = new File();
		clinic.add(new Animal("nameTest", "ownerTest", s, "breedTest", f));
		*/
		
		Registry registry = LocateRegistry.createRegistry(1099);
		
		if (registry == null)
			System.err.println("RMI registry not found");
		else
		{
			registry.bind("clinic", clinic);
			System.out.println("Server ready");
		}
	}
}
