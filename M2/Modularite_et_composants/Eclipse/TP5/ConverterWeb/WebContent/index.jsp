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
	<%
		if (request.getParameter("amount") == null)
		{
	%>
	<form name="convert" action="index.jsp">
		<input type="number" name="amount" placeholder="Enter your amount">
		<input type="text" name="currency" placeholder="Enter the currency code">
		<input type="submit" value="Convert">
	</form>	
	<%
		}
		else
		{
			double amount = Double.parseDouble(request.getParameter("amount"));
			String currency = request.getParameter("currency");
			amount = converterBean.euroToOtherCurrency(amount, currency);
			out.println("<h4>The converted amount is: " + amount + "</h4>");
		}
	%>
</body>
</html>