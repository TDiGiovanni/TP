<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*, javax.naming.*, javax.jms.*"
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Currency converter</title>
</head>

<body>
	<jsp:useBean class="converter.ConverterBean" id="converterBean"/>
	<form name="convert" action="index.jsp">
		<input type="text" name="email" placeholder="Enter your email address">
		<br/><br/>
		<input type="number" name="amount" placeholder="Enter the amount">
		<p>to</p>
		<select name="currency">
		<%
			for (converter.Currency currency : converterBean.getAvailableCurrencies())
			{
				out.println("<option value=" + currency.getCode() + ">" + currency.getFullName() + "</option>");
			}
		%>
		</select>
		<br/><br/>
		<input type="submit" value="Convert">
	</form>	
	<%
		String parameter = request.getParameter("amount");
		if (parameter != null)
		{			
			double amount = Double.parseDouble(request.getParameter("amount"));
			
			String currency = request.getParameter("currency");
			if (currency != null)
			{
				double newAmount = converterBean.euroToOtherCurrency(amount, currency);
				out.println("<p>" + amount + " EUR is equivalent to " + newAmount + " " + currency + ".</p>");
			}
			
			String email = request .getParameter("email");
			if (email != null && email.length() != 0)
			{
				// Envoi de message dans la file
				Context jndiContext = new InitialContext();
				javax.jms.ConnectionFactory  connectionFactory = (QueueConnectionFactory) jndiContext.lookup("/ConnectionFactory");
				Connection connection = connectionFactory.createConnection();
				Session sessionQ = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				TextMessage message = sessionQ.createTextMessage();
				message.setText (amount + "#" + email);
				javax.jms.Queue queue = (javax.jms.Queue) jndiContext.lookup ("queue/MailContent");
				MessageProducer messageProducer = sessionQ.createProducer(queue);
				messageProducer.send(message);
			}
		}
	%>
</body>
</html>