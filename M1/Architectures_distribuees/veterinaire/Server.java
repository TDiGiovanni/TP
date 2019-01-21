package veterinaire;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("java.security.policy", "security.policy");
		System.setSecurityManager(new SecurityManager());
		
		Cabinet cabinet = new Cabinet();
		cabinet.add(new Animal("a1","m1",new Espece(),"test"));
		cabinet.add(new Animal("a2","m2",new Espece(),"truc"));
		
		Registry registry = LocateRegistry.createRegistry(1099);
		//Registry registry = LocateRegistry.getRegistry();
		
		if (registry == null)
			System.err.println("RMI registry not found");
		else
		{
			registry.bind("cabinet", cabinet);
			System.out.println("Server ready");
		}
	}
}
