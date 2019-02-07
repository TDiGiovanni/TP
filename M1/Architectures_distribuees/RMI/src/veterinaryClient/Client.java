package veterinaryClient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import veterinaryShared.Animal;
import veterinaryShared.IAnimal;
import veterinaryShared.IClinic;
import veterinaryShared.Veterinary;

public class Client
{
	public static void main(String[] args) throws Exception
	{
		Registry registry = LocateRegistry.getRegistry(1099);

		IClinic clinic = (IClinic) registry.lookup("clinic");

		Scanner sc = new Scanner(System.in);

		// Creation of the user
		System.out.println("Enter your name:");
		Veterinary veterinary = new Veterinary(sc.next());
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
			int input = sc.nextInt();
			
			System.out.println("Name of the patient:");
			String patientName = sc.next();
			
			switch(input)
			{
			case 1: // Find
				
				IAnimal patient = clinic.getAnimal(patientName);
				if (patient != null)
					System.out.println(patient.print());
				else
					System.out.println("Patient not found \n");
				break;

			case 2: // Add
				clinic.add(new Animal(patientName));
				System.out.println("Patient added \n");
				break;
			/*
			case 3: // Remove
				clinic.remove(new Animal(patientName));
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
