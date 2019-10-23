package converter;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ConverterBean
 */
@Remote
@Stateless
public class ConverterBean implements IConverter
{
    /**
     * Default constructor. 
     */
    public ConverterBean()
    {
        
    }

	@Override
	public double euroToOtherCurrency(double amount, String currencyCode)
	{
		return amount * 2;
		/*
		SAXBuilder builder = new SAXBuilder();
		Document document;
		
		try
		{
			URL url = new URL( "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
			HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
			document = builder.build(connection.getInputStream());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return 0;
		}

		Namespace namespace = Namespace.getNamespace("http://www.ecb.int/vocabulary/2002-08-01/eurofxref");
		Element root = document.getRootElement();
		Element cube = root.getChild("Cube", namespace);
		Element cube2 = cube.getChild("Cube", namespace);
		List<Element> currencies = cube2.getChildren();
		
		for (Element currency : currencies)
		{
			String currencyName = currency.getAttributeValue("currency", namespace);
			if (currencyName.equals(currencyCode))
			{
				double currencyRate = Double.parseDouble(currency.getAttributeValue("rate", namespace));
				return amount * currencyRate;
			}
		}
		
		return 0;
		*/
	}

}
