<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit Stock Details</title>
<script src="${pageContext.request.contextPath}/js/stock.js"
	type="text/javascript"></script>

</head>
<body>
	<form:form id="stockformId" modelAttribute="stockForm">
		<table>
			<tr>
				<td>Stock Symbol</td>
				<td><form:input path="symbol" type="hidden"/>${stockDetails.symbol}</td>
			</tr>
			<tr>
				<td>Stock Name</td>
				<td><form:input path="name" id="name" type="text" maxlength="20" value="${stockDetails.name}"/></td>
			</tr>
			<tr>
				<td>Company Name</td>
				<td><form:input path="companyName" id="companyName" type="text" value="${stockDetails.companyName}"/></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><form:input path="description" id="description" type="text" value="${stockDetails.description}"/></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><form:input path="quantity" id="quantity" type="text" value="${stockDetails.quantity}"/></td>
			</tr>
			<tr>
				<td>Current Market Price</td>
				<td><form:input path="currentMktPrice" id="currentMktPrice" type="text" value="${stockDetails.currentMktPrice}"/></td>
			</tr>
			<tr>
				<td colspan="2" class="centerAlign"><input type="button"
					id="btnAdd" value="Save Stock" onclick="javascript:saveStockDetails();">
					<button type="button" name="back" onclick="goToHomePage();">Back</button>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>