package com.tech.sims.model;

import com.tech.sims.model.base.IModel;

/**
 * StockModel Implementation
 * 
 * @author salil.
 * @version 1.0
 */
public class StockDetails implements IModel{

	/**
	 * @versionNo.
	 */
	private static final long serialVersionUID = -2220677033479208341L;
	/**
	 * symbol- symbol
	 */
	private String symbol;
	
	/**
	 * name- name
	 */
	private String name;
	
	/**
	 * companyName- companyName
	 */
	private String companyName; 

	/**
	 * description- description
	 */
	private String description;
	
	/**
	 * quantity- quantity
	 */
	private int quantity;
	
	/**
	 * currentMktPrice- 
	 *                   currentMktPrice
	 */
	private double currentMktPrice;

	/**
	 * 
	 * @return symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * 
	 * @param symbol
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 
	 * @param companyName
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * 
	 * @return -currentMktPrice
	 */
	public double getCurrentMktPrice() {
		return currentMktPrice;
	}

	/**
	 * 
	 * @param currentMktPrice
	 */
	public void setCurrentMktPrice(double currentMktPrice) {
		this.currentMktPrice = currentMktPrice;
	}
	
	
}
