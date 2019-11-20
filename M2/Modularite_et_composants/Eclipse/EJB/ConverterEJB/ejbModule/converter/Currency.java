package converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Currency implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	protected List<String> countriesName;
	protected String fullName;
	protected String code;
	protected float rate;
	
	// Constructors
	public Currency()
	{
		this.countriesName = new ArrayList<>();
	}
	
	public Currency(List<String> countriesName, String fullName, String code, float rate)
	{
		this.countriesName = countriesName;
		this.fullName = fullName;
		this.code = code;
		this.rate = rate;
	}
	
	// Getters & setters
	public List<String> getCountriesName()
	{
		return this.countriesName;
	}
	
	public String getFullName()
	{
		return this.fullName;
	}
	
	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public float getRate()
	{
		return rate;
	}

	public void setRate(float rate)
	{
		this.rate = rate;
	}
	
	// Adds a country to the list
	public void addCountryName(String countryName)
	{
		this.countriesName.add(countryName);
	}
}
