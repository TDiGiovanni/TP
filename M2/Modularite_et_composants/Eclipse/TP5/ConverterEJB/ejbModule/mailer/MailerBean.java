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
    			TextMessage textMessage = (TextMessage) message; 
	            String content = textMessage.getText();
	            
	            // Recuperer le montant a convertir
	            String s = content.substring(0,content.indexOf("#"));
	            double amount = Double.parseDouble(s);
	            
	            // Demander au bean session de faire toutes les conversions
	            Map<Currency, Double> map = converter.euroToOtherCurrencies(amount);
	            Properties p = new Properties();
	            p.put("mail.smtp.host", "smtp.gmail.com");
	            p.put("mail.smtp.auth", "true");
	            p.put("mail.smtp.starttls.enable","true");
	            javax.mail.Session session = javax.mail.Session.getInstance(p);
	            javax.mail.Message msg = new MimeMessage(session);
	            try
	            {
	            	// Preparation du mail
	                msg.setFrom(new InternetAddress("<user>@gmail.com"));
	                String dest = content.substring(content.indexOf("#") + 1);
	                msg.setRecipient(javax.mail.Message.RecipientType.TO,
	                                 new InternetAddress(dest));
	                msg.setSubject("Currency converter");
	                
	                // Mettre en forme les resultats retournes par le bean session (Map)
	                // dans une chaine de caracteres contenant les balises HTML
	                // necessaires pour construire le tableau HTML (variable content)
	                // Voir la capture d'ecran de la Figure 1
	                msg.setContent(content, "text/html;charset=utf8");
	                msg.setSentDate(Calendar.getInstance().getTime()); 
	                
	                // Preparation de l'envoi du mail
	                Transport transport = session.getTransport("smtp");
	                transport.connect("smtp.gmail.com",587,"<user>","<mot-de-passe>");        
	                
	                // Envoi du mail
	                transport.sendMessage(msg, msg.getAllRecipients());
	                transport.close();
	                System.out.println("Email sent to " + dest);
	            }
	            catch(MessagingException e)
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
