package com.tech.sims.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tech.sims.dao.base.IEntityVo;

@Entity
@Table(name = "USER")
public class UserEVO implements IEntityVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2044755302132922974L;
	
	@Id
	@Column(name = "USERNAME", unique = true, nullable = false)
	private String username;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "ROLE")
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
