package veterinary;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client
{
	public static void main(String[] args) throws Exception
	{		
		Registry registry = LocateRegistry.getRegistry(1099);

		ICabinet cabinet = (ICabinet) registry.lookup("cabinet");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name:");
		Veterinary veterinary = new Veterinary(sc.next());
		cabinet.login(veterinary);
		
		System.out.println("Find (enter 1) or add (enter 2) a patient:");
		switch(sc.nextInt())
		{
		case 1:
			System.out.println("Name of the patient to find:");
			IAnimal patient = cabinet.getAnimal(sc.next());
			if (patient != null)
				System.out.println(patient.print());
			else
				System.out.println("Patient not found");
			break;

		case 2:
			System.out.println("Name of the patient to create:");
			cabinet.add(new Animal(sc.next()));
			System.out.println("Patient added");
			break;
		}
		
		cabinet.logout(veterinary);
		sc.close();
	}
}
