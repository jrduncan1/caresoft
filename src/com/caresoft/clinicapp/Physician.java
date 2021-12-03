package com.caresoft.clinicapp;

import java.util.*;

public class Physician extends User implements HIPAACompliantUser {

	private ArrayList<String> patientNotes;
	
	// Constructor
	public Physician(Integer id) {
		super(id);
	}
	
	// Code provided
	public void newPatientNotes(String notes, String patientName, Date date) {
	    String report = String.format(
	        "Datetime Submitted: %s \n", date);
	    report += String.format("Reported By ID: %s\n", this.id);
	    report += String.format("Patient Name: %s\n", patientName);
	    report += String.format("Notes: %s \n", notes);
	    this.patientNotes.add(report);
	}
	
	// Implemented methods
	@Override
	public boolean assignPin(int pin) {
		if(String.valueOf(pin).length() == 4) {
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
		return false;
	}
	
	// Getters & Setters
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}
	
	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
}

