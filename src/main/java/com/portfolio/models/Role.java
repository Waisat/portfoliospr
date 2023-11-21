package com.portfolio.models;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;



@Embeddable
public class Role {
	
	
	@Column(nullable = false)
	protected String role;
	public Role() {
		
	}
	public Role(String intitule) {
		super();
		this.role = intitule;
	}
	
	public String getIntitule() {
		return role;
	}
	public void setIntitule(String intitule) {
		this.role = intitule;
	}
	@Override
	public String toString() {
		return "Role [intitule=" + role + "]";
	}
	
	
}
