package veterinaire;

import java.rmi.RemoteException;

public class Animal implements IAnimal
{
	protected String nom;
	protected String nomMaitre;
	protected Espece espece;
	protected String race;
	protected Dossier dossierSuivi;
	
	public Animal() throws RemoteException {}
	
	public Animal(String nom, String nomMaitre, Espece espece, String race) throws RemoteException
	{
		this.nom = nom;
		this.nomMaitre = nomMaitre;
		this.espece = espece;
		this.race = race;
	}
	
	public Espece getEspece() throws RemoteException
	{
		return this.espece;
	}
	
	public Dossier getDossierSuivi() throws RemoteException
	{
		return this.dossierSuivi;
	}
	
	public void setDossierSuivi(Dossier dossierSuivi) throws RemoteException
	{
		this.dossierSuivi = dossierSuivi;
	}
	
	public String print() throws RemoteException
	{
		return "Nom : " + nom
				+ "\nNom du maître : " + nomMaitre
				+ "\nEspèce : " + espece.name
				+ "\nRace : " + race
				+ "\nDossier de suivi : " + dossierSuivi.suivi;
	}
}
