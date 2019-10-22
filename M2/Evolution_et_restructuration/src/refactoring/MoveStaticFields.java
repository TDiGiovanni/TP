package refactoring;

// Auteur : Thomas Di Giovanni
public class MoveStaticFields
{
	public static void main(String[] args)
	{
		System.out.println("Horror movie example: " + Cinema.HORROR_EXAMPLE);
		System.out.println("Comedy movie example: " + Cinema.COMEDY_EXAMPLE);
	}
}

// Il faut déplacer les champs statiques "COMEDY_EXAMPLE" et "HORROR_EXAMPLE" dans la classe "Movie"
class Cinema
{
	public static String HORROR_EXAMPLE = "It";
	public static String COMEDY_EXAMPLE = "Hot Fuzz";
	
	private String name;
	private String address;
	
	public String getName()
	{
		return name;
	}
	
	public String getAddress()
	{
		return address;
	}
}
