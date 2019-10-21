package refactoring;

// Auteur : Thomas Di Giovanni
public class ExtractClass
{
	public static void main(String[] args)
	{
		Computer Y540 = new Computer("Lenovo", "China", 1, 1);
		System.out.println(Y540.toString());
	}
}

// Il faut extraire la classe "Manufacturer", qui contient les attributs "manufacturerName" et "manufacturerCountry"
class Computer
{
	private String manufacturerName;
	private String manufacturerCountry;
	private double screenSize;
	private double weight;
	
	public Computer(String manufacturerName, String manufacturerCountry, double screenSize, double weight)
	{
		this.manufacturerName = manufacturerName;
		this.manufacturerCountry = manufacturerCountry;
		this.screenSize = screenSize;
		this.weight = weight;
	}
	
	public String getManufacturerName()
	{
		return manufacturerName;
	}
	
	public String getManufacturerCountry()
	{
		return manufacturerCountry;
	}
	
	public double getScreenSize()
	{
		return screenSize;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	@Override
	public String toString()
	{
		String result = "Computer";
		
		result += " made by " + this.getManufacturerName()
		+ " from " + this.getManufacturerCountry()
		+ ", its screen size is " + this.getScreenSize()
		+ ", its weight is " + this.getWeight();
		
		return result;
	}
}