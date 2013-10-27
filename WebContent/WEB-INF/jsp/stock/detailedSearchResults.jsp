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
		<table border="1">
			<tr>
				<th>Symbol</th>
				<th>Name</th>
				<th>Company Name</th>
				<th>Description</th>
				<th>Qty</th>
				<th>Current Market Price</th>
			</tr>
			<c:if test="${fn:length(stockDetailsList) eq 0}">
				<tr>
					<td align="center" colspan="6"><span style="color: red;">No Records
							Found</span></td>
				</tr>
			</c:if>
			<c:if test="${fn:length(stockDetailsList) gt 0}">
				<c:forEach items="${stockDetailsList}" var="stockItem"
					varStatus="stockItemStatus">
					<tr>
						<td>${stockItem.symbol}</td>
						<td>${stockItem.name}</td>
						<td>${stockItem.companyName}</td>
						<td>${stockItem.description}</td>
						<td>${stockItem.quantity}</td>
						<td>${stockItem.currentMktPrice}</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</form:form>
	<button type="button" name="back" onclick="goToHomePage();">Back</button>
</body>
</html>