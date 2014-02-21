package com.tech.sims.model;

import com.tech.sims.model.base.IModel;

public class UserCredentials implements IModel {

	/**
	 * Unique serial version ID.
	 */
	private static final long serialVersionUID = -4257887344929655861L;

	private String username;
	
	private String password;
	
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
