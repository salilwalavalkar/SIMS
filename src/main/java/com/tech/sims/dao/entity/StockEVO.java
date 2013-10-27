package com.tech.sims.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tech.sims.dao.base.IEntityVo;

/**
 * Student Entity Value Object.
 * 
 * @author shailendra
 * @version 1.0
 */
@Entity
@Table(name = "STOCK")
public class StockEVO implements IEntityVo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4870168688201180340L;
	
    /**
      * SYMBOL 
     */
	@Id
	@Column(name = "SYMBOL", unique = true, nullable = false)
	private String symbol;
	
	/**
     * NAME 
     */
	@Column(name = "NAME")
	private String name;
	
	/**
     * COMPANYNAME 
     */
	@Column(name = "COMPANYNAME")
	private String companyName;

	/**
     * DESCRIPTION 
     */
	@Column(name = "DESCRIPTION")
	private String description;

	/**
     * QTY 
     */
	@Column(name = "QTY")
	private int quantity;

	/**
     * CURRENTMKTPRICE 
     */
	@Column(name = "CURRENTMKTPRICE")
	private double currentMktPrice;

	/**
     * @return - symbol
     */
	public String getSymbol() {
		return symbol;
	}

	/**
     * setter: set a symbol
     */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
     * @return - name
     */
	public String getName() {
		return name;
	}

	/**
     * setter: set a name
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
     * @return - companyName
     */
	public String getCompanyName() {
		return companyName;
	}

	/**
     * setter: set a companyName
     */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
     * @return - description
     */
	public String getDescription() {
		return description;
	}

	/**
     * setter: set a quantity
     */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
     * @return - quantity
     */
	public int getQuantity() {
		return quantity;
	}

	/**
     * setter: set a quantity
     */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
     * @return - currentMktPrice
     */
	public double getCurrentMktPrice() {
		return currentMktPrice;
	}

	/**
     * setter: set a currentMktPrice
     */
	public void setCurrentMktPrice(double currentMktPrice) {
		this.currentMktPrice = currentMktPrice;
	}


}
