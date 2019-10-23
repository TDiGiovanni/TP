package converter;

import java.util.Scanner;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConverterApp
{
	public static void main(String[] args) throws NamingException
	{
		// Lookup the converter
		IConverter converter = (IConverter) InitialContext.doLookup("ejb:Converter/ConverterEJB/ConverterBean!converter.IConverter");
		
		// Get the user input
		Scanner scanner = new Scanner(System.in);
		double amount = 0;
		String currency = "";
		
		do
		{
		System.out.println("Enter the desired amount to convert:");
		amount = scanner.nextDouble();
		
		System.out.println("Enter the desired currency (or quit to close the app):");
		currency = scanner.next();
		
		// Then convert
		System.out.println(converter.euroToOtherCurrency(amount, currency));
		}
		while (!currency.equals("quit"));
		
		scanner.close();
	}
}
