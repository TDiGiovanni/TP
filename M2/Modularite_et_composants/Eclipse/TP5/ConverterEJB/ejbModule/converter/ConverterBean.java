package converter;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.net.ssl.HttpsURLConnection;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

/**
 * Session Bean implementation class ConverterBean
 */
@Remote
@Stateful
public class ConverterBean implements IConverter
{
	List<Currency> currencies;
	
    /**
     * Default constructor. 
     */
    public ConverterBean()
    {
        this.currencies = getAvailableCurrencies();
    }
    
	@Override
	public List<Currency> getAvailableCurrencies()
	{
		List<Currency> result = new ArrayList<>();
		
		SAXBuilder builder = new SAXBuilder();
		Document documentEuropa, documentIso;
		
		try
		{
			// Open the first document
			URL url = new URL( "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
			HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
			documentEuropa = builder.build(connection.getInputStream());
			
			// Open the second document
			url = new URL( "https://www.currency-iso.org/dam/downloads/lists/list_one.xml");
			connection = (HttpsURLConnection)url.openConnection();
			documentIso = builder.build(connection.getInputStream());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return result;
		}

		// Navigate the first document
		Namespace namespace = Namespace.getNamespace("http://www.ecb.int/vocabulary/2002-08-01/eurofxref");
		Element root = documentEuropa.getRootElement();
		Element cube = root.getChild("Cube", namespace);
		Element cube2 = cube.getChild("Cube", namespace);
		List<Element> documentCurrencies = cube2.getChildren();
		
		for (Element currency : documentCurrencies)
		{
			Currency newCurrency = new Currency();
			
			String currencyCode = currency.getAttributeValue("currency");
			newCurrency.setCode(currencyCode);
			
			float currencyRate = Float.parseFloat(currency.getAttributeValue("rate"));
			newCurrency.setRate(currencyRate);
			
			result.add(newCurrency);
		}
		
		// Navigate the second document
		root = documentIso.getRootElement();
		Element ccyTbl = root.getChild("CcyTbl");
		documentCurrencies = ccyTbl.getChildren();

		for (Element currency : documentCurrencies)
		{
			for (Currency resultCurrency : result)
			{
				if (resultCurrency.getCode().equals(currency.getChildText("Ccy")))
				{
					resultCurrency.addCountryName(currency.getChildText("CtryNm"));
					resultCurrency.setFullName(currency.getChildText("CcyNm"));
				}
			}
		}
		
		return result;
	}

	@Override
	public double euroToOtherCurrency(double amount, String currencyCode)
	{		
		for (Currency currency : currencies)
		{
			if (currency.getCode().equals(currencyCode))
			{
				return amount * currency.getRate();
			}
		}
		
		return 0;
	}
	
	@Override
	public Map<Currency, Double> euroToOtherCurrencies(double amount)
	{
		Map<Currency, Double> result = new HashMap<>();
		
		for (Currency currency : currencies)
		{
			result.put(currency, amount * currency.getRate());
		}
		
		return result;
	}
}
