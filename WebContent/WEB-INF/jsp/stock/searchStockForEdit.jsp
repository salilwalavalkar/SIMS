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
				<td>Enter Stock Symbol</td>
				<td><form:input path="symbol" id="symbol" type="text"
						maxlength="3" /></td>
			</tr>
			<tr>
				<td colspan="2" class="centerAlign"><input type="button"
					id="btnAdd" value="Search Stock"
					onclick="javascript:searchAndLoadStockDetails();" />
					<button type="button" name="back" onclick="goToHomePage();">Back</button>
			</tr>
			<tr>
			<td colspan="2" class="centerAlign">
				<c:if test="${stkFound ne null and stkFound eq 'NO'}">
					Stock not found. Please try again with different stock.
				</c:if>
			</td>
			</tr>
		</table>

	</form:form>
</body>
</html>