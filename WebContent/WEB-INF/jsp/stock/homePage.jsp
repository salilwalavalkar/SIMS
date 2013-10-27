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
	<form:form id="stockformId" modelAttribute="stockform">
		<table>
			<tr>
				<td colspan="100" class="centerAlign"> STOCK INFORMATION MANAGEMENT SYSTEM</TD>
			</tr>
              <tr>
              <td>
              
              </td>
              </tr>
			<tr>
				<td colspan="100" class="centerAlign"><input type="button"
					id="btnAdd" value="Add Stock"
					onclick="javascript:showAddStockScreen();" />&nbsp;&nbsp;<input
					type="button" id="btnAdd" value="Edit Stock"
					onclick="searchStockForEdit();" />&nbsp;&nbsp;<input
					type="button" id="btnAdd" value="Detailed Search Stock"
					onclick="javascript:detailedSearchCriteria();" />
			</tr>
		</table>
	</form:form>
</body>
</html>