package veterinaryClient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import veterinaryShared.IAnimal;
import veterinaryShared.IClinic;
import veterinaryShared.IVeterinary;

public class Client
{
	public static void main(String[] args) throws Exception
	{
		Registry registry = LocateRegistry.getRegistry(1099);

		IClinic clinic = (IClinic) registry.lookup("clinic");

		Scanner sc = new Scanner(System.in);

		// Creation of the user
		System.out.println("Enter your name:");
		IVeterinary veterinary = (IVeterinary) new Veterinary(sc.next());
		clinic.login(veterinary);

		// Main loop
		boolean loop = true;
		while (loop)
		{
			System.out.println("1- Find a patient \n"
					+ "2- Add a patient \n"
					//+ "3- Remove a patient \n"
					+ "4- Leave \n"
					+ "Enter your choice:");
			
			switch(sc.nextInt())
			{
			case 1: // Find
				System.out.println("Name of the patient:");
				
				IAnimal patient = clinic.getAnimal(sc.next());
				if (patient != null)
					System.out.println(patient.print());
				else
					System.out.println("Patient not found \n");
				break;

			case 2: // Add
				System.out.println("Name of the patient:");
				
				clinic.add(new Animal(sc.next()));
				System.out.println("Patient added \n");
				break;
			/*
			case 3: // Remove
				System.out.println("Name of the patient:");
			
				clinic.remove(new Animal(sc.next()));
				System.out.println("Patient removed \n");
				break;
			*/
			case 4: // Leave
				loop = false;
				break;

			default:
				break;
			}
		}

		clinic.logout(veterinary);
		sc.close();
	}
}
