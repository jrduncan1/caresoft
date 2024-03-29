package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	private Integer employeeID;
	private String role;
	private ArrayList<String> securityIncidents = new ArrayList<String>();

	// Constructor
	public AdminUser(Integer employeeID, String role) {
		super(employeeID);
		setRole(role);
	}
	
	// Code provided
	public void newIncident(String notes) {
	    String report = String.format(
	        "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
	        new Date(), this.id, notes
	    );
	    securityIncidents.add(report);
	}
	public void authIncident() {
	    String report = String.format(
	        "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
	        new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
	    );
	    securityIncidents.add(report);
	}
	
	// Implemented Methods

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		return securityIncidents;
	}

	@Override
	public boolean assignPin(int pin) {
		if(String.valueOf(pin).length() >= 6) {
			setPin(pin);
			return true;
		}
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID == this.id) {
			return true;
		}
		authIncident();
		return false;
	}
	
	// Getters & Setters

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	
	
}


