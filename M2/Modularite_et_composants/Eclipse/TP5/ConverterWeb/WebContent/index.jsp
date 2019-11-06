<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*"
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
		<input type="submit" value="Convert to all currencies">
	</form>	
	<%
		String anyParameter = request.getParameter("amount");
		if (anyParameter != null)
		{
			String email = request .getParameter("email");
			if (email != null && email.length() != 0)
			{
				// Demander...
			}
			
			double amount = Double.parseDouble(request.getParameter("amount"));
			String currency = request.getParameter("currency");
			double newAmount = converterBean.euroToOtherCurrency(amount, currency);
			out.println("<p>" + amount + " EUR is equivalent to " + newAmount + " " + currency + ".</p>");
		}
	%>
</body>
</html>