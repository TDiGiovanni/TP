package converter;


import java.util.Properties;
import java.util.Scanner;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class ConverterApp {
    public static void main(String[] args) throws NamingException {
        // Set up the context
        Properties properties = new Properties();
        properties.put("java.naming.factory.initial", "org.wildfly.naming.client.WildFlyInitialContextFactory");
        properties.put("java.naming.provider.url", "http-remoting:localhost:8080");
        InitialContext context = new InitialContext(properties);
        // Lookup the converter
        IConverter converter = ((IConverter) (context.lookup("ejb:Converter/ConverterEJB/ConverterBean!converter.IConverter?stateful")));
        // Get the user input
        Scanner scanner = new Scanner(System.in);
        double amount = 0;
        String currency = "";
        String restart = "";
        do {
            System.out.println("Enter the desired amount to convert:");
            amount = scanner.nextDouble();
            System.out.println("Enter the desired currency (or quit to close the app):");
            currency = scanner.next();
            System.out.println(converter.euroToOtherCurrency(amount, currency));
            System.out.println("Restart? (y/n)");
            restart = scanner.next();
        } while (restart.equals("y") );
        scanner.close();
    }
}

