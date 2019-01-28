package veterinary;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("java.rmi.server.codebase", "file://auto_home/tdigiovanni/Bureau/TP/M1/temp/server/src");
		System.setProperty("java.security.policy", "securite.policy");
		if (System.getSecurityManager() == null)
			
			System.setSecurityManager(new SecurityManager());
		
		Cabinet cabinet = new Cabinet();
		Species e = new Species("e",10);
		File d = new File();
		cabinet.add(new Animal("a1", "m1", e, "r1", d));
		cabinet.add(new Animal("a2", "m2", e, "r2", d));
		
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
