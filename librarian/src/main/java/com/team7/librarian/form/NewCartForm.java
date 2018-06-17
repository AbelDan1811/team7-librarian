package com.team7.librarian.form;

import java.util.List;

import org.yaml.snakeyaml.emitter.Emitable;

public class NewCartForm {
	
	private String email;
	
	private String contactNumber;
	
	private String fullName;
	
	private String organization; 
	
	private List<String> pickup;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public List<String> getPickup() {
		return pickup;
	}

	public void setPickup(List<String> pickup) {
		this.pickup = pickup;
	}

	public String toString() {
		return email+ contactNumber + fullName + organization + pickup.toString();
	}
	
}
