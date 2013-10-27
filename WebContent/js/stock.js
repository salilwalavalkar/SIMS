/* Trim function - Start */
String.prototype.trim = function() {
	return this.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
};
/* Trim function - End */

function validateStockDetails() {
	if (chkIfValueIsNull("symbol")) {
		alert("Stock Symbol is mandatory");
		return false;
	}
	if (isNumber(document.getElementById('symbol').value)) {
		alert("Symbol cannot be numeric");
		return false;
	}	
	if (chkIfValueIsNull("name")) {
		alert("Stock name is mandatory");
		return false;
	}
	if (chkIfValueIsNull("companyName")) {
		alert("Company Name is mandatory");
		return false;
	}
	if (chkIfValueIsNull("description")) {
		alert("Company Description is mandatory");
		return false;
	}
	if (chkIfValueIsNull("quantity")) {
		alert("Quantity is mandatory");
		return false;
	}
	if (!isNumber(document.getElementById('quantity').value)) {
		alert("Quantity should be numeric");
		return false;
	}	
	if (chkIfValueIsNull("currentMktPrice")) {
		alert("Current Market Price is mandatory");
		return false;
	}
	if (!isNumber(document.getElementById('currentMktPrice').value)) {
		alert("Market price should be numeric");
		return false;
	}	
	return true;
}

function chkIfValueIsNull(id) {
	if (document.getElementById(id).value.trim() == '') {
		return true;
	}
	return false;
}

function isNumber(n) {
	return !isNaN(parseFloat(n)) && isFinite(n);
}

function submitForm(formId, actionURL, method) {
	var formElement = document.getElementById(formId);
	formElement.action = actionURL;
	formElement.method = method;
	formElement.submit();
}

function goToHomePage()
{
	submitForm("stockformId", "../stock/homePage", "GET");
}

function showAddStockScreen() {
	submitForm("stockformId", "../stock/showAddStockDetails", "POST");
}

function addStockDetails() {
	if (validateStockDetails()) {
		submitForm("stockformId", "../stock/addStockDetails", "POST");
	}
}

function searchStockForEdit() {
	submitForm("stockformId", "../stock/searchStockForEdit", "POST");
}

function searchAndLoadStockDetails()
{
	if (chkIfValueIsNull("symbol")) {
		alert("Stock Symbol is mandatory");
		return false;
	}
	if (isNumber(document.getElementById('symbol').value)) {
		alert("Symbol cannot be numeric");
		return false;
	}	
	submitForm("stockformId", "../stock/searchAndLoadStockDetails", "POST");	
}

function saveStockDetails() {
	if (validateStockDetails()) {
		var validate = confirm("Are you sure you want to save data ?");
		if (validate == true) {
			submitForm("stockformId", "../stock/saveStockDetails", "POST");
		} else {
			alert("Save was discarded.");
		}
	}
}

function detailedSearchCriteria() {
	submitForm("stockformId", "../stock/detailedSearchCriteria", "POST");
}

function detailedSearchResults() {
	if (validateForDetailedSearch()) 
	{
		submitForm("stockformId", "../stock/detailedSearchResults", "POST");
	}
}

function validateForDetailedSearch()
{
	
	if (chkIfValueIsNull("symbol") && chkIfValueIsNull("name") && chkIfValueIsNull("currentMktPriceMin") && chkIfValueIsNull("currentMktPriceMax")) {
		alert("Please enter atleast one search criteria");
		return false;
	}
	if (isNumber(document.getElementById('symbol').value)) {
		alert("Symbol cannot be numeric");
		return false;
	}	
	
	if(!chkIfValueIsNull("currentMktPriceMin"))
	{
		if(!isNumber(document.getElementById('currentMktPriceMin').value))
		{
			alert("Market price must be numeric");
			return false;
		}
	}
	if(!chkIfValueIsNull("currentMktPriceMax"))
	{
		if(!isNumber(document.getElementById('currentMktPriceMax').value))
		{
			alert("Market price must be numeric");
			return false;
		}
	}
	return true;
}