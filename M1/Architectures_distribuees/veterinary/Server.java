package veterinary;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("java.security.policy", "securite.policy");
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new SecurityManager());
		
		Cabinet cabinet = new Cabinet();
		//Species s = new Species("speciesTest",10);
		//File f = new File();
		//cabinet.add(new Animal("nameTest", "ownerTest", s, "breedTest", f));
		
		Registry registry = LocateRegistry.createRegistry(1099);
		
		if (registry == null)
			System.err.println("RMI registry not found");
		else
		{
			registry.bind("cabinet", cabinet);
			System.out.println("Server ready");
		}
	}
}
