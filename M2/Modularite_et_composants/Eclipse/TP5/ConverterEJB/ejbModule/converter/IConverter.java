package converter;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

@Remote
public interface IConverter
{
	public List<Currency> getAvailableCurrencies();
	
	public double euroToOtherCurrency(double amount, String currencyCode);
	public Map<Currency, Double> euroToOtherCurrencies(double amount);
}
