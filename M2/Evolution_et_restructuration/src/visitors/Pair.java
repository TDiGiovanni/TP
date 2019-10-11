package visitors;

public class Pair
{
	protected String first;
	protected String second;
	protected int value;
	
	public Pair(String newFirst, String newSecond, int newValue)
	{
		this.first = newFirst;
		this.second = newSecond;
		this.value = newValue;
	}
	
	public Pair(String newFirst, String newSecond)
	{
		this.first = newFirst;
		this.second = newSecond;
		this.value = 0;
	}
	
	public String getFirst()
	{
		return this.first;
	}

	public String getSecond()
	{
		return this.second;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	public void increment()
	{
		this.value++;
	}
}
