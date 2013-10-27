<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Stock Information Management System</title>

<script src="${pageContext.request.contextPath}/js/stock.js"
	type="text/javascript"></script>

</head>
<body>
	<form:form id="stockformId" modelAttribute="stockForm">
		<table>
			<tr>
				<td>Enter Stock Symbol:</td>
				<td><form:input path="symbol" id="symbol" type="text"
						maxlength="3" /></td>
			</tr>
			<tr>
				<td>Enter Stock Name:</td>
				<td><form:input path="name" id="name" type="text" maxlength="20" /></td>
			</tr>
			<tr>
				<td>Market Price Between:</td>
				<td><form:input path="currentMktPriceMin" id="currentMktPriceMin" type="text" size="5"/> -  
				<form:input path="currentMktPriceMax" id="currentMktPriceMax" type="text" size="5"/></td>
			</tr>			
			<tr>
				<td colspan="2" class="centerAlign"><input type="button"
					id="btnAdd" value="Search Stock"
					onclick="javascript:detailedSearchResults();" />
					<button type="button" name="back" onclick="goToHomePage();">Back</button>
			</tr>
		</table>

	</form:form>
</body>
</html>