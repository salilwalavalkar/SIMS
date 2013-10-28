package com.tech.sims.form.stock;

import com.tech.sims.web.form.IForm;

/**
 * StockForm Implementation
 * 
 * @author salil.
 * @version 1.0
 */
public class StockForm implements IForm {

	/**
	 * @version
	 */
	private static final long serialVersionUID = -9021717831422394480L;

	/**
	 * symbol - symbol
	 */
	private String symbol;

	/**
	 * name - name
	 */
	private String name;

	/**
	 * companyName - companyName
	 */
	private String companyName;

	/**
	 * description - description
	 */
	private String description;

	/**
	 * quantity - quantity
	 */
	private String quantity;

	/**
	 * currentMktPrice - currentMktPrice
	 */
	private String currentMktPrice;

	/**
	 * currentMktPriceMin - currentMktPriceMin
	 */
	private String currentMktPriceMin;

	/**
	 * currentMktPriceMax - currentMktPriceMax
	 */
	private String currentMktPriceMax;

	/**
	 * actionPerformed - actionPerformed
	 */
	private String actionPerformed;

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol
	 *            the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName
	 *            the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the currentMktPrice
	 */
	public String getCurrentMktPrice() {
		return currentMktPrice;
	}

	/**
	 * @param currentMktPrice
	 *            the currentMktPrice to set
	 */
	public void setCurrentMktPrice(String currentMktPrice) {
		this.currentMktPrice = currentMktPrice;
	}

	/**
	 * @return the currentMktPriceMin
	 */
	public String getCurrentMktPriceMin() {
		return currentMktPriceMin;
	}

	/**
	 * @param currentMktPriceMin
	 *            the currentMktPriceMin to set
	 */
	public void setCurrentMktPriceMin(String currentMktPriceMin) {
		this.currentMktPriceMin = currentMktPriceMin;
	}

	/**
	 * @return the currentMktPriceMax
	 */
	public String getCurrentMktPriceMax() {
		return currentMktPriceMax;
	}

	/**
	 * @param currentMktPriceMax
	 *            the currentMktPriceMax to set
	 */
	public void setCurrentMktPriceMax(String currentMktPriceMax) {
		this.currentMktPriceMax = currentMktPriceMax;
	}

	/**
	 * @return the actionPerformed
	 */
	public String getActionPerformed() {
		return actionPerformed;
	}

	/**
	 * @param actionPerformed
	 *            the actionPerformed to set
	 */
	public void setActionPerformed(String actionPerformed) {
		this.actionPerformed = actionPerformed;
	}

}
