package veterinaire;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client
{
	public static void main(String[] args) throws Exception
	{
		String host = (args.length < 1) ? null : args[0];
		Registry registry = LocateRegistry.getRegistry(host);
		
		ICabinet stub = (ICabinet) registry.lookup("cabinet");
		
		Animal patient = stub.getAnimal("a1");
		if (patient != null)
			System.out.println(patient.print());
		else
			System.out.println("Patient introuvable");
	}
}
