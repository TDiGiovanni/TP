package converter;

import java.net.URL;
import java.util.List;

import javax.ejb.Stateless;
import javax.net.ssl.HttpsURLConnection;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

/**
 * Session Bean implementation class ConverterBean
 */
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
		
		Element root = document.getRootElement();
		Namespace namespace = Namespace.getNamespace("http://www.ecb.int/vocabulary/2002-08-01/eurofxref");
		Element cube = root.getChild("Cube", namespace);
		Element cube2 = cube.getChild("Cube", namespace);
		List<Element> values = cube2.getChildren("Cube", namespace);
		
		for (Element value : values)
		{
			String currencyValue = value.getAttribute("currency", namespace).toString();
			
			if (currencyValue.equals(currencyCode))
				return amount * Integer.parseInt(currencyValue);
		}
		
		return 0;
	}

}
