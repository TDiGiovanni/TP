package mailer;

import java.util.Calendar;
import java.util.Map;
import java.util.Properties;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import converter.Currency;
import converter.IConverter;

/**
 * Message-Driven Bean implementation class for: Mailer
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "queue/MailContent"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "queue/MailContent")
public class MailerBean implements MessageListener
{
	@EJB
	IConverter converter;
	
    /**
     * Default constructor. 
     */
    public MailerBean()
    {
        
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message)
    {
    	try
    	{
    		if (message instanceof TextMessage)
    		{
	            String messageContent = ((TextMessage) message).getText();
	            
	            // Getting the amount to convert
	            String s = messageContent.substring(0, messageContent.indexOf("#"));
	            double amount = Double.parseDouble(s);
	            
	            // Mail service properties
	            String hotmailHost = "smtp-mail.outlook.com";
	            String senderAddress = "digio.thomas@hotmail.fr";
	            Properties p = new Properties();
	            p.put("mail.smtp.host", hotmailHost);
	            p.put("mail.smtp.auth", "true");
	            p.put("mail.smtp.starttls.enable","true");
	            javax.mail.Session session = javax.mail.Session.getInstance(p);
	            javax.mail.Message mail = new MimeMessage(session);
	            try
	            {
	                Transport transport = session.getTransport("smtp");
	                transport.connect(hotmailHost, 587, senderAddress, "1233petitschats");
	                mail.setFrom(new InternetAddress(senderAddress));
	                
	            	// Mail destination
	                String destinationAddress = messageContent.substring(messageContent.indexOf("#") + 1);
	                mail.setRecipient(javax.mail.Message.RecipientType.TO,
	                                 new InternetAddress(destinationAddress));
	                
	                // Mail content
	                mail.setSubject("Currency converter");
	                
		            Map<Currency, Double> currencies = converter.euroToOtherCurrencies(amount);
		            
		            String mailContent = "<table><thead><tr><th colspan=\"2\">Currency conversions for " + amount + "€</th></tr></thead><tbody>";
		            
		            for (Currency currency : currencies.keySet())
		            	mailContent += "<tr><td>" + currencies.get(currency) + "</td><td>" + currency.getFullName() + " (" + currency.getCode() + ")</td></tr>";
		            
		            mailContent += "</tbody></table>";
	                
	                mail.setContent(mailContent, "text/html;charset=utf8");
	                
	                // Sending mail
	                mail.setSentDate(Calendar.getInstance().getTime()); 
	                transport.sendMessage(mail, mail.getAllRecipients());
	                transport.close();
	                System.out.println("Email sent to " + destinationAddress);
	            }
	            catch (MessagingException e)
	            {
	            	e.printStackTrace();
	            }
	        }
    	}
    	catch (JMSException e)
    	{
    		e.printStackTrace();
    	}
    }
}
